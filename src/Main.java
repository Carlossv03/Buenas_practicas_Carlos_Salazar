public class Main {
    public static void main(String[] args) {
        // Create a valid student
        Student student = new Student("12345", "Carlos");

        // Add valid grades
        student.addGrade(95.5);
        student.addGrade(85.0);
        student.addGrade(74.3);

        // Attempt to add an invalid grade
        student.addGrade(150.0);  // Error message will be shown

        // Remove by valid and invalid index
        student.removeGradeByIndex(1);   // OK
        student.removeGradeByIndex(10);  // Error

        // Remove by value
        student.removeGradeByValue(74.3); // OK
        student.removeGradeByValue(10.0); // Error

        // Generate report
        student.reportCard();
    }
}
