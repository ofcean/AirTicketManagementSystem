package yqh;

import spg.function.Flight;

public class Ticket {
    public String flightNum;//航班号
    public String place[]=new String[2];//起飞地点，降落地点
    public Type.PlaceEnum placetype;
    public int fare;//机票价格
    public Ticket(){}
    public Ticket(Flight x, Type.PlaceEnum t) {
        placetype=t;
        flightNum=x.getFlightId();
        switch (t){
            case FULL:
                place[0]=x.getPlace1();
                place[1]=x.getPlace3();
                fare=x.getPrice1()+x.getPrice2();
                break;
            case FIRST:
                place[0]=x.getPlace1();
                place[1]=x.getPlace2();
                fare=x.getPrice1();
                break;
            case SECOND:
                place[0]=x.getPlace2();
                place[1]=x.getPlace3();
                fare=x.getPrice2();
                break;
        }
    }
}
