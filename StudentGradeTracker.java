import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentGradeTracker {
    private static Map<String, Double> grades = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("Choose an option: add, calculate, exit");
            String option = scanner.next();
            
            if (option.equals("add")) {
                System.out.print("Enter subject: ");
                String subject = scanner.next();
                System.out.print("Enter grade: ");
                double grade = scanner.nextDouble();
                grades.put(subject, grade);
            } else if (option.equals("calculate")) {
                double total = 0;
                for (double grade : grades.values()) {
                    total += grade;
                }
                double average = total / grades.size();
                System.out.println("Average grade: " + average);
                System.out.println("Letter grade: " + getLetterGrade(average));
            } else if (option.equals("exit")) {
                break;
            }
        }
    }

    private static String getLetterGrade(double average) {
        if (average >= 90) {
            return "A";
        } else if (average >= 80) {
            return "B";
        } else if (average >= 70) {
            return "C";
        } else if (average >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
}