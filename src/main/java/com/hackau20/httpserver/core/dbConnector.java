package com.hackau20.httpserver.core;

import com.hackau20.httpserver.dbClass.users;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class dbConnector {


   private static final String CONPARAM = "jdbc:mysql://localhost:3306/db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
  private static final   String USER = "root";
   private static final String PASS = "AllDbes1";


    public static ArrayList<users> getTest()
    {
        ArrayList<users> usersAr = new ArrayList<users>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(CONPARAM,USER,PASS);
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from users");
            users us=null;
            while(rs.next()) {
                us = new users(rs.getInt("idUsers"), rs.getString("firstName"), rs.getString("lastName"), rs.getInt("score"), rs.getString("mail"));
                usersAr.add(us);
                System.out.println(rs.getInt("idUsers") + "  " + rs.getString("firstName") + "  " + rs.getString("lastName") + " " + rs.getInt("score") + rs.getString("mail"));
            }
            con.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return usersAr;
    }

}
