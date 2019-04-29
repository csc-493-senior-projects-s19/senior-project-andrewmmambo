// written by Marima Andrew Mambondiumwe for CSC 493, Spring 2019

package attendB;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

@SuppressWarnings("unused")
public class FacultyLogin extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static FacultyLogin frame;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new FacultyLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FacultyLogin() {
		setForeground(Color.BLACK);
		setTitle("BereaATTEND");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1320, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		//allows the faculty member to input their login details
		JLabel lblAdminLoginForm = new JLabel("Faculty Login");
		lblAdminLoginForm.setBounds(556, 306, 119, 22);
		lblAdminLoginForm.setForeground(Color.CYAN);
		lblAdminLoginForm.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblEnterName = new JLabel("Enter Name:");
		lblEnterName.setBounds(309, 383, 114, 22);
		lblEnterName.setForeground(Color.CYAN);
		lblEnterName.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblEnterPassword = new JLabel("Enter Password:");
		lblEnterPassword.setBounds(309, 493, 148, 22);
		lblEnterPassword.setForeground(Color.CYAN);
		lblEnterPassword.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		textField = new JTextField();
		textField.setBounds(522, 387, 204, 20);
		textField.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnLogin.setBounds(574, 559, 86, 37);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String name=textField.getText();
			String password=String.valueOf(passwordField.getPassword());
			if(name.equals("b001")&&password.equals("beloved")){ // checks whether the faculty member inputted the correct login details
				FacultySuccess.main(new String[]{});
				frame.dispose();
			}else{
				JOptionPane.showMessageDialog(FacultyLogin.this, "Username or Password Error","Login Error!", JOptionPane.ERROR_MESSAGE);
				textField.setText("");
				passwordField.setText("");
			}
			}
		});
		
		passwordField = new JPasswordField();
		passwordField.setBounds(522, 497, 204, 20);
		contentPane.setLayout(null);
		contentPane.add(lblAdminLoginForm);
		contentPane.add(lblEnterName);
		contentPane.add(lblEnterPassword);
		contentPane.add(passwordField);
		contentPane.add(textField);
		contentPane.add(btnLogin);
		
		JLabel lblBereaattendAClass = new JLabel("BereaATTEND- a class attendance management tool");
		lblBereaattendAClass.setForeground(Color.CYAN);
		lblBereaattendAClass.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblBereaattendAClass.setBounds(370, 12, 548, 34);
		contentPane.add(lblBereaattendAClass);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(FacultyLogin.class.getResource("/attendB/clocks.png"))); // sets the logo on the GUI
		label.setBackground(new Color(240, 240, 240));
		label.setBounds(503, 55, 224, 240);
		contentPane.add(label);
	}
}
