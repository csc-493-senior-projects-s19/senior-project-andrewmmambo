package bereaattend;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.MessageBox;


public class MainWindow  {

	protected static final int EXIT_ON_CLOSE = 0;
	//	protected static final String HIDE_ON_CLOSE = null;
	protected Shell shlBereaattend;
	
	private String EnterUsername  = null;
    private String EnterPassword  = null;
    private Text txtEnterUsername;
    private Text txtEnterPassword;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MainWindow window = new MainWindow();
			window.open();
			MainWindow.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	private static void setVisible(boolean b) {
	}
	

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
	protected void createContents() {
		shlBereaattend = new Shell();
		shlBereaattend.setImage(SWTResourceManager.getImage(MainWindow.class, "/bereaattend/clocks.png"));
		shlBereaattend.setSize(655, 451);
		
		CLabel lblBereaattend = new CLabel(shlBereaattend, SWT.NONE);
		lblBereaattend.setImage(SWTResourceManager.getImage(MainWindow.class, "/bereaattend/clocks.png"));
		lblBereaattend.setBounds(175, 0, 286, 52);
		lblBereaattend.setText("BereaATTEND- An Attendance Management System");
		
		CLabel logo = new CLabel(shlBereaattend, SWT.NONE);
		logo.setImage(SWTResourceManager.getImage
				(MainWindow.class, "/bereaattend/clocks.png"));
		logo.setBounds(201, 51, 230, 200);
		logo.setText("");
		
		Label lblUsername = new Label(shlBereaattend, SWT.NONE);
		lblUsername.setBounds(194, 257, 47, 15);
		lblUsername.setText("User ID");
		
		Label lblPassword = new Label(shlBereaattend, SWT.NONE);
		lblPassword.setBounds(186, 298, 55, 15);
		lblPassword.setText("Password");
		
		txtEnterUsername = new Text(shlBereaattend, SWT.BORDER);
		txtEnterUsername.setBounds(263, 257, 121, 21);
		
		txtEnterPassword = new Text(shlBereaattend, SWT.BORDER);
		txtEnterPassword.setBounds(263, 298, 121, 21);
		
		Button btnLogin_1 = new Button(shlBereaattend, SWT.NONE);

		btnLogin_1.setBounds(289, 344, 75, 25);
		btnLogin_1.setText("LOGIN");
		
	btnLogin_1.addListener(SWT.Selection, new Listener() {
		public void handleEvent(Event event) {
			EnterUsername = txtEnterUsername.getText();
            EnterPassword = txtEnterPassword.getText();
            	
            if (EnterUsername.equals("B001") && EnterPassword.equals
            		("berea")
            		) {
            	  MessageBox messageBox = new MessageBox(shlBereaattend, SWT.OK | SWT.ICON_WORKING);
               	  messageBox.setText("Info");
               	  messageBox.setMessage("Valid");                   		
               	  messageBox.open();
            	  setDefaultCloseOperation(MainWindow.EXIT_ON_CLOSE);

            
               	try {
               			
            		studentview window1 = new studentview();
            		window1.open();
            		MainWindow.setVisible(false);
            	} catch (Exception e1) {
            		e1.printStackTrace();
            		}
               		
            		
            }else if (EnterUsername.equals("A001") && EnterPassword.equals
            		("beloved")
            		) {
	            	  MessageBox messageBox = new MessageBox(shlBereaattend, SWT.OK | SWT.ICON_WORKING);
                   	  messageBox.setText("Info");
                   	  messageBox.setMessage("Valid");                   		
                   	  messageBox.open();
                	  setDefaultCloseOperation(MainWindow.EXIT_ON_CLOSE);

                
                  try {
                   			
                   	  profview1 window2 = new profview1();
                	  window2.open();
                	  MainWindow.setVisible(false);
                  } catch (Exception e2) {
                		e2.printStackTrace();
                		}
            	}
	 
              else {
            	    MessageBox messageBox = new MessageBox(shlBereaattend, SWT.OK | SWT.ICON_WORKING);
            	    String errorMsg = "Invalid login details";
                	messageBox.setMessage(errorMsg);
               		messageBox.open(); 
               }

	}
	protected void setDefaultCloseOperation(int exitOnClose) {
				{			
	}
}
	});
}
}
  

