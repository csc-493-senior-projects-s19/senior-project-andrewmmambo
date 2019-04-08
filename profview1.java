package bereaattend;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.custom.CLabel;

import javax.swing.JComboBox;

import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.custom.CCombo;

public class profview1 {

	protected Shell shlBereaattend;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			profview1 window = new profview1();
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
		lblWelcome.setBounds(173, 225, 143, 21);
		lblWelcome.setText("Welcome Professor/T.A");
		
		CLabel label = new CLabel(shlBereaattend, SWT.NONE);
		label.setText("BereaATTEND- An Attendance Management System");
		label.setImage(SWTResourceManager.getImage(profview1.class, "/bereaattend/clocks.png"));
		label.setBounds(62, 0, 286, 21);
		
		CLabel label_1 = new CLabel(shlBereaattend, SWT.NONE);
		label_1.setText("");
		label_1.setImage(SWTResourceManager.getImage(profview1.class, "/bereaattend/clocks.png"));
		label_1.setBounds(112, 28, 261, 191);
		
		Button btnViewAttendance = new Button(shlBereaattend, SWT.NONE);
		btnViewAttendance.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnViewAttendance.setBounds(188, 297, 117, 25);
		btnViewAttendance.setText("GO TO ATTENDANCE");
		
		CCombo combo = new CCombo(shlBereaattend, SWT.BORDER);
		combo.setText("SELECT A COURSE");
		combo.setItems(new String[] {"Machine Learning", "Computer Architecture", "Data Science", "Intro to Programming 1"});
		combo.setTouchEnabled(true);
		combo.setListVisible(true);
		combo.setBounds(152, 258, 187, 21);
		
		
		
	}
}
