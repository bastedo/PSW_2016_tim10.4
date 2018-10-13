<<<<<<< HEAD
package view;

import javax.swing.JButton;
import javax.swing.JToolBar;

import app.MainFrame;
/**
 * 
 * @author Snezana Stevanovic
 * 
 * Klasa u okviru koje se kreira {@link JToolBar} za Child tabele
 *
 */

@SuppressWarnings("serial")
public class ChildToolbar extends JToolBar {
	

	private JButton promote;
	private JButton addRow;
	private JButton editRow;
	private JButton deleteRow;
	private JButton search;

	public ChildToolbar(){
		super();
		setFloatable(false);
		promote = add(MainFrame.getInstance().getAction().getPromote());
		addSeparator();
		addRow = add(MainFrame.getInstance().getAction().getAddRowFalse());
		editRow = add(MainFrame.getInstance().getAction().getEditRow());
		deleteRow = add(MainFrame.getInstance().getAction().getDeleteRowFalse());
		addSeparator();
		search = add(MainFrame.getInstance().getAction().getSearch());
		
	}

	public void changeLanguage() {
		promote.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("CHILDbtnUp"));
		addRow.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("PARENTbtnAdd"));
		editRow.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("PARENTbtnUpdate"));
		deleteRow.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("PARENTbtnDelete"));
		search.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("PARENTbtnSearch"));
		// TODO Auto-generated method stub
		
	}
	
	
}
=======
package view;

import javax.swing.JButton;
import javax.swing.JToolBar;

import app.MainFrame;
/**
 * 
 * @author Snezana Stevanovic
 * 
 * Klasa u okviru koje se kreira {@link JToolBar} za Child tabele
 *
 */

@SuppressWarnings("serial")
public class ChildToolbar extends JToolBar {
	

	private JButton promote;
	private JButton addRow;
	private JButton editRow;
	private JButton deleteRow;
	private JButton search;

	public ChildToolbar(){
		super();
		setFloatable(false);
		promote = add(MainFrame.getInstance().getAction().getPromote());
		addSeparator();
		addRow = add(MainFrame.getInstance().getAction().getAddRowFalse());
		editRow = add(MainFrame.getInstance().getAction().getEditRow());
		deleteRow = add(MainFrame.getInstance().getAction().getDeleteRowFalse());
		addSeparator();
		search = add(MainFrame.getInstance().getAction().getSearch());
		
	}

	public void changeLanguage() {
		promote.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("CHILDbtnUp"));
		addRow.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("PARENTbtnAdd"));
		editRow.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("PARENTbtnUpdate"));
		deleteRow.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("PARENTbtnDelete"));
		search.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("PARENTbtnSearch"));
		// TODO Auto-generated method stub
		
	}
	
	
}
>>>>>>> origin/master
