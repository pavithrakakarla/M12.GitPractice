package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteUpdate {

	public static void main(String[] args) throws SQLException {
		
		Driver driverRef=new Driver();
		
		//Step1: Register the driver/ Database
		DriverManager.deregisterDriver(driverRef);
		
		//Step2: Establish connection with Database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/m11db","root", "Vedyasri@1");
		
		//Step3:Issue create statement
		Statement state = con.createStatement();
		
		//step4:Execute a query
		int result = state.executeUpdate("insert into candidate_info values('spiderman',6,'NewYork');");
		
		//To verify data is added to table, 1 means in output we get "1 row affected, so caapturing from there."
		if(result == 1)
		{
			System.out.println("Data added");
		}
		
		//To verify data is added to table via select query
		ResultSet result1 = state.executeQuery("select * from candidate_info;");
		
		//To print all lines of data in a column
		while(result1.next())
		{
			System.out.println(result1.getString(1));
		}		
		//step5: close the database
		con.close();
	}
}
