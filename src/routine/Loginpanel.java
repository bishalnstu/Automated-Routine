package routine;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Loginpanel extends JPanel {
	public String us,pass;
	private Boolean ret;
			
	JButton btnSubmit = new JButton("Submit");
	private JTextField textField;
	private JPasswordField passwordField;
	public Loginpanel() {
		
		this.setLayout(null);
		JLabel lblLogin = new JLabel("Login :");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblLogin.setBounds(219, 54, 92, 35);
		add(lblLogin);
		
		JLabel lblNewLabel = new JLabel("Username :");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(107, 138, 78, 21);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(210, 137, 101, 23);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password :");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(107, 179, 78, 21);
		add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(210, 178, 101, 23);
		add(passwordField);
		
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 us= textField.getText();
			     pass= passwordField.getText();
			     textField.setText(null);
				passwordField.setText(null);
				 ret=checklogin(us, pass);
				 
					 JFrame f1 = (JFrame) SwingUtilities.getWindowAncestor(btnSubmit);
					
					 if(ret)
					 {
						 f1.dispose();
					 }
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSubmit.setBounds(210, 224, 101, 35);
		add(btnSubmit);
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
	
	private Boolean checklogin(String us,String pass)
	{
      
		Boolean flag;
		
		if(us.equals("1") && pass.equals("1"))
		{
			 Setframe obj = new Setframe();
			
			flag=true;
		}
		else
		{
			flag=false;
			JOptionPane.showMessageDialog(null, "Access Denied");
		}
		
		return flag;
	}
}
