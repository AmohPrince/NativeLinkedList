import java.util.Scanner;

public class Main {
    static boolean exit = false;

    public static void main(String[] args) {
        run();
    }

    static void run() {
        Engine engine = new Engine();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome, Choose from the below menu by typing appropriate numbers");
        engine.showMenu();
        int choice = scanner.nextInt();
        if (choice == 1) {
            engine.printInputData();
        } else if (choice == 2) {
            engine.deleteCourse();
            engine.printInputData();
        } else if (choice == 3) {
            engine.insertNewCourse();
            engine.printInputData();
        } else if (choice == 4) {
            engine.deleteStudent();
            engine.printInputData();
        } else if (choice == 5) {
            engine.createNewStudent();
            engine.printInputData();
        } else if (choice == 6) {
            engine.changeStudentCourse();
        } else if (choice == 7) {
            engine.displayCourseList();
        } else if (choice == 8) {
            engine.displayStudentList();
        } else if (choice == 9) {
            System.exit(2);
        }
    }


//    public static void main(String[] args) {
//        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
//        singlyLinkedList.insert(new Student("Flo", "1234", "amoscbkyuac", "web3", new Course("2", "Physics", 10)));
//        singlyLinkedList.insert(new Student("Deathrow", "1264", "jdcyikfkvyu", "web973", new Course("1", "Physics", 10)));
//        singlyLinkedList.insert(new Student("FloBitch", "1254", "amosfagvubkyuac", "web93", new Course("2", "Fred", 2)));
//        singlyLinkedList.displayAsList("1");

//        System.out.println(singlyLinkedList.size());
//        singlyLinkedList.printAll();
//        System.out.println(singlyLinkedList.get("1254"));
//        Engine engine = new Engine();
//        engine.debug();
//        engine.displayStudentList();

//        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
//        doublyLinkedList.insertCourse(new Course("CS�4883", "Death", 20));
//        doublyLinkedList.insertCourse(new Course("2", "Row", 10));
//        doublyLinkedList.insertCourse(new Course("3", "Bitch", 40));
//
//        System.out.println(doublyLinkedList.get("3").getCourseName());
//        System.out.println(doublyLinkedList.contains(new Course("CS 4883", "Bitch", 40)));
//    }


}
