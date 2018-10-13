package forms.listener;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;

import model.Column;
import model.Columns;
import model.TableModel;
import model.TableSchema;
import readDB.DatabaseColumn;
import readDB.ReadDatabase;
import readDB.ReadDatabaseChild;
import app.MainFrame;
import controller.TableController;
import forms.DeleteRowDialog;
	/**
	 * Klasa koja reaguje na klik OK,i vrsi brisanje redova u tabeli
	 * @author 
	 *
	 */
public class OkDeleteListener implements ActionListener, KeyListener {
	/**
	 * Atribut koji predstavlja informaciju da li je u pitanju
	 *  parent {@code TRUE} ili child {@code FALSE} tabela
	 */
	private boolean isParent;
	/**
	* Atribut koji predstavljai instancu dialoga za brisanje
	*/
	private DeleteRowDialog dialog;
	
	private TableController tc;
	/**
	* Konstruktor unutar kog se vrsi inicijalizacija atributa na osnovu prosledjenih parametara
	* @param isParent da li je rec o parent {@code TRUE} ili child {@code FALSE} tabeli
	* @param dialog instanca otvorenog dialoga za brisanje
	*/
	public OkDeleteListener(boolean isParent, DeleteRowDialog dialog) {
		this.isParent = isParent;
		this.dialog = dialog;
	}
		
	/**
	 * Metoda koja vrsi brisanje selektovanog reda iz tabele.
	 */
	public void delete() {
			
		tc = new TableController();
		
		JScrollPane scrollPane = (JScrollPane)MainFrame.getInstance().getMainTabsParent().getComponent(0);
		JViewport view = scrollPane.getViewport();
        Component[] components =view.getComponents();
        JTable tableParent = (JTable) components[0];
        int idxRowParent = tableParent.getSelectedRow();
			
//        JPanel panel = (JPanel)MainFrame.getInstance().getMainTabsParent().getSelectedComponent();
//		JTable tableParent = ((JTable)MainFrame.getInstance().getMainTabsParent().getSelectedComponent());
//		int idxRowParent = tableParent.getSelectedRow();
//		
		int indexP = MainFrame.getInstance().getMainTabsParent().getSelectedIndex();
		
		TableSchema tableSchemaParent  = MainFrame.getInstance().getTabelebyName(MainFrame.getInstance().getMainTabsParent().getTitleAt(indexP));
		Columns parentC = tableSchemaParent.getColumns();
		System.out.println(parentC.size() + tableSchemaParent.getName() + parentC );
		ArrayList<DatabaseColumn> data = new ArrayList<DatabaseColumn>();
			
				if(isParent == true) {
					try{
						for(int i=0; i<parentC.size(); i++) {
							System.out.println(parentC.getColumn(i).getName()+ tableSchemaParent.getReferences().size());
								
									int idx = findColumnIndex(parentC.getColumn(i).getName(),true);
									Column column = parentC.getColumn(i);
									String code = column.getCode();
									String value = null;
									Object value1 = (tableParent.getModel().getValueAt(idxRowParent, idx));
									if (value1 != null) {
										value = value1.toString();
										String type = column.getTypeC();
										System.out.println(code+value+type);
										data.add(new DatabaseColumn(code, value, type));
									}
									
								
							}
						ReadDatabaseChild.getInstance().DeleteFromDatabase(tableSchemaParent, data);
						ReadDatabase.getInstance().Read(tableSchemaParent);
						TableModel tableModel = tc.addData(tableSchemaParent);
						tableParent.setModel(tableModel);
						
					}catch (Exception e1) {
						JOptionPane.showMessageDialog(new JFrame(), MainFrame.getInstance().getResourceBundle().getString("errorDelete"));
					}
				}
				else{
					JTable tableChild = (JTable) ((JScrollPane)MainFrame.getInstance().getMainTabsChild().getSelectedComponent()).getViewport().getComponent(0);
					//JScrollPane scrollPane1 = (JScrollPane)MainFrame.getInstance().getMainTabsParent().getComponent(0);
					//JViewport view1 = scrollPane1.getViewport();
			        //Component[] components1 =view1.getComponents();
			        //JTable tableChild = (JTable) components[0];
			        
			        
					int indexC = MainFrame.getInstance().getMainTabsChild().getSelectedIndex();
					TableSchema tableSchemaChild  = MainFrame.getInstance().getTabelebyName(MainFrame.getInstance().getMainTabsChild().getTitleAt(indexC));
					
					int idxRowChild = tableChild.getSelectedRow();
					Columns childC  = tableSchemaChild.getColumns();
					try{
						for(int i=0; i<childC.size(); i++) {
							if(tableSchemaChild.getReferences().size() != 0) {
								int idx = findColumnIndex(childC.getColumn(i).getName(), false);
								Column column = childC.getColumn(i);
								String value= null;
								String code = column.getCode();
								Object value1 = (tableChild.getModel().getValueAt(idxRowChild, idx));
								if (value1 != null) {
									value = value1.toString();
									String type = column.getTypeC();
									System.out.println(code+value+type);
									data.add(new DatabaseColumn(code, value.trim(), type));
								}
								
							}
						}
						
						ReadDatabaseChild.getInstance().DeleteFromDatabase(tableSchemaChild, data);
						tableChild.repaint();
					}catch (Exception e1) {
						JOptionPane.showMessageDialog(new JFrame(), MainFrame.getInstance().getResourceBundle().getString("errorDelete"));
						}
			} 
				
//				try{
//					for(int i=0; i<parentC.size(); i++) {
//							if(tableSchemaParent.getReferences().size() != 0) {
//								int idx = findColumnIndex(parentC.getColumn(i).getName(), true);
//								Column column = parentC.getColumn(i);
//								String code = column.getCode();
//								String value = (tableParent.getModel().getValueAt(idxRowParent, idx)).toString();
//								String type = column.getTypeC();
//								data.add(new DatabaseColumn(code, value, type));
//							}
//						}
//						
//					ReadDatabaseChild.getInstance().DeleteFromDatabase(tableSchemaParent, data);
//					ReadDatabase.getInstance().Read(tableSchemaParent);
//					TableModel tableModel = tc.addData(tableSchemaParent);
//					tableParent.setModel(tableModel);
//					tableParent.repaint();
//				}catch (Exception e1) {
//					JOptionPane.showMessageDialog(new JFrame(), MainFrame.getInstance().getResourceBundle().getString("errorDelete"));
//				}
				
			
			TableController tc = new TableController();
			tc.createParentTableView(tableSchemaParent);
			tc.setChildren(tableSchemaParent);
			dialog.setVisible(false);
			
//			JTable table = new JTable();
//			if(isParent)
//				table = tc.getTableParent((JPanel)MainFrame.getInstance().getMainTabsParent().getSelectedComponent());
//			else
//				table = TableController.getInstance().getTableChild((JPanel)MainFrame.getInstance().getMainTabsParent().getSelectedComponent());

//			if(table.getSelectedRow()!=-1){
//				MainFrame.getInstance().getAction().getDeleteRow(isParent).setEnabled(true);
//				MainFrame.getInstance().getActionManager().getEditRow(isParent).setEnabled(true);
//			} else {
//				MainFrame.getInstance().getActionManager().getDeleteRow(isParent).setEnabled(false);
//				MainFrame.getInstance().getActionManager().getEditRow(isParent).setEnabled(false);
//			}
			
		}
	/**
	 * Metoda koja pristiskom na dugme ok poziva delete metodu
	 */
	public void actionPerformed(ActionEvent arg0) {
		delete();
		
	}
	/**
	 * Metoda koja se poziva pritiskom na dugme na tastaturi
	 */
	public void keyPressed(KeyEvent arg0) {
		if(arg0.getKeyCode() == KeyEvent.VK_ENTER){ 
			delete();
		}
	}

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Metoda koja na osnovu parametra vraca index kolone u tabeli
	 * @param name  naziv kolone
	 * @return index pronadjene  kolone
	 */
	private int findColumnIndex(String name,boolean isParent) {
		if(isParent == true) {
		JScrollPane scrollPane = (JScrollPane)MainFrame.getInstance().getMainTabsParent().getComponent(0);
		JViewport view = scrollPane.getViewport();
	    Component[] components =view.getComponents();
		JTable tableParent = (JTable) components[0];
		for(int ii=0; ii<tableParent.getColumnCount(); ii++) {
			//System.out.println(tableParent.getColumnName(ii));
			//System.out.println(name);
			//System.out.println(ii);
			if(tableParent.getColumnName(ii).equals(name)) {
				return ii;
			}
		}
		} else {
			
			JTable tableChild = (JTable) ((JScrollPane)MainFrame.getInstance().getMainTabsChild().getSelectedComponent()).getViewport().getComponent(0);
			
			
			for(int ii=0; ii<tableChild.getColumnCount(); ii++) {
				if(tableChild.getColumnName(ii).equals(name)) {
					return ii;
				}
			}
		}
		return -1;
	}
}
