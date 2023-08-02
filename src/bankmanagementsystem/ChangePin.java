/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankmanagementsystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel; 
import javax.swing.*; 
import java.awt.*;  
import java.sql.ResultSet;



public class ChangePin extends JFrame implements ActionListener{ 
    String accountNumber; 
    JButton backButton,changeButton;  
    JTextField textfield1,textfield2,textfield3;
    public ChangePin(String accountNumber){
        this.accountNumber = accountNumber;  
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg")); 
        Image i2 = i1.getImage().getScaledInstance(700, 750, Image.SCALE_DEFAULT); 
        ImageIcon i3 = new ImageIcon(i2); 
        
        JLabel imageLabel = new JLabel(i3); 
        imageLabel.setBounds(0,0,700,750);
        add(imageLabel); 
        
        JLabel l1 = new JLabel("Enter Old Pin");  
        l1.setBounds(140,250,200,10); 
        l1.setForeground(Color.WHITE);  
        l1.setBorder(BorderFactory.createEmptyBorder()); 
        imageLabel.add(l1); 
        
        
        textfield1 = new JTextField(); 
        textfield1.setBounds(140,265,200,25); 
        textfield1.setBorder(BorderFactory.createEmptyBorder()); 
        imageLabel.add(textfield1); 
        
        
        JLabel l2 = new JLabel("Enter New Pin");  
        l2.setBounds(140,300,200,10); 
        l2.setForeground(Color.WHITE);  
        l2.setBorder(BorderFactory.createEmptyBorder());  
        imageLabel.add(l2);
        
        textfield2 = new JTextField(); 
        textfield2.setBounds(140,315,200,25); 
        textfield2.setBorder(BorderFactory.createEmptyBorder()); 
        imageLabel.add(textfield2); 
        
        JLabel l3 = new JLabel("Re-Enter New Pin");
        l3.setBounds(140,355,200,10); 
        l3.setForeground(Color.WHITE);  
        l3.setBorder(BorderFactory.createEmptyBorder());  
        imageLabel.add(l3); 
        
        textfield3 = new JTextField(); 
        textfield3.setBounds(140,370,200,25); 
        textfield3.setBorder(BorderFactory.createEmptyBorder()); 
        imageLabel.add(textfield3);  
        
        backButton = new JButton("Back"); 
        backButton.setBounds(140,425,100,25); 
        backButton.addActionListener(this); 
        imageLabel.add(backButton); 
        
        changeButton = new JButton("Change PIN"); 
        changeButton.setBounds(260,425,125,25);  
        changeButton.addActionListener(this);
        imageLabel.add(changeButton); 
        
        
        
        setSize(700,750);     
        setLocation(300,0);  
        setUndecorated(true);
        setVisible(true); 
    }
    public static void main(String[] args){
        new ChangePin(""); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==backButton){
            
            setVisible(false); 
            new Transactions(accountNumber); 
            
        }else if(e.getSource()==changeButton){
            String oldPin = textfield1.getText(); 
            String newPin = textfield2.getText(); 
            String re_enteredPin = textfield3.getText(); 
            
            try{
                Conn conn = new Conn(); 
            
                String query1 = "select * from bankAccount where accountNumber = '"+accountNumber+"'"; 
                
                ResultSet accountDeetResultSet = conn.s.executeQuery(query1);  
                String fetchedPinNumber="";
                if(accountDeetResultSet.next()){
                    fetchedPinNumber = accountDeetResultSet.getString("pinNumber"); 
                }else{
                    throw new Exception("Something went wrong");
                }
                 
                
                if(!fetchedPinNumber.equals(oldPin)){
                    throw new Exception("Wrong old pin");
                } 
                
                if(!newPin.equals(re_enteredPin)){
                    throw new Exception("New PinNumbers should match");
                } 
                
                String query2 = "update bankAccount set pinNumber = '"+newPin+"' where accountNumber = '"+accountNumber+"';";
                String query3 = "update accountDetails set pinNumber = '"+newPin+"' where accountNumber = '"+accountNumber+"';";
                conn.s.executeUpdate(query2); 
                conn.s.executeUpdate(query3);
                JOptionPane.showMessageDialog(null,"PIN Changed successfully. . .");
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null,ex.getMessage()); 
            }
            
        }
    }
}
