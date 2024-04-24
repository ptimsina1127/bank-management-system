
package bank.management.system;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener{
    
    long random;
    JTextField nameTextField , fnameTextField,emailTextField,
                addressTextField,cityTextField,stateTextField,
                zipTextField;
    JButton next,clear;
    JRadioButton male,female,others,married,unmarried;
    JDateChooser dateChooser;
    
    SignupOne(){
        
        setLayout(null);
        
        Random ran = new Random();
        random = (Math.abs(ran.nextLong()%9000L)+1000L);
             
        JLabel formno = new JLabel("APPLICATION FORM NO." + random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140, 0, 600, 40);
        add(formno);
                
        JLabel personDetails = new JLabel("Page 1: Personal Details");
        personDetails.setFont(new Font("Raleway",Font.BOLD,22));
        personDetails.setBounds(290, 50, 400, 30);
        add(personDetails);
        
        JLabel name = new JLabel("Name:*");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100, 140, 100, 30);
        add(name);
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font ("Raleway",Font.BOLD, 14));
        nameTextField.setBounds(300, 140, 400, 30);
        add(nameTextField);
        
        JLabel fname = new JLabel("Fathers Name:");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100, 190, 150, 30);
        add(fname);
        
        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font ("Raleway",Font.BOLD, 14));
        fnameTextField.setBounds(300, 190, 400, 30);
        add(fnameTextField);
        
        
        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100, 240, 150, 30);
        add(dob);
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 240, 400, 30);
        dateChooser.setForeground(new Color(105,105,105));
        add(dateChooser);
        
        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100, 290, 100, 30);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(300, 290, 60, 30);
        male.setBackground(Color.WHITE);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(450, 290, 120, 30);
        female.setBackground(Color.WHITE);
        add(female);
        
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        JLabel email = new JLabel("Email:");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100, 340, 100, 30);
        add(email);
        
        emailTextField = new JTextField();
        emailTextField.setFont(new Font ("Raleway",Font.BOLD, 14));
        emailTextField.setBounds(300, 340, 400, 30);
        add(emailTextField);
        
        JLabel marital = new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setBounds(100, 390, 150, 30);
        add(marital);
        
        married = new JRadioButton("Married");
        married.setBounds(300, 390, 100, 30);
        married.setBackground(Color.WHITE);
        add(married);
        
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450, 390, 100, 30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        
        others = new JRadioButton("Others");
        others.setBounds(600, 390, 100, 30);
        others.setBackground(Color.WHITE);
        add(others);
        
        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(others);
        
        
        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100, 440, 150, 30);
        add(address);
        
        addressTextField = new JTextField();
        addressTextField.setFont(new Font ("Raleway",Font.BOLD, 14));
        addressTextField.setBounds(300, 440, 400, 30);
        add(addressTextField);
        
        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100, 490, 150, 30);
        add(city);
        
        cityTextField = new JTextField();
        cityTextField.setFont(new Font ("Raleway",Font.BOLD, 14));
        cityTextField.setBounds(300, 490, 400, 30);
        add(cityTextField);
        
        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100, 540, 150, 30);
        add(state);
        
        stateTextField = new JTextField();
        stateTextField.setFont(new Font ("Raleway",Font.BOLD, 14));
        stateTextField.setBounds(300, 540, 400, 30);
        add(stateTextField);
        
        JLabel pincode = new JLabel("ZIP Code:*");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100, 590, 150, 30);
        add(pincode);
        
        zipTextField = new JTextField();
        zipTextField.setFont(new Font ("Raleway",Font.BOLD, 14));
        zipTextField.setBounds(300, 590, 400, 30);
        add(zipTextField);
        
//        clear = new JButton("CLEAR");
//        clear.setBounds(300, 90, 80, 30);
//        clear.setBackground(Color.BLACK);
//        clear.setForeground(Color.WHITE);
//        clear.addActionListener(this);
//        add(clear);
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(390, 90, 80, 30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,670);
        
        setLocation(350,10);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
            String formno = ""+random; // long
            String name = nameTextField.getText();
            String fname = fnameTextField.getText();
            String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
            String gender = null;
            if (male.isSelected()){
                gender ="Male";
            }
            else if (female.isSelected()){
                gender = "Female";
            }
            
            String email = emailTextField.getText();
            String marital = null;
            if(married.isSelected()){
                marital = "Married";
            }
            else if (unmarried.isSelected()){
                marital = "Unmarried";
            }
            else if (others.isSelected()){
                marital = "Other";
            }
            
            String address = addressTextField.getText();
            String city = cityTextField.getText();
            String state = stateTextField.getText();
            String pin = zipTextField.getText();
            
            try{
                if (name.equals("")){
                    JOptionPane.showMessageDialog(null, "Name is Required:");
                }
                else if(pin.equals("")){
                    JOptionPane.showMessageDialog(null, "ZipCode is Required!");
                } 
                
                else {
                    Conn c = new Conn();
                    String query = "insert into signup values ('" + formno+"', '"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
                    c.s.executeUpdate(query);
                    
                    setVisible(false);
                    new SignupTwo(formno).setVisible(true);
                }
            } 
            catch (Exception e){
                System.out.println(e);
            } 
        }
    public static void main(String[] args) {
        new SignupOne();
        
    }
}