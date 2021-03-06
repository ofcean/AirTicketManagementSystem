/**
 * Sample Skeleton for 'PassengerInterface.fxml' Controller Class
 */

package spg.UI;

import com.jfoenix.controls.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.mysql.cj.xdevapi.Table;
import com.sun.org.apache.xpath.internal.operations.Or;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import lyh.RecommendByPrice;
import spg.function.*;
import yqh.Type;
import yqh.User;

import javax.jws.soap.SOAPBinding;

public class PassengerInterface implements Tool {

    User us = new User();

    FlightOperation fop = new FlightOperation();

    public static AppModel model = new AppModel();

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="stackpane"
    private StackPane stackpane; // Value injected by FXMLLoader

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

    @FXML // fx:id="buttonSearch211"
    private JFXButton buttonCheck1; // Value injected by FXMLLoader

    @FXML // fx:id="buttonSearch2"
    private JFXButton buttonSearch2; // Value injected by FXMLLoader

    @FXML // fx:id="tableOrder2"
    private TableView<Order2> tableOrder2; // Value injected by FXMLLoader

    @FXML // fx:id="colOrder2"
    private TableColumn<Order2, String> colOrder2; // Value injected by FXMLLoader

    @FXML // fx:id="passenger_id2"
    private TableColumn<Order2, String> colPassengerId2; // Value injected by FXMLLoader

    @FXML // fx:id="flight_id2"
    private TableColumn<Order2, String> colFlightId2; // Value injected by FXMLLoader

    @FXML // fx:id="order_status2"
    private TableColumn<Order2, String> colOrderStatus2; // Value injected by FXMLLoader

    @FXML // fx:id="order_status2"
    private TableColumn<Order2, String> colRefund2; // Value injected by FXMLLoader

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

    @FXML // fx:id="buttonRecommend4"
    private JFXButton buttonRecommend4; // Value injected by FXMLLoader

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
        assert stackpane != null : "fx:id=\"stackpane\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
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
        assert buttonCheck1 != null : "fx:id=\"buttonCheck1\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert buttonSearch2 != null : "fx:id=\"buttonSearch2\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert tableOrder2 != null : "fx:id=\"tableOrder2\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert colOrder2 != null : "fx:id=\"colOrder2\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
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
        assert buttonRecommend4 != null : "fx:id=\"buttonRecommend4\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert comboCity24 != null : "fx:id=\"comboCity24\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert comboCity14 != null : "fx:id=\"comboCity14\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert comboRecommend4 != null : "fx:id=\"comboRecommend4\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert buttonReturn5 != null : "fx:id=\"buttonReturn5\" was not injected: check your FXML file 'PassengerInterface.fxml'.";
        assert buttonExit5 != null : "fx:id=\"buttonExit5\" was not injected: check your FXML file 'PassengerInterface.fxml'.";

        //Initializes the all comboBox
        JFXComboBox[] comboPLACE = {comboCity13, comboCity23, comboCity13, comboCity14, comboCity24};
        for (JFXComboBox btn : comboPLACE) btn.setItems(FXCollections.observableArrayList(PLACE));
        comboSort3.setItems(FXCollections.observableArrayList(SORT));
        comboRecommend4.setItems(FXCollections.observableArrayList(RECOMMEND));

        buttonCheck1.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            String delayFlightId = fop.seekDelayFlight(textUserId1.getText());
            String[] city = fop.seekDelayFlightCity(textUserId1.getText(), delayFlightId);
            if (delayFlightId != null) {
                textMessage1.setText("我们抱歉地通知您，航班" + delayFlightId + "延误。");
                this.showFlightTable(fop.seekFlightWithoutDelay(city[0], city[1]), colId1, colAirway1, colCity11, colCity21,
                        colTime11, colTime21, colTicket1, colPrice1, colStatus1, colBuy1, tableFlight1);
            }
        });

        buttonSearch2.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            Order2 or = new Order2();
            this.showOrderTable(or.seekOrder(textUserId1.getText()));
        });

        buttonSearch3.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            this.showFlightTable(fop.seekFlightWithSort(textFlightId3.getText().equals("") ? "不限" : textFlightId3.getText(),
                    comboCity13.getValue() == null ? "北京" : comboCity13.getValue(), comboCity23.getValue() == null ? "北京"
                            : comboCity23.getValue(), comboSort3.getValue() == null ? "不限" : comboSort3.getValue()), colId3,
                    colAirway3, colCity13, colCity23, colTime13, colTime23, colTicket3, colPrice3, colStatus3, colBuy3, tableFlight3);
        });

        buttonRecommend4.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            if (comboRecommend4.getValue() == null || comboRecommend4.getValue().equals("价格")) {
                RecommendByPrice rbp = new RecommendByPrice();
                this.showFlightTable(rbp.PriceRecommend(comboCity14.getValue() == null ? "北京" : comboCity14.getValue(),
                        comboCity24.getValue() == null ? "北京" : comboCity24.getValue()), colId4, colAirway4, colCity14,
                        colCity24, colTime14, colTime24, colTicket4, colPrice4, colStatus4, colBuy4, tableFlight4);
            } else if (comboRecommend4.getValue().equals("用时")) {
                this.showFlightTable(us.best("AZ1234", "AZ4563"), colId4, colAirway4, colCity14,
                        colCity24, colTime14, colTime24, colTicket4, colPrice4, colStatus4, colBuy4, tableFlight4);
            }
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

    //The user purchase interface displays information about each flight
    private void showFlightTable(ObservableList<Flight2> flightList, TableColumn<Flight2, String> id, TableColumn<Flight2, String> airway,
                                 TableColumn<Flight2, String> city1, TableColumn<Flight2, String> city2, TableColumn<Flight2, String> time1,
                                 TableColumn<Flight2, String> time2, TableColumn<Flight2, String> ticket, TableColumn<Flight2, String> price,
                                 TableColumn<Flight2, String> status, TableColumn<Flight2, String> buy, TableView<Flight2> tableflight) {
        id.setCellValueFactory(new PropertyValueFactory<>("flightId"));
        airway.setCellValueFactory(new PropertyValueFactory<>("airway"));
        city1.setCellValueFactory((new PropertyValueFactory<>("place1")));
        city2.setCellValueFactory(new PropertyValueFactory<>("place2"));
        time1.setCellValueFactory(new PropertyValueFactory<>("time1"));
        time2.setCellValueFactory(new PropertyValueFactory<>("time2"));
        ticket.setCellValueFactory(new PropertyValueFactory<>("ticket"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        buy.setCellFactory((col) -> {
            TableCell<Flight2, String> cell = new TableCell<Flight2, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);
                    if (!empty) {
                        JFXButton buyBtn = new JFXButton("购票");//Add the buy tickets button
                        this.setGraphic(buyBtn);
                        buyBtn.setOnMouseClicked((me) -> {//Tickets are purchased and the results are displayed
                            Flight2 clickedFli = this.getTableView().getItems().get(this.getIndex());
                            ObservableList<Flight> flights = fop.seekFlight(clickedFli.getFlightId(), "不限", "不限");
                            for (Flight btn : flights) {//Three cases of ticket purchase, and three results of ticket purchase
                                if (clickedFli.getPlace1().equals(btn.getPlace1()) && clickedFli.getPlace2().equals(btn.getPlace2()))
                                    showTicketResults(clickedFli.getFlightId(), Type.PlaceEnum.FIRST);
                                else if (clickedFli.getPlace1().equals(btn.getPlace2()) && clickedFli.getPlace2().equals(btn.getPlace3()))
                                    showTicketResults(clickedFli.getFlightId(), Type.PlaceEnum.SECOND);
                                else if (clickedFli.getPlace1().equals(btn.getPlace1()) && clickedFli.getPlace2().equals(btn.getPlace3())) {
                                    showTicketResults(clickedFli.getFlightId(), Type.PlaceEnum.FULL);
                                }
                            }
                        });
                    }
                }

            };
            return cell;
        });
        tableflight.setItems(flightList);
    }

    //A function that displays the result of a ticket purchase
    public void showTicketResults(String flightId, Type.PlaceEnum a) {
        us.setId(textUserId1.getText());
        int b = us.buyres(flightId, a);
        if (b == 1)
            showMsgDialog("成功", "购票成功");
        else if (b == 2)
            showMsgDialog("成功", "票已售空，已预约");
        else if (b == 0)
            showMsgDialog("失败", "购票失败，请重试");
    }

    //Displays all user orders
    private void showOrderTable(ObservableList<Order2> orderList) {
        colOrder2.setCellValueFactory(new PropertyValueFactory<>("index"));
        colPassengerId2.setCellValueFactory(new PropertyValueFactory<>("passengerId"));
        colFlightId2.setCellValueFactory((new PropertyValueFactory<>("flightId")));
        colOrderStatus2.setCellValueFactory(new PropertyValueFactory<>("orderStatus"));
        colRefund2.setCellFactory((col) -> {
            TableCell<Order2, String> cell = new TableCell<Order2, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);
                    if (!empty) {
                        JFXButton delBtn = new JFXButton("退票");//Add the buy tickets button
                        this.setGraphic(delBtn);
                        delBtn.setOnMouseClicked((me) -> {//Tickets are purchased and the results are displayed
                            Order2 clickedOrd = this.getTableView().getItems().get(this.getIndex());
                            us.refundDB(clickedOrd.getIndex());
                            showMsgDialog("成功", "退票成功，请刷新");
                        });
                    }
                }
            };
            return cell;
        });
        tableOrder2.setItems(orderList);
    }

    private void showMsgDialog(String heading, String msg) {
        JFXDialogLayout content = new JFXDialogLayout();
        Text t = new Text(heading);
        t.setFont(Font.font("Microsoft YaHei UI Light", FontWeight.BOLD, FontPosture.REGULAR, 20));
        Text m = new Text(msg);
        m.setFont(Font.font("Microsoft YaHei UI Light", FontWeight.NORMAL, FontPosture.REGULAR, 16));
        content.setHeading(t);
        content.setBody(m);
        JFXButton btn = new JFXButton("确定");
        JFXDialog dialog = new JFXDialog(stackpane, content, JFXDialog.DialogTransition.CENTER);
        btn.setOnAction(event -> dialog.close());
        content.setActions(btn);
        dialog.show();
    }

    //A function that passes data between two controllers
    public static void setText(String text) {
        model.setText(text);
    }
}