<<<<<<< HEAD
package forms.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import model.User;
import model.Users;
import app.MainFrame;
import connection.ReadUsers;
import forms.LoginDialog;

/**
 * Klasa koja sadrzi metodu koja se poziva pri prijavi na sistem.
 * @author Snezana Stevanovic
 *
 */
@SuppressWarnings("deprecation")
public class OkLoginListener implements ActionListener, KeyListener  {
	
	/**
	 * Instanca klase koja omogucava citanje korisnika iz baze radi provere validnosti podataka koriscenih pri prijavi na sistem.
	 */
	private ReadUsers readUsers;
	/**
	 * Dijalog koji sadrzi polja i dugmad za prijavu na sistem.
	 */
	private LoginDialog loginDialog;
	/**
	 * Panel u kome se ispisuje greska pri prijavljivanju, ukoliko postoji.
	 */
	private JPanel errorPanel;
	/**
	 * Prijavljeni korisnik.
	 */
	public static User loggedUser;
	/**
	 * Polje koje oznacava da li se korisnik prijavio na sistem.
	 */
	public static boolean login = false;
	
	/**
	 * Konstruktor u kome se inicijalizuju atributi klase.
	 */
	public OkLoginListener() { 
		readUsers = new ReadUsers();
		loginDialog = LoginDialog.getInstance();
		errorPanel = LoginDialog.getInstance().getErrorPanel();
		loggedUser = new User();
		login = false;
	}
	
	/**
	 * Metoda koja se poziva prilikom klika na dugme za prijavljivanje na sistem.
	 * U ovoj metodi vrsi se provera validnosti unesenog korisnickog imena i odgovarajuce lozinke.
	 * U zavisnosti od ishoda validacije, korisnik se ili prijavljuje na sistem ili mu se ispisuje greska sa naznakom o tome u cemu je pogresio pri prijavi.
	 */
	private void logIn() {

		String username = LoginDialog.getInstance().getUsernameField().getText();
		String password = LoginDialog.getInstance().getPasswordField().getText();
		JLabel errorLoginUsernameAndPasswordEmpty = new JLabel(MainFrame.getInstance().getResourceBundle().getString("errorLoginUsernameAndPasswordEmpty"), SwingConstants.CENTER);
		JLabel errorLoginUsernameEmpty = new JLabel(MainFrame.getInstance().getResourceBundle().getString("errorLoginUsernameEmpty"), SwingConstants.CENTER);
		JLabel errorLoginPasswordEmpty = new JLabel(MainFrame.getInstance().getResourceBundle().getString("errorLoginPasswordEmpty"), SwingConstants.CENTER);
		JLabel errorLoginUsernameNotExist = new JLabel(MainFrame.getInstance().getResourceBundle().getString("errorLoginUsernameNotExist"), SwingConstants.CENTER);
		JLabel errorLoginPasswordWrong = new JLabel(MainFrame.getInstance().getResourceBundle().getString("errorLoginPasswordWrong"), SwingConstants.CENTER);
				
		if(username.equals("") || password.equals("")) {
			errorPanel.removeAll();
			if(username.equals("") && password.equals("")){
				errorPanel.add(errorLoginUsernameAndPasswordEmpty);
			} else if (username.equals("")){
				errorPanel.add(errorLoginUsernameEmpty);

			} else if (password.equals("")){
				errorPanel.add(errorLoginPasswordEmpty);
			}
			errorPanel.repaint();
			errorPanel.revalidate();
		}
		else { 
			Users users = readUsers.getListUsers();
			loggedUser = users.getUserByUsername(username);	
			if(!loggedUser.getUsername().equals("")) {
				if(loggedUser.getPassword().equals(password)){
						login = true;
						loginDialog.dispose();
						MainFrame.setInstanceToNull();
						MainFrame main = MainFrame.getInstance();
						main.setVisible(true);
					}
					else {
						errorPanel.removeAll();
						errorPanel.add(errorLoginPasswordWrong);
						errorPanel.repaint();
						errorPanel.revalidate();
					}
			} else {
				errorPanel.removeAll();
				errorPanel.add(errorLoginUsernameNotExist);
				errorPanel.repaint();
				errorPanel.revalidate();
			}
		}
	}
	
	/**
	 * Metoda koja se poziva pri kliku na dugme za prijavu.
	 */
	public void actionPerformed(ActionEvent arg0) {
		logIn();
	}

	/**
	 * Metoda koja se poziva pri kliku na taster Enter u dijalogu za prijavu na sistem.
	 */
	public void keyPressed(KeyEvent arg0) {
		if(arg0.getKeyCode() == KeyEvent.VK_ENTER) 
			logIn();
	}

	public void keyReleased(KeyEvent arg0) {}

	public void keyTyped(KeyEvent arg0) {}
}
=======
package forms.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import model.User;
import model.Users;
import app.MainFrame;
import connection.ReadUsers;
import forms.LoginDialog;

/**
 * Klasa koja sadrzi metodu koja se poziva pri prijavi na sistem.
 * @author Snezana Stevanovic
 *
 */
@SuppressWarnings("deprecation")
public class OkLoginListener implements ActionListener, KeyListener  {
	
	/**
	 * Instanca klase koja omogucava citanje korisnika iz baze radi provere validnosti podataka koriscenih pri prijavi na sistem.
	 */
	private ReadUsers readUsers;
	/**
	 * Dijalog koji sadrzi polja i dugmad za prijavu na sistem.
	 */
	private LoginDialog loginDialog;
	/**
	 * Panel u kome se ispisuje greska pri prijavljivanju, ukoliko postoji.
	 */
	private JPanel errorPanel;
	/**
	 * Prijavljeni korisnik.
	 */
	public static User loggedUser;
	/**
	 * Polje koje oznacava da li se korisnik prijavio na sistem.
	 */
	public static boolean login = false;
	
	/**
	 * Konstruktor u kome se inicijalizuju atributi klase.
	 */
	public OkLoginListener() { 
		readUsers = new ReadUsers();
		loginDialog = LoginDialog.getInstance();
		errorPanel = LoginDialog.getInstance().getErrorPanel();
		loggedUser = new User();
		login = false;
	}
	
	/**
	 * Metoda koja se poziva prilikom klika na dugme za prijavljivanje na sistem.
	 * U ovoj metodi vrsi se provera validnosti unesenog korisnickog imena i odgovarajuce lozinke.
	 * U zavisnosti od ishoda validacije, korisnik se ili prijavljuje na sistem ili mu se ispisuje greska sa naznakom o tome u cemu je pogresio pri prijavi.
	 */
	private void logIn() {

		String username = LoginDialog.getInstance().getUsernameField().getText();
		String password = LoginDialog.getInstance().getPasswordField().getText();
		JLabel errorLoginUsernameAndPasswordEmpty = new JLabel(MainFrame.getInstance().getResourceBundle().getString("errorLoginUsernameAndPasswordEmpty"), SwingConstants.CENTER);
		JLabel errorLoginUsernameEmpty = new JLabel(MainFrame.getInstance().getResourceBundle().getString("errorLoginUsernameEmpty"), SwingConstants.CENTER);
		JLabel errorLoginPasswordEmpty = new JLabel(MainFrame.getInstance().getResourceBundle().getString("errorLoginPasswordEmpty"), SwingConstants.CENTER);
		JLabel errorLoginUsernameNotExist = new JLabel(MainFrame.getInstance().getResourceBundle().getString("errorLoginUsernameNotExist"), SwingConstants.CENTER);
		JLabel errorLoginPasswordWrong = new JLabel(MainFrame.getInstance().getResourceBundle().getString("errorLoginPasswordWrong"), SwingConstants.CENTER);
				
		if(username.equals("") || password.equals("")) {
			errorPanel.removeAll();
			if(username.equals("") && password.equals("")){
				errorPanel.add(errorLoginUsernameAndPasswordEmpty);
			} else if (username.equals("")){
				errorPanel.add(errorLoginUsernameEmpty);

			} else if (password.equals("")){
				errorPanel.add(errorLoginPasswordEmpty);
			}
			errorPanel.repaint();
			errorPanel.revalidate();
		}
		else { 
			Users users = readUsers.getListUsers();
			loggedUser = users.getUserByUsername(username);	
			if(!loggedUser.getUsername().equals("")) {
				if(loggedUser.getPassword().equals(password)){
						login = true;
						loginDialog.dispose();
						MainFrame.setInstanceToNull();
						MainFrame main = MainFrame.getInstance();
						main.setVisible(true);
					}
					else {
						errorPanel.removeAll();
						errorPanel.add(errorLoginPasswordWrong);
						errorPanel.repaint();
						errorPanel.revalidate();
					}
			} else {
				errorPanel.removeAll();
				errorPanel.add(errorLoginUsernameNotExist);
				errorPanel.repaint();
				errorPanel.revalidate();
			}
		}
	}
	
	/**
	 * Metoda koja se poziva pri kliku na dugme za prijavu.
	 */
	public void actionPerformed(ActionEvent arg0) {
		logIn();
	}

	/**
	 * Metoda koja se poziva pri kliku na taster Enter u dijalogu za prijavu na sistem.
	 */
	public void keyPressed(KeyEvent arg0) {
		if(arg0.getKeyCode() == KeyEvent.VK_ENTER) 
			logIn();
	}

	public void keyReleased(KeyEvent arg0) {}

	public void keyTyped(KeyEvent arg0) {}
}
>>>>>>> origin/master
