public class Teacher extends Person {
    private String Department;
    private Designation designation;
    private int hours;

    public static void setTeacherDetails(Teacher t) {
        setPersonDetails(t);

        // Enter department, it can only be business and computing
        Boolean repeat = true;
        while (repeat) {
            System.out.print("Enter department (Business or Computing)): ");
            String department = stringInput.nextLine();

            // Use switch
            switch (department.toUpperCase()) {
                case "BUSINESS":
                    t.setDepartment("Business");
                    repeat = false;
                    break;
                case "COMPUTING":
                    t.setDepartment("Computing");
                    repeat = false;
                    break;
                default:
                    System.out.println("\nInvalid department\n");
                    break;
            }
        }

        while (true) {
            System.out.print("Enter designation (HOF, CO, or L): ");
            String designation = stringInput.nextLine();

            // If not HOF, CO, or L, ask again
            if (!designation.equalsIgnoreCase("HOF") && !designation.equalsIgnoreCase("CO") && !designation.equalsIgnoreCase("L")) {
                System.out.println("\nInvalid designation!\n");
            } else {
                t.setDesignation(Designation.getDesignation(designation));
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

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }
}