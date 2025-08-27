import java.time.LocalDate;
import java.util.Scanner;

public class DateArithmetic {
    public static void main(String[] args) {
        performDateArithmetic();
    }

    static void performDateArithmetic() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a date (YYYY-MM-DD): ");

        String str = scanner.nextLine();
        LocalDate    date = LocalDate.parse(str);
        LocalDate modifiedDate = date.plusDays(7).plusMonths(1).plusYears(2);
        LocalDate finalDate = modifiedDate.minusWeeks(3);
        System.out.println(finalDate);
    }
}