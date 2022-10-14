import java.util.Scanner;

public class Person {
    protected static final Scanner numberInput = new Scanner(System.in);
    protected static final Scanner stringInput = new Scanner(System.in);

    private int id;
    private String firstName;
    private String lastName;
    private String gender;
    private Long phoneNumber;
    private String address;

    protected static void setPersonDetails(Person p) {
        while (true) {
            System.out.print("Enter new ID: ");
            int id = numberInput.nextInt();

            // If one of the people has this ID, try again
            if (Main.people.stream().anyMatch(s -> s.getId() == id)) {
                System.out.println("\nStudent with this ID already exists!");
            } else {
                p.setId(id);
                break;
            }
        }

        System.out.print("Enter first name: ");
        p.setFirstName(stringInput.nextLine());

        System.out.print("Enter last name: ");
        p.setLastName(stringInput.nextLine());

        System.out.print("Enter gender: ");
        p.setGender(stringInput.nextLine());

        System.out.print("Enter phone number: ");
        p.setPhoneNumber(numberInput.nextLong());

        System.out.print("Enter address: ");
        p.setAddress(stringInput.nextLine());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
