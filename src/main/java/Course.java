public class Course {
    private Course previousCourse;
    private Course nextCourse;
    private String CourseNumber;
    private String CourseName;
    private int studentCount;


    public Course(String courseNumber, String courseName, int studentCount) {
        CourseNumber = courseNumber;
        CourseName = courseName;
        this.studentCount = studentCount;
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

    public int getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
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
                ", studentCount=" + studentCount +
                '}' + "\n";
    }
}
