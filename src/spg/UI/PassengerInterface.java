/**
 * Sample Skeleton for 'PassengerInterface.fxml' Controller Class
 */

package spg.UI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import spg.function.*;
import yqh.Type;
import yqh.User;

public class PassengerInterface implements Tool {

    User us = new User();

    FlightOperation fop = new FlightOperation();

    OrderOperation oop = new OrderOperation();

    public static AppModel model = new AppModel();

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="panePassenger"
    private Pane panePassenger; // Value injected by FXMLLoader

    @FXML // fx:id="textUserId1"
    private Label textUserId1; // Value injected by FXMLLoader

    @FXML // fx:id="tableFlight1"
    private TableView<Flight2> tableFlight1; // Value injected by FXMLLoader

    @FXML // fx:id="colId1"
    private TableColumn<Flight2, String> colId1; // Value injected by FXMLLoader

    @FXML // fx:id="colAirway1"
    private TableColumn<Flight2, String> colAirway1; // Value injected by FXMLLoader

    @FXML // fx:id="colCity11"
    private TableColumn<Flight2, String> colCity11; // Value injected by FXMLLoader

    @FXML // fx:id="colCity21"
    private TableColumn<Flight2, String> colCity21; // Value injected by FXMLLoader

    @FXML // fx:id="colTime11"
    private TableColumn<Flight2, String> colTime11; // Value injected by FXMLLoader

    @FXML // fx:id="colTime21"
    private TableColumn<Flight2, String> colTime21; // Value injected by FXMLLoader

    @FXML // fx:id="colPrice11"
    private TableColumn<Flight2, String> colPrice1; // Value injected by FXMLLoader

    @FXML // fx:id="colTicket11"
    private TableColumn<Flight2, String> colTicket1; // Value injected by FXMLLoader

    @FXML // fx:id="colStatus1"
    private TableColumn<Flight2, String> colStatus1; // Value injected by FXMLLoader

    @FXML // fx:id="colBuy1"
    private TableColumn<Flight2, String> colBuy1; // Value injected by FXMLLoader

    @FXML // fx:id="textMessage1"
    private Label textMessage1; // Value injected by FXMLLoader

    @FXML // fx:id="buttonSearch1"
    private JFXButton buttonSearch1; // Value injected by FXMLLoader

    @FXML // fx:id="buttonSearch211"
    private JFXButton buttonCheck1; // Value injected by FXMLLoader

    @FXML // fx:id="buttonSearch2"
    private JFXButton buttonSearch2; // Value injected by FXMLLoader

    @FXML // fx:id="tableOrder2"
    private TableView<Order> tableOrder2; // Value injected by FXMLLoader

    @FXML // fx:id="passenger_id2"
    private TableColumn<Flight2, String> colPassengerId2; // Value injected by FXMLLoader

    @FXML // fx:id="flight_id2"
    private TableColumn<Flight2, String> colFlightId2; // Value injected by FXMLLoader

    @FXML // fx:id="order_status2"
    private TableColumn<Flight2, String> colOrderStatus2; // Value injected by FXMLLoader

    @FXML // fx:id="order_status2"
    private TableColumn<Flight2, String> colRefund2; // Value injected by FXMLLoader

    @FXML // fx:id="textFlightId3"
    private JFXTextField textFlightId3; // Value injected by FXMLLoader

    @FXML // fx:id="comboCity13"
    private JFXComboBox<String> comboCity13; // Value injected by FXMLLoader

    @FXML // fx:id="comboCity23"
    private JFXComboBox<String> comboCity23; // Value injected by FXMLLoader

    @FXML // fx:id="comboSort3"
    private JFXComboBox<String> comboSort3; // Value injected by FXMLLoader

    @FXML // fx:id="buttonSearch3"
    private JFXButton buttonSearch3; // Value injected by FXMLLoader

    @FXML // fx:id="tableFlight"
    private TableView<Flight2> tableFlight3; // Value injected by FXMLLoader

    @FXML // fx:id="colId3"
    private TableColumn<Flight2, String> colId3; // Value injected by FXMLLoader

    @FXML // fx:id="colAirway3"
    private TableColumn<Flight2, String> colAirway3; // Value injected by FXMLLoader

    @FXML // fx:id="colCity13"
    private TableColumn<Flight2, String> colCity13; // Value injected by FXMLLoader

    @FXML // fx:id="colCity23"
    private TableColumn<Flight2, String> colCity23; // Value injected by FXMLLoader

    @FXML // fx:id="colTime13"
    private TableColumn<Flight2, String> colTime13; // Value injected by FXMLLoader

    @FXML // fx:id="colTime23"
    private TableColumn<Flight2, String> colTime23; // Value injected by FXMLLoader

    @FXML // fx:id="colPrice13"
    private TableColumn<Flight2, String> colPrice3; // Value injected by FXMLLoader

    @FXML // fx:id="colTicket13"
    private TableColumn<Flight2, String> colTicket3; // Value injected by FXMLLoader

    @FXML // fx:id="colStatus3"
    private TableColumn<Flight2, String> colStatus3; // Value injected by FXMLLoader

    @FXML // fx:id="colBuy3"
    private TableColumn<Flight2, String> colBuy3; // Value injected by FXMLLoader

    @FXML // fx:id="tableFlight2"
    private TableView<Flight2> tableFlight4; // Value injected by FXMLLoader

    @FXML // fx:id="colId4"
    private TableColumn<Flight2, String> colId4; // Value injected by FXMLLoader

    @FXML // fx:id="colAirway4"
    private TableColumn<Flight2, String> colAirway4; // Value injected by FXMLLoader

    @FXML // fx:id="colCity14"
    private TableColumn<Flight2, String> colCity14; // Value injected by FXMLLoader

    @FXML // fx:id="colCity24"
    private TableColumn<Flight2, String> colCity24; // Value injected by FXMLLoader

    @FXML // fx:id="colTime14"
    private TableColumn<Flight2, String> colTime14; // Value injected by FXMLLoader

    @FXML // fx:id="colTime24"
    private TableColumn<Flight2, String> colTime24; // Value injected by FXMLLoader

    @FXML // fx:id="colPrice14"
    private TableColumn<Flight2, String> colPrice4; // Value injected by FXMLLoader

    @FXML // fx:id="colTicket14"
    private TableColumn<Flight2, String> colTicket4; // Value injected by FXMLLoader

    @FXML // fx:id="colStatus4"
    private TableColumn<Flight2, String> colStatus4; // Value injected by FXMLLoader

    @FXML // fx:id="colBuy4"
    private TableColumn<Flight2, String> colBuy4; // Value injected by FXMLLoader

    @FXML // fx:id="butttonRecommend4"
    private JFXButton butttonRecommend4; // Value injected by FXMLLoader

    @FXML // fx:id="comboCity24"
    private JFXComboBox<String> comboCity24; // Value injected by FXMLLoader

    @FXML // fx:id="comboCity14"
    private JFXComboBox<String> comboCity14; // Value injected by FXMLLoader

    @FXML // fx:id="comboRecommend4"
    private JFXComboBox<String> comboRecommend4; // Value injected by FXMLLoader

    @FXML // fx:id="buttonReturn5"
    private JFXButton buttonReturn5; // Value injected by FXMLLoader

    @FXML // fx:id="buttonExit5"
    private JFXButton buttonExit5; // Value injected by FXMLLoader

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        // update text area if text in model changes:
        model.textProperty().addListener((obs, oldText, newText) -> textUserId1.setText(newText));
        assert panePassenger != null : "fx:id=\"panePassenger\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert textUserId1 != null : "fx:id=\"textUserId1\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert tableFlight1 != null : "fx:id=\"tableFlight1\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colId1 != null : "fx:id=\"colId1\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colAirway1 != null : "fx:id=\"colAirway1\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colCity11 != null : "fx:id=\"colCity11\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colCity21 != null : "fx:id=\"colCity21\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colTime11 != null : "fx:id=\"colTime11\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colTime21 != null : "fx:id=\"colTime21\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colPrice1 != null : "fx:id=\"colPrice1\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colTicket1 != null : "fx:id=\"colTicket1\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colStatus1 != null : "fx:id=\"colStatus1\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colBuy1 != null : "fx:id=\"colBuy1\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert textMessage1 != null : "fx:id=\"textMessage1\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert buttonSearch1 != null : "fx:id=\"buttonSearch1\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert buttonCheck1 != null : "fx:id=\"buttonCheck1\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert buttonSearch2 != null : "fx:id=\"buttonSearch2\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert tableOrder2 != null : "fx:id=\"tableOrder2\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colPassengerId2 != null : "fx:id=\"colPassengerId2\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colFlightId2 != null : "fx:id=\"colFlightId2\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colOrderStatus2 != null : "fx:id=\"colOrderStatus2\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colRefund2 != null : "fx:id=\"colRefund2\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert textFlightId3 != null : "fx:id=\"textFlightId3\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert comboCity13 != null : "fx:id=\"comboCity13\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert comboCity23 != null : "fx:id=\"comboCity23\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert comboSort3 != null : "fx:id=\"comboSort3\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert buttonSearch3 != null : "fx:id=\"buttonSearch3\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert tableFlight3 != null : "fx:id=\"tableFlight3\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colId3 != null : "fx:id=\"colId3\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colAirway3 != null : "fx:id=\"colAirway3\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colCity13 != null : "fx:id=\"colCity13\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colCity23 != null : "fx:id=\"colCity23\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colTime13 != null : "fx:id=\"colTime13\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colTime23 != null : "fx:id=\"colTime23\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colPrice3 != null : "fx:id=\"colPrice3\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colTicket3 != null : "fx:id=\"colTicket3\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colStatus3 != null : "fx:id=\"colStatus3\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colBuy3 != null : "fx:id=\"colBuy3\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert tableFlight4 != null : "fx:id=\"tableFlight4\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colId4 != null : "fx:id=\"colId4\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colAirway4 != null : "fx:id=\"colAirway4\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colCity14 != null : "fx:id=\"colCity14\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colCity24 != null : "fx:id=\"colCity24\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colTime14 != null : "fx:id=\"colTime14\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colTime24 != null : "fx:id=\"colTime24\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colPrice4 != null : "fx:id=\"colPrice4\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colTicket4 != null : "fx:id=\"colTicket4\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colStatus4 != null : "fx:id=\"colStatus4\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colBuy4 != null : "fx:id=\"colBuy4\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert butttonRecommend4 != null : "fx:id=\"butttonRecommend4\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert comboCity24 != null : "fx:id=\"comboCity24\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert comboCity14 != null : "fx:id=\"comboCity14\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert comboRecommend4 != null : "fx:id=\"comboRecommend4\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert buttonReturn5 != null : "fx:id=\"buttonReturn5\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert buttonExit5 != null : "fx:id=\"buttonExit5\" was not injected: check your FXML file 'PassengerInterface.fxml'.";

        //Initializes the all comboBox
        JFXComboBox[] comboPLACE = {comboCity13, comboCity23, comboCity13, comboCity14, comboCity24};
        for (JFXComboBox btn : comboPLACE) btn.setItems(FXCollections.observableArrayList(PLACE));
        comboSort3.setItems(FXCollections.observableArrayList(SORT));
        comboRecommend4.setItems(FXCollections.observableArrayList(RECOMMAND));

        buttonCheck1.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            String delayFlightId;
            if ((delayFlightId = fop.seekDelayFlight(textUserId1.getText())) != null) {
                textMessage1.setText("我们抱歉地通知您，航班" + delayFlightId + "延误。");
            }
        });

        buttonSearch1.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {

        });

        buttonSearch3.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            this.showFlightTable(fop.seekFlightWithSort(textFlightId3.getText().equals("") ? "不限" : textFlightId3.getText(), comboCity13.getValue() == null ? "北" +
                    "京" : comboCity13.getValue(), comboCity23.getValue() == null ? "北京" : comboCity23.getValue(), comboSort3.getValue() == null ? "不限制" : comboSort3.getValue()));
        });

        buttonReturn5.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
                panePassenger.getChildren().setAll(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        buttonExit5.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            System.exit(0);
        });
    }

    private void showFlightTable(ObservableList<Flight2> flightList) {
        colId3.setCellValueFactory(new PropertyValueFactory<>("flightId"));
        colAirway3.setCellValueFactory(new PropertyValueFactory<>("airway"));
        colCity13.setCellValueFactory((new PropertyValueFactory<>("place1")));
        colCity23.setCellValueFactory(new PropertyValueFactory<>("place2"));
        colTime13.setCellValueFactory(new PropertyValueFactory<>("time1"));
        colTime23.setCellValueFactory(new PropertyValueFactory<>("time2"));
        colTicket3.setCellValueFactory(new PropertyValueFactory<>("ticket"));
        colPrice3.setCellValueFactory(new PropertyValueFactory<>("price"));
        colStatus3.setCellValueFactory(new PropertyValueFactory<>("status"));
        colBuy3.setCellFactory((col) -> {
            TableCell<Flight2, String> cell = new TableCell<Flight2, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);
                    if (!empty) {
                        JFXButton delBtn = new JFXButton("购票");
                        this.setGraphic(delBtn);
                        delBtn.setOnMouseClicked((me) -> {
                            Flight2 clickedFli = this.getTableView().getItems().get(this.getIndex());
                            /*if (comboCity13.getValue() != null && comboCity23.getValue() != null) {
                                if (comboCity13.getValue().equals(clickedFli.getPlace1()) && comboCity23.getValue().equals(clickedFli.getPlace2()))
                                    //购票函数us.buyDB(clickedFli, Type.PlaceEnum.FIRST);
                                else if (comboCity13.getValue().equals(clickedFli.getPlace2()) && comboCity23.getValue().equals(clickedFli.getPlace3()))
                                    us.buyDB(clickedFli, Type.PlaceEnum.SECOND);
                                else
                                    us.buyDB(clickedFli, Type.PlaceEnum.FULL);
                            } else {
                                System.out.println("购票失败");
                                //弹出购票失败窗口
                            }*/
                        });
                    }
                }

            };
            return cell;
        });
        tableFlight3.setItems(flightList);
    }

    public static void setText(String text) {
        model.setText(text);
    }
}
