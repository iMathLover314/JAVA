package lab1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Objects;

import static org.testng.Assert.assertEquals;

public class Lab1Test
{
    @Test(dataProvider = "equalObjectsTest")
    public void equalObjectsTestProvider(Person obj1, Person obj2, boolean res)
    {
        assertEquals(Objects.equals(obj1,obj2),res);
    }
    @DataProvider
    public Object[][] equalObjectsTest()
    {
        Employee.EmployeeBuilder EB = new Employee.EmployeeBuilder();
        EB.setName("Oleg");
        EB.setSurname("Buendok");
        EB.setAge(19);
        EB.setIdCard(1001);
        EB.setNamePosition("Administrator");
        EB.setSalary(20000);
        Employee empl1 = (Employee) EB.build();

        EB.setName("Bogdan");
        EB.setSurname("Mazurok");
        EB.setAge(25);
        EB.setIdCard(10002);
        EB.setNamePosition("Cleaner");
        EB.setSalary(15000);
        Employee empl2 = (Employee) EB.build();

        Client.ClientBuilder CB = new Client.ClientBuilder();
        CB.setName("Matvei");
        CB.setSurname("Mulark");
        CB.setAge(30);
        CB.setPhoneNumber("0993254321");
        CB.setIdOrder(1);
        Client client1 = (Client) CB.build();

        CB.setName("Oleg");
        CB.setSurname("Mazurok");
        CB.setAge(25);
        CB.setPhoneNumber("0953377166");
        CB.setIdOrder(2);
        Client client2 = (Client) CB.build();
        return new Object[][]{{empl1,empl2,false}, {empl1,empl1,true}, {client1,client2,false},{client1,client1,true}};
    }
    @Test(dataProvider = "hashEqualPersons")
        public void hashEqualPersonsProvider(Person obj1,Person obj2)
        {
            assertEquals(obj1.hashCode(),obj2.hashCode());
    }
    @DataProvider
    public Object[][] hashEqualPersons()
    {
        Employee.EmployeeBuilder EB = new Employee.EmployeeBuilder();
        EB.setName("Oleg");
        EB.setSurname("Buendok");
        EB.setAge(19);
        EB.setIdCard(1001);
        EB.setNamePosition("Administrator");
        EB.setSalary(20000);
        Employee empl1 = (Employee) EB.build();
        Employee empl2 = (Employee) EB.build();
        return new Object[][]{{empl1,empl2}};
    }

}
