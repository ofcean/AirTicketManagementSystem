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
        id = userid;
    }

    public Order buy(Flight x, Type.PlaceEnum t) {//购票，参数为航班x和上下机情况t，购票成功返回Order对象r并修改x，失败返回空订单，x无变化，此方法不改变数据库
        Order r = new Order(null, null, null, 0);//初始化为空订单，属性皆为null
        r.setIndex(0);
        int p[] = new int[2];
        p[0] = x.getTicket1();
        p[1] = x.getTicket2();
        switch (t) { //检查余票，无余票返回r退出。有则余票数减1
            case FULL:
                if (p[0] == 0 || p[1] == 0)
                    return r;
                p[0]--;
                p[1]--;
                x.setTicket1(p[0]);
                x.setTicket2(p[1]);
                r.setLeg(3);
                break;
            case FIRST:
                if (p[0] == 0)
                    return r;
                p[0]--;
                x.setTicket1(p[0]);
                r.setLeg(1);
                break;
            case SECOND:
                if (p[1] == 0)
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

    public boolean buyDB(Flight x, Type.PlaceEnum t) {//购票，参数为航班x和上下机情况t，并更新数据库，成功返回true，失败返回false
        try {
            Connection conn = DatabaseConnection.getCon();
            conn.setAutoCommit(false);
            Statement s = conn.createStatement();
            Order r = buy(x, t);
            if (r.getFlightId() == null && r.getPassengerId() == null)
                return false;
            ResultSet rs = s.executeQuery("select * from flight.order_list");
            int orderid = 0;
            while (rs.next()) {
                if (rs.getInt("index") > orderid)
                    orderid = rs.getInt("index");
            }
            orderid += 1;
            s.execute("update flight.flight set ticket1=" + x.getTicket1() + " and ticket2=" + x.getTicket2() + " where flight_id='" + x.getFlightId() + "'");
            s.execute("insert into flight.order_list values (" + orderid + ", '" + r.getPassengerId() + "','" + r.getFlightId() + "','" + r.getOrderStatus() + "'," + r.getLeg() + ")");
            s.close();
            rs.close();
            conn.commit();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean reservationDB(Flight x, Type.PlaceEnum t) {//预约抢票，参数为航班x和上下机情况t,购票成功返回true，并更新数据库,失败返回false
        Order r = new Order(null, null, null, 0);
        switch (t) {
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
        try {
            Connection conn = DatabaseConnection.getCon();
            conn.setAutoCommit(false);
            Statement s = conn.createStatement();
            if (r.getFlightId() == null && r.getPassengerId() == null)
                return false;
            ResultSet rs = s.executeQuery("select * from flight.order_list");
            int orderid = 0;
            while (rs.next()) {
                if (rs.getInt("index") > orderid)
                    orderid = rs.getInt("index");
            }
            orderid += 1;
            s.execute("insert into flight.order values (" + orderid + ",'" + r.getPassengerId() + "','" + r.getFlightId() + "','" + r.getOrderStatus() + "'," + r.getLeg() + ")");
            s.close();
            rs.close();
            conn.commit();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public int buyres(String flightId, Type.PlaceEnum t) {//购票与预约功能，需要参数航班ID和航程类型t，普通购票成功返回1，没有余票自动预约并返回2，都失败返回0
        Flight x = new Flight();
        try {
            Connection conn = DatabaseConnection.getCon();
            conn.setAutoCommit(false);
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("select * from flight.flight where flight_id='" + flightId + "'");
            while (rs.next()) {
                String place[] = new String[3];
                place[0] = rs.getString("place1");
                place[1] = rs.getString("place2");
                place[2] = rs.getString("place3");
                String time[] = new String[4];
                time[0] = rs.getString("time1");
                time[1] = rs.getString("time2");
                time[2] = rs.getString("time3");
                time[3] = rs.getString("time4");
                int ticket[] = new int[2];
                ticket[0] = rs.getInt("ticket1");
                ticket[1] = rs.getInt("ticket2");
                int price[] = new int[2];
                price[0] = rs.getInt("price1");
                price[1] = rs.getInt("price2");
                x.addFlight(rs.getString("flight_id"), rs.getString("airway"), place, time, rs.getBoolean("is_stop"), ticket, price);
            }
            conn.commit();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (buyDB(x, t))
            return 1;
        else if (reservationDB(x, t))
            return 2;
        else
            return 0;
    }

    public void refundDB(int orderid){//退票，参数为航班x和要退的票t
        Order n=new Order(null,null,null,0);
        n.setIndex(orderid);
        try {
            Connection conn = DatabaseConnection.getCon();
            conn.setAutoCommit(false);
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("select * from flight.order_list where index=" + orderid + "");
            String place[] = new String[3];
            while (rs.next()) {
                n.setOrderStatus(rs.getString("status"));
                n.setLeg(rs.getInt("leg"));
                n.setFlightId(rs.getString("flight_id"));
            }
            s.execute("delete from flight.order_list where index=" + orderid + "");
            if(n.getOrderStatus()=="已出票") {
                rs=s.executeQuery("select * from flight.order");
                int minid=9999;
                while (rs.next()) {
                    if (rs.getInt("index") < minid && rs.getString("status")=="预约中" && rs.getInt("leg")==n.getLeg())
                        minid = rs.getInt("index");
                }
                if(minid==9999){
                    rs=s.executeQuery("select * from flight.flight where flight_id='"+n.getFlightId()+"'");
                    int ticket[]=new int[2];
                    ticket[0]=rs.getInt("ticket1");
                    ticket[1]=rs.getInt("ticket2");
                    switch (n.getLeg()){
                        case 1:
                            ticket[0]++;
                            break;
                        case 2:
                            ticket[1]++;
                            break;
                        case 3:
                            ticket[0]++;
                            ticket[1]++;
                            break;
                    }
                    s.executeUpdate("update flight.flight set ticket1=" + ticket[0] + " and ticket2=" + ticket[1] + " where flight_id='" + n.getFlightId() + "'");
                }
                else{
                    s.executeUpdate("update flight.order set status='已出票' where index="+minid+"");
                }
            }
            conn.commit();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
