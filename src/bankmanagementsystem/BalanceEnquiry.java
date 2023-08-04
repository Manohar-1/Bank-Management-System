/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankmanagementsystem;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;  
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author mudha
 */
public class BalanceEnquiry extends JFrame implements ActionListener{ 
    String accountNumber; 
    JButton backButton; 
    
    public BalanceEnquiry(String accountNumber){
        this.accountNumber = accountNumber; 
         
        setLayout(null); 
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg")); 
        Image i2 = i1.getImage().getScaledInstance(700, 750, Image.SCALE_DEFAULT); 
        ImageIcon i3 = new ImageIcon(i2); 
        
        JLabel l1 = new JLabel(i3); 
        l1.setBounds(0,0,700,750);
        add(l1); 
        
        Conn conn = new Conn(); 
        String query = "select balance from bankAccount where accountNumber = '"+accountNumber+"'";
        try{ 
            System.out.println(query);
            ResultSet rs = conn.s.executeQuery(query);  
            String balance = ""; 
            if(rs.next()){
                balance = rs.getString("balance");   
            }else{
                throw new Exception("Something went wrong");
            }
                          
            JLabel l2 = new JLabel("Your account balance is "+balance+"Rs/-");  
            l2.setBounds(130,250,200,20);  
            l2.setForeground(Color.WHITE);
            l1.add(l2); 
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex.getMessage()); 
        }
        
        backButton = new JButton("Back"); 
        backButton.setBounds(260,435,140,25); 
        backButton.addActionListener(this);
        l1.add(backButton);
        
        setSize(700,750);     
        setLocation(300,0);  
        setUndecorated(true);
        setVisible(true); 
    } 
    
    public static void main(String[] args){
        new BalanceEnquiry(""); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==backButton){
            setVisible(false); 
            new Transactions(accountNumber);
        }
    }
}
