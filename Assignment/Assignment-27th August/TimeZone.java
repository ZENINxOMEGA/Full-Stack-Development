import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TimeZone {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("GMT Asia/Kolkata America/Los_Angeles" );
        String strc=in.next();
        displayDifferentTimezones(strc);
    }

    static void displayDifferentTimezones(String zones) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");

        // Time zones to display


        ZoneId zoneId = ZoneId.of(zones);
        ZonedDateTime zonedDateTime = ZonedDateTime.now(zoneId);
        System.out.println(zones + ": " + zonedDateTime.format(formatter));
    }

    public static class DateArthemetic {
        public static void main(String[] args) {
            dateArithmetic();
        }
        static void dateArithmetic() {
            Scanner scanner = new Scanner(System.in);


            System.out.print("Enter YYYY-MM-DD  ");
            String input = scanner.nextLine();
              LocalDate date = LocalDate.parse(input);
            LocalDate newdate = date.plusDays(7).plusMonths(1).plusYears(2);
            LocalDate finaldate = newdate.minusWeeks(3);

            System.out.println(finaldate);

        }
    }
}