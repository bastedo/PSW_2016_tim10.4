package table.listener;

import java.awt.Component;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import app.MainFrame;
import model.TableModel;




/**
 * Implementacija {@link ListSelectionListener} interfejsa.
 * 
 * @author Boris Bogojevic
 *
 */
public class TableSelectionListener implements ListSelectionListener {
	private JTable table;
	
	public TableSelectionListener(JTable table) {
		this.setTable(table);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		int i = MainFrame.getInstance().getMainTabsParent().getComponentCount();
		JScrollPane scrollPane = (JScrollPane)MainFrame.getInstance().getMainTabsParent().getComponent(0);
		JViewport view = scrollPane.getViewport();
        Component[] components =view.getComponents();
        for (int i1 = 0; i1 < components.length; i1++) {
            if (components[i1] instanceof JTable) {
                System.out.println("Hehehehr here is heídden that JTable");
                JTable jt = (JTable)components[i1];
                DefaultTableModel tm = (DefaultTableModel) jt.getModel();
                int i3 = jt.getSelectedRow();
                if (i3>-1){
	                System.out.println(i3);
	                System.out.println(tm.getDataVector().elementAt(i3));
	                Vector aba = (Vector)tm.getDataVector().elementAt(i3);
	                aba.get(1);
	                System.out.println(aba.get(0));
	               if (tm.getDataVector().elementAt(i3) !=null) {
	            	   
	            	    int a = MainFrame.getInstance().getMainTabsChild().getComponentCount();
	            	    	if(a>0) {
	            	    		for(int i11 = 0; i11<a; i11++){
	            	    			System.out.println(a);
	                	    		JScrollPane scrollPane1 = (JScrollPane)MainFrame.getInstance().getMainTabsChild().getComponent(i11);
	                       			JViewport view1 = scrollPane1.getViewport();
	                       			Component[] components1 =view1.getComponents();
	                       			for (int i111 = 0; i111 < components1.length; i111++) {
	                       				if (components[i111] instanceof JTable) {
	                       					System.out.println("Hehehehr here is heídden that JTable");
	                       	                JTable jt1 = (JTable)components1[i111];
	                       	                DefaultTableModel tm1 = (DefaultTableModel) jt1.getModel();
	                       	                TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(tm1); 
	                       	                sorter.setRowFilter(RowFilter.regexFilter((String)aba.get(0)));
	
	                       	                jt1.setRowSorter(sorter);
                       	                
                       				}
                       				
                       			}
            	    		}
            	    		
            	    		
            	    	}
           			
           			
               }
                
            }
            }
        }
		
		System.out.println("promena"+i);
		
	}

	/**
	 * @return the table
	 */
	public JTable getTable() {
		return table;
	}

	/**
	 * @param table the table to set
	 */
	public void setTable(JTable table) {
		this.table = table;
	}
	



}
