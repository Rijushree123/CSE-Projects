package MManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
    
    JLabel l1,l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1,b2;
    
    Login(){
        l1 = new JLabel("Username");
        l1.setBounds(40,50,100,40);
        add(l1);

        l2 = new JLabel("Password");
        l2.setBounds(40,100,100,40);
        add(l2);
        
        t1 = new JTextField();
        t1.setBounds(150,53,150,30);
        add(t1);
        
        t2 = new JPasswordField();
        t2.setBounds(150,103,150,30);
        add(t2);
        
        b1 =new JButton("Login");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(40,150,100,30);
        b1.addActionListener(this);
        add(b1);
        
        b2= new JButton("Cancel");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(240,150,100,30);
        b2.addActionListener(this);
        add(b2);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("login.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(350,20,200,200);
        add(l3);
        
        
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        setBounds(400,200,600,300);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
        try{
            conn c1 = new conn();
            String u = t1.getText();
            String v = t2.getText();
            
            String q = "select * from login where username= '"+u+"' and pass='"+v+"'";
            
            ResultSet rs = c1.s.executeQuery(q); 
            if(rs.next()){ 
                new Main().setVisible(true);
                this.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(null, "Invalid login");
                setVisible(false);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        }
        else if(ae.getSource()==b2){
            System.exit(0);
        }
    }
    
    public static void main(String args[])
    {
        new Login(); 
    }
}
