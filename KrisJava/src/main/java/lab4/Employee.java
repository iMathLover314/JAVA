package lab4;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Employee extends Person
{
    protected final String namePosition;
    protected final int idCard;
    protected final int salary;

    public String getNamePosition() {
        return namePosition;
    }

    public int getIdCard() {
        return idCard;
    }

    public int getSalary() {
        return salary;
    }


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
                '}';
    }

    public final static class EmployeeBuilder extends PersonBuilder
    {
        @NotNull
        protected String namePosition;
        @NotNull
        protected int idCard;
        @NotNull
        @Min(value = 10000, message = "MIN SALARY = 10000")
        @Max(value = 100000, message = "MAX SALARY = 100000")
        protected int salary;

        public EmployeeBuilder(){};

        public EmployeeBuilder setNamePosition(String namePosition) {
            this.namePosition = namePosition;
            return this;
        }

        public EmployeeBuilder setIdCard(int idCard) {
            this.idCard = idCard;
            return this;
        }

        public EmployeeBuilder setSalary(int salary) {
            this.salary = salary;
            return this;
        }
        public Person build()
        {
            Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
            Set<ConstraintViolation<EmployeeBuilder>> constraintViolations = validator.validate(this);
            if(constraintViolations.size() > 0) {
                String errors = constraintViolations.stream().map(constraintViolation -> {
                    String fieldName = constraintViolation.getPropertyPath().toString().toUpperCase();
                    String message = constraintViolation.getMessage();
                    return String.join(" : ", fieldName, message);
                }).collect(Collectors.joining("\n"));
                throw new IllegalArgumentException(errors);
            }
            return new Employee(this);
        }
    }
}
