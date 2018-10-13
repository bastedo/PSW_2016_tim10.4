package readDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import connection.DBConnection;
import model.TableSchema;

public class AddToDatabase {
	public static AddToDatabase instance;

	public static AddToDatabase getInstance() {
		if(instance == null) {                      
			instance = new AddToDatabase();       
		}
	
		return instance;     
	}

	public String insertRow(TableSchema tableSchema, ArrayList<DatabaseColumn> editedColumns) {
		Connection conn = DBConnection.getInstance().getConnection();
		String returnVal = "";
		System.out.println("addtoDB");
		
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
				System.out.println(editedColumns.get(i).getCodeColumn());
				System.out.println(editedColumns.get(i).getValueColumn());
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
	


