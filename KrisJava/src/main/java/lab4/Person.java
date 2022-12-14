package lab4;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Objects;

abstract public class Person {
    protected final String name;
    protected final String surname;

    Person(PersonBuilder PB)
    {
        this.name = PB.name;
        this.surname = PB.surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(surname, person.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }

    static abstract class PersonBuilder
    {
        @NotNull
        protected String name;
        @NotNull
        protected String surname;

        public PersonBuilder setName(String name)
        {
            this.name = name;
            return this;
        }

        public PersonBuilder setSurname(String surname)
        {
            this.surname = surname;
            return this;
        }


        abstract public Person build();
    }
}
