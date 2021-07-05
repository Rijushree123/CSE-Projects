package hotel_management_system;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;

public class UpdateCheck extends JFrame implements ActionListener
{
	JButton b1,b2,b3;
	Choice c1;
	JTextField t1,t2,t3,t4,t5;
	UpdateCheck()
	{
		JLabel l1 = new JLabel("Check-in Details");
		l1.setForeground(new Color(25, 25, 112));
		l1.setFont(new Font("Tahoma", Font.BOLD, 20));
		l1.setBounds(90, 28, 200, 30);
		add(l1);
		
		JLabel l2 = new JLabel("Customer-ID");
		l2.setBounds(50, 80, 150, 30);
		add(l2);
		
		c1 = new Choice();
		try {
			conn c = new conn();
			ResultSet rs = c.s.executeQuery("select * from customer");
			while(rs.next())
			{
				c1.add(rs.getString("number"));
			}
		}
		catch(Exception e) {}
		c1.setBounds(200,80,150,25);
		add(c1);
		
		JLabel l3 = new JLabel("Room Number");
		l3.setBounds(50, 120, 200, 30);
		add(l3);
		
		t1 = new JTextField();
		t1.setBounds(200,120,150,25);
		add(t1);
		
		JLabel l4 = new JLabel("Name");
		l4.setBounds(50, 160, 200, 30);
		add(l4);
		
		t2 = new JTextField();
		t2.setBounds(200,160,150,25);
		add(t2);
		
		JLabel l5 = new JLabel("Check-In");
		l5.setBounds(50, 200, 200, 30);
		add(l5);
		
		t3 = new JTextField();
		t3.setBounds(200,200,150,25);
		add(t3);
		
		JLabel l6 = new JLabel("Amount Paid");
		l6.setBounds(50, 240, 200, 30);
		add(l6);
		
		t4 = new JTextField();
		t4.setBounds(200,240,150,25);
		add(t4);
		
		JLabel l7 = new JLabel("Pending Amount");
		l7.setBounds(50, 280, 200, 30);
		add(l7);
		
		t5 = new JTextField();
		t5.setBounds(200,280,150,25);
		add(t5);
		
		b1 = new JButton("Check");
		b1.setBounds(35, 340, 100, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Update");
		b2.setBounds(155, 340, 100, 30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);
        
        b3 = new JButton("Back");
		b3.setBounds(275, 340, 100, 30);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.addActionListener(this);
        add(b3);
		
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("check.png"));
        Image i3 = i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel icon = new JLabel(i2);
        icon.setBounds(400,50,500,300);
        add(icon);
        
        
        
		setLayout(null);
		setBounds(295,200,970,500);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			try {
				String room = null;
				String deposite = null;
				int amountPaid=0;
				//String price = null;
				conn c = new conn();
				String id = c1.getSelectedItem();
				String str = "select * from customer where number = '"+id+"'";
				ResultSet rs = c.s.executeQuery(str);
				while(rs.next())
				{
					t1.setText(rs.getString("room"));
				    t2.setText(rs.getString("name"));
				    t3.setText(rs.getString("status"));
				    t4.setText(rs.getString("deposite"));
				    room = rs.getString("room");		
				    deposite = rs.getString("deposite");
				}
				ResultSet rs2 = c.s.executeQuery("select * from room where room_number ='"+room+"'");
				
				while(rs2.next())
				{
					String price = rs2.getString("price");
					amountPaid = Integer.parseInt(price)-Integer.parseInt(deposite);
					t5.setText(Integer.toString(amountPaid));
				}
				
			}catch(Exception e) {}
		}
		else if(ae.getSource()==b2)
		{
			try{
                conn c = new conn();
                
                String id = c1.getSelectedItem();
                String room = t1.getText();  //room number
                String name = t2.getText();  //name
                String check = t3.getText(); //status;    
                String deposit = t4.getText(); //deposit    

                c.s.executeUpdate("update customer set room = '"+room+"', name = '"+name+"', status = '"+check+"', deposite = '"+deposit+"' where number = '"+id+"'");
                
                JOptionPane.showMessageDialog(null, "Data Updated Successfully");
                new Reception().setVisible(true);
                setVisible(false);
            }catch(Exception ee){
                System.out.println(ee);
            }				
		}
		else if(ae.getSource()==b3)
		{
			new Reception().setVisible(true);
			this.setVisible(false);
		}
		
	}
	public static void main(String[] args) 
	{
		new UpdateCheck().setVisible(true);

	}

}
