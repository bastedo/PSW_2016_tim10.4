package forms.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import app.MainFrame;
import forms.LoginDialog;
import forms.LogoutDialog;

/**
 * Klasa koja omogucava odjavljivanje korisnika sa sistema.
 * @author Snezana Stevanovic
 *
 */
public class OkLogoutListener implements ActionListener, KeyListener {
	
	/**
	 * Dijalog koji sadrzi elemente neophodne za odjavu sa sistema.
	 */
	private LogoutDialog ld;
	
	/**
	 * Konstruktor.
	 * @param ld dijalog za odjavu za sistema.
	 */
	public OkLogoutListener(LogoutDialog ld){
		this.ld = ld;
	}
	
	/**
	 * Metoda koja oogucava odjavu sa sistema.
	 * Obezbedjuje zatvaranje dijaloga za odjavu, kao i glavnog prozora aplikacije.
	 * Zatim se otvara dijalog za prijavu na sistem.
	 */
	public void logOut(){
		ld.dispose();
		MainFrame.getInstance().dispose();
		LoginDialog.setInstanceToNull();
		LoginDialog.getInstance().setVisible(true);
	}
	
	/**
	 * Metoda koja se poziva pri kliku na dugme za odjavu sa sistema.
	 */
	public void actionPerformed(ActionEvent arg0) {
		logOut();
	}
	
	/**
	 * Metoda koja se poziva pri kliku na taster Enter u dijalogu za odjavu sa sistema.
	 */
	public void keyPressed(KeyEvent arg0) {
		if(arg0.getKeyCode() == KeyEvent.VK_ENTER) 
			logOut();
	}

	public void keyReleased(KeyEvent arg0) {}

	public void keyTyped(KeyEvent arg0) {}

}
