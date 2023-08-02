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
import java.time.LocalDateTime;
import javax.swing.JOptionPane;


public class FastCash extends JFrame implements ActionListener{
    
    String accountNumber; 
    JButton button1,button2,button3,button4,button5,button6,backButton;
    public FastCash(String accountNumber){
        this.accountNumber = accountNumber; 
        
        this.accountNumber = accountNumber;
        setLayout(null); 
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg")); 
        Image i2 = i1.getImage().getScaledInstance(700, 750, Image.SCALE_DEFAULT); 
        ImageIcon i3 = new ImageIcon(i2); 
        
        JLabel l1 = new JLabel(i3); 
        l1.setBounds(0,0,700,750);
        add(l1); 
        
        
        JLabel heading = new JLabel("Select amount to be withdrawn"); 
        heading.setForeground(Color.WHITE); 
        heading.setBounds(180,250,300,20); 
        l1.add(heading);
        
        button1 = new JButton("Rs 100"); 
        button1.setBounds(125,345,120,25);  
        button1.addActionListener(this);
        l1.add(button1);
        
        button2 = new JButton("Rs 200"); 
        button2.setBounds(125,375,120,25); 
        button2.addActionListener(this);
        l1.add(button2);
        
        button3 = new JButton("Rs 500"); 
        button3.setBounds(125,405,120,25);
        button3.addActionListener(this);
        l1.add(button3);
        
        button4 = new JButton("Rs 1000"); 
        button4.setBounds(260,345,140,25); 
        button4.addActionListener(this);
        l1.add(button4);
        
        button5 = new JButton("Rs 2000"); 
        button5.setBounds(260,375,140,25);  
        button5.addActionListener(this);
        l1.add(button5); 
        
        button6 = new JButton("Rs 5000"); 
        button6.setBounds(260,405,140,25);  
        button6.addActionListener(this);
        l1.add(button6); 
        
        backButton = new JButton("Back"); 
        backButton.setBounds(260,435,140,25); 
        backButton.addActionListener(this);
        l1.add(backButton);
        
        
        setSize(700,750);     
        setLocation(300,0);  
        setUndecorated(true);
        setVisible(true); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==backButton){
            setVisible(false); 
            new Transactions(accountNumber); 
        }else{
            String amount = ((JButton)e.getSource()).getText().substring(3); 
            
            String query1 = "select balance from bankAccount where accountNumber = '"+accountNumber+"'"; 
            
            
            try{
                Conn conn = new Conn();  
                ResultSet balanceResultSet = conn.s.executeQuery(query1);  
                
                String balance = ""; 
                
                if(balanceResultSet.next()){
                    balance = balanceResultSet.getString("balance"); 
                }else{
                    throw new Exception("Some error occured, please try later...");
                }
                Long longAmount = Long.parseLong(amount); 
                Long longBalance = Long.parseLong(balance); 
                
                Long totalAmount = longBalance - longAmount; 
                
                if(totalAmount<0){
                    throw new Exception("Insufficient Funds"); 
                }else if(totalAmount<500){
                    throw new Exception("Minimum balance 500Rs/- must be maintained...");
                }
                
                
                String query2 = "update bankAccount set balance = "+totalAmount+" where accountNumber = '"+accountNumber+"'"; 
                LocalDateTime datetime = LocalDateTime.now();
                String query3 = "insert into history values('"+accountNumber+"','"+("-"+longAmount)+"','"+datetime+"')";
                conn.s.executeUpdate(query2);   
                conn.s.executeUpdate(query3); 
                
                
                JOptionPane.showMessageDialog(null,longAmount +" Rs/- withdrawn successfully from your account");
                System.out.println("amount withdrawn successfully"); 
                
                conn.s.close(); 
                conn.close();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }
    
    public static void main(String[] args) {
        new FastCash(""); 
    }
    
}
