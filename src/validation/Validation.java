<<<<<<< HEAD
package validation;

/**
 * Klasa koja sadrzi metode za proveru tipova podataka.
 * @author Boris
 *
 */
public class Validation {
	
	/**
	 * Metoda za odredjivanje da li je prosledjeni string tipa "int".
	 * Pri pozivanju ove metode, takodje se proverava da li se string sastoji samo od space karaktera.
	 * Ukoliko je to slucaj, podatak nece biti validan.
	 * @param string predstavlja niz karaktera iz odgovarajuceg {@code JTextField} 
	 * 					polja za koje se vrsi provera.
	 * @return true ili false, u zavisnosti da li je string tipa "int" ili ne.
	 */
	public static boolean isInt(String string) {
		String str = string.trim();
			if(str.length() != 0) {
				if(string.matches("[1-9][0-9]*"))
					return true;
				return false;
			}
			else
				return false;
	}
		
	/**
	 * Metoda za odredjivanje da li je prosledjeni string tipa "numeric".
	 * Pri pozivanju ove metode, takodje se proverava da li se string sastoji samo od space karaktera.
	 * Ukoliko je to slucaj, podatak nece biti validan.
	 * @param string predstavlja niz karaktera iz odgovarajuceg {@code JTextField} 
	 * 					polja za koje se vrsi provera.
	 * @return true ili false, u zavisnosti da li je string tipa "numeric" ili ne.
	 */
	public static boolean isNumeric(String string) {
		String str = string.replace(",", ".");
		String str1 = str.trim();
		if(str1.length() != 0) {
			if(str.matches("[1-9][\\,\\d]*(.\\d+)?"))
				return true;
			return false;
		}
		else
			return false;
	}
	
	/**
	 * Metoda za odredjivanje da li je prosledjeni string tipa "char".
	 * Pri pozivanju ove metode, takodje se proverava da li se string sastoji samo od space karaktera.
	 * Ukoliko je to slucaj, podatak nece biti validan.
	 * @param string predstavlja niz karaktera iz odgovarajuceg {@code JTextField}
	 * 				 polja za koje se vrsi provera.
	 * @return true ili false, u zavisnosti da li je string tipa "char" ili ne.
	 */
	public static boolean isChar(String string) {
		String str = string.trim();
		if(str.length() != 0) {
			if(string.matches("([a-z]|[A-Z]|[0-9])\\w*"))
				return true;
			return false;
		}
		else
			return false;
	}
	
	/**
	 * Metoda za odredjivanje da li je prosledjeni string tipa "varchar".
	 * Posto podatak ovog tipa moze da sadrzi sve moguce karaktere, takodje je obezbedjena provera unosa space karaktera.
	 * Prosledjeni string nece proci validaciju ukoliko se sastoji samo od space karaktera.
	 * @param string predstavlja niz karaktera iz odgovarajuceg {@code JTextField} 
	 * 					polja za koje se vrsi provera.
	 * @return true ili false, u zavisnosti da li je string tipa "varchar" ili ne.
	 */
	public static boolean isVarchar(String string) {
		String str = string.trim();
		if(str.length() != 0)
			return true;
		else
			return false;
	}
	
	/**
	 * Metoda za odredjivanje da li je prosledjeni string koji je tipa "numeric" odgovarajuce duzine.
	 * @param string predstavlja niz karaktera iz odgovarajuceg {@code JTextField} polja za koje se vrsi provera.
	 * @param before broj cifara koji treba da se nadje ispred zareza.
	 * @return true ili false, u zavisnosti da li string odgovara duzini podatka ili ne.
	 */
	public static boolean isValidLengthNumeric(String string, String before) {
		string = string.replace(",", ".");
		if(string.contains("."))
			if(Integer.parseInt(before) >= string.split("\\.")[0].length())
				return true;
			else
				return false;
		else
			if(Integer.parseInt(before) >= string.length())
				return true;
		return false;
	}
	
	/**
	 * Metoda za odredjivanje da li je prosledjeni string koji je tipa "char" odgovarajuce duzine.
	 * @param string predstavlja niz karaktera iz odgovarajuceg {@code JTextField} polja za koje se vrsi provera.
	 * @param desiredLength broj karaktera kojem treba da odgovara broj karaktera prosledjenog string-a.
	 * @return true ili false, u zavisnosti da li string odgovara duzini podataka ili ne.
	 */
	public static boolean isValidLengthChar(String string, String desiredLength) {
		if(string.length() == Integer.parseInt(desiredLength))
			return true;
		return false;
	}
	
	/**
	 * Metoda za odredjivanje da li je prosledjeni string koji je tipa "varchar" odgovarajuce duzine.
	 * @param string predstavlja niz karaktera iz odgovarajuceg {@code JTextField} polja za koje se vrsi provera.
	 * @param desiredLength broj karaktera kojem treba da odgovara broj karaktera prosledjenog string-a.
	 * @return true ili false, u zavisnosti da li string odgovara duzini podataka ili ne.
	 */
	public static boolean isValidLengthVarchar(String string, String desiredLength) {
		if(string.length() <= Integer.parseInt(desiredLength))
			return true;
		return false;
	}

}
=======
package validation;

/**
 * Klasa koja sadrzi metode za proveru tipova podataka.
 * @author Boris
 *
 */
public class Validation {
	
	/**
	 * Metoda za odredjivanje da li je prosledjeni string tipa "int".
	 * Pri pozivanju ove metode, takodje se proverava da li se string sastoji samo od space karaktera.
	 * Ukoliko je to slucaj, podatak nece biti validan.
	 * @param string predstavlja niz karaktera iz odgovarajuceg {@code JTextField} 
	 * 					polja za koje se vrsi provera.
	 * @return true ili false, u zavisnosti da li je string tipa "int" ili ne.
	 */
	public static boolean isInt(String string) {
		String str = string.trim();
			if(str.length() != 0) {
				if(string.matches("[1-9][0-9]*"))
					return true;
				return false;
			}
			else
				return false;
	}
		
	/**
	 * Metoda za odredjivanje da li je prosledjeni string tipa "numeric".
	 * Pri pozivanju ove metode, takodje se proverava da li se string sastoji samo od space karaktera.
	 * Ukoliko je to slucaj, podatak nece biti validan.
	 * @param string predstavlja niz karaktera iz odgovarajuceg {@code JTextField} 
	 * 					polja za koje se vrsi provera.
	 * @return true ili false, u zavisnosti da li je string tipa "numeric" ili ne.
	 */
	public static boolean isNumeric(String string) {
		String str = string.replace(",", ".");
		String str1 = str.trim();
		if(str1.length() != 0) {
			if(str.matches("[1-9][\\,\\d]*(.\\d+)?"))
				return true;
			return false;
		}
		else
			return false;
	}
	
	/**
	 * Metoda za odredjivanje da li je prosledjeni string tipa "char".
	 * Pri pozivanju ove metode, takodje se proverava da li se string sastoji samo od space karaktera.
	 * Ukoliko je to slucaj, podatak nece biti validan.
	 * @param string predstavlja niz karaktera iz odgovarajuceg {@code JTextField}
	 * 				 polja za koje se vrsi provera.
	 * @return true ili false, u zavisnosti da li je string tipa "char" ili ne.
	 */
	public static boolean isChar(String string) {
		String str = string.trim();
		if(str.length() != 0) {
			if(string.matches("([a-z]|[A-Z]|[0-9])\\w*"))
				return true;
			return false;
		}
		else
			return false;
	}
	
	/**
	 * Metoda za odredjivanje da li je prosledjeni string tipa "varchar".
	 * Posto podatak ovog tipa moze da sadrzi sve moguce karaktere, takodje je obezbedjena provera unosa space karaktera.
	 * Prosledjeni string nece proci validaciju ukoliko se sastoji samo od space karaktera.
	 * @param string predstavlja niz karaktera iz odgovarajuceg {@code JTextField} 
	 * 					polja za koje se vrsi provera.
	 * @return true ili false, u zavisnosti da li je string tipa "varchar" ili ne.
	 */
	public static boolean isVarchar(String string) {
		String str = string.trim();
		if(str.length() != 0)
			return true;
		else
			return false;
	}
	
	/**
	 * Metoda za odredjivanje da li je prosledjeni string koji je tipa "numeric" odgovarajuce duzine.
	 * @param string predstavlja niz karaktera iz odgovarajuceg {@code JTextField} polja za koje se vrsi provera.
	 * @param before broj cifara koji treba da se nadje ispred zareza.
	 * @return true ili false, u zavisnosti da li string odgovara duzini podatka ili ne.
	 */
	public static boolean isValidLengthNumeric(String string, String before) {
		string = string.replace(",", ".");
		if(string.contains("."))
			if(Integer.parseInt(before) >= string.split("\\.")[0].length())
				return true;
			else
				return false;
		else
			if(Integer.parseInt(before) >= string.length())
				return true;
		return false;
	}
	
	/**
	 * Metoda za odredjivanje da li je prosledjeni string koji je tipa "char" odgovarajuce duzine.
	 * @param string predstavlja niz karaktera iz odgovarajuceg {@code JTextField} polja za koje se vrsi provera.
	 * @param desiredLength broj karaktera kojem treba da odgovara broj karaktera prosledjenog string-a.
	 * @return true ili false, u zavisnosti da li string odgovara duzini podataka ili ne.
	 */
	public static boolean isValidLengthChar(String string, String desiredLength) {
		if(string.length() == Integer.parseInt(desiredLength))
			return true;
		return false;
	}
	
	/**
	 * Metoda za odredjivanje da li je prosledjeni string koji je tipa "varchar" odgovarajuce duzine.
	 * @param string predstavlja niz karaktera iz odgovarajuceg {@code JTextField} polja za koje se vrsi provera.
	 * @param desiredLength broj karaktera kojem treba da odgovara broj karaktera prosledjenog string-a.
	 * @return true ili false, u zavisnosti da li string odgovara duzini podataka ili ne.
	 */
	public static boolean isValidLengthVarchar(String string, String desiredLength) {
		if(string.length() <= Integer.parseInt(desiredLength))
			return true;
		return false;
	}

}
>>>>>>> origin/master
