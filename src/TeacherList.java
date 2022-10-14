import java.util.Scanner;
import java.util.stream.Stream;

public class TeacherList {
    protected final Scanner numberInput = new Scanner(System.in);
    protected final Scanner stringInput = new Scanner(System.in);

    public void menu() {
        while (true) {
            System.out.println("--------Teacher Menu--------");
            System.out.println("[1] - Add new teacher");
            System.out.println("[2] - Update teacher");
            System.out.println("[3] - Delete teacher");
            System.out.println("[4] - Calculate salary of a teacher");
            System.out.println("[5] - Show all teachers");
            System.out.println("[6] - Exit");
            System.out.print("Enter choice: ");
            int choice = numberInput.nextInt();

            System.out.println("----------------------------");
            switch (choice) {
                case 1:
                    System.out.println("Add new teacher");
                    addTeacher();
                    break;
                case 2:
                    System.out.println("Update teacher");
                    updateTeacher();
                    break;
                case 3:
                    System.out.println("Delete teacher");
                    deleteTeacher();
                    break;
                case 4:
                    System.out.println("Calculate salary of a teacher");
                    calculateSalary();
                    break;
                case 5:
                    System.out.println("Show all teachers");
                    showAllTeachers();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private void showAllTeachers() {
        Stream<Teacher> teacherStream = Main.people.stream().filter(person -> person instanceof Teacher).map(person -> (Teacher) person);
        if (teacherStream.findAny().isPresent()) {
            displayTeachers(teacherStream);
        } else {
            System.out.println("No teachers found");
        }
    }

    private void displayTeachers(Stream<Teacher> teachers) {
        System.out.println("ID       | Name                            | Designation | Phone Number");
        System.out.println("-------------------------------------------------------------------");
        teachers.forEach(teacher -> {
            System.out.printf("%-9s| %-30s| %-12s| %s%n",
                    teacher.getId(), teacher.getFirstName() + " " + teacher.getLastName(),
                    teacher.getDesignation(), teacher.getPhoneNumber());
        });
    }

    private void calculateSalary() {
        Teacher teacher = findTeacher();

        System.out.print("Enter hours worked: ");
        int hours = numberInput.nextInt();

        double salary = teacher.getSalary(hours);
        System.out.printf("Salary of %s is %.2f%n", teacher.getFirstName() + " " + teacher.getLastName(), salary);
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
            System.out.println("Teacher not found");
        }
    }

    private void deleteTeacher() {
        Teacher teacher = findTeacher();
        Main.people.remove(teacher);
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
