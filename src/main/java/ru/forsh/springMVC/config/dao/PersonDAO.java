package ru.forsh.springMVC.config.dao;

import org.springframework.stereotype.Component;
import ru.forsh.springMVC.config.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {

        people = new ArrayList<>(List.of(new Person(++PEOPLE_COUNT, "Kolya"),
                new Person(++PEOPLE_COUNT, "Lera"),
                new Person(++PEOPLE_COUNT, "Misha")));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {

        return people.stream()
                .filter(person -> person.getId() == id)
                .findAny()
                .orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);

    }
}
