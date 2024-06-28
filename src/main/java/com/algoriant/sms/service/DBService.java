package com.algoriant.sms.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.util.Properties;
import java.io.InputStream;


public class DBService{
	
	private static DBService instance;
	private static final String PROPERTY_NAME = "config.properties";
	private static final String URL = "url";
	private static final String USERNAME = "username";
	private static final String PASSWORD = "password";
	private String url;
	private String username;
	private String password;
	
	private DBService() {
		init();
	}
	
	public static DBService getInstance(){
		if(instance==null){
			synchronized(DBService.class){
				if(instance==null){
					instance = new DBService();
				}
			}
		}
		return instance;
	}
	
	public Connection getConnection(){
		try{
			return DriverManager.getConnection(url,username,password);
		}catch(Exception ex){
			throw new RuntimeException("Failure while establish a connection to database using url: "+url,ex);
		}
	}
	
	public static void closeConnection(ResultSet rs, PreparedStatement pst, Connection con){
		try{
			if(rs != null)
				rs.close();
		}catch(Exception ex){}
		try{
			if(pst != null)
				pst.close();
		}catch(Exception ex){}
		try{
			if(con != null)
				con.close();
		}catch(Exception ex){}
	}

	private  void init(){
		try{
			InputStream is = this.getClass().getClassLoader().getResourceAsStream(PROPERTY_NAME);
			Properties property = new Properties();
			property.load(is);
			url = property.getProperty(URL);
			username = property.getProperty(USERNAME);
			password = property.getProperty(PASSWORD);
		}catch(Exception ex){
			throw new RuntimeException("Failure while load a properties file "+PROPERTY_NAME,ex);
		}
	}
}
