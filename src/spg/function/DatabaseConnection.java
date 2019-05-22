package spg.function;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    private static Connection conn = null;

    public static Connection getCon() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//Load the database connection driver
            String user = "root";
            String psw = "spgzho520";
            String url = "jdbc:mysql://127.0.0.1:3306/Flight?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convert_To_Null&useSSL=false";
            conn = DriverManager.getConnection(url, user, psw);//Get connected
        } catch (Exception e) {
            System.out.println("Failed to connect to database.");
            e.printStackTrace();
        }
        return conn;
    }
}