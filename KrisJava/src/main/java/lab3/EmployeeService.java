package lab3;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeService {
    private List<Employee> emplList;

    public EmployeeService(List<Employee> emplList) {
        this.emplList = emplList;
    }

    public List<Employee> getEmplList() {
        return emplList;
    }

    public void setEmplList(List<Employee> emplList) {
        this.emplList = emplList;
    }
    public List<Employee> getEmployeesByPosition(String position)
    {
        return emplList.stream().filter(employee -> position.equals(employee.namePosition)).collect(Collectors.toList());
    }
    public List<Employee> getEmployeesBySalary(int salary)
    {
        return emplList.stream().filter(employee -> salary == employee.salary).collect(Collectors.toList());
    }
    public List<Employee> getEmployeesByName(String name)
    {
        return emplList.stream().filter(employee -> name.equals(employee.getPerson().getName())).collect(Collectors.toList());
    }
    public List<Employee> getEmployeesBySurname(String surname)
    {
        return emplList.stream().filter(employee -> surname.equals(employee.getPerson().getSurname())).collect(Collectors.toList());
    }
}
