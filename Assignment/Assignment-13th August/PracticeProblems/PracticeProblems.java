import java.util.Scanner;

public class PracticeProblems {
    public static void main(String[] args) {
        /*Question Number 1 */
        System.out.println("Welcome To BridgeLabz");


        /*Question Number 2 */
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Two Numbers to Find Their Sum: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int sum = a + b;   
        System.out.println("The Sum of Two Numbers is: " + sum);

        /*Question Number 3 */
        System.out.println("Enter the temperature in Celsius: ");
        double celsius = sc.nextDouble();
        double fahrenheit = (celsius * 9/5) + 32;
        System.out.println(celsius + " degrees Celsius is equal to " + fahrenheit + " degrees Fahrenheit.");

        /*Question Number 4 */
        System.out.println("Enter the radius of the circle: ");
        double radius = sc.nextDouble();
        double area = Math.PI * radius * radius;
        System.out.println("The area of the circle with radius " + radius + " is: " + area);

        /* Question Number 5 */
        System.out.println("Enter the radius of the cylinder: ");
        double radiusCyl = sc.nextDouble();
        System.out.println("Enter the height of the cylinder: ");
        double heightCyl = sc.nextDouble(); 
        double volumeCyl = Math.PI * radiusCyl * radiusCyl * heightCyl;
        System.out.println("The volume of the cylinder is: " + volumeCyl);

        sc.close();

    }
}
        

        