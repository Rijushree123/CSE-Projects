package hotel_management_system;

import java.sql.*;  

public class conn{
    Connection c;
    Statement s;
    public conn(){  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            c =DriverManager.getConnection("jdbc:mysql:///projecthotelmm","root",""); 
            
            s =c.createStatement();  
            
           
        }catch(Exception e){ 
           e.printStackTrace();
        }  
    }
}