public class SinglyLinkedList implements SinglyLinkedListInterface {
    Student head;

    public boolean add(Student student) {
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

        return true;
    }

    public boolean remove(String studentId) {
        //assuming it's the first element;
        var prevStudent = getById(studentId);
        var nextStudent = prevStudent.getNext();
        prevStudent.setNext(nextStudent);
        return false;
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
                return student;
            }
            student = student.getNext();
        }
        if (student.getId() == studentId) {
            return student;
        }
        return null;
    }

    public Student getByName(String studentName) {
        Student student = head;
        while (student.getNext() != null) {
            if (student.getName() == studentName) {
                return student;
            }
            student = student.getNext();
        }
        if (student.getName() == studentName) {
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
        if (head == null) {
            return 0;
        }
        Student student = head;
        while (student.getNext() != null) {
            i++;
            student = student.getNext();
        }
        return i + 1;
    }

    @Override
    public boolean contains(Student student) {
        Student test = head;
        while (test.getNext() != null) {
            if (test.getName() == student.getName()) {
                return true;
            }
            test = test.getNext();
        }
        if (test.getName() == student.getName()) {
            return true;
        }
        return false;
    }

}
