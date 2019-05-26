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
public class Delay implements Tool {   //date4(1 2 3 4) time4(1 2 3 4)  buttonSearch4  buttonDelay4 textFlightId4
    /*void initialize() {  //给我航班号，返回四个时间，给我4个时间，存到数据库里去
        FlightOperation operation = new FlightOperation();
        Flight fli = operation.seekFlight(textFlightId4.getText(),"不限制","不限制");
        date41.setValue(LocalDate.parse(fli.getTime1().substring(0, 10), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        date42.setValue(LocalDate.parse(fli.getTime1().substring(0, 10), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        date43.setValue(LocalDate.parse(fli.getTime1().substring(0, 10), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        date44.setValue(LocalDate.parse(fli.getTime1().substring(0, 10), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        time41.setValue(LocalTime.parse(fli.getTime1().substring(11, 19), DateTimeFormatter.ofPattern("HH:mm:ss")));
        time42.setValue(LocalTime.parse(fli.getTime1().substring(11, 19), DateTimeFormatter.ofPattern("HH:mm:ss")));
        time43.setValue(LocalTime.parse(fli.getTime1().substring(11, 19), DateTimeFormatter.ofPattern("HH:mm:ss")));
        time44.setValue(LocalTime.parse(fli.getTime1().substring(11, 19), DateTimeFormatter.ofPattern("HH:mm:ss")));
        //修改
        String[] time=new String[4];
        time[0]=date41.getValue().toString() + '-' + time41.getValue().toString();
        time[1]=date42.getValue().toString() + '-' + time42.getValue().toString();
        time[2]=date43.getValue().toString() + '-' + time43.getValue().toString();
        time[3]=date44.getValue().toString() + '-' + time44.getValue().toString();
        fli.setTime1(time[0]);
        fli.setTime2(time[1]);
        fli.setTime3(time[2]);
        fli.setTime4(time[3]);
        operation.deleteFlight(textFlightId4.getText());
        operation.saveFlight(fli);
        //LocalDate.parse(btn.getTime1().substring(0, 10), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }*/

    public LocalDate[] DelayFlighTDates(String flightNum){
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

    public LocalDate[] DelayFlighTtimes(String flightNum){
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

    public void DelayTimeUpdate1(String flightNum,String time1,String time2,String time3,String time4){  //在UI自己输入time
        FlightOperation operation = new FlightOperation();
        ObservableList<Flight> flightList = FXCollections.observableArrayList();
        flightList=operation.seekFlight(flightNum,"不限制","不限制");
        Flight fli=flightList.get(0);
        fli.setTime1(time1);
        fli.setTime2(time2);
        fli.setTime3(time3);
        fli.setTime4(time4);
        operation.deleteFlight(flightNum);
        operation.saveFlight(fli);
    }
    public void DelayTimeUpdate2(String flightNum){  //在UI自己读取time
        String[] times=new String[4];
        FlightOperation operation = new FlightOperation();
        ObservableList<Flight> flightList = FXCollections.observableArrayList();
        //flightList=operation.seekFlight(flightNum,"不限制","不限制");
        Flight fli=new Flight();
        times[0] = date41.getValue().toString() + '-' + time41.getValue().toString();
        times[1] = date42.getValue().toString() + '-' + time42.getValue().toString();
        times[2] = date43.getValue().toString() + '-' + time43.getValue().toString();
        times[3] = date44.getValue().toString() + '-' + time44.getValue().toString();
        fli.setTime1(times[0]);
        fli.setTime2(times[1]);
        fli.setTime3(times[2]);
        fli.setTime4(times[3]);
        operation.deleteFlight(flightNum);
        operation.saveFlight(fli);
    }

    public void DelayStatusUpdate(String flightNum){
        FlightOperation operation = new FlightOperation();
        ObservableList<Flight> flightList = FXCollections.observableArrayList();
        flightList=operation.seekFlight(flightNum,"不限制","不限制");
        Flight fli=flightList.get(0);
        fli.setStatus("delayed");
        operation.deleteFlight(flightNum);
        operation.saveFlight(fli);
    }
    public ObservableList<Flight> DelayRecommend(String place1,String place2){   //始发，终点
        FlightOperation operation = new FlightOperation();
        ObservableList<Flight> flightList = FXCollections.observableArrayList();
        flightList=operation.seekFlight("不限制",place1,place2); //if delayed
        return flightList;
    }
}