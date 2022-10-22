import java.util.Scanner;
import java.util.stream.Stream;

public class StudentList {

    protected final Scanner numberInput = new Scanner(System.in);

    public void menu() {
        while (true) {
            System.out.println("----------------------------------------------");
            System.out.println("                Student Menu                  ");
            System.out.println("----------------------------------------------");

            System.out.println("[1] - Add new student");
            System.out.println("[2] - Update student");
            System.out.println("[3] - Delete student");
            System.out.println("[4] - Show remaining balance");
            System.out.println("[5] - Fee deposit");
            System.out.println("[6] - Display all student with zero balance");
            System.out.println("[7] - Display all student with non-zero balance");
            System.out.println("[8] - Exit");
            System.out.print("Enter choice: ");
            int choice = numberInput.nextInt();

            System.out.println("----------------------------------------------");
            switch (choice) {
                case 1:
                    System.out.println("                Add New Student               ");
                    System.out.println("----------------------------------------------");
                    addStudent();
                    break;
                case 2:
                    System.out.println("                Update Student                ");
                    System.out.println("----------------------------------------------");
                    updateStudent();
                    break;
                case 3:
                    System.out.println("                Delete Student                ");
                    System.out.println("----------------------------------------------");
                    deleteStudent();
                    break;
                case 4:
                    System.out.println("            Show Remaining Balance            ");
                    System.out.println("----------------------------------------------");
                    showBalance();
                    break;
                case 5:
                    System.out.println("                Fee Deposit                   ");
                    System.out.println("----------------------------------------------");
                    feeDeposit();
                    break;
                case 6:
                    System.out.println("    Display All Student with Zero Balance     ");
                    System.out.println("----------------------------------------------");
                    displayZeroBalance();
                    break;
                case 7:
                    System.out.println(" Display All Student with Non - Zero Balance  ");
                    System.out.println("----------------------------------------------");
                    displayNonZeroBalance();
                    break;
                case 8:
                    return;
                default:
                    System.out.println("\nInvalid choice\n");
            }
        }
    }

    private void displayNonZeroBalance() {
        Stream<Student> nonZeroBalance = Main.people.stream()
                .filter(person -> person instanceof Student)
                .map(person -> (Student) person)
                .filter(student -> student.getRemainingBalance() > 0);

        displayStudents(nonZeroBalance);
    }

    private void displayZeroBalance() {
        Stream<Student> zeroBalance = Main.people.stream()
                .filter(p -> p instanceof Student)
                .map(p -> (Student) p)
                .filter(s -> s.getRemainingBalance() == 0);

        displayStudents(zeroBalance);
    }

    private void displayStudents(Stream<Student> students) {
        System.out.println("ID       | Name                            | Gender | Balance | Tuition | Modules | Repeats | Phone Number | Address                         ");
        System.out.println("---------+---------------------------------+--------+---------+---------+---------+---------+--------------+---------------------------------");
        students.forEach(student -> System.out.printf("%-8d | %-31s | %-6s | %-7.2f | %-7.2f | %-7d | %-7d | %-12d | %-31s%n",
                student.getId(),
                student.getFirstName() + " " + student.getLastName(), student.getGender(),
                student.getRemainingBalance(), student.getTuition(),
                student.getModuleCount(), student.getModuleRepeat(),
                student.getPhoneNumber(), student.getAddress()));
        System.out.println("\n");
    }

    private void feeDeposit() {
        Student student = findStudent();
        student.manageStudent();
    }

    public void addStudent() {
        Student student = new Student();
        Student.setStudentDetails(student);

        Main.people.add(student);

        System.out.print("\nSTUDENT ADDED SUCCESSFULLY!\n\n");
    }

    public void updateStudent() {
        Student.setStudentDetails(findStudent());
        System.out.println("\nSTUDENT SUCCESSFULLY UPDATED!\n");
    }

    private Student findStudent() {
        while (true) {
            System.out.print("Enter student ID: ");
            int id = numberInput.nextInt();

            for (Person person : Main.people) {
                if (person instanceof Student && person.getId() == id) {
                    return (Student) person;
                }
            }
            System.out.println("\nStudent not found\n");
        }
    }

    public void showBalance() {
        Student student = findStudent();
        System.out.println("\nRemaining balance: " + student.getRemainingBalance() + "\n");
    }

    public void deleteStudent() {
        Student student = findStudent();
        Main.people.remove(student);
        System.out.println("\nSTUDENT INFORMATION SUCCESSFULLY DELETED!\n");
    }
}
