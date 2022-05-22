package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener {

    JPasswordField pin, repin;
    JButton change, back;
    String pinnumber;
    
    PinChange(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700, 680, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, -30, 700, 680);
        add(image);

        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(150, 280, 500, 35);
        image.add(text);

        JLabel pintext = new JLabel("New Pin:");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System", Font.BOLD, 16));
        pintext.setBounds(150, 315, 150, 35);
        image.add(pintext);

        pin = new JPasswordField();
        pin.setFont(new Font("Raleway", Font.BOLD, 25));
        pin.setBounds(255, 320, 100, 20);
        image.add(pin);

        JLabel repintext = new JLabel("RE-Enter Pin:");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System", Font.BOLD, 16));
        repintext.setBounds(150, 340, 500, 35);
        image.add(repintext);

        repin = new JPasswordField();
        repin.setFont(new Font("Raleway", Font.BOLD, 25));
        repin.setBounds(255, 345, 100, 20);
        image.add(repin);

        change = new JButton("CHANGE");
        change.setBounds(275, 405, 125, 25);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("BACK");
        back.setBounds(275, 433, 125, 20);
        back.addActionListener(this);
        image.add(back);

        setSize(700, 680);
        setLocation(300, 5);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == change) {
            try {
                String npin = pin.getText();
                String rpin = repin.getText();

                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN does not Match");
                    return;
                }
                
                if (npin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please Enter new PIN");
                    return;
                }
                
                if (rpin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please re-Enter new PIN");
                    return;
                }
                
                Conn conn = new Conn();
                String query1 ="update bank set pin = '"+rpin+"' where pin ='"+pinnumber+"'";
                String query2 ="update login set pin = '"+rpin+"' where pin ='"+pinnumber+"'";
                String query3 ="update signupthree set pin = '"+rpin+"' where pin ='"+pinnumber+"'";    
                
                            
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null, "PIN Changed Successfully");
                
                setVisible(false);
                new Transactions(rpin).setVisible(true);
                       
            } catch (Exception e) {
                System.out.println(e);
            }

        }else{
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }

    }

    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }

}
