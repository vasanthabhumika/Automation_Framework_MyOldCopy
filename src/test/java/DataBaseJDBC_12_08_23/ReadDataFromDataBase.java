package DataBaseJDBC_12_08_23;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ReadDataFromDataBase {

	public static void main(String[] args) throws Throwable {
		Driver DriverRef = new Driver();
		
		DriverManager.registerDriver(DriverRef);
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Qspiders_info", "root", "root");
		Statement stat = connection.createStatement();
		String query = "Select * from Student_infom";
		ResultSet result = stat.executeQuery(query);
		
		while(result.next()) {
			System.out.println(result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4));
		}

		connection.close();
	}

}
