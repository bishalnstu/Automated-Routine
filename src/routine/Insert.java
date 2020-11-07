package routine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class Insert {

	private String sql;
	private static String username = "root";
	private static String passward = "";
	
	private static Connection connection;
	private static Statement command;
	private static ResultSet data;
	 
	 public void loadname(Vector<String> T_Name)
		{
		 
			sql="select name from storename";
			
			try {
				Class.forName("org.h2.Driver");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
				connection= DriverManager.getConnection("jdbc:h2:~/mydb\\storedata;MV_STORE=FALSE and ;MVCC=FALSE", "sa","");
				command= connection.createStatement();
				data=command.executeQuery(sql);
				
				if(data.first())
				{
					T_Name.add(data.getString("name"));
					while(data.next())
					{
						T_Name.add(data.getString("name"));
					}

				}
				
				connection.close();
				data.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		public void loadcourse(Vector<String> course)
		{
			sql="select course from storecourse";
			try {
				Class.forName("org.h2.Driver");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				connection= DriverManager.getConnection("jdbc:h2:~/mydb\\storedata;MV_STORE=FALSE and ;MVCC=FALSE", "sa","");
				command= connection.createStatement();
				data=command.executeQuery(sql);
				
				if(data.first())
				{
					course.add(data.getString("course"));
					while(data.next())
					{
						course.add(data.getString("course"));
					}

				}
				
				connection.close();
				data.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		public void loadtime(Vector<String> t_slot)
		{
			sql="select time from storetime";
			try {
				Class.forName("org.h2.Driver");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				connection= DriverManager.getConnection("jdbc:h2:~/mydb\\storedata;MV_STORE=FALSE and ;MVCC=FALSE", "sa","");
				command= connection.createStatement();
				data=command.executeQuery(sql);
				
				if(data.first())
				{
					t_slot.add(data.getString("time"));
					while(data.next())
					{
						t_slot.add(data.getString("time"));
					}

				}
				
				connection.close();
				data.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		public void loadday(Vector<String> day)
		{
			sql="select day from storeday";
			try {
				Class.forName("org.h2.Driver");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				connection= DriverManager.getConnection("jdbc:h2:~/mydb\\storedata;MV_STORE=FALSE and ;MVCC=FALSE", "sa","");
				command= connection.createStatement();
				data=command.executeQuery(sql);
				
				if(data.first())
				{
					day.add(data.getString("day"));
					while(data.next())
					{
						day.add(data.getString("day"));
					}

				}
				
				connection.close();
				data.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		public void loadroom(Vector<String> cls)
		{
			sql="select room from storeroom";
			try {
				Class.forName("org.h2.Driver");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				connection= DriverManager.getConnection("jdbc:h2:~/mydb\\storedata;MV_STORE=FALSE and ;MVCC=FALSE", "sa","");
				command= connection.createStatement();
				data=command.executeQuery(sql);
				
				if(data.first())
				{
					cls.add(data.getString("room"));
					while(data.next())
					{
						cls.add(data.getString("room"));
					}

				}
				
				connection.close();
				data.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		public void loadbatch(Vector<String> batchlist)
		{
			sql="select batch from storebatch";
			try {
				Class.forName("org.h2.Driver");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				connection= DriverManager.getConnection("jdbc:h2:~/mydb\\storedata;MV_STORE=FALSE and ;MVCC=FALSE", "sa","");
				command= connection.createStatement();
				data=command.executeQuery(sql);
				
				if(data.first())
				{
					batchlist.add(data.getString("batch"));
					while(data.next())
					{
						batchlist.add(data.getString("batch"));
					}

				}
				
				connection.close();
				data.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	
}
