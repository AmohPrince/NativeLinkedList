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
        if (student == head) {

        }
        Student temp = head.getNext();
        head.setNext(temp);
    }

    public void transferStudent(Course newCourse, Student student) {
        student.setCourse(newCourse);
    }

    public void displayAsList() {
        Student student = head;
        while (student.getNext() != null) {
            System.out.println(student.getName());
            student = student.getNext();
        }
    }
}