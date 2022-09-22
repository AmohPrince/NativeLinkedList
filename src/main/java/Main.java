import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Engine engine = new Engine();
        try {
            engine.begin();
        } catch (IOException ioException) {
            System.out.println("Something went terribly wrong");
        }
        System.out.println("Welcome, Choose from the below menu by typing appropriate numbers");
        System.out.print("1. Read the input data\n" +
                "2. Delete a course\n" +
                "3. Insert a new course\n" +
                "4. Delete a student\n" +
                "5. Insert a new student\n" +
                "6. Transfer a student from one course to another\n" +
                "7. Display the course list\n" +
                "8. Display the student list\n" +
                "9. Exit");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                Engine.printInputData();
        }
    }
}
