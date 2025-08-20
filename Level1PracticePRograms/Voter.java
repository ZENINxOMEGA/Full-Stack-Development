import java.util.Scanner;

public class Voter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] age = new int[10];
        
        for (int i = 0; i < age.length; i++) {
            System.out.print("Enter age of voter " + (i + 1) + ": ");
            age[i] = sc.nextInt();
        }
        System.out.println("----------------------------------------------------------------12");
        for (int i = 0; i < age.length; i++) {
            if (age[i] >= 18) {
                System.out.println("Voter " + (i + 1) + " is eligible to vote.");
            } 
            if (age[i] < 0) {
                System.out.println("Invalid age entered for voter ");
            }
            if (age[i] < 18 && age[i] > 0) {
                System.out.println("Voter " + (i + 1) + " is not eligible to vote.");
            }
        }
        sc.close();
    }
}