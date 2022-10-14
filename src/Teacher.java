public class Teacher extends Person {
    private Designation designation;
    private int hours;

    public static void setTeacherDetails(Teacher t) {
        setPersonDetails(t);

        while (true) {
            System.out.print("Enter designation (HOF, CO, or L): ");
            String designation = stringInput.nextLine();

            // If not HOF, CO, or L, ask again
            if (!designation.equalsIgnoreCase("HOF") && !designation.equalsIgnoreCase("CO") && !designation.equalsIgnoreCase("L")) {
                System.out.println("\nInvalid designation!");
            } else {
                t.setDesignation(Designation.getDesignation(designation));
                break;
            }
        }

        while (true) {
            System.out.print("Enter hours: ");
            t.setHours(numberInput.nextInt());

            // If less than 1 or greater than 40, ask again
            if (t.getHours() < 1 || t.getHours() > 40) {
                System.out.println("\nThe amount of hours must be 1-40!");
            } else {
                break;
            }
        }
    }

    /**
     * Gets the salary of the teacher
     *
     * @param hours the hours the teacher has worked
     * @return the salary of the teacher
     */
    public float getSalary(int hours) {
        return designation.getSalary(hours);
    }

    public Designation getDesignation() {
        return designation;
    }

    public void setDesignation(Designation designation) {
        this.designation = designation;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }
}