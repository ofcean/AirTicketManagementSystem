package spg.function;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderOperation {

    public boolean buyTicket(String passengerId, String flightId, int ticket, int leg) {
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
    }
}
