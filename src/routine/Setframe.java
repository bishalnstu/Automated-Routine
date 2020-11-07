package routine;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.*;
import javax.swing.UIManager.*;

import com.mysql.fabric.Server;
import com.mysql.fabric.xmlrpc.base.Value;
import com.mysql.jdbc.Driver;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.awt.Toolkit;

public class Setframe extends JFrame{
     
     
	 Vector<String> T_Name=new Vector<String>(10,2);
	 Vector<String> day=new Vector<String>(10,2);
	 Vector<String> course=new Vector<String>(10,2);
	 Vector<String> t_slot=new Vector<String>(10,2);
	 Vector<String> batchlist=new Vector<String>(10,2);
	 Vector<String> cls=new Vector<String>(10,2);
	 
	private Insert in; 
	private windowpanel frmpanel;
	public static Connection connection;
	public static Statement command;
	public static ResultSet data;
	private static String sql1,sql2,sql3,sql4,sql5,sql6;
	
	public Setframe()
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Program Files (x86)\\ClassRoutine\\images\\background.png"));
		
		in=new Insert();
		try {
			Class.forName("org.h2.Driver");
			
			try {
				
				connection=DriverManager.getConnection("jdbc:h2:~/mydb\\storedata;MV_STORE=FALSE and ;MVCC=FALSE", "sa","");
				sql1= "CREATE TABLE IF NOT EXISTS storename(ID INT auto_increment, name VARCHAR(25))";
				command=connection.createStatement();
				command.execute(sql1);
				sql2= "CREATE TABLE IF NOT EXISTS storebatch(ID INT auto_increment, batch VARCHAR(25))";
				command=connection.createStatement();
				command.execute(sql2);
				sql3= "CREATE TABLE IF NOT EXISTS storeroom(ID INT auto_increment, room VARCHAR(25))";
				command=connection.createStatement();
				command.execute(sql3);
				sql4= "CREATE TABLE IF NOT EXISTS storeday(ID INT auto_increment, day VARCHAR(25))";
				command=connection.createStatement();
				command.execute(sql4);
				sql5= "CREATE TABLE IF NOT EXISTS storetime(ID INT auto_increment, time VARCHAR(25))";
				command=connection.createStatement();
				command.execute(sql5);
				sql6= "CREATE TABLE IF NOT EXISTS storecourse(ID INT auto_increment, course VARCHAR(25))";
				command=connection.createStatement();
				command.execute(sql6);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
			}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	
		frmpanel = new windowpanel();
		
		setfrm();
		
	}
	
	private void setfrm()
	{
		this.setVisible(true);
		this.setSize(512,285);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(frmpanel);
		getContentPane().setLayout(null);
		
		JLabel backlabel = new JLabel("New label");
		backlabel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
			}
		});
		backlabel.setIcon(new ImageIcon("C:\\Program Files (x86)\\ClassRoutine\\images\\background.jpg"));
		backlabel.setBounds(0, 0, 506, 257);
		frmpanel.add(backlabel);
		
		JPopupMenu popupMenu = new JPopupMenu();
	    
		JMenu item1,item2,item3,item4,item5,item;
		JMenuItem item6,item7,item8,item9,item10,item11,item12,item13,item14,item15,item16,item17;
		
		item1 = new JMenu("Course");
		item2 = new JMenu("Room");
		item3 = new JMenu("Time");
		item4 = new JMenu("Day");
		item5 = new JMenu("Teacher");
		item = new JMenu("Batch");
		
		
		item6 = new JMenuItem("ADD");
	    item7 = new JMenuItem("Remove");
	    item8 = new JMenuItem("ADD");
	    item9 = new JMenuItem("Remove");
	    item10 = new JMenuItem("ADD");
	    item11 = new JMenuItem("Remove");
	    item12 = new JMenuItem("ADD");
	    item13 = new JMenuItem("Remove");
	    item14 = new JMenuItem("ADD");
	    item15 = new JMenuItem("Remove");
	    item16 = new JMenuItem("ADD");
	    item17 = new JMenuItem("Remove");
	    
	    
	    popupMenu.add(item);
		popupMenu.add(item1);
		popupMenu.add(item2);
		popupMenu.add(item3);
		popupMenu.add(item4);
		popupMenu.add(item5);
		
		item1.add(item6);
		item1.add(item7);
		item2.add(item8);
		item2.add(item9);
		item3.add(item10);
		item3.add(item11);
		item4.add(item12);
		item4.add(item13);
		item5.add(item14);
		item5.add(item15);
		item.add(item16);
		item.add(item17);
		
		addPopup(backlabel,popupMenu);
		
		this.setResizable(false);
	    
	    
	    
	    item6.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent ae) {
	    		
	    		String input;
	    		input=JOptionPane.showInputDialog("enter course to Add");
	    		adddata1(input);
	    		
	    	}
	    });
	    item7.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent ae) {
	    		
	    		String input;
	    		input=JOptionPane.showInputDialog("enter Course to Remove");
	    		
	    		deldata1(input);
	    	}
	    });
	   
	    item14.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent ae) {
	    		
	    		String input;
	    		input=JOptionPane.showInputDialog("enter Teacher to Add");
	    		
	    		adddata5(input);
	    	}
	    });
	    item15.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent ae) {
	    		
	    		String input;
	    		input=JOptionPane.showInputDialog("enter Teacher to Remove");
	    		
	    		deldata5(input);
	    	}
	    });
	    item16.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent ae) {
	    		
	    		String input;
	    		input=JOptionPane.showInputDialog("enter Batch to Add");
	    		
	    		adddata6(input);
	    	}
	    });
	    item17.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent ae) {
	    		
	    		String input;
	    		input=JOptionPane.showInputDialog("enter Batch to Remove");
	    		deldata6(input);
	    		
	    	}
	    });
	    
		
	}
	 

	  public void adddata1(String val)
	  {
		 
		
		  String sql = " insert into storecourse (course) values('"+val+"')";
		 
		  try {
			Class.forName("org.h2.Driver");

			  try {
				  connection=DriverManager.getConnection("jdbc:h2:~/mydb\\storedata;MV_STORE=FALSE and ;MVCC=FALSE", "sa","");
				command= connection.createStatement();
				command.execute(sql);
			   
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		  
		  course.clear();
		  in.loadcourse(course);
		  
		  frmpanel.course_list.removeAllItems();
		  
		  for(int i=0; i<course.size();i++)
			 frmpanel.course_list.addItem(course.get(i));
		    frmpanel.course_list.setSelectedIndex(-1);
		     
	  }
	  public void deldata1(String val)
	  {
		 
		 String sql= "delete from storecourse where course='"+val+"' ";
		 
		 try {
			Class.forName("org.h2.Driver");
			  try {
					 connection=DriverManager.getConnection("jdbc:h2:~/mydb\\storedata;MV_STORE=FALSE and ;MVCC=FALSE", "sa","");
					command= connection.createStatement();
					command.execute(sql);
				   
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 

		  course.clear();
		  in.loadcourse(course);
		
		    frmpanel.course_list.removeAllItems();
		    
		  for(int i=0; i<course.size();i++)
		  {
			  frmpanel.course_list.addItem(course.get(i));
		  }
			 // System.out.println(course.get(i));
			
		    frmpanel.course_list.setSelectedIndex(-1);
		  
	  }
	 
	 
	  
	 
	  
	  public void adddata5(String val)
	  {
		 
		  String sql = "insert into storename " + "(name)" + " values ('"+val+"')" ;
		  
		  try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		  
		  try {
			  connection=DriverManager.getConnection("jdbc:h2:~/mydb\\storedata;MV_STORE=FALSE and ;MVCC=FALSE", "sa","");
			command= connection.createStatement();
			command.execute(sql);
		   
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  T_Name.clear();
		  in.loadname(T_Name);
		  
		  frmpanel.Tname_list.removeAllItems();
		  
		  for(int i=0; i<T_Name.size();i++)
				frmpanel.Tname_list.addItem(T_Name.get(i));
			 frmpanel.Tname_list.setSelectedIndex(-1);
	  }
	  public void deldata5(String val)
	  {
		 
		  String sql= "delete from storename where name='"+val+"' ";
		  
		  try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		  
		  try {
			 connection=DriverManager.getConnection("jdbc:h2:~/mydb\\storedata;MV_STORE=FALSE and ;MVCC=FALSE", "sa","");
			command= connection.createStatement();
			command.execute(sql);
		   
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  T_Name.clear();
		  in.loadname(T_Name);
		  
		  frmpanel.Tname_list.removeAllItems();
		  
		  for(int i=0; i<T_Name.size();i++)
				frmpanel.Tname_list.addItem(T_Name.get(i));
			 frmpanel.Tname_list.setSelectedIndex(-1);
	  }
	  public void adddata6(String val)
	  {
		 
		  String sql = "insert into storebatch " + "(batch)" + " values ('"+val+"')" ;
		  
		  try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		  
		  try {
			 connection=DriverManager.getConnection("jdbc:h2:~/mydb\\storedata;MV_STORE=FALSE and ;MVCC=FALSE", "sa","");
			command= connection.createStatement();
			command.execute(sql);
		   
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  batchlist.clear();
		  in.loadbatch(batchlist);
		  
		  frmpanel.batch.removeAllItems();
		  
		  for(int i=0; i<batchlist.size();i++)
			     frmpanel.batch.addItem(batchlist.get(i));
			 frmpanel.batch.setFont(new Font("Tahoma", Font.PLAIN, 12));
			frmpanel. batch.setSelectedIndex(-1);
	  }
	  public void deldata6(String val)
	  {
		 
		  String sql= "delete from storebatch where batch='"+val+"' ";
		  
		  try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		  
		  try {
			 connection=DriverManager.getConnection("jdbc:h2:~/mydb\\storedata;MV_STORE=FALSE and ;MVCC=FALSE", "sa","");
			command= connection.createStatement();
			command.execute(sql);
		   
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  batchlist.clear();
		  in.loadbatch(batchlist);
		  
		  frmpanel.batch.removeAllItems();
		  
		  for(int i=0; i<batchlist.size();i++)
			     frmpanel.batch.addItem(batchlist.get(i));
			 frmpanel.batch.setFont(new Font("Tahoma", Font.PLAIN, 12));
			frmpanel. batch.setSelectedIndex(-1);
	  }
	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
