package view;


import javax.swing.JButton;
import javax.swing.JToolBar;

import app.MainFrame;


public class ParentToolbar extends JToolBar {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton demote;
	private JButton addRow;
	private JButton editRow;
	private JButton deleteRow;
	private JButton search;
	
	public ParentToolbar(){
		super();
		setFloatable(false);
		demote = add(MainFrame.getInstance().getAction().getDemote());
		addSeparator();
		addRow = add(MainFrame.getInstance().getAction().getAddRowTrue());
		editRow = add(MainFrame.getInstance().getAction().getEditRow());
		deleteRow = add(MainFrame.getInstance().getAction().getDeleteRowTrue());
		addSeparator();
		search = add(MainFrame.getInstance().getAction().getSearch());
		
	}
	public void changeLanguage(){
		demote.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("PARENTbtnDown"));
		addRow.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("PARENTbtnAdd"));
		editRow.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("PARENTbtnUpdate"));
		deleteRow.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("PARENTbtnDelete"));
		search.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("PARENTbtnSearch"));
	}

	

}
