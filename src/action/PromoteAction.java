package action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import app.MainFrame;
import controller.TableController;


/**
 * 
 * @author Snezana Stevanovic
 * 
 * Klasa u okviru koje se realizuje izvrsavanje Promote akcije
 *
 */

@SuppressWarnings("serial")
public class PromoteAction extends CommonAction {

	/**
	 * Konstruktor unutar kog se uz pomoæ nasledjene klase {@code CommonAction} 
	 * dodeljuju sve vrednosti koje ovo dugme treba da poseduje.
	 */
	public PromoteAction() {
		super("Promote",
			  MainFrame.getInstance().getResourceBundle().getString("CHILDbtnUp"), 
			  KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK+ActionEvent.ALT_MASK),
			   KeyEvent.VK_D,
			   new ImageIcon("src/icons/promote.png"));
		  	   this.setEnabled(false);
		  	   
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		
		int tabIndex =	MainFrame.getInstance().getMainTabsChild().getSelectedIndex();
		String tableName = MainFrame.getInstance().getMainTabsChild().getTitleAt(tabIndex);
		
		TableController tableController = new TableController();
		
		tableController.createParentTableView(tableController.getSelectedTable(tableName));
		tableController.setChildren(tableController.getSelectedTable(tableName));
		MainFrame.getInstance().getSplit2().resetToPreferredSizes();
		MainFrame.getInstance().getSplit2().setResizeWeight(1.0);
		MainFrame.getInstance().getSplit2().setDividerLocation(250);
		MainFrame.getInstance().getPanel().validate();
		MainFrame.getInstance().repaint();
		
		if (MainFrame.getInstance().getTabelebyName(tableName).getReferences().size() != 0 ){
			MainFrame.getInstance().getAction().getDemote().setEnabled(true);
		}
	}
	
}
