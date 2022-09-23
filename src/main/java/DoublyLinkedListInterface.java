public interface DoublyLinkedListInterface extends LinkedList {
    Course getByCourseNumber(String courseNumber);

    Course getByCourseName(String courseName);

    boolean add(Course course);

    boolean contains(Course course);

    boolean remove(String courseNumber);
}
