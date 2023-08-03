/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankmanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*; 


public class SignUpThree extends JFrame implements ActionListener{
    
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton next,cancel; 
    String formNo;
    String initialBalance = "500"; 
    public SignUpThree(String formNo){  
        this.formNo = formNo; 
        setLayout(null);
        
        JLabel l1 = new JLabel("Page 3: Account Details"); 
        l1.setFont(new Font("Raleway",Font.ITALIC,18)); 
        l1.setBounds(300,30,400,20);  
        add(l1);  
        
        JLabel type = new JLabel("Account Type"); 
        type.setFont(new Font("Raleway",Font.BOLD,18)); 
        type.setBounds(100,100,200,20); 
        add(type);   
        
        
        r1 = new JRadioButton("Saving Account"); 
        r1.setBounds(100, 130, 200, 20); 
        r1.setFont(new Font("Raleway",Font.BOLD,16)); 
        r1.setBackground(Color.WHITE);
        add(r1); 
        
        r2 = new JRadioButton("Fixed Deposit Account") ;
        r2.setBounds(350,130,200,20); 
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBackground(Color.WHITE);
        add(r2); 
        
        r3 = new JRadioButton("Current Account"); 
        r3.setBounds(100,160,200,20); 
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBackground(Color.WHITE);
        add(r3); 
        
        r4 = new JRadioButton("Recurring Bank Account"); 
        r4.setBounds(350,160,250,20); 
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBackground(Color.WHITE);
        add(r4);    
        
        ButtonGroup groupButton1 = new ButtonGroup(); 
        groupButton1.add(r1);
        groupButton1.add(r2);
        groupButton1.add(r3);
        groupButton1.add(r4); 
        
        JLabel cardNumberLabel = new JLabel("Card Number"); 
        cardNumberLabel.setFont(new Font("Raleway",Font.BOLD,18)); 
        cardNumberLabel.setBounds(100,225,200,20); 
        cardNumberLabel.setBackground(Color.WHITE);
        add(cardNumberLabel);  
        
        JLabel dummyCardNumber = new JLabel("XXXX-XXXX-XXXX-5662"); 
        dummyCardNumber.setFont(new Font("Raleway",Font.BOLD,18));  
        dummyCardNumber.setBounds(290,225,400,20); 
        dummyCardNumber.setBackground(Color.WHITE);  
        add(dummyCardNumber);
        
        JLabel cardDetail = new JLabel("Your 16-Digit Card Number"); 
        cardDetail.setFont(new Font("Raleway",Font.BOLD,10));  
        cardDetail.setBounds(100,250,400,15); 
        cardDetail.setBackground(Color.WHITE);  
        add(cardDetail); 
        
        JLabel pinLabel = new JLabel("PIN"); 
        pinLabel.setFont(new Font("Raleway",Font.BOLD,18)); 
        pinLabel.setBounds(100,280,100,20); 
        pinLabel.setBackground(Color.WHITE);
        add(pinLabel);  
        
        JLabel dummyPin = new JLabel("XXXX"); 
        dummyPin.setFont(new Font("Raleway",Font.BOLD,18));  
        dummyPin.setBounds(290,280,100,20); 
        dummyPin.setBackground(Color.WHITE);  
        add(dummyPin); 
        
        
        
        JLabel pinDetail = new JLabel("Your 4-digit PIN Number"); 
        pinDetail.setFont(new Font("Raleway",Font.BOLD,10));  
        pinDetail.setBounds(100,305,300,15); 
        pinDetail.setBackground(Color.WHITE);  
        add(pinDetail);
        
        JLabel serviceLabel = new JLabel("Services Required:"); 
        serviceLabel.setFont(new Font("Raleway",Font.BOLD,18));  
        serviceLabel.setBounds(100,350,300,15); 
        serviceLabel.setBackground(Color.WHITE);  
        add(serviceLabel); 
        
        c1 = new JCheckBox("ATM Card") ;
        c1.setFont(new Font("Raleway",Font.BOLD,14));
        c1.setBounds(100,375,150,20);  
        c1.setBackground(Color.WHITE);
        add(c1); 
        
        c2 = new JCheckBox("Internet Banking");
        c2.setFont(new Font("Raleway",Font.BOLD,14));
        c2.setBounds(260,375,200,20); 
        c2.setBackground(Color.WHITE);
        add(c2); 
        
        c3 = new JCheckBox("Mobile Banking") ;
        c3.setFont(new Font("Raleway",Font.BOLD,14));
        c3.setBounds(100,400,150,20); 
        c3.setBackground(Color.WHITE);
        add(c3); 
        
        c4 = new JCheckBox("Email & SMS Alerts");
        c4.setFont(new Font("Raleway",Font.BOLD,14));
        c4.setBounds(260,400,200,20); 
        c4.setBackground(Color.WHITE);
        add(c4); 
        
        c5 = new JCheckBox("Cheque Book") ;
        c5.setFont(new Font("Raleway",Font.BOLD,14));
        c5.setBounds(100,430,150,20); 
        c5.setBackground(Color.WHITE);
        add(c5); 
        
        c6 = new JCheckBox("E-Statement");
        c6.setFont(new Font("Raleway",Font.BOLD,14));
        c6.setBounds(260,430,200,20); 
        c6.setBackground(Color.WHITE);
        add(c6);  
        
        c7 = new JCheckBox("I here by declare that all mentioned declared above are genuine"); 
        c7.setFont(new Font("Raleway",Font.BOLD,14));
        c7.setBounds(100,460,800,20); 
        c7.setBackground(Color.WHITE);
        c7.addActionListener(this);
        add(c7); 
        
        next = new JButton("Next"); 
        next.setBackground(Color.BLUE); 
        next.setForeground(Color.WHITE);
        next.addActionListener(this); 
        next.setBounds(300,500,100,30); 
        next.setEnabled(false);
        add(next);
        
        cancel = new JButton("Cancel"); 
        cancel.setBackground(Color.BLUE); 
        cancel.setForeground(Color.WHITE); 
        cancel.addActionListener(this); 
        cancel.setBounds(100,500,100,30);  
        add(cancel); 
        
        
        
        
        
        
        setSize(800,600); 
        setLocation(200,20); 
        setVisible(true); 
        getContentPane().setBackground(Color.WHITE);
        
    }
    
    public static void main(String[] args){
        new SignUpThree("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(c7.isSelected()){
            next.setEnabled(true);
        }else{
            next.setEnabled(false);
        }  
        
        if(e.getSource()==cancel){
            
        }else if(e.getSource()==next){
           
                String accountType = ""; 
            
                if(r1.isSelected()){
                    accountType += "Savings";
                }else if(r2.isSelected()){
                    accountType += "FixedDeposit";
                }else if(r3.isSelected()){
                    accountType += "CurrentAccount";
                }else if(r4.isSelected()){
                    accountType += "RecurringAccount";
                }
                
                String cardNumber = ""; 
                Random random = new Random(); 
                long cardLongVariable = Math.abs(random.nextLong() % 90000000L)+5046343200000000L; 
                cardNumber += cardLongVariable; 
                
                
                String pinNumber = ""; 
                long pinLongVariable = Math.abs(random.nextLong() % 10000L); 
                pinNumber += pinLongVariable; 
                
                StringBuilder facility = new StringBuilder(""); 
                
                if(c1.isSelected()){
                     facility.append("ATM Card,");
                }
                if(c2.isSelected()){
                    facility.append("Internet Banking,");
                }
                if(c3.isSelected()){
                    facility.append("Mobile Banking,");
                }
                if(c4.isSelected()){
                    facility.append("Email & SMS Alerts,");
                }
                
                if(c5.isSelected()){
                    facility.append("Cheque Book,");
                }
                
                if(c6.isSelected()){
                    facility.append("E-Statement");
                }
                
                if(facility.charAt(facility.length()-1)==','){
                    facility.deleteCharAt(facility.length()-1); 
                }
                
                try{ 
                    if(accountType.equals("")){
                       throw new Exception("Account Type Cannot be null"); 
                    }else if(cardNumber.equals("")){
                       throw new Exception("Card Number Cannot Be Null");  
                    }else if(pinNumber.equals("")){
                       throw new Exception("pinNumber Cannot Be Null");   
                    }else if(facility.equals("")){
                       throw new Exception("facility Cannot Be Null");   
                    }
                    
                    String query1 = "insert into accountdetails values('"+formNo+ "','"+accountType+"','"+cardNumber+"','"+pinNumber+"','"+facility.toString()+"')";
                    String query2 = "insert into bankAccount values('"+cardNumber+"','"+pinNumber+"','"+initialBalance+"')"; 
                    
                    Conn connection = new Conn();  
                    connection.s.executeUpdate(query1); 
                    connection.s.executeUpdate(query2);     
                    connection.s.close(); 
                    connection.close(); 
                    JOptionPane.showMessageDialog(null,"card Number:"+cardNumber+"\npin Number:"+pinNumber);
                    System.out.println("Data persisted successfully..."); 
                    
                    setVisible(false); 
                    new Login();
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                
                
                
        }
    }
}
