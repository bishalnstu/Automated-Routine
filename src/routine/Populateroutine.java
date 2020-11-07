package routine;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import net.miginfocom.swing.MigLayout;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager.*;
import java.awt.Toolkit;
public class Populateroutine extends JFrame{
	
	
	private String day[]= {"Sun","Mon","Tue","Wed","Thu"};
	private String t_slot []={"9.00","10.00","11.00","12.00","2.00","3.00","4.00"};
	 
	public static String sql,param=new String();
	public static Connection connection;
	public static Statement command;
	public static ResultSet data;
    String[] cols = {"YR/TM", "9.00-9.50 ","10.00-10.50 ","11.00-11.50 ","12.00-12.50 ","2.00-2.50 ","3.00-3.50 ","4.00-4.50 "};
   
    DefaultTableModel model = new DefaultTableModel(cols, 30);
    JTable table = new JTable(model);
    
    String newLine = System.getProperty("line.separator");
    
    public Populateroutine() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Program Files (x86)\\ClassRoutine\\images\\icon.jpg"));
    	
    	try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	try {
    		sql= "CREATE TABLE IF NOT EXISTS routine(ID INT auto_increment, name VARCHAR(25),courseid VARCHAR(25),time VARCHAR(25),day VARCHAR(25),roomno VARCHAR(25),batch VARCHAR(25))";
			connection=DriverManager.getConnection("jdbc:h2:~/mydb\\classroutine;MV_STORE=FALSE and ;MVCC=FALSE", "sa","");
			command=connection.createStatement();
			command.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    	table.getColumnModel().getColumn(0).setPreferredWidth(80);
    	table.getColumnModel().getColumn(1).setPreferredWidth(160);
    	table.getColumnModel().getColumn(2).setPreferredWidth(160);
    	table.getColumnModel().getColumn(3).setPreferredWidth(160);
    	table.getColumnModel().getColumn(4).setPreferredWidth(160);
    	table.getColumnModel().getColumn(5).setPreferredWidth(160);
    	table.getColumnModel().getColumn(6).setPreferredWidth(160);
    	table.getColumnModel().getColumn(7).setPreferredWidth(160);
    	this.setVisible(true);
    	setResizable(false);
    	setTitle("CLASS ROUTINE ICE Dept.");
    	getContentPane().setBackground(new Color(0, 0, 128));
    	SpringLayout springLayout = new SpringLayout();
    	getContentPane().setLayout(springLayout);
    	table.setRowSelectionAllowed(false);
    	table.setBackground(SystemColor.activeCaption);
    	
    	JScrollPane scrollPane = new JScrollPane(table);
    	springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, 503, SpringLayout.NORTH, getContentPane());
    	springLayout.putConstraint(SpringLayout.EAST, scrollPane, 0, SpringLayout.EAST, getContentPane());
    	 scrollPane.setViewportView(table);
         getContentPane().add(scrollPane);
         
         JLabel lblNewLabel = new JLabel("SUN");
         springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, getContentPane());
         springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, -793, SpringLayout.EAST, getContentPane());
         springLayout.putConstraint(SpringLayout.WEST, scrollPane, 6, SpringLayout.EAST, lblNewLabel);
         springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, 106, SpringLayout.NORTH, getContentPane());
         lblNewLabel.setForeground(new Color(0, 128, 0));
         lblNewLabel.setBackground(new Color(0, 100, 0));
         lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
         getContentPane().add(lblNewLabel);
         
         JLabel lblNewLabel_1 = new JLabel("MON");
         springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 53, SpringLayout.SOUTH, lblNewLabel);
         springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, lblNewLabel);
         lblNewLabel_1.setForeground(new Color(34, 139, 34));
         lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
         getContentPane().add(lblNewLabel_1);
         
         JLabel lblNewLabel_2 = new JLabel("TUE");
         springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 64, SpringLayout.SOUTH, lblNewLabel_1);
         springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_2, 0, SpringLayout.WEST, lblNewLabel);
         lblNewLabel_2.setForeground(new Color(0, 128, 0));
         lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
         getContentPane().add(lblNewLabel_2);
         
         JLabel lblThu = new JLabel("WED");
         springLayout.putConstraint(SpringLayout.NORTH, lblThu, 79, SpringLayout.SOUTH, lblNewLabel_2);
         springLayout.putConstraint(SpringLayout.EAST, lblThu, 0, SpringLayout.EAST, lblNewLabel_1);
         lblThu.setForeground(new Color(0, 128, 0));
         lblThu.setFont(new Font("Tahoma", Font.BOLD, 16));
         getContentPane().add(lblThu);
         
         JLabel lblNewLabel_3 = new JLabel("THU");
         springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_3, -52, SpringLayout.SOUTH, getContentPane());
         springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_3, 0, SpringLayout.EAST, lblNewLabel_1);
         lblNewLabel_3.setForeground(new Color(0, 128, 0));
         lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
         getContentPane().add(lblNewLabel_3);
         
         JButton btnNewButton = new JButton("refresh");
         springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 42, SpringLayout.SOUTH, btnNewButton);
         
    	springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 0, SpringLayout.NORTH, btnNewButton);
         btnNewButton.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent arg0) {
         		setvalue();
         	}
         });
         getContentPane().add(btnNewButton);
         
    
          this.setSize(865, 531);
          this.setLocationRelativeTo(null);
        
    }
    
    
    void setvalue()
    {
    	String room,name;
          String arra[]={"Y1T1","Y2T2","Y3T1"};
    	
    	for(int i=0;i<day.length;i++)
    	{
    		boolean flag1=false,flag2=false;
    		param=day[i];
    		sql=" select name,roomno,courseid,time,batch from routine where day= '"+param+"' ";
    		
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
    				
    				for(int j=0;j<t_slot.length;j++)
					{
    					
						if(data.getString("time").equals(t_slot[j]))
    					{
							
							room=data.getString("roomno");
							name=data.getString("name");
							String temp=data.getString("courseid") +" "+ room + name;
							String bach=data.getString("batch");
							
							if(room.equals("C-1"))
							{
								model.setValueAt(temp,i*2, j+1);
								
								if (!flag1) {
									model.setValueAt(bach, i*2, 0);
									flag1=true;
								}
							}
								
    						
							else {
								model.setValueAt(temp,i*2+1, j+1);
								if (!flag2) {
									model.setValueAt(bach, i*2+1, 0);
									flag2=true;
								}
							}   						
    						break;
    					}
						
					}
    				
    				while(data.next())
    				{
    					
    					for(int j=0;j<t_slot.length;j++)
    					{
    						if(data.getString("time").equals(t_slot[j]))
        					{
    							room=data.getString("roomno");
    							name=data.getString("name");
    							String temp=data.getString("courseid")+" "+ room + name;
    							String bach=data.getString("batch");
    							if(room.equals("C-1"))
    							{
    								if(!flag1)
    								{
    									model.setValueAt(bach, i*2, 0);
    									flag1=true;
    								}
    								model.setValueAt(temp,i*2, j+1);
    							}
    								
    							else 
    							 {
    								if (!flag2) 
    								{
    									model.setValueAt(bach, i*2+1, 0);
    									flag2=true;
    								}
    							    model.setValueAt(temp,i*2+1, j+1);
    							 }   
        						
        						break;
        					}
    					}
    					
    				}
    				data.close();
    				connection.close();
    				
    			}
    			
    		} catch (SQLException e) {
    			
    			e.printStackTrace();
    		}
    		
    	}
		
	
    }
}
			