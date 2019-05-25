package spg.function;

import com.sun.org.apache.xpath.internal.operations.Or;

public class Order {

    private String passengerId;
    private String flightId;
    private String orderStatus;
    private int leg;//One of the first half,two for the second half,and three for the second half

    public Order(String passengerId, String flightId, String orderStatus, int leg) {
        this.passengerId = passengerId;
        this.flightId = flightId;
        this.orderStatus = orderStatus;//The ticket has been issued and the reservation is in process
        this.leg = leg;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public void setPassengerId(String passengerId) {
        this.passengerId = passengerId;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setLeg(int leg) {
        this.leg = leg;
    }

    public String getFlightId() {
        return flightId;
    }

    public String getPassengerId() {
        return passengerId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public int getLeg() {
        return leg;
    }
}
