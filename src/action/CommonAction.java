package action;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

/**
 *  Klasa unutar koje se vrsi postavljanje vrednosti atributa 
 *  koji ce se morati dodeljivati unutar svake akcije
 *  @author Snezana Stevanovic
 */

@SuppressWarnings("serial")
public abstract class CommonAction extends AbstractAction {
	/**
	 * Kostruktor unutar kog se vrsi dodela vrednosti prosledjenih parametara. 
	 * @param name element koji dodeljuje ime 
	 * @param description element pomocu kod postavljamo opis
	 * @param ks element uz pomoæ kog postavljamo akcelerator
	 * @param mk element uz pomoæ kog postavljamo mnemonik
	 * @param image element uz pomoæ kog postavljamo ikonicu
	 */

	public CommonAction(String name, String description, KeyStroke ks, int mk, ImageIcon image) {
		// TODO Auto-generated method stub
		putValue(NAME, name);
		putValue(SHORT_DESCRIPTION, description);
		putValue(ACCELERATOR_KEY, ks);
		putValue(MNEMONIC_KEY, mk);
		putValue(SMALL_ICON, image);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
	}
}
