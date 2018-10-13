package forms;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import model.User;
import app.MainFrame;
import forms.listener.CancelListener;
import forms.listener.OkLoginListener;
/**
 * Klasa koja kreira dijalog koji se koristi za prijavu na sistem.
 * 
 *
 */
@SuppressWarnings("serial")
public class LoginDialog extends JDialog {
	/**
	 * Instanca dijaloga za prijavu na sistem.
	 */
	public static LoginDialog instance = null;
	/**
	 * Panel u kome se nalazi forma koja obezbedjuje prijavu na sistem.
	 */
	private JPanel panel = new JPanel(new BorderLayout());
	/**
	 * Tekstualno polje za unos korisnickog imena pri prijavi.
	 */
	private JTextField usernameField = new JTextField(30);
	/**
	 * Tekstualno polje za unos lozinke pri prijavi.
	 */
	private JPasswordField passwordField = new JPasswordField(30);
	/**
	 * Panel u koji se ispisuju greske pri prijavi na sistem.
	 */
	private JPanel errorPanel = new JPanel();
	/**
	 * Meni koji obezbedjuje promenu jezika prilikom prijave na sistem.
	 */
	//private ChangeLanguageMenu changeLanguage;
	/**
	 * Dugme na ciji klik zapocinje akcija prijavljivanja na sistem.
	 */
	private JButton btnOk;
	/**
	 * Dugme na ciji klik se otkazuje akcija prijavljivanja na sistem i izlazi se iz aplikacije.
	 */
	private JButton btnCancel;
	/**
	 * Labela za identifikaciju tekstualnog polja za unos korisnickog imena.
	 */
	private JLabel unLabel;
	/**
	 * Labela za identifikaciju tekstualnog polja za unos lozinke.
	 */
	private JLabel pwLabel;
	/**
	 * Labela koja sadrzi naslov dijaloga za prijavu.
	 */
	private JLabel languageLabel;
	/**
	 * Meni bar dijaloga u kome se nalazi opcija izmene jezika.
	 */
	private JMenuBar menuBar;
	
	/**
	 * Konstruktor.
	 */
	public LoginDialog() {
		instance = null;
		OkLoginListener.login = false;
		OkLoginListener.loggedUser = new User();
	}
	
	/**
	 * Metoda koja vrsi inicijalizaciju dijaloga za prijavu.
	 * U ovoj metodi se takodje vrsi provera validnosti unesenog korisnickog imena i lozinke.
	 * Ukoliko se ispostavi da je korisnik uneo neki nevalidan podatak, ispisuje mu se greska sa tacnom naznakom o tome u cemu je greska.
	 * Kada korisnik unese validne podatke, korisnik se prijavljuje na sistem i otvara se glavni prozor aplikacije. 
	 */
	public void initialise() {
		
		setLayout(new BorderLayout());
		setSize(new Dimension(550, 250));
		setResizable(false);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle(MainFrame.getInstance().getResourceBundle().getString("title"));
//		setIconImage(MainFrame.getInstance().getTk().getImage(getClass().getResource("icons/logo.png")));

		
		menuBar = new JMenuBar();
//		changeLanguage = new ChangeLanguageMenu();
//		menuBar.add(changeLanguage);
		setJMenuBar(menuBar);
		
//		languageLabel = new JLabel(MainFrame.getInstance().getResourceBundle().getString("loginLabel"), SwingConstants.CENTER);
		
//		add(BorderLayout.NORTH, languageLabel);
		
		JPanel mainPanel = new JPanel();
		JPanel unPanel = new JPanel();
		JPanel pwPanel = new JPanel();
		JPanel btnPanel = new JPanel();
		
		unLabel = new JLabel(MainFrame.getInstance().getResourceBundle().getString("loginUsername"));
		pwLabel = new JLabel(MainFrame.getInstance().getResourceBundle().getString("loginPassword"));
		pwLabel.setSize(new Dimension(50,50));
		btnOk = new JButton(MainFrame.getInstance().getResourceBundle().getString("loginButtonOK"));
		btnCancel = new JButton(MainFrame.getInstance().getResourceBundle().getString("loginButtonCancel"));
		
		usernameField.setMargin(new Insets(2, 2, 2, 2));
		usernameField.addKeyListener(new OkLoginListener());
		passwordField.setMargin(new Insets(2, 2, 2, 2));
		passwordField.addKeyListener(new OkLoginListener());
		
		unPanel.add(unLabel);
		unPanel.add(usernameField);
		
		pwPanel.add(pwLabel);
		pwPanel.add(passwordField);
		
		btnOk.addActionListener(new OkLoginListener());
		btnOk.addKeyListener(new OkLoginListener());
		btnCancel.addActionListener(new CancelListener("cancelLogin"));
		btnCancel.addKeyListener(new CancelListener("cancelLogin"));
		
		btnPanel.add(btnOk);
		btnPanel.add(btnCancel);
		
		mainPanel.add(unPanel);
		mainPanel.add(pwPanel);
		mainPanel.add(btnPanel);
		
		panel.add(BorderLayout.CENTER, mainPanel);
		panel.add(BorderLayout.SOUTH, errorPanel);
		
		add(BorderLayout.CENTER, panel);
	}
	
	/**
	 * Inicijalizacija komponenti pri promeni jezika.
	 */
	public void initComponents(){
		
		unLabel.setText(MainFrame.getInstance().getResourceBundle().getString("loginUsername"));
	    pwLabel.setText(MainFrame.getInstance().getResourceBundle().getString("loginPassword"));
	    btnOk.setText(MainFrame.getInstance().getResourceBundle().getString("loginButtonOK"));
	    btnCancel.setText(MainFrame.getInstance().getResourceBundle().getString("loginButtonCancel"));
	    
	//    changeLanguage.setText(MainFrame.getInstance().getResourceBundle().getString("changeLanguage"));
	    languageLabel.setText(MainFrame.getInstance().getResourceBundle().getString("loginLabel"));
	    
	    setTitle(MainFrame.getInstance().getResourceBundle().getString("loginTitle"));
	    
	 //   changeLanguage.initComponents(true);
	}
	
	/**
	 * Metoda koja poziva metodu za inicijalizaciju dijaloga za prijavu.
	 * Ukoliko data instanca ne postoji, pravi novu. U suprotnom, vraca onu koja je vec kreirana.
	 * @return instancu dijaloga.
	 */
	public static LoginDialog getInstance() {
		if(instance == null) {
			instance = new LoginDialog();
			instance.initialise();
		}
		
		return instance;
	}
	
	public static void setInstanceToNull(){
		instance = null;
	}
	
	public JPanel getErrorPanel() {
		return errorPanel;
	}
	
	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JTextField getUsernameField() {
		return usernameField;
	}

	public void setUsernameField(JTextField usernameField) {
		this.usernameField = usernameField;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}
	
}
