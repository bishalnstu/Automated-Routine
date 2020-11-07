package routine;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.sql.rowset.Predicate;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import org.omg.CORBA.PRIVATE_MEMBER;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.*;
import java.awt.event.*;
import javax.swing.SwingConstants;
public class windowpanel extends JPanel {
	
	
	public static String sql;
	
     public int count =0;
     private boolean flag,flag1 =false;
    
	 private String Time,Day,Name,Course,msg,ClassRoom,Batch =new String();
	 private JLabel Teacher_name,Course_ID;
	 
	 Vector<String> T_Name=new Vector<String>(10,2);
	 Vector<String> day=new Vector<String>(10,2);
	 Vector<String> course=new Vector<String>(10,2);
	 Vector<String> t_slot=new Vector<String>(10,2);
	 Vector<String> batchlist=new Vector<String>(10,2);
	 Vector<String> cls=new Vector<String>(10,2);
	 public JComboBox Tname_list = new JComboBox();
	 public JComboBox batch = new JComboBox<>();
	 public JComboBox course_list= new JComboBox<>();
	 private JButton submit,run,clear; 
	 private SpringLayout currentlayout;
	 private DBclass db;
	 private Insert ini;
	 private Map<String,String> mapthename = new HashMap<String,String>();
	 private Map<String, String>mapthetime = new HashMap<String,String>();
	
	 
	public windowpanel()
	{
		
		
		course_list.setMaximumRowCount(3);
		Tname_list.setMaximumRowCount(3);
		batch.setMaximumRowCount(3);
		db= new DBclass();
		ini= new Insert();
		
		ini.loadname(T_Name);  
		ini.loadbatch(batchlist);
		ini.loadcourse(course);
		ini.loadday(day);
		ini.loadroom(cls);
		ini.loadtime(t_slot);
		
		for(int i=0; i<T_Name.size();i++)
			Tname_list.addItem(T_Name.get(i));
		 Tname_list.setSelectedIndex(-1);
		
		 
		 for(int i=0; i<course.size();i++)
				course_list.addItem(course.get(i));
		     course_list.setSelectedIndex(-1);
		
				for(int i=0; i<batchlist.size();i++)
				     batch.addItem(batchlist.get(i));
				 batch.setFont(new Font("Tahoma", Font.PLAIN, 12));
				 batch.setSelectedIndex(-1);
			
			 
		submit= new JButton("SUBMIT");
		submit.setHorizontalAlignment(SwingConstants.RIGHT);
		run = new JButton("RUN");
		clear = new JButton("Clear");
		clear.setFont(new Font("Tahoma", Font.BOLD, 14));
	
		run.setFont(new Font("Tahoma", Font.BOLD, 14));
		submit.setFont(new Font("Tahoma", Font.BOLD, 14));
		Teacher_name = new JLabel("Teacher Name");
		Teacher_name.setFont(new Font("Dialog", Font.BOLD, 14));
		Course_ID= new JLabel(" Course ID");
		Course_ID.setFont(new Font("Dialog", Font.BOLD, 14));
		
		currentlayout = new SpringLayout();
		currentlayout.putConstraint(SpringLayout.NORTH, course_list, 0, SpringLayout.NORTH, clear);
		currentlayout.putConstraint(SpringLayout.NORTH, run, 0, SpringLayout.NORTH, batch);
		currentlayout.putConstraint(SpringLayout.WEST, run, 302, SpringLayout.WEST, this);
		currentlayout.putConstraint(SpringLayout.WEST, clear, 52, SpringLayout.EAST, course_list);
		currentlayout.putConstraint(SpringLayout.EAST, clear, -160, SpringLayout.EAST, this);
		currentlayout.putConstraint(SpringLayout.EAST, run, -160, SpringLayout.EAST, this);
		currentlayout.putConstraint(SpringLayout.EAST, batch, -52, SpringLayout.WEST, run);
		currentlayout.putConstraint(SpringLayout.NORTH, Tname_list, 0, SpringLayout.NORTH, submit);
		currentlayout.putConstraint(SpringLayout.EAST, submit, -160, SpringLayout.EAST, this);
		currentlayout.putConstraint(SpringLayout.NORTH, clear, -5, SpringLayout.NORTH, Course_ID);
		currentlayout.putConstraint(SpringLayout.NORTH, submit, 0, SpringLayout.NORTH, Teacher_name);
		currentlayout.putConstraint(SpringLayout.WEST, submit, 52, SpringLayout.EAST, Tname_list);
		currentlayout.putConstraint(SpringLayout.WEST, course_list, 16, SpringLayout.EAST, Course_ID);
		currentlayout.putConstraint(SpringLayout.EAST, course_list, -300, SpringLayout.EAST, this);
		currentlayout.putConstraint(SpringLayout.WEST, Tname_list, 16, SpringLayout.EAST, Teacher_name);
		currentlayout.putConstraint(SpringLayout.EAST, Tname_list, -300, SpringLayout.EAST, this);
		currentlayout.putConstraint(SpringLayout.NORTH, Course_ID, 68, SpringLayout.SOUTH, Teacher_name);
		currentlayout.putConstraint(SpringLayout.EAST, Course_ID, 0, SpringLayout.EAST, Teacher_name);
		currentlayout.putConstraint(SpringLayout.NORTH, Teacher_name, 57, SpringLayout.NORTH, this);
		currentlayout.putConstraint(SpringLayout.EAST, Teacher_name, -404, SpringLayout.EAST, this);
		
		setpanel();
		
		iniaction();
	}
	
	private void iniaction()
	{
		 
		   course_list.addActionListener(new ActionListener()
		   {
				
				@Override
				public void actionPerformed(ActionEvent ae) {
					// TODO Auto-generated method stub
				    Course= ""+ ((JComboBox)ae.getSource()).getSelectedItem();
				
				}
			} );
		 
		 Tname_list.addActionListener( new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent ae) {
					// TODO Auto-generated method stub
				    Name = "" + ((JComboBox)ae.getSource()).getSelectedItem();
				}
			});
		    
		 batch.addActionListener( new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent ae) {
					// TODO Auto-generated method stub
				   Batch =""+ ((JComboBox)ae.getSource()).getSelectedItem();
				    
				}
			});
		 
		 clear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(db.deleterecord())
				{
				
					msg="Clear Successfull";
					JOptionPane.showMessageDialog(null, msg);
				}
				else
				{
					msg="Clear UnSuccessfull";
					JOptionPane.showMessageDialog(null, msg);
				}
			}
		});
		 
		 run.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Populateroutine loadroutine = new Populateroutine();
				loadroutine.setvalue();
			
			}
		});
		 
		submit.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent ae) {
				// TODO Auto-generated method stub
				
		         msg= db.checkexsists(Course);
		         
				if(msg.equals("Null"))
				{
					
					flag=db.checktiming(Name, Course, Batch);
					
					if(flag)
					{
						msg="Successfull";
						JOptionPane.showMessageDialog(null, msg);
					}
					
				}
				else{
					
					JOptionPane.showMessageDialog(null,"Take By : "+msg);
				}
				
				Tname_list.setSelectedIndex(-1);
				  course_list.setSelectedIndex(-1);
				   batch.setSelectedIndex(-1);
				   Time="";
			}
		});
	}
	
	
	private void setpanel() {
		
	
		this.setLayout(currentlayout);
		this.setSize(550, 300);
		this.add(batch);
		this.add(Course_ID);
		this.add(Teacher_name);
		this.add(Tname_list);
		this.add(submit);
		this.add(run);
		this.add(clear);
		this.add(course_list);
		setBackground(SystemColor.inactiveCaptionBorder);
		
		JLabel lblBatch = new JLabel("Batch");
		currentlayout.putConstraint(SpringLayout.WEST, batch, 10, SpringLayout.EAST, lblBatch);
		currentlayout.putConstraint(SpringLayout.NORTH, lblBatch, 22, SpringLayout.SOUTH, Teacher_name);
		currentlayout.putConstraint(SpringLayout.NORTH, batch, -2, SpringLayout.NORTH, lblBatch);
		currentlayout.putConstraint(SpringLayout.WEST, lblBatch, 112, SpringLayout.WEST, this);
		lblBatch.setFont(new Font("Dialog", Font.BOLD, 14));
		add(lblBatch);
			
		
	}
	
	
	
}
