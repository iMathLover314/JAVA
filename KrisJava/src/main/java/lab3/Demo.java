package lab3;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        Employee empl1 = new Employee("Cleaner", 1002, 20000, new Person("Oleg","Buendok"));
        Employee empl2 = new Employee("Administrator", 1001, 15000, new Person("Aleks","Abalduy"));
        Employee empl3 = new Employee("Waiter", 1003, 10000, new Person("Serg","Rinkachiruku"));
        Employee empl4 = new Employee("Waiter", 1004, 10000, new Person("Anton","Djatlov"));
        Employee empl5 = new Employee("Dishwasher", 1005, 11000, new Person("Vlad","Martiniuk"));

        System.out.println("Comparable(sort by namePosition)");
        TreeSet<Employee> myList = new TreeSet<>();
        myList.add(empl1);
        myList.add(empl2);
        myList.add(empl3);

        for(Employee item : myList)
        {
            System.out.println(item);
        }
        System.out.println("\n");

        System.out.println("Comparator(sort by salary)");
        List<Employee>list1 = new ArrayList<>();
        list1.add(empl1);
        list1.add(empl2);
        list1.add(empl3);
        list1.add(empl4);
        list1.add(empl5);
        Comparator salaryComparator = new EmployeeComparator();
        Collections.sort(list1,salaryComparator);
        for(Employee item : list1)
        {
            System.out.println(item);
        }
        System.out.println("\n");

        System.out.println("Comparator stream API(sort by idCard)");
        List<Employee>list2 = new ArrayList<>();
        list2.add(empl1);
        list2.add(empl2);
        list2.add(empl3);
        list2 = list2.stream().sorted(Comparator.comparingInt(Employee::getIdCard)).collect(Collectors.toList());
        for(Employee item : list2)
        {
            System.out.println(item);
        }

        System.out.println("\nEmployeeService");
        List<Employee> employees = new ArrayList<>();
        employees.addAll(list1);
        EmployeeService employeeService = new EmployeeService(employees);

        System.out.println("\ngetEmployeesByName");
        for(Employee e : employeeService.getEmployeesByName("Serg"))
        {
            System.out.println(e);
        }

        System.out.println("\ngetEmployeesBySurname");
        for(Employee e : employeeService.getEmployeesBySurname("Abalduy"))
        {
            System.out.println(e);
        }

        System.out.println("\ngetEmployeesBySalary");
        for(Employee e : employeeService.getEmployeesBySalary(10000))
        {
            System.out.println(e);
        }

        System.out.println("\ngetEmployeesByPosition");
        for(Employee e : employeeService.getEmployeesByPosition("Waiter"))
        {
            System.out.println(e);
        }
    }
}