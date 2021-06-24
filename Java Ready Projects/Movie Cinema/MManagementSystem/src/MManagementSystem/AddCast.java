package MManagementSystem;

import javax.swing.*;

import net.proteanit.sql.DbUtils;

import java.awt.*;
//import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class AddCast extends JFrame implements ActionListener{
	
	JButton b1,b2;
	JButton b11,b22;
	JTable t1;
	JTextField t2,t3,t4,t5;
	JRadioButton r1,r2;
	JMenuBar mb;
	JMenu m1;
	
	AddCast(){
		
		mb = new JMenuBar();
        add(mb);
        mb.setBounds(580,88,380,30);
        
        m1 =new JMenu("Actor Id                    Movie Id               Movie Role");
        m1.setForeground(Color.blue);
        m1.setBounds(580,100,380,30);
        mb.add(m1);
		
		JLabel l1 = new JLabel("Movie Cast");
		l1.setBounds(450,50,500,30);
		l1.setFont(new Font("Tahoma",Font.PLAIN,35));
		add(l1);
		
		JLabel l2 =new JLabel("Actor Id");
	       l2.setBounds(40,92,300,30);
	       l2.setFont(new Font("Tahoma",Font.PLAIN,14));
	       add(l2);
	       
	       t2= new JTextField();
	       t2.setBounds(200,97,150,20);
	        add(t2);
	       
	    JLabel l3 =new JLabel("Movie Id");
	       l3.setBounds(40,140,300,30);
	       l3.setFont(new Font("Tahoma",Font.PLAIN,14));
	       add(l3);
	       
	       t3= new JTextField();
	       t3.setBounds(200,145,150,20);
	        add(t3);      
	       
	    JLabel l4 =new JLabel("Movie Role");
		   l4.setBounds(40,188,300,30);
		   l4.setFont(new Font("Tahoma",Font.PLAIN,14));
		   add(l4);
		       
		   t4= new JTextField();
		   t4.setBounds(200,193,150,20);
		  add(t4);
		
		t1= new JTable();
        t1.setBounds(580,118,380,420);
        t1.setBackground(Color.yellow);
        t1.setFont(new Font("Tahoma",Font.BOLD,14));
        add(t1);
        
        
        b1 = new JButton("ADD MOVIE CAST");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(198,250,150,30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("DELETE CAST");
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
    		System.out.println("Miu");
            String Act_id= t2.getText();
            String Mov_id  =t3.getText();
            String MRol = t4.getText();
            
         
            String q1 = "insert into movie_cast values("+Act_id+","+Mov_id+",'"+MRol+"')";
            try{
                conn c= new conn();
                c.s.executeUpdate(q1);
                JOptionPane.showMessageDialog(null,"New actor added Successfully!");
                //new Main().setVisible(true);
                //this.setVisible(false);
                t2.setText("");
                t3.setText("");
                t4.setText("");
            }   catch(Exception e){}
        }
    	else if(ae.getSource()==b2){
    		String Act_id= t2.getText();
            String Mov_id  =t3.getText();
            
         
            String q1 = "delete from movie_cast where Mov_id='"+Mov_id+"' and Act_id="+Act_id;
            try{
                conn c= new conn();
                c.s.executeUpdate(q1);
                JOptionPane.showMessageDialog(null,"Movie Cast deleted Successfully!");
                //new Main().setVisible(true);
                //this.setVisible(false);
                t2.setText("");
                t3.setText("");
                t4.setText("");
                
            }   catch(Exception e){}
        }
    	else if(ae.getSource()==b11){
        	
            try{
                conn c =new conn();
                
                String col[] = {"Actor id", "Actor Name", "Actor Gender"};
                String str ="Select * from movie_cast";
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
		new AddCast().setVisible(true);
	}
}