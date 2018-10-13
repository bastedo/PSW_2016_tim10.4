package action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;

import app.MainFrame;
import controller.TableController;
import model.TableSchema;
import view.DemoteDialog;

/**
 * 
 * @author Snezana
 * 
 * Klasa unutar koje se realizuje izvrsavanje Demote akcije
 *
 */

@SuppressWarnings("serial")
public class DemoteAction extends CommonAction {

	/**
	 * Konstruktor unutar kog se uz pomo� nasledjene klase {@code CommonAction} 
	 * dodeljuju sve vrednosti koje ovo dugme treba da poseduje.
	 */
	public DemoteAction() {
		super(	"Demote",
				MainFrame.getInstance().getResourceBundle().getString("PARENTbtnDown"), 
				KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK+ActionEvent.ALT_MASK),
				KeyEvent.VK_D,
				new ImageIcon("src/icons/demote.png"));
				this.setEnabled(false);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Realizacija akcije prilikom klikom na dugme Demote
	 */
	@Override
	public void actionPerformed(ActionEvent arg0){
		
		int tabIndex =	MainFrame.getInstance().getMainTabsParent().getSelectedIndex();
		String tableName = MainFrame.getInstance().getMainTabsParent().getTitleAt(tabIndex);
		
		TableController tableController = new TableController();
		String currTableName = null;
		
		if (MainFrame.getInstance().getTabelebyName(tableName).getReferences().size()<=1){

			TableSchema curTable = MainFrame.getInstance().getTabelebyName(tableName);
			String codeRef = curTable.getReference();
			currTableName = tableController.getNameByCode(codeRef);
			
			tableController.createParentTableView(tableController.getSelectedTable(currTableName));
			tableController.setChildren(tableController.getSelectedTable(currTableName));
		}
		else {
			DemoteDialog dd = new DemoteDialog();
		}
		if (currTableName !=null) {
			if (tableController.getSelectedTable(currTableName).getReferences().size() == 0 ){
				MainFrame.getInstance().getAction().getDemote().setEnabled(false);
			}
		}
		MainFrame.getInstance().getSplit2().resetToPreferredSizes();
		MainFrame.getInstance().getSplit2().setResizeWeight(1.0);
		MainFrame.getInstance().getSplit2().setDividerLocation(250);
		MainFrame.getInstance().getPanel().validate();
		MainFrame.getInstance().repaint();
		
		
	
	}

}
