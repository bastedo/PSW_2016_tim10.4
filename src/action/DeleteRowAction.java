package action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import forms.DeleteRowDialog;


/**
 * 
 * @author Snezana Stevanovic
 * 
 * Klasa unutar koje se realizuje akcija DeleteRow
 *
 */
@SuppressWarnings("serial")
public class DeleteRowAction extends CommonAction{

	private boolean isParent;
	/**
	 * Konstruktor unutar kog se uz pomoæ nasledjene klase {@code CommonAction} 
	 * dodeljuju sve vrednosti koje ovo dugme treba da poseduje.
	 */
	public DeleteRowAction(boolean isParent) {
		super( "Delete",
				"Delete", 
				KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK+ActionEvent.ALT_MASK),
				KeyEvent.VK_D,
				new ImageIcon("src/icons/delete.png"));
				this.setEnabled(false);
				this.isParent = isParent;
		// TODO Auto-generated constructor stub
	}
	
	public void actionPerformed(ActionEvent e){
		DeleteRowDialog delete = new DeleteRowDialog(isParent);
		delete.setVisible(true);
	}

}
