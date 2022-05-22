
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
public class FastCash extends JFrame implements ActionListener{
    
    JButton deposit,withdrawl,ministatement,pinchange,fastcash,balanceenquiry,exit;
    String pinnumber;
    FastCash(String pinnumber){
        this.pinnumber = pinnumber;        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon (ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700, 680, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,-30,700,680);
        add (image);
        
        JLabel text = new JLabel ("PLEASE SELECT WITHDRAWL AMOUNT");
        text.setBounds(140,270,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,12));
        image.add(text);
        
        deposit = new JButton("$20") ;
        deposit.setBounds(135,345,125,25);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl = new JButton("$40") ;
        withdrawl.setBounds(275,345,125,25);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastcash = new JButton("$60") ;
        fastcash.setBounds(135,375,125,25);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministatement = new JButton("$100") ;
        ministatement.setBounds(275,375,125,25);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        pinchange = new JButton("$200") ;
        pinchange.setBounds(135,405,125,25);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balanceenquiry = new JButton("$500") ;
        balanceenquiry.setFont(new Font("system",Font.BOLD,11));
        balanceenquiry.setBounds(275,405,125,25);
        image.add(balanceenquiry);
        
        exit = new JButton("BACK") ;
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
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        } else {
            String amount = ((JButton)ae.getSource()).getText().substring(1);
            Conn c = new Conn();
            try {
                ResultSet rs = c.s.executeQuery("Select * from bank where pin = '"+pinnumber+"'");
                int balance = 0;
                while (rs.next()){
                    if (rs.getString("type").equals("deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if (ae.getSource() != exit && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "insufficient Balance");
                    return;
                }
                 Date date = new Date();
                 String query = "insert into bank values('"+pinnumber+"','"+date+"','withdrawl','"+amount+"')";
                 c.s.executeUpdate(query);
                 JOptionPane.showMessageDialog(null,"$"+amount+" Debited Successfully");
                 
                 setVisible(false);
                 new Transactions (pinnumber).setVisible(true);
                 
            } catch (Exception e){
                System.out.println(e);
            }
        }
    }
    
    public static void main(String[] args) {
        new FastCash("");
    }
}
