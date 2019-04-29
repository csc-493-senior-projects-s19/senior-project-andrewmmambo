// written by Marima Andrew Mambondiumwe for CSC 493, Spring 2019

package attendB;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;


// THIS CLASS ALLOWS THE STUDENT TO MAKE SEVERAL FUNCTIONAL OP[TIONS ONCE THEY SUCCESSFULLY LOGIN
@SuppressWarnings("unused")
public class StudentSuccess extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static StudentSuccess frame;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new StudentSuccess();
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
	public StudentSuccess() {
		setTitle("BereaATTEND");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1320, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setForeground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblStudentSection = new JLabel("Student Section");
		lblStudentSection.setForeground(Color.CYAN);
		lblStudentSection.setBounds(559, 330, 191, 27);
		lblStudentSection.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		JButton btnViewAttendance = new JButton("View Student Details");
		btnViewAttendance.setBounds(537, 395, 224, 37);
		btnViewAttendance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				students.main(new String[]{});
			}
		});
		btnViewAttendance.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		
		JButton btnSelectCourse = new JButton("View Attendance");
		btnSelectCourse.setBounds(559, 457, 191, 37);
		btnSelectCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewAttendance.main(new String[]{});
			}
		});
		btnSelectCourse.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(559, 533, 191, 37);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainLogin.main(new String[]{});
				frame.dispose();
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblBereaattendAClass = new JLabel("BereaATTEND- a class attendance management tool");
		lblBereaattendAClass.setBounds(354, 14, 621, 29);
		lblBereaattendAClass.setForeground(Color.CYAN);
		lblBereaattendAClass.setFont(new Font("Tahoma", Font.BOLD, 24));
		contentPane.setLayout(null);
		contentPane.add(lblBereaattendAClass);
		contentPane.add(lblStudentSection);
		contentPane.add(btnLogout);
		contentPane.add(btnSelectCourse);
		contentPane.add(btnViewAttendance);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(StudentSuccess.class.getResource("/attendB/clocks.png")));
		label.setBounds(537, 70, 224, 236);
		contentPane.add(label);
	}

}
