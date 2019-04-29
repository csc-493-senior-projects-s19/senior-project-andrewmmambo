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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;

@SuppressWarnings("unused")

//this class allows faculty to add student details. It is a back up class. It is currently not being implemented.
public class facultyaddstudentsForm extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static facultyaddstudentsForm frame;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new facultyaddstudentsForm();
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
	public facultyaddstudentsForm() {
		setTitle("BereaATTEND");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1320, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblAddAttendance = new JLabel("Add Attendance");
		lblAddAttendance.setBounds(572, 302, 189, 29);
		lblAddAttendance.setForeground(Color.CYAN);
		lblAddAttendance.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		JLabel lblStudentid = new JLabel("Student ID:");
		lblStudentid.setBounds(532, 338, 106, 22);
		lblStudentid.setForeground(Color.CYAN);
		lblStudentid.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblName = new JLabel("StudentName:");
		lblName.setBounds(532, 376, 136, 22);
		lblName.setForeground(Color.CYAN);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(532, 409, 81, 22);
		lblDate.setForeground(Color.CYAN);
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblCourse = new JLabel("Course:");
		lblCourse.setBounds(532, 452, 106, 22);
		lblCourse.setForeground(Color.CYAN);
		lblCourse.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblPresent = new JLabel("Present:");
		lblPresent.setBounds(532, 491, 106, 22);
		lblPresent.setForeground(Color.CYAN);
		lblPresent.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		textField = new JTextField();
		textField.setBounds(714, 342, 167, 20);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(714, 380, 167, 20);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(714, 413, 167, 20);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(714, 456, 167, 20);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(714, 495, 167, 20);
		textField_4.setColumns(10);
		
		JButton btnAddattendance = new JButton("Add attendance");
		btnAddattendance.setBounds(596, 547, 180, 31);
		btnAddattendance.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAddattendance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String studentid=textField.getText();
			String studentname=textField_1.getText();
			String date=textField_2.getText();
			String course=textField_3.getText();
			int present= Integer.parseInt(textField_4.getText());
			int i=facultyaddstudents.save(studentid, studentname, date, course, present);
				if(i>0){
					JOptionPane.showMessageDialog(facultyaddstudentsForm.this,"Attendance added successfully!");
					StudentSuccess.main(new String[]{});
					frame.dispose();
					
				}else{
					JOptionPane.showMessageDialog(facultyaddstudentsForm.this,"Sorry, unable to save!");
			}
			}
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack.setBounds(623, 597, 114, 37);
		
		JLabel lblBereaattendAClass = new JLabel("BereaATTEND- a class attendance management tool");
		lblBereaattendAClass.setBounds(402, 11, 621, 29);
		lblBereaattendAClass.setForeground(Color.CYAN);
		lblBereaattendAClass.setFont(new Font("Tahoma", Font.BOLD, 24));
		contentPane.setLayout(null);
		contentPane.add(lblBereaattendAClass);
		contentPane.add(lblAddAttendance);
		contentPane.add(lblName);
		contentPane.add(lblStudentid);
		contentPane.add(lblDate);
		contentPane.add(lblCourse);
		contentPane.add(lblPresent);
		contentPane.add(textField_4);
		contentPane.add(textField_3);
		contentPane.add(textField_2);
		contentPane.add(textField_1);
		contentPane.add(textField);
		contentPane.add(btnAddattendance);
		contentPane.add(btnBack);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(facultyaddstudentsForm.class.getResource("/attendB/clocks.png")));
		label.setBounds(562, 62, 224, 229);
		contentPane.add(label);
	}

}
