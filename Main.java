import java.util.ArrayList;
	import java.util.Scanner;
	class Student {
	    int rollNo;
	    String name;
	    String department;

	    Student(int rollNo, String name, String department) {
	        this.rollNo = rollNo;
	        this.name = name;
	        this.department = department;
	    }

	    void display() {
	        System.out.println("Roll No: " + rollNo);
	        System.out.println("Name: " + name);
	        System.out.println("Department: " + department);
	        System.out.println("---------------------------");
	    }
	}

	public class Main {

	    static ArrayList<Student> students = new ArrayList<>();

	    public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);
	        int choice;

	        do {
	            System.out.println("\n===== Student Management System =====");
	            System.out.println("1. Add Student");
	            System.out.println("2. View Students");
	            System.out.println("3. Search Student");
	            System.out.println("4. Delete Student");
	            System.out.println("5. Exit");
	            System.out.print("Enter your choice: ");
	            choice = sc.nextInt();

	            switch (choice) {

	                case 1:
	                    System.out.print("Enter Roll No: ");
	                    int roll = sc.nextInt();
	                    sc.nextLine(); // clear buffer

	                    System.out.print("Enter Name: ");
	                    String name = sc.nextLine();

	                    System.out.print("Enter Department: ");
	                    String dept = sc.nextLine();

	                    students.add(new Student(roll, name, dept));
	                    System.out.println("Student Added Successfully!");
	                    break;

	                case 2:
	                    if (students.isEmpty()) {
	                        System.out.println("No students found.");
	                    } else {
	                        for (Student s : students) {
	                            s.display();
	                        }
	                    }
	                    break;

	                case 3:
	                    System.out.print("Enter Roll No to Search: ");
	                    int searchRoll = sc.nextInt();
	                    boolean found = false;

	                    for (Student s : students) {
	                        if (s.rollNo == searchRoll) {
	                            s.display();
	                            found = true;
	                        }
	                    }

	                    if (!found) {
	                        System.out.println("Student not found.");
	                    }
	                    break;

	                case 4:
	                    System.out.print("Enter Roll No to Delete: ");
	                    int deleteRoll = sc.nextInt();
	                    students.removeIf(s -> s.rollNo == deleteRoll);
	                    System.out.println("Student Deleted (if existed).");
	                    break;

	                case 5:
	                    System.out.println("Exiting... Thank You!");
	                    break;

	                default:
	                    System.out.println("Invalid choice!");
	            }

	        } while (choice != 5);

	        sc.close();
	    }
	}

