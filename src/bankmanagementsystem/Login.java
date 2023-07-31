/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankmanagementsystem;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Login extends JFrame implements ActionListener{ 
    JButton login,clear,SignUp; 
    JTextField cardNoText; 
    JPasswordField pinText;
    Login(){
        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo3.jpg")); 
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_REPLICATE); 
        
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label1 = new JLabel(i3);  
        add(label1);
        label1.setBounds(70,10,100,100); 
        
        JLabel heading = new JLabel("Welcome To ATM");  
        heading.setFont(new Font("Osward",Font.BOLD,38));
        heading.setBounds(200,40,400,40); 
        add(heading);
        
        JLabel cardno = new JLabel("Card No");  
        cardno.setFont(new Font("Osward",Font.BOLD,25));
        cardno.setBounds(70,150,100,20); 
        add(cardno);
        
        cardNoText = new JTextField(); 
        cardNoText.setBounds(260, 150, 200, 25); 
        cardNoText.setFont(new Font("Oswan",Font.PLAIN,14));
        add(cardNoText);
        
        JLabel pin = new JLabel("Pin");  
        pin.setFont(new Font("Osward",Font.BOLD,25));
        pin.setBounds(70,210,100,20); 
        add(pin); 
        
        pinText = new JPasswordField(); 
        pinText.setBounds(260, 210, 200, 25); 
        add(pinText); 
        
        login = new JButton("Login"); 
        login.setBounds(260, 250, 100, 25); 
        login.setBackground(Color.BLACK); 
        login.setForeground(Color.WHITE); 
        login.addActionListener(this);
        add(login); 
        
        clear = new JButton("Clear"); 
        clear.setBounds(360, 250, 100, 25); 
        clear.setBackground(Color.BLACK); 
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);  
        
        
        SignUp = new JButton("Sign Up"); 
        SignUp.setBounds(260, 300, 200, 25); 
        SignUp.setBackground(Color.BLACK); 
        SignUp.setForeground(Color.WHITE);
        SignUp.addActionListener(this);
        add(SignUp);  
        
         
        getContentPane().setBackground(Color.WHITE);
        setSize(600,400); 
        setVisible(true);
        setLocation(350,200); 
    }
    
    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== clear){
            cardNoText.setText(""); 
            pinText.setText("");
        }else if(e.getSource()==login){
            
        }else if(e.getSource()==SignUp){
            setVisible(false); 
            new Signup();
        }
    }
}
