import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

        for (int i = 0; i < studentNames.size(); i++) {
            Student student = new Student(studentNames.get(i), studentIds.get(i), emails.get(i), addresses.get(i), new Course(courseNumbers.get(i), courseNames.get(i), getStudentCount(courseNames.get(i))));
            singlyLinkedList.insert(student);
            studentList.add(student);
        }

        for (int i = 0; i < courseNames.size(); i++) {
            doublyLinkedList.insertCourse(new Course(courseNames.get(i), courseNames.get(i), getStudentCount(courseNames.get(i))));
        }

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


    public void deleteCourse(String courseNumber) {
        //TODO Complete
        var toBeDeleted = doublyLinkedList.get(courseNumber);
        if (toBeDeleted == null) {
            System.out.println("You are trying an un-inserted element");
        } else {
            doublyLinkedList.deleteCourse(toBeDeleted);
            courseNumbers.remove(toBeDeleted.getCourseNumber());
            refreshValues();
        }
    }

    public void insertNewCourse(String newCourseNumber, String newCourseName) {
        //TODO Complete
        Course newCourse = new Course(newCourseNumber, newCourseName, 0);
        doublyLinkedList.insertCourse(newCourse);
        courseNumbers.add(newCourse.getCourseNumber());
        refreshValues();
    }

    public void deleteStudent(String deletingId, String deletingCourseName) {
        //TODO Complete
        Student toBeDeleted = singlyLinkedList.get(deletingId);
        singlyLinkedList.deleteStudent(toBeDeleted);
        studentIds.remove(toBeDeleted.getId());
        refreshValues();
    }

    public void createNewStudent(String courseNumberToEnrollTo, String studentName, String studentId, String studentEmergencyContact) {
        //TODO Complete
        Course targetCourse = doublyLinkedList.get(courseNumberToEnrollTo);
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

    public void changeStudentCourse(String studentNameToChangeCourse, String courseNumberToDropFrom, String courseNumberToEnrolTo) {
        //TODO Complete
        var courseToChangeTo = doublyLinkedList.get(courseNumberToEnrolTo);
        var studentToChangeCourse = singlyLinkedList.get(studentNameToChangeCourse);
        singlyLinkedList.transferStudent(courseToChangeTo, studentToChangeCourse);
    }

    public void displayCourseList() {
        //TODO Complete
        doublyLinkedList.printCourseList();
    }

    public void displayStudentList() {
        //TODO Complete
        singlyLinkedList.displayAsList();
    }
}
