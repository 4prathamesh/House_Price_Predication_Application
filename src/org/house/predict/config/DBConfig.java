package org.house.predict.config;
import java.sql.*;
import java.util.*;
public class DBConfig {
	private static Connection conn;
	private static PreparedStatement stmt;
	private static ResultSet rs;
	private static Statement st;
	private static DBConfig db=null;
	private DBConfig()
	{
		try {
			// we lode properties file and take data from file
			
			Properties p= new Properties();
		
			// aapn ha path use kela karun jar aapn ha path 10 jage var
			// use kela tar prathek jagi jaun change kara lagen 
			// aani new class use karun kela tar yeka jagich change kara lagen
			p.load(PathHelper.fin);  
			String driverClassName=p.getProperty("driver.classname");
			String username=p.getProperty("db.username");
			String password=p.getProperty("db.password");
			String url=p.getProperty("db.url");
			
			Class.forName(driverClassName);
			conn=DriverManager.getConnection(url,username,password);
			if(conn!=null)
			{
				System.out.println("DataBase is Connected");
			}
			else
			{
				System.out.println("DataBase is not Connected");
			}
					
		}
		catch(Exception ex)
		{
			System.out.println("error is"+ex);
		}
	}
	
	public static DBConfig getDBInstance()
	{
		if(db==null)
		{
			db=new DBConfig();
		}
		return db;
	}
	public static Connection getConnection()
	{
		return conn;
	}
	public static PreparedStatement getStatement()
	{
		return stmt;
	}
	public static ResultSet getResultSet()
	{
		return rs;
	}
	
	public static Statement getStmt() {
		return st;
	}
}
