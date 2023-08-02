/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankmanagementsystem;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField; 
import java.sql.ResultSet;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;


public class Deposit extends JFrame implements ActionListener{ 
    JTextField cashDepositAmount;
    JButton depositButton,backButton;
    String accountNumber;
    public Deposit(String accountNumber){ 
        this.accountNumber = accountNumber;
        setLayout(null); 
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg")); 
        Image i2 = i1.getImage().getScaledInstance(700, 750, Image.SCALE_DEFAULT); 
        ImageIcon i3 = new ImageIcon(i2); 
        
        JLabel l1 = new JLabel(i3); 
        l1.setBounds(0,0,700,750);
        add(l1);   
        
        JLabel depositLabel = new JLabel("Enter the deposit amount"); 
        depositLabel.setBounds(180,240,200,10);  
        depositLabel.setForeground(Color.WHITE); 
        l1.add(depositLabel); 
        
        cashDepositAmount = new JTextField();  
        cashDepositAmount.setBounds(180,270,200,25); 
        cashDepositAmount.setBorder(BorderFactory.createEmptyBorder());
        l1.add(cashDepositAmount);
        
        depositButton = new JButton("Deposit"); 
        depositButton.setBounds(300,390,100,30);  
        depositButton.addActionListener(this);
        l1.add(depositButton); 
        
        backButton = new JButton("Back"); 
        backButton.setBounds(300,425,100,30);  
        backButton.addActionListener(this);
        l1.add(backButton); 
        
        setSize(700,750);     
        setLocation(300,0);  
        setUndecorated(true);
        setVisible(true); 
    }
    public static void main(String[] args){
        new Deposit("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==depositButton){ 
            String depositAmount = cashDepositAmount.getText();  
            
            Conn connection = new Conn(); 
            
            String query1 = "select balance from bankAccount where accountNumber = '"+accountNumber+"'"; 
            
            try{ 
                if(depositAmount.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter deposit amount");
                    throw new Exception("Please enter deposit amount...");
                }
                ResultSet balanceResultSet = connection.s.executeQuery(query1);  
                if(balanceResultSet.next()){
                    System.out.println("Moving one step forward");
                }
                String balance = balanceResultSet.getString("balance");
                System.out.println(balance);   
                
                Long balanceAmount = Long.parseLong(balance); 
                Long amountToBeAdded = Long.parseLong(depositAmount); 
                
                Long totalAmount = balanceAmount+amountToBeAdded; 
                
                String query2 = "update bankAccount set balance = "+totalAmount+" where accountNumber = '"+accountNumber+"'"; 
                LocalDateTime datetime = LocalDateTime.now();
                String query3 = "insert into history values('"+accountNumber+"','"+("+"+amountToBeAdded)+"','"+datetime+"')";
                int checkingExecuteUpdate = connection.s.executeUpdate(query2);   
                int checkingExecuteUpdate2 = connection.s.executeUpdate(query3); 
                System.out.println(checkingExecuteUpdate+" "+checkingExecuteUpdate2); 
                
                JOptionPane.showMessageDialog(null,amountToBeAdded +" Rs/- deposited successfully in your account");
                System.out.println("amount deposited successfully");
                
            }catch(Exception ex){
                System.out.println("ERROR: "+ex.getMessage()); 
            }
            
        }else if(e.getSource()==backButton){
            setVisible(false); 
            new Transactions(accountNumber);
        }
    }
}
