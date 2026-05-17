import java.util.ArrayList;
import java.util.Scanner;
class Student {
    int id;
    String name;
    String course;
    int age;
    double marks;
    Student(int id, String name, String course, int age, double marks) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.age = age;
        this.marks = marks;
    }
}
public class StudentManagementSystem {
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Search Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    searchStudent();
                    break;
                case 6:
                    System.out.println("Thank you! Program closed.");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 6);
    }
    static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        if (findStudentById(id) != null) {
            System.out.println("Student ID already exists!");
            return;
        }
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Course: ");
        String course = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();
        if (age <= 0 || marks < 0 || marks > 100) {
            System.out.println("Invalid age or marks!");
            return;
        }
        students.add(new Student(id, name, course, age, marks));
        System.out.println("Student added successfully!");
    }
    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }
        System.out.println("\n-------------------------------------------------------------");
        System.out.printf("%-10s %-20s %-15s %-10s %-10s\n",
                "ID", "Name", "Course", "Age", "Marks");
        System.out.println("-------------------------------------------------------------");
        for (Student s : students) {
            System.out.printf("%-10d %-20s %-15s %-10d %-10.2f\n",
                    s.id, s.name, s.course, s.age, s.marks);
        }
        System.out.println("-------------------------------------------------------------");
    }
    static void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();
        Student s = findStudentById(id);
        if (s == null) {
            System.out.println("Student not found!");
            return;
        }
        System.out.print("Enter New Name: ");
        s.name = sc.nextLine();
        System.out.print("Enter New Course: ");
        s.course = sc.nextLine();
        System.out.print("Enter New Age: ");
        s.age = sc.nextInt();
        System.out.print("Enter New Marks: ");
        s.marks = sc.nextDouble();
        if (s.age <= 0 || s.marks < 0 || s.marks > 100) {
            System.out.println("Invalid age or marks!");
            return;
        }
        System.out.println("Student updated successfully!");
    }
    static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        int id = sc.nextInt();
     Student s = findStudentById(id);
        if (s == null) {
            System.out.println("Student not found!");
            return;
        }
        students.remove(s);
        System.out.println("Student deleted successfully!");
    }
    static void searchStudent() {
        System.out.print("Enter Student ID to search: ");
        int id = sc.nextInt();
        Student s = findStudentById(id);
        if (s == null) {
            System.out.println("Student not found!");
            return;
        }
        System.out.println("\nStudent Details:");
        System.out.println("ID     : " + s.id);
        System.out.println("Name   : " + s.name);
        System.out.println("Course : " + s.course);
        System.out.println("Age    : " + s.age);
        System.out.println("Marks  : " + s.marks);
    }
    static Student findStudentById(int id) {
        for (Student s : students) {
            if (s.id == id) {
                return s;
            }
        }
        return null;
    }
}