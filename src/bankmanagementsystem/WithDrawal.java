package bankmanagementsystem;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.JFrame; 
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
public class WithDrawal extends JFrame implements ActionListener{ 
    JTextField cashWithDrawalAmountTextField;
    JButton withDrawButton,backButton;
    String accountNumber;
    public WithDrawal(String accountNumber){
        this.accountNumber = accountNumber; 
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg")); 
        Image i2 = i1.getImage().getScaledInstance(700, 750, Image.SCALE_DEFAULT); 
        ImageIcon i3 = new ImageIcon(i2); 
        
        JLabel l1 = new JLabel(i3); 
        l1.setBounds(0,0,700,750);
        add(l1); 
        
        JLabel depositLabel = new JLabel("Enter the withdrawal amount"); 
        depositLabel.setBounds(180,240,200,10);  
        depositLabel.setForeground(Color.WHITE); 
        l1.add(depositLabel); 
        
        cashWithDrawalAmountTextField = new JTextField();  
        cashWithDrawalAmountTextField.setBounds(180,270,200,25); 
        cashWithDrawalAmountTextField.setBorder(BorderFactory.createEmptyBorder());
        l1.add(cashWithDrawalAmountTextField);
        
        withDrawButton = new JButton("Withdraw"); 
        withDrawButton.setBounds(300,390,100,30);  
        withDrawButton.addActionListener(this);
        l1.add(withDrawButton); 
        
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
        new WithDrawal("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==withDrawButton){
            String withdrawalAmount = cashWithDrawalAmountTextField.getText();  
            
            Conn connection = new Conn(); 
            
            String query1 = "select balance from bankAccount where accountNumber = '"+accountNumber+"'"; 
            
            try{ 
                if(withdrawalAmount.equals("")){
                    throw new Exception("Please enter withdrawal amount...");
                }
                
                ResultSet balanceResultSet = connection.s.executeQuery(query1);  
                String balance = ""; 
                
                if(balanceResultSet.next()){
                    balance = balanceResultSet.getString("balance");
                }else{
                    throw new Exception("Please check your account details");
                }
                
                  
                
                Long balanceAmount = Long.parseLong(balance); 
                Long  amountToBeWithDrawn= Long.parseLong(withdrawalAmount); 
                Long totalAmount = balanceAmount-amountToBeWithDrawn; 
                
                if(totalAmount<0){
                    throw new Exception("Insufficient funds"); 
                }else if(totalAmount<500){
                    throw new Exception("Minimum balance 500Rs/- should be in bank account"); 
                }
                
                String query2 = "update bankAccount set balance = "+totalAmount+" where accountNumber = '"+accountNumber+"'"; 
                LocalDateTime datetime = LocalDateTime.now();
                String query3 = "insert into history values('"+accountNumber+"','"+("-"+amountToBeWithDrawn)+"','"+datetime+"')";
                int checkingExecuteUpdate = connection.s.executeUpdate(query2);   
                int checkingExecuteUpdate2 = connection.s.executeUpdate(query3); 
                System.out.println(checkingExecuteUpdate+" "+checkingExecuteUpdate2); 
                
                JOptionPane.showMessageDialog(null,amountToBeWithDrawn +" Rs/- withdrawn successfully from your account");
                System.out.println("amount withdrawn successfully");
                connection.s.close();  
                connection.close();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null,ex.getMessage()); 
            }
            
        }else if(e.getSource()==backButton){
            setVisible(false); 
            new Transactions(accountNumber);
        }
    }
}
