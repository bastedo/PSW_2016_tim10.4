package model;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.ResourceBundle;

import javax.swing.ListSelectionModel;
import javax.swing.event.TableColumnModelListener;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;


/**
 * 
 * @author Snezana Stevanovic
 * Klasa koja predstavlja model jedne kolone u tabeli
 *
 */
@SuppressWarnings("serial")
public class Column implements TableColumnModel, Serializable {
	
	private String name;
	private String code;
	private String columnType;
	private String notNull;
	private String typeLength;
	private String lenghtC;
	private String localName;
	
	public Column(String name, String code, String columnType, String notNull, String typeLength, String lenghtC) {
		super();
		this.name = name;
		this.code = code;
		this.columnType = columnType;
		this.notNull = notNull;
		this.typeLength = typeLength;
		this.lenghtC = lenghtC;
		this.localName = name.replace(" ", "");
	}

	public Column() {
		
		super();
		name = "";
		code = "";
		columnType = "";
		notNull = "false";
		typeLength = "";
		lenghtC = "3";
		localName=name.replace(" ", "");
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

	
	public String getColumnType() {
		return columnType;
	}

	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}

	
	public String getNotNull() {
		return notNull;
	}

	public void setNotNull(String notNull) {
		this.notNull = notNull;
	}

	public String getTypeLength() {
		return typeLength;
	}

	public void setTypeLength(String typeLength) {
		this.typeLength = typeLength;
	}

	@Override
	public void addColumn(TableColumn aColumn) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addColumnModelListener(TableColumnModelListener x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TableColumn getColumn(int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getColumnIndex(Object columnIdentifier) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getColumnIndexAtX(int xPosition) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getColumnMargin() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getColumnSelectionAllowed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Enumeration<TableColumn> getColumns() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSelectedColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int[] getSelectedColumns() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListSelectionModel getSelectionModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotalColumnWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void moveColumn(int columnIndex, int newIndex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeColumnModelListener(TableColumnModelListener x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setColumnMargin(int newMargin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setColumnSelectionAllowed(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSelectionModel(ListSelectionModel newModel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeColumn(TableColumn column) {
		// TODO Auto-generated method stub
		
	}

	public String getTypeC() {
		
		// TODO Auto-generated method stub
		return columnType;
	}

	public String getLengthC() {
		// TODO Auto-generated method stub
		return lenghtC;
	}

	/**
	 * @return the lenghtC
	 */
	public String getLenghtC() {
		return lenghtC;
	}

	/**
	 * @param lenghtC the lenghtC to set
	 */
	public void setLenghtC(String lenghtC) {
		this.lenghtC = lenghtC;
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
	public void localizeColumn(ResourceBundle resourceBundle){
			
			if(resourceBundle.containsKey(localName))
				name = resourceBundle.getString(localName);
	}


	public boolean getReference() {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}
