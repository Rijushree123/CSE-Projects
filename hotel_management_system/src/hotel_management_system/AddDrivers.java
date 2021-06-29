package hotel_management_system;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class AddDrivers extends JFrame implements ActionListener
{
	private JPanel contentPane;
    private JTextField t1,t2,t3,t4, t5;
    private JComboBox comboBox, comboBox_1;
    JButton b1,b2;
    Choice c1;
    
	AddDrivers()
	{
		JLabel l10 = new JLabel("Add Drivers");
        l10.setFont(new Font("Tahoma", Font.BOLD, 18));
        l10.setBounds(150, 10, 150, 30);
        add(l10);
		
		JLabel name = new JLabel("Name");
		name.setForeground(new Color(25, 25, 112));
		name.setFont(new Font("Tahoma", Font.BOLD, 14));
		name.setBounds(60, 70, 100, 30);
		add(name);
		
		t1 = new JTextField();
		t1.setBounds(200, 70, 150, 30);
		add(t1);
		
		JLabel age = new JLabel("Age");
		age.setForeground(new Color(25, 25, 112));
		age.setFont(new Font("Tahoma", Font.BOLD, 14));
		age.setBounds(60, 110, 100, 30);
		add(age);
		
		t2 = new JTextField();
		t2.setBounds(200, 110, 150, 30);
		add(t2);
		
		JLabel gender = new JLabel("Gender");
		gender.setForeground(new Color(25, 25, 112));
		gender.setFont(new Font("Tahoma", Font.BOLD, 14));
		gender.setBounds(60, 150, 100, 30);
		add(gender);
		
		comboBox = new JComboBox(new String[] { "Male", "Female" });
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(200, 150, 150, 30);
		add(comboBox);
		
		JLabel car = new JLabel("Car Company");
		car.setForeground(new Color(25, 25, 112));
		car.setFont(new Font("Tahoma", Font.BOLD, 14));
		car.setBounds(60, 190, 100, 30);
		add(car);
		
		t3 = new JTextField();
		t3.setBounds(200, 190, 150, 30);
		add(t3);
		
		JLabel brand = new JLabel("Car Brand");
		brand.setForeground(new Color(25, 25, 112));
		brand.setFont(new Font("Tahoma", Font.BOLD, 14));
		brand.setBounds(60, 230, 100, 30);
		add(brand);
		
		t4 = new JTextField();
		t4.setBounds(200, 230, 150, 30);
		add(t4);
		
		JLabel available = new JLabel("Available");
		available.setForeground(new Color(25, 25, 112));
		available.setFont(new Font("Tahoma", Font.BOLD, 14));
		available.setBounds(60, 270, 100, 30);
		add(available);
		
		comboBox_1 = new JComboBox(new String[] { "Yes", "No" });
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setBounds(200, 270, 150, 30);
		add(comboBox_1);

		
		JLabel location = new JLabel("Location");
		location.setForeground(new Color(25, 25, 112));
		location.setFont(new Font("Tahoma", Font.BOLD, 14));
		location.setBounds(60, 310, 100, 30);
		add(location);
		
		t5 = new JTextField();
		t5.setBounds(200, 310, 150, 30);
		add(t5);
		
		b1 = new JButton("Add");
		b1.addActionListener(this);
		b1.setBounds(60, 370, 130, 30);
	    b1.setBackground(Color.BLACK);
	    b1.setForeground(Color.WHITE);
		add(b1);

		b2 = new JButton("Back");
		b2.addActionListener(this);
		b2.setBounds(220, 370, 130, 30);
	    b2.setBackground(Color.BLACK);
	    b2.setForeground(Color.WHITE);
		add(b2);
		
		ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("eleven.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l15 = new JLabel(i2);
        l15.setBounds(400,30,500,370);
        add(l15);

		getContentPane().setBackground(Color.WHITE);
		setBounds(288, 200, 980, 500);
		setLayout(null);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae){
        try{
            
            if(ae.getSource() == b1){
                try{
                conn c = new conn();
                String name = t1.getText();
                String age = t2.getText();
                String gender = (String)comboBox.getSelectedItem();
                String company  = t3.getText();
                String brand = t4.getText();
                String available = (String)comboBox_1.getSelectedItem();
                String location = t5.getText();
                String str = "INSERT INTO driver values( '"+name+"', '"+age+"', '"+gender+"','"+company+"', '"+brand+"', '"+available+"','"+location+"')";
              
                
		c.s.executeUpdate(str);
		JOptionPane.showMessageDialog(null, "Driver Successfully Added");
                this.setVisible(false);
               
                }catch(Exception ee){
                    System.out.println(ee);
                }
            }
            else if(ae.getSource() == b2){
                this.setVisible(false);
            }
        }catch(Exception eee){
            
        }
    }
	
	public static void main(String[] args) 
	{
		new AddDrivers().setVisible(true);;

	}

}
