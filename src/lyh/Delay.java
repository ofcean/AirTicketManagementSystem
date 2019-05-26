package lyh;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import spg.function.*;
import spg.function.FlightOperation;
import spg.function.Tool;

import java.lang.String;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

//search update
public class Delay implements Tool {

    public LocalDate[] DelayFlighTDates(String flightNum) {         //输入航班号，获取日期
        ObservableList<Flight> flightList = FXCollections.observableArrayList();
        Connection conn = null;
        FlightOperation operation = new FlightOperation();
        try {
            conn = DatabaseConnection.getCon();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from flight.flight where flight_id='" + flightNum + "'");
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

        LocalDate[] Date = new LocalDate[4];
        Flight fli = flightList.get(0);
        Date[0] = LocalDate.parse(fli.getTime1().substring(0, 10), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        if (fli.getIsStop()) {
            Date[1] = LocalDate.parse(fli.getTime2().substring(0, 10), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            Date[2] = LocalDate.parse(fli.getTime3().substring(0, 10), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }
        Date[3] = LocalDate.parse(fli.getTime4().substring(0, 10), DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        return Date;
    }

    public LocalTime[] DelayFlighTtimes(String flightNum) {     //输入航班号，获取时间
        ObservableList<Flight> flightList = FXCollections.observableArrayList();
        Connection conn = null;
        FlightOperation operation = new FlightOperation();
        try {
            conn = DatabaseConnection.getCon();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from flight.flight where flight_id='" + flightNum + "'");
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


        LocalTime[] Time = new LocalTime[4];
        Flight fli = flightList.get(0);
        Time[0] = LocalTime.parse(fli.getTime1().substring(11, 19), DateTimeFormatter.ofPattern("HH:mm:ss"));
        if (fli.getIsStop()) {
            Time[1] = LocalTime.parse(fli.getTime2().substring(11, 19), DateTimeFormatter.ofPattern("HH:mm:ss"));
            Time[2] = LocalTime.parse(fli.getTime3().substring(11, 19), DateTimeFormatter.ofPattern("HH:mm:ss"));
        }
        Time[3] = LocalTime.parse(fli.getTime4().substring(11, 19), DateTimeFormatter.ofPattern("HH:mm:ss"));

        return Time;
    }

    public void DelayTimeUpdate1(String flightNum, String time1, String time2, String time3, String time4, String date1, String date2, String date3, String date4) {  //输入时间日期，更新
        ObservableList<Flight> flightList = FXCollections.observableArrayList();
        Connection conn = null;
        FlightOperation operation = new FlightOperation();
        try {
            conn = DatabaseConnection.getCon();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from flight.flight where flight_id='" + flightNum + "'");
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

        Flight fli = flightList.get(0);//更新信息
        String[] tim = new String[4];
        tim[0] = date1 + '-' + time1;
        tim[1] = date2 + '-' + time2;
        tim[2] = date3 + '-' + time3;
        tim[3] = date4 + '-' + time4;
        fli.setTime1(tim[0]);
        fli.setTime2(tim[1]);
        fli.setTime3(tim[2]);
        fli.setTime4(tim[3]);
        fli.setStatus("延误");
        //更新数据库
        boolean result = false;
        try {
            conn = DatabaseConnection.getCon();
            String sql = "delete from flight.flight where flight_id = ?";
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

        FlightOperation op = new FlightOperation();
        op.saveFlight(fli);
    }
}