package hotel_management_system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class AddEmployee extends JFrame implements ActionListener
{
	JTextField t1, t2, t3, t4, t5, t6;
	JRadioButton r1, r2;
	JComboBox c1;
	JButton b1;
	AddEmployee()
	{
		JLabel name = new JLabel("NAME");
		name.setFont(new Font("Tahoma",Font.PLAIN,17));
		name.setBounds(60,50,120,30);
		add(name);
		
		t1 = new JTextField();
		t1.setBounds(200,50,150,30);
		add(t1);
		
		JLabel age = new JLabel("AGE");
		age.setFont(new Font("Tahoma",Font.PLAIN,17));
		age.setBounds(60,100,120,30);
		add(age);
		
		t2 = new JTextField();
		t2.setBounds(200,100,150,30);
		add(t2);
		
		JLabel gender = new JLabel("GENDER");
		gender.setFont(new Font("Tahoma",Font.PLAIN,17));
		gender.setBounds(60,150,120,30);
		add(gender);
		
		r1 = new JRadioButton("Male");
		r1.setFont(new Font("Tahoma",Font.PLAIN,14));
		r1.setBackground(Color.WHITE);
		r1.setBounds(200,150,70,30);
		add(r1);
		
		r2 = new JRadioButton("Female");
		r2.setFont(new Font("Tahoma",Font.PLAIN,14));
		r2.setBackground(Color.WHITE);
		r2.setBounds(280,150,70,30);
		add(r2);
			
		JLabel job = new JLabel("JOB");
		job.setFont(new Font("Tahoma",Font.PLAIN,17));
		job.setBounds(60,200,120,30);
		add(job);
		
		String str[] = {"Front Desk Clerks","Porters",
				"Housekeeping","Kitchen Staff","Room Service",
				"Waiter/Waitress","Manager","Accountant","Chef"};
		c1 = new JComboBox(str);
		c1.setBackground(Color.WHITE);
		c1.setBounds(200,200,150,30);
		add(c1);
		
		
		JLabel salary = new JLabel("SALARY");
		salary.setFont(new Font("Tahoma",Font.PLAIN,17));
		salary.setBounds(60,250,120,30);
		add(salary);
		
		t3 = new JTextField();
		t3.setBounds(200,250,150,30);
		add(t3);
		
		JLabel phone = new JLabel("PHONE");
		phone.setFont(new Font("Tahoma",Font.PLAIN,17));
		phone.setBounds(60,300,120,30);
		add(phone);
		
		t4 = new JTextField();
		t4.setBounds(200,300,150,30);
		add(t4);
		
		JLabel adhar = new JLabel("ADHAR");
		adhar.setFont(new Font("Tahoma",Font.PLAIN,17));
		adhar.setBounds(60,350,120,30);
		add(adhar);
		
		t5 = new JTextField();
		t5.setBounds(200,350,150,30);
		add(t5);
		
		JLabel email = new JLabel("EMAIL");
		email.setFont(new Font("Tahoma",Font.PLAIN,17));
		email.setBounds(60,400,120,30);
		add(email);
		
		t6 = new JTextField();
		t6.setBounds(200,400,150,30);
		add(t6);
		
		b1 = new JButton("Submit");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(200,450,150,30);
		b1.addActionListener(this);
		add(b1);
		
		JLabel AddPassengers = new JLabel("ADD EMPLOYEE DETAILS");
        AddPassengers.setForeground(Color.BLUE);
        AddPassengers.setFont(new Font("Tahoma", Font.PLAIN, 31));
        AddPassengers.setBounds(440, 18, 442, 35);
        add(AddPassengers);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("emp.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 500,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(390,60,450,450);
        add(image);
        
        		
        getContentPane().setBackground(Color.WHITE);
        
		setLayout(null);
		setBounds(308,180,920,590);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String name = t1.getText();
        String age = t2.getText();
        String salary = t3.getText();
        String phone = t4.getText();
        String aadhar = t5.getText();
        String email = t6.getText();
       
        String gender = null;
        
        if(r1.isSelected())
        {
            gender = "male";
        
        }
        else if(r2.isSelected())
        {
            gender = "female";
        }

                
        String job = (String)c1.getSelectedItem();
        
        try {
            conn c = new conn();
            String str = "INSERT INTO employee values( '"+name+"', '"+age+"', '"+gender+"','"+job+"', '"+salary+"', '"+phone+"','"+aadhar+"', '"+email+"')";
            
            c.s.executeUpdate(str);
            JOptionPane.showMessageDialog(null,"Employee Added");
            setVisible(false);
            } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    

	}

	public static void main(String[] args) 
	{
		new AddEmployee().setVisible(true);
	}

}
