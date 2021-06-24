package MManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Main extends JFrame implements ActionListener{
	JMenuBar mb;
    JMenu m1,m2;
    JMenuItem i1,i2,i3,i4,i5;
	
	Main(){
		
		mb = new JMenuBar();
        add(mb);
        
        m1 =new JMenu("Menu");
        m1.setForeground(Color.RED);
        mb.add(m1);
        
        i1= new JMenuItem("Add Actor");
        i1.addActionListener(this);
        m1.add(i1);
         
        i2= new JMenuItem("Add Director");
        i2.addActionListener(this);
        m1.add(i2);
        
        i3= new JMenuItem("Add Movies");
        i3.addActionListener(this);
        m1.add(i3);
                
        i4= new JMenuItem("Add Cast");
        i4.addActionListener(this);
        m1.add(i4);
        mb.setBounds(0,0,1024,30);
		
        i5 =new JMenuItem("Add Rating");
        i5.addActionListener(this);
        m1.add(i5);
		
        /*m2 =new JMenu("Movie Details");
        m2.setForeground(Color.RED);
        mb.add(m2);*/
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("movie4.jpg"));
        JLabel l1 = new JLabel(i1);
        l1.setBounds(0,0,1366,768);
        add(l1);
        
        JLabel l2 = new JLabel("Welcome To Movies Database");
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("tohoma",Font.BOLD,55));
        l2.setBounds(100,120,900,100);
        l1. add(l2);
		
		getContentPane().setBackground(Color.WHITE);
		
		setLayout(null);
		setBounds(250,0,1024,720);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("Add Actor")){
            new AddActor().setVisible(true);
            this.setVisible(false);
        }else if(ae.getActionCommand().equals("Add Director")){
            new AddDirector().setVisible(true);
            this.setVisible(false);
        }else if(ae.getActionCommand().equals("Add Movies")){
            new AddMovies().setVisible(true);
            this.setVisible(false);
        }else if(ae.getActionCommand().equals("Add Cast")){
            new AddCast().setVisible(true);
            this.setVisible(false);
        }else if(ae.getActionCommand().equals("Add Rating")){
        	new AddRating().setVisible(true);
        	this.setVisible(false);
        }
    }
	
	public static void main(String args[]) {
		new Main().setVisible(true);
	}

}

