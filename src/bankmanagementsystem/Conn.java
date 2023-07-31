/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankmanagementsystem;

import java.sql.*; 
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conn {
    Connection c; 
    Statement s;
    public Conn(){
        try{
       
            
            String url = "jdbc:mysql:///bankmanagementsystem"; 
            
            c = DriverManager.getConnection(url,"root","root"); 
            s = c.createStatement();
            
        }catch(Exception e){
            System.out.println(e.getMessage()); 
        }
    } 
    
//    public static void close(){ 
//        try {
//            c.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(Conn.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
