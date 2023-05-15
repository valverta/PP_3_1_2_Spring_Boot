package ru.javamentor.PP_3_1_2_Spring_Boot.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @NotBlank(message = "Имя не должно быть пустым")
    @Size(min=2, max = 20, message = "В имени должно быть от 2 до 20 символов")
    @Pattern(regexp = "[A-Za-zА-Яа-яЁё]+", message = "Имя должно состоять только из букв английского или русского алфавита")
    private String name;

    @Column(name = "surname")
    @NotBlank(message = "Фамилия не должна быть пустой")
    @Size(min=2, max = 30, message = "В фамилии должно быть от 2 до 30 символов")
    @Pattern(regexp = "[A-Za-zА-Яа-яЁё]+", message = "Фамилия должна состоять только из букв английского или русского алфавита")
    private String surname;

    @Column(name = "age")
    @Min(value = 0, message = "Возраст не должен быть меньше 0")
    @Max(value = 122, message = "Возраст не должен быть больше 122")
    private int age;

    public User() {}

    public User(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}