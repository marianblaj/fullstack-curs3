package curs02.people;

import services.Varste;

import java.util.Objects;

public class People {
    private final String firstName;
    private final String lastName;
    private final int age;
    private final Varste varsta;


    public People(String firstName, String lastName, int age, Varste varsta) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.varsta = varsta;
    }

    @Override
    public String toString() {
        return "People{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof People)) return false;
        People people = (People) o;
        return getAge() == people.getAge() &&
                Objects.equals(getFirstName(), people.getFirstName()) &&
                Objects.equals(getLastName(), people.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getAge());
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public Varste getVarsta() {
        return varsta;
    }
}
