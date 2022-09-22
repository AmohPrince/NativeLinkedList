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

        System.out.println(courseNumbers);
        System.out.println(courseNames);

        numberOfCourses = (int) courseNumbers.stream().distinct().count();
        totalStudents = (int) studentIds.stream().count();

        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        for (int i = 0; i < studentNames.size(); i++) {
            Student student = new Student(studentNames.get(i), studentIds.get(i), emails.get(i), addresses.get(i), new Course(courseNumbers.get(i), courseNames.get(i), getStudentCount(courseNames.get(i))));
            singlyLinkedList.insert(student);
            studentList.add(student);
        }

        DoublyLinkedList doublyLinkedList = new DoublyLinkedList(courseNames.size(), studentNames.size());
        for (int i = 0; i < courseNames.size(); i++) {
            doublyLinkedList.insertCourse(new Course(courseNames.get(i), courseNames.get(i), getStudentCount(courseNames.get(i))));
        }

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


}
