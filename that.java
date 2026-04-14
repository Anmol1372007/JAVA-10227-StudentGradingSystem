import java.util.Scanner;

class Student {
    String name;
    int[] marks;
    double average;
    char grade;

    // Constructor
    public Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    // Method to calculate average
    public void calculateAverage() {
        int sum = 0;
        for (int i = 0; i < marks.length; i++) {
            sum += marks[i];
        }
        average = (double) sum / marks.length;
    }

    // Method to assign grade
    public void assignGrade() {
        if (average >= 90) {
            grade = 'A';
        } else if (average >= 75) {
            grade = 'B';
        } else if (average >= 60) {
            grade = 'C';
        } else if (average >= 50) {
            grade = 'D';
        } else {
            grade = 'F';
        }
    }

    // Method to display details
    public void displayDetails() {
        System.out.println("\n----- Student Report -----");
        System.out.println("Name: " + name);

        System.out.print("Marks: ");
        for (int m : marks) {
            System.out.print(m + " ");
        }

        System.out.println("\nAverage: " + average);
        System.out.println("Grade: " + grade);
    }
}

public class that {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter number of subjects: ");
        int n = sc.nextInt();

        int[] marks = new int[n];

        System.out.println("Enter marks:");
        for (int i = 0; i < n; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
        }

        Student s = new Student(name, marks);

        s.calculateAverage();
        s.assignGrade();
        s.displayDetails();

        sc.close();
    }
}
