package spg.function;

import com.sun.org.apache.xpath.internal.operations.Or;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Order2 {
    private int index;
    private String passengerId;
    private String flightId;
    private String orderStatus;

    public Order2() {
    }

    public ObservableList<Order2> seekOrder(String passengerId) {//Query the required data from the database
        ObservableList<Order2> orderList = FXCollections.observableArrayList();
        Connection conn = null;
        try {
            conn = DatabaseConnection.getCon();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from flight.order_list where passenger_id='" + passengerId + "'");//Execute the SQL and return the result set
            while (rs.next()) {
                Order2 order = new Order2();
                order.setIndex(rs.getInt("index"));
                order.setPassengerId(rs.getString("passenger_id"));
                order.setFlightId(rs.getString("flight_id"));
                order.setOrderStatus(rs.getString("order_status"));
                orderList.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();//Close the connection
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return orderList;//Returns the result
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
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