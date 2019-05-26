/**
 * Sample Skeleton for 'Login.fxml' Controller Class
 */

package spg.UI;

import com.jfoenix.controls.JFXButton;

import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import spg.function.LoginOperation;

public class Login {

    LoginOperation op = new LoginOperation();

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="paneLogin"
    private Pane paneLogin; // Value injected by FXMLLoader

    @FXML // fx:id="stackpane"
    private StackPane stackpane; // Value injected by FXMLLoader

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
        assert stackpane != null : "fx:id=\"stackpane\" was not injected: check your FXML file 'Login.fxml'.";
        assert textId != null : "fx:id=\"textId\" was not injected: check your FXML file 'Login.fxml'.";
        assert buttonLogin != null : "fx:id=\"buttonLogin\" was not injected: check your FXML file 'Login.fxml'.";
        assert textPassword != null : "fx:id=\"textPassword\" was not injected: check your FXML file 'Login.fxml'.";

        buttonLogin.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> login());
    }

    private void login() {
        if (!op.isUser(textId.getText(), textPassword.getText()))
            showMsgDialog("登录出错","账号或密码错误，请重试");
        else if (op.isAdmin(textId.getText(), textPassword.getText())) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("Administrator.fxml"));
                paneLogin.getChildren().setAll(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("PassengerInterface.fxml"));
                paneLogin.getChildren().setAll(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PassengerInterface.fxml"));
            try {
                Pane login = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            PassengerInterface control = loader.getController();
            control.model.setText(textId.getText());
        }
    }

    private void showMsgDialog(String heading, String msg) {
        JFXDialogLayout content = new JFXDialogLayout();
        Text t = new Text(heading);
        t.setFont(Font.font("Microsoft YaHei", FontWeight.BOLD, FontPosture.REGULAR, 20));
        Text m = new Text(msg);
        m.setFont(Font.font("Microsoft YaHei", FontWeight.NORMAL, FontPosture.REGULAR, 16));
        content.setHeading(t);
        content.setBody(m);
        JFXButton btn = new JFXButton("确定");
        JFXDialog dialog = new JFXDialog(stackpane, content, JFXDialog.DialogTransition.CENTER);
        btn.setOnAction(event -> dialog.close());
        content.setActions(btn);
        dialog.show();
    }
}