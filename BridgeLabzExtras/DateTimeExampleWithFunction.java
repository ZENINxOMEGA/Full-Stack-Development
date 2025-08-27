import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class DateTimeExampleWithFunction {
    // Main method - entry point of the program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Get user input date in dd-MM-yyyy format
        String inputDate = getInputDate(scanner);

        // Step 2: Parse the input date to LocalDate
        LocalDate parsedDate = parseDate(inputDate);

        // Step 3: Find and display the day of the week for the input date
        displayDayOfWeek(parsedDate);

        // Step 4: Calculate and display the number of days between input date and current date
        displayDaysBetween(parsedDate);

        // Step 5: Display the current date and time in a formatted way
        displayCurrentDateTime();
    }

    // Step 1: Function to get user input
    public static String getInputDate(Scanner scanner) {
        System.out.println("Enter a date (dd-MM-yyyy): ");
        // Read and return the date string entered by the user
        return scanner.nextLine();
    }

    // Step 2: Function to parse the input date
    public static LocalDate parseDate(String inputDate) {
        // Define the date format to be used for parsing
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        // Parse the date string into a LocalDate object using the formatter
        return LocalDate.parse(inputDate, formatter);
    }

    // Step 3: Function to display the day of the week for the input date
    public static void displayDayOfWeek(LocalDate date) {
        // Get the day of the week for the parsed date
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        // Print the day of the week
        System.out.println("Day of the Week: " + dayOfWeek);
    }

    // Step 4: Function to display the number of days between the input date and the current date
    public static void displayDaysBetween(LocalDate date) {
        // Get the current date
        LocalDate currentDate = LocalDate.now();
        // Calculate the number of days between the input date and the current date
        long daysBetween = ChronoUnit.DAYS.between(date, currentDate);
        // Print the number of days between the two dates
        System.out.println("Days between input date and current date: " + daysBetween);
    }

    // Step 5: Function to display the current date and time in a formatted way
    public static void displayCurrentDateTime() {
        // Get the current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();
        // Define the format to display the date and time
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        // Print the current date and time in the specified format
        System.out.println("Current Date and Time: " + currentDateTime.format(dateTimeFormatter));
    }
}
