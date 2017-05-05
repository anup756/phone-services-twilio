package com.corvisaAPI;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.Properties;
 
public class DBConnection {
 
    public static Connection getConnection() {
    	InputStream inputStream;
        Connection con = null;
    	try{
	        Properties props = new Properties();
	        String propfile = "db.properties";
	        inputStream = DBConnection.class.getClassLoader().getResourceAsStream(propfile);
	        if (inputStream != null){
	        	props.load(inputStream);
	        }else{
	        	throw new FileNotFoundException("Property File not found");
	        }
	        //Date time = new Date(System.currentTimeMillis());
	     // get the property value and print it out
	     	String db_class = props.getProperty("DB_DRIVER_CLASS");
	     	String db_URL = props.getProperty("DB_URL");
	     	String db_uname = props.getProperty("DB_USERNAME");
	     	String db_password = props.getProperty("DB_PASSWORD");
	     	
	     	Class.forName(db_class);
	     	con = DriverManager.getConnection(db_URL,db_uname,db_password);
	     	System.out.println("Connection Established");
    	}catch(IOException | ClassNotFoundException | SQLException e){
    		e.printStackTrace();
    	}
    	return con;
    }
}
