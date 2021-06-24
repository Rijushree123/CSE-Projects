package MManagementSystem;

import javax.swing.*;

import net.proteanit.sql.DbUtils;

import java.awt.*;
//import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class AddMovies extends JFrame implements ActionListener{
	
	JButton b1,b2,b3,b4,b5,b6;
	JButton b11,b22;
	JTable t1;
	JTextField t2,t3,t4,t5,t6;
	JRadioButton r1,r2;
	Choice c2;
	JMenuBar mb;
	JMenu m1;
	
	AddMovies(){
		
		mb = new JMenuBar();
        add(mb);
        mb.setBounds(540,88,450,30);
        
        m1 =new JMenu("Movie Id            Movie Title        Mov_Year          Mov_Lang           Director Id");
        m1.setForeground(Color.blue);
        m1.setBounds(540,100,450,30);
        mb.add(m1);
		
		JLabel l1 = new JLabel("Movies");
		l1.setBounds(450,50,500,30);
		l1.setFont(new Font("Tahoma",Font.PLAIN,35));
		add(l1);
		
		JLabel l2 =new JLabel("Movie Id");
	       l2.setBounds(40,92,300,30);
	       l2.setFont(new Font("Tahoma",Font.PLAIN,14));
	       add(l2);
	       
	       t2= new JTextField();
	       t2.setBounds(200,97,150,20);
	        add(t2);
	       
	    JLabel l3 =new JLabel("Movie Title");
	       l3.setBounds(40,135,300,30);
	       l3.setFont(new Font("Tahoma",Font.PLAIN,14));
	       add(l3);
	       
	       t3= new JTextField();
	       t3.setBounds(200,140,150,20);
	        add(t3);      
	       
	    JLabel l4 =new JLabel("Mov_Year");
	       l4.setBounds(40,185,300,30);
	       l4.setFont(new Font("Tahoma",Font.PLAIN,14));
	       add(l4);
	       
	       t4= new JTextField();
	       t4.setBounds(200,190,150,20);
	        add(t4);
	       
	    JLabel l5 =new JLabel(" Mov_Lang");
		   l5.setBounds(36,235,300,30);
		   l5.setFont(new Font("Tahoma",Font.PLAIN,14));
		   add(l5);
		       
		   t5= new JTextField();
		   t5.setBounds(200,240,150,20);
		   add(t5);	
		   
		JLabel l6 =new JLabel("Director Id");
	       l6.setBounds(40,285,150,30);
	       l6.setFont(new Font("Tahoma",Font.PLAIN,14));
	       add(l6);
	       
	       t6= new JTextField();
		   t6.setBounds(200,290,150,20);
		   add(t6);	
	        
	        
		t1= new JTable();
        t1.setBounds(540,119,450,430);
        t1.setBackground(Color.green);
        t1.setFont(new Font("Tahoma",Font.BOLD,14));
        add(t1);
        
        
        
        
        b2 = new JButton("DELETE MOVIE");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(40,330,130,30);
        b2.addActionListener(this);
        add(b2);
        
        b1 = new JButton("ADD MOVIE");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(180,330,130,30);
        b1.addActionListener(this);
        add(b1);
        
        b3 = new JButton("UPDATE YEAR");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(320,330,130,30);
        b3.addActionListener(this);
        add(b3);
        
        b4 = new JButton("UPDATE TITLE");
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        b4.setBounds(40,380,130,30);
        b4.addActionListener(this);
        add(b4);
        
        b5 = new JButton("UPDATE LANG");
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.WHITE);
        b5.setBounds(180,380,130,30);
        b5.addActionListener(this);
        add(b5);
        
        b6 = new JButton("UPDATE DIRECTOR");
        b6.setBackground(Color.BLACK);
        b6.setForeground(Color.WHITE);
        b6.setBounds(320,380,130,30);
        b6.addActionListener(this);
        add(b6);
        
        
        
        
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
		
	     ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("movie1.jpg"));
	        JLabel img =new JLabel(i1);
	        img.setBounds(-111,340,590,322);
	        add(img);	
	     
	     
		getContentPane().setBackground(Color.WHITE);
		
		setLayout(null);
		setBounds(250,0,1024,720);
		setVisible(true);
	}
	
    
    public void actionPerformed(ActionEvent ae){
    	if(ae.getSource()==b1){
            String Mov_id= t2.getText();
            String Mov_Title =t3.getText();
            String Mov_Year = t4.getText();
            String Mov_Lang = t5.getText();
            String Dir_id = t6.getText();
         
            String q1 = "insert into movies values("+Mov_id+",'"+Mov_Title+"',"+Mov_Year+",'"+Mov_Lang+"',"+Dir_id+")";
            try{
                conn c= new conn();
                c.s.executeUpdate(q1);
                JOptionPane.showMessageDialog(null,"New movie added Successfully!");
                //new Main().setVisible(true);
                //this.setVisible(false);
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                t6.setText("");
                
            }   catch(Exception e){}
        }
    	else if(ae.getSource()==b2){
            String Mov_id= t2.getText();
                     
            String q1 = "delete from movies where Mov_id="+Mov_id;
            try{
                conn c= new conn();
                c.s.executeUpdate(q1);
                JOptionPane.showMessageDialog(null,"Movie deleted Successfully!");
                //new Main().setVisible(true);
                //this.setVisible(false);
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                t6.setText("");
                
            }   catch(Exception e){}
        }
    	else if(ae.getSource()==b3){
            String Mov_id= t2.getText();
            String Mov_Title =t3.getText();
            String Mov_Year = t4.getText();
            String Mov_Lang = t5.getText();
            String Dir_id = t6.getText();
         
            String q1 = "update movies set Mov_Year='"+Mov_Year+"'where Mov_id="+Mov_id;
            try{
                conn c= new conn();
                c.s.executeUpdate(q1);
                JOptionPane.showMessageDialog(null,"New movie updated Successfully!");
                //new Main().setVisible(true);
                //this.setVisible(false);
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                t6.setText("");
                
            }   catch(Exception e){}
        }
    	else if(ae.getSource()==b4){
            String Mov_id= t2.getText();
            String Mov_Title =t3.getText();
            
         
            String q1 = "update movies set Mov_Title='"+Mov_Title+"'where Mov_id="+Mov_id;
            try{
                conn c= new conn();
                c.s.executeUpdate(q1);
                JOptionPane.showMessageDialog(null,"New movie updated Successfully!");
                //new Main().setVisible(true);
                //this.setVisible(false);
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                t6.setText("");
                
            }   catch(Exception e){}
        }
    	else if(ae.getSource()==b5){
            String Mov_id= t2.getText();          
            String Mov_Lang = t5.getText();
         
            String q1 = "update movies set Mov_Lang='"+Mov_Lang+"'where Mov_id="+Mov_id;
            try{
                conn c= new conn();
                c.s.executeUpdate(q1);
                JOptionPane.showMessageDialog(null,"New movie updated Successfully!");
                //new Main().setVisible(true);
                //this.setVisible(false);
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                t6.setText("");
                
            }   catch(Exception e){}
        }
    	else if(ae.getSource()==b6){
            String Mov_id= t2.getText();
            String Dir_id = t6.getText();
         
            String q1 = "update movies set Dir_id='"+Dir_id+"'where Mov_id="+Mov_id;
            try{
                conn c= new conn();
                c.s.executeUpdate(q1);
                JOptionPane.showMessageDialog(null,"New movie updated Successfully!");
                //new Main().setVisible(true);
                //this.setVisible(false);
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                t6.setText("");
                
            }   catch(Exception e){}
        }
    	else if(ae.getSource()==b11){
        	
            try{
                conn c =new conn();
                
                String str ="Select * from movies";
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
		new AddMovies().setVisible(true);
	}
}