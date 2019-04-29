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
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
// this class allows the faculty member to make changes to the attendance record of a student. it calls the attendance DAO class for the database interactions.
@SuppressWarnings("unused")
public class editattendance extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static editattendance frame;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new editattendance();
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
	public editattendance() {
		setTitle("BereaATTEND");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1320, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lbltakeattendance = new JLabel("Take attendance");
		lbltakeattendance.setBounds(570, 273, 198, 29);
		lbltakeattendance.setForeground(Color.CYAN);
		lbltakeattendance.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		JLabel lblstudentid = new JLabel("Student Id");
		lblstudentid.setBounds(442, 345, 136, 22);
		lblstudentid.setForeground(Color.CYAN);
		lblstudentid.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblStudentname = new JLabel("Student Name:");
		lblStudentname.setBounds(442, 417, 136, 22);
		lblStudentname.setForeground(Color.CYAN);
		lblStudentname.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		textField = new JTextField();
		textField.setBounds(633, 349, 181, 20);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(633, 421, 181, 20);
		textField_1.setColumns(10);
		
		JButton btnPresent = new JButton("Present");
		btnPresent.setBounds(522, 470, 104, 34);
		btnPresent.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnPresent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String studentid=textField.getText();
				String studentname=textField_1.getText();
				int i=editattendanceDao.delete(studentid, studentname);
				if(i>0){
					JOptionPane.showMessageDialog(editattendance.this,"Counted present!");
					FacultySuccess.main(new String[]{});
					frame.dispose();
					
				}else{
					JOptionPane.showMessageDialog(editattendance.this,"unable to be counted present");
				}
			}
		});
		
		JLabel lblNewLabel = new JLabel("Make sure correct attendance is taken!");
		lblNewLabel.setBounds(24, 568, 374, 34);
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(621, 551, 116, 31);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FacultySuccess.main(new String[]{});
				frame.dispose();
			}
		});
		
		JButton btnAbsent = new JButton("Absent");
		btnAbsent.setBounds(730, 470, 104, 34);
		btnAbsent.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAbsent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String studentid=textField.getText();
				String studentname=textField_1.getText();
				int i=editattendanceDao.delete(studentid, studentname);
				if(i<1){
					JOptionPane.showMessageDialog(editattendance.this,"Counted absent!");
					FacultySuccess.main(new String[]{});
					frame.dispose();
					
				}else{
					JOptionPane.showMessageDialog(editattendance.this,"unable to be counted absent");
				
			}
			}	
		});
		
		JLabel lblBereaattendAClass = new JLabel("BereaATTEND- a class attendance management tool");
		lblBereaattendAClass.setBounds(407, 16, 471, 22);
		lblBereaattendAClass.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblBereaattendAClass.setForeground(Color.CYAN);
		contentPane.setLayout(null);
		contentPane.add(lblBereaattendAClass);
		contentPane.add(lblStudentname);
		contentPane.add(lblstudentid);
		contentPane.add(textField_1);
		contentPane.add(textField);
		contentPane.add(btnAbsent);
		contentPane.add(btnPresent);
		contentPane.add(lbltakeattendance);
		contentPane.add(lblNewLabel);
		contentPane.add(btnBack);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(editattendance.class.getResource("/attendB/clocks.png")));
		label.setBounds(560, 59, 224, 203);
		contentPane.add(label);
	}
}
