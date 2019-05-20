package spg.function;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.lang.String;

public class FlightOperation implements Tool {
    private static FlightOperation instance = new FlightOperation();

    public static FlightOperation getInstance() {
        return instance;
    }

    public FlightOperation() {
    }

    public boolean saveFlight(Flight fli) {//Add data to the database
        boolean result = false;
        Connection conn = null;
        try {
            conn = DatabaseConnection.getCon();  //Establishing a database connection
            String sqlInset = "insert into flight.flight(flight_id, airway, status, place1, place2, place3, time1, time2, time3," +
                    " time4, is_stop, ticket1, ticket2, price1, price2) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sqlInset);//It throws an exception
            stmt.setString(1, fli.getFlightId());//Put the data into the database
            stmt.setString(2, fli.getAirway());
            stmt.setString(3, fli.getStatus());
            stmt.setString(4, fli.getPlace1());
            stmt.setString(5, fli.getPlace2());
            stmt.setString(6, fli.getPlace3());
            stmt.setString(7, fli.getTime1());
            stmt.setString(8, fli.getTime2());
            stmt.setString(9, fli.getTime3());
            stmt.setString(10, fli.getTime4());
            stmt.setBoolean(11, fli.getIsStop());
            stmt.setInt(12, fli.getTicket1());
            stmt.setInt(13, fli.getTicket2());
            stmt.setInt(14, fli.getPrice1());
            stmt.setInt(15, fli.getPrice2());
            int i = stmt.executeUpdate();//Performs an insert data operation and returns the number of rows affected
            if (i == 1) {
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

    public ObservableList<Flight> seekFlight(String a, String b, String c) {//Query the required data from the database
        ObservableList<Flight> flightList = FXCollections.observableArrayList();
        Connection conn = null;
        String[] place = new String[3];
        String[] time = new String[4];
        int[] ticket = new int[2];
        int[] price = new int[2];
        try {
            conn = DatabaseConnection.getCon();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from flight.flight");//Execute the SQL and return the result set
            if (!a.equals("不限制") && b.equals("不限制") && c.equals("不限制"))
                rs = stmt.executeQuery("select * from flight.flight where flight_id = '" + a + "'");
            else if (a.equals("不限制") && !b.equals("不限制") && c.equals("不限制"))
                rs = stmt.executeQuery("select * from flight.flight where place1 = '" + b + "'");
            else if (a.equals("不限制") && b.equals("不限制") && !c.equals("不限制"))
                rs = stmt.executeQuery("select * from flight.flight where place3 = '" + c + "'");
            else if (!a.equals("不限制") && !b.equals("不限制") && c.equals("不限制"))
                rs = stmt.executeQuery("select * from flight.flight where flight_id = '" + a + "' and place1 = '" + b + "'");
            else if (!a.equals("不限制") && b.equals("不限制"))
                rs = stmt.executeQuery("select * from flight.flight where flight_id = '" + a + "' and place3 = '" + c + "'");
            else if (a.equals("不限制") && !b.equals("不限制"))
                rs = stmt.executeQuery("select * from flight.flight where place1 = '" + b + "' and place3 = '" + c + "'");
            else if (!a.equals("不限制"))
                rs = stmt.executeQuery("select * from flight.flight where flight_id = '" + a + "' and place1 = '" + b + "' and place3 = '" + c + "'");
            while (rs.next()) {
                Flight flight = new Flight();
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
    }

    public boolean deleteFlight(String flightNum) {//Cancellation of flights
        boolean result = false;
        Connection conn = null;
        try {
            conn = DatabaseConnection.getCon();
            String sql = "delete from Flight.tb_flight where flightNum = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, flightNum);
            int i = stmt.executeUpdate();
            if (i == 1) {
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}