import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DoublyLinkedListTest {

    static DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
    static Course course1 = new Course("CS�4883", "Death");
    static Course course2 = new Course("2", "Row");
    static Course course3 = new Course("3", "Bitch");

    @BeforeAll
    static void initializeTests() {
        doublyLinkedList.add(course1);
        doublyLinkedList.add(course2);
        doublyLinkedList.add(course3);
    }

    @Test
    void remove() {
        doublyLinkedList.remove(course1.getCourseNumber());
        assertEquals(2, doublyLinkedList.size());
    }

    @Test
    void add() {
        Course courseTest = new Course("456", "Delle");
        doublyLinkedList.add(courseTest);
        assertEquals(4, doublyLinkedList.size());
    }

    @Test
    void getByCourseNumber() {
        assertEquals("Death", doublyLinkedList.getByCourseNumber("CS�4883").getCourseName());
    }

    @Test
    void getByCourseName() {
        assertEquals("2", doublyLinkedList.getByCourseName("Row").getCourseNumber());
    }

    @Test
    void contains() {
        assertEquals(course1.getCourseName(), "Death");
    }

    @Test
    void size() {
        assertEquals(3, doublyLinkedList.size());
    }
}