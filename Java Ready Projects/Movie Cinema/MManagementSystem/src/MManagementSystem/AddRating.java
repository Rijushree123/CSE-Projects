package MManagementSystem;

import javax.swing.*;

import net.proteanit.sql.DbUtils;

import java.awt.*;
import java.awt.event.ActionEvent;
//import java.awt.event.*;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class AddRating extends JFrame implements ActionListener{
	
	JButton b1,b2;
	JButton b11,b22;
	JTable t1;
	JTextField t2,t3,t4,t5;
	JRadioButton r1,r2;
	JMenuBar mb;
	JMenu m1;
	
	AddRating(){
		mb = new JMenuBar();
        add(mb);
        mb.setBounds(580,113,340,30);
        
        m1 =new JMenu("Movie Id                                       Rating Star");
        m1.setForeground(Color.blue);
        m1.setBounds(780,100,340,30);
        mb.add(m1);
        
		JLabel l1 = new JLabel("Movie Rating");
		l1.setBounds(410,50,500,30);
		l1.setFont(new Font("Tahoma",Font.PLAIN,35));
		add(l1);
		
		JLabel l2 =new JLabel("Movie Id");
	       l2.setBounds(40,122,300,30);
	       l2.setFont(new Font("Tahoma",Font.PLAIN,14));
	       add(l2);
	       
	       t2= new JTextField();
	       t2.setBounds(200,127,150,20);
	        add(t2);
	       
	    JLabel l3 =new JLabel("Rating Star");
	       l3.setBounds(40,170,300,30);
	       l3.setFont(new Font("Tahoma",Font.PLAIN,14));
	       add(l3);
	       
	       t3= new JTextField();
	       t3.setBounds(200,175,150,20);
	       
	       add(t3);      
	       
	    
		
		t1= new JTable();
        t1.setBounds(580,142,340,400);
        t1.setBackground(Color.ORANGE);
        t1.setFont(new Font("Tahoma",Font.BOLD,14));
        add(t1);
        
        
        b1 = new JButton("ADD MOVIE RATING");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(198,250,150,30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("DELETE RATING");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(40,250,150,30);
        b2.addActionListener(this);
        add(b2);
        
        
		 b11 = new JButton("Load Data");
	     b11.setBackground(Color.BLACK);
	     b11.setForeground(Color.WHITE);
	     b11.setBounds(350,560,120,30);
	     add(b11);
	     b11.addActionListener(this);
	     
	     b22 = new JButton("Back");
	     b22.setBackground(Color.BLACK);
	     b22.setForeground(Color.WHITE);
	     b22.setBounds(530,560,120,30);
	     add(b22);
	     b22.addActionListener(this);
		
	     ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("movie2.jpg"));
	        JLabel img =new JLabel(i1);
	        img.setBounds(-50,250,590,322);
	        add(img);	     
	     
	     
		getContentPane().setBackground(Color.WHITE);
		
		setLayout(null);
		setBounds(250,0,1024,720);
		setVisible(true);
	}
	
    
    public void actionPerformed(ActionEvent ae){
    	if(ae.getSource()==b1){
            String mov_id= t2.getText();
            String rev_stars  =t3.getText();
            
            
         
            String q1 = "insert into rating values("+mov_id+","+rev_stars+")";
            try{
                conn c= new conn();
                c.s.executeUpdate(q1);
                JOptionPane.showMessageDialog(null,"New rating added Successfully!");
                //new Main().setVisible(true);
                //this.setVisible(false);
                t2.setText("");
                t3.setText("");
            }   catch(Exception e){}
        }
    	else if(ae.getSource()==b2){
    		String mov_id= t2.getText();
            String rev_stars  =t3.getText();
            
         
            String q1 = "delete from rating where mov_id='"+mov_id+"' and rev_stars="+rev_stars;
            try{
                conn c= new conn();
                c.s.executeUpdate(q1);
                JOptionPane.showMessageDialog(null,"Movie deleted Successfully!");
                //new Main().setVisible(true);
                //this.setVisible(false);
                t2.setText("");
                t3.setText("");
                
            }   catch(Exception e){}
        }
    	else if(ae.getSource()==b11){
        	
            try{
                conn c =new conn();
                
                String col[] = {"Actor id", "Actor Name", "Actor Gender"};
                String str ="Select * from rating";
                ResultSet rs = c.s.executeQuery(str);
                
                t1.setModel(DbUtils.resultSetToTableModel(rs));
                
                
            }catch(Exception e){
                
            }
            
        }else if(ae.getSource()==b22){
            new Main().setVisible(true);
            this.setVisible(false);
        }
    }
	
	public static void main(String args[]) {
		new AddRating().setVisible(true);
	}
}