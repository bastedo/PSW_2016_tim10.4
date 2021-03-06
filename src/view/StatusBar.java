<<<<<<< HEAD
package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import model.User;
import app.MainFrame;
import forms.listener.OkLoginListener;
/**
 * Klasa koja predstavlja status bar aplikacije
 * @author Snezana Stevanovic
 */
@SuppressWarnings("serial")
public class StatusBar extends JPanel {
	/**
	 * Atribut koji predstavlja datum
	 */
	private Status dateAndTime;
	/**
	 * Atribut koji predstavlja korisnicko ime treutno prijavljenog korisnika
	 */
	private Status username;
	/**
	 * Atribut koji predstavlja korisnika koji je treb+nutno prijavljen
	 */
	private User loggedUser;
	/**
	 * Atribut koji predstavlja ime korisnika
	 */
	private String userName;
	/**
	 * Konstruktor unutar kog se vr�i inicijalizacija i prikaz 
	 * komponenti koje se nalaze u status baru
	 */
	public StatusBar() {
		
		setLayout(new GridLayout(1,2,5,5));
		setBackground(Color.lightGray);
		setBorder(BorderFactory.createLineBorder(Color.darkGray));
		
		DateFormat df = DateFormat.getDateInstance();
		String datum = df.format(new Date());
		
		loggedUser = OkLoginListener.loggedUser;
		userName = loggedUser.getFirstName() + " " + loggedUser.getLastName();
		
		dateAndTime = new Status(datum);
		username = new Status(MainFrame.getInstance().getResourceBundle().getString("loginUser") 
					+ " " + userName);
		
		add(dateAndTime);
		add(username);
		
	}

	/**
	 * Metoda unutar koje se vr�i inicijalizacija 
	 * komponenti koje se menjaju prilikom promene jezika.
	 */
	public void initComponents() {
		
		DateFormat df = DateFormat.getDateInstance();
		String datum = df.format(new Date());
		
		dateAndTime.setText(datum);
		
		username.setText(MainFrame.getInstance().getResourceBundle().getString("loginUser")+ userName);
		
	}
	/**
	 * Geter metoda
	 * @return trenutni datum
	 */
	public Status getDateAndTime() {
		return dateAndTime;
	}
	/**
	 * Metoda koja podesava datum
	 * @param dateAndTime vrednost koju treba da podesi za datum
	 */
	public void setDateAndTime(Status dateAndTime) {
		this.dateAndTime = dateAndTime;
	}
	/**
	 * Geter metoda
	 * @return korisnicko ime korisnika
	 */
	public Status getUsername() {
		return username;
	}
	/**
	 * Metoda koja podesava korisnicko ime korisnika
	 * @param username vrednost koja treba da se podesi
	 */
	public void setUsername(Status username) {
		this.username = username;
	}
	
	public void localizeStatusBar(ResourceBundle resourceBundle){
		DateFormat sdf = SimpleDateFormat.getInstance() ;
		String datum = sdf.format(new Date());
		dateAndTime.setText(datum);
		username.setText(MainFrame.getInstance().getResourceBundle().getString("loginUser") 
					+ " " + userName);

		
	}
}
=======
package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import model.User;
import app.MainFrame;
import forms.listener.OkLoginListener;
/**
 * Klasa koja predstavlja status bar aplikacije
 * @author Snezana Stevanovic
 */
@SuppressWarnings("serial")
public class StatusBar extends JPanel {
	/**
	 * Atribut koji predstavlja datum
	 */
	private Status dateAndTime;
	/**
	 * Atribut koji predstavlja korisnicko ime treutno prijavljenog korisnika
	 */
	private Status username;
	/**
	 * Atribut koji predstavlja korisnika koji je treb+nutno prijavljen
	 */
	private User loggedUser;
	/**
	 * Atribut koji predstavlja ime korisnika
	 */
	private String userName;
	/**
	 * Konstruktor unutar kog se vr�i inicijalizacija i prikaz 
	 * komponenti koje se nalaze u status baru
	 */
	public StatusBar() {
		
		setLayout(new GridLayout(1,2,5,5));
		setBackground(Color.lightGray);
		setBorder(BorderFactory.createLineBorder(Color.darkGray));
		
		DateFormat df = DateFormat.getDateInstance();
		String datum = df.format(new Date());
		
		loggedUser = OkLoginListener.loggedUser;
		userName = loggedUser.getFirstName() + " " + loggedUser.getLastName();
		
		dateAndTime = new Status(datum);
		username = new Status(MainFrame.getInstance().getResourceBundle().getString("loginUser") 
					+ " " + userName);
		
		add(dateAndTime);
		add(username);
		
	}

	/**
	 * Metoda unutar koje se vr�i inicijalizacija 
	 * komponenti koje se menjaju prilikom promene jezika.
	 */
	public void initComponents() {
		
		DateFormat df = DateFormat.getDateInstance();
		String datum = df.format(new Date());
		
		dateAndTime.setText(datum);
		
		username.setText(MainFrame.getInstance().getResourceBundle().getString("loginUser")+ userName);
		
	}
	/**
	 * Geter metoda
	 * @return trenutni datum
	 */
	public Status getDateAndTime() {
		return dateAndTime;
	}
	/**
	 * Metoda koja podesava datum
	 * @param dateAndTime vrednost koju treba da podesi za datum
	 */
	public void setDateAndTime(Status dateAndTime) {
		this.dateAndTime = dateAndTime;
	}
	/**
	 * Geter metoda
	 * @return korisnicko ime korisnika
	 */
	public Status getUsername() {
		return username;
	}
	/**
	 * Metoda koja podesava korisnicko ime korisnika
	 * @param username vrednost koja treba da se podesi
	 */
	public void setUsername(Status username) {
		this.username = username;
	}
	
	public void localizeStatusBar(ResourceBundle resourceBundle){
		DateFormat sdf = SimpleDateFormat.getInstance() ;
		String datum = sdf.format(new Date());
		dateAndTime.setText(datum);
		username.setText(MainFrame.getInstance().getResourceBundle().getString("loginUser") 
					+ " " + userName);

		
	}
}
>>>>>>> origin/master
