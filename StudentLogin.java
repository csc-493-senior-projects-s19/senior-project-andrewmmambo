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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;

@SuppressWarnings("unused")
public class StudentLogin extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static StudentLogin frame;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				//initiates the student login main window
				try {
					frame = new StudentLogin();
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
	public StudentLogin() {
		setTitle("BereaATTEND");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1320, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		// allows the student to input their login details
		JLabel lblFacultyLoginForm = new JLabel("Student Login");
		lblFacultyLoginForm.setBounds(567, 253, 125, 22);
		lblFacultyLoginForm.setForeground(Color.CYAN);
		lblFacultyLoginForm.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblEnterName = new JLabel("Enter Name:");
		lblEnterName.setForeground(Color.CYAN);
		lblEnterName.setBounds(386, 328, 114, 22);
		lblEnterName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		
		JLabel lblEnterPassword = new JLabel("Enter Password:");
		lblEnterPassword.setForeground(Color.CYAN);
		lblEnterPassword.setBounds(382, 416, 148, 22);
		lblEnterPassword.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		textField = new JTextField();
		textField.setBounds(540, 332, 180, 20);
		textField.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnLogin.setBounds(590, 468, 86, 37);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String name=textField.getText();
			String password=String.valueOf(passwordField.getPassword());
			//System.out.println(name+" "+password);
			
			if(StudentDao.validate(name, password)){ //tries to verify the login details by calling another class that interacts with the database
				StudentSuccess.main(new String[]{});
				frame.dispose();
			}else{
				JOptionPane.showMessageDialog(StudentLogin.this, "Sorry, Username or Password Error","Login Error!", JOptionPane.ERROR_MESSAGE);
				textField.setText("");
				passwordField.setText("");
			}
			}
		});
		
		passwordField = new JPasswordField();
		passwordField.setBounds(540, 420, 184, 20);
		
		JLabel lblBereaattendAClass = new JLabel("BereaATTEND- a class attendance management tool");// sets the title on the GUI
		lblBereaattendAClass.setForeground(Color.CYAN);
		lblBereaattendAClass.setBounds(330, 5, 621, 29);
		lblBereaattendAClass.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(515, 45, 224, 197);
		lblNewLabel.setIcon(new ImageIcon(StudentLogin.class.getResource("/attendB/clocks.png"))); // sets the logo on the GUI
		contentPane.setLayout(null);
		contentPane.add(lblEnterPassword);
		contentPane.add(lblEnterName);
		contentPane.add(textField);
		contentPane.add(passwordField);
		contentPane.add(lblBereaattendAClass);
		contentPane.add(lblNewLabel);
		contentPane.add(btnLogin);
		contentPane.add(lblFacultyLoginForm);
	}
}
