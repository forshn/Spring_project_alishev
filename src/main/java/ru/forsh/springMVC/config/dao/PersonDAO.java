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

        people = new ArrayList<>(List.of(new Person(++PEOPLE_COUNT, "Kolya", 32, "forsh_nikolay@mail.ru"),
                new Person(++PEOPLE_COUNT, "Lera", 28, "bajieska@mail.ru"),
                new Person(++PEOPLE_COUNT, "Misha", 5, "misha@mail.ru")));
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

    public void update(int id, Person updatedPerson) {
         Person personToBeUpdated = show(id);
         personToBeUpdated.setName(updatedPerson.getName());
         personToBeUpdated.setAge(updatedPerson.getAge());
         personToBeUpdated.setEmail(updatedPerson.getEmail());

    }

    public void delete(int id) {
        people.removeIf(person -> person.getId() == id);
    }
}
