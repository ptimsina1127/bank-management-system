
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{
    
    JButton deposit,withdrawl,ministatement,pinchange,fastcash,balanceenquiry,exit;
    String pinnumber;
    Transactions(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon (ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700, 680, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,-30,700,680);
        add (image);
        
        JLabel text = new JLabel ("Please Select your Transaction");
        text.setBounds(155,270,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        deposit = new JButton("Deposit") ;
        deposit.setBounds(135,345,125,25);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl = new JButton("Cash Withdrawl") ;
        withdrawl.setBounds(275,345,125,25);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastcash = new JButton("Fast Cash") ;
        fastcash.setBounds(135,375,125,25);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministatement = new JButton("Mini Statement") ;
        ministatement.setBounds(275,375,125,25);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        pinchange = new JButton("Pin Change") ;
        pinchange.setBounds(135,405,125,25);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balanceenquiry = new JButton("Balance Enquiry") ;
        balanceenquiry.setFont(new Font("system",Font.BOLD,11));
        balanceenquiry.setBounds(275,405,125,25);
        image.add(balanceenquiry);
        
        exit = new JButton("Exit") ;
        exit.setBounds(275,433,125,20);
        exit.addActionListener(this);
        image.add(exit);
        
        
        setSize(700,680);
        setLocation(300,10);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==exit){
            System.exit(0);
        } else if (ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        } else if (ae.getSource()== withdrawl){
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        new Transactions("");
    }
}
