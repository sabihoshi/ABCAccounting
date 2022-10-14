import java.util.Scanner;
import java.util.stream.Stream;

public class StudentList {

    protected final Scanner numberInput = new Scanner(System.in);

    public void menu() {
        while (true) {
            System.out.println("--------Student Menu--------");
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

            System.out.println("----------------------------");
            switch (choice) {
                case 1:
                    System.out.println("Add new student");
                    addStudent();
                    break;
                case 2:
                    System.out.println("Update student");
                    updateStudent();
                    break;
                case 3:
                    System.out.println("Delete student");
                    deleteStudent();
                    break;
                case 4:
                    System.out.println("Show remaining balance");
                    showBalance();
                    break;
                case 5:
                    System.out.println("Fee deposit");
                    feeDeposit();
                    break;
                case 6:
                    System.out.println("Display all student with zero balance");
                    displayZeroBalance();
                    break;
                case 7:
                    System.out.println("Display all student with non - zero balance");
                    displayNonZeroBalance();
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Invalid choice");
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
                student.getAmountPaid(), student.getTuition(),
                student.getModuleCount(), student.getModuleRepeat(),
                student.getPhoneNumber(), student.getAddress()));
    }

    private void feeDeposit() {
        Student student = findStudent();
        student.manageStudent();
    }

    public void addStudent() {
        Student student = new Student();
        Student.setStudentDetails(student);

        Main.people.add(student);
    }

    public void updateStudent() {
        Student.setStudentDetails(findStudent());
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
            System.out.println("Student not found");
        }
    }

    public void showBalance() {
        Student student = findStudent();
        System.out.println("Remaining balance: " + student.getRemainingBalance());
    }

    public void deleteStudent() {
        Student student = findStudent();
        Main.people.remove(student);
    }
}
