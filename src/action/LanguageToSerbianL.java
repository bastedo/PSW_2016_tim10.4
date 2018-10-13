package action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import app.MainFrame;

/**
 * 
 * @author Boris Bogojevic
 * 
 * Klasa u okviru koje se realizuje izvrsavanje akcije promene jezika u Srpski (latinicu)
 *
 */
@SuppressWarnings("serial")
public class LanguageToSerbianL extends CommonAction {

	/**
	 * Konstruktor unutar kog se uz pomoæ nasledjene klase {@code CommonAction} 
	 * dodeljuju sve vrednosti koje ovo dugme treba da poseduje.
	 */
	public LanguageToSerbianL() {
		super( "Serbian",
				"Serbian", 
				KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK+ActionEvent.ALT_MASK),
				KeyEvent.VK_E,
				new ImageIcon("src/icons/edit.png"));
		// TODO Auto-generated constructor stub
	}
	public void actionPerformed(ActionEvent e){
		MainFrame.getInstance().changeLanguage(new Locale("sr","BA"));
		MainFrame.getInstance().validate();
		MainFrame.getInstance().repaint();
	}

}
