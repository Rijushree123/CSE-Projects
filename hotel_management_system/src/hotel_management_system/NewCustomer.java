package hotel_management_system;

import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class NewCustomer extends JFrame implements ActionListener
{
	JTextField t1,t2,t3,t4,t5;
	JButton b1 , b2;
	JComboBox comboBox;
	Choice c2;
	JRadioButton r1,r2;
	NewCustomer()
	{
		JLabel l1 = new JLabel("NEW CUSTOMER FORM");
		l1.setBounds(100,20,300,30);
		l1.setForeground(Color.BLUE);
		l1.setFont(new Font("Tahoma",Font.PLAIN,20));
		add(l1);
		
		JLabel l2 = new JLabel("ID");
		l2.setBounds(35,80,100,30);
		add(l2);
		
		comboBox = new JComboBox(new String[] {"Passport", "Aadhar Card", "Voter Id", "Driving license"});
		comboBox.setBounds(200, 80, 150, 25);
		comboBox.setBackground(Color.WHITE);
		add(comboBox);
		
		JLabel l3 = new JLabel("NUMBER");
		l3.setBounds(35,120,100,30);
		add(l3);
		
		t1 = new JTextField();
		t1.setBounds(200, 120, 150, 25);
		add(t1);
		
		JLabel l4 = new JLabel("NAME");
		l4.setBounds(35,160,100,30);
		add(l4);
		
		t2 = new JTextField();
		t2.setBounds(200, 160, 150, 25);
		add(t2);
		
		JLabel l5 = new JLabel("GENDER");
		l5.setBounds(35,200,100,30);
		add(l5);
		
		r1 = new JRadioButton("Male");
		r1.setBounds(200,200,60,25);
		r1.setBackground(Color.WHITE);
		add(r1);
		
		r2 = new JRadioButton("Female");
		r2.setBounds(270,200,80,25);
		r2.setBackground(Color.WHITE);
		add(r2);
		
		JLabel l6 = new JLabel("COUNTRY");
		l6.setBounds(35,240,100,30);
		add(l6);
		
		t3 = new JTextField();
		t3.setBounds(200, 240, 150, 25);
		add(t3);
		
		JLabel l7 = new JLabel("ALLOCATED ROOM  NO.");
		l7.setBounds(35,280,160,30);
		add(l7);
		
		c2 = new Choice();
        /*try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from room where available = 'Available'");
            ResultSet rs2 = c.s.executeQuery("select count(available) as rowcount from room where available='Available'");    
            rs2.next();
            int count = rs2.getInt("rowcount");
            //System.out.println(count);
            if(count==0)
            {
            	c2.add("No Room Available");
            }
            else {
            while(rs.next()){
                c2.add(rs.getString("room_number"));    
            }
            }
        }catch(Exception e){ }*/
		try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from room where available = 'Available'");
            while(rs.next()){
                c2.add(rs.getString("room_number"));    
            }
            
        }catch(Exception e){ }
        c2.setBounds(200, 280, 150, 25);
        add(c2);
		
		JLabel l8 = new JLabel("CHECKED IN");
		l8.setBounds(35,320,150,30);
		add(l8);
		
		t4 = new JTextField();
		t4.setBounds(200, 320, 150, 25);
		add(t4);
		
		JLabel l9 = new JLabel("DEPOSITE");
		l9.setBounds(35,360,150,30);
		add(l9);
		
		t5 = new JTextField();
		t5.setBounds(200, 360, 150, 25);
		add(t5);
		
		b1 = new JButton("Add Customer");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(60,410,120,25);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Back");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(200,410,120,25);
		b2.addActionListener(this);
		add(b2);
		
		ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("fifth.png"));
        Image i3 = i1.getImage().getScaledInstance(300, 400,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel icon = new JLabel(i2);
        icon.setBounds(400,50,300,400);
        add(icon);
		
		
		getContentPane().setBackground(Color.white);
		setLayout(null);
		setBounds(388,200,750,500);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == b1)
		{
		String id = (String)comboBox.getSelectedItem();
		String number = t1.getText();
		String name = t2.getText();
		String gender = null;
		if(r1.isSelected())
		{
			gender = "Male";
		}
		else if(r2.isSelected())
		{
			gender = "Female";
		}
		String country = t3.getText();
		String room = c2.getSelectedItem();
		String status = t4.getText();
		String deposite = t5.getText();
		String str = "insert into customer values('"+id+"','"+ number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+status+"','"+deposite+"')";
		String str2 = "update room set available = 'Occupied' where  room_number = '"+room+"'";
		
		try {
			conn c = new conn();
			c.s.executeUpdate(str);
			
			JOptionPane.showMessageDialog(null, "New Customer Added");
			c.s.executeUpdate(str2);
			new Reception().setVisible(true);
			this.setVisible(false);
		}
		catch(Exception e) {}
	}
		else if(ae.getSource() == b2)
		{
			new Reception().setVisible(true);
			this.setVisible(false);
		}
	}
	public static void main(String[] args) 
	{
		new NewCustomer().setVisible(true);

	}

}
