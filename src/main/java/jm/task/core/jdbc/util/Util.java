package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
// Сделал без методов Util,Drier. Как узнал они не обязательны,
// надеюсь из за них не приидется переделывать :(

public class Util {

    private static final String URL = "jdbc:mysql://localhost:3306/mydb1"; // раньше в mySql не ставились 2 слэша?Спросить
    // так же хотелось бы добавить что начиная с 2003 года это можно не писать :)
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // раньше логин и пороль зашивался в url через знак вопроса,спросить про это
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD); // url,properties
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






