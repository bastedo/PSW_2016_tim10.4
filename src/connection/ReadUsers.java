package connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.User;
import model.Users;
import app.MainFrame;
/**
 * Klasa unutar koje se vrsi iscitavanje korisnika iz baze
 * 
 */
public class ReadUsers {
	/**
	 * Atribut koji predstavlja konekciju sa bazom.
	 */
	private Connection conn;
	/**
	 * Atribut koji predstavlja listu korisnika.
	 */
	private Users listUsers;
	/**
	 * Konstruktor unutar kog se vrsi iscitavanje korisnika iz baze
	 */
	public ReadUsers(){
		
		listUsers = new Users();
		conn = DBConnection.getInstance().getConnection();
		try {
			Statement stm = conn.createStatement();
			ResultSet res = stm.executeQuery("select * from korisnici");
			
			while(res.next()){
				String firstName = res.getString(1);
				String lastName = res.getString(2);
				String username = res.getString(3);
				String password = res.getString(4);
				String role = res.getString(5);
				listUsers.addUser(new User(firstName, lastName, username, password, role));
			}
			
		} catch(Exception e) {
			JOptionPane.showMessageDialog(new JFrame(),"Greska prilikom logovanja");
			System.exit(0);
		}
	}
	/**
	 * Mastoda koja vraca listu iscitanih korisnika iz baze
	 * @return listu korisnika
	 */
	public Users getListUsers() {
		return listUsers;
	}

	
}
