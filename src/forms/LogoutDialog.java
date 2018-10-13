package forms;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import app.MainFrame;
import forms.listener.CancelListener;
import forms.listener.OkLoginListener;
import forms.listener.OkLogoutListener;

/**
 * Klasa koja omogucuje odjavljivanje sa sistema i prijavljivanje sa drugim korisnickim imenom ili izlazak iz aplikacije.
 * 
 *
 */
@SuppressWarnings("serial")
public class LogoutDialog extends JDialog {

	/**
	 * Instanca dijaloga za odjavu.
	 */
	public static LogoutDialog instance = null;
	/**
	 * Labela koja obezbedjuje ispis poruke pri odjavi sa sistema.
	 */
	private JLabel message;
	/**
	 * Panel koji sadrzi labelu za ispis poruke o odjavi sa sistema i dugmad za rukovanje datom akcijom.
	 */
	private JPanel panel;
	/**
	 * Dugme koje omogucuje odjavu sa sistema.
	 */
	private JButton logoutBtn;
	/**
	 * Dugme koje omogucuje otkazivanje odjave sa sistema.
	 */
	private JButton cancelBtn;
	/**
	 * Panel u kome se nalaze dugmad za rukovanje akcijom odjave sa sistema.
	 */
	private JPanel buttonPanel;
	
	/**
	 * Konstruktor.
	 * Ovde se vrsi inicijalizacija komponenti koje se nalaze u dijalogu za odjavu sa sistema.
	 */
	public LogoutDialog() {
		
		setLayout(new BorderLayout());
		setTitle(MainFrame.getInstance().getResourceBundle().getString("logoutDialog"));
		setSize(new Dimension(500, 120));
		setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		setIconImage(MainFrame.getInstance().getTk().getImage(getClass().getResource("icons/logo.png")));
		setLocationRelativeTo(null);
		
		panel = new JPanel(new BorderLayout());
		buttonPanel = new JPanel();
		message = new JLabel(OkLoginListener.loggedUser.getFirstName() 
							 + MainFrame.getInstance().getResourceBundle().getString("logoutMessage")
							,SwingConstants.CENTER);
		logoutBtn = new JButton(MainFrame.getInstance().getResourceBundle().getString("logout"));
		cancelBtn = new JButton(MainFrame.getInstance().getResourceBundle().getString("loginButtonCancel"));
		cancelBtn.addActionListener(new CancelListener("cancelLogout",this));
		cancelBtn.addKeyListener(new CancelListener("cancelLogout",this));
		logoutBtn.addActionListener(new OkLogoutListener(this));
		logoutBtn.addKeyListener(new OkLogoutListener(this));
		buttonPanel.add(logoutBtn);
		buttonPanel.add(cancelBtn);
		panel.add(message, BorderLayout.CENTER);
		panel.add(buttonPanel, BorderLayout.SOUTH);
		add(BorderLayout.CENTER, panel);
	}


}
