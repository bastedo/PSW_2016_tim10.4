package connection;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import app.MainFrame;
/**
 * Klasa koja omogucava konekciju sa bazom.
 * @author Snezana
 */
public class DBConnection   {
	/**
	 * Atribut koji predstavlja instancu klase preko koje se konektujemo na bazu
	 */
	public static DBConnection instance; 
	/**
	 * Atribut koji predstavlja konekciju
	 */
	public static Connection conn;      
	/**
	 * Atribut koji predstavlja korisnicko ime tima
	 */
	private String userName = "psw-2016-tim10-4";       
	/**
	 * Atribut koji predstavlja lozinku tima
	 */
	private String password = "tim10-415136969";        
	/**
	 * Atribut koji predstavlja ipAdresu pomocu koje se konektujemo
	 */
	private String ipAdress = "147.91.175.155"; 	
	  
	/**
	 * Metoda koja vraca instancu klase
	 * @return {@code DBConnection} koja predstavlja instancu klase
	 */
	public static DBConnection getInstance() {     
		
		if(instance == null) {                     
			instance = new DBConnection();
			instance.initConnection();       
		}
		return instance;              
	}
	
	/**
	 * Metoda koja inicijalizuje i kreira konekciju
	 * @throws Exception ukoliko je nemoguce izvrsiti konekciju sa bazom
	 */
	private  void initConnection() {           
		
		try {
				Class.forName("net.sourceforge.jtds.jdbc.Driver");
				String url = "jdbc:jtds:sqlserver://147.91.175.155:1433/psw-2016-tim10-4";  // promenljiva url definise server i naziv
				DriverManager.setLoginTimeout(3);
				conn = DriverManager.getConnection(url, userName, password);  // kreiranje konekcije
		} catch(Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getMessage()); 
		}
	}
	/**
	 * Metoda koja vraca kreiranu instancu konekcije
	 * @return {@code Connection} koja predtsavlja instancu klase
	 */
	
	public  Connection getConnection() {
		return conn;
	}

}
