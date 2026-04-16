package smartcampus;

import smartcampus.exception.CourseNotFoundException;
import smartcampus.exception.InvalidFeeException;
import smartcampus.exception.StudentNotFoundException;
import smartcampus.service.CampusService;
import smartcampus.thread.EnrollmentProcessor;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * SmartCampus Management System - Main Entry Point
 * BTech 2nd Year | GNC College
 */
public class Main {

    public static void main(String[] args) {
        CampusService service = new CampusService();
        Scanner scanner = new Scanner(System.in);

        // Load previously saved data on startup
        service.loadData();

        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║   SmartCampus Management System      ║");
        System.out.println("║   GNC College | BTech 2nd Year       ║");
        System.out.println("╚══════════════════════════════════════╝");

        boolean running = true;
        while (running) {
            printMenu();
            int choice = -1;
            try {
                System.out.print("Enter choice: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // consume newline
            } catch (InputMismatchException e) {
                System.out.println("  ✗  Invalid input! Please enter a number.\n");
                scanner.nextLine();
                continue;
            }

            switch (choice) {

                case 1: // Add Student
                    try {
                        System.out.print("Student ID   : ");
                        int sid = scanner.nextInt(); scanner.nextLine();
                        System.out.print("Name         : ");
                        String sname = scanner.nextLine();
                        System.out.print("Email        : ");
                        String email = scanner.nextLine();
                        service.addStudent(sid, sname, email);
                    } catch (InputMismatchException e) {
                        System.out.println("  ✗  Invalid ID format.");
                        scanner.nextLine();
                    }
                    break;

                case 2: // Add Course
                    try {
                        System.out.print("Course ID    : ");
                        int cid = scanner.nextInt(); scanner.nextLine();
                        System.out.print("Course Name  : ");
                        String cname = scanner.nextLine();
                        System.out.print("Fee (₹)      : ");
                        double fee = scanner.nextDouble(); scanner.nextLine();
                        service.addCourse(cid, cname, fee);
                    } catch (InputMismatchException e) {
                        System.out.println("  ✗  Invalid input format.");
                        scanner.nextLine();
                    } catch (InvalidFeeException e) {
                        System.out.println("  ✗  " + e.getMessage());
                    }
                    break;

                case 3: // Enroll Student
                    try {
                        System.out.print("Student ID   : ");
                        int esid = scanner.nextInt();
                        System.out.print("Course ID    : ");
                        int ecid = scanner.nextInt(); scanner.nextLine();
                        service.enrollStudent(esid, ecid);
                    } catch (InputMismatchException e) {
                        System.out.println("  ✗  Invalid ID format.");
                        scanner.nextLine();
                    } catch (StudentNotFoundException | CourseNotFoundException e) {
                        System.out.println("  ✗  " + e.getMessage());
                    }
                    break;

                case 4: // View Students
                    service.viewStudents();
                    break;

                case 5: // View Enrollments
                    service.viewEnrollments();
                    break;

                case 6: // Process Enrollment (Thread)
                    EnrollmentProcessor processor = new EnrollmentProcessor(service.getEnrollments());
                    Thread thread = new Thread(processor, "EnrollmentThread-1");
                    thread.start();
                    try { thread.join(); } catch (InterruptedException e) {
                        System.out.println("  Thread interrupted.");
                    }
                    break;

                case 7: // Save Data (Bonus)
                    service.saveData();
                    break;

                case 8: // View Courses
                    service.viewCourses();
                    break;

                case 0: // Exit
                    service.saveData(); // auto-save on exit
                    System.out.println("\n  Goodbye! Data saved automatically. 👋");
                    running = false;
                    break;

                default:
                    System.out.println("  ✗  Invalid choice. Please select from the menu.");
            }
            System.out.println();
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("┌─────────────────────────────────────┐");
        System.out.println("│           MAIN MENU                 │");
        System.out.println("├─────────────────────────────────────┤");
        System.out.println("│  1. Add Student                     │");
        System.out.println("│  2. Add Course                      │");
        System.out.println("│  3. Enroll Student in Course        │");
        System.out.println("│  4. View All Students               │");
        System.out.println("│  5. View All Enrollments            │");
        System.out.println("│  6. Process Enrollments (Thread)    │");
        System.out.println("│  7. Save Data to File               │");
        System.out.println("│  8. View All Courses                │");
        System.out.println("│  0. Exit                            │");
        System.out.println("└─────────────────────────────────────┘");
    }
}
