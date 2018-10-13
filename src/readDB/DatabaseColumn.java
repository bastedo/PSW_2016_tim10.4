package readDB;
/**
 * Klasa koja obuhvata one detalje o podacima koji su potrebni za izvrsavanje operacija nad tim podacima
 * i njihovo slanje u bazu putem odovarajucih upita.
 * @author Boris Bogojevic
 */
public class DatabaseColumn {
	/**
	 * Atribut koji predstavlja kod kolone
	 */
	private String codeColumn;
	/**
	 * Atribut koji predstavlja koju vrednost poseduje ta kolona
	 */
	private String valueColumn;
	/**
	 * Atribut koji predstavlja koji je tip podatka koji se nalazi u ovoj koloni
	 */
	private String typeColumn;
	/**
	 * Konstruktor koji podesava inicijalne vrednosti
	 */
	public DatabaseColumn() {
		codeColumn = "";
		valueColumn = "";
		typeColumn = "";
	}
	/**
	 * Konstruktor koji podesava vrednosti na osnovu prosledjenih parametara
	 * @param code kod kolone
	 * @param value vrednost podatka
	 * @param type tip podatka
	 */
	public DatabaseColumn(String code, String value, String type){
		this.codeColumn = code;
		this.valueColumn = value;
		this.typeColumn = type;
	}
	/**
	 * Geter metoda
	 * @return kog je tipa podatak u koloni {INT, SMALLINT, DATETIME, NUMERIC, CHAR, VARCHAR, BIT}
	 */
	public String getTypeColumn() {
		return typeColumn;
	}
	/**
	 * Metoda koja podesava kog je tipa kolona
	 * @param typeColumn vrednost koju podesavamo za tip {INT, SMALLINT, DATETIME, NUMERIC, CHAR, VARCHAR, BIT}
	 */
	public void setTypeColumn(String typeColumn) {
		this.typeColumn = typeColumn;
	}
	/**
	 * Geter metoda
	 * @return kod kolone
	 */
	public String getCodeColumn() {
		return codeColumn;
	}
	/**
	 * Metoda koja podesava kod kolone
	 * @param codeColumn vrednost koja se dodejuje za kod kolone
	 */
	public void setCodeColumn(String codeColumn) {
		this.codeColumn = codeColumn;
	}
	/**
	 * Geter metoda
	 * @return vrednost koja se nalazi u koloni
	 */
	public String getValueColumn() {
		return valueColumn;
	}
	/**
	 * Metoda koja podesava vrednost koju ima podatak u koloni
	 * @param valueColumn vrednost koja treba da se podesi kao vrednost podatka
	 */
	public void setValueColumn(String valueColumn) {
		this.valueColumn = valueColumn;
	}
}
