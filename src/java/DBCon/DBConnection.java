/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBCon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author Dulanji
 */
public class DBConnection {
   private static Connection c;
    private static void setConnection()throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
         c=DriverManager.getConnection("jdbc:mysql://localhost:3306/masterfinder","root","1234");
    }
    public static void iud(String sql)throws Exception{
    if (c==null){
        setConnection();
        }
    c.createStatement().executeUpdate(sql);
    }
   public static ResultSet search(String sql) throws Exception{
    if(c==null)  {
        setConnection();
    } 
    return c.createStatement().executeQuery(sql);
   }
   public static Connection getDB() throws Exception{
       if(c==null){
           setConnection();
       }
       return c;
   }
 
}
