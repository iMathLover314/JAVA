package lab1;

import java.util.Objects;

/**
 * The type Person.
 */
abstract public class Person {
    /**
     * The Name.
     */
    protected final String name;
    /**
     * The Surname.
     */
    protected final String surname;
    /**
     * The Age.
     */
    protected final int age;

    /**
     * Instantiates a new Person.
     *
     * @param PB the pb
     */
    Person(PersonBuilder PB)
    {
        this.name = PB.name;
        this.surname = PB.surname;
        this.age = PB.age;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets surname.
     *
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Gets age.
     *
     * @return the age
     */
    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name) && Objects.equals(surname, person.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }

    /**
     * The type Person builder.
     */
    static abstract class PersonBuilder
    {
        /**
         * The Name.
         */
        protected String name;
        /**
         * The Surname.
         */
        protected String surname;
        /**
         * The Age.
         */
        protected int age;

        /**
         * Sets name.
         *
         * @param name the name
         * @return the name
         */
        public PersonBuilder setName(String name)
        {
            this.name = name;
            return this;
        }

        /**
         * Sets surname.
         *
         * @param surname the surname
         * @return the surname
         */
        public PersonBuilder setSurname(String surname)
        {
            this.surname = surname;
            return this;
        }

        /**
         * Sets age.
         *
         * @param age the age
         * @return the age
         */
        public PersonBuilder setAge(int age)
        {
            this.age = age;
            return this;
        }

        /**
         * Build person.
         *
         * @return the person
         */
        abstract public Person build();
    }
}
