/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankmanagementsystem;

import com.toedter.calendar.JCalendar;
import javax.swing.*; 
import java.awt.*;
import java.util.Random;  
import java.util.*; 
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SignUpTwo extends JFrame implements ActionListener{ 
    JTextField nameTextField,fnameTextField,emailTextField,addressTextField,cityTextField,stateTextField,pinTextField; 
    JButton next; 
    JDateChooser dateChoser;
    JRadioButton male,female,married,unmarried,other;
    long random;
    SignUpTwo(){ 
        
        Random rand  = new Random(); 
        random = Math.abs(rand.nextLong()%9000L) + 1000L;
        
        setLayout(null);
        
        JLabel formno = new JLabel("APPLICATION FORM NO " + random); 
        formno.setFont(new Font("Raleway",Font.BOLD,38)); 
        formno.setBounds(140,20,600,40);  
        add(formno);
        
        JLabel personalDetails = new JLabel("Page 1:Personal Details"); 
        personalDetails.setFont(new Font("Raleway",Font.ITALIC,22)); 
        personalDetails.setBounds(280,50,400,40);  
        add(personalDetails);
        
        JLabel name = new JLabel("Name:"); 
        name.setFont(new Font("Raleway",Font.BOLD,20)); 
        name.setBounds(140,85,100,40);  
        add(name); 
        
        nameTextField = new JTextField(); 
        nameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        nameTextField.setBounds(300, 85, 300, 40);
        add(nameTextField);
        
        JLabel fname = new JLabel("Father's name:"); 
        fname.setFont(new Font("Raleway",Font.BOLD,20)); 
        fname.setBounds(140,145,150,40);  
        add(fname); 
        
        fnameTextField = new JTextField(); 
        fnameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        fnameTextField.setBounds(300, 145, 300, 40);
        add(fnameTextField);
        
        JLabel dob = new JLabel("Date Of Birth:"); 
        dob.setFont(new Font("Raleway",Font.BOLD,20)); 
        dob.setBounds(140,205,200,40);  
        add(dob); 
        
        dateChoser = new JDateChooser(); 
        dateChoser.setBounds(300,205,300,40);
        dateChoser.setForeground(Color.BLACK);
        add(dateChoser);
        
        
        JLabel gender = new JLabel("Gender:"); 
        gender.setFont(new Font("Raleway",Font.BOLD,20)); 
        gender.setBounds(140,265,100,40);  
        add(gender);
        
        male = new JRadioButton("Male"); 
        male.setBounds(300,265,100,40); 
        male.setBackground(Color.WHITE);
        add(male); 
        
        female = new JRadioButton("Female"); 
        female.setBounds(450,265,100,40); 
        female.setBackground(Color.WHITE);
        add(female); 
        
        ButtonGroup genderGroupButton = new ButtonGroup(); 
        genderGroupButton.add(male); 
        genderGroupButton.add(female); 
        
        
        
        JLabel email = new JLabel("Email:"); 
        email.setFont(new Font("Raleway",Font.BOLD,20)); 
        email.setBounds(140,325,100,40);  
        add(email);
        
        emailTextField = new JTextField(); 
        emailTextField.setFont(new Font("Raleway",Font.BOLD,14));
        emailTextField.setBounds(300, 325, 300, 40);
        add(emailTextField);
        
        JLabel maritalStatus = new JLabel("Marital Status:"); 
        maritalStatus.setFont(new Font("Raleway",Font.BOLD,20)); 
        maritalStatus.setBounds(140,385,150,40);  
        add(maritalStatus);
        
        married = new JRadioButton("Married"); 
        married.setBounds(300,385,100,40); 
        married.setBackground(Color.WHITE);
        add(married); 
        
        unmarried = new JRadioButton("Unmarried"); 
        unmarried.setBounds(420,385,100,40); 
        unmarried.setBackground(Color.WHITE);
        add(unmarried); 
        
        other = new JRadioButton("Others"); 
        other.setBounds(540,385,100,40); 
        other.setBackground(Color.WHITE);
        add(other); 
        
        ButtonGroup marriedGroupButton = new ButtonGroup(); 
        marriedGroupButton.add(married); 
        marriedGroupButton.add(unmarried); 
        marriedGroupButton.add(other); 
        
        JLabel address = new JLabel("Address:"); 
        address.setFont(new Font("Raleway",Font.BOLD,20)); 
        address.setBounds(140,445,150,40);  
        add(address); 
        
        addressTextField = new JTextField(); 
        addressTextField.setFont(new Font("Raleway",Font.BOLD,14));
        addressTextField.setBounds(300, 445, 300, 40);
        add(addressTextField);
        
        JLabel city = new JLabel("City:"); 
        city.setFont(new Font("Raleway",Font.BOLD,20)); 
        city.setBounds(140,505,150,40);  
        add(city); 
        
        cityTextField = new JTextField(); 
        cityTextField.setFont(new Font("Raleway",Font.BOLD,14));
        cityTextField.setBounds(300, 505, 300, 40);
        add(cityTextField);
        
        JLabel state = new JLabel("State:"); 
        state.setFont(new Font("Raleway",Font.BOLD,20)); 
        state.setBounds(140,565,150,40);  
        add(state);
        
        stateTextField = new JTextField(); 
        stateTextField.setFont(new Font("Raleway",Font.BOLD,14));
        stateTextField.setBounds(300, 565, 300, 40);
        add(stateTextField);
        
        JLabel pincode = new JLabel("PinCode:"); 
        pincode.setFont(new Font("Raleway",Font.BOLD,20)); 
        pincode.setBounds(140,625,150,40);  
        add(pincode);
        
        pinTextField = new JTextField(); 
        pinTextField.setFont(new Font("Raleway",Font.BOLD,14));
        pinTextField.setBounds(300, 625, 300, 40);
        add(pinTextField);
        
        
        next = new JButton("Next"); 
        next.setBackground(Color.BLACK); 
        next.setForeground(Color.WHITE); 
        next.setBounds(500,670,100,40);
        next.addActionListener(this);
        add(next);
        
        
        
        
        getContentPane().setBackground(Color.WHITE);
        setSize(790,800); 
        setLocation(350,0); 
        setVisible(true);
    }
    public static void main(String[] args) {
        new SignUpTwo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==next){
            String formno =""+random;
            String name = nameTextField.getText(); 
            String fname =fnameTextField.getText(); 
            String dob = ((JTextField)dateChoser.getDateEditor().getUiComponent()).getText(); 
            System.out.println(dob);
            String gender = null; 
            
            if(male.isSelected()){
                gender = "Male"; 
            }else if(female.isSelected()){
                gender = "Female"; 
            }
            
            String email = emailTextField.getText(); 
            
            String maritalStatus = null; 
            
            if(married.isSelected()){
                maritalStatus = "Married";
            }else if(unmarried.isSelected()){
                maritalStatus = "Unmarried";
            }else if(other.isSelected()){
                maritalStatus = "Other";
            }
            
            String address = addressTextField.getText(); 
            String state = stateTextField.getText(); 
            String city = cityTextField.getText(); 
            String pincode = pinTextField.getText();
            
            try{
                if(name.equals("")){
                    JOptionPane.showMessageDialog(null, "Name is required"); 
                    throw new Exception("Name is required");
                }
                
                if(fname.equals("")){
                    JOptionPane.showMessageDialog(null,"Father name cannot be null"); 
                    throw new Exception("Father name cannot be null"); 
                }
                
                if(gender == null){
                    JOptionPane.showMessageDialog(null,"Please select your gender"); 
                    throw new Exception("Gender is not selected"); 
                }
                
                if(dob.equals("")){
                    JOptionPane.showMessageDialog(null, "Please select the date from the calendar");
                    throw new Exception("Date of Birth required"); 
                }
                
                if(email.equals("")){
                    JOptionPane.showMessageDialog(null,"Enter your email"); 
                    throw new Exception("Enter your email");
                }
                
                if(maritalStatus ==null){
                    JOptionPane.showMessageDialog(null,"Please select your marital staus"); 
                    throw new Exception("Please select your marital staus");
                }
                
                if(address.equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter your address..."); 
                    throw new Exception("Address field cannot be null");
                }
                
                if(city.equals("")){
                    JOptionPane.showMessageDialog(null,"City field cannot be null"); 
                    throw new Exception("City field cannot be null");
                }
                
                if(state.equals("")){
                    JOptionPane.showMessageDialog(null,"State field cannot be null"); 
                    throw new Exception("State field cannot be null");
                }
                
                if(pincode.equals("")){
                    JOptionPane.showMessageDialog(null,"Pincode field cannot be null"); 
                    throw new Exception("Pincode field cannot be null");
                }
                
                Conn c = new Conn();
                String query = "insert into signup values('" +formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+maritalStatus+"','"+address+"','"+state+"','"+city+"','"+pincode+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Date persisted successfully...");
            }catch(Exception ex){
                System.out.println(ex.getMessage()); 
            }
            
            
        }
    }
}