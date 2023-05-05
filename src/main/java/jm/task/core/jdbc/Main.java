package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {

    private final static UserService us = new UserServiceImpl();
    public static void main(String[] args) {
        us.createUsersTable();
        us.saveUser("вася", "тестовый", (byte) 1);
        us.saveUser("васёк", "тестовый", (byte) 2);
        us.saveUser("васька", "тестовый", (byte) 3);
        us.saveUser("василий", "тестовый", (byte) 4);
        us.removeUserById(2);

        us.getAllUsers();

        us.cleanUsersTable();

        us.dropUsersTable();
    }
    }
