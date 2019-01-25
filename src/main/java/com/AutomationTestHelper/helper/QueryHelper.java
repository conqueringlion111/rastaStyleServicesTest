package com.AutomationTestHelper.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryHelper {

	public String runQuery(String dbURL, String username, String password, String ColumnName) throws ClassNotFoundException, SQLException, InterruptedException {
		
		String uName = null;		
		/*
		 * the query we want to run
		 */
		String query = "SELECT " + ColumnName+ " FROM LibertyQA.dbo.tblAgreement WHERE CaseNumber = 'CaseNumber123';";
				
		//local sql server JDBC driver
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDrive");
		
		//connect to DB - we will used the passed in dbURL, username and password to connect to the DB
		 
		Connection con = DriverManager.getConnection(dbURL, username, password);
		System.out.println("Connection Successfull");
		
		//Create statement object
		Statement stmt = con.createStatement();		
		Thread.sleep(2500);
		
		// Send SQL query to DB
		ResultSet rs = stmt.executeQuery(query);
		
		// While loop to get ResultSet all rows of data
		while(rs.next()) {
//			System.out.println("RequestedOn: " + rs.getString("RequestedOn"));
//			System.out.println("ScheduledTestNotes: " + rs.getString("ScheduledTestNotes"));
//			System.out.println("SiteID: " + rs.getString("SiteID"));
//			System.out.println("RequestedBy: " + rs.getString("RequestedBy"));
//			System.out.println("NextStartDate: " + rs.getString("NextStartDate"));
//			System.out.println("NextEndDate: " + rs.getString("NextEndDate"));
			
		    uName = rs.getString(1);
		    		    
			System.out.println(uName);
		}
		
		// Close DB connection
		con.close();
		
		return uName;
		
	}
}
