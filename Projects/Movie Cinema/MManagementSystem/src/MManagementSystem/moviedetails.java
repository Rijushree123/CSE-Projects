package MManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTable;

public class moviedetails extends JFrame implements ActionListener 
{
	JMenuBar mb;
	JMenu m1,m2;
	JMenuItem i1,i2,i3,i4,i5;
	JTable t1;
	moviedetails()
	{
		mb = new JMenuBar();
        add(mb);
        mb.setBounds(200,88,580,30);
        
        /*ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("movie4.jpg"));
        JLabel l1 = new JLabel(i1);
        l1.setBounds(0,0,1366,768);
        add(l1);*/
        
		t1= new JTable();
        t1.setBounds(200,118,580,420);
        t1.setBackground(Color.WHITE);
        t1.setFont(new Font("Tahoma",Font.BOLD,14));
        add(t1);
        
        getContentPane().setBackground(Color.WHITE);
		
		setLayout(null);
		setBounds(250,0,1024,720);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		
	}

	public static void main(String[] args) 
	{
		new moviedetails().setVisible(true);

	}

}
