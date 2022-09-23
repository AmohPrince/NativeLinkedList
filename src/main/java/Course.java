public class Course {
    private SinglyLinkedList studentList = new SinglyLinkedList();
    private Course previousCourse;
    private Course nextCourse;
    private String CourseNumber;
    private String CourseName;

    private int studentCount;

    public Course(String courseNumber, String courseName) {
        CourseNumber = courseNumber;
        CourseName = courseName;
        this.studentCount = studentList.size();
    }

    public int getStudentCount() {
        return studentCount;
    }

    public SinglyLinkedList getStudentList() {
        return studentList;
    }

    public void setStudentList(SinglyLinkedList studentList) {
        this.studentList = studentList;
    }

    public Course getPreviousCourse() {
        return previousCourse;
    }

    public void setPreviousCourse(Course previousCourse) {
        this.previousCourse = previousCourse;
    }

    public Course getNextCourse() {
        return nextCourse;
    }

    public void setNextCourse(Course nextCourse) {
        this.nextCourse = nextCourse;
    }

    public String getCourseNumber() {
        return CourseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        CourseNumber = courseNumber;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    @Override
    public String toString() {
        return "Course{" +
                "previousCourse=" + previousCourse +
                ", nextCourse=" + nextCourse +
                ", CourseNumber='" + CourseNumber + '\'' +
                ", CourseName='" + CourseName + '\'' +
                '}' + "\n";
    }
}
