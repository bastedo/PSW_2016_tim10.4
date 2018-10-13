<<<<<<< HEAD
package action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.KeyStroke;

import app.MainFrame;
import controller.JsonParser;
import model.TableSchema;

/**
 * 
 * @author Boris Bogojevic
 * 
 * Klasa u okviru koje se realizuje izvrsavanje akcije promene jezika u Engleski
 *
 */
@SuppressWarnings("serial")
public class LanguageToEnglish extends CommonAction {

	/**
	 * Konstruktor unutar kog se uz pomoæ nasledjene klase {@code CommonAction} 
	 * dodeljuju sve vrednosti koje ovo dugme treba da poseduje.
	 */
	public LanguageToEnglish() {
		super( "English",
				"English", 
				KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK+ActionEvent.ALT_MASK),
				KeyEvent.VK_E,
				new ImageIcon("src/icons/edit.png"));
		// TODO Auto-generated constructor stub
	}
	public void actionPerformed(ActionEvent e){
		MainFrame.getInstance().changeLanguage(new Locale("en","US"));
		System.out.println("akcija");
		MainFrame.getInstance().validate();
		MainFrame.getInstance().repaint();
	}

}
=======
package action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.KeyStroke;

import app.MainFrame;
import controller.JsonParser;
import model.TableSchema;

/**
 * 
 * @author Boris Bogojevic
 * 
 * Klasa u okviru koje se realizuje izvrsavanje akcije promene jezika u Engleski
 *
 */
@SuppressWarnings("serial")
public class LanguageToEnglish extends CommonAction {

	/**
	 * Konstruktor unutar kog se uz pomoæ nasledjene klase {@code CommonAction} 
	 * dodeljuju sve vrednosti koje ovo dugme treba da poseduje.
	 */
	public LanguageToEnglish() {
		super( "English",
				"English", 
				KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK+ActionEvent.ALT_MASK),
				KeyEvent.VK_E,
				new ImageIcon("src/icons/edit.png"));
		// TODO Auto-generated constructor stub
	}
	public void actionPerformed(ActionEvent e){
		MainFrame.getInstance().changeLanguage(new Locale("en","US"));
		System.out.println("akcija");
		MainFrame.getInstance().validate();
		MainFrame.getInstance().repaint();
	}

}
>>>>>>> origin/master
