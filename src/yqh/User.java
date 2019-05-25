package yqh;

import spg.function.*;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import  java.sql.SQLException;
import java.util.Queue;


public class User {
    public String id;//ID
    public ArrayList ticketlist = new ArrayList();//已购航班

    public Flight getflight(String flightNum) {//参数为航班号，返回指定航班，未完成
        Flight x = new Flight();
        return x;
    }
    public Order buy(Flight x, Type.PlaceEnum t){//购票，参数为航班x和上下机情况t，购票成功返回Order对象r并修改x，失败返回空订单，x无变化
        Order r=new Order(null,null,null,0);//初始化为空订单，属性皆为null
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
                break;
            case FIRST:
                if(p[0]==0)
                    return r;
                p[0]--;
                x.setTicket1(p[0]);
                break;
            case SECOND:
                if(p[1]==0)
                    return r;
                p[1]--;
                x.setTicket2(p[1]);
                break;
        }
        r.setFlightId(x.getFlightId());
        r.setOrderStatus("已出票");
        r.setPassengerId(id);
        return r;
    }

    public void buyDB(Flight x, Type.PlaceEnum t){
        try{
            Connection conn=DatabaseConnection.getCon();
            conn.setAutoCommit(false);
            Statement s=conn.createStatement();
            Order r=buy(x,t);
            s.execute("update flight set ticket1="+x.getTicket1()+",ticket2="+x.getTicket2()+" where flight_id="+x.getFlightId()+";");
            s.execute("insert into ORDER values ('"+r.getPassengerId()+"','"+r.getFlightId()+"','"+r.getOrderStatus()+"','"+r.getLeg()+"')");
            s.close();
            conn.commit();
            conn.close();
        }catch (Exception e){

        }
    }

    /*public void reservation(Flight x, Type.PlaceEnum t){//预约抢票，参数为航班x和上下机情况t
        switch (t){
            case FULL:
                Queue<String> q = x.getAppointList();
                q.add(String.valueOf(id));
                String qt[]=new String[q.size()];
                for(int i=0;i<q.size();i++)
                    qt[i]=q.poll();
                x.setAppointList(qt);
                break;
            case FIRST:
                Queue<String> q1 = x.getAppointList1();
                q1.add(String.valueOf(id));
                String qt1[]=new String[q1.size()];
                for(int i=0;i<q1.size();i++)
                    qt1[i]=q1.poll();
                x.setAppointList1(qt1);
                break;
            case SECOND:
                Queue<String> q2 = x.getAppointList2();
                q2.add(String.valueOf(id));
                String qt2[]=new String[q2.size()];
                for(int i=0;i<q2.size();i++)
                    qt2[i]=q2.poll();
                x.setAppointList2(qt2);
                break;
        }
    }

    public void refund(Flight x, Ticket rt){//退票，参数为航班x和要退的票t
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
