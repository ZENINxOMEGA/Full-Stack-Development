import java.util.Scanner;

public class Level1PracticeProblems {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        /* Question Number 1 */
        int HarryBirthYear = 2000;
        int CurrentYear = 2024;
        int HarryAge = CurrentYear - HarryBirthYear;
        System.out.println("Harry's age is: " + HarryAge);

        /* Question Number 2 */
        int MathsMarks = 94;
        int PhysicsMarks = 95;
        int ChemistryMarks = 96;
        int TotalMarks = MathsMarks + PhysicsMarks + ChemistryMarks;
        double Percentage = (TotalMarks / 300.0) * 100;
        int Average = TotalMarks / 3;
        System.out.println("Harry's average marks are: " + Average);
        System.out.println("Harry's percentage is: " + Percentage + "%");

        /* Question Number 3 */
        float distanceInKm = 10.8f;
        float distanceInMiles = distanceInKm * 0.621371f;
        System.out.println("Distance in miles: " + distanceInMiles);

        /* Question Number 4 */
        int costPrice = 129;
        int sellingPrice = 191;
        int profit = sellingPrice - costPrice;
        int profitPercentage = (profit * 100) / costPrice;
        System.out.println("Profit percentage is: " + profitPercentage + "%");

        /* Question Number 5 */
        int CountPens = 14;
        int CountStudents = 3;
        int PensPerStudent = CountPens / CountStudents;
        int RemainingPens = CountPens % CountStudents;
        System.out.println("Each student gets " + PensPerStudent + " pens.");
        System.out.println("Remaining pens in the box: " + RemainingPens);

        /* Question Number 6 */

    }
}