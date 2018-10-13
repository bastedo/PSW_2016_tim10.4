package readDB;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;



import model.TableSchema;
import validation.Validation;
import app.MainFrame;
import connection.DBConnection;



/**
 * Klasa koja u sebi sadrzi metodu koja kao parametar prima selektovana sema tabele i na osnovu njega iscitava podatke 
 * koji se nalaze u bazi i smesta ih u Vector objekata.
 * @author Boris Bogojevic
 *
 */

public class ReadDatabase {
	/**
	 * Atribut koji predstavlja instancu klase {@code ReadDatabase}
	 */
	public static ReadDatabase instance;
	/**
	 * Atribut koji predstavlja {@code Vector} koji nam sluzi sa smestanje podataka 
	 * koje ucitamo iz baze 
	 */
	private Vector<Vector<Object>> data;
	/**
	 * Konstruktor unutar kog se vrsi inicijalizacija 
	 */
	public ReadDatabase() {
		data = new Vector<Vector<Object>>();
	}
	
	/**
	 * Metoda koja vraca instancu klase
	 * @return {@code ReadDatabase} koja predstavlja instancu klase
	 */	
	public static ReadDatabase getInstance() {     
	
		if(instance == null) {                      
			instance = new ReadDatabase();       
		}
	
		return instance;             
	}
	/**
	 * Geter metoda
	 * @return {@code Vector} podataka koji su ucitani iz baze
	 */
	public Vector<Vector<Object>> getData() {
		return data;
	}

	/**
	 * Metoda koja na osnovu parametra vrsi selekciju iz baze podataka
	 * @param tableSchema - selektovana sema tabele 
	 */
	public void Read(TableSchema tableSchema)  {
		Connection conn = DBConnection.getInstance().getConnection();
		data = new Vector<Vector<Object>>();
		
		try {
			Statement stm = conn.createStatement();
			ResultSet res = stm.executeQuery("SELECT * FROM" + " " + tableSchema.getCode() + ";");
			System.out.println(res.toString());
			while (res.next()) {
				Vector<Object> record = new Vector<Object>();
					for(int i=0;i<tableSchema.getColumns().size();i++) {
						if(tableSchema.getColumns().getColumn(i).getColumnType().equals("datetime")){
							if(	res.getObject(i+1)!=null){
								String obj = res.getObject(i+1).toString().split(" ")[0];
							    String[] string = obj.split("-");
							    String god = string[0];
							    String dan = string[2];
							    String mesec = string[1];
								record.add(dan + "-" + mesec + "-" + god);
							} else
								record.add("");
						}
						/*else if(tableSchema.getColumns().getColumn(i).getTypeC().equals("bit")) {
							if(res.getObject(i+1) != null) {
								String str = res.getObject(i+1).toString();
								Boolean cb = new Boolean(str);
								record.add(cb);
							}
							else
								record.add("");
						}*/
						else {
							record.add(res.getObject(i+1));	
						}
					}
					data.add(record);
			}
		} catch(Exception e) {
			//System.out.println(e.ge);
			JOptionPane.showMessageDialog(new JFrame(),"Greska prilikom citanja iza baze!");
		}
	}
	
	/**
	 * Metoda koja na osnovu parametara vrsi selekciju iz baze
	 * @param tableSchema - selektovana sema tabele
	 * @param list - lista kolone po kojima se vrsi selekcija
	 */
	public void ReadWhere(TableSchema tableSchema, ArrayList<DatabaseColumn> list ){
		Connection conn = DBConnection.getInstance().getConnection();
		data = new Vector<Vector<Object>>();
			try {
				Statement stm = conn.createStatement();
				StringBuffer sqlStatement = new StringBuffer();
				sqlStatement.append("SELECT * FROM " + tableSchema.getCode() + " WHERE ");
				
				for(int i=0; i<list.size();i++) {
					
					if(list.get(i).getTypeColumn().equals("char") || list.get(i).getTypeColumn().equals("varchar")) {
						
						if(list.get(i).getValueColumn().contains("'")){
							String vrednost = list.get(i).getValueColumn().replace("'", "''");
							list.get(i).setValueColumn(vrednost);
						}
						
						if(list.get(i).getValueColumn().startsWith("*") && list.get(i).getValueColumn().endsWith("*")) {
							String upit = list.get(i).getValueColumn().replace("*", "%");
							sqlStatement.append(list.get(i).getCodeColumn() + " LIKE \'" + upit + "\'" );
						} else if(list.get(i).getValueColumn().startsWith("*")) {
							String upit = list.get(i).getValueColumn().substring(1);
							sqlStatement.append(list.get(i).getCodeColumn() + " LIKE \'%" + upit + "\'" );
						} else if( list.get(i).getValueColumn().endsWith("*")) {
							String upit = list.get(i).getValueColumn().substring(0, list.get(i).getValueColumn().length()-1);
							sqlStatement.append(list.get(i).getCodeColumn() + " LIKE \'" + upit + "%\'" );
						} else {
							String upit = list.get(i).getValueColumn();
							sqlStatement.append(list.get(i).getCodeColumn() + " = \'"+ upit + "\'" );
						}
						
					} else if(list.get(i).getTypeColumn().equals("int") || list.get(i).getTypeColumn().equals("smalint") || list.get(i).getTypeColumn().equals("numeric")){
						String type = "false";
						
						if(list.get(i).getTypeColumn().equals("int")){
							type = "int";
						} else if (list.get(i).getTypeColumn().equals("smalint")){
							type = "smalint";
						} else if(list.get(i).getTypeColumn().equals("numeric")){
							type = "numeric";
						} 
						
						if(list.get(i).getValueColumn().startsWith("*") && list.get(i).getValueColumn().endsWith("*")) {
							String number = list.get(i).getValueColumn().substring(1,list.get(i).getValueColumn().length()-1);
							String upit = list.get(i).getValueColumn().replace("*", "%");
							if(type.equals("int") || type.equals("smalint")){
								if(Validation.isInt(number)){
									sqlStatement.append("CAST("+list.get(i).getCodeColumn()+" AS TEXT)" + " LIKE \'" + upit + "\'" );
								} else {
									return;
								}
							} else if(type.equals("numeric")){
								if(Validation.isNumeric(number)){
									sqlStatement.append(list.get(i).getCodeColumn() + " LIKE \'" + upit + "\'" );
								} else {
									return;
								}
							}
						} else if(list.get(i).getValueColumn().startsWith("*")) {
							String number = list.get(i).getValueColumn().substring(1);
							String upit = list.get(i).getValueColumn().replace("*", "%");
							if(type.equals("int") || type.equals("smalint")){
								if(Validation.isInt(number)){
									sqlStatement.append("CAST("+list.get(i).getCodeColumn()+" AS TEXT)" + " LIKE \'" + upit + "\'" );
								} else {
									return;
								}
							} else if(type.equals("numeric")){
								if(Validation.isNumeric(number)){
									sqlStatement.append(list.get(i).getCodeColumn() + " LIKE \'" + upit + "\'" );
								} else {
									return;
								}
							}
						} else if( list.get(i).getValueColumn().endsWith("*")) {
							String number = list.get(i).getValueColumn().substring(0, list.get(i).getValueColumn().length()-1);
							String upit = list.get(i).getValueColumn().replace("*", "%");
							if(type.equals("int") || type.equals("smalint")){
								if(Validation.isInt(number)){
									sqlStatement.append("CAST("+list.get(i).getCodeColumn()+" AS TEXT)" + " LIKE \'" + upit + "\'" );
								} else {
									return;
								}
							} else if(type.equals("numeric")){
								if(Validation.isNumeric(number)){
									sqlStatement.append(list.get(i).getCodeColumn() + " LIKE \'" + upit + "\'" );
								} else {
									return;
								}
							}
						} else if(list.get(i).getValueColumn().startsWith(">=")) {
							String number = list.get(i).getValueColumn().substring(2);
							String upit = list.get(i).getValueColumn().replace(">=", "");
							if(type.equals("int") || type.equals("smalint")){
								if(Validation.isInt(number)){
									sqlStatement.append(list.get(i).getCodeColumn() + ">=" + upit );
								} else {
									return;
								}
							} else if(type.equals("numeric")){
								if(Validation.isNumeric(number)){
									sqlStatement.append(list.get(i).getCodeColumn() + ">=" + upit );
								} else {
									return;
								}
							} else {
								return;
							}	
						}
						else if(list.get(i).getValueColumn().startsWith("<=")) {
							String number = list.get(i).getValueColumn().substring(2);
							String upit = list.get(i).getValueColumn().replace("<=", "");
							if(type.equals("int") || type.equals("smalint")){
								if(Validation.isInt(number)){
									sqlStatement.append(list.get(i).getCodeColumn() + "<=" + upit );
								} else {
									return;
								}
							} else if(type.equals("numeric")){
								if(Validation.isNumeric(number)){
									sqlStatement.append(list.get(i).getCodeColumn() + "<=" + upit );
								} else {
									return;
								}
							} else {
								return;
							}
						}
						else if(list.get(i).getValueColumn().startsWith(">")){
							String number = list.get(i).getValueColumn().substring(1);
							String upit = list.get(i).getValueColumn().replace(">", "");
							if(type.equals("int") || type.equals("smalint")){
								if(Validation.isInt(number)){
									sqlStatement.append(list.get(i).getCodeColumn() + ">" + upit );
								} else {
									return;
								}
							} else if(type.equals("numeric")){
								if(Validation.isNumeric(number)){
									sqlStatement.append(list.get(i).getCodeColumn() + ">" + upit );
								} else {
									return;
								}
							} else {
								return;
							}
						}
						else if(list.get(i).getValueColumn().startsWith("<")) {
							String number = list.get(i).getValueColumn().substring(1);
							String upit = list.get(i).getValueColumn().replace("<", "");
							if(type.equals("int") || type.equals("smalint")){
								if(Validation.isInt(number)){
									sqlStatement.append(list.get(i).getCodeColumn() + "<" + upit  );
								}  else {
									return;
								}
							} else if(type.equals("numeric")){
								if(Validation.isNumeric(number)){
									sqlStatement.append(list.get(i).getCodeColumn() + "<" + upit  );
								}  else {
									return;
								}
							} else {
								return;
							}
						}
						else {
							String number = list.get(i).getValueColumn();
							if(type.equals("int") || type.equals("smalint")){
								if(Validation.isInt(number)){
									sqlStatement.append(list.get(i).getCodeColumn() + "=" + list.get(i).getValueColumn());
								}  else {
									return;
								}
							} else if(type.equals("numeric")){
								if(Validation.isNumeric(number)){
									sqlStatement.append(list.get(i).getCodeColumn() + "=" + list.get(i).getValueColumn());
								}  else {
									return;
								}
							} else {
								return;
							}
						}
						
					} else if(list.get(i).getTypeColumn().equals("datetime")) {
						if(!(list.get(i).getValueColumn().equals("empty")) && !(list.get(i+1).getValueColumn().equals("empty"))) {
							
							String valueOd = list.get(i).getValueColumn();
							String valueDo = list.get(i+1).getValueColumn();
							
							sqlStatement.append(list.get(i).getCodeColumn()  + " BETWEEN " + "'" + valueOd + "'" +" AND "+ "'" + valueDo + "'" );
							
							i++;
						
						} else if((!(list.get(i).getValueColumn().equals("empty")) && (list.get(i+1).getValueColumn().equals("empty")))) {
							
							String valueOd = list.get(i).getValueColumn();
							
							sqlStatement.append(list.get(i).getCodeColumn()  + " >= '" + valueOd + "'");
							
							i++;
						
						} else if((list.get(i).getValueColumn().equals("empty")) && !(list.get(i+1).getValueColumn().equals("empty"))){
							
							String valueDo = list.get(i+1).getValueColumn();
							
							sqlStatement.append(list.get(i+1).getCodeColumn()  + " <= '" + valueDo + "'");
							
							i++;
						}
					} else if (list.get(i).getTypeColumn().equals("bit")){
						String value = list.get(i).getValueColumn();
						
						if(value.equals("true") ){
							sqlStatement.append(list.get(i).getCodeColumn()  + " = " + 1);
						} else if(value.equals("false")){
							sqlStatement.append(list.get(i).getCodeColumn()  + " = " + 0);
						}
					}
					
					if(i + 1 != list.size()) {
						sqlStatement.append(" AND ");
					} else {
						sqlStatement.append(";");
					}
					
				}
				
				ResultSet res = stm.executeQuery(sqlStatement.toString());
				
				while (res.next()) {
					Vector<Object> record = new Vector<Object>();
						for(int i=0;i<tableSchema.getColumns().size();i++) {
							if(tableSchema.getColumns().getColumn(i).getTypeC().equals("datetime")){
								if(res.getObject(i+1) != null){
									String obj = res.getObject(i+1).toString().split(" ")[0];
								    String[] string = obj.split("-");
								    String god = string[0];
								    String dan = string[2];
								    String mesec = string[1];
									record.add(dan + "-" + mesec + "-" + god);
								}else{
									record.add("");
								}
							} else {
								record.add(res.getObject(i+1));	
						}
					}
						data.add(record);
				}
			} catch(Exception e) {
					JOptionPane.showMessageDialog(new JFrame(),MainFrame.getInstance().getResourceBundle().getString("errorDatabaseRead"));
			}
	}

	/**
	 * Metoda koja salje upit za bazi za izmenu selektovanog reda u tabeli.
	 * @param tableSchema sema tabele koji predstavlja tabelu ciji slog menjamo.
	 * @param primaryColumns kolone odgovarajuce tabele koje su primarni kjucevi.
	 * @param editedColumns kolone odgovarajuce tabele koje sadrze vrednosti iz {@code JTextField} polja iz forme za izmenu.
	 * @return prazan string ukoliko nema gresaka pri izmeni sloga. Ukoliko ima, vraca koja je greska u pitanju i kolonu na koju se odnosi greska.
	 */
	public String updateRow(TableSchema tableSchema, ArrayList<DatabaseColumn> primaryColumns, ArrayList<DatabaseColumn> editedColumns) {
		
		Connection conn = DBConnection.getInstance().getConnection();
		String retVal = "";
		
		try {
			Integer idx = 0;
			HashMap<String, String> map = new HashMap<String, String>();
			String value = "";
			StringBuffer sqlStatement = new StringBuffer();
			
			sqlStatement.append("UPDATE " + tableSchema.getCode() + " SET ");
			for(int i = 0; i < editedColumns.size(); i++) {
				
				value = editedColumns.get(i).getValueColumn();
				if(value.contains("'"))
					value = value.replaceAll("'", "''");
				
				sqlStatement.append(editedColumns.get(i).getCodeColumn() + " = ");
					
				if(value.equals(""))
					sqlStatement.append("null");
				else
					if(editedColumns.get(i).getTypeColumn().equals("char")
					|| editedColumns.get(i).getTypeColumn().equals("varchar"))
						sqlStatement.append("\'" + value + "\'");
					else if(editedColumns.get(i).getTypeColumn().equals("datetime")) {
						sqlStatement.append("?");
						idx++;
						map.put(Integer.toString(idx), value);
					}
					/*else if(editedColumns.get(i).getTypeColumn().equals("int")) {
						int val = Integer.parseInt(value);
						sqlStatement.append(val);
					}
					else if(editedColumns.get(i).getTypeColumn().equals("smallint")) {
						short val = Short.parseShort(value);
						sqlStatement.append(val);
					}
					else if(editedColumns.get(i).getTypeColumn().equals("numeric")) {
						BigDecimal val = new BigDecimal(value);
						sqlStatement.append(val);
					}*/
					//treba dodati jos i za bit polje
					else
						sqlStatement.append(value);
						
					if(i != editedColumns.size() - 1)
						sqlStatement.append(", ");
			}
			
			sqlStatement.append(" WHERE ");
			for(int j = 0; j < primaryColumns.size(); j++) {
				sqlStatement.append(primaryColumns.get(j).getCodeColumn() + " = ");
				
				if(primaryColumns.get(j).getTypeColumn().equals("char")
				|| primaryColumns.get(j).getTypeColumn().equals("varchar")
				|| primaryColumns.get(j).getTypeColumn().equals("datetime"))
					sqlStatement.append("\'" + primaryColumns.get(j).getValueColumn() + "\'");
				else
					sqlStatement.append(primaryColumns.get(j).getValueColumn());
				
				if(j != primaryColumns.size() - 1)
					sqlStatement.append(" AND ");
				else
					sqlStatement.append(";");
			}
						
			PreparedStatement stm = conn.prepareStatement(sqlStatement.toString());
			if(map.size() != 0)
				for(Map.Entry<String, String> set: map.entrySet()) {
					int index = Integer.parseInt(set.getKey());
					Timestamp time = Timestamp.valueOf(set.getValue());
					stm.setTimestamp(index, time);
				}
			stm.executeUpdate();
			
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
			
			if(e.getMessage().contains("FOREIGN KEY"))
				retVal = "errorForeignKey";
			else if (e.getMessage().contains("PRIMARY KEY"))
				retVal = "errorPrimaryKey";
			else if (e.getMessage().contains("REFERENCE"))
				retVal = "errorReference";
			else
				retVal = "errorDatabaseRead";
		}
		return retVal;
	}
	
	/**
	 * Metoda koja salje upit ka bazi za dodavanje sloga u tabelu.
	 * @param tableSchema sema tabele u ciju tabelu dodajemo slog.
	 * @param editedColumns kolone odgovarajuce tabele koje sadrze vrednosti iz {@code JTextField} polja iz forme za dodavanje.
	 * @return prazan string ukoliko nema gresaka pri dodavanju sloga. Ukoliko ima, vraca koja je greska u pitanju i kolonu na koju se odnosi greska.
	 */
	public String insertRow(TableSchema tableSchema, ArrayList<DatabaseColumn> editedColumns) {
		
		Connection conn = DBConnection.getInstance().getConnection();
		String returnVal = "";
		
		try {
			Integer idx = 0;
			HashMap<String, String> map = new HashMap<String, String>();
			String value = "";
			StringBuffer sqlStatement = new StringBuffer();
			sqlStatement.append("INSERT INTO " + tableSchema.getCode() + " (");
			
			for(int i = 0; i < editedColumns.size(); i++) {
				sqlStatement.append(editedColumns.get(i).getCodeColumn());
				
				if(i != editedColumns.size() - 1)
					sqlStatement.append(", ");
				else
					sqlStatement.append(")");
			}
			
			sqlStatement.append(" VALUES (");
			for(int i = 0; i < editedColumns.size(); i++) {
				
				value = editedColumns.get(i).getValueColumn();
				if(value.contains("'"))
					value = value.replaceAll("'", "''");
				
				if(value.equals(""))
					sqlStatement.append("null");
				else
					if(editedColumns.get(i).getTypeColumn().equals("char")
					|| editedColumns.get(i).getTypeColumn().equals("varchar"))
						sqlStatement.append("\'" + value + "\'");
					else if(editedColumns.get(i).getTypeColumn().equals("datetime")) {
						sqlStatement.append("?");
						idx++;
						map.put(Integer.toString(idx), value);
					}
					else
						sqlStatement.append(value);
				
				if(i != editedColumns.size() - 1)
					sqlStatement.append(", ");
				else
					sqlStatement.append(")");
			}
			
			PreparedStatement stm = conn.prepareStatement(sqlStatement.toString());
			if(map.size()!=0)
				for(Map.Entry<String, String> set: map.entrySet()) {
					int index = Integer.parseInt(set.getKey());
					Timestamp time = Timestamp.valueOf(set.getValue());
					stm.setTimestamp(index, time);
			    }
			stm.executeUpdate();
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			
			if(e.getMessage().contains("FOREIGN KEY"))
				returnVal = "errorForeignKey";
			else if (e.getMessage().contains("PRIMARY KEY"))
				returnVal = "errorPrimaryKey";
			else if (e.getMessage().contains("REFERENCE"))
				returnVal = "errorReference";
			else
				returnVal = "errorDatabaseRead";
		}
		return returnVal;
	}
}