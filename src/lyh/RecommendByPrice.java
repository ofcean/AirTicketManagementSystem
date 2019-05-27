package lyh;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import spg.function.DatabaseConnection;
import spg.function.Flight;
import spg.function.Tool;
import spg.function.Flight2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RecommendByPrice implements Tool {
    //按起飞地点找
    public ObservableList<Flight> SeekTakeoff(String place) {
        ObservableList<Flight> flightList = FXCollections.observableArrayList();
        Connection conn = null;
        try {
            conn = DatabaseConnection.getCon();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from flight.flight where place1 = '" + place + "'");
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
        return flightList;
    }

    //按降落地点找
    public ObservableList<Flight> SeekLanding(String place) {
        ObservableList<Flight> flightList = FXCollections.observableArrayList();
        Connection conn = null;
        try {
            conn = DatabaseConnection.getCon();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from flight.flight where place3 = '" + place + "'");
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
        return flightList;
    }


    //配对1，SeekTakeoff.palce2==SeekLanding.place1
    public ObservableList<Flight2> FlightMatches1(ObservableList<Flight> takeoff, ObservableList<Flight> landing) {
        ObservableList<Flight> flightList = FXCollections.observableArrayList();
        for (int i = 0; i < takeoff.size(); i++)
            for (int j = 0; j < landing.size(); j++) {
                if (takeoff.get(i).getIsStop()) {
                    String takoff = takeoff.get(i).getPlace2();
                    String laning = landing.get(j).getPlace1();
                    if (takoff.equals(laning)) {
                        flightList.add(takeoff.get(i));
                        flightList.add(landing.get(j));
                    }
                }
            }
        ObservableList<Flight2> flightList2 = FXCollections.observableArrayList();
        for (int m = 0; m < flightList.size(); m = m + 2) {
            Flight2 fli2 = new Flight2();
            fli2.setFlightId(flightList.get(m).getFlightId());
            fli2.setAirway(flightList.get(m).getAirway());
            fli2.setStatus(flightList.get(m).getStatus());
            fli2.setTicket(flightList.get(m).getTicket1());
            fli2.setPlace1(flightList.get(m).getPlace1());
            fli2.setPlace2(flightList.get(m).getPlace2());
            fli2.setTime1(flightList.get(m).getTime1());
            fli2.setTime2(flightList.get(m).getTime2());
            fli2.setPrice(flightList.get(m).getPrice1());
            flightList2.add(m, fli2);
        }
        for (int m = 1; m < flightList.size(); m = m + 2) {
            Flight2 fli2 = new Flight2();
            fli2.setFlightId(flightList.get(m).getFlightId());
            fli2.setAirway(flightList.get(m).getAirway());
            fli2.setStatus(flightList.get(m).getStatus());

            if (flightList.get(m).getTicket2() == 0) {
                fli2.setTicket(flightList.get(m).getTicket1());
            } else {
                if (flightList.get(m).getTicket2() < flightList.get(m).getTicket1())  //按票少的算
                {
                    fli2.setTicket(flightList.get(m).getTicket2());
                }
                fli2.setTicket(flightList.get(m).getTicket1());
            }
            fli2.setPlace1(flightList.get(m).getPlace1());
            fli2.setPlace2(flightList.get(m).getPlace3());
            fli2.setTime1(flightList.get(m).getTime1());
            fli2.setTime2(flightList.get(m).getTime4());
            fli2.setPrice(flightList.get(m).getPrice1());
            flightList2.add(m, fli2);
        }
        return flightList2;
    }

    //配对2，SeekTakeoff.palce3==SeekLanding.place1
    public ObservableList<Flight2> FlightMatches2(ObservableList<Flight> takeoff, ObservableList<Flight> landing) {
        ObservableList<Flight> flightList = FXCollections.observableArrayList();
        System.out.println(landing.size());
        for (int i = 0; i < takeoff.size(); i++)
            for (int j = 0; j < landing.size(); j++) {
                String takoff = takeoff.get(i).getPlace3();
                String laning = landing.get(j).getPlace1();
                if (takoff.equals(laning)) {
                    flightList.add(takeoff.get(i));
                    flightList.add(landing.get(j));
                }
            }
        ObservableList<Flight2> flightList2 = FXCollections.observableArrayList();
        for (int m = 0; m < flightList.size(); m = m + 2) {
            Flight2 fli2 = new Flight2();
            fli2.setFlightId(flightList.get(m).getFlightId());
            fli2.setAirway(flightList.get(m).getAirway());
            fli2.setStatus(flightList.get(m).getStatus());


            if (flightList.get(m).getTicket2() == 0) {
                fli2.setTicket(flightList.get(m).getTicket1());
            } else {
                if (flightList.get(m).getTicket2() < flightList.get(m).getTicket1())  //按票少的算
                {
                    fli2.setTicket(flightList.get(m).getTicket2());
                }
                fli2.setTicket(flightList.get(m).getTicket1());

            }

            fli2.setPlace1(flightList.get(m).getPlace1());
            fli2.setPlace2(flightList.get(m).getPlace3());
            fli2.setTime1(flightList.get(m).getTime1());
            fli2.setTime2(flightList.get(m).getTime4());
            fli2.setPrice(flightList.get(m).getPrice1());
            flightList2.add(m, fli2);
        }
        for (int m = 1; m < flightList.size(); m = m + 2) {
            Flight2 fli2 = new Flight2();
            fli2.setFlightId(flightList.get(m).getFlightId());
            fli2.setAirway(flightList.get(m).getAirway());
            fli2.setStatus(flightList.get(m).getStatus());

            if (flightList.get(m).getTicket2() == 0) {
                fli2.setTicket(flightList.get(m).getTicket1());
            } else {
                if (flightList.get(m).getTicket2() < flightList.get(m).getTicket1())  //按票少的算
                {
                    fli2.setTicket(flightList.get(m).getTicket2());
                }
                fli2.setTicket(flightList.get(m).getTicket1());
            }
            fli2.setPlace1(flightList.get(m).getPlace1());
            fli2.setPlace2(flightList.get(m).getPlace3());
            fli2.setTime1(flightList.get(m).getTime1());
            fli2.setTime2(flightList.get(m).getTime4());
            fli2.setPrice(flightList.get(m).getPrice1());
            flightList2.add(m, fli2);
        }
        return flightList2;
    }

    //配对3，SeekTakeoff.palce2==SeekLanding.place2
    public ObservableList<Flight2> FlightMatches3(ObservableList<Flight> takeoff, ObservableList<Flight> landing) {
        ObservableList<Flight> flightList = FXCollections.observableArrayList();
        for (int i = 0; i < takeoff.size(); i++)
            for (int j = 0; j < landing.size(); j++) {
                if (takeoff.get(i).getIsStop() && landing.get(j).getIsStop()) {
                    String takoff = takeoff.get(i).getPlace2();
                    String laning = landing.get(j).getPlace2();
                    if (takoff.equals(laning)) {
                        flightList.add(takeoff.get(i));
                        flightList.add(landing.get(j));
                    }
                }
            }
        ObservableList<Flight2> flightList2 = FXCollections.observableArrayList();
        for (int m = 0; m < flightList.size(); m = m + 2) {
            Flight2 fli2 = new Flight2();
            fli2.setFlightId(flightList.get(m).getFlightId());
            fli2.setAirway(flightList.get(m).getAirway());
            fli2.setStatus(flightList.get(m).getStatus());
            fli2.setStatus(flightList.get(m).getStatus());

            fli2.setTicket(flightList.get(m).getTicket1());

            fli2.setPlace1(flightList.get(m).getPlace1());
            fli2.setPlace2(flightList.get(m).getPlace2());
            fli2.setTime1(flightList.get(m).getTime1());
            fli2.setTime2(flightList.get(m).getTime2());
            fli2.setPrice(flightList.get(m).getPrice1());
            flightList2.add(m, fli2);
        }
        for (int m = 1; m < flightList.size(); m = m + 2) {
            Flight2 fli2 = new Flight2();
            fli2.setFlightId(flightList.get(m).getFlightId());
            fli2.setAirway(flightList.get(m).getAirway());
            fli2.setStatus(flightList.get(m).getStatus());

            fli2.setTicket(flightList.get(m).getTicket2());

            fli2.setPlace1(flightList.get(m).getPlace2());
            fli2.setPlace2(flightList.get(m).getPlace3());
            fli2.setTime1(flightList.get(m).getTime3());
            fli2.setTime2(flightList.get(m).getTime4());
            fli2.setPrice(flightList.get(m).getPrice2());
            flightList2.add(m, fli2);
        }
        return flightList2;
    }

    //配对4，SeekTakeoff.palce3==SeekLanding.place2
    public ObservableList<Flight2> FlightMatches4(ObservableList<Flight> takeoff, ObservableList<Flight> landing) {
        ObservableList<Flight> flightList = FXCollections.observableArrayList();
        for (int i = 0; i < takeoff.size(); i++)
            for (int j = 0; j < landing.size(); j++) {
                String takoff = takeoff.get(i).getPlace1();
                String laning = landing.get(j).getPlace3();
                if (takoff.equals(laning)) {
                    flightList.add(takeoff.get(i));
                    flightList.add(landing.get(j));
                }
            }
        ObservableList<Flight2> flightList2 = FXCollections.observableArrayList();
        for (int m = 0; m < flightList.size(); m = m + 2) {
            Flight2 fli2 = new Flight2();
            fli2.setFlightId(flightList.get(m).getFlightId());
            fli2.setAirway(flightList.get(m).getAirway());
            fli2.setStatus(flightList.get(m).getStatus());
            fli2.setStatus(flightList.get(m).getStatus());

            if (flightList.get(m).getTicket2() == 0) {
                fli2.setTicket(flightList.get(m).getTicket1());
            } else {
                if (flightList.get(m).getTicket2() < flightList.get(m).getTicket1())  //按票少的算
                {
                    fli2.setTicket(flightList.get(m).getTicket2());
                }
                fli2.setTicket(flightList.get(m).getTicket1());
            }
            fli2.setPlace1(flightList.get(m).getPlace1());
            fli2.setPlace2(flightList.get(m).getPlace3());
            fli2.setTime1(flightList.get(m).getTime1());
            fli2.setTime2(flightList.get(m).getTime4());
            fli2.setPrice(flightList.get(m).getPrice1());
            flightList2.add(m, fli2);
        }
        for (int m = 1; m < flightList.size(); m = m + 2) {
            Flight2 fli2 = new Flight2();
            fli2.setFlightId(flightList.get(m).getFlightId());
            fli2.setAirway(flightList.get(m).getAirway());
            fli2.setStatus(flightList.get(m).getStatus());

            fli2.setTicket(flightList.get(m).getTicket2());

            fli2.setPlace1(flightList.get(m).getPlace2());
            fli2.setPlace2(flightList.get(m).getPlace3());
            fli2.setTime1(flightList.get(m).getTime3());
            fli2.setTime2(flightList.get(m).getTime4());
            fli2.setPrice(flightList.get(m).getPrice2());
            flightList2.add(m, fli2);
        }
        return flightList2;
    }

    //四种配对整合
    public ObservableList<Flight2> Flightunion(ObservableList<Flight2> fli1, ObservableList<Flight2> fli2, ObservableList<Flight2> fli3, ObservableList<Flight2> fli4) {
        ObservableList<Flight2> flightList = FXCollections.observableArrayList();
        for (int i = 0; i < fli1.size(); i++) {
            flightList.add(fli1.get(i));
        }
        for (int j = 0; j < fli2.size(); j++) {
            flightList.add(fli2.get(j));
        }
        for (int k = 0; k < fli3.size(); k++) {
            flightList.add(fli3.get(k));
        }
        for (int m = 0; m < fli4.size(); m++) {
            flightList.add(fli4.get(m));
        }
        return flightList;
    }


    //选出价格最便宜的一组，返回只有两个对象的数组
    public ObservableList<Flight2> FlightPriceRecommend(ObservableList<Flight2> fliList) {
        ObservableList<Flight2> flightList = FXCollections.observableArrayList();
        int minprice = 0, price = 0;
        try {
            for (int i = 0; i < fliList.size(); i = i + 2) {
                price = fliList.get(i).getPrice() + fliList.get(i + 1).getPrice();
                if (minprice == 0) {
                    minprice = price;
                    flightList.add(fliList.get(i));       //修改
                    flightList.add(fliList.get(i + 1));
                } else if (price < minprice) {
                    minprice = price;
                    flightList.remove(0);
                    flightList.remove(0);
                    flightList.add(fliList.get(i));        //修改
                    flightList.add(fliList.get(i + 1));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flightList;
    }


    public ObservableList<Flight2> PriceRecommend(String place1, String place2) {
        RecommendByPrice op = new RecommendByPrice();
        ObservableList<Flight> seekTakeoff = op.SeekTakeoff(place1);
        ObservableList<Flight> seekLanding = op.SeekLanding(place2);
        ObservableList<Flight2> flightMatches1 = op.FlightMatches1(seekTakeoff, seekLanding);
        ObservableList<Flight2> flightMatches2 = op.FlightMatches2(seekTakeoff, seekLanding);
        ObservableList<Flight2> flightMatches3 = op.FlightMatches3(seekTakeoff, seekLanding);
        ObservableList<Flight2> flightMatches4 = op.FlightMatches4(seekTakeoff, seekLanding);
        ObservableList<Flight2> flightunion = op.Flightunion(flightMatches1, flightMatches2, flightMatches3, flightMatches4);
        ObservableList<Flight2> flightPriceRecommend = op.FlightPriceRecommend(flightunion);
        return flightPriceRecommend;
    }

}