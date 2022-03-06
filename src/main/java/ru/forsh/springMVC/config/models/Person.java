package ru.forsh.springMVC.config.models;


import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Person {
    private int id;

    @NotEmpty(message = "Введите имя")
    @Size(min = 2, max = 30, message = "Имя должно быть от 2х до 30 знаков")
    private String name;

    @NotEmpty(message = "Почта не должна быть пустой")
    @Email(message = "email должен быть корректным")
    private String email;

    @Min(value = 0, message = "Возраст указан некорректно")
    private int age;

    public Person() {

    }

    public Person(int id, String name, int age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
