import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

// Think of this interface as a contract or a promise.
// Any class that wants to be a logger *must* provide a 'log' method.
// This makes our system flexible – we could later create a FileLogger or a DatabaseLogger
// without changing the ATM class at all.
interface TransactionLogger {
    void log(String message);
}

// Using an enum is a safe and clean way to represent a fixed set of values.
// This prevents typos (e.g., "WIDRAWAL") that could happen if we used simple strings.
enum TransactionType {
    DEPOSIT, WITHDRAWAL, FAILED
}

// This class is a "POJO" (Plain Old Java Object). Its main job is to hold data.
// We've made its fields 'final' so that once a transaction is created, it cannot be changed.
// It's like a permanent record.
class Transaction {
    // We use AtomicLong to make sure every transaction gets a unique ID,
    // even if many transactions were happening at the exact same time in a bigger application.
    private static final AtomicLong idGenerator = new AtomicLong(10001);

    private final long transactionId;
    private final LocalDateTime date;
    private final double amount;
    private final TransactionType type;
    private final double balanceAfter;

    // The constructor captures a "snapshot" of the transaction the moment it happens.
    public Transaction(TransactionType type, double amount, double balanceAfter) {
        this.transactionId = idGenerator.getAndIncrement();
        this.date = LocalDateTime.now();
        this.type = type;
        this.amount = amount;
        this.balanceAfter = balanceAfter;
    }

    // This method is just for presentation. It formats the transaction details
    // into a neat, single line, perfect for printing on a bank statement.
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return String.format("  ID: %d | %s | %-10s | Amount: %8.2f | Balance: %8.2f",
                transactionId, date.format(formatter), type, amount, balanceAfter);
    }
}


// This is the blueprint for any bank account. It contains all the features and data
// that *every* type of account will have in common.
class Account {
    // 'protected' means this class and its "children" (like SavingsAccount) can access these variables directly.
    // It's a way of sharing information within the family of Account classes.
    protected final String accountNumber;
    protected final String holderName;
    protected double balance;
    protected final List<Transaction> transactionHistory;

    public Account(String accountNumber, String holderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            // Every time something happens, we record it.
            transactionHistory.add(new Transaction(TransactionType.DEPOSIT, amount, balance));
            System.out.println("Deposit successful. New balance: $" + String.format("%.2f", balance));
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // This is the standard, default withdrawal logic.
    // We'll see later how subclasses can provide their own special versions of this method.
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
        } else if (balance >= amount) {
            balance -= amount;
            transactionHistory.add(new Transaction(TransactionType.WITHDRAWAL, amount, balance));
            System.out.println("Withdrawal successful. New balance: $" + String.format("%.2f", balance));
        } else {
            transactionHistory.add(new Transaction(TransactionType.FAILED, amount, balance));
            System.out.println("Withdrawal failed. Insufficient funds.");
        }
    }

    // A helper method to neatly display the account's entire history.
    public void printStatement() {
        System.out.println("\n--- Account Statement for " + holderName + " (" + accountNumber + ") ---");
        System.out.println("Current Balance: $" + String.format("%.2f", balance));
        System.out.println("Transaction History:");
        if (transactionHistory.isEmpty()) {
            System.out.println("  No transactions found.");
        } else {
            for (Transaction t : transactionHistory) {
                System.out.println(t);
            }
        }
        System.out.println("--- End of Statement ---");
    }
}


// By writing "extends Account", we're saying a SavingsAccount IS-A type of Account.
// It automatically gets all the properties and methods of the Account class for free. This is Inheritance.
class SavingsAccount extends Account {
    // This is a special rule that *only* applies to Savings Accounts.
    private static final double MINIMUM_BALANCE = 500.00;

    public SavingsAccount(String accountNumber, String holderName, double initialBalance) {
        super(accountNumber, holderName, initialBalance);
    }

    // Here, we are overriding the default withdraw behavior with a new, stricter rule for savings accounts.
    // This is Polymorphism in action - the same action (withdraw) behaves differently for different objects.
    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }
        
        // This is our special rule: first, check if the withdrawal would break the minimum balance requirement.
        if ((balance - amount) >= MINIMUM_BALANCE) {
            // If the rule is not broken, we let the original 'withdraw' method from the Account class do the work.
            super.withdraw(amount);
        } else {
            // If the rule is broken, we record the failure and inform the user.
            transactionHistory.add(new Transaction(TransactionType.FAILED, amount, balance));
            System.out.println("Withdrawal failed. Must maintain a minimum balance of $" + String.format("%.2f", MINIMUM_BALANCE));
        }
    }
}


// A CurrentAccount is another special type of Account, with its own unique rules.
class CurrentAccount extends Account {
    // The special rule for a Current Account is that it can go into a negative balance, up to a certain limit.
    private final double overdraftLimit;

    public CurrentAccount(String accountNumber, String holderName, double initialBalance, double overdraftLimit) {
        super(accountNumber, holderName, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }

    // We override the withdraw method again, but this time with different logic for the overdraft feature.
    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }

        // The check is different here: is the resulting balance still within our allowed overdraft?
        if ((balance - amount) >= -overdraftLimit) {
            super.withdraw(amount); // If so, proceed with the normal withdrawal process.
        } else {
            transactionHistory.add(new Transaction(TransactionType.FAILED, amount, balance));
            System.out.println("Withdrawal failed. Exceeds overdraft limit of $" + String.format("%.2f", overdraftLimit));
        }
    }
}


// An abstract class is like an incomplete template. It defines the "what" but not the "how".
// We are saying "any real, working ATM MUST have these features (withdraw, deposit)"...
// ...but we are not defining *how* they work yet. That's up to the concrete classes that extend this one.
abstract class ATM {
    protected final String machineId;
    protected final String location;

    public ATM(String machineId, String location) {
        this.machineId = machineId;
        this.location = location;
    }

    public abstract void withdraw(Account account, double amount);
    public abstract void deposit(Account account, double amount);
}

// This is a "concrete" class – a real, working implementation of our ATM template.
// It fulfills two contracts: it IS-A-KIND-OF ATM, and it IS-A TransactionLogger.
class BankATM extends ATM implements TransactionLogger {
    
    public BankATM(String machineId, String location) {
        super(machineId, location);
    }

    // Here we provide the actual "how" for the withdraw method.
    // The ATM's job is to log the attempt and then tell the account to handle the actual logic.
    @Override
    public void withdraw(Account account, double amount) {
        log("Attempting withdrawal of $" + String.format("%.2f", amount) + " for account " + account.accountNumber);
        account.withdraw(amount);
    }
    
    // Same for deposit. The ATM machine orchestrates the action.
    @Override
    public void deposit(Account account, double amount) {
        log("Attempting deposit of $" + String.format("%.2f", amount) + " for account " + account.accountNumber);
        account.deposit(amount);
    }

    // This is the implementation of the 'log' method promised by the TransactionLogger interface.
    @Override
    public void log(String message) {
        System.out.println("[ATM LOG @" + this.location + "]: " + message);
    }
}


// This is our main program where we'll simulate the ATM system in action.
// We'll create our objects and make them interact to tell a story.
public class ATMManagementSystem {
    public static void main(String[] args) {
        
        // --- SETUP ---
        // First, let's create a single ATM machine for our bank.
        BankATM mainStreetAtm = new BankATM("ATM001", "Main Street");

        // Now, let's create two customers with two different types of accounts.
        Account savings = new SavingsAccount("SA12345", "Alice Smith", 2000.00);
        Account current = new CurrentAccount("CA67890", "Bob Johnson", 1000.00, 500.00);

        // --- SCENARIO 1: Alice's Savings Account ---
        // Let's run a few transactions for Alice and see her special savings account rules in action.
        System.out.println("--- Processing transactions for Alice's Savings Account ---");
        mainStreetAtm.deposit(savings, 500.00);      // Balance: 2500
        mainStreetAtm.withdraw(savings, 200.00);     // Balance: 2300
        mainStreetAtm.withdraw(savings, 1800.00);    // This should succeed, as her balance will be 500, which is the minimum.
        mainStreetAtm.withdraw(savings, 1.00);       // This should FAIL, as it would drop her balance below 500.
        
        // Finally, let's print her statement to see the results.
        savings.printStatement();

        
        // --- SCENARIO 2: Bob's Current Account ---
        // Now let's see how Bob's overdraft feature works.
        System.out.println("\n\n--- Processing transactions for Bob's Current Account ---");
        mainStreetAtm.deposit(current, 300.00);      // Balance: 1300
        mainStreetAtm.withdraw(current, 500.00);     // Balance: 800
        mainStreetAtm.withdraw(current, 1200.00);    // This should succeed, using up 400 of his 500 overdraft. New Balance: -400.
        mainStreetAtm.withdraw(current, 200.00);     // This should FAIL, as it would exceed his overdraft limit.
        
        // Print Bob's final statement.
        current.printStatement();
    }
}