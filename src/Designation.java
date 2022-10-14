public enum Designation {

    HeadOfFaculty {
        public int teachingHours() {
            return 8;
        }
    }, Coordinator {
        public int teachingHours() {
            return 13;
        }
    }, Lecturer {
        public int teachingHours() {
            return 18;
        }
    };

    private static final float baseSalary = 1200.00f;

    public static Designation getDesignation(String designation) {
        switch (designation.toUpperCase()) {
            case "HOF":
                return HeadOfFaculty;
            case "CO":
                return Coordinator;
            case "L":
                return Lecturer;
            default:
                return null;
        }
    }

    public abstract int teachingHours();

    /**
     * Gets the salary of the teacher
     *
     * @param hours The amount of hours the teacher has worked
     * @return The salary of the teacher
     */
    public float getSalary(int hours) {
        int overtime = Math.max(hours - teachingHours(), 0);
        float overtimePay = overtime * 325f;
        float totalSalary = baseSalary + overtimePay;

        return totalSalary
                + getHousingAllowance(totalSalary)
                + getMedicalAllowance(totalSalary)
                + getTravellingAllowance(totalSalary);
    }

    public float getHousingAllowance(float salary) {
        return salary * 0.10f;
    }

    public float getMedicalAllowance(float salary) {
        return salary * 0.03f;
    }

    public float getTravellingAllowance(float salary) {
        return salary * 0.05f;
    }
}
