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

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

@SuppressWarnings("unused")
//This class gives feedback to the faculty when they try to make an alteration or addition to an attendance record.

public class attendanceForm extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static attendanceForm frame;
	private JPanel contentPane;
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
					frame = new attendanceForm();
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
	public attendanceForm() {
		setTitle("BereaATTEND");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1320, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Edit attendance");
		lblNewLabel.setBounds(579, 299, 188, 29);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setForeground(Color.CYAN);
		
		JLabel lblSID = new JLabel("StudentID:");
		lblSID.setBounds(473, 364, 101, 22);
		lblSID.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSID.setForeground(Color.CYAN);
		
		textField_1 = new JTextField();
		textField_1.setBounds(628, 368, 172, 20);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(628, 433, 172, 20);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(628, 485, 172, 20);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(628, 535, 172, 20);
		textField_4.setColumns(10);
		
		JLabel lblStudentname = new JLabel("Student name:");
		lblStudentname.setBounds(473, 429, 134, 22);
		lblStudentname.setForeground(Color.CYAN);
		lblStudentname.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(473, 481, 108, 22);
		lblDate.setForeground(Color.CYAN);
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblCourse = new JLabel("Course:");
		lblCourse.setBounds(473, 531, 100, 22);
		lblCourse.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCourse.setForeground(Color.CYAN);
		
		JButton btnCourse = new JButton("OK");
		btnCourse.setBounds(564, 588, 100, 31);
		btnCourse.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			String studentid=textField_1.getText();
			String studentname=textField_2.getText();
			String date=textField_3.getText();
			String course=textField_4.getText();
			
			if(attendanceDao.checkstudentid(studentid)){
			
			int i=attendanceDao.save(studentid, studentname, date, course);
			if(i>0){
				JOptionPane.showMessageDialog(attendanceForm.this,"Attendance taken successfully!");
				FacultySuccess.main(new String[]{});
				frame.dispose();
				
			}else{
				JOptionPane.showMessageDialog(attendanceForm.this,"Sorry, unable to take attendance!");
			}//end of save if-else
			
			}else{
				JOptionPane.showMessageDialog(attendanceForm.this,"Sorry, Student ID doesn't exist!");
			}//end of checkbook if-else
			
			}
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(723, 588, 101, 31);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FacultySuccess.main(new String[]{});
				frame.dispose();
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("Note: Please check Student ID Carefully before recording attendance!");
		lblNewLabel_1.setBounds(10, 634, 608, 16);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setForeground(Color.ORANGE);
		
		JLabel lblBereaattendAClass = new JLabel("BereaATTEND- a class attendance management tool");
		lblBereaattendAClass.setBounds(415, 11, 471, 22);
		lblBereaattendAClass.setForeground(Color.CYAN);
		lblBereaattendAClass.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.setLayout(null);
		contentPane.add(lblBereaattendAClass);
		contentPane.add(lblSID);
		contentPane.add(lblStudentname);
		contentPane.add(lblDate);
		contentPane.add(lblCourse);
		contentPane.add(textField_2);
		contentPane.add(textField_1);
		contentPane.add(textField_3);
		contentPane.add(textField_4);
		contentPane.add(lblNewLabel_1);
		contentPane.add(btnCourse);
		contentPane.add(btnBack);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(attendanceForm.class.getResource("/attendB/clocks.png")));
		label.setBounds(538, 44, 229, 243);
		contentPane.add(label);
	}
}
