package hotel_management_system;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;

public class Dashboard extends JFrame implements ActionListener
{
	JMenuBar mb;
	JMenu m1,m2;
	JMenuItem i1,i2,i3,i4;
	Dashboard()
	{
		mb = new JMenuBar();
		add(mb);
		
		m1 = new JMenu("HOTEL MANAGEMENT");
	    m1.setForeground(Color.RED);
		mb.add(m1);
		m2 = new JMenu("ADMIN");
		m2.setForeground(Color.blue);
		mb.add(m2);
		i1 = new JMenuItem("RECEPTION");
		i1.addActionListener(this);
		m1.add(i1);
		i2 = new JMenuItem("ADD EMPLOYEE");
		i2.addActionListener(this);
		m2.add(i2);
		i3 = new JMenuItem("ADD ROOMS");
		i3.addActionListener(this);
		m2.add(i3);
		i4 = new JMenuItem("ADD DRIVERS");
		i4.addActionListener(this);
		m2.add(i4);
		
		mb.setBounds(0,0,1542,30);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("third.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1542, 830,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2); 
		JLabel l1 = new JLabel(i3);
		l1.setBounds(0,0,1542,830);
		add(l1);
		
		
		JLabel l2 = new JLabel("The TAJ GROUP WELCOMES YOU!");
		l2.setBounds(373,50,1000,100);
		l2.setForeground(Color.white);
		l2.setFont(new Font("Tahoma",Font.PLAIN,50));
		l1.add(l2);
		
		setLayout(null);
		setBounds(1,3,1534,830);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getActionCommand().equals("RECEPTION"))
		{
			new Reception().setVisible(true);
		}
		else if(ae.getActionCommand().equals("ADD EMPLOYEE"))
		{
			new AddEmployee().setVisible(true);
		}
		else if(ae.getActionCommand().equals("ADD ROOMS"))
		{
			new AddRooms().setVisible(true);
		}
		else if(ae.getActionCommand().equals("ADD DRIVERS"))
		{
			new AddDrivers().setVisible(true);
		}
		
	}
	public static void main(String[] args) 
	{
		new Dashboard().setVisible(true);
	}

	

}
