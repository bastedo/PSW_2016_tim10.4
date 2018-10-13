package model;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * Klasa koja predstavlja listu korisnika 
 * @author  Snezana Stevanovic
 */
@SuppressWarnings("serial")
public class Users implements Serializable {
	/**
	 * Atribut koji predstavlja listu korisnika
	 */
	private ArrayList<User> listUser;
	/**
	 * Konstruktor unutar kog se vrsi inicijalizacija
	 */
	public Users() {
		listUser = new ArrayList<User>();
	}
	/**
	 * Konstruktor unutar kog se na osnovu prosledjenih parametara vrsi inicijalizacija
	 * @param users lista korisnika
	 */
	public Users(ArrayList<User> users){
		super();
		this.listUser = users;
	}
	/**
	 * Geter metoda
	 * @param index na osnovu kog se pronalzi korisnik
	 * @return pronadjenog korisnika
	 */
	public User getUser(int index){
		return listUser.get(index);
	}
	/**
	 * Geter metoda
	 * @return listu svih korisnika
	 */
	public ArrayList<User> getUsers() {
		return listUser;
	}
	/**
	 * Metoda unutar koje se vrsi dodavanje korisnika
	 * @param user koji treba da se doda u listu
	 */
	public void addUser(User user){
		if(user != null)
			listUser.add(user);
	}
	/**
	 * Metoda unutar koje se vrsi pronalazenje korisnika na od=snovu prosledjenih parametara
	 * @param username na osnovu kog se vrsi pretraga
	 * @return pronadjenog korisnika
	 */
	public User getUserByUsername(String username) {
		User user = new User();
		for(int i = 0; i < listUser.size(); i++){
			if(listUser.get(i).getUsername().equals(username)){
				user = listUser.get(i);
				break;
			}
		}
		return user;
	}
}
