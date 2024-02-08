/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaproduct;


/**
 *
 * @author Windows
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class Javaproduct {

    public static Connection connDB(){
        String dbName = "dbjava",
                user = "fame",
                pass = "12345",
                host = "Localhost",
                driverName = "com.mysql.jdbc.Driver";
        try{
            Class.forName(driverName);
            String url = "jdbc:mysql://"+host+"/"+dbName;
            Connection conn = DriverManager.getConnection(url,user,pass);
            System.out.println("Connect Succes");
            return conn;
        }catch (Exception ex){
            System.out.print(ex.getMessage());
        }
            return null;
}
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Javaproduct().connDB();
    }
    
    public static void insertProduct(String sql) throws Exception{
        connDB().createStatement().executeUpdate(sql);
    }
    
}
