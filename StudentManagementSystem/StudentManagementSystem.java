import java.util.ArrayList;
import java.util.List;

/**
 * Represents a university course.
 * This class is a simple data object holding course information.
 */
class Course {
    private final String courseId;
    private final String courseName;
    private final int credits;

    public Course(String courseId, String courseName, int credits) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.credits = credits;
    }

    public String getCourseId() { return courseId; }
    public String getCourseName() { return courseName; }
    public int getCredits() { return credits; }

    /**
     * Provides a human-readable representation of the Course object.
     * @return A string in the format "courseName (courseId)".
     */
    @Override
    public String toString() {
        return this.courseName + " (" + this.courseId + ")";
    }
}

/**
 * Links a Student to a Course, representing an enrollment.
 * This class demonstrates composition, as a Student "has" Enrollments.
 */
class Enrollment {
    private final Course course;
    private final double grade; // Grade on a 4.0 scale

    public Enrollment(Course course, double grade) {
        this.course = course;
        this.grade = grade;
    }

    public Course getCourse() { return course; }
    public double getGrade() { return grade; }
}

/**
 * Base class for a student in the management system.
 * It handles core student information and course enrollments.
 */
class Student {
    private final String studentId;
    private final String name;
    private final List<Enrollment> enrollments;

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.enrollments = new ArrayList<>();
    }

    public String getStudentId() { return studentId; }
    public String getName() { return name; }
    public List<Enrollment> getEnrollments() { return new ArrayList<>(enrollments); } // Return a copy for safety

    /**
     * Enrolls the student in a course with a specific grade.
     * @param course The course to enroll in.
     * @param grade The grade received in the course.
     */
    public void enroll(Course course, double grade) {
        this.enrollments.add(new Enrollment(course, grade));
    }

    /**
     * Calculates the Grade Point Average (GPA) for the student.
     * This method can be overridden by subclasses for specific GPA rules.
     * @return The calculated GPA.
     */
    public double calculateGPA() {
        if (enrollments.isEmpty()) {
            return 0.0;
        }
        
        double totalPoints = 0;
        double totalCredits = 0;

        for (Enrollment e : enrollments) {
            totalPoints += e.getGrade() * e.getCourse().getCredits();
            totalCredits += e.getCourse().getCredits();
        }

        return totalCredits == 0 ? 0.0 : totalPoints / totalCredits;
    }

    /**
     * Prints a formatted transcript for the student, including courses, grades, and final GPA.
     */
    public void printTranscript() {
        System.out.println("Transcript for " + name + " (" + studentId + ")");
        System.out.println("------------------------------------");
        for (Enrollment e : enrollments) {
            System.out.printf("- %-20s: %.1f%n", e.getCourse().getCourseName(), e.getGrade());
        }
        System.out.println("------------------------------------");
        System.out.printf("Final GPA: %.2f%n", calculateGPA());
    }
}

/**
 * Represents an undergraduate student, inheriting from Student.
 * Has a custom rule for calculating GPA.
 */
class UndergraduateStudent extends Student {
    // A constant to define the maximum possible grade for GPA calculation.
    private static final double MAX_GRADE_FOR_GPA = 4.0;

    public UndergraduateStudent(String studentId, String name) {
        super(studentId, name);
    }

    /**
     * Calculates GPA for an undergraduate student.
     * Overrides the base method to cap all grades at 4.0, ensuring extra credit doesn't inflate GPA.
     * @return The calculated GPA.
     */
    @Override
    public double calculateGPA() {
        double totalPoints = 0;
        double totalCredits = 0;

        for (Enrollment e : getEnrollments()) {
            double grade = Math.min(e.getGrade(), MAX_GRADE_FOR_GPA);
            totalPoints += grade * e.getCourse().getCredits();
            totalCredits += e.getCourse().getCredits();
        }

        return totalCredits == 0 ? 0.0 : totalPoints / totalCredits;
    }
}

/**
 * Represents a postgraduate student, inheriting from Student.
 * Has a custom rule for calculating GPA.
 */
class PostgraduateStudent extends Student {
    // A constant to define the minimum GPA required to pass.
    private static final double MINIMUM_PASSING_GPA = 2.5;

    public PostgraduateStudent(String studentId, String name) {
        super(studentId, name);
    }

    /**
     * Calculates GPA for a postgraduate student.
     * Overrides the base method to enforce a minimum passing GPA. If the calculated GPA
     * is below this threshold, the student is considered to have failed (GPA 0.0).
     * @return The calculated GPA, or 0.0 if below the passing threshold.
     */
    @Override
    public double calculateGPA() {
        double gpa = super.calculateGPA();
        return gpa < MINIMUM_PASSING_GPA ? 0.0 : gpa;
    }
}

/**
 * The main class to run the Student Management System simulation.
 * This class sets up the demo data and prints the results.
 */
public class StudentManagementSystem {
    
    public static void main(String[] args) {
        System.out.println("--- Student Management System ---");
        
        // 1. Setup the courses available at the university.
        Course java = new Course("CS101", "Java Programming", 3);
        Course math = new Course("MA101", "Calculus I", 4);
        Course db = new Course("CS205", "Databases", 2);

        // 2. Create different types of students.
        Student alice = new UndergraduateStudent("UG001", "Alice");
        Student bob = new PostgraduateStudent("PG001", "Bob");

        // 3. Enroll students in courses and assign grades.
        alice.enroll(java, 3.5);
        alice.enroll(math, 3.7);

        // Bob's average grade is (2.2 * 3 + 2.8 * 2) / 5 = 2.44, which is below the 2.5 threshold.
        bob.enroll(java, 2.2);
        bob.enroll(db, 2.8);

        // 4. Print the final transcripts for each student.
        System.out.println();
        alice.printTranscript();
        
        System.out.println("\n====================================\n");
        
        bob.printTranscript();
        System.out.println("\n");
    }
}