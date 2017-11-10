package com.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by lenovo on 2017/7/6.
 */
public class CrudTest {
    public static final String DBDRIVER = "org.gjt.mm.mysql.Driver" ;
    public static final String URL="jdbc:mysql://localhost:3306/worker";
    public static final String USER="root";
    public static final String PASSWORD="root";

    static {
        try{
            Class.forName(DBDRIVER) ;
            System.out.println("mysql�����ɹ�����.");
        }catch(ClassNotFoundException e){
            System.out.println("mysql��������ʧ��");
            e.printStackTrace() ;
        }
    }

    public static void main(String[] args) throws  Exception{
              query();
            insert();
//              update();
//              delete();
              System.out.println("�޸ĺ�����ݲ�ѯ����:");
              query();
    }

    public static void query() throws Exception{
        Connection conn;  //���ݿ�����
        Statement stmt;   //���ݿ����
        String sql="select id,name,age from develops ";
        conn= DriverManager.getConnection(URL,USER,PASSWORD); //�������ݿ�
        stmt=conn.createStatement();   //ʵ����Statement����
        ResultSet rs=stmt.executeQuery(sql);      //ִ�����ݿ��ѯ����
        while(rs.next()){        //ָ���ƶ���һ��
            String name=rs.getString(2);
            int id=rs.getInt(1);             //��ȡ����
            int age=rs.getInt(3);
            System.out.println("id:"+id+" name:"+name+" age:"+age);
        }
        rs.close();                     //�رս����
        stmt.close();                //�����ر�
        conn.close();                 //���ݿ�ر�
    }

    public static void insert() throws Exception{
        Connection conn=DriverManager.getConnection(URL,USER,PASSWORD);
        conn.setAutoCommit(false);
        Statement stmt=conn.createStatement();
        String sql="insert into develops values ('zeng',1,28)";
        System.out.println(sql);
        stmt.executeUpdate(sql);     //ִ�и��²���
        conn.commit();               //�ύ����
        stmt.close();
        conn.close();
    }

    public static void update() throws Exception{
        Connection conn=DriverManager.getConnection(URL,USER,PASSWORD);
        conn.setAutoCommit(false);
        Statement stmt=conn.createStatement();
        String sql="update develops set id=100 where id=1";
        System.out.println(sql);
        stmt.executeUpdate(sql);     //ִ�и��²���
        stmt.close();
        conn.close();
    }

    public static void delete() throws Exception{
        Connection conn=DriverManager.getConnection(URL,USER,PASSWORD);
        conn.setAutoCommit(false);
        Statement stmt=conn.createStatement();
        String sql="delete  from develops where id=100 ";
        System.out.println(sql);
        stmt.executeUpdate(sql);     //ִ�и��²���
        stmt.close();
        conn.close();
    }
}
