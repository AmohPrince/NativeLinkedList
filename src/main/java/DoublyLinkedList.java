public class DoublyLinkedList implements DoublyLinkedListInterface {
    private Course head;
    private Course prevCourse;
    private Course nextCourse;
    private int courseCount;
    private int totalStudentCount;

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

    public boolean remove(String courseNumber) {
        var course = getByCourseNumber(courseNumber);
        var next = course.getNextCourse();
        var previous = course.getPreviousCourse();

        if (head == null) {
            System.out.println("List is empty");
        } else if (course == head) {//If it's the first element
            head.setNextCourse(null);
        } else if (previous != null && next != null) {//Suggests it's in the middle
            previous.setNextCourse(next);
        } else if (previous != null && next == null) {//Suggesting its last
            previous.setNextCourse(null);
        }
        return false;
    }

    public boolean add(Course course) {
        if (head == null) {
            head = course;
        } else {
            Course next = head;
            while (next.getNextCourse() != null) {
                next = next.getNextCourse();
            }
            next.setNextCourse(course);
            return true;
        }

        return false;
    }

    public void printCourseList() {
        Course course = head;
        System.out.println("The list of courses registered are as follows:");
        while (course.getNextCourse() != null) {
            System.out.println(String.format("Course Number: %s", course.getCourseName()));
            System.out.println(String.format("Course Name: %s", course.getCourseNumber()));
            System.out.println(String.format("Number of students enrolled: %d", course.getStudentCount()));
            System.out.println();
            System.out.println();
            course = course.getNextCourse();
        }

    }

    public Course getByCourseNumber(String courseNumber) {
        Course course = head;
        while (course.getNextCourse() != null) {
            if (course.getCourseNumber().equals(courseNumber)) {
                return course;
            }
            course = course.getNextCourse();
        }
        if (course.getCourseNumber().equals(courseNumber)) {
            return course;
        }
        return null;
    }

    @Override
    public Course getByCourseName(String courseName) {
        Course course = head;
        while (course.getNextCourse() != null) {
            if (course.getCourseName() == courseName) {
                return course;
            }
            course = course.getNextCourse();
        }
        if (course.getCourseName() == courseName) {
            return course;
        }
        return null;
    }

    public boolean contains(Course toBeInserted) {
        Course course = head;
        while (course.getNextCourse() != null) {
            if (course.getCourseName() == toBeInserted.getCourseName()) {
                System.out.println(course.getCourseName() + " " + toBeInserted.getCourseName());
                return true;
            }
            course = course.getNextCourse();
        }
        if (course.getCourseName() == toBeInserted.getCourseName()) {
            return true;
        }


        return false;
    }

    public void printAll() {
        Course course = head;
        while (course.getNextCourse() != null) {
            System.out.println(course.toString());
            course = course.getNextCourse();
        }
    }

    @Override
    public int size() {
        int i = 0;
        Course course = head;
        while (course.getNextCourse() != null) {
            i++;
            course = course.getNextCourse();
        }
        return i + 1;
    }
}
