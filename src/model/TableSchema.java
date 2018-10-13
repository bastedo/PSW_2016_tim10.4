package model;

import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.table.DefaultTableModel;

import app.MainFrame;

/**
 * Klasa koja predstavlja osnovne podatke o tabeli. Kolone, listu potomaka 
 * ime, kod, reference
 * 
 * @author Snezana Stevanovic
 * @author Boris Bogojevic
 *
 */

@SuppressWarnings("serial")
public class TableSchema{

	private Columns columns;
	private ArrayList<TableSchema> children; 
	private String name;
	private String code;
	private String reference;
	private ArrayList<String> tableNames;
	private String columnType;
	private ArrayList<String> references;
	private String localName;
	
	
	public TableSchema(){
		columns = new Columns();
		children = new ArrayList<>();
		name = "";
		code ="";
		reference = "";
		tableNames = new ArrayList<String>();
		references = new ArrayList<String>();
		columnType = "";
		localName = name.replace(" ", "");
	}

	public void	addColumns(Columns c){
		columns = c;
}

	public Columns getColumns() {
		return columns;
	}

	public void setColumns(Columns columns) {
		this.columns = columns;
	}

	public ArrayList<TableSchema> getChildren() {
		return children;
	}

	public void setChildren(ArrayList<TableSchema> children) {
		this.children = children;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public void addChild(TableSchema t){
		children.add(t);
	}

	public ArrayList<String> getTableNames() {
		return tableNames;
	}

	public void setTableNames(ArrayList<String> tableNames) {
		this.tableNames = tableNames;
	}
	
	
	public String getColumnType() {
		return columnType;
	}

	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public ArrayList<String> getReferences() {
		return references;
	}

	public void setReferences(ArrayList<String> references) {
		this.references = references;
	}

	public void addTableName(String name){
		tableNames.add(name);
	}
	
	public void addColumn(Column c){
		columns.addColumn(c);
	}
	
	public void removeAllColumns(){
			columns.removeAllColumns();
	}
	
	public TableSchema getTableByName(String code){
		TableSchema tableS = new TableSchema();
		tableS = MainFrame.getInstance().getTabele().get(code);
		return tableS;
		
	}
	
	public void addReference(String refer){
		references.add(refer);
	}
	public void localizeTableSchema(ResourceBundle resourceBundle){
		
		if(resourceBundle.containsKey(localName))
			name = resourceBundle.getString(localName);
		
		
		for (int i = 0; i<columns.size(); i++){
			columns.getColumn(i).localizeColumn(resourceBundle);
		}
	}

	/**
	 * @return the localName
	 */
	public String getLocalName() {
		return localName;
	}

	/**
	 * @param localName the localName to set
	 */
	public void setLocalName(String localName) {
		this.localName = localName;
	}
	
	
}
