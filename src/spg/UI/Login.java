/**
 * Sample Skeleton for 'Login.fxml' Controller Class
 */

package spg.UI;

import com.jfoenix.controls.JFXButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import spg.function.DatabaseConnection;

public class Login {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="textId"
    private TextField textId; // Value injected by FXMLLoader

    @FXML // fx:id="buttonLogin"
    private JFXButton buttonLogin; // Value injected by FXMLLoader

    @FXML // fx:id="textPassword"
    private PasswordField textPassword; // Value injected by FXMLLoader

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert textId != null : "fx:id=\"textId\" was not injected: check your FXML file 'Login.fxml'.";
        assert buttonLogin != null : "fx:id=\"buttonLogin\" was not injected: check your FXML file 'Login.fxml'.";
        assert textPassword != null : "fx:id=\"textPassword\" was not injected: check your FXML file 'Login.fxml'.";

        /*buttonLogin.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            Connection conn = null;
            try {
                conn = DatabaseConnection.getCon();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("select * from flight.user where ");//Execute the SQL and return the result set
                while (rs.next()) {
                    Flight flight = new Flight();
                    flight.setFlightId(rs.getString("flight_id"));
                    flight.setAirway(rs.getString("airway"));
                    flight.setStatus(rs.getString("status"));
                    flight.setPlace1(rs.getString("place1"));
                    flight.setPlace2(rs.getString("place2"));
                    flight.setPlace3(rs.getString("place3"));
                    flight.setTime1(rs.getString("time1"));
                    flight.setTime2(rs.getString("time2"));
                    flight.setTime3(rs.getString("time3"));
                    flight.setTime4(rs.getString("time4"));
                    flight.setIsStop(rs.getBoolean("is_stop"));
                    flight.setTicket1(rs.getInt("ticket1"));
                    flight.setTicket2(rs.getInt("ticket2"));
                    flight.setPrice1(rs.getInt("price1"));
                    flight.setPrice2(rs.getInt("price2"));
                    flightList.add(flight);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();//Close the connection
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return flightList;//Returns the result
        });*/
    }
}
