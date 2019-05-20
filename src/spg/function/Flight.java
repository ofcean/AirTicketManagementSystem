package spg.function;

import javafx.beans.property.SimpleStringProperty;

import java.util.*;
import java.sql.Timestamp;

public class Flight implements spg.function.Tool {
    private String  flightId;//flight number
    private String airway;//airway
    private String status;//Flight status: normal, delayed, cancelled
    private String[] place = new String[3];//Departure, stopover, landing location
    private String[] time = new String[4];//Take-off, stop-over, endurance and landing time
    private boolean isStop;//Whether stopping
    private int[] ticket = new int[2];//tickets left
    private int[] price = new int[2];
    //The total ticket price of the whole journey or the first journey ticket price,
    //the second journey ticket price and the total ticket price shall be the sum of the two multiplied by 0.9

    public Flight() {//Initial flight
        status = "正常";
    }

    //Increase the flight
    public void addFlight(String flightId, String airway, String[] place, String[] time, boolean isStop,int[] ticket, int[] price) {
        this.flightId = flightId;
        this.airway = airway;
        this.isStop = isStop;
        System.arraycopy(place, 0, this.place, 0, place.length);
        System.arraycopy(time, 0, this.time, 0, time.length);
        System.arraycopy(ticket, 0, this.ticket, 0, ticket.length);
        System.arraycopy(price, 0, this.price, 0, price.length);
    }

    //取消航班
    public void deleteFlight(int flightNum) {

    }

    //修改航班信息
    public void updateInfo() {

    }

    //查找航班
    public static void seekFlight(int flightNum) {

    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getAirway() {
        return airway;
    }

    public void setAirway(String airways) {
        this.airway = airways;
    }

    public String[] getPlace() {
        return place;
    }

    public void setPlace(String[] place) {
        System.arraycopy(place, 0, this.place, 0, place.length);
    }

    public String[] getTime() {
        return time;
    }

    public void setTime(String[] time) {
        System.arraycopy(time, 0, this.time, 0, time.length);
    }

    public int[] getTicket() {
        return ticket;
    }

    public void setTicket() {
        this.ticket = ticket;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int[] getPrice() {
        return price;
    }

    public void setPrice(int[] price) {
        System.arraycopy(price, 0, this.price, 0, price.length);
    }

    public boolean getIsStop() {
        return isStop;
    }

    public void setIsStop(boolean isStop) {
        this.isStop = isStop;
    }
}