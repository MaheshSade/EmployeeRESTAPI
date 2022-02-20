//package com.example.mainproject;
//
//import org.springframework.stereotype.Component;
//
//import java.sql.*;
//
//@Component
//public class DatabaseConnection {
//
//    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//
//        String url = "jdbc:mysql://localhost:3306/mahesh";
//
//        String username = "root";
//
//        String password = "160104180";
//
//        String driver = "com.mysql.cj.jdbc.Driver";
//
//
//
//        Class.forName(driver);
//
//        Connection con = DriverManager.getConnection(url,username,password);
//
//        Statement st = con.createStatement();
//
//
////        int rowsinserted =  st.executeUpdate("insert into students values(3,'ravi',88)");
////
////        int rowsupdated =  st.executeUpdate("update students set name='pavan',marks=75 where id=2");
////
////        int rowsdeleted = st.executeUpdate("delete from students where id=3");
////
////        System.out.println("Rows inserted: "+rowsupdated);
////
////        System.out.println("Rows updated: "+rowsupdated);
////
////        System.out.println("Rows deleted: "+rowsdeleted);
//
//
//
////        ResultSet rs = st.executeQuery("select * from students");
////
////        while (rs.next())
////
////        {
////
////            System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
////
////        }
//
//
//
//    }
//
//}
//
//