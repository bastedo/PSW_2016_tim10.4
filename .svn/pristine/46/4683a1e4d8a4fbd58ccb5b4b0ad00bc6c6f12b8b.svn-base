package action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import app.MainFrame;
import forms.AddRowDialog;

/**
 * 
 * @author Snezana Stevanovic
 * 
 * Klasa u okviru koje se realizuje izvrsavanje AddRow akcije
 *
 */
@SuppressWarnings("serial")
public class AddRowAction  extends CommonAction{
	private boolean isParent;
	/**
	 * Konstruktor unutar kog se uz pomoæ nasledjene klase {@code CommonAction} 
	 * dodeljuju sve vrednosti koje ovo dugme treba da poseduje.
	 */
	public AddRowAction(boolean isParent) {
		super(  "Add row",
				MainFrame.getInstance().getResourceBundle().getString("PARENTbtnAdd"), 
				KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK+ActionEvent.ALT_MASK),
				KeyEvent.VK_A,
				new ImageIcon("src/icons/addRow.png"));
				this.setEnabled(false);
				this.isParent = isParent;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		AddRowDialog dialog = new AddRowDialog(isParent);
		dialog.setVisible(true);
		
	}

}
