import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class DateTimeExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Input date in dd-MM-yyyy format
        System.out.println("Enter a date (dd-MM-yyyy): ");
        String inputDate = scanner.nextLine();

        // Step 2: Parse input date using DateTimeFormatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse(inputDate, formatter);

        // Step 3: Find the day of the week
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        System.out.println("Day of the Week: " + dayOfWeek);

        // Step 4: Calculate the difference between input date and current date
        LocalDate currentDate = LocalDate.now();
        long daysBetween = ChronoUnit.DAYS.between(date, currentDate);
        System.out.println("Days between input date and current date: " + daysBetween);

        // Step 5: Display the current date and time in a formatted way
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        System.out.println("Current Date and Time: " + currentDateTime.format(dateTimeFormatter));
    }
}
