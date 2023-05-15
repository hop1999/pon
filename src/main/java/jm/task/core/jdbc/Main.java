package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;

public class Main {
//    private static UserDao udao = new UserDaoHibernateImpl();

    public static void main(String[] args) {
        UserDao udao = new UserDaoHibernateImpl();

        udao.createUsersTable();

        udao.saveUser("Name1", "LastName1", (byte) 20);
        udao.saveUser("Name2", "LastName2", (byte) 25);
        udao.saveUser("Name3", "LastName3", (byte) 31);
        udao.saveUser("Name4", "LastName4", (byte) 38);

        udao.removeUserById(1);
        udao.getAllUsers();
        udao.cleanUsersTable();
        udao.dropUsersTable();
    }
}