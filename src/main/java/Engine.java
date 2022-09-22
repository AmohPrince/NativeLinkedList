import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Engine {
    static int numberOfCourses;
    static int totalStudents;
    List<String> courseNumbers = new ArrayList<>();
    List<String> studentNames = new ArrayList<>();
    List<String> courseNames = new ArrayList<>();
    List<String> studentIds = new ArrayList<>();
    List<String> emails = new ArrayList<>();
    List<String> addresses = new ArrayList<>();
    List<Student> studentList = new ArrayList<>();
    DoublyLinkedList doublyLinkedList = new DoublyLinkedList(courseNames.size(), studentNames.size());
    SinglyLinkedList singlyLinkedList = new SinglyLinkedList();

    public Engine() {
        try {
            begin();
        } catch (IOException ioException) {
            ioException.getLocalizedMessage();
        }
    }

    static void printInputData() {
        System.out.println("Input file is read successfully..");
        System.out.println("Summary of the record:");
        System.out.println(String.format("Number of courses registered: %d", numberOfCourses));
        System.out.println(String.format("Number of total students: %d", totalStudents));
    }


    void begin() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("inputFile.txt"));
        bufferedReader.readLine();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            String[] values = line.split(",");
            courseNumbers.add(values[0]);
            courseNames.add(values[1]);
            studentNames.add(cleaned(values[3]) + " " + cleaned(values[2]));
            studentIds.add(values[4]);
            emails.add(values[5]);
            addresses.add(values[6]);
        }

        numberOfCourses = (int) courseNumbers.stream().distinct().count();
        totalStudents = (int) studentIds.stream().count();

        Course firstItem = new Course(courseNumbers.get(0), courseNames.get(0), getStudentCount(courseNames.get(0)));
        doublyLinkedList.insertCourse(firstItem);
        for (int i = 1; i < courseNames.size(); i++) {
            Course toBeInserted = new Course(courseNumbers.get(i), courseNames.get(i), getStudentCount(courseNames.get(i)));
            if (!doublyLinkedList.contains(toBeInserted)) {
                doublyLinkedList.insertCourse(toBeInserted);
            }
        }

        for (int i = 0; i < studentNames.size(); i++) {
            Student student = new Student(studentNames.get(i), studentIds.get(i), emails.get(i), addresses.get(i), doublyLinkedList.getByCourseNumber(courseNumbers.get(i)));
            singlyLinkedList.insert(student);
            studentList.add(student);
        }


    }

    void showMenu() {
        System.out.print("1. Read the input data\n" +
                "2. Delete a course\n" +
                "3. Insert a new course\n" +
                "4. Delete a student\n" +
                "5. Insert a new student\n" +
                "6. Transfer a student from one course to another\n" +
                "7. Display the course list\n" +
                "8. Display the student list\n" +
                "9. Exit");
    }

    private void refreshValues() {
        numberOfCourses = (int) courseNumbers.stream().distinct().count();
        totalStudents = (int) studentIds.stream().count();
    }

    private int getStudentCount(String courseName) {
        return (int) studentList.stream().filter(student -> student.getCourse().getCourseName() == courseName).count();
    }


    private String cleaned(String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                if (s.charAt(i) != '"') {
                    builder.append(s.charAt(i));
                }
            }
        }
        return builder.toString();
    }


    public void deleteCourse() {
        System.out.println("Enter the course number to delete:");
        Scanner scanner = new Scanner(System.in);
        String courseNumber = scanner.next();
        scanner.close();
        var toBeDeleted = doublyLinkedList.getByCourseNumber(courseNumber);
        if (toBeDeleted == null) {
            System.out.println("You are trying to remove an un-inserted element");
        } else {
            doublyLinkedList.deleteCourse(toBeDeleted);
            courseNumbers.remove(toBeDeleted.getCourseNumber());
            refreshValues();
        }
    }

    public void insertNewCourse() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the new course number to add:");
        String newCourseNumber = scanner.next();
        System.out.println(String.format("Enter the new course name for %s:", newCourseNumber));
        String newCourseName = scanner.next();
        scanner.close();
        Course newCourse = new Course(newCourseNumber, newCourseName, 0);
        doublyLinkedList.insertCourse(newCourse);
        courseNumbers.add(newCourse.getCourseNumber());
        refreshValues();
    }

    public void deleteStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the student ID number to delete:");
        String deletingId = scanner.next();
        System.out.println("Enter the course number from which the student is to be dropped from:");
        String deletingCourseName = scanner.next();
        scanner.close();
        Student toBeDeleted = singlyLinkedList.getById(deletingId);
        if (toBeDeleted == null) {
            System.out.println("Student not found");
        } else {
            singlyLinkedList.deleteStudent(toBeDeleted);
            studentIds.remove(toBeDeleted.getId());
        }
        refreshValues();
    }

    public void createNewStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the course number the student wants to enroll to:");
        String courseNumberToEnrollTo = scanner.next();
        System.out.println("Enter the student’s name:");
        String studentName = scanner.next();
        System.out.println("Enter the student’s ID:");
        String studentId = scanner.next();
        System.out.println("Enter the student’s emergency contact address:");
        String studentEmergencyContact = scanner.next();
        scanner.close();
        Course targetCourse = doublyLinkedList.getByCourseNumber(courseNumberToEnrollTo);
        Student toBeInserted;
        if (targetCourse == null) {
            toBeInserted = new Student(studentName, studentId, null, studentEmergencyContact, new Course(courseNumberToEnrollTo, null, 0));
        } else {
            toBeInserted = new Student(studentName, studentId, null, studentEmergencyContact, targetCourse);
            studentIds.add(toBeInserted.getId());
            refreshValues();
        }
        singlyLinkedList.insert(toBeInserted);
    }

    public void changeStudentCourse() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the student’s name:");
        String studentNameToChangeCourse = scanner.next();
        System.out.println("Enter the course number the student wants to drop from:");
        String courseNumberToDropFrom = scanner.next();
        System.out.println("Enter the course number the student wants to enroll to:");
        String courseNumberToEnrolTo = scanner.next();
        scanner.close();
        var courseToChangeTo = doublyLinkedList.getByCourseNumber(courseNumberToEnrolTo);
        var studentToChangeCourse = singlyLinkedList.getByName(studentNameToChangeCourse);
        singlyLinkedList.transferStudent(courseToChangeTo, studentToChangeCourse);
    }

    public void displayCourseList() {
        doublyLinkedList.printCourseList();
    }

    public void displayStudentList() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the course number:");
        System.out.println("Note that the formatting or character encoding of the text may be wrong. make sure it looks something like CS�3513:");
        String courseNumber = scanner.next();
        scanner.close();
        System.out.println();
        System.out.println(String.format("The list of students enrolled in the course %s are as follows:", courseNumber));
        singlyLinkedList.displayAsList(courseNumber);
        scanner.close();
    }

    public void debug() {
//        singlyLinkedList.printAll();
        doublyLinkedList.printAll();
    }
}
