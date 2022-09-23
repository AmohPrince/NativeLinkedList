public interface SinglyLinkedListInterface extends LinkedList {
    Student getById(String studentId);

    Student getByName(String studentName);

    boolean add(Student student);

    boolean contains(Student student);

    boolean remove(String id);

}
