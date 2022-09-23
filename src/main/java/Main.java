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
    
}
