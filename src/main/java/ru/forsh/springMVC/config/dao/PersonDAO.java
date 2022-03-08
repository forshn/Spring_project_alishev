package ru.forsh.springMVC.config.dao;

import org.springframework.stereotype.Component;
import ru.forsh.springMVC.config.models.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;

    private static final String URL = "jdbc:postgresql://localhost:5433/first_db";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "Brijxxx3";

    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver")
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Person> index() {
        List<Person> people = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String Sql = "SELECT * FROM Person";
            ResultSet resultSet = statement.executeQuery(Sql);

            while(resultSet.next()){
                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setAge(resultSet.getInt("age"));
                person.setEmail(resultSet.getString("email"));

                people.add(person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return people;
    }

    public Person show(int id) {

      //  return people.stream()
       //         .filter(person -> person.getId() == id)
         //       .findAny()
           //     .orElse(null);
        return null;
    }

    public void save(Person person) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement
                    .executeQuery
                            ("INSERT INTO person VALUES (" + 1 + ")");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*public void update(int id, Person updatedPerson) {
         Person personToBeUpdated = show(id);
         personToBeUpdated.setName(updatedPerson.getName());
         personToBeUpdated.setAge(updatedPerson.getAge());
         personToBeUpdated.setEmail(updatedPerson.getEmail());

    }*/

    /*public void delete(int id) {
        people.removeIf(person -> person.getId() == id);
    }*/
}
