package hotel_management_system;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

import net.proteanit.sql.DbUtils;

public class SearchRoom extends JFrame implements ActionListener
{
	JComboBox comboc1;
	JCheckBox c2;
	JButton b1,b2;
	JTable t1;
	SearchRoom()
	{
		JLabel l1 = new JLabel("Search For Room");
		l1.setFont(new Font("Tahoma",Font.PLAIN,20));
		l1.setBounds(400,30,200,30);
		add(l1);
		
		JLabel l2 = new JLabel("Room Bed Type");
		l2.setBounds(50,100,100,20);
		add(l2);
		
		comboc1 = new JComboBox(new String[]{"Single Bed", "Double Bed"});
		comboc1.setBounds(150,100,150,25);
		comboc1.setBackground(Color.white);
		add(comboc1);
		
		c2 = new JCheckBox("Only display avialable");
		c2.setBounds(600,100,150,25);
		c2.setBackground(Color.white);
		add(c2);
		
		t1 = new JTable();
		t1.setBounds(0,200,1000,300);
		add(t1);
		
		JLabel l3 = new JLabel("Room Number");
		l3.setBounds(50,160,100,20);
		add(l3);
		
		JLabel l4 = new JLabel("Availability");
		l4.setBounds(270,160,100,20);
		add(l4);
		
		JLabel l5 = new JLabel("Cleaning Status");
		l5.setBounds(450,160,100,20);
		add(l5);
		
		JLabel l6 = new JLabel("Price");
		l6.setBounds(670,160,100,20);
		add(l6);
		
		JLabel l7 = new JLabel("Bed Type");
		l7.setBounds(870,160,100,20);
		add(l7);
		
		
		
		b1 = new JButton("Check");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(350,520,120,30);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Back");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(500,520,120,30);
		b2.addActionListener(this);
		add(b2);
		
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setBounds(270,170,1000,650);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			try
			{
				String str = "select * from room where bed_type = '"+comboc1.getSelectedItem() +"'";
				String str2 = "select * from room where available ='Available' and bed_type= '"+comboc1.getSelectedItem()+"'";
				conn c =new conn();
				ResultSet rs = c.s.executeQuery(str);
				t1.setModel(DbUtils.resultSetToTableModel(rs));
				if(c2.isSelected())
				{
					ResultSet rs2 = c.s.executeQuery(str2);
					t1.setModel(DbUtils.resultSetToTableModel(rs2));
				}
			}
			catch(Exception e) 
			{
				System.out.println(e);
			}
		}
		else if(ae.getSource()==b2)
		{
			new Reception().setVisible(true);
			this.setVisible(false);
		}
	}
	
	public static void main(String[] args) 
	{
		new SearchRoom().setVisible(true);;

	}

}
