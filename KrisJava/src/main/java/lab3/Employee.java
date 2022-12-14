package lab3;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import java.util.Objects;

public class Employee implements Comparable<Employee>
{
    protected String namePosition;
    protected int idCard;
    protected int salary;
    @JsonUnwrapped
    protected Person person;

    public String getNamePosition() {
        return namePosition;
    }

    public void setNamePosition(String namePosition) {
        this.namePosition = namePosition;
    }

    public int getIdCard() {
        return idCard;
    }

    public void setIdCard(int idCard) {
        this.idCard = idCard;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Employee(String namePosition, int idCard, int salary, Person person) {
        this.namePosition = namePosition;
        this.idCard = idCard;
        this.salary = salary;
        this.person = person;
    }

    public Employee() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return idCard == employee.idCard && salary == employee.salary && Objects.equals(namePosition, employee.namePosition) && Objects.equals(person, employee.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(namePosition, idCard, salary, person);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "namePosition='" + namePosition + '\'' +
                ", idCard=" + idCard +
                ", salary=" + salary +
                ", person=" + person +
                '}';
    }

    @Override
    public int compareTo(Employee o) {
        return this.namePosition.compareTo(o.namePosition);
    }
}
