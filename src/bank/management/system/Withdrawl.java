
package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;


public class Withdrawl extends JFrame implements ActionListener{
    
    JTextField amount;
    JButton withdraw, back ;
    String pinnumber;
    
    Withdrawl(String pinnumber){
        
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700,680, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,-30,700,680);
        add(image);
        
        JLabel text = new JLabel ("Enter the amount you want to Withdraw");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,14));
        text.setBounds(125,270,270,20);
        image.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBounds(125,300,250,20);
        image.add(amount);
        
        withdraw = new JButton("Withdraw");
        withdraw.setBounds(275,400,125,25);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
        back = new JButton("Back");
        back.setBounds(275,427,125,25);
        back.addActionListener(this);
        image.add(back);
        
        
        
        setSize(700,680);
        setLocation(300,10);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()== withdraw){
            String number = amount.getText();
            Date date = new Date();
            if (number.equals("")){
                JOptionPane.showMessageDialog(null, "Please Enter the Amount you want to withdraw");
            }else{
                try{
                Conn conn = new Conn();
                String query = "insert into bank values ('"+pinnumber+"','"+date+"','WITHDRAWL','"+number+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "$"+number+" Withdraw Successful");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
                } catch (Exception e){
                    System.out.println(e);
                }
            }    
        }else if(ae.getSource()==back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
        
    }
    public static void main(String[] args) {
        new Withdrawl("");
    }
}
