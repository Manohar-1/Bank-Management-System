/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankmanagementsystem;
import javax.swing.JFrame; 
import javax.swing.JLabel; 
import java.awt.Color; 
import javax.swing.JOptionPane; 
import java.sql.ResultSet;
import java.time.LocalDateTime;

public class Ministatement extends JFrame{
    String accountNumber; 
    
    public Ministatement(String accountNumber){
        this.accountNumber = accountNumber;  
        setTitle("Mini Statement"); 
        setLayout(null); 
         
         
        
        JLabel bank = new JLabel("State Bank Of India");
        bank.setBounds(140,20,150,20); 
        add(bank);
        
        
        
        JLabel card = new JLabel(); 
        card.setBounds(15,70,300,20);  
        add(card);  
        card.setText("Account Number : "+accountNumber.substring(0,4)+"XXXXXXXX"+accountNumber.substring(12));
        
        JLabel mini = new JLabel(); 
        mini.setBounds(20,100,400,200);
        add(mini);
        
        JLabel balance = new JLabel(); 
        balance.setBounds(15,305,200,20); 
        add(balance); 
        
        
        try{
            Conn conn = new Conn(); 
            
            ResultSet rs = conn.s.executeQuery("select * from history where accountNumber = '"+accountNumber+"' order by transactionTime desc limit 5"); 
            while(rs.next()){ 
                System.out.println("HHHHHOW Many times???");
               
                String transaction=""; 
                if(rs.getString("amount").charAt(0)=='+'){
                    transaction = "Deposit";
                }else{
                    transaction = "Withdrawal"; 
                }
                mini.setText(mini.getText()+"<html>"+rs.getObject("transactionTime", LocalDateTime.class)+"&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount").substring(1)+"&nbsp;&nbsp;&nbsp;&nbsp;"+transaction+"<br><br><html>");
            }  
            
            
            ResultSet rs2 = conn.s.executeQuery("select * from bankAccount where accountNumber = '"+accountNumber+"'");  
            if(rs2.next()){
                balance.setText("Your account balance is "+rs2.getString("balance")+"Rs/-"); 
            }else{
                throw new Exception("Something went wrong");
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        setSize(400,400); 
        setLocation(20,20);  
        getContentPane().setBackground(Color.WHITE); 
        setVisible(true);         
    }
    
    public static void main(String[] args){
        new Ministatement("5046343254540921"); 
    }
}
