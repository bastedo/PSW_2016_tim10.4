package forms.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import forms.LogoutDialog;


/**
 * Klasa koja omogucava otkazivanje odredjene akcije.
 * 
 *@author  Snezana Stevanovic
 */
public class CancelListener implements ActionListener, KeyListener{
	
	/**
	 * Naziv koji sluzi za jednoznacnu identifikaciju dugmeta za koji treba da se izvrsi akcija otkazivanja.
	 */
	private String name = "";
	
	/**
	 * Dijalog za odjavljivanje sa sistema.
	 */
	private LogoutDialog ld;
	/**
	 * Konstruktor.
	 * @param buttonName predstavlja naziv dugmeta na koji je kliknuto i u zavisnosti od toga obavljaju se razlicite akcije.
	 * @param ld dijalog za odjavljivanje sa sistema.
	 */
	public CancelListener(String buttonName, LogoutDialog ld) {
		name = buttonName;
		this.ld = ld;
	}
	
	/**
	 * Konstruktor.
	 * @param buttonName predstavlja naziv dugmeta na koji je kliknuto i u zavisnosti od toga obavljaju se razlicite akcije.
	 */
	public CancelListener(String buttonName){
		name = buttonName;
	}
	/**
	 * Metoda koja opisuje sta se dogadja na klik dugmeta kojem je dodeljen listener putem misa.
	 */
	public void actionPerformed(ActionEvent arg0) {
		if(name.equals("cancelLogin")) {
			System.exit(0);
		}
		else if(name.equals("cancelLogout")) {
			ld.dispose();
		}
	}
	/**
	 * Metoda koja predstavlja sta se dogadja na klik dugmeta kojem je dodeljen listener putem tastera.
	 */
	public void keyPressed(KeyEvent arg0) {
		if(name.equals("cancelLogin")) {
			System.exit(0);
		}
		else if(name.equals("cancelLogout")) {
			ld.dispose();
		}
	}

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
