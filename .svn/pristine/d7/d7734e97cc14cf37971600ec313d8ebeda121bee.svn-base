package model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Klasa koja predstavlja model svih kolona jedne tabele
 * 
 * @author Snezana Stevanovic
 *
 */
public class Columns {

	private ArrayList<Column> columns;
	
	public Columns(){
		columns = new ArrayList<Column>();
	}

	public Columns(ArrayList<Column> col){
		super();
		this.columns = col;
	}
	
	/** GET I SET METODE**/
	public ArrayList<Column> getColumns() {
		return columns;
	}

	public Column getColumn(int index){
		return columns.get(index);
	}
	
	public void setColumns(ArrayList<Column> columns) {
		this.columns = columns;
	}
	
	
	//NASE METODE
	public int size(){
		return columns.size();
	}
	
	public void addColumn(Column c){
		columns.add(c);
	}
	
	public Iterator<Column> getIterator(){
		return columns.iterator();
	}
	
	public void removeAllColumns(){
		for (int i =0; i<columns.size(); i++){
			columns.removeAll(columns);
		}
	}

	public Column getColumnByCode(String code){
		Column column = new Column();
		for (Column c : columns) {
			if(c.getCode().equals(code)){
				column = c;
			}
		}
		return column;
	}
	
}
 