// written by Marima Andrew Mambondiumwe for CSC 493, Spring 2019

package attendB;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

//THIS CLASS ALLOWS THE FACULTY TO MAKE SEVERAL FUNCTIONAL OPTIONS ONCE THEY SUCCESSFULLY LOGIN
@SuppressWarnings("unused")
public class FacultySuccess extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static FacultySuccess frame;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new FacultySuccess();
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
	public FacultySuccess() {
		setTitle("BereaATTEND");
		setForeground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1320, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setForeground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblAdminSection = new JLabel("Faculty Section");
		lblAdminSection.setBounds(542, 323, 226, 40);
		lblAdminSection.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblAdminSection.setForeground(Color.CYAN);
		
		JButton btnNewButton = new JButton("Take attendance"); // allows the faculty to record the attendance of a student.
		btnNewButton.setBounds(502, 376, 266, 49);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			editattendance.main(new String[]{});
			frame.dispose();
			}
		});
		
		JButton btnViewStudent = new JButton("View Student");// allows the faculty to view the student attendance record.
		btnViewStudent.setBounds(502, 451, 266, 49);
		btnViewStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			ViewAttendance.main(new String[]{});
			}
		});
		btnViewStudent.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JButton btnDeleteStudent = new JButton("Delete Student Attendance"); // allows the faculty to delete the student attendance record
		btnDeleteStudent.setBounds(502, 527, 266, 49);
		btnDeleteStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			DeleteStudent.main(new String[]{});
			frame.dispose();
			}
		});
		btnDeleteStudent.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(542, 601, 181, 49);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainLogin.main(new String[]{});
				frame.dispose();
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.setLayout(null);
		contentPane.add(lblAdminSection);
		contentPane.add(btnLogout);
		contentPane.add(btnDeleteStudent);
		contentPane.add(btnViewStudent);
		contentPane.add(btnNewButton);
		
		JLabel lblBereaattendAClass = new JLabel("BereaATTEND- a class attendance management tool"); // sets the title on the GUI
		lblBereaattendAClass.setForeground(Color.CYAN);
		lblBereaattendAClass.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblBereaattendAClass.setBounds(364, 11, 621, 40);
		contentPane.add(lblBereaattendAClass);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(FacultySuccess.class.getResource("/attendB/clocks.png"))); // SETS THE LOGO ON THE GUI
		label.setBounds(523, 79, 226, 233);
		contentPane.add(label);
	}
}
