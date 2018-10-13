package controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.json.simple.parser.ParseException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTree;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import model.Column;
import model.Node;
import model.TableSchema;
import model.TableModel;
import app.MainFrame;
/**
 * 
 * @author Snezana Stevanovic
 * 
 * Klasa koja parsira JSON file.
 * U okviru nje se generise model aplikacije.
 * Kreira se sema {@link TableModel} i sema {@link TableSchema}
 *
 */

public class JsonParser {

	private JTree tree;
	public static Node root;
	private JSONObject  jsonObject;
	
	
	/**
	 * Metoda koja generise stablo aplikacije u zavisnosti od JSON objekta.
	 * @return {@link JTree} objekat-kreirano stablo
	 */
	public JTree generateTree() {
		
		JSONParser parser = new JSONParser();
		
		try {
			
			Object object = parser.parse(new InputStreamReader(getClass().getResourceAsStream("tree.json")));
			jsonObject = (JSONObject)object;
			
			root = new Node();
			root.setParent(null);	       
			setNodeNameAndCode(root, jsonObject);
			tree = new JTree(root);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(new JFrame(), "Operation interrupted! File not found.");
			MainFrame.getInstance().dispose();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(new JFrame(), "Operation interrupted! Cannot start the application.");
			MainFrame.getInstance().dispose();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(new JFrame(), "Operation interrupted! File is not valid.");
			MainFrame.getInstance().dispose();
		}
		
		return tree;
	}
	

	public void generateTables(){
		JSONParser parser = new JSONParser();
		
		
	try {
			
			Object object = parser.parse(new InputStreamReader(getClass().getResourceAsStream("tree.json")));
			jsonObject = (JSONObject)object;
			
			createTableModel(jsonObject);
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(new JFrame(), "Operation interrupted! File not found.");
			MainFrame.getInstance().dispose();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(new JFrame(), "Operation interrupted! Cannot start the application.");
			MainFrame.getInstance().dispose();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(new JFrame(), "Operation interrupted! File is not valid.");
			MainFrame.getInstance().dispose();
		}
	
	}
	
	/**
	 * Metoda koja zapocinje kreiranje {@link TableModel}
	 * @param obj - {@link JSONObject} koji sadrzi fajl u okviru kojeg su svi podaci o tabelama.
	 */
	@SuppressWarnings("unchecked")
	public void createTableModel(JSONObject obj){
			
			JSONArray children = (JSONArray) obj.get("children");
			if(children.size() ==0 ){
				return;
			}
			
			Iterator<JSONObject> array = children.iterator();
			while(array.hasNext()){
				setTable(new TableSchema() ,array.next());
			}
	}		
	
	/**
	 * Metoda koja za pojedinacnu {@link TableModel} tabelu setuje njen naziv i kod, 
	 *   njene kolone i njene child tabele
	 * @param t - {@link TableModel} tabela ciji se podaci generisu.
	 * @param obj - {@link JSONObject} koji sadrzi tabele
	 */
	@SuppressWarnings("unchecked")
	private void setTable(TableSchema t, JSONObject obj){
		setTableNameAndCode(t, obj);
		JSONArray chilArray = (JSONArray) obj.get("children");
		if(chilArray.size() == 0){
			setColumns(t, obj);
			setReference(t, obj);
			System.out.println("");
			System.out.println(t.getReferences().size());
			System.out.println("");
		}
		else{
			setColumns(t,obj);
			setReference(t, obj);
			System.out.println("");
			System.out.println(t.getReferences().size());
			System.out.println("");
			Iterator<JSONObject> array = chilArray.iterator();
			while(array.hasNext()){
				TableSchema child = new TableSchema();
				t.addChild(child);
				setTable(child, array.next());
				}
			}
		
	}
	
	/**
	 * Metoda koja odredjenoj tabeli podesava naziv i kod
	 * @param t - {@link TableModel} tabela za koju se podesavaju naziv i kod
	 * @param obj - parsirani {@link JSONObject} iz kojeg se kupi naziv i kod
	 */
	public void setTableNameAndCode(TableSchema t, JSONObject obj){
		String name = (String) obj.get("name");
		String code = (String) obj .get("code");
		
//		if(name.equals("Drzava")){
//			name=MainFrame.getInstance().getResourceBundle().getString("Drzava");
//			
//		}
		
		if(name != null){
			t.setName(name);
			t.setLocalName(name.replace(" ", ""));
		}
		if(code != null){
			t.setCode(code);
		}
		
	
	}
	
	@SuppressWarnings("unchecked")
	public void setReference(TableSchema t, JSONObject obj){
		JSONArray refArray = (JSONArray) obj.get("reference");
		if(refArray== null){
			t.addReference(null);
			System.out.println("nnnnnn");
		}
		else{
			Iterator<JSONObject> array = refArray.iterator();
			int i = 0 ;
			while(array.hasNext()){
				
				System.out.println("ima:    " + i++);
				setRef(t,array.next());
				}
		}
	}
	
	public void setRef(TableSchema t, JSONObject obj){
	String ref = (String) obj.get("refCode");
	System.out.println(ref);
		if(ref != null){
			t.setReference(ref);
			t.addReference(ref);
			System.out.println(t.getReferences().size());
		}
	}
	
	/**
	 * Metoda koja za prosledjenu tabelu kreira njene kolone
	 * @param t - TableModel tabela cije se kolone podesavaju
	 * @param obj - parsirani {@link JSONObject} iz kojeg se kupe podaci o tabeli
	 */
	@SuppressWarnings("unchecked")
	private void setColumns(TableSchema t, JSONObject obj){
		
		t.removeAllColumns();
		
		JSONArray columns = (JSONArray) obj.get("columns");
		if(columns.size() == 0){
			return;
		}
		
		Iterator<JSONObject> array = columns.iterator();
		while(array.hasNext()){
			Column c = new Column();
			setColumnNameAndCode(c,array.next());
			t.addColumn(c);
			
		}
		if (MainFrame.getInstance().getTabele().containsKey(t.getCode())){
			System.out.println(t.getName() + "    llllllll           Duplikat");
		}else {
			MainFrame.getInstance().getTabele().put(t.getCode(), t);
			System.out.println(t.getCode()+ t.getName() + t.toString()+"   "+ t.getReferences().size());
		}
		
		System.out.println(t.getName());
		System.out.println(MainFrame.getInstance().getTabele().size());
	}
	
	/**
	 * Metoda koja za prosledjenu kolonu podesava njen naziv i kod
	 * @param c - {@link Column} kolona ciji se parametri podesavaju
	 * @param obj - parsirani {@link JSONObject} iz kojeg se kupe vrednosti kolone
	 */
	private void setColumnNameAndCode (Column c,JSONObject obj){
		
 		String name = (String) obj.get("name");
 		String code = (String) obj.get("code");
 		String columnType = (String) obj.get("columnType");
 		String notNull = (String) obj.get("isnullable");
 		String typeLength = (String) obj.get("typeLength");
 		
 		if (name != null){
 			c.setName(name);
 			c.setLocalName(name.replace(" ", ""));
 		}
 		if (code != null){
 			c.setCode(code);
 		}
 		if (columnType != null){
 			c.setColumnType(columnType);
 		}
 		if (notNull != null){
 			c.setNotNull(notNull);
 		}
 		if(typeLength != null){
 			c.setTypeLength(typeLength);
 		}
 	}

	/**
	 * Metoda koja podesava naziv i kod za cvor u stablu
	 * @param n -  {@link Node} cvor stabla za koji se podesavaju parametri
	 * @param obj - {@link JSONObject} iz kojeg se parsiranjem kupe podaci 
	 */
 	private void setNodeNameAndCode (Node n, JSONObject obj){
 		String name = (String) obj.get("name");
 		String code = (String) obj.get("code");
 		String type = (String) obj.get("type");
 		
 		if( name != null){
			n.setName(name);
			n.setLocalNameKey(name.replace(" ", ""));
		}
		if( code != null) {
			n.setCode(code);
		}
		if( type != null){
			n.setType(type);
		}
		
		setNodeChildren(n, obj);
 		
 	}
 	
 	/**
 	 * Metoda koja za neki cvor iz stabla podesava njegove child-ove, ukoliko ih ima
 	 * @param node - {@link Node} cvor za koji se podesavaju child-ovi
 	 * @param object - {@link JSONObject} iz kojeg se parsiranjem kupe podaci
 	 */
 	
	@SuppressWarnings({ "unchecked" })
	public void setNodeChildren(Node node, JSONObject object){
		
		JSONArray jsonChilArray = (JSONArray) object.get("children");
		
		if(jsonChilArray.size() == 0){
			return;
		}
		
		Iterator<JSONObject> array = jsonChilArray.iterator();
		
		while(array.hasNext()){
			Node myNode = new Node();
			node.addChildren(myNode);
			setNodeNameAndCode(myNode, array.next());
		//	System.err.println(myNode.getName());
		}	
	}
	@SuppressWarnings("unused")
	public void readAllTables () {
		Set<String> set = MainFrame.getInstance().getTabele().keySet();
		HashMap<String, TableSchema> a = MainFrame.getInstance().getTabele();
		Iterator<String> iterator = set.iterator();
//	    while(iterator.hasNext()) {
//	    	String setElement = iterator.next();
//	    	TableModel b = MainFrame.getInstance().getTabele().get(iterator);
//	    	//System.out.println(setElement);
//	    	if (setElement.equals("NASELJENO_MESTO")){
//	    		System.out.println("        istiii       ");
//	    	}
//	    	if (a.containsKey("NASELJENO_MESTO")) {
//	    		System.out.println("        nasaoooo       ");
//	    	}
//	    	if (MainFrame.getInstance().getTabele().containsKey("NASELJENO_MESTO")) {
//	    		System.out.println("        nasaoooo main      ");
//	    	}
//	    	if (a.containsKey(iterator.toString())) {
// 	    		System.out.println("        nasaoooo main      ");
// 	    	}
// 	    	
//	    	if (MainFrame.getInstance().getTabele().get(iterator) != null) {
//	    		System.out.println(MainFrame.getInstance().getTabele().get(iterator.toString()).getName());
//	    	}else {
//	    		System.out.println(setElement+ "      nije nasaoooo ");
//	    	}
//	    	
//	    }
		
		for (String key: MainFrame.getInstance().getTabele().keySet()) {
		    System.out.println("key : " + key);
		    System.out.println("value : " + MainFrame.getInstance().getTabele().get(key).getCode());
		}
	}
	
}