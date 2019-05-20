package spg.function;

public class Flight implements spg.function.Tool {
    private String flightId;//flight number
    private String airway;//airway
    private String status;//Flight status: normal, delayed
    private String place1, place2, place3;//Departure, stopover, landing location
    private String time1, time2, time3, time4;//Take-off, stop-over, endurance and landing time
    private boolean isStop;//Whether stopping
    private int ticket1, ticket2;//tickets left
    private int price1, price2;
    //The total ticket price of the whole journey or the first journey ticket price,
    //the second journey ticket price and the total ticket price shall be the sum of the two multiplied by 0.9

    public Flight() {//Initial flight
        status = "正常";
    }

    //Increase the flight
    public void addFlight(String flightId, String airway, String[] place, String[] time, boolean isStop, int[] ticket, int[] price) {
        this.flightId = flightId;
        this.airway = airway;
        this.place1 = place[0];
        this.place2 = place[1];
        this.place3 = place[2];
        this.time1 = time[0];
        this.time2 = time[1];
        this.time3 = time[2];
        this.time4 = time[3];
        this.isStop = isStop;
        this.ticket1 = ticket[0];
        this.ticket2 = ticket[1];
        this.price1 = price[0];
        this.price2 = price[1];
    }

    //取消航班
    public void deleteFlight(int flightNum) {

    }

    //修改航班信息
    public void updateInfo() {

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

    public String getPlace1() {
        return place1;
    }

    public void setPlace1(String place1) {
        this.place1 = place1;
    }

    public String getPlace2() {
        return place2;
    }

    public void setPlace2(String place2) {
        this.place2 = place2;
    }

    public String getPlace3() {
        return place3;
    }

    public void setPlace3(String place3) {
        this.place3 = place3;
    }

    public String getTime1() {
        return time1;
    }

    public String getTime2() {
        return time2;
    }

    public String getTime3() {
        return time3;
    }

    public String getTime4() {
        return time4;
    }

    public void setTime1(String time1) {
        this.time1 = time1;
    }

    public void setTime2(String time2) {
        this.time2 = time2;
    }

    public void setTime3(String time3) {
        this.time3 = time3;
    }

    public void setTime4(String time4) {
        this.time4 = time4;
    }

    public int getTicket1() {
        return ticket1;
    }

    public int getTicket2() {
        return ticket2;
    }

    public void setTicket1(int ticket1) {
        this.ticket1 = ticket1;
    }

    public void setTicket2(int ticket2) {
        this.ticket2 = ticket2;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPrice1() {
        return price1;
    }

    public int getPrice2() {
        return price2;
    }

    public void setPrice1(int price1) {
        this.price1 = price1;
    }

    public void setPrice2(int price2) {
        this.price2 = price2;
    }

    public boolean getIsStop() {
        return isStop;
    }

    public void setIsStop(boolean isStop) {
        this.isStop = isStop;
    }
}