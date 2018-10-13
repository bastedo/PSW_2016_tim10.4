package forms;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import app.MainFrame;
import forms.listener.OkDeleteListener;

/**
 * Klasa koja pravi dijalog za brisanje sa upitom za korisnika,i na osnovu klika na dugme OK vrsi pozivanje metode koja brise podatke u zavisnosti od uslova
 * @author Snezana Stevanovic
 *
 */

@SuppressWarnings("serial")
public class DeleteRowDialog extends JDialog {
	/**
	 * Atribut koji presdstavlja dugme akcije potvrde
	 */
	private JButton okButton = new JButton("OK");
	/**
	 * Atribut koji predstalja dugme akcije otkaza
	 */
	private JButton cancelButton = new JButton("Cancel");
	/**
	 * Konstruktor koji kao parametar prima da je selektovano u parent ili child tabeli
	 * @param isParent - true ili false,u zavisnosti sta je selektovano
	 */
	public DeleteRowDialog(boolean isParent) {
		setLocationRelativeTo(null);
		setModal(true);
		setResizable(false);
		setSize(300,100);
		setLayout(new BorderLayout());
		add(BorderLayout.CENTER, new JLabel("Da li ste sigurni da zelite da obrisete red?", SwingConstants.CENTER));

		JPanel buttonPanel = new JPanel(new FlowLayout());
		okButton.addKeyListener(new OkDeleteListener(isParent, this));
		okButton.addActionListener(new OkDeleteListener(isParent, this));
		cancelButton.addActionListener(new CancelListenerRow(this, isParent));
		cancelButton.addKeyListener(new CancelListenerRow(this, isParent));
		
		buttonPanel.add(okButton);
		buttonPanel.add(cancelButton);
		add(BorderLayout.SOUTH, buttonPanel);
		
	}
}
