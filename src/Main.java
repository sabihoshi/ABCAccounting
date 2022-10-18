import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static final List<Person> people = new ArrayList<>();
    private static final Scanner input = new Scanner(System.in);
    private static final StudentList student = new StudentList();
    private static final TeacherList teacher = new TeacherList();

    public static void main(String[] args) {
        boolean repeat = true;
        while (repeat) {
            System.out.println("-------------------");
            System.out.println("     Main Menu     ");
            System.out.println("-------------------");
            System.out.println("[1] Manage Students");
            System.out.println("[2] Manage Teachers");
            System.out.println("[3] Exit");
            System.out.print("Enter choice: ");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    student.menu();
                    break;
                case 2:
                    teacher.menu();
                    break;
                case 3:
                    System.out.println("\nProgram terminated!\n");
                    repeat = false;
                    break;
                default:
                    System.out.println("\nInvalid choice\n");
            }
        }
    }

}