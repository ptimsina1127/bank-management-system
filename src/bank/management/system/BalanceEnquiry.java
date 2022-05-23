package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {

    JButton back;
    String pinnumber;

    BalanceEnquiry(String pinnumber) {

        this.pinnumber = pinnumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700, 680, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, -30, 700, 680);
        add(image);

        back = new JButton("Back");
        back.setBounds(275, 433, 125, 20);
        back.addActionListener(this);
        image.add(back);

        Conn c = new Conn();
        
        int balance = 0;
        
        try {
            ResultSet rs = c.s.executeQuery("Select * from bank where pin = '" + pinnumber + "'");
            
            while (rs.next()) {
                if (rs.getString("type").equals("DEPOSIT")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
            JLabel text = new JLabel("Your Current balance is $ "+ balance);
            text.setForeground(Color.WHITE);
            text.setBounds(150,270,300,30);
            image.add(text);

            setSize(700, 680);
            setLocation(275, 5);
            setUndecorated(true);
            setVisible(true);
        }
    
    

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("");
    }

}
