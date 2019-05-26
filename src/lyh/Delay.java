package lyh;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import spg.function.*;
import spg.function.FlightOperation;
import spg.function.Tool;
import java.lang.String;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
//search update
public class Delay implements Tool {


    public LocalDate[] DelayFlighTDates(String flightNum){         //输入航班号，获取时间
        LocalDate[] Date=new LocalDate[4];
        FlightOperation operation = new FlightOperation();
        ObservableList<Flight> flightList = FXCollections.observableArrayList();
        flightList=operation.seekFlight(flightNum,"不限制","不限制");
        Flight fli=flightList.get(0);
        Date[0]=LocalDate.parse(fli.getTime1().substring(0, 10), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Date[1]=LocalDate.parse(fli.getTime2().substring(0, 10), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Date[2]=LocalDate.parse(fli.getTime3().substring(0, 10), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Date[3]=LocalDate.parse(fli.getTime4().substring(0, 10), DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        return Date;
    }

    public LocalDate[] DelayFlighTtimes(String flightNum){     //输入航班号，获取日期
        LocalDate[] Time=new LocalDate[4];
        FlightOperation operation = new FlightOperation();
        ObservableList<Flight> flightList = FXCollections.observableArrayList();
        flightList=operation.seekFlight(flightNum,"不限制","不限制");
        Flight fli=flightList.get(0);
        Time[0]=LocalDate.parse(fli.getTime1().substring(11, 19), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Time[1]=LocalDate.parse(fli.getTime2().substring(11, 19), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Time[2]=LocalDate.parse(fli.getTime3().substring(11, 19), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Time[3]=LocalDate.parse(fli.getTime4().substring(11, 19), DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        return Time;
    }

    public void DelayTimeUpdate1(String flightNum,String time1,String time2,String time3,String time4,String date1,String date2,String date3,String date4){  //输入时间日期，更新
        FlightOperation operation = new FlightOperation();
        ObservableList<Flight> flightList = FXCollections.observableArrayList();
        flightList=operation.seekFlight(flightNum,"不限制","不限制");
        Flight fli=flightList.get(0);
        String[] tim=new String[4];
        tim[0]=date1 + '-' + time1;
        tim[1]=date2 + '-' + time2;
        tim[2]=date3 + '-' + time3;
        tim[3]=date4 + '-' + time4;
        fli.setTime1(time1);
        fli.setTime2(time2);
        fli.setTime3(time3);
        fli.setTime4(time4);
        fli.setStatus("delayed");              //状态变为延误
        operation.deleteFlight(flightNum);
        operation.saveFlight(fli);
    }


    public ObservableList<Flight> DelayRecommend(String place1,String place2){   //始发，终点，推荐
        FlightOperation operation = new FlightOperation();
        ObservableList<Flight> flightList = FXCollections.observableArrayList();
        flightList=operation.seekFlight("不限制",place1,place2); //if delayed
        return flightList;
    }
}