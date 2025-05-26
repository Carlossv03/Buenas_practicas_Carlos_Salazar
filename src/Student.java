import java.util.ArrayList;
import java.util.List;

public class Student {
    private String id;
    private String name;
    private List<Double> grades;
    private boolean passed;
    private boolean honorRoll;

    public Student(String id, String name) {
        if (id == null || id.trim().isEmpty() || name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("ID and name must not be empty.");
        }
        this.id = id;
        this.name = name;
        this.grades = new ArrayList<>();
        this.passed = false;
        this.honorRoll = false;
    }

    public void addGrade(double grade) {
        if (grade < 0 || grade > 100) {
            System.out.println("Invalid grade: " + grade + ". Must be between 0 and 100.");
            return;
        }
        grades.add(grade);
    }

    public boolean removeGradeByIndex(int index) {
        try {
            grades.remove(index);
            return true;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: Invalid index " + index);
            return false;
        }
    }

    public boolean removeGradeByValue(double value) {
        if (grades.contains(value)) {
            grades.remove(value);
            return true;
        } else {
            System.out.println("Error: Grade value not found.");
            return false;
        }
    }

    public double getAverage() {
        if (grades.isEmpty()) return 0.0;

        double total = 0.0;
        for (double g : grades) {
            total += g;
        }
        return total / grades.size();
    }

    public String getLetterGrade() {
        double avg = getAverage();
        if (avg >= 90) return "A";
        if (avg >= 80) return "B";
        if (avg >= 70) return "C";
        if (avg >= 60) return "D";
        return "F";
    }

    public void evaluate() {
        double avg = getAverage();
        this.passed = avg >= 60;
        this.honorRoll = avg >= 90;
    }

    public void reportCard() {
        evaluate(); // Asegura que honorRoll y passed están actualizados
        System.out.println("===== STUDENT REPORT =====");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Grades Count: " + grades.size());
        System.out.printf("Average: %.2f\n", getAverage());
        System.out.println("Letter Grade: " + getLetterGrade());
        System.out.println("Passed: " + (passed ? "Yes" : "No"));
        System.out.println("Honor Roll: " + (honorRoll ? "Yes" : "No"));
        System.out.println("==========================");
    }
}
