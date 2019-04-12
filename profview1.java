package bereaattend;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.custom.CLabel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;

import com.mysql.jdbc.ResultSetMetaData;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Table;

public class profview1 {

	protected Shell shlBereaattend;
	private Table table;

	/**
	 * Launch the application.
	 * @param result
	 */
	public static void main(String[] args) throws Exception {
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
		shlBereaattend.setSize(698, 422);
		shlBereaattend.setText("BereaATTEND");
		
		CLabel lblWelcome = new CLabel(shlBereaattend, SWT.NONE);
		lblWelcome.setBounds(68, 66, 143, 21);
		lblWelcome.setText("Welcome Professor/T.A");
		
		CLabel label = new CLabel(shlBereaattend, SWT.NONE);
		label.setText("BereaATTEND- An Attendance Management System");
		label.setImage(SWTResourceManager.getImage(profview1.class, "/bereaattend/clocks.png"));
		label.setBounds(191, 11, 286, 21);
		
		CLabel label_1 = new CLabel(shlBereaattend, SWT.NONE);
		label_1.setText("");
		label_1.setImage(SWTResourceManager.getImage(profview1.class, "/bereaattend/clocks.png"));
		label_1.setBounds(234, 38, 261, 191);
		
//		table = new Table(shlBereaattend, SWT.BORDER | SWT.FULL_SELECTION);
		
//		table.setBounds(180, 262, 356, 111);
//		table.setHeaderVisible(true);
//		table.setLinesVisible(true);
		
		CCombo combo = new CCombo(shlBereaattend, SWT.BORDER);
		combo.setText("SELECT A COURSE");
		combo.setItems(new String[] {"Machine Learning", "Computer Architecture", "Data Science", "Intro to Programming 1"});
		combo.setTouchEnabled(true);
		combo.setListVisible(true);
		combo.setBounds(257, 235, 187, 21);
		combo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String selected_text = combo.getItem(combo.getSelectionIndex());
				System.out.println(selected_text);
				
				  if (selected_text.equals("Machine Learning")) {
				    	try {
				    		ConnectDB.main(null);
				    		System.out.println("MA");
				    		
		            	} catch (Exception e1) {
		            		e1.printStackTrace();
		            		}
		               		
		            		
		            }else if  (selected_text.equals("Computer Architecture")) {	            		 
		                  try {
		                	  ConnectDB.main(null);
		                	  System.out.println("CA");
		                	  
		                  } catch (Exception e2) {
		                		e2.printStackTrace();
		                		}
				  
					}else if  (selected_text.equals("Data Science")) {					 
							try {
								ConnectDB.main(null);	
								System.out.println("DS");
							} catch (Exception e3) {
								e3.printStackTrace();
							}
					}
		              else {
		            	  try {
								ConnectDB.main(null);	
								System.out.println("Intro to Programming 1");
							} catch (Exception e4) {
								e4.printStackTrace();
							}
		              }
			}
		
	@SuppressWarnings("unused")
	public  DefaultTableModel buildTableModel(ResultSet result) throws SQLException{
		JTable table = new JTable(buildTableModel(result));
		java.sql.ResultSetMetaData metaData = result.getMetaData();
	    // names of columns
	    Vector<String> columnNames = new Vector<String>();
	    int columnCount = metaData.getColumnCount();
	    for (int column = 1; column <= columnCount; column++) {
	        columnNames.add(metaData.getColumnName(column));
	    }

	    // data of the table
	    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	    while (result.next()) {
	        Vector<Object> vector = new Vector<Object>();
	        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
	            vector.add(result.getObject(columnIndex));
	        }
	        data.add(vector);
	    }
	    return new DefaultTableModel(data, columnNames);
	}		
	});
}
}