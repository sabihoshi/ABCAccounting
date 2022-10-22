import java.util.Scanner;
import java.util.stream.Stream;

public class TeacherList {
    private final Scanner numberInput = new Scanner(System.in);

    public void menu() {
        while (true) {
            System.out.println("----------------------------------------------");
            System.out.println("                Teacher Menu                  ");
            System.out.println("----------------------------------------------");

            System.out.println("[1] - Add new teacher");
            System.out.println("[2] - Update teacher");
            System.out.println("[3] - Delete teacher");
            System.out.println("[4] - Calculate salary of a teacher");
            System.out.println("[5] - Show all teachers");
            System.out.println("[6] - Exit");
            System.out.print("Enter choice: ");
            int choice = numberInput.nextInt();

            System.out.println("----------------------------------------------");
            switch (choice) {
                case 1:
                    System.out.println("                Add New Teacher               ");
                    System.out.println("----------------------------------------------");
                    addTeacher();
                    break;
                case 2:
                    System.out.println("                Update Teacher                ");
                    System.out.println("----------------------------------------------");
                    updateTeacher();
                    break;
                case 3:
                    System.out.println("                Delete Teacher                ");
                    System.out.println("----------------------------------------------");
                    deleteTeacher();
                    break;
                case 4:
                    System.out.println("         Calculate Salary of a Teacher        ");
                    System.out.println("----------------------------------------------");
                    calculateSalary();
                    break;
                case 5:
                    System.out.println("              Show All Teachers               ");
                    System.out.println("----------------------------------------------");
                    showAllTeachers();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice\n");
            }
        }
    }

    private void showAllTeachers() {
        Stream<Teacher> teachers = Main.people.stream()
                .filter(person -> person instanceof Teacher)
                .map(person -> (Teacher) person);

        displayTeachers(teachers);
    }

    private void displayTeachers(Stream<Teacher> teachers) {
        System.out.println("ID       | Name                            | Gender | Department | Designation     | Phone Number | Address                         ");
        System.out.println("---------+---------------------------------+--------+------------+-----------------+--------------+---------------------------------");
        teachers.forEach(teacher -> System.out.printf("%-8s | %-31s | %-6s | %-10s | %-15s | %-12s | %-31s\n",
                teacher.getId(), teacher.getFirstName() + " " + teacher.getLastName(),
                teacher.getGender(), teacher.getDepartment(), teacher.getDesignation(),
                teacher.getPhoneNumber(), teacher.getAddress()));
    }

    private void calculateSalary() {
        Teacher teacher = findTeacher();

        System.out.print("Enter hours worked: ");
        int hours = numberInput.nextInt();

        double salary = teacher.getSalary(hours);
        System.out.printf("\nSalary of %s is %.2f\n\n", teacher.getFirstName() + " " + teacher.getLastName(), salary);
    }

    private Teacher findTeacher() {
        while (true) {
            System.out.print("Enter teacher ID: ");
            int id = numberInput.nextInt();

            for (Person person : Main.people) {
                if (person instanceof Teacher && person.getId() == id) {
                    return (Teacher) person;
                }
            }
            System.out.println("\nTeacher not found\n");
        }
    }

    private void deleteTeacher() {
        Teacher teacher = findTeacher();
        Main.people.remove(teacher);
        System.out.println("\nTeacher deleted!\n");
    }

    private void updateTeacher() {
        Teacher teacher = findTeacher();
        Teacher.setTeacherDetails(teacher);
    }

    private void addTeacher() {
        Teacher teacher = new Teacher();
        Teacher.setTeacherDetails(teacher);
        Main.people.add(teacher);
    }
}
