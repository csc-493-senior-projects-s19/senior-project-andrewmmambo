package bereaattend;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.custom.CCombo;

public class studentview {

	public class setVisible {

	}

	protected Shell shlBereaattend;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			studentview window = new studentview();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlBereaattend.open();
		shlBereaattend.layout();
		while (!shlBereaattend.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlBereaattend = new Shell();
		shlBereaattend.setSize(518, 422);
		shlBereaattend.setText("BereaATTEND");
		
		CLabel lblWelcome = new CLabel(shlBereaattend, SWT.NONE);
		lblWelcome.setBounds(193, 227, 107, 21);
		lblWelcome.setText("Welcome Student");
		
		CLabel label = new CLabel(shlBereaattend, SWT.NONE);
		label.setText("BereaATTEND- An Attendance Management System");
		label.setImage(SWTResourceManager.getImage(studentview.class, "/bereaattend/clocks.png"));
		label.setBounds(109, 0, 286, 21);
		
		CLabel label_1 = new CLabel(shlBereaattend, SWT.NONE);
		label_1.setText("");
		label_1.setImage(SWTResourceManager.getImage(studentview.class, "/bereaattend/clocks.png"));
		label_1.setBounds(129, 27, 230, 194);
		
		Button btnViewAttendance = new Button(shlBereaattend, SWT.NONE);
		btnViewAttendance.setBounds(168, 300, 117, 25);
		btnViewAttendance.setText("VIEW ATTENDANCE");
		
		CCombo combo = new CCombo(shlBereaattend, SWT.BORDER);
		combo.setTouchEnabled(true);
		combo.setItems(new String[] {"Machine Learning", "Computer Architecture", "Data Science", "Intro to Programming"});
		combo.setText("SELECT A COURSE");
		combo.setListVisible(true);
		combo.setBounds(145, 256, 203, 21);

	}

	public static void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	}
