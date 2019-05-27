package yqh;

//import com.sun.org.apache.xpath.internal.operations.String;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import spg.function.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class User {
    public String id;//ID
    public ArrayList ticketlist = new ArrayList();//已购航班

    public void setId(String userid) {//参数为航班号，返回指定航班，未完成
        id = userid;
    }

    public Order buy(Flight x, Type.PlaceEnum t) {//购票，参数为航班x和上下机情况t，购票成功返回Order对象r并修改x，失败返回空订单，x无变化，此方法不改变数据库
        Order r = new Order(0, null, null, null, 0);//初始化为空订单，属性皆为null
        int p[] = new int[2];
        p[0] = x.getTicket1();

        System.out.println(p[0]);
        System.out.println(p[1]);
        switch (t) { //检查余票，无余票返回r退出。有则余票数减1
            case FULL:
                if (p[0] == 0 || p[1] == 0)
                    return r;
                p[0]--;
                p[1]--;
                System.out.println(p[0]);
                System.out.println(p[1]);
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
        Order r = new Order(0, null, null, null, 0);
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

    public void refundDB(int orderid) {//退票，参数为航班x和要退的票t
        Order n = new Order(0, null, null, null, 0);
        n.setIndex(orderid);
        try {
            Connection conn = DatabaseConnection.getCon();
            conn.setAutoCommit(false);
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("select * from flight.order_list where index = " + orderid + "");
            String place[] = new String[3];
            while (rs.next()) {
                n.setOrderStatus(rs.getString("status"));
                n.setLeg(rs.getInt("leg"));
                n.setFlightId(rs.getString("flight_id"));
            }
            s.execute("delete from flight.order_list where index=" + orderid + "");
            if (n.getOrderStatus() == "已出票") {
                rs = s.executeQuery("select * from flight.order");
                int minid = 9999;
                while (rs.next()) {
                    if (rs.getInt("index") < minid && rs.getString("status") == "预约中" && rs.getInt("leg") == n.getLeg())
                        minid = rs.getInt("index");
                }
                if (minid == 9999) {
                    rs = s.executeQuery("select * from flight.flight where flight_id='" + n.getFlightId() + "'");
                    int ticket[] = new int[2];
                    ticket[0] = rs.getInt("ticket1");
                    ticket[1] = rs.getInt("ticket2");
                    switch (n.getLeg()) {
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
                } else {
                    s.executeUpdate("update flight.order set status='已出票' where index=" + minid + "");
                }
            }
            conn.commit();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ObservableList<Flight2> timebest(String place1, String place2){
        List<Graph> head = new ArrayList<Graph>();
        Edge p=new Edge();
        Graph g=new Graph();
        List<Edge> q = new ArrayList<Edge>();
        int item,mintime;
        String fid;
        try {
            Connection conn = DatabaseConnection.getCon();
            conn.setAutoCommit(false);
            Statement s = conn.createStatement();
            ResultSet rs;
            for(int i=0;i<6;i++) {
                for (int j=0;j<6;j++) {
                    rs = s.executeQuery("select * from flight.flight where place1='"+intplace(i)+"' and place2='"+intplace(j)+"'");
                    int mintime1 = 9999;
                    String fid1=null;
                    while (rs.next()) {
                        item=timesub(rs.getString("time1"),rs.getString("time2"));
                        if (item < mintime1) {
                            mintime1 = item;
                            fid1=rs.getString("flight_id");
                        }
                    }
                    rs = s.executeQuery("select * from flight.flight where place2='"+intplace(i)+"' and place3='"+intplace(j)+"'");
                    int mintime2 = 9999;
                    String fid2=null;
                    while (rs.next()) {
                        item=timesub(rs.getString("time3"),rs.getString("time4"));
                        if (item < mintime2) {
                            mintime2 = item;
                            fid2=rs.getString("flight_id");
                        }
                    }
                    rs = s.executeQuery("select * from flight.flight where place1='"+intplace(i)+"' and place3='"+intplace(j)+"'");
                    int mintime3 = 9999;
                    String fid3=null;
                    while (rs.next()) {
                        item=timesub(rs.getString("time1"),rs.getString("time4"));
                        if (item < mintime3) {
                            mintime3 = item;
                            fid3=rs.getString("flight_id");
                        }
                    }
                    if(mintime1<=mintime2) {
                        mintime = mintime1;
                        fid=fid1;
                        p.type=1;
                    }
                    else {
                        mintime = mintime2;
                        fid=fid2;
                        p.type=2;
                    }
                    if (mintime>mintime3){
                        mintime=mintime3;
                        fid=fid3;
                        p.type=3;
                    }
                    p.cost=mintime;
                    p.num=j;
                    p.start=i;
                    p.flightid=fid;
                    q.add(p);
                }
                g.num=i;
                g.p=q;
                head.add(g);
            }
            s.close();
            conn.commit();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        int path[]={-1,-1,-1,-1,-1,-1};
        int dist[]={Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE};
        int s[]={0,0,0,0,0,0};
        int v=placeint(place1),t=placeint(place2);
        dist[v]=0;
        s[v]=1;
        int u=v,k,pi=0,ldist;
        for(int j=0;j<5;j++){
            while(pi<head.get(v).p.size()){
                k=head.get(v).p.get(pi).num;
                if(s[k]!=1 && dist[u]+head.get(v).p.get(pi).cost<dist[k]){
                    dist[k]=dist[u]+head.get(v).p.get(pi).cost;
                    path[k]=u;
                }
                pi++;
            }
            ldist=Integer.MAX_VALUE;
            for (int i=0;i<6;i++)
                if (dist[i]<ldist && s[i]==0){
                    ldist=dist[i];
                    u=i;
                }
            s[u]=1;
            if (u==t)
                break;
        }
        int e;
        ObservableList<Flight2> bt = FXCollections.observableArrayList();
        List<Edge> best = new ArrayList<Edge>();
        while(path[u]!=-1){
            int j=0;
            while(u!=head.get(path[u]).p.get(j).num&&j<=head.get(path[u]).p.size()){
                j++;
            }
            best.add(0,head.get(path[u]).p.get(j));
            u=path[u];
        }
        for(int i=0;i<best.size();i++){
            Flight2 x = new Flight2();
            try {
                Connection conn = DatabaseConnection.getCon();
                conn.setAutoCommit(false);
                Statement s1 = conn.createStatement();
                ResultSet rs = s1.executeQuery("select * from flight.flight where flight_id='" + best.get(i).flightid + "'");
                while (rs.next()) {
                    String place[] = new String[2];
                    place[0] = intplace(best.get(i).start);
                    place[1] = intplace(best.get(i).num);
                    x.setPlace1(place[0]);
                    x.setPlace2(place[1]);
                    String time[] = new String[2];
                    if (best.get(i).type == 1) {
                        time[0] = rs.getString("time1");
                        time[1] = rs.getString("time2");
                    }else if(best.get(i).type==2){
                        time[0] = rs.getString("time3");
                        time[1] = rs.getString("time4");
                    }else{
                        time[0] = rs.getString("time1");
                        time[1] = rs.getString("time4");
                    }
                    x.setTime1(time[0]);
                    x.setTime2(time[1]);
                    int ticket;
                    if (best.get(i).type == 1) {
                        ticket=rs.getInt("ticket1");
                    }else if(best.get(i).type==2){
                        ticket=rs.getInt("ticket2");
                    }else{
                        ticket=rs.getInt("ticket1");
                    }
                    x.setTicket(ticket);
                    int price;
                    if (best.get(i).type == 1) {
                        price=rs.getInt("price1");
                    }else if(best.get(i).type==2){
                        price=rs.getInt("price2");
                    }else{
                        price=rs.getInt("price1");
                    }
                    x.setPrice(price);
                    x.setFlightId(rs.getString("flight_id"));
                    x.setAirway(rs.getString("airway"));
                    x.setStatus(rs.getString("status"));
                }
                conn.commit();
                conn.close();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            bt.add(x);
        }
        return bt;
    }

    public static int placeint(String place){
        switch (place){
            case "北京":
                return 0;
            case "上海":
                return 1;
            case "成都":
                return 2;
            case "重庆":
                return 3;
            case "广州":
                return 4;
            case "深圳":
                return 5;
            default:
                return -1;

        }
    }

    public static String intplace(int num){
        switch (num){
            case 0:
                return "北京";
            case 1:
                return "上海";
            case 2:
                return "成都";
            case 3:
                return "重庆";
            case 4:
                return "广州";
            case 5:
                return "深圳";
            default:
                return "";

        }
    }

    public static int timesub(String time1,String time2) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return (int) (sdf.parse(time2).getTime() - sdf.parse(time1).getTime()) / (1000 * 60);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
