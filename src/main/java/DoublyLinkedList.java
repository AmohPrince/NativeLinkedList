public class DoublyLinkedList {
    private Course head;
    private Course prevCourse;
    private Course nextCourse;
    private int courseCount;
    private int totalStudentCount;

    public DoublyLinkedList(int courseCount, int totalStudentCount) {
        this.courseCount = courseCount;
        this.totalStudentCount = totalStudentCount;
    }

    public Course getPrevCourse() {
        return prevCourse;
    }

    public void setPrevCourse(Course prevCourse) {
        this.prevCourse = prevCourse;
    }

    public Course getNextCourse() {
        return nextCourse;
    }

    public void setNextCourse(Course nextCourse) {
        this.nextCourse = nextCourse;
    }

    public void deleteCourse(Course course) {
        var previous = course.getPreviousCourse();
        var next = course.getNextCourse();

        if (head == null) {
            System.out.println("List is empty");
        } else if (course == head) {//If it's the first element
            head.setNextCourse(null);
        } else if (previous != null && next != null) {//Suggests it's in the middle
            previous.setNextCourse(next);
        } else if (previous != null && next == null) {//Suggesting its last
            previous.setNextCourse(null);
        }
    }

    public void insertCourse(Course course) {
        if (head == null) {
            head = course;
        } else {
            Course next = head;
            while (next.getNextCourse() != null) {
                next = next.getNextCourse();
            }
            next.setNextCourse(course);
        }

    }

    public void printCourseList() {
        Course course = head;
        while (course.getNextCourse() != null) {
            System.out.println(course.getCourseName());
            course = course.getNextCourse();
        }

    }

    public Course get(String courseNumber) {
        Course course = head;
        while (course.getNextCourse() != null) {
            if (course.getCourseNumber() == courseNumber) {
                return course;
            }
            course = course.getNextCourse();
        }
        return null;
    }

}
