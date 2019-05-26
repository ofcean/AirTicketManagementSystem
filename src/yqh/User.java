package yqh;

//import com.sun.org.apache.xpath.internal.operations.String;
import spg.function.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class User {
    public String id;//ID
    public ArrayList ticketlist = new ArrayList();//已购航班

    public void setId(String userid) {//参数为航班号，返回指定航班，未完成
        id=userid;
    }

    public Order buy(Flight x, Type.PlaceEnum t){//购票，参数为航班x和上下机情况t，购票成功返回Order对象r并修改x，失败返回空订单，x无变化，此方法不改变数据库
        Order r=new Order(null,null,null,0);//初始化为空订单，属性皆为null
        r.setIndex(0);
        int p[]=new int[2];
        p[0]=x.getTicket1();
        p[1]=x.getTicket2();
        switch (t){ //检查余票，无余票返回r退出。有则余票数减1
            case FULL:
                if(p[0]==0||p[1]==0)
                    return r;
                p[0]--;
                p[1]--;
                x.setTicket1(p[0]);
                x.setTicket2(p[1]);
                r.setLeg(3);
                break;
            case FIRST:
                if(p[0]==0)
                    return r;
                p[0]--;
                x.setTicket1(p[0]);
                r.setLeg(1);
                break;
            case SECOND:
                if(p[1]==0)
                    return r;
                p[1]--;
                x.setTicket2(p[1]);
                r.setLeg(2);
                break;
        }
        r.setFlightId(x.getFlightId());
        r.setOrderStatus("已出票");
        r.setPassengerId(id);
        return r;
    }

    public boolean buyDB(Flight x, Type.PlaceEnum t){//购票，参数为航班x和上下机情况t，并更新数据库，成功返回true，失败返回false
        try{
            Connection conn=DatabaseConnection.getCon();
            conn.setAutoCommit(false);
            Statement s=conn.createStatement();
            Order r=buy(x,t);
            if(r.getFlightId()==null&&r.getPassengerId()==null)
                return false;
            ResultSet rs = s.executeQuery("select max(index) from flight.order;");
            int orderid=0;
            if(rs.next()) {//目前order中最大ID加1作为新orderID，若目前无order则新ID为0
                rs.previous();
                orderid=rs.getInt(1)+1;
            }
            s.execute("update flight.flight set ticket1="+x.getTicket1()+",ticket2="+x.getTicket2()+" where flight_id="+x.getFlightId()+";");
            s.execute("insert into flight.order values ("+orderid+",'"+r.getPassengerId()+"','"+r.getFlightId()+"','"+r.getOrderStatus()+"','"+r.getLeg()+"')");
            s.close();
            conn.commit();
            conn.close();
        }catch (Exception e){

        }
        return true;
    }

    public boolean reservationDB(Flight x, Type.PlaceEnum t){//预约抢票，参数为航班x和上下机情况t,购票成功返回true，并更新数据库,失败返回false
        Order r=new Order(null,null,null,0);
        switch (t){
            case FULL:
                r.setLeg(3);
                break;
            case FIRST:
                r.setLeg(1);
                break;
            case SECOND:
                r.setLeg(2);
                break;
        }
        r.setFlightId(x.getFlightId());
        r.setPassengerId(id);
        r.setOrderStatus("预约中");
        try{
            Connection conn=DatabaseConnection.getCon();
            conn.setAutoCommit(false);
            Statement s=conn.createStatement();
            if(r.getFlightId()==null&&r.getPassengerId()==null)
                return false;
            ResultSet rs = s.executeQuery("select max(index) from flight.order;");
            int orderid=0;
            if(rs.next()) {//目前order中最大ID加1作为新orderID，若目前无order则新ID为0
                rs.previous();
                orderid=rs.getInt(1)+1;
            }
            s.execute("insert into flight.order values ("+orderid+",'"+r.getPassengerId()+"','"+r.getFlightId()+"','"+r.getOrderStatus()+"','"+r.getLeg()+"')");
            s.close();
            conn.commit();
            conn.close();
        }catch (Exception e){

        }
        return true;
    }

    public int buyres(String flightId,Type.PlaceEnum t){//购票与预约功能，需要参数航班ID和航程类型t，普通购票成功返回1，没有余票自动预约并返回2，都失败返回0
        Flight x=new Flight();
        try{
            Connection conn=DatabaseConnection.getCon();
            conn.setAutoCommit(false);
            Statement s=conn.createStatement();
            ResultSet rs = s.executeQuery("select * from flight.flight where flight_id="+flightId+";");
            String place[]=new String[3];
            place[0]=rs.getString("place1");
            place[1]=rs.getString("place2");
            place[2]=rs.getString("place3");
            String time[]=new String[4];
            time[0]=rs.getString("time1");
            time[1]=rs.getString("time2");
            time[2]=rs.getString("time3");
            time[3]=rs.getString("time4");
            int ticket[]=new int[2];
            ticket[0]=rs.getInt("ticket1");
            ticket[0]=rs.getInt("ticket2");
            int price[]=new int[2];
            ticket[0]=rs.getInt("price1");
            ticket[0]=rs.getInt("price2");
            x.addFlight(rs.getString("flight_id"),rs.getString("airway"), place,time, rs.getBoolean("is_stop"),ticket,price);
            s.close();
            rs.close();
            conn.commit();
            conn.close();
        }catch (Exception e){

        }
        if (buyDB(x,t))
            return 1;
        else if (reservationDB(x,t))
            return 2;
        else
            return 0;
    }

    /*public void refund(Flight x, Ticket rt){//退票，参数为航班x和要退的票t
        Type.PlaceEnum t=rt.placetype;
        int[] p=x.getResTicket();
        String uid;
        for(int i=0;i<x.getWaybill().length;i++)//更新x的乘客列表
            if(x.getWaybill()[i]==id){
                int[] item = new int[MAXCAPACITY];
                item=x.getWaybill();
                item[i]=0;
                x.setWaybill(item);
                break;
            }
        switch (t){
            case FULL:
                Queue<String> q = x.getAppointList();
                p[0]++;
                p[1]++;
                x.setResTicket(p);
                if(q.size()!=0){
                    uid=q.poll();
                    String qt[]=new String[q.size()];
                    for(int i=0;i<q.size();i++)
                        qt[i]=q.poll();
                    x.setAppointList(qt);
                    //User y=search(uid);           //search方法通过乘客ID搜索乘客，并返回乘客对象，未实现
                    //y.buy(x,FULL);
                }
                break;
            case FIRST:
                Queue<String> q1 = x.getAppointList1();
                p[0]++;
                x.setResTicket(p);
                if(q1.size()!=0){
                    uid=q1.poll();
                    String qt[]=new String[q1.size()];
                    for(int i=0;i<q1.size();i++)
                        qt[i]=q1.poll();
                    x.setAppointList1(qt);
                    //User y=search(uid);
                    //y.buy(x,FIRST);
                }
                break;
            case SECOND:
                Queue<String> q2 = x.getAppointList2();
                p[1]++;
                x.setResTicket(p);
                if(q2.size()!=0){
                    uid=q2.poll();
                    String qt[]=new String[q2.size()];
                    for(int i=0;i<q2.size();i++)
                        qt[i]=q2.poll();
                    x.setAppointList2(qt);
                    //User y=search(uid);
                    //y.buy(x,SECOND);
                }
                break;
        }
        return;
    }*/
}
