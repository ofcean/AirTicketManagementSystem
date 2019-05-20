package spg.function;

import java.lang.management.PlatformLoggingMXBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.commons.lang3.StringUtils;

import java.lang.String;

import java.util.ArrayList;
import java.util.List;

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
            for (int i = 0; i < 3; i++) stmt.setString(i + 4, fli.getPlace()[i]);
            for (int i = 0; i < 4; i++) stmt.setString(i + 7, fli.getTime()[i]);
            stmt.setBoolean(11, fli.getIsStop());
            for (int i = 0; i < 2; i++) stmt.setInt(i + 12, fli.getTicket()[i]);
            for (int i = 0; i < 2; i++) stmt.setInt(i + 14, fli.getPrice()[i]);
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

    public Flight seekFlightByNum(String flightNum1) {       //通过航班号从数据库中查询所需数据
        Flight fli = new Flight();
        Connection conn = null;
        try {
            conn = DatabaseConnection.getCon();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Flight.tb_flight where flightNum = '" + flightNum1 + "'");//执行SQL并返回结果集
            while (rs.next()) {
                String[] tim = rs.getString("tim").split(",");
                Timestamp[] time = new Timestamp[4];
                for (int i = 0; i < 4; i++)
                    time[i] = Timestamp.valueOf(tim[i]);
                String[] resTic = rs.getString("resTicket").split(",");
                int[] resTicket = new int[2];
                for (int i = 0; i < 2; i++)
                    resTicket[i] = Integer.parseInt(resTic[i]);
                String[] pri = rs.getString("price").split(",");
                int[] price = new int[2];
                for (int i = 0; i < 2; i++)
                    price[i] = Integer.parseInt(pri[i]);
                fli.setFlightId(rs.getString("flightNum"));
                fli.setAirway(rs.getString("airways"));
                fli.setPlace(rs.getString("place").split(","));
                //fli.setTicket(fli.getTicket());
                fli.setStatus(rs.getString("status"));
                fli.setPrice(price);
                fli.setIsStop(rs.getBoolean("isStop"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();                                         //关闭连接
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return fli;                                            //返回结果
    }

    public ObservableList<Flight> SeekFlight(String a, String b, String c) {//Query the required data from the database
        ObservableList<Flight> flightList = FXCollections.observableArrayList();
        Connection conn = null;
        try {
            conn = DatabaseConnection.getCon();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from flight.flight");//Execute the SQL and return the result set
            if (a != "不限制" && b.equals("不限制") && c.equals("不限制"))
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
                /*place[0]=rs.getString("place1");
                place[1]=rs.getString("place2");
                place[2]=rs.getString("place3");*/
                Flight flight = new Flight();
                flight.setFlightId(rs.getString("flight_id"));
                /*flight.setPlace(place);*/
                flightList.add(flight);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();                                         //关闭连接
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return flightList;                                             //返回结果
    }

    public ObservableList<Flight> getFlightData() {
        Flight flight1 = new Flight();
        ObservableList<Flight> flightList = FXCollections.observableArrayList(flight1);
        return flightList;
    }

    public boolean deleteFlight(String flightNum) {//取消航班
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