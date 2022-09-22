public class SinglyLinkedList {
    Student head;

    public void insert(Student student) {
        Student studentToTest = student;

        //If it's the first time inserting then head is null
        if (head == null) {
            head = studentToTest;
        } else {
            Student nextStudent = head;
            while (nextStudent.getNext() != null) {
                nextStudent = nextStudent.getNext();
            }
            nextStudent.setNext(student);
        }
    }

    public void deleteStudent(Student student) {
        //assuming it's the first element;
        var prevStudent = student.getPrev();
        var nextStudent = student.getNext();
        prevStudent.setNext(nextStudent);
    }

    public void transferStudent(Course newCourse, Student student) {
        if (student != null) {
            student.setCourse(newCourse);
        }
    }

    public void displayAsList(String courseNumber) {
        System.out.println(String.format("Student’s ID          Students Name       Email       Address"));
        Student student = head;
        while (student.getNext() != null) {
            if (student.getCourse().getCourseNumber().equals(courseNumber)) {
                System.out.format("%s                 %s             %s             %s", student.getId(), student.getName(), student.getEmail(), student.getAddress() + "\n");
            }
            student = student.getNext();
        }
    }

    public Student getById(String studentId) {
        Student student = head;
        while (student.getNext() != null) {
            if (student.getId() == studentId) {
                System.out.println(student.getId() + " " + studentId);
                return student;
            }
            student = student.getNext();
        }
        if (student.getId() == studentId) {
            System.out.println(student.getId() + " " + studentId);
            return student;
        }
        return null;
    }

    public Student getByName(String studentName) {
        System.out.println(studentName);
        Student student = head;
        while (student.getNext() != null) {
            if (student.getName() == studentName) {
                System.out.println(student.getId() + " " + studentName);
                return student;
            }
            student = student.getNext();
        }
        if (student.getName() == studentName) {
            System.out.println(student.getId() + " " + studentName);
            return student;
        }
        return null;
    }

    public void printAll() {
        Student student = head;
        while (student.getNext() != null) {
            System.out.println(student.getName() + " " + student.getCourse().getCourseNumber());
            student = student.getNext();
        }
        System.out.println(student.getName() + " " + student.getCourse().getCourseNumber());
    }

    public int size() {
        int i = 0;
        Student student = head;
        while (student.getNext() != null) {
            i++;
            student = student.getNext();
        }
        return i + 1;
    }
}
