package routine;

import javax.swing.*;
import javax.swing.UIManager.*;
import javax.swing.JFrame;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

public class Login extends JFrame{
	
	private Loginpanel panel ;
	
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Program Files (x86)\\ClassRoutine\\images\\icon.jpg"));
		
		panel = new Loginpanel();
		
		setfrm();
		
	}
	
	private void setfrm()
	{
		this.setVisible(true);
		this.setSize(488,300);
		this.setTitle("Login Form");
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(panel);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Program Files (x86)\\ClassRoutine\\images\\1.jpg"));
		lblNewLabel.setBounds(0, 0, 483, 272);
		panel.add(lblNewLabel);
		
		
		this.setResizable(false);
	}
	 
	public static void main(String[] args) {
		
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available, you can set the GUI to another look and feel.
		}
		    
           Login ob = new Login();   
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