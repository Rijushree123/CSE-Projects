package hotel_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddRooms extends JFrame implements ActionListener
{
	private JPanel contentPane;
	private JTextField t1,t2,t3,t4;
    private JComboBox comboBox, comboBox_1, comboBox_2, comboBox_3;
    JButton b1,b2;
    Choice c1;
	AddRooms()
	{
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel l1 = new JLabel("Add Rooms");
        l1.setFont(new Font("Tahoma", Font.BOLD, 18));
        l1.setBounds(150, 20, 120, 20);
        contentPane.add(l1);
		
        JLabel room = new JLabel("Room Number");
    	room.setForeground(new Color(25, 25, 112));
    	room.setFont(new Font("Tahoma", Font.BOLD, 14));
    	room.setBounds(60, 80, 120, 30);
    	contentPane.add(room);
    	
    	t1 = new JTextField();
    	t1.setBounds(200, 80, 150, 30);
    	contentPane.add(t1);
    	
    	JLabel available = new JLabel("Available");
    	available.setForeground(new Color(25, 25, 112));
    	available.setFont(new Font("Tahoma", Font.BOLD, 14));
    	available.setBounds(60, 130, 120, 30);
    	contentPane.add(available);
    	
    	comboBox = new JComboBox(new String[] { "Available", "Occupied" });
    	comboBox.setBackground(Color.WHITE);
    	comboBox.setBounds(200, 130, 150, 30);
    	contentPane.add(comboBox);
    	
    	JLabel status = new JLabel("Cleaning Status");
    	status.setForeground(new Color(25, 25, 112));
    	status.setFont(new Font("Tahoma", Font.BOLD, 14));
    	status.setBounds(60, 180, 120, 30);
    	contentPane.add(status);
    	
    	comboBox_2 = new JComboBox(new String[] { "Cleaned", "Dirty" });
    	comboBox_2.setBackground(Color.WHITE);
    	comboBox_2.setBounds(200, 180, 150, 30);
    	contentPane.add(comboBox_2);
    	
    	JLabel price = new JLabel("Price");
    	price.setForeground(new Color(25, 25, 112));
    	price.setFont(new Font("Tahoma", Font.BOLD, 14));
    	price.setBounds(60, 230, 120, 30);
    	contentPane.add(price);
    	
    	t2 = new JTextField();
    	t2.setBounds(200, 230, 150, 30);
    	contentPane.add(t2);
    	
    	JLabel bed = new JLabel("Bed Type");
    	bed.setForeground(new Color(25, 25, 112));
    	bed.setFont(new Font("Tahoma", Font.BOLD, 14));
    	bed.setBounds(60, 280, 120, 30);
    	contentPane.add(bed);
    	
    	comboBox_3 = new JComboBox(new String[] { "Single Bed", "Double Bed"});
    	comboBox_3.setBackground(Color.WHITE);
    	comboBox_3.setBounds(200, 280, 150, 30);
    	contentPane.add(comboBox_3);
    	
    	b1 = new JButton("Add Rooms");
    	b1.addActionListener(this);
    	b1.setBounds(60, 350, 130, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
    	contentPane.add(b1);

    	b2 = new JButton("Back");
    	b2.addActionListener(this);
    	b2.setBounds(220, 350, 130, 30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
    	contentPane.add(b2);
    	
    	ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("twelve.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l15 = new JLabel(i2);
        l15.setBounds(400,30,500,350);
        add(l15);

		getContentPane().setBackground(Color.WHITE);
    	
		setBounds(308,200,940,470);
		setLayout(null);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae){
        try{
            
            if(ae.getSource() == b1){
                try{
                conn c = new conn();
                String room = t1.getText();
                String available = (String)comboBox.getSelectedItem();
                String status = (String)comboBox_2.getSelectedItem();
                String price  = t2.getText();
                String type = (String)comboBox_3.getSelectedItem();
                String str = "INSERT INTO room values( '"+room+"', '"+available+"', '"+status+"','"+price+"', '"+type+"')";
              
                
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Room Successfully Added");
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
		new AddRooms().setVisible(true);
	}

}
