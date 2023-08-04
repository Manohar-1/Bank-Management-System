
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
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
public class Transactions extends JFrame implements ActionListener{ 
    
    JButton depositButton,fastCashButton,pinChangeButton,cashWithDrawalButton,miniStatementButton,balanceEnquiryButton,exitButton;
    String accountNumber; 
    public Transactions(String accountNumber){
        this.accountNumber = accountNumber;
        setLayout(null); 
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg")); 
        Image i2 = i1.getImage().getScaledInstance(700, 750, Image.SCALE_DEFAULT); 
        ImageIcon i3 = new ImageIcon(i2); 
        
        JLabel l1 = new JLabel(i3); 
        l1.setBounds(0,0,700,750);
        add(l1); 
        
        
        JLabel heading = new JLabel("Please select your transaction"); 
        heading.setForeground(Color.WHITE); 
        heading.setBounds(180,250,300,20); 
        l1.add(heading);
        
        depositButton = new JButton("Deposit"); 
        depositButton.setBounds(125,345,120,25);  
        depositButton.addActionListener(this); 
        depositButton.setBorder(BorderFactory.createEmptyBorder());
        l1.add(depositButton);
        
        fastCashButton = new JButton("Fast Cash"); 
        fastCashButton.setBounds(125,375,120,25); 
        fastCashButton.addActionListener(this);
        fastCashButton.setBorder(BorderFactory.createEmptyBorder());
        l1.add(fastCashButton);
        
        pinChangeButton = new JButton("Pin Change"); 
        pinChangeButton.setBounds(125,405,120,25);
        pinChangeButton.addActionListener(this);
        pinChangeButton.setBorder(BorderFactory.createEmptyBorder());
        l1.add(pinChangeButton);
        
        cashWithDrawalButton = new JButton("Cash Withdraw"); 
        cashWithDrawalButton.setBounds(260,345,140,25); 
        cashWithDrawalButton.addActionListener(this); 
        cashWithDrawalButton.setBorder(BorderFactory.createEmptyBorder());
        l1.add(cashWithDrawalButton);
        
        balanceEnquiryButton = new JButton("Balance Enquiry"); 
        balanceEnquiryButton.setBounds(260,375,140,25);  
        balanceEnquiryButton.addActionListener(this);
        balanceEnquiryButton.setBorder(BorderFactory.createEmptyBorder());
        l1.add(balanceEnquiryButton); 
        
        miniStatementButton = new JButton("Mini Statement"); 
        miniStatementButton.setBounds(260,405,140,25);  
        miniStatementButton.addActionListener(this);
        miniStatementButton.setBorder(BorderFactory.createEmptyBorder());
        l1.add(miniStatementButton); 
        
        exitButton = new JButton("Exit"); 
        exitButton.setBounds(260,435,140,25); 
        exitButton.addActionListener(this);
        exitButton.setBorder(BorderFactory.createEmptyBorder());
        l1.add(exitButton);
        
        
        setSize(700,750);     
        setLocation(300,0);  
        setUndecorated(true);
        setVisible(true); 
        
        
    }
    public static void main(String[] args){
        new Transactions("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
//        pinChangeButton,cashWithDrawalButton,miniStatementButton,balanceEnquiryButton,exitButton; 
         if(ae.getSource()==exitButton){
            System.exit(0);    
         }
         
         if(ae.getSource()==depositButton){
             setVisible(false); 
             new Deposit(accountNumber); 
         }else if(ae.getSource()==fastCashButton){
             setVisible(false); 
             new FastCash(accountNumber);
         }else if(ae.getSource()==pinChangeButton){
             setVisible(false); 
             new ChangePin(accountNumber); 
         }else if(ae.getSource()==cashWithDrawalButton){
             setVisible(false);  
             new WithDrawal(accountNumber);
         }else if(ae.getSource()==miniStatementButton){
             new Ministatement(accountNumber);
         }else if(ae.getSource()==balanceEnquiryButton){
             setVisible(false); 
             new BalanceEnquiry(accountNumber);
         }
    }
}
