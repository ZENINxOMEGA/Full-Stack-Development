import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DateTimePrograms {

    // Q1: Display current time in different time zones
    public static void displayTimeInZones() {
        System.out.println("\n--- Current Time in Different Time Zones ---");
        
        // Get current time in GMT
        ZonedDateTime gmtTime = ZonedDateTime.now(ZoneId.of("GMT"));
        System.out.println("Current GMT Time: " + gmtTime);

        // Get current time in IST (India Standard Time)
        ZonedDateTime istTime = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        System.out.println("Current IST Time: " + istTime);

        // Get current time in PST (Pacific Standard Time)
        ZonedDateTime pstTime = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));
        System.out.println("Current PST Time: " + pstTime);
    }

    // Q2: Perform date arithmetic operations
    public static void performDateArithmetic() {
        System.out.println("\n--- Date Arithmetic Operations ---");
        
        LocalDate date = LocalDate.of(2025, 8, 27);

        // Add 7 days, 1 month, and 2 years
        LocalDate newDate = date.plusDays(7).plusMonths(1).plusYears(2);

        // Subtract 3 weeks from the new date
        LocalDate finalDate = newDate.minusWeeks(3);

        System.out.println("Original Date:        " + date);
        System.out.println("After Operations:     " + finalDate);
        System.out.println("(Original -> +2y, 1m, 7d -> -3w)");
    }

    // Q3: Format the current date in various patterns
    public static void formatCurrentDate() {
        System.out.println("\n--- Formatting the Current Date ---");
        
        LocalDate today = LocalDate.now();
        System.out.println("Today's Date (Default Format): " + today);

        // Define different formatters
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter format3 = DateTimeFormatter.ofPattern("EEE, MMM dd, yyyy"); // EEE for day of week

        // Apply formats and print
        System.out.println("Format (dd/MM/yyyy):        " + today.format(format1));
        System.out.println("Format (yyyy-MM-dd):        " + today.format(format2));
        System.out.println("Format (EEE, MMM dd, yyyy): " + today.format(format3));
    }

    // Q4: Compare two dates
    public static void compareTwoDates() {
        System.out.println("\n--- Comparing Two Dates ---");
        
        LocalDate date1 = LocalDate.of(2025, 8, 27);
        LocalDate date2 = LocalDate.of(2026, 1, 15);
        
        System.out.println("Comparing Date 1: " + date1);
        System.out.println("With Date 2:      " + date2);

        if (date1.isBefore(date2)) {
            System.out.println("Result: " + date1 + " is before " + date2);
        } else if (date1.isAfter(date2)) {
            System.out.println("Result: " + date1 + " is after " + date2);
        } else if (date1.isEqual(date2)) {
            System.out.println("Result: " + date1 + " is the same as " + date2);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=================================");
            System.out.println("   Java Date/Time Programs Menu");
            System.out.println("=================================");
            System.out.println("1. Display Time in Different Zones");
            System.out.println("2. Perform Date Arithmetic");
            System.out.println("3. Format Current Date");
            System.out.println("4. Compare Two Dates");
            System.out.println("0. Exit");
            System.out.println("=================================");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: displayTimeInZones(); break;
                case 2: performDateArithmetic(); break;
                case 3: formatCurrentDate(); break;
                case 4: compareTwoDates(); break;
                case 0: System.out.println("Exiting program. Goodbye!"); break;
                default: System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        sc.close();
    }
}