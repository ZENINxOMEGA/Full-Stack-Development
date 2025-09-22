import java.util.Scanner;

public class SelfProblems {
    public static void main(String[] args) {
        /* Calculate Simple Interest */
        System.out.println("enter principal, rate and time");
        Scanner sc = new Scanner(System.in);
        float p = sc.nextFloat();  
        float r = sc.nextFloat();
        float t = sc.nextFloat();
        float si = (p * r * t) / 100;
        System.out.println("Simple Interest is: " + si);

        /* Perimeter of Rectangle */
        System.out.println("enter length and breadth of rectangle");
        float l = sc.nextFloat();   
        float b = sc.nextFloat();
        float perimeter = 2 * (l + b);
        System.out.println("Perimeter of rectangle is: " + perimeter);

        /* Power Calculation */
        System.out.println("enter base and exponent");
        int base = sc.nextInt();
        int exponent = sc.nextInt();
        int result = 1;
        for (int i = 1; i <= exponent; i++) {
            result *= base;
        }
        System.out.println("Result of " + base + " raised to the power of " + exponent + " is: " + result);

        /* Average of 3 numbers */
        System.out.println("enter three numbers");
        float num1 = sc.nextFloat();
        float num2 = sc.nextFloat();
        float num3 = sc.nextFloat();
        float average = (num1 + num2 + num3) / 3;
        System.out.println("Average of three numbers is: " + average);

        /* Convert Kilometres to miles */
        System.out.println("enter distance in kilometres");
        float km = sc.nextFloat();
        float miles = km * 0.621371f;
        System.out.println("Distance in miles is: " + miles);

        sc.close();
    }
}
        