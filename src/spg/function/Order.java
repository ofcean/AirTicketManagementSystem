package spg.function;

public class Order {

    private String passengerId;
    private String flightId;
    private String orderStatus;

    public Order(String passengerId, String flightId, String orderStatus) {
        this.passengerId = passengerId;
        this.flightId = flightId;
        this.orderStatus = orderStatus;//The ticket has been issued and the reservation is in process
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

    public String getFlightId() {
        return flightId;
    }

    public String getPassengerId() {
        return passengerId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }
}
