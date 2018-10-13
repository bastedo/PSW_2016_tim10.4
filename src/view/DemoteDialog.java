package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import app.MainFrame;
import controller.TableController;
import model.TableSchema;
import net.miginfocom.swing.MigLayout;

/**
 * 
 * @author Snezana Stevanovic
 *
 *Klasa koja predstavlja {@link JDialog} dialog koji se korisniku
 * otvara prilikom odabira tabele za propagaciju (PARENT propagacija) 
 */

@SuppressWarnings("serial")
public class DemoteDialog extends JDialog{
	
	/**
	 * Konstruktor u okviru koga je implementiran izgled dijaloga kao i akcija
	 */
	public DemoteDialog(){
		
		JPanel panel = new JPanel();
		int tabIndex =	MainFrame.getInstance().getMainTabsParent().getSelectedIndex();
		String tableName = MainFrame.getInstance().getMainTabsParent().getTitleAt(tabIndex);
		
		TableController tableController = new TableController();
		
		JComboBox<String> combo = new JComboBox<String>();
		JButton btnOk =new JButton("OK");
		
		for (int i=0; i< MainFrame.getInstance().getTabele().get(tableName).getReferences().size(); i++){
			if (MainFrame.getInstance().getTabele().get(tableName).getReferences().size() >1){

				combo.addItem(tableController.getNameByCode(MainFrame.getInstance().getTabele().get(tableName).getReferences().get(i)));
				
			}
		}
		
		panel.setLayout(new MigLayout());
		panel.add(new JLabel("Odaberite tabelu za propagaciju: "), "newline, center");
		panel.add(combo, "newline, bottom, center");
		panel.add(btnOk, "newline, right, split 2, width 100px");
		
		this.setTitle("Demote dialog");
		this.setSize((int)MainFrame.getInstance().getTk().getScreenSize().getHeight()/3, (int)MainFrame.getInstance().getTk().getScreenSize().getWidth()/8);
		this.setLayout(new MigLayout());
		this.add(panel, "center");
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				TableSchema curTable = MainFrame.getInstance().getTabele().get(combo.getSelectedItem());
				
				tableController.createParentTableView(tableController.getSelectedTable(curTable.getName()));
				tableController.setChildren(tableController.getSelectedTable(curTable.getName()));
				MainFrame.getInstance().getSplit2().resetToPreferredSizes();
				MainFrame.getInstance().getSplit2().setResizeWeight(1.0);
				MainFrame.getInstance().getSplit2().setDividerLocation(250);
				MainFrame.getInstance().getPanel().validate();
				MainFrame.getInstance().repaint();
				dispose();
			}
		});
	}

}
