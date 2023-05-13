package jm.task.core.jdbc.service;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.dao.*; // если-что использую весь пакет дао :"(

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao udao = new UserDaoHibernateImpl();

    @Override
    public void createUsersTable() {
        udao.cleanUsersTable();// по какой то причине метод createUsersTable не работает, хотя я уже создал 5 разных таблиц использовал 5 разных версий Hibernate и 5 разных бд... Подскажите :"(
    }

    @Override
    public void dropUsersTable() {
        udao.dropUsersTable();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        udao.saveUser(name, lastName, age);
    }

    @Override
    public void removeUserById(long id) {
        udao.removeUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return udao.getAllUsers();
    }

    @Override
    public void cleanUsersTable() {
        udao.cleanUsersTable();
    }
}
