import java.util.Scanner;

public class EvenOddPosNeg {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];

        // Getting input for 5 numbers
        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        // Checking each number for positive/negative/zero and even/odd
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("\nNumber " + numbers[i] + " is: ");
            if (numbers[i] > 0) {
                System.out.print("Positive and ");
                if (numbers[i] % 2 == 0) {
                    System.out.println("Even");
                } else {
                    System.out.println("Odd");
                }
            } else if (numbers[i] < 0) {
                System.out.println("Negative");
            } else {
                System.out.println("Zero");
            }
        }

        // Comparing first and last elements
        System.out.println("\nComparing first element (" + numbers[0] + 
                         ") and last element (" + numbers[4] + "):");
        if (numbers[0] == numbers[4]) {
            System.out.println("First and last elements are equal");
        } else if (numbers[0] > numbers[4]) {
            System.out.println("First element is greater than last element");
        } else {
            System.out.println("First element is less than last element");
        }

        scanner.close();
    }
}
