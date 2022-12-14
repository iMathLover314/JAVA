package lab1;

import java.util.Objects;

/**
 * The type Employee.
 */
public class Employee extends Person
{
    /**
     * The Name position.
     */
    protected final String namePosition;
    /**
     * The id card.
     */
    protected final int idCard;
    /**
     * The Salary.
     */
    protected final int salary;

    /**
     * Gets name position.
     *
     * @return the name position
     */
    public String getNamePosition() {
        return namePosition;
    }

    /**
     * Gets id card.
     *
     * @return the id card
     */
    public int getIdCard() {
        return idCard;
    }

    /**
     * Gets salary.
     *
     * @return the salary
     */
    public int getSalary() {
        return salary;
    }


    /**
     * Instantiates a new Employee.
     *
     * @param EB the eb
     */
    public Employee(EmployeeBuilder EB) {
        super(EB);
        this.namePosition = EB.namePosition;
        this.idCard = EB.idCard;
        this.salary = EB.salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return idCard == employee.idCard && salary == employee.salary && Objects.equals(namePosition, employee.namePosition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(namePosition, idCard, salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "namePosition='" + namePosition + '\'' +
                ", idCard=" + idCard +
                ", salary=" + salary +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }

    /**
     * The type Employee builder.
     */
    public final static class EmployeeBuilder extends PersonBuilder
    {
        /**
         * The Name position.
         */
        protected String namePosition;
        /**
         * The Id card.
         */
        protected int idCard;
        /**
         * The Salary.
         */
        protected int salary;

        /**
         * Instantiates a new Employee builder.
         */
        public EmployeeBuilder(){};

        /**
         * Sets name position.
         *
         * @param namePosition the name position
         * @return the name position
         */
        public EmployeeBuilder setNamePosition(String namePosition) {
            this.namePosition = namePosition;
            return this;
        }

        /**
         * Sets id card.
         *
         * @param idCard the id card
         * @return the id card
         */
        public EmployeeBuilder setIdCard(int idCard) {
            this.idCard = idCard;
            return this;
        }

        /**
         * Sets salary.
         *
         * @param salary the salary
         * @return the salary
         */
        public EmployeeBuilder setSalary(int salary) {
            this.salary = salary;
            return this;
        }
        public Person build()
        {
            return new Employee(this);
        };
    }
}
