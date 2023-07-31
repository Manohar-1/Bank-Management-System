/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankmanagementsystem;

import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;
import java.util.*; 



public class SignUpTwo extends JFrame implements ActionListener{ 
    JTextField aadharTextField,panTextField; 
    JButton next; 
    JComboBox religionComboBox,categoryComboBox,incomeComboBox,educationComboBox,occupationComboBox;
    JRadioButton yes1,yes2,no1,no2;
    String formNumber = null;
    
    SignUpTwo(String formno){ 
        
        formNumber = formno;
        setLayout(null);
        
       
        
        JLabel additionalDetails = new JLabel("Page 2 : Additional Details"); 
        additionalDetails.setFont(new Font("Raleway",Font.ITALIC,22)); 
        additionalDetails.setBounds(280,10,400,40);  
        add(additionalDetails);
        
        JLabel religionLable = new JLabel("Religion:"); 
        religionLable.setFont(new Font("Raleway",Font.BOLD,20)); 
        religionLable.setBounds(140,85,100,25);  
        add(religionLable); 
        
        String[] religionOptions = {"--","Muslim","Hindu","Christian","Other"};
        religionComboBox =  new JComboBox(religionOptions);
        religionComboBox.setFont(new Font("Raleway",Font.PLAIN,14));
        religionComboBox.setBounds(300, 85, 300, 25);
        religionComboBox.setBackground(Color.WHITE);
        add(religionComboBox);
        
        
        JLabel categoryLabel = new JLabel("Category:"); 
        categoryLabel.setFont(new Font("Raleway",Font.BOLD,20)); 
        categoryLabel.setBounds(140,125,150,25);  
        add(categoryLabel); 
        
        String[] categoryOptions = {"--","General","SC","ST","OBC","Other"};
        categoryComboBox = new JComboBox(categoryOptions);
        categoryComboBox.setFont(new Font("Raleway",Font.PLAIN,14));
        categoryComboBox.setBounds(300, 125, 300, 25); 
        categoryComboBox.setBackground(Color.WHITE);
        add(categoryComboBox);
        
        JLabel incomeLabel = new JLabel("Income:"); 
        incomeLabel.setFont(new Font("Raleway",Font.BOLD,20)); 
        incomeLabel.setBounds(140,170,150,25);  
        add(incomeLabel); 
        
        String[] incomeOptions ={"--","< 1,50,000","< 5,00,000","< 8,00,000","Upto 10,00,000"};
        incomeComboBox = new JComboBox(incomeOptions);
        incomeComboBox.setFont(new Font("Raleway",Font.PLAIN,14));
        incomeComboBox.setBounds(300,170,300,25);
        incomeComboBox.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.GRAY));
        incomeComboBox.setBackground(Color.WHITE); 
        add(incomeComboBox);
        
        
        JLabel educationLabel = new JLabel("Educational"); 
        educationLabel.setFont(new Font("Raleway",Font.BOLD,20)); 
        educationLabel.setBounds(140,215,150,25);  
        add(educationLabel);
        
        JLabel qualificationLabel = new JLabel("Qualification:"); 
        qualificationLabel.setFont(new Font("Raleway",Font.BOLD,20)); 
        qualificationLabel.setBounds(140,240,150,25);  
        add(qualificationLabel);
        
        
        String[] educationOptions = {"--","UnderGraduate","Graduate","Post-Graduate","Doctrate","Others"};
        educationComboBox = new JComboBox(educationOptions);
        educationComboBox.setBounds(300,240,300,25); 
        educationComboBox.setBackground(Color.WHITE);
        add(educationComboBox); 
        
        
        JLabel occupationLabel = new JLabel("Occupation:"); 
        occupationLabel.setFont(new Font("Raleway",Font.BOLD,20)); 
        occupationLabel.setBounds(140,305,150,25);  
        add(occupationLabel);
        
        String[] occupationOptions ={"--","Student","Employed","Unemployed","Farmer","Others"};
        occupationComboBox = new JComboBox(occupationOptions);
        occupationComboBox.setBounds(300,305,300,25); 
        occupationComboBox.setBackground(Color.WHITE);
        add(occupationComboBox); 
        
        
        
        JLabel aadharLabel = new JLabel("Aadhar No:"); 
        aadharLabel.setFont(new Font("Raleway",Font.BOLD,20)); 
        aadharLabel.setBounds(140,350,150,25);  
        add(aadharLabel); 
        
        aadharTextField = new JTextField(); 
        aadharTextField.setFont(new Font("Raleway",Font.BOLD,14));
        aadharTextField.setBounds(300, 350, 300, 25); 
        aadharTextField.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.GRAY));
        add(aadharTextField);
        
        JLabel seniorCitizenLabel = new JLabel("Senior Citizen:"); 
        seniorCitizenLabel.setFont(new Font("Raleway",Font.BOLD,20)); 
        seniorCitizenLabel.setBounds(140,395,150,25);  
        add(seniorCitizenLabel); 
        
        yes1 = new JRadioButton("YES"); 
        yes1.setFont(new Font("Raleway",Font.BOLD,14));
        yes1.setBounds(300, 395, 100, 25);
        yes1.setBackground(Color.WHITE);
        add(yes1);
        
        no1 = new JRadioButton("NO");
        no1.setFont(new Font("Raleway",Font.BOLD,14));
        no1.setBounds(450, 395, 550, 25);
        no1.setBackground(Color.WHITE);
        add(no1); 
        
        ButtonGroup seniorCitizenGroupButton = new ButtonGroup(); 
        seniorCitizenGroupButton.add(no1); 
        seniorCitizenGroupButton.add(yes1);
        
        
        
        
        JLabel existingAccountLabel = new JLabel("Existing A/c:"); 
        existingAccountLabel.setFont(new Font("Raleway",Font.BOLD,20)); 
        existingAccountLabel.setBounds(140,435,150,25);  
        add(existingAccountLabel);
        
        yes2 = new JRadioButton("YES"); 
        yes2.setFont(new Font("Raleway",Font.BOLD,14));
        yes2.setBounds(300, 435, 100, 25);
        yes2.setBackground(Color.WHITE);
        add(yes2);
        
        no2 = new JRadioButton("NO");
        no2.setFont(new Font("Raleway",Font.BOLD,14));
        no2.setBounds(450, 435, 100, 25);
        no2.setBackground(Color.WHITE);
        add(no2); 
        
        ButtonGroup existingAccountGroupButton = new ButtonGroup(); 
        existingAccountGroupButton.add(no2); 
        existingAccountGroupButton.add(yes2);
        
        
        
        JLabel panNumberLabel = new JLabel("PAN Number:"); 
        panNumberLabel.setFont(new Font("Raleway",Font.BOLD,20)); 
        panNumberLabel.setBounds(140,480,150,25);  
        add(panNumberLabel);
        
        panTextField = new JTextField(); 
        panTextField.setFont(new Font("Raleway",Font.BOLD,14));
        panTextField.setBounds(300, 480, 300, 25);
        panTextField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        add(panTextField);
        
        
        next = new JButton("Next"); 
        next.setBackground(Color.BLACK); 
        next.setForeground(Color.WHITE); 
        next.setBounds(500,535,100,40);
        next.addActionListener(this);
        add(next);
        
        
        
        getContentPane().setBackground(Color.WHITE);
        setSize(790,800); 
        setLocation(350,0); 
        setVisible(true);
    }
    public static void main(String[] args) {
        new SignUpTwo("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==next){
            
            String religion = (String)religionComboBox.getSelectedItem();
            String category = (String)categoryComboBox.getSelectedItem();
            String income   = (String)incomeComboBox.getSelectedItem() ;
                    
            String education = (String)educationComboBox.getSelectedItem(); 
            String occupation = (String)occupationComboBox.getSelectedItem(); 
            
            String aadharNo = aadharTextField.getText(); 
            String panNumber = panTextField.getText(); 
            
            String seniorCitizen =""; 
            
            if(yes1.isSelected()){
                seniorCitizen = "YES";
            }else if(no1.isSelected()){
                seniorCitizen = "NO";
            } 
            
            String existingAccount = ""; 
            
            if(yes2.isSelected()){
                existingAccount = "YES";
            }else if(no2.isSelected()){
                existingAccount = "NO";
            }
            
            
            
            
            
           
            
            try{
                if(religion.equals("--")){
                    JOptionPane.showMessageDialog(null, "Religion cannot be null"); 
                    throw new Exception("Please select your religion");
                }
                
                if(category.equals("--")){
                    JOptionPane.showMessageDialog(null,"Category cannot be null"); 
                    throw new Exception("Category is mandatory"); 
                }
                
                if(income.equals("--")){
                    JOptionPane.showMessageDialog(null,"Income cannot be null"); 
                    throw new Exception("Income is mandatory"); 
                }
                
                if(education.equals("--")){
                    JOptionPane.showMessageDialog(null, "education cannot be null");
                    throw new Exception("education cannot be null"); 
                }
                
                if(occupation.equals("--")){
                    JOptionPane.showMessageDialog(null,"occupation cannot be null"); 
                    throw new Exception("occupation cannot be null");
                }
                
                if(seniorCitizen ==null){
                    JOptionPane.showMessageDialog(null,"Please select your marital staus"); 
                    throw new Exception("Please select your marital staus");
                }
                
                if(aadharNo.equals("")){
                    JOptionPane.showMessageDialog(null,"Aadhar number cannot be null"); 
                    throw new Exception("aadhaar number cannot be null");
                }
                
                if(seniorCitizen.equals("")){
                    JOptionPane.showMessageDialog(null,"Please select a valid option for senior citizen"); 
                    throw new Exception("Senior citzen not selected.");
                }
                
                if(existingAccount.equals("")){
                    JOptionPane.showMessageDialog(null,"Please select a valid option for existingAccount"); 
                    throw new Exception("existingAccount not selected.");
                }
                
                if(panNumber.equals("")){
                    JOptionPane.showMessageDialog(null,"PanNumber field cannot be null"); 
                    throw new Exception("PanNumber field cannot be null");
                }
                
                Conn c = new Conn();
                String query = "insert into additional values('" +formNumber+"','"+religion+"','"+category+"','"+income+"','"+education+"','"+occupation+"','"+aadharNo+"','"+seniorCitizen+"','"+existingAccount+"','"+panNumber+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Additional Details persisted successfully..."); 
                setVisible(false);
            }catch(Exception ex){
                System.out.println(ex.getMessage()); 
            }
            
            
        }
    }
}