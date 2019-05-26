package spg.function;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.lang.String;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;

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
        try {
            conn = DatabaseConnection.getCon();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from flight.flight");//Execute the SQL and return the result set
            if (!a.equals("不限") && b.equals("不限") && c.equals("不限"))
                rs = stmt.executeQuery("select * from flight.flight where flight_id = '" + a + "'");
            else if (a.equals("不限") && !b.equals("不限") && c.equals("不限"))
                rs = stmt.executeQuery("select * from flight.flight where place1 = '" + b + "'");
            else if (a.equals("不限") && b.equals("不限") && !c.equals("不限"))
                rs = stmt.executeQuery("select * from flight.flight where place3 = '" + c + "'");
            else if (!a.equals("不限") && !b.equals("不限") && c.equals("不限"))
                rs = stmt.executeQuery("select * from flight.flight where flight_id = '" + a + "' and place1 = '" + b + "'");
            else if (!a.equals("不限") && b.equals("不限"))
                rs = stmt.executeQuery("select * from flight.flight where flight_id = '" + a + "' and place3 = '" + c + "'");
            else if (a.equals("不限") && !b.equals("不限"))
                rs = stmt.executeQuery("select * from flight.flight where place1 = '" + b + "' and place3 = '" + c + "'");
            else if (!a.equals("不限"))
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
        return result;
    }

    public String seekDelayFlight(String passengerId) {//Query the required data from the database
        Connection conn = null;
        try {
            conn = DatabaseConnection.getCon();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from flight.order where passenger_id='" + passengerId + "'");//Execute the SQL and return the result set
            while (rs.next()) {
                String flightId = rs.getString("flight_id");
                ResultSet rt = stmt.executeQuery("select * from flight.flight where flight_id='" + flightId + "' and status='延误'");
                if (rt.next()) return flightId;
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
        return null;//Returns the result
    }

    public String[] seekDelayFlightCity(String passengerId, String flightId) {
        Connection conn = null;
        String[] city = new String[2];
        try {
            conn = DatabaseConnection.getCon();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from flight.order where passenger_id='" + passengerId + "' and flight_id='" + flightId + "'");//Execute the SQL and return the result set
            while (rs.next()) {
                int leg = rs.getInt("leg");
                ResultSet rt = stmt.executeQuery("select * from flight.flight where flight_id='" + flightId + "'");
                if (leg == 1) {
                    city[0] = rt.getString("place1");
                    city[1] = rt.getString("place2");
                } else if (leg == 2) {
                    city[0] = rt.getString("place2");
                    city[1] = rt.getString("place3");
                } else {
                    city[0] = rt.getString("place1");
                    city[1] = rt.getString("place3");
                }
                return city;
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
        return null;//Returns the result
    }

    public ObservableList<Flight2> seekFlightWithSort(String a, String b, String c, String d) {//Query the required data from the database
        ObservableList<Flight2> flightList = FXCollections.observableArrayList();
        Connection conn = null;
        try {
            conn = DatabaseConnection.getCon();
            Statement stmt = conn.createStatement();
            ResultSet r1, r2, r3, r4, r5;
            if (!a.equals("不限")) {
                r1 = stmt.executeQuery("select * from flight.flight where flight_id='" + a + "'");
                while (r1.next()) {
                    Flight flight = new Flight();
                    flight.setIsStop(r1.getBoolean("is_stop"));
                    r1.previous();
                    if (flight.getIsStop()) {
                        flightList = setFlight2(flightList, r1, "place1", "place2", "time1",
                                "time2", "ticket1", "price1");
                        r2 = stmt.executeQuery("select * from flight.flight where flight_id='" + a + "'");
                        flightList = setFlight2(flightList, r2, "place2", "place3", "time3",
                                "time4", "ticket2", "price2");
                    } else {
                        flightList = setFlight2(flightList, r1, "place1", "place3", "time1",
                                "time4", "ticket1", "price1");
                    }
                    break;
                }
                return flightList;
            } else {
                r3 = stmt.executeQuery("select * from flight.flight where place1='" + b + "' and place2='" + c + "'");
                flightList = setFlight2(flightList, r3, "place1", "place2", "time1",
                        "time2", "ticket1", "price1");
                r4 = stmt.executeQuery("select * from flight.flight where place2='" + b + "' and place3='" + c + "'");
                flightList = setFlight2(flightList, r4, "place2", "place3", "time3",
                        "time4", "ticket2", "price2");
                r5 = stmt.executeQuery("select * from flight.flight where place1='" + b + "' and place3='" + c + "'");
                while (r5.next()) {
                    Flight2 flight = new Flight2();
                    flight.setFlightId(r5.getString("flight_id"));
                    flight.setAirway(r5.getString("airway"));
                    flight.setStatus(r5.getString("status"));
                    flight.setPlace1(r5.getString("place1"));
                    flight.setPlace2(r5.getString("place3"));
                    flight.setTime1(r5.getString("time1"));
                    flight.setTime2(r5.getString("time4"));
                    flight.setTicket(r5.getInt("ticket1") + r5.getInt("ticket2"));
                    flight.setPrice(r5.getInt("price1") + r5.getInt("price2"));
                    flightList.add(flight);
                }
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
        if (d.equals("票价"))
            FXCollections.sort(flightList, Comparator.comparing((Flight2 s) -> s.getPrice()));
        else if (d.equals("飞行时间")) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            FXCollections.sort(flightList, Comparator.comparing((Flight2 s) -> {
                try {
                    return (int) (sdf.parse(s.getTime2()).getTime() -
                            sdf.parse(s.getTime1()).getTime()) / (1000 * 60);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return 0;
            }));

        } else if (d.equals("余票数量"))
            FXCollections.sort(flightList, Comparator.comparing((Flight2 s) -> 0 - s.getTicket()));
        return flightList;//Returns the result
    }

    //Searches for flights between specified cities without delays
    /*public ObservableList<Flight2> seekFlightWithoutDelay(String c, String d) {
        ObservableList<Flight2> flightList = FXCollections.observableArrayList();
        Connection conn = null;
        try {
            conn = DatabaseConnection.getCon();
            Statement stmt = conn.createStatement();
            ResultSet r1, r2, r3, r4, r5;
            if (!a.equals("不限")) {
                r1 = stmt.executeQuery("select * from flight.flight where flight_id='" + a + "'");
                while (r1.next()) {
                    Flight flight = new Flight();
                    flight.setIsStop(r1.getBoolean("is_stop"));
                    r1.previous();
                    if (flight.getIsStop()) {
                        flightList = setFlight2(flightList, r1, "place1", "place2", "time1",
                                "time2", "ticket1", "price1");
                        r2 = stmt.executeQuery("select * from flight.flight where flight_id='" + a + "'");
                        flightList = setFlight2(flightList, r2, "place2", "place3", "time3",
                                "time4", "ticket2", "price2");
                    } else {
                        flightList = setFlight2(flightList, r1, "place1", "place3", "time1",
                                "time4", "ticket1", "price1");
                    }
                    break;
                }
                return flightList;
            } else {
                r3 = stmt.executeQuery("select * from flight.flight where place1='" + b + "' and place2='" + c + "'");
                flightList = setFlight2(flightList, r3, "place1", "place2", "time1",
                        "time2", "ticket1", "price1");
                r4 = stmt.executeQuery("select * from flight.flight where place2='" + b + "' and place3='" + c + "'");
                flightList = setFlight2(flightList, r4, "place2", "place3", "time3",
                        "time4", "ticket2", "price2");
                r5 = stmt.executeQuery("select * from flight.flight where place1='" + b + "' and place3='" + c + "'");
                while (r5.next()) {
                    Flight2 flight = new Flight2();
                    flight.setFlightId(r5.getString("flight_id"));
                    flight.setAirway(r5.getString("airway"));
                    flight.setStatus(r5.getString("status"));
                    flight.setPlace1(r5.getString("place1"));
                    flight.setPlace2(r5.getString("place3"));
                    flight.setTime1(r5.getString("time1"));
                    flight.setTime2(r5.getString("time4"));
                    flight.setTicket(r5.getInt("ticket1") + r5.getInt("ticket2"));
                    flight.setPrice(r5.getInt("price1") + r5.getInt("price2"));
                    flightList.add(flight);
                }
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
        return flightList;
    }*/

    private ObservableList<Flight2> setFlight2(ObservableList<Flight2> flightList, ResultSet rs, String place1, String
            place2, String time1, String time2, String ticket, String price) {
        try {
            while (rs.next()) {
                Flight2 flight = new Flight2();
                flight.setFlightId(rs.getString("flight_id"));
                flight.setAirway(rs.getString("airway"));
                flight.setStatus(rs.getString("status"));
                flight.setPlace1(rs.getString(place1));
                flight.setPlace2(rs.getString(place2));
                flight.setTime1(rs.getString(time1));
                flight.setTime2(rs.getString(time2));
                flight.setTicket(rs.getInt(ticket));
                flight.setPrice(rs.getInt(price));
                flightList.add(flight);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flightList;
    }
}