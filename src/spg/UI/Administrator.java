/**
 * Sample Skeleton for 'Administrator.fxml' Controller Class
 */

package spg.UI;

import com.jfoenix.controls.*;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

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
import lyh.Delay;
import spg.function.Flight;
import spg.function.FlightOperation;
import spg.function.Tool;

public class Administrator implements Tool {
    private FlightOperation op = new FlightOperation();

    private Delay deop = new Delay();

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="stackpane"
    private StackPane stackpane; // Value injected by FXMLLoader

    @FXML // fx:id="paneAdmin"
    private Pane paneAdmin; // Value injected by FXMLLoader

    @FXML // fx:id="time11"
    private JFXTimePicker time11; // Value injected by FXMLLoader

    @FXML // fx:id="comboAirway1"
    private JFXComboBox<String> comboAirway1; // Value injected by FXMLLoader

    @FXML // fx:id="textFlightId1"
    private JFXTextField textFlightId1; // Value injected by FXMLLoader

    @FXML // fx:id="toggleIsStop1"
    private JFXToggleButton toggleIsStop1; // Value injected by FXMLLoader

    @FXML // fx:id="textPrice11"
    private JFXTextField textPrice11; // Value injected by FXMLLoader

    @FXML // fx:id="textPrice12"
    private JFXTextField textPrice12; // Value injected by FXMLLoader

    @FXML // fx:id="textTicket11"
    private JFXTextField textTicket11; // Value injected by FXMLLoader

    @FXML // fx:id="textTicket12"
    private JFXTextField textTicket12; // Value injected by FXMLLoader

    @FXML // fx:id="comboCity11"
    private JFXComboBox<String> comboCity11; // Value injected by FXMLLoader

    @FXML // fx:id="comboCity12"
    private JFXComboBox<String> comboCity12; // Value injected by FXMLLoader

    @FXML // fx:id="comboCity13"
    private JFXComboBox<String> comboCity13; // Value injected by FXMLLoader

    @FXML // fx:id="date11"
    private JFXDatePicker date11; // Value injected by FXMLLoader

    @FXML // fx:id="date12"
    private JFXDatePicker date12; // Value injected by FXMLLoader

    @FXML // fx:id="time12"
    private JFXTimePicker time12; // Value injected by FXMLLoader

    @FXML // fx:id="date13"
    private JFXDatePicker date13; // Value injected by FXMLLoader

    @FXML // fx:id="date14"
    private JFXDatePicker date14; // Value injected by FXMLLoader

    @FXML // fx:id="time13"
    private JFXTimePicker time13; // Value injected by FXMLLoader

    @FXML // fx:id="time14"
    private JFXTimePicker time14; // Value injected by FXMLLoader

    @FXML // fx:id="buttonAdd1"
    private JFXButton buttonAdd1; // Value injected by FXMLLoader

    @FXML // fx:id="textFlightId2"
    private JFXTextField textFlightId2; // Value injected by FXMLLoader

    @FXML // fx:id="comboCity21"
    private JFXComboBox<String> comboCity21; // Value injected by FXMLLoader

    @FXML // fx:id="comboCity23"
    private JFXComboBox<String> comboCity23; // Value injected by FXMLLoader

    @FXML // fx:id="buttonSearch2"
    private JFXButton buttonSearch2; // Value injected by FXMLLoader

    @FXML // fx:id="tableFlight"
    private TableView<Flight> tableFlight; // Value injected by FXMLLoader

    @FXML // fx:id="colId"
    private TableColumn<Flight, String> colId; // Value injected by FXMLLoader

    @FXML // fx:id="colAirway"
    private TableColumn<Flight, String> colAirway; // Value injected by FXMLLoader

    @FXML // fx:id="colCity"
    private TableColumn<Flight, String> colCity1; // Value injected by FXMLLoader

    @FXML // fx:id="colCity2"
    private TableColumn<Flight, String> colCity2; // Value injected by FXMLLoader

    @FXML // fx:id="colCity3"
    private TableColumn<Flight, String> colCity3; // Value injected by FXMLLoader

    @FXML // fx:id="colTime"
    private TableColumn<Flight, String> colTime1; // Value injected by FXMLLoader

    @FXML // fx:id="colTime2"
    private TableColumn<Flight, String> colTime2; // Value injected by FXMLLoader

    @FXML // fx:id="colTime3"
    private TableColumn<Flight, String> colTime3; // Value injected by FXMLLoader

    @FXML // fx:id="colTime4"
    private TableColumn<Flight, String> colTime4; // Value injected by FXMLLoader

    @FXML // fx:id="colPrice"
    private TableColumn<Flight, String> colPrice1; // Value injected by FXMLLoader

    @FXML // fx:id="colPrice2"
    private TableColumn<Flight, String> colPrice2; // Value injected by FXMLLoader

    @FXML // fx:id="colTicket"
    private TableColumn<Flight, String> colTicket1; // Value injected by FXMLLoader

    @FXML // fx:id="colTicket2"
    private TableColumn<Flight, String> colTicket2; // Value injected by FXMLLoader

    @FXML // fx:id="colStatus"
    private TableColumn<Flight, String> colStatus; // Value injected by FXMLLoader

    @FXML // fx:id="colDelete"
    private TableColumn<Flight, String> colDelete; // Value injected by FXMLLoader

    @FXML // fx:id="textFlight31"
    private JFXTextField textFlight31; // Value injected by FXMLLoader

    @FXML // fx:id="buttonSearch3"
    private JFXButton buttonSearch3; // Value injected by FXMLLoader

    @FXML // fx:id="textFlight32"
    private JFXTextField textFlight32; // Value injected by FXMLLoader

    @FXML // fx:id="toggleIsStop3"
    private JFXToggleButton toggleIsStop3; // Value injected by FXMLLoader

    @FXML // fx:id="comboAirway3"
    private JFXComboBox<String> comboAirway3; // Value injected by FXMLLoader

    @FXML // fx:id="comboCity31"
    private JFXComboBox<String> comboCity31; // Value injected by FXMLLoader

    @FXML // fx:id="comboCity32"
    private JFXComboBox<String> comboCity32; // Value injected by FXMLLoader

    @FXML // fx:id="comboCity33"
    private JFXComboBox<String> comboCity33; // Value injected by FXMLLoader

    @FXML // fx:id="date31"
    private JFXDatePicker date31; // Value injected by FXMLLoader

    @FXML // fx:id="time31"
    private JFXTimePicker time31; // Value injected by FXMLLoader

    @FXML // fx:id="time32"
    private JFXTimePicker time32; // Value injected by FXMLLoader

    @FXML // fx:id="date32"
    private JFXDatePicker date32; // Value injected by FXMLLoader

    @FXML // fx:id="date33"
    private JFXDatePicker date33; // Value injected by FXMLLoader

    @FXML // fx:id="time33"
    private JFXTimePicker time33; // Value injected by FXMLLoader

    @FXML // fx:id="date34"
    private JFXDatePicker date34; // Value injected by FXMLLoader

    @FXML // fx:id="time34"
    private JFXTimePicker time34; // Value injected by FXMLLoader

    @FXML // fx:id="textPrice31"
    private JFXTextField textPrice31; // Value injected by FXMLLoader

    @FXML // fx:id="textTicket31"
    private JFXTextField textTicket31; // Value injected by FXMLLoader

    @FXML // fx:id="textPrice32"
    private JFXTextField textPrice32; // Value injected by FXMLLoader

    @FXML // fx:id="textTicket32"
    private JFXTextField textTicket32; // Value injected by FXMLLoader

    @FXML // fx:id="buttonUpdate3"
    private JFXButton buttonUpdate3; // Value injected by FXMLLoader

    @FXML // fx:id="textFlightId4"
    private JFXTextField textFlightId4; // Value injected by FXMLLoader

    @FXML // fx:id="buttonSearch4"
    private JFXButton buttonSearch4; // Value injected by FXMLLoader

    @FXML // fx:id="time42"
    private JFXTimePicker time42; // Value injected by FXMLLoader

    @FXML // fx:id="date41"
    private JFXDatePicker date41; // Value injected by FXMLLoader

    @FXML // fx:id="date44"
    private JFXDatePicker date44; // Value injected by FXMLLoader

    @FXML // fx:id="date43"
    private JFXDatePicker date43; // Value injected by FXMLLoader

    @FXML // fx:id="time44"
    private JFXTimePicker time44; // Value injected by FXMLLoader

    @FXML // fx:id="time41"
    private JFXTimePicker time41; // Value injected by FXMLLoader

    @FXML // fx:id="time43"
    private JFXTimePicker time43; // Value injected by FXMLLoader

    @FXML // fx:id="date42"
    private JFXDatePicker date42; // Value injected by FXMLLoader

    @FXML // fx:id="buttonDelay4"
    private JFXButton buttonDelay4; // Value injected by FXMLLoader

    @FXML // fx:id="buttonReturn5"
    private JFXButton buttonReturn5; // Value injected by FXMLLoader

    @FXML // fx:id="buttonExit5"
    private JFXButton buttonExit5; // Value injected by FXMLLoader

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert stackpane != null : "fx:id=\"stackpane\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert paneAdmin != null : "fx:id=\"paneAdmin\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert time11 != null : "fx:id=\"time11\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert comboAirway1 != null : "fx:id=\"comboAirway1\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert textFlightId1 != null : "fx:id=\"textFlightId1\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert toggleIsStop1 != null : "fx:id=\"toggleIsStop1\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert textPrice11 != null : "fx:id=\"textPrice11\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert textPrice12 != null : "fx:id=\"textPrice12\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert textTicket11 != null : "fx:id=\"textTicket11\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert textTicket12 != null : "fx:id=\"textTicket12\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert comboCity11 != null : "fx:id=\"comboCity11\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert comboCity12 != null : "fx:id=\"comboCity12\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert comboCity13 != null : "fx:id=\"comboCity13\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert date11 != null : "fx:id=\"date11\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert date12 != null : "fx:id=\"date12\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert time12 != null : "fx:id=\"time12\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert date13 != null : "fx:id=\"date13\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert date14 != null : "fx:id=\"date14\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert time13 != null : "fx:id=\"time13\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert time14 != null : "fx:id=\"time14\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert buttonAdd1 != null : "fx:id=\"buttonAdd1\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert textFlightId2 != null : "fx:id=\"textFlightId2\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert comboCity21 != null : "fx:id=\"comboCity21\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert comboCity23 != null : "fx:id=\"comboCity23\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert buttonSearch2 != null : "fx:id=\"buttonSearch2\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert tableFlight != null : "fx:id=\"tableFlight\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert colId != null : "fx:id=\"colId\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert colAirway != null : "fx:id=\"colAirway\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert colCity1 != null : "fx:id=\"colCity1\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert colCity2 != null : "fx:id=\"colCity2\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert colCity3 != null : "fx:id=\"colCity3\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert colTime1 != null : "fx:id=\"colTime1\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert colTime2 != null : "fx:id=\"colTime2\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert colTime3 != null : "fx:id=\"colTime3\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert colTime4 != null : "fx:id=\"colTime4\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert colPrice1 != null : "fx:id=\"colPrice1\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert colPrice2 != null : "fx:id=\"colPrice2\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert colTicket1 != null : "fx:id=\"colTicket1\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert colTicket2 != null : "fx:id=\"colTicket2\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert colStatus != null : "fx:id=\"colStatus\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert colDelete != null : "fx:id=\"colDelete\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert textFlight31 != null : "fx:id=\"textFlight31\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert buttonSearch3 != null : "fx:id=\"buttonSearch3\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert textFlight32 != null : "fx:id=\"textFlight32\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert toggleIsStop3 != null : "fx:id=\"toggleIsStop3\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert comboAirway3 != null : "fx:id=\"comboAirway3\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert comboCity31 != null : "fx:id=\"comboCity31\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert comboCity32 != null : "fx:id=\"comboCity32\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert comboCity33 != null : "fx:id=\"comboCity33\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert date31 != null : "fx:id=\"date31\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert time31 != null : "fx:id=\"time31\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert time32 != null : "fx:id=\"time32\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert date32 != null : "fx:id=\"date32\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert date33 != null : "fx:id=\"date33\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert time33 != null : "fx:id=\"time33\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert date34 != null : "fx:id=\"date34\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert time34 != null : "fx:id=\"time34\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert textPrice31 != null : "fx:id=\"textPrice31\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert textTicket31 != null : "fx:id=\"textTicket31\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert textPrice32 != null : "fx:id=\"textPrice32\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert textTicket32 != null : "fx:id=\"textTicket32\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert buttonUpdate3 != null : "fx:id=\"buttonUpdate3\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert textFlightId4 != null : "fx:id=\"textFlightId4\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert buttonSearch4 != null : "fx:id=\"buttonSearch4\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert time42 != null : "fx:id=\"time42\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert date41 != null : "fx:id=\"date41\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert date44 != null : "fx:id=\"date44\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert date43 != null : "fx:id=\"date43\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert time44 != null : "fx:id=\"time44\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert time41 != null : "fx:id=\"time41\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert time43 != null : "fx:id=\"time43\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert date42 != null : "fx:id=\"date42\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert buttonDelay4 != null : "fx:id=\"buttonDelay4\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert buttonReturn5 != null : "fx:id=\"buttonReturn5\" was not injected: check your FXML file 'Administrator.fxml'.";
        assert buttonExit5 != null : "fx:id=\"buttonExit5\" was not injected: check your FXML file 'Administrator.fxml'.";

        //Initializes the all comboBox
        JFXComboBox[] comboPLACE = {comboCity11, comboCity12, comboCity13, comboCity31, comboCity32, comboCity33};
        for (JFXComboBox btn : comboPLACE) btn.setItems(FXCollections.observableArrayList(PLACE));
        comboCity21.setItems(FXCollections.observableArrayList(PLACE2));
        comboCity23.setItems(FXCollections.observableArrayList(PLACE2));
        comboAirway1.setItems(FXCollections.observableArrayList(AIRWAYS));
        comboAirway3.setItems(FXCollections.observableArrayList(AIRWAYS));

        //Initializes the toggleIsStop1 and toggleIsStop3
        toggleIsStop1.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> setMyDisable(toggleIsStop1, comboCity12,
                date12, time12, date13, time13, textPrice12, textTicket12));
        toggleIsStop3.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> setMyDisable(toggleIsStop3, comboCity32,
                date32, time32, date33, time33, textPrice32, textTicket32));

        buttonAdd1.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            Flight newFlight = new Flight();
            String[] place = new String[3];
            String[] time = new String[4];
            int[] ticket = new int[2];
            int[] price = new int[2];
            if (toggleIsStop1.isSelected()) {
                place[1] = comboCity12.getValue();
                time[1] = date12.getValue().toString() + '-' + time12.getValue().toString();
                time[2] = date13.getValue().toString() + '-' + time13.getValue().toString();
                ticket[1] = Integer.valueOf(textTicket12.getText());
                price[1] = Integer.valueOf(textPrice12.getText());
            } else {
                place[1] = "无";
                time[1] = time[2] = "0000-00-00 00:00";
            }
            place[0] = comboCity11.getValue();
            place[2] = comboCity13.getValue();
            time[0] = date11.getValue().toString() + '-' + time11.getValue().toString();
            time[3] = date14.getValue().toString() + '-' + time14.getValue().toString();
            ticket[0] = Integer.valueOf(textTicket11.getText());
            price[0] = Integer.valueOf(textPrice11.getText());
            newFlight.addFlight(textFlightId1.getText(), comboAirway1.getValue(), place, time, toggleIsStop1.isSelected(), ticket, price);
            boolean result = op.saveFlight(newFlight);//Save the data in the database
            if (result)
                showMsgDialog("成功", "新增航班成功");
            else
                showMsgDialog("失败", "新增航班失败，请重试");
        });

        buttonSearch2.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            this.showFlightTable(op.seekFlight(textFlightId2.getText().equals("") ? "不限" : textFlightId2.getText(),
                    comboCity21.getValue() == null ? "不限" : comboCity21.getValue(), comboCity23.getValue() == null ? "不限" : comboCity23.getValue()));
        });

        buttonSearch3.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            ObservableList<Flight> flight = op.seekFlight(textFlight31.getText(), "不限", "不限");
            if (flight.isEmpty())
                showMsgDialog("失败", "查找航班失败，无此航班");
            else {
                for (Flight btn : flight) {
                    toggleIsStop3.setSelected(btn.getIsStop());
                    setMyDisable(toggleIsStop3, comboCity32, date32, time32, date33, time33, textPrice32, textTicket32);
                    textFlight32.setText(btn.getFlightId());
                    comboAirway3.setValue(btn.getAirway());
                    comboCity31.setValue(btn.getPlace1());
                    comboCity33.setValue(btn.getPlace3());
                    date31.setValue(LocalDate.parse(btn.getTime1().substring(0, 10), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                    date34.setValue(LocalDate.parse(btn.getTime4().substring(0, 10), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                    time31.setValue(LocalTime.parse(btn.getTime1().substring(11, 19), DateTimeFormatter.ofPattern("HH:mm:ss")));
                    time34.setValue(LocalTime.parse(btn.getTime4().substring(11, 19), DateTimeFormatter.ofPattern("HH:mm:ss")));
                    textPrice31.setText(String.valueOf(btn.getPrice1()));
                    textTicket31.setText(String.valueOf(btn.getTicket1()));
                    if (toggleIsStop3.isSelected()) {
                        comboCity32.setValue(btn.getPlace2());
                        date32.setValue(LocalDate.parse(btn.getTime2().substring(0, 10), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                        date33.setValue(LocalDate.parse(btn.getTime3().substring(0, 10), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                        time32.setValue(LocalTime.parse(btn.getTime2().substring(11, 19), DateTimeFormatter.ofPattern("HH:mm:ss")));
                        time33.setValue(LocalTime.parse(btn.getTime3().substring(11, 19), DateTimeFormatter.ofPattern("HH:mm:ss")));
                        textPrice32.setText(String.valueOf(btn.getPrice2()));
                        textTicket32.setText(String.valueOf(btn.getTicket2()));
                    }
                }
            }
        });

        buttonUpdate3.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            Flight newFlight = new Flight();
            String[] place = new String[3];
            String[] time = new String[4];
            int[] ticket = new int[2];
            int[] price = new int[2];
            if (toggleIsStop3.isSelected()) {
                place[1] = comboCity32.getValue();
                time[1] = date32.getValue().toString() + '-' + time32.getValue().toString();
                time[2] = date33.getValue().toString() + '-' + time33.getValue().toString();
                ticket[1] = Integer.valueOf(textTicket32.getText());
                price[1] = Integer.valueOf(textPrice32.getText());
            } else {
                place[1] = "无";
                time[1] = time[2] = "0000-00-00 00:00";
            }
            place[0] = comboCity31.getValue();
            place[2] = comboCity33.getValue();
            time[0] = date31.getValue().toString() + '-' + time31.getValue().toString();
            time[3] = date34.getValue().toString() + '-' + time34.getValue().toString();
            ticket[0] = Integer.valueOf(textTicket31.getText());
            price[0] = Integer.valueOf(textPrice31.getText());
            op.deleteFlight(textFlight31.getText());
            newFlight.addFlight(textFlight32.getText(), comboAirway3.getValue(), place, time, toggleIsStop3.isSelected(), ticket, price);
            boolean result = op.saveFlight(newFlight);//Save the data in the database
            if (result)
                showMsgDialog("成功", "更新航班信息成功");
            else
                showMsgDialog("失败", "更新航班信息失败，请重试");
        });

        buttonSearch4.addEventHandler(MouseEvent.MOUSE_CLICKED, mouse -> {
            LocalDate[] dates = deop.DelayFlighTDates(textFlightId4.getText());
            LocalTime[] times = deop.DelayFlighTtimes(textFlightId4.getText());
            if (dates[0].toString().equals("2019-01-01"))
                showMsgDialog("失败", "查找航班失败，无此航班");
            else {
                if (dates[1] == null) {
                    date42.setDisable(true);
                    date43.setDisable(true);
                    time42.setDisable(true);
                    time43.setDisable(true);
                } else {
                    date42.setDisable(false);
                    date43.setDisable(false);
                    time42.setDisable(false);
                    time43.setDisable(false);
                    date42.setValue(dates[1]);
                    date43.setValue(dates[2]);
                    time42.setValue(times[1]);
                    time43.setValue(times[2]);
                }
                date41.setValue(dates[0]);
                date44.setValue(dates[3]);
                time41.setValue(times[0]);
                time44.setValue(times[3]);
            }
        });

        buttonDelay4.addEventHandler(MouseEvent.MOUSE_CLICKED, mouse -> {
            deop.DelayTimeUpdate1(textFlightId4.getText(), time41.getValue().toString(), time42.getValue() == null ?
                            "00:00" : time42.getValue().toString(), time43.getValue() == null ? "00:00" : time43.getValue().toString(),
                    time44.getValue().toString(), date41.getValue().toString(), date42.getValue() == null ? "0000-00-00" :
                            date42.getValue().toString(), date43.getValue() == null ? "0000-00-00" : date43.getValue().toString(), date44.getValue().toString());
            showMsgDialog("成功", "发布延误成功，已通知此航班乘客");
        });

        buttonReturn5.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
                paneAdmin.getChildren().setAll(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        buttonExit5.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            System.exit(0);
        });
    }


    //About initializes the toggleIsStop1 and toggleIsStop3
    private void setMyDisable(JFXToggleButton a, JFXComboBox b, JFXDatePicker c, JFXTimePicker d, JFXDatePicker e, JFXTimePicker f, TextField g, TextField h) {
        if (a.isSelected()) {
            b.setDisable(false);
            c.setDisable(false);
            d.setDisable(false);
            e.setDisable(false);
            f.setDisable(false);
            g.setDisable(false);
            h.setDisable(false);
        } else {
            b.setDisable(true);
            c.setDisable(true);
            d.setDisable(true);
            e.setDisable(true);
            f.setDisable(true);
            g.setDisable(true);
            h.setDisable(true);
        }
    }

    private void showFlightTable(ObservableList<Flight> flightList) {
        colId.setCellValueFactory(new PropertyValueFactory<>("flightId"));
        colAirway.setCellValueFactory(new PropertyValueFactory<>("airway"));
        colCity1.setCellValueFactory((new PropertyValueFactory<>("place1")));
        colCity2.setCellValueFactory(new PropertyValueFactory<>("place2"));
        colCity3.setCellValueFactory(new PropertyValueFactory<>("place3"));
        colTime1.setCellValueFactory(new PropertyValueFactory<>("time1"));
        colTime2.setCellValueFactory(new PropertyValueFactory<>("time2"));
        colTime3.setCellValueFactory(new PropertyValueFactory<>("time3"));
        colTime4.setCellValueFactory(new PropertyValueFactory<>("time4"));
        colTicket1.setCellValueFactory(new PropertyValueFactory<>("ticket1"));
        colTicket2.setCellValueFactory(new PropertyValueFactory<>("ticket2"));
        colPrice1.setCellValueFactory(new PropertyValueFactory<>("price1"));
        colPrice2.setCellValueFactory(new PropertyValueFactory<>("price2"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        colDelete.setCellFactory((col) -> {
            TableCell<Flight, String> cell = new TableCell<Flight, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);
                    if (!empty) {
                        JFXButton delBtn = new JFXButton("删除");
                        this.setGraphic(delBtn);
                        delBtn.setOnMouseClicked((me) -> {
                            Flight clickedFli = this.getTableView().getItems().get(this.getIndex());
                            if (op.deleteFlight(clickedFli.getFlightId()))
                                showMsgDialog("成功", "删除成功，请刷新");
                        });
                    }
                }

            };
            return cell;
        });
        tableFlight.setItems(flightList);
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

}
