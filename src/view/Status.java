<<<<<<< HEAD
package view;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;

/**
 * Klasa koja predstavlja labelu koja s nalazi unutar status bara
 * @author Snezana Stevanovic
 */
@SuppressWarnings("serial")
public class Status extends JLabel{
	/**
	 * Inicijalizacija labele koja se nalazi unutar status bara
	 * @param text tekst koji treba da se ispiše unutar labele
	 */
	public Status(String text) {
		
		super(text);
		setHorizontalAlignment(CENTER);
		setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		setPreferredSize(new Dimension(200,25));
		
		
	}
}
=======
package view;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;

/**
 * Klasa koja predstavlja labelu koja s nalazi unutar status bara
 * @author Snezana Stevanovic
 */
@SuppressWarnings("serial")
public class Status extends JLabel{
	/**
	 * Inicijalizacija labele koja se nalazi unutar status bara
	 * @param text tekst koji treba da se ispiše unutar labele
	 */
	public Status(String text) {
		
		super(text);
		setHorizontalAlignment(CENTER);
		setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		setPreferredSize(new Dimension(200,25));
		
		
	}
}
>>>>>>> origin/master
