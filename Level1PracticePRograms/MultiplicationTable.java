import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Get input from user
        System.out.print("Enter a number to generate multiplication table: ");
        int number = scanner.nextInt();
        
        // Create array to store multiplication results
        int[] multiplicationTable = new int[10];
        
        // Calculate and store multiplication results
        for(int i = 0; i < 10; i++) {
            multiplicationTable[i] = number * (i + 1);
        }
        
        // Display multiplication table using the array
        System.out.println("\nMultiplication Table for " + number + ":");
        for(int i = 0; i < 10; i++) {
            System.out.println(number + " * " + (i + 1) + " = " + multiplicationTable[i]);
        }
        
        scanner.close();
    }
}
