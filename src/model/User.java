package model;
/**
 * Klasa koj predstavlja tabelu korisnika
 * Snezana Stevanovic
 */
public class User {
	/**
	 * Atribut koji predstavlja ime kosisnika
	 */
	private String firstName;
	/**
	 * Atribut koji predstavlja prezime kosisnika
	 */
	private String lastName;
	/**
	 * Atribut koji predstavlja korisnicko ime kosisnika
	 */
	private String username;
	/**
	 * Atribut koji predstavlja lozinku kosisnika
	 */
	private String password;
	/**
	 * Atribut koji predstavlja ulogu kosisnika {ADMIN ili USER}
	 */
	private String role; 
	/**
	 * Konstruktor unutar kog se vrsi pocetna inicijalizacija
	 */
	public User() {
		firstName = "";
		lastName = "";
		username = "";
		password = "";
		role = "";
	}
	/**
	 * Konstruktor unutar kog se vrsi inicijalizacija na osnovu prosledjenih parametara
	 * @param firstName ime korisnika
	 * @param lastName prezime korisnika
	 * @param username korisnicko ime korisnika
	 * @param password lozinka korisnika
	 * @param role uloga korisnika {ADMIN ili USER}
	 */
	public User(String firstName, String lastName, String username,
			String password, String role) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.role = role;
	}
	/**
	 * Geter metoda
	 * @return ime korisnika
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * Metoda koja podesava ime korisnika
	 * @param firstName vrednost koja treba da se dodeli za ime korisnika
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * Geter metoda
	 * @return prezime korisnika
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * Metoda koja podesava prezime korisnika
	 * @param lastName vrednost koja treda da se dodeli za prezime korisnika
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * Geter metoda
	 * @return korisnicko ime korisnika
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * Metoda koja podesava korisnicko ime korsicnika
	 * @param username vrednost koja treba da se dodeli za kotrisnicko ime
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * Geter metoda
	 * @return lozinku korisnika
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * Metoda koja podesava lozinku korisnika
	 * @param password vrednost koja treba da se podesi za lozinku
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * Geter metoda
	 * @return ulogu korisnika {ADMIN ili USER}
	 */
	public String getRole() {
		return role;
	}
	/**
	 * Metoda koja podesava ulogu korisnika
	 * @param role vrednost koja treba da se podesi { USER ili ADMIN}
	 */
	public void setRole(String role) {
		this.role = role;
	}
}
