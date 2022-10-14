public class Student extends Person {
    private int moduleCount;
    private int moduleRepeat;
    private float amountPaid;

    public static void setStudentDetails(Student s) {
        setPersonDetails(s);
        manageModules(s);
        manageTuition(s);
    }

    public static void manageModules(Student s) {
        while (true) {
            System.out.print("Enter module count: ");
            s.setModuleCount(numberInput.nextInt());

            // If less than 0 or greater than 6, ask again
            if (s.getModuleCount() < 0 || s.getModuleCount() > 6) {
                System.out.println("The amount of modules must be 0-6!");
            } else {
                break;
            }
        }

        while (true) {
            System.out.print("Enter module repeat: ");
            s.setModuleRepeat(numberInput.nextInt());

            // If less than 0 or greater than 2 or the amount of modules, ask again
            if (s.getModuleRepeat() < 0 || s.getModuleRepeat() > 2 || s.getModuleRepeat() > s.getModuleCount()) {
                System.out.println("The amount of modules repeated must be 0-2 and less than the amount of modules!");
            } else {
                break;
            }
        }
    }

    public static void manageTuition(Student s) {
        while (true) {
            System.out.print("Enter amount paid: ");
            float paid = numberInput.nextFloat();

            // If less than 0 or greater than tuition, ask again
            if (paid < 0 || paid > s.getRemainingBalance()) {
                System.out.println("The amount paid must be 0-" + s.getRemainingBalance() + "!");
            } else {
                s.setAmountPaid(paid + s.getAmountPaid());
                break;
            }
        }

        System.out.println("Tuition paid successfully!");
        System.out.println("Remaining balance: " + s.getRemainingBalance());
    }

    public float getRemainingBalance() {
        return getTuition() - getAmountPaid();
    }

    public void manageStudent() {
        while (true) {
            System.out.println("----------------------------------------------");
            System.out.println("             Student Management               ");
            System.out.println("----------------------------------------------");

            System.out.println("[1] - Encode New / Repeated Modules");
            System.out.println("[2] - Tuition Payment");
            System.out.println("[3] - Exit");
            System.out.print("Enter choice: ");
            int choice = numberInput.nextInt();

            System.out.println("----------------------------------------------");
            switch (choice) {
                case 1:
                    System.out.println("       Encode New / Repeated Modules          ");
                    System.out.println("----------------------------------------------");
                    manageModules(this);
                    break;
                case 2:
                    System.out.println("                 Tuition Payment              ");
                    System.out.println("----------------------------------------------");
                    manageTuition(this);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    public int getModuleCount() {
        return moduleCount;
    }

    public void setModuleCount(int moduleCount) {
        this.moduleCount = moduleCount;
    }

    public int getModuleRepeat() {
        return moduleRepeat;
    }

    public void setModuleRepeat(int moduleRepeat) {
        this.moduleRepeat = moduleRepeat;
    }

    public float getTuition() {
        int newModules = moduleCount - moduleRepeat;
        return (525 * newModules) + (110 * moduleRepeat);
    }

    public float getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(float amountPaid) {
        this.amountPaid = amountPaid;
    }
}
