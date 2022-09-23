import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SinglyLinkedListTest {
    static SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
    static Student student1 = new Student("Flo", "1234", "amoscbkyuac", "web3", new Course("2", "Physics"));
    static Student student2 = new Student("Deathrow", "1264", "jdcyikfkvyu", "web973", new Course("1", "Physics"));
    static Student student3 = new Student("FloBitch", "1254", "amosfagvubkyuac", "web93", new Course("2", "Fred"));

    @BeforeAll
    static void initializeTests() {
        singlyLinkedList.add(student1);
        singlyLinkedList.add(student2);
        singlyLinkedList.add(student3);
    }


    @Test
    void add() {
        Student student = new Student("amol", "234", "xsyuwe", "xSDy", null);
        singlyLinkedList.add(student);
        assertEquals(4, singlyLinkedList.size());
    }

    @Test
    void remove() {
        singlyLinkedList.remove(student1.getId());
        assertEquals(2, singlyLinkedList.size());
    }

    @Test
    void transferStudent() {
    }

    @Test
    void getById() {
        assertEquals("Deathrow", singlyLinkedList.getById("1264").getName());
    }

    @Test
    void getByName() {
        assertEquals("1254", singlyLinkedList.getByName("Flobitch").getId());
    }

    @Test
    void size() {
        assertEquals(3, singlyLinkedList.size());
    }

    @Test
    void contains() {
        assertEquals(true, singlyLinkedList.contains(student3));
    }
}