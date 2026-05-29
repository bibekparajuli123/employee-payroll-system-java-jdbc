package com.lcwd.employee;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection createDBConnection() {

        try {

            Class<?> c = Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Loaded: " + c.getName());

            String url =
                    "jdbc:mysql://localhost:3306/employee_db?useSSL=false&serverTimezone=UTC";

            Connection con =
                    DriverManager.getConnection(url, "root", "my_password");

            System.out.println("Connected!");

            return con;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}