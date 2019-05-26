package spg.function;

import com.sun.org.apache.xpath.internal.operations.Or;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class OrderOperation {
    //Query the segment of the specified flight and return
    /*public int seekOrderLeg(String passengerId, String flightId) {
        Connection conn = null;
        try {
            conn = DatabaseConnection.getCon();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from flight.order where passenger_id='" + passengerId + "'" +
                    " and flight_id='" + flightId + "'");
            while (rs.next()) {
                Order order=new Order(rs.getString(""));
                flight.setFlightId(rs.getString("flight_id"));
                flight.setAirway(rs.getString("airway"));
                flight.setStatus(rs.getString("status"));
                flight.setPlace1(rs.getString("place1"));
                flight.setPlace2(rs.getString("place2"));
                flight.setPlace3(rs.getString("place3"));
                flight.setTime1(rs.getString("time1"));
                flight.setTime2(rs.getString("time2"));
                flight.setTime3(rs.getString("time3"));
                flight.setTime4(rs.getString("time4"));
                flight.setIsStop(rs.getBoolean("is_stop"));
                flight.setTicket1(rs.getInt("ticket1"));
                flight.setTicket2(rs.getInt("ticket2"));
                flight.setPrice1(rs.getInt("price1"));
                flight.setPrice2(rs.getInt("price2"));
                flightList.add(flight);
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
        return flightList;//Returns the result
    }*/

    /*public boolean buyTicket(String passengerId, String flightId, int ticket, int leg) {
        boolean result = false;
        Connection conn = null;
        try {
            conn = DatabaseConnection.getCon();  //Establishing a database connection
            String sqlInset = "insert into flight.order(passenger_id, flight_id, status, leg) values(?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sqlInset);//It throws an exception
            stmt.setString(1, passengerId);//Put the data into the database
            stmt.setString(2, flightId);
            stmt.setString(3, ticket > 0 ? "已出票" : "预约中");
            stmt.setInt(4, leg);
            int i = stmt.executeUpdate();//Performs an insert data operation and returns the number of rows affected
            if (i == 1 && ticket > 0) {
                System.out.println("购票成功");
                //票数减1的函数
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {//The use of finally is to execute the finally statement regardless of whether the program has an exception, so close the connection here
            try {
                conn.close(); //When a Connection is opened, its close () method must finally be called to close the Connection to free system and database resources
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }*/
}
