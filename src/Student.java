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

            // If less than 1 or greater than 6, ask again
            if (s.getModuleCount() < 1 || s.getModuleCount() > 6) {
                System.out.println("The amount of modules must be 1-6!");
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
            s.setAmountPaid(numberInput.nextFloat());

            // If less than 0 or greater than tuition, ask again
            if (s.getAmountPaid() < 0 || s.getAmountPaid() > s.getTuition()) {
                System.out.println("The amount paid must be 0-" + s.getTuition() + "!");
            } else {
                break;
            }
        }

        System.out.println("Tuition paid successfully!");
        System.out.println("Remaining balance: " + s.getTuition());
    }

    public float getRemainingBalance() {
        return getTuition() - getAmountPaid();
    }

    public void manageStudent() {
        while (true) {
            System.out.println("--------Student Management--------");
            System.out.println("[1] - Encode New / Repeated Modules");
            System.out.println("[2] - Tuition Payment");
            System.out.println("[3] - Exit");
            System.out.print("Enter choice: ");
            int choice = choice = numberInput.nextInt();
            System.out.println("---------------------------");
            switch (choice) {
                case 1:
                    manageModules(this);
                    break;
                case 2:
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

    /**
     * Sets the amount of modules the student is taking
     *
     * @param moduleCount the moduleCount to set
     * @throws IllegalArgumentException if moduleCount is less than 0 or greater than 6
     */
    public void setModuleCount(int moduleCount) {
        if (moduleCount < 0 || moduleCount > 6) {
            System.out.println("The amount of modules must be 0 -6!");
            throw new IllegalArgumentException();
        } else {
            this.moduleCount = moduleCount;
        }
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