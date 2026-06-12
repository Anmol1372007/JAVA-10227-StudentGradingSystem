import java.util.Scanner;

class Student {
    
    private String name;
    private int[] marks;
    private double average;
    private char grade;

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


        System.out.printf("\nAverage: %.2f\n", average); 
        System.out.println("Grade: " + grade);
        System.out.println("--------------------------\n");
    }
}


public class GradingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char choice;

        
        do {
            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();

            System.out.print("Enter number of subjects: ");
            int n = sc.nextInt();

            int[] marks = new int[n];

            System.out.println("Enter marks (0 to 100):");
            for (int i = 0; i < n; i++) {
                // 2. Input Validation

                while (true) {
                    System.out.print("Subject " + (i + 1) + ": ");
                    int inputMark = sc.nextInt();
                    
                    if (inputMark >= 0 && inputMark <= 100) {
                        marks[i] = inputMark;
                        break; 
                    } else {
                        System.out.println("Invalid Marks! Please enter marks between 0 and 100.");
                    }
                }
            }

            
            Student s = new Student(name, marks);
            s.calculateAverage();
            s.assignGrade();
            s.displayDetails();

                    System.out.print("Do you want to calculate for another student? (y/n): ");
            choice = sc.next().charAt(0);
            sc.nextLine();

        } while (choice == 'y' || choice == 'Y');

        System.out.println("Thank you for using the Student Grading System!");
        sc.close();
    }
}
