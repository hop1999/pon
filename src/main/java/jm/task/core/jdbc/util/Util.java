package jm.task.core.jdbc.util;

import java.sql.*;
// Сделал без методов Util,Drier. Как узнал они не обязательны,
// надеюсь из за них не приидется переделывать :(

public class Util {

    private static final String URL = "jdbc:mysql://localhost:3306/mydb1";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("Ошибка загрузки драйвера JDBC");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Ошибка соединения с базой данных");
            e.printStackTrace();
        }
        return connection;
    }

    }






