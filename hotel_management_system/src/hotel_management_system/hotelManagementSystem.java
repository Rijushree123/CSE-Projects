package hotel_management_system;

import java.awt.Color;
import java.awt.event.*;

import javax.swing.*;
import java.awt.*;

public class hotelManagementSystem extends JFrame implements ActionListener
{
	hotelManagementSystem()
	{
		//setSize(400,400);
		
		//setLocation(300,300);
		
		ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("first.jpg"));
		JLabel l1 = new JLabel(i1);
		l1.setBounds(0, 0, 1366, 565);
		add(l1);
		
		JLabel l2 = new JLabel("Hotel Management System");
		l2.setBounds(20, 430, 1000, 90);
		l2.setForeground(Color.white);
		l2.setFont(new Font("serif", Font.PLAIN, 70));
		l1.add(l2);
		
		JButton b1 = new JButton("Next");
		b1.setBackground(Color.white);
		b1.setForeground(Color.black);
		b1.setBounds(1100,450,150,50);
		b1.addActionListener(this);
		l1.add(b1);
		
		
		setLayout(null);
		setBounds(80,100,1366,565);
		setVisible(true);
		
		/*while(true)
		{
			l2.setVisible(false);
			try {
				Thread.sleep(500);
			}
			catch(Exception e){}
			l2.setVisible(true);
			try {
			Thread.sleep(500);
			}
			catch(Exception e){}
		}*/
		
		
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		new login().setVisible(true);
		this.setVisible(false);
	}

	public static void main(String[] args) 
	{
		new hotelManagementSystem();
		
		
	}

}
