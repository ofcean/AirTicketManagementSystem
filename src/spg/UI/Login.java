/**
 * Sample Skeleton for 'Login.fxml' Controller Class
 */

package spg.UI;

import com.jfoenix.controls.JFXButton;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import spg.function.DatabaseConnection;

public class Login {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="paneLogin"
    private Pane paneLogin; // Value injected by FXMLLoader

    @FXML // fx:id="textId"
    private TextField textId; // Value injected by FXMLLoader

    @FXML // fx:id="buttonLogin"
    private JFXButton buttonLogin; // Value injected by FXMLLoader

    @FXML // fx:id="textPassword"
    private PasswordField textPassword; // Value injected by FXMLLoader

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert paneLogin != null : "fx:id=\"paneLogin\" was not injected: check your FXML file 'Login.fxml'.";
        assert textId != null : "fx:id=\"textId\" was not injected: check your FXML file 'Login.fxml'.";
        assert buttonLogin != null : "fx:id=\"buttonLogin\" was not injected: check your FXML file 'Login.fxml'.";
        assert textPassword != null : "fx:id=\"textPassword\" was not injected: check your FXML file 'Login.fxml'.";

        buttonLogin.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            Connection conn = null;
            conn = DatabaseConnection.getCon();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from flight.user where id='" + textId + "' and passward='" + textPassword + "'");//Execute the SQL and return the result set
            if (rs == null)
                System.out.println("无该用户或密码错误");//后期改成弹窗
            else {
                while (rs.next()) {
                    if (rs.getBoolean("is_admin")) {
                        Parent root = FXMLLoader.load(getClass().getResource("Administrator.fxml"));
                        paneLogin.getChildren().setAll(root);
                    } else if (!rs.getBoolean("is_admin")) {
                        Parent root = FXMLLoader.load(getClass().getResource("PassengerInterface.fxml"));
                        paneLogin.getChildren().setAll(root);
                    }

                }
            }
        });
    }
}