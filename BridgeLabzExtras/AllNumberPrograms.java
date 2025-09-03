import java.util.Scanner;

public class AllNumberPrograms {

    // 2. Maximum of Three Numbers
    public static void findMaxOfThree(Scanner sc) {
        System.out.println("\n--- Find Maximum of Three Numbers ---");
        int a, b, c;
        System.out.print("Enter first number: ");
        a = sc.nextInt();
        System.out.print("Enter second number: ");
        b = sc.nextInt();
        System.out.print("Enter third number: ");
        c = sc.nextInt();
        
        int max;
        if (a >= b && a >= c) {
            max = a;
        } else if (b >= a && b >= c) {
            max = b;
        } else {
            max = c;
        }
        System.out.println("Maximum number is: " + max);
    }

    // 3. Prime Number Checker
    public static void checkPrimeNumber(Scanner sc) {
        System.out.println("\n--- Prime Number Checker ---");
        System.out.print("Enter a number to check: ");
        int n = sc.nextInt();
        boolean isPrime = true;

        if (n <= 1) {
            isPrime = false;
        } else {
            // Check for factors from 2 up to the square root of n
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }

        if (isPrime) {
            System.out.println(n + " is a prime number.");
        } else {
            System.out.println(n + " is not a prime number.");
        }
    }

    // 4. Fibonacci Sequence Generator
    public static void generateFibonacci(Scanner sc) {
        System.out.println("\n--- Fibonacci Sequence Generator ---");
        System.out.print("Enter the number of terms to generate: ");
        int terms = sc.nextInt();
        int f = 0, g = 1;
        
        System.out.print("Fibonacci sequence: ");
        for (int i = 1; i <= terms; i++) {
            System.out.print(f + " ");
            int next = f + g;
            f = g;
            g = next;
        }
        System.out.println();
    }

    // 5. Palindrome Checker
    public static void checkPalindrome(Scanner sc) {
        System.out.println("\n--- Palindrome Checker ---");
        System.out.print("Enter a string or number: ");
        String str = sc.next();
        String rev = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            rev = rev + str.charAt(i);
        }

        if (str.equalsIgnoreCase(rev)) {
            System.out.println(str + " is a palindrome.");
        } else {
            System.out.println(str + " is not a palindrome.");
        }
    }

    // 6. Factorial Calculator
    public static void calculateFactorial(Scanner sc) {
        System.out.println("\n--- Factorial Calculator ---");
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        long fact = 1; // Use long to handle larger results
        
        if (n < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
            return;
        }

        for (int i = 1; i <= n; i++) {
            fact = fact * i;
        }
        System.out.println("Factorial of " + n + " is " + fact);
    }

    // 7. GCD and LCM Calculator
    public static void calculateGcdAndLcm(Scanner sc) {
        System.out.println("\n--- GCD and LCM Calculator ---");
        System.out.print("Enter first number: ");
        int x = sc.nextInt();
        System.out.print("Enter second number: ");
        int y = sc.nextInt();
        
        int a = x;
        int b = y;
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        
        int gcd = a;
        // LCM * GCD = x * y
        int lcm = (x * y) / gcd;

        System.out.println("GCD: " + gcd);
        System.out.println("LCM: " + lcm);
    }

    // 8. Temperature Converter
    public static void convertTemperature(Scanner sc) {
        System.out.println("\n--- Temperature Converter ---");
        System.out.print("Enter 1 for Celsius to Fahrenheit or 2 for Fahrenheit to Celsius: ");
        int choice = sc.nextInt();

        if (choice == 1) {
            System.out.print("Enter temperature in Celsius: ");
            double c = sc.nextDouble();
            double f = (c * 9.0 / 5.0) + 32; // Use 9.0/5.0 for floating-point division
            System.out.println("Temperature in Fahrenheit: " + f);
        } else if (choice == 2) {
            System.out.print("Enter temperature in Fahrenheit: ");
            double f = sc.nextDouble();
            double c = (f - 32) * 5.0 / 9.0; // Use 5.0/9.0 for floating-point division
            System.out.println("Temperature in Celsius: " + c);
        } else {
            System.out.println("Invalid choice.");
        }
    }

    // 9. Basic Calculator
    public static void basicCalculator(Scanner sc) {
        System.out.println("\n--- Basic Calculator ---");
        System.out.print("Enter first number: ");
        double num1 = sc.nextDouble();
        System.out.print("Choose operation (+, -, *, /): ");
        char op = sc.next().charAt(0);
        System.out.print("Enter second number: ");
        double num2 = sc.nextDouble();
        
        double result = 0;
        boolean validOp = true;

        switch(op) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("Error: Division by zero is not allowed.");
                    validOp = false;
                }
                break;
            default:
                System.out.println("Error: Invalid operator.");
                validOp = false;
        }

        if (validOp) {
            System.out.println("Result: " + num1 + " " + op + " " + num2 + " = " + result);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=================================");
            System.out.println("    Java Number Programs Menu");
            System.out.println("=================================");
            System.out.println("1. Find Maximum of Three Numbers");
            System.out.println("2. Prime Number Checker");
            System.out.println("3. Fibonacci Sequence Generator");
            System.out.println("4. Palindrome Checker");
            System.out.println("5. Factorial Calculator");
            System.out.println("6. GCD and LCM Calculator");
            System.out.println("7. Temperature Converter");
            System.out.println("8. Basic Calculator");
            System.out.println("0. Exit");
            System.out.println("=================================");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: findMaxOfThree(sc); break;
                case 2: checkPrimeNumber(sc); break;
                case 3: generateFibonacci(sc); break;
                case 4: checkPalindrome(sc); break;
                case 5: calculateFactorial(sc); break;
                case 6: calculateGcdAndLcm(sc); break;
                case 7: convertTemperature(sc); break;
                case 8: basicCalculator(sc); break;
                case 0: System.out.println("Exiting program. Goodbye!"); break;
                default: System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        sc.close();
    }
}