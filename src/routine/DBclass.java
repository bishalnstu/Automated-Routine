package routine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class DBclass {

	//public boolean flag=true,checked=false;
	private String day[]= {"Sun","Mon","Tue","Wed","Thu"};
	private String t_slot []={"9.00","10.00","11.00","12.00","2.00","3.00","4.00"};
	public static String sql=new String();
	private String time,day1;
	private static String username = "root";
	private static String passward = "";
	private static Connection connection;
	private static Statement command;
	private static ResultSet data;
	public String msg,no,msg1;
	
	public String checkexsists(String param)
	{
		
		
		sql="select name from routine where courseid = '"+param+"' ";
		
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			connection=DriverManager.getConnection("jdbc:h2:~/mydb\\classroutine;MV_STORE=FALSE and ;MVCC=FALSE", "sa","");
			command=connection.createStatement();
			data=command.executeQuery(sql);
			
			if(data.first())
			{
				msg=data.getString("name");
				
			}
			else
			{
				msg="Null";
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return msg;
		
	}
	
	public boolean insert(String NAME, String CID , String Time ,String Day, String RNO, String BACH)
	{
		sql= "insert into routine" + "(name,courseid,time,day,roomno,batch)" +" values ( '"+NAME+"' ,'"+CID+"','"+Time+"','"+Day+"','"+RNO+"','"+BACH+"')";
		
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			connection=DriverManager.getConnection("jdbc:h2:~/mydb\\classroutine;MV_STORE=FALSE and ;MVCC=FALSE", "sa","");
			command=connection.createStatement();
			command.execute(sql);
			
			return true;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
			return false;
		}
	}
	
	
	public Boolean checktiming(String name,String courseid,String batch)
	{
		
		 boolean flag1,flag2,flag=false;
		 
		 for(int i=0;i<day.length;i++)
		 {
			 for(int j=0;j<t_slot.length;j++)
			 {
				 flag1=false;flag2=false;
				 time=t_slot[j];
				 day1=day[i];
				 
				 
				 sql="select roomno from routine where time = '"+time+"' AND day='"+day1+"'" ;
				 
				 
				 try {
						Class.forName("org.h2.Driver");
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						connection=DriverManager.getConnection("jdbc:h2:~/mydb\\classroutine;MV_STORE=FALSE and ;MVCC=FALSE", "sa","");
						command=connection.createStatement();
						data=command.executeQuery(sql);
						
					   if(data.first())
					   {
						   
						   if((data.getString("roomno").equals("C-1")))
						   {
							   
							   flag1=true;
							   
							  
						   }
						   while(data.next())
						   {
							  
							   if((data.getString("roomno").equals("C-2")))
							   {
								  
								   flag2=true;
								   
							   }
						   }
						   
					   }
					   
					   
					} catch (SQLException e) {
						
						e.printStackTrace();
						
					}
					
					if(!flag1 && !flag2 && !flag)
					{
						insert(name, courseid, time, day1, "C-1", batch);
						flag=true;
					}
					else if(!flag1 && !flag)
					{
						
						if(!overlapping(time, day1, name, courseid))
						{
							insert(name, courseid, time, day1, "C-1", batch);
							flag=true;
						}
						
					}
					else if(!flag2 && !flag)
					{
						if(!overlapping(time, day1, name, courseid))
						{
							insert(name, courseid, time, day1, "C-2", batch);
							flag=true;
						}
					}
					
					
					if(flag)
					{
						break;
					}
			 }
			 
			 if(flag)
				 break;
			 
		 }
		
		
		if(!flag)
		{
			msg1="No Time Slot is empty";
			JOptionPane.showMessageDialog(null, msg1);
		}
		
		return flag;
	}
	
	Boolean overlapping(String time ,String day1,String name,String courseid)
	{
		Boolean mark=false;
		sql="select name from routine where time = '"+time+"' AND day='"+day1+"'" ;
		 
		 
		 try {
				Class.forName("org.h2.Driver");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		 
		try {
			connection=DriverManager.getConnection("jdbc:h2:~/mydb\\classroutine;MV_STORE=FALSE and ;MVCC=FALSE", "sa","");
			command=connection.createStatement();
			data=command.executeQuery(sql);
			

			   if(data.first())
			   {
				   
				   if((data.getString("name").equals(name)))
				   {
					   
					   mark=true;
					   
					  
				   }
				   while(data.next())
				   {
					  
					   if((data.getString("name").equals(name)))
					   {
						  
						   mark=true;
						   
					   }
				   }
				   
			   }
			   
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return mark;
	}
	
	public boolean deleterecord()
	{
		
		sql="DELETE from routine";
		
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			connection=DriverManager.getConnection("jdbc:h2:~/mydb\\classroutine;MV_STORE=FALSE and ;MVCC=FALSE", "sa","");
			command=connection.createStatement();
			command.execute(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
}
