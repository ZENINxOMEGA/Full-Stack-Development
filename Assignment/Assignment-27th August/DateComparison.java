import java.time.LocalDate;
import java.util.Scanner;

public class DateComparison {
    public static void main(String[] args) {
        compareTwoDates();
    }

    static void compareTwoDates() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("(YYYY-MM-DD): ");
            String strdate = scanner.nextLine();
            LocalDate date1 = LocalDate.parse(strdate);
            System.out.print("(YYYY-MM-DD): ");
            String strdate2 = scanner.nextLine();
            LocalDate date2 = LocalDate.parse(strdate2);
            if (date1.isBefore(date2)) {
                System.out.println(" date is BEFORE");
            } else if (date1.isAfter(date2)) {
                System.out.println("date is AFTER ");
            } else if (date1.isEqual(date2)) {
                System.out.println("Both dates are EQUAL.");
            }
        }
}