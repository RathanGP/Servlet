package com.jsp.jdbc.steps.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



public class App 
{
    public static void main( String[] args ) throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","root");
        
       Statement st= connection.createStatement();
       boolean execute = st.execute("insert into student values(108,'Max')");
       System.out.println(execute);
       
       if(execute==false)
       {
    	   System.out.println("Data inserted...!");
       }
       else
    	   System.out.println("Data  not inserted...!");
       
       connection.close();
    
    }
    
}
