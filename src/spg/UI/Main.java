package spg.UI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import spg.function.*;//
import yqh.Type;
import yqh.User;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("Administrator.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("PassengerInterface.fxml"));
        primaryStage.setTitle("飞机票管理系统");
        primaryStage.setScene(new Scene(root, 1280, 800));
        primaryStage.getIcons().add(new Image("/spg/image/plane.jpg"));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}