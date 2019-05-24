/**
 * Sample Skeleton for 'PassengerInterface.fxml' Controller Class
 */

package spg.UI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextField;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class PassengerInterface {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="panePassenger"
    private JFXTabPane panePassenger; // Value injected by FXMLLoader

    @FXML // fx:id="textUserId1"
    private static Label textUserId1; // Value injected by FXMLLoader

    @FXML // fx:id="tableFlight1"
    private TableView<?> tableFlight1; // Value injected by FXMLLoader

    @FXML // fx:id="colId1"
    private TableColumn<?, ?> colId1; // Value injected by FXMLLoader

    @FXML // fx:id="colAirway1"
    private TableColumn<?, ?> colAirway1; // Value injected by FXMLLoader

    @FXML // fx:id="colCity11"
    private TableColumn<?, ?> colCity11; // Value injected by FXMLLoader

    @FXML // fx:id="colCity21"
    private TableColumn<?, ?> colCity21; // Value injected by FXMLLoader

    @FXML // fx:id="colCity31"
    private TableColumn<?, ?> colCity31; // Value injected by FXMLLoader

    @FXML // fx:id="colTime11"
    private TableColumn<?, ?> colTime11; // Value injected by FXMLLoader

    @FXML // fx:id="colTime21"
    private TableColumn<?, ?> colTime21; // Value injected by FXMLLoader

    @FXML // fx:id="colTime31"
    private TableColumn<?, ?> colTime31; // Value injected by FXMLLoader

    @FXML // fx:id="colTime41"
    private TableColumn<?, ?> colTime41; // Value injected by FXMLLoader

    @FXML // fx:id="colPrice11"
    private TableColumn<?, ?> colPrice11; // Value injected by FXMLLoader

    @FXML // fx:id="colPrice21"
    private TableColumn<?, ?> colPrice21; // Value injected by FXMLLoader

    @FXML // fx:id="colTicket11"
    private TableColumn<?, ?> colTicket11; // Value injected by FXMLLoader

    @FXML // fx:id="colTicket21"
    private TableColumn<?, ?> colTicket21; // Value injected by FXMLLoader

    @FXML // fx:id="colStatus1"
    private TableColumn<?, ?> colStatus1; // Value injected by FXMLLoader

    @FXML // fx:id="colBuy1"
    private TableColumn<?, ?> colBuy1; // Value injected by FXMLLoader

    @FXML // fx:id="textMessage1"
    private Label textMessage1; // Value injected by FXMLLoader

    @FXML // fx:id="buttonSearch211"
    private JFXButton buttonSearch211; // Value injected by FXMLLoader

    @FXML // fx:id="buttonSearch2"
    private JFXButton buttonSearch2; // Value injected by FXMLLoader

    @FXML // fx:id="passenger_id2"
    private TableColumn<?, ?> passenger_id2; // Value injected by FXMLLoader

    @FXML // fx:id="flight_id2"
    private TableColumn<?, ?> flight_id2; // Value injected by FXMLLoader

    @FXML // fx:id="order_status2"
    private TableColumn<?, ?> order_status2; // Value injected by FXMLLoader

    @FXML // fx:id="textFlightId3"
    private JFXTextField textFlightId3; // Value injected by FXMLLoader

    @FXML // fx:id="comboCity13"
    private JFXComboBox<?> comboCity13; // Value injected by FXMLLoader

    @FXML // fx:id="comboCity23"
    private JFXComboBox<?> comboCity23; // Value injected by FXMLLoader

    @FXML // fx:id="comboSort3"
    private JFXComboBox<?> comboSort3; // Value injected by FXMLLoader

    @FXML // fx:id="buttonSearch3"
    private JFXButton buttonSearch3; // Value injected by FXMLLoader

    @FXML // fx:id="tableFlight"
    private TableView<?> tableFlight; // Value injected by FXMLLoader

    @FXML // fx:id="colId3"
    private TableColumn<?, ?> colId3; // Value injected by FXMLLoader

    @FXML // fx:id="colAirway3"
    private TableColumn<?, ?> colAirway3; // Value injected by FXMLLoader

    @FXML // fx:id="colCity13"
    private TableColumn<?, ?> colCity13; // Value injected by FXMLLoader

    @FXML // fx:id="colCity23"
    private TableColumn<?, ?> colCity23; // Value injected by FXMLLoader

    @FXML // fx:id="colCity33"
    private TableColumn<?, ?> colCity33; // Value injected by FXMLLoader

    @FXML // fx:id="colTime13"
    private TableColumn<?, ?> colTime13; // Value injected by FXMLLoader

    @FXML // fx:id="colTime23"
    private TableColumn<?, ?> colTime23; // Value injected by FXMLLoader

    @FXML // fx:id="colTime33"
    private TableColumn<?, ?> colTime33; // Value injected by FXMLLoader

    @FXML // fx:id="colTime43"
    private TableColumn<?, ?> colTime43; // Value injected by FXMLLoader

    @FXML // fx:id="colPrice13"
    private TableColumn<?, ?> colPrice13; // Value injected by FXMLLoader

    @FXML // fx:id="colPrice23"
    private TableColumn<?, ?> colPrice23; // Value injected by FXMLLoader

    @FXML // fx:id="colTicket13"
    private TableColumn<?, ?> colTicket13; // Value injected by FXMLLoader

    @FXML // fx:id="colTicket23"
    private TableColumn<?, ?> colTicket23; // Value injected by FXMLLoader

    @FXML // fx:id="colStatus3"
    private TableColumn<?, ?> colStatus3; // Value injected by FXMLLoader

    @FXML // fx:id="colBuy3"
    private TableColumn<?, ?> colBuy3; // Value injected by FXMLLoader

    @FXML // fx:id="tableFlight2"
    private TableView<?> tableFlight2; // Value injected by FXMLLoader

    @FXML // fx:id="colId4"
    private TableColumn<?, ?> colId4; // Value injected by FXMLLoader

    @FXML // fx:id="colAirway4"
    private TableColumn<?, ?> colAirway4; // Value injected by FXMLLoader

    @FXML // fx:id="colCity14"
    private TableColumn<?, ?> colCity14; // Value injected by FXMLLoader

    @FXML // fx:id="colCity24"
    private TableColumn<?, ?> colCity24; // Value injected by FXMLLoader

    @FXML // fx:id="colCity34"
    private TableColumn<?, ?> colCity34; // Value injected by FXMLLoader

    @FXML // fx:id="colTime14"
    private TableColumn<?, ?> colTime14; // Value injected by FXMLLoader

    @FXML // fx:id="colTime24"
    private TableColumn<?, ?> colTime24; // Value injected by FXMLLoader

    @FXML // fx:id="colTime34"
    private TableColumn<?, ?> colTime34; // Value injected by FXMLLoader

    @FXML // fx:id="colTime44"
    private TableColumn<?, ?> colTime44; // Value injected by FXMLLoader

    @FXML // fx:id="colPrice14"
    private TableColumn<?, ?> colPrice14; // Value injected by FXMLLoader

    @FXML // fx:id="colPrice24"
    private TableColumn<?, ?> colPrice24; // Value injected by FXMLLoader

    @FXML // fx:id="colTicket14"
    private TableColumn<?, ?> colTicket14; // Value injected by FXMLLoader

    @FXML // fx:id="colTicket24"
    private TableColumn<?, ?> colTicket24; // Value injected by FXMLLoader

    @FXML // fx:id="colStatus4"
    private TableColumn<?, ?> colStatus4; // Value injected by FXMLLoader

    @FXML // fx:id="butttonRecommend4"
    private JFXButton butttonRecommend4; // Value injected by FXMLLoader

    @FXML // fx:id="comboCity24"
    private JFXComboBox<?> comboCity24; // Value injected by FXMLLoader

    @FXML // fx:id="comboCity14"
    private JFXComboBox<?> comboCity14; // Value injected by FXMLLoader

    @FXML // fx:id="comboRecommend4"
    private JFXComboBox<?> comboRecommend4; // Value injected by FXMLLoader

    @FXML // fx:id="buttonReturn5"
    private JFXButton buttonReturn5; // Value injected by FXMLLoader

    @FXML // fx:id="buttonExit5"
    private JFXButton buttonExit5; // Value injected by FXMLLoader

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert panePassenger != null : "fx:id=\"panePassenger\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert textUserId1 != null : "fx:id=\"textUserId1\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert tableFlight1 != null : "fx:id=\"tableFlight1\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colId1 != null : "fx:id=\"colId1\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colAirway1 != null : "fx:id=\"colAirway1\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colCity11 != null : "fx:id=\"colCity11\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colCity21 != null : "fx:id=\"colCity21\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colCity31 != null : "fx:id=\"colCity31\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colTime11 != null : "fx:id=\"colTime11\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colTime21 != null : "fx:id=\"colTime21\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colTime31 != null : "fx:id=\"colTime31\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colTime41 != null : "fx:id=\"colTime41\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colPrice11 != null : "fx:id=\"colPrice11\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colPrice21 != null : "fx:id=\"colPrice21\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colTicket11 != null : "fx:id=\"colTicket11\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colTicket21 != null : "fx:id=\"colTicket21\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colStatus1 != null : "fx:id=\"colStatus1\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colBuy1 != null : "fx:id=\"colBuy1\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert textMessage1 != null : "fx:id=\"textMessage1\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert buttonSearch211 != null : "fx:id=\"buttonSearch211\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert buttonSearch2 != null : "fx:id=\"buttonSearch2\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert passenger_id2 != null : "fx:id=\"passenger_id2\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert flight_id2 != null : "fx:id=\"flight_id2\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert order_status2 != null : "fx:id=\"order_status2\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert textFlightId3 != null : "fx:id=\"textFlightId3\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert comboCity13 != null : "fx:id=\"comboCity13\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert comboCity23 != null : "fx:id=\"comboCity23\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert comboSort3 != null : "fx:id=\"comboSort3\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert buttonSearch3 != null : "fx:id=\"buttonSearch3\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert tableFlight != null : "fx:id=\"tableFlight\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colId3 != null : "fx:id=\"colId3\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colAirway3 != null : "fx:id=\"colAirway3\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colCity13 != null : "fx:id=\"colCity13\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colCity23 != null : "fx:id=\"colCity23\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colCity33 != null : "fx:id=\"colCity33\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colTime13 != null : "fx:id=\"colTime13\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colTime23 != null : "fx:id=\"colTime23\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colTime33 != null : "fx:id=\"colTime33\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colTime43 != null : "fx:id=\"colTime43\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colPrice13 != null : "fx:id=\"colPrice13\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colPrice23 != null : "fx:id=\"colPrice23\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colTicket13 != null : "fx:id=\"colTicket13\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colTicket23 != null : "fx:id=\"colTicket23\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colStatus3 != null : "fx:id=\"colStatus3\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colBuy3 != null : "fx:id=\"colBuy3\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert tableFlight2 != null : "fx:id=\"tableFlight2\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colId4 != null : "fx:id=\"colId4\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colAirway4 != null : "fx:id=\"colAirway4\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colCity14 != null : "fx:id=\"colCity14\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colCity24 != null : "fx:id=\"colCity24\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colCity34 != null : "fx:id=\"colCity34\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colTime14 != null : "fx:id=\"colTime14\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colTime24 != null : "fx:id=\"colTime24\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colTime34 != null : "fx:id=\"colTime34\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colTime44 != null : "fx:id=\"colTime44\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colPrice14 != null : "fx:id=\"colPrice14\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colPrice24 != null : "fx:id=\"colPrice24\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colTicket14 != null : "fx:id=\"colTicket14\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colTicket24 != null : "fx:id=\"colTicket24\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colStatus4 != null : "fx:id=\"colStatus4\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert butttonRecommend4 != null : "fx:id=\"butttonRecommend4\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert comboCity24 != null : "fx:id=\"comboCity24\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert comboCity14 != null : "fx:id=\"comboCity14\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert comboRecommend4 != null : "fx:id=\"comboRecommend4\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert buttonReturn5 != null : "fx:id=\"buttonReturn5\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert buttonExit5 != null : "fx:id=\"buttonExit5\" was not injected: check your FXML file 'PassengerInterface.fxml'.";

    }

    public static void setTextUserId1(Label textUserId1) {
        PassengerInterface.textUserId1 = textUserId1;
    }
}
