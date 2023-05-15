package ru.javamentor.PP_3_1_2_Spring_Boot.dao;

import ru.javamentor.PP_3_1_2_Spring_Boot.model.User;

import java.util.List;

public interface UserDAO {

    List<User> getAllUsers();

    void saveUser(User user);

    void updateUser(User user);

    User getUser(int id);

    void removeUser(int id);
}
