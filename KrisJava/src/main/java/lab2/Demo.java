package lab2;

import lab2.Objects.Employee;
import lab2.Objects.Person;
import lab2.serialize.SerializeToJSON;
import lab2.serialize.SerializeToTxt;
import lab2.serialize.SerializeToXml;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        Employee empl1 = new Employee("Administrator", 1001, 20000, new Person("Oleg","Buendok",19));
        Employee empl2 = new Employee("Cleaner", 1002, 15000, new Person("Aleks","Abalduy",25));

        List<Employee> myList = new ArrayList<>();
        myList.add(empl1);
        myList.add(empl2);

        SerializeToJSON serializerJSON = new SerializeToJSON();
        SerializeToXml serializerToXml = new SerializeToXml();
        SerializeToTxt serializerToTxt = new SerializeToTxt();


        System.out.println("JSON:");
        serializerJSON.writeToFile(myList,"testJSON.json");
        System.out.println(serializerJSON.readFromFile("testJSON.json"));

        System.out.println("XML:");
        serializerToXml.writeToFile(myList,"testXML.xml");
        System.out.println(serializerToXml.readFromFile("testXML.xml"));

        System.out.println("TXT:");
        serializerToTxt.writeToFile(myList,"testTXT.txt");
        System.out.println(serializerToTxt.readFromFile("testTXT.txt"));
    }
}