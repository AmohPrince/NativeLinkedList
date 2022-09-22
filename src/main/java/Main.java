import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Engine engine = new Engine();
        System.out.println("Welcome, Choose from the below menu by typing appropriate numbers");
        System.out.print("1. Read the input data\n" +
                "2. Delete a course\n" +
                "3. Insert a new course\n" +
                "4. Delete a student\n" +
                "5. Insert a new student\n" +
                "6. Transfer a student from one course to another\n" +
                "7. Display the course list\n" +
                "8. Display the student list\n" +
                "9. Exit");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                engine.printInputData();
            case 2:
                System.out.println("Enter the course number to delete:");
                String courseNumber = scanner.next();
                System.out.println(courseNumber);
                engine.deleteCourse(courseNumber);
                engine.printInputData();
            case 3:
                System.out.println("Enter the new course number to add:");
                String newCourseNumber = scanner.next();
                System.out.println("Enter the new course name for CS4323:");
                String newCourseName = scanner.next();
                engine.insertNewCourse(newCourseNumber, newCourseName);
                engine.printInputData();
            case 4:
                System.out.println("Enter the student ID number to delete:");
                String deletingId = scanner.next();
                System.out.println("Enter the course number from which the student is to be dropped from:");
                String deletingCourseName = scanner.next();
                engine.deleteStudent(deletingId, deletingCourseName);
                engine.printInputData();
            case 5:
                System.out.println("Enter the course number the student wants to enroll to:");
                String courseNumberToEnrollTo = scanner.next();
                System.out.println("Enter the student’s name:");
                String studentName = scanner.next();
                System.out.println("Enter the student’s ID:");
                String studentId = scanner.next();
                System.out.println("Enter the student’s emergency contact address:");
                String studentEmergencyContact = scanner.next();
                engine.createNewStudent(courseNumberToEnrollTo, studentName, studentId, studentEmergencyContact);
                engine.printInputData();
            case 6:
                System.out.println("Enter the student’s name:");
                String studentNameToChangeCourse = scanner.next();
                System.out.println("Enter the course number the student wants to drop from:");
                String courseNumberToDropFrom = scanner.next();
                System.out.println("Enter the course number the student wants to enroll to:");
                String courseNumberToEnrolTo = scanner.next();
                engine.changeStudentCourse(studentNameToChangeCourse, courseNumberToDropFrom, courseNumberToEnrolTo);

            case 7:
                engine.displayCourseList();
            case 8:
                engine.displayStudentList();
            case 9:
                System.exit(2);
        }
    }
}
