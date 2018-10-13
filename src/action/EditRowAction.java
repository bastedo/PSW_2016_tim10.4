package action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

/**
 * 
 * @author Snezana Stevanovic
 * 
 * Klasa u okviru koje se realizuje izvrsavanje Edit akcije
 *
 */
@SuppressWarnings("serial")
public class EditRowAction extends CommonAction {

	/**
	 * Konstruktor unutar kog se uz pomoæ nasledjene klase {@code CommonAction} 
	 * dodeljuju sve vrednosti koje ovo dugme treba da poseduje.
	 */
	public EditRowAction() {
		super( "Edit",
				"Edit", 
				KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK+ActionEvent.ALT_MASK),
				KeyEvent.VK_E,
				new ImageIcon("src/icons/edit.png"));
				this.setEnabled(false);
		// TODO Auto-generated constructor stub
	}

}
