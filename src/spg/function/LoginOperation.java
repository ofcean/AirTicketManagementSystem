package spg.function;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import spg.UI.PassengerInterface;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginOperation {

    //Returns whether the user exists
    public boolean isUser(String textId, String textPassword) {
        Connection conn = null;
        conn = DatabaseConnection.getCon();
        ResultSet rs = null;
        try {
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from flight.user where id='" + textId + "' and password='" + textPassword + "'");
            if (rs.next())
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    //Returns whether this user is an administrator
    public boolean isAdmin(String id, String password) {
        Connection conn = null;
        conn = DatabaseConnection.getCon();
        ResultSet rs = null;//Execute the SQL and return the result set
        try {
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from flight.user where id = '" + id + "' and password = '" + password + "' and is_admin = true");
            if (rs.next())
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {//The use of finally is to execute the finally statement regardless of whether the program has an exception, so close the connection here
            try {
                conn.close(); //When a Connection is opened, its close () method must finally be called to close the Connection to free system and database resources
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}