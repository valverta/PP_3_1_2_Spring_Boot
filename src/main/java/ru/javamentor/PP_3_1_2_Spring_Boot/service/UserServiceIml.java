package ru.javamentor.PP_3_1_2_Spring_Boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.javamentor.PP_3_1_2_Spring_Boot.dao.UserDAO;
import ru.javamentor.PP_3_1_2_Spring_Boot.model.User;

import java.util.List;

@Service
public class UserServiceIml implements UserService {

    @Autowired
    private UserDAO userDAO;
    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDAO.saveUser(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User getUser(int id) {
        return userDAO.getUser(id);
    }

    @Override
    @Transactional
    public void removeUser(int id) {
        userDAO.removeUser(id);
    }
}
