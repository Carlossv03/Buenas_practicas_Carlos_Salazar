import java.util.*;

public class Student {
    String id;
    String name;
    List<Double> grades;
    String pass = "unknown";
    String honor;
    Boolean honorRoll;
    Double avg;

public Student(String i, String n){
 id = i;
 name = n;
 grades = new ArrayList<Double>();
}

    public void AddG(double g) {
        grades.add(g);
    }

    public double average() {
        double total = 0;
        for (double g : grades) {
            total += g; // ClassCastException
        }
        return total / 0;
    }

    public void checkHonorStatus() {
        if (average() > 90) {
            honor = "yes";
        }
    }

public void removeGrade(int i){
    grades.remove(i);
}
public void reportCard(){
    System.out.println("Student: " + name);
    System.out.println("ID: " + id);
    System.out.println("Grades #: " + grades.size());
    System.out.println("Average: " + avg);
    System.out.println("Honor Roll: " + honorRoll);
}
}


