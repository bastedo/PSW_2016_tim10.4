package forms.listener;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import app.MainFrame;
import controller.TableController;
import forms.AddRowDialog;
import forms.AddRowForm;
import model.Column;
import model.Columns;
import model.TableModel;
import model.TableSchema;
import readDB.AddToDatabase;
import readDB.DatabaseColumn;
import readDB.ReadDatabase;
import tree.TreeMouseListener;
import validation.Validation;


/**
 * Klasa koja omugucava da se na klik dugmeta doda slog u tabelu.
 * @author Boris Bogojevic
 *
 */
public class OkAddRowListener implements ActionListener, KeyListener {
	
	/**
	 * Tabela u koju dodajemo slog.
	 */
	private JTable table;
	/**
	 * Panel koji sadrzi formu za dodavanje sloga izgenerisanu na osnovu kolona date {@code JTable}.
	 */
	private AddRowForm panel;
	/**
	 * Dijalog u kome se nalazi panel sa formom za dodavanje sloga i dugmadi za izvrsavanje ili otkazivanje akcije.
	 */
	private AddRowDialog dialog;
	/**
	 * Podatak koji nam govori da dodajemo slog u parent ili child tabelu.
	 */
	private boolean isParent;
	
	private TableSchema tableSchema ;
	
	/**
	 * Konstruktor.
	 * @param table2 predstavlja tabelu u koju dodajemo slog.
	 * @param isParent nam govori da li je u pitanju parent ili child tabela.
	 * @param panel predstavlja panel u kojem se nalazi forma za dodavanje.
	 * @param dialog predstavlja dijalog u kojem se nalazi panel i dugmad za rukovanje akcijom dodavanja sloga.
	 */
	public OkAddRowListener(TableSchema table2, boolean isParent, AddRowForm panel, AddRowDialog dialog)  {
		//this.table = table2;
		this.panel = panel;
		this.tableSchema = panel.getTable() ;
		this.dialog = dialog;
		this.isParent = isParent;
	}

	/**
	 * Metoda koja omogucjuje dodavanje unesenih podataka u odgovarajucu tabelu.
	 * Pri dodavanju, vrsi se kupljenje podataka iz forme i njihova validacija po odredjenom kriterijumu.
	 * Ukoliko se ispostavi da su svi podaci validni, sledi slanje istih u bazu.
	 */
	public void add() {
		
		
		
		Columns columns = tableSchema.getColumns();
		JPanel mainPan = (JPanel)panel.getComponent(0);
		
		ArrayList<DatabaseColumn> editedColumns = new ArrayList<DatabaseColumn>();
		ArrayList<JLabel> labels = new ArrayList<JLabel>();
		
		HashMap<String, String> validationType = new HashMap<String, String>();
		HashMap<String, String> validationMandatory = new HashMap<String, String>();
		HashMap<String, String> validationLength = new HashMap<String, String>();
		
		/**
		 * Dodavanje svih {@code JTextField} komponenata u listu.
		 */
		for(int i = 1; i < mainPan.getComponentCount(); i = i+3) {
			for(int j = 0; j < tableSchema.getColumns().size(); j++)
				if(mainPan.getComponent(i).getName().equals(tableSchema.getColumns().getColumn(j).getCode()))
					if(mainPan.getComponent(i) instanceof JTextField) {
						JTextField field = (JTextField)mainPan.getComponent(i);
						String val = field.getText();
						if(tableSchema.getColumns().getColumn(j).getTypeC().equals("numeric"))
							val = val.replaceAll(",", ".");
						editedColumns.add(new DatabaseColumn(field.getName(), val, tableSchema.getColumns().getColumn(j).getTypeC()));
					}
					else if(mainPan.getComponent(i) instanceof JDateChooser) {
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
						JDateChooser chooser = (JDateChooser)mainPan.getComponent(i);
						String date;
						if(chooser.getDate() != null)
							date = sdf.format(chooser.getDate());
						else
							date = "";
						editedColumns.add(new DatabaseColumn(chooser.getName(), date, tableSchema.getColumns().getColumn(j).getTypeC()));
					}
					else if(mainPan.getComponent(i) instanceof JCheckBox) {
						JCheckBox checkBox = (JCheckBox)mainPan.getComponent(i);
						String val = "";
						if(checkBox.isSelected())
							val = "1";
						else
							val = "0";
						editedColumns.add(new DatabaseColumn(checkBox.getName(), val, tableSchema.getColumns().getColumn(j).getTypeC()));
					}
		}
		
		/**
		 * Dodavanje svih {@code JLabel} komponenata za validaciju u listu.
		 */
		for(int i = 2; i < mainPan.getComponentCount(); i = i+3)
			labels.add((JLabel)mainPan.getComponent(i));
		
		/**
		 * Provera validnosti tipa unesenih podataka.
		 */
		for(int i = 0; i < editedColumns.size(); i++) {
			
			Column column = columns.getColumnByCode(editedColumns.get(i).getCodeColumn());
			String value = editedColumns.get(i).getValueColumn();
			
			/**
			 * Vrsimo proveru validnosti tipova ukoliko je odgovarajuce polje obavezno i nije prazno
			 * ili ukoliko nije obavezno i nije prazno.
			 */
			if(!value.equals("")) {
				
				validationMandatory.put(column.getCode(), "true");
				
				if(column.getTypeC().equals("int") || column.getTypeC().equals("smallint")) {
					validationLength.put(column.getCode(), "true");
					if(Validation.isInt(value) == false) {
						validationType.put(column.getCode(), "false");
						labels.get(i).setIcon(new ImageIcon("icons/notChecked.png"));
					}
					else {
						validationType.put(column.getCode(), "true");
						labels.get(i).setToolTipText(null);
						labels.get(i).setIcon(new ImageIcon("icons/check.png"));
					}
				}
						
					
					if(column.getTypeC().equals("numeric")) {
						if(Validation.isNumeric(value) == true) {
							validationType.put(column.getCode(), "true");
							if(Validation.isValidLengthNumeric(value, column.getLengthC().split(",")[0]) == true) {
								validationLength.put(column.getCode(), "true");
								labels.get(i).setToolTipText(null);
								labels.get(i).setIcon(new ImageIcon("icons/checked.png"));
							}
							else {
								validationLength.put(column.getCode(), "false");
								labels.get(i).setIcon(new ImageIcon("icons/notChecked.png"));
							}
						}
						else {
							validationType.put(column.getCode(), "false");
							labels.get(i).setIcon(new ImageIcon("icons/notChecked.png"));
						}
					}
				
					
					if(column.getTypeC().equals("char")) {
						if(Validation.isChar(value) == true) {
							validationType.put(column.getCode(), "true");
							if(Validation.isValidLengthChar(value, column.getLengthC()) == true) {
								validationLength.put(column.getCode(), "true");
								labels.get(i).setToolTipText(null);
								labels.get(i).setIcon(new ImageIcon("icons/check.png"));
							}
							else {
								validationLength.put(column.getCode(), "false");
								labels.get(i).setIcon(new ImageIcon("icons/notChecked.png"));
						//		labels.get(i).setToolTipText(MainFrame.getInstance().getResourceBundle().getString("validationLength") + column.getLengthC());
							}
						}
						else {
							validationType.put(column.getCode(), "false");
							labels.get(i).setIcon(new ImageIcon("icons/notChecked.png"));
							labels.get(i).setToolTipText( "Duzina "+column.getName() + " je maximalno"+column.getLenghtC());
						}
					}
				
					
					if(column.getTypeC().equals("varchar")) {
						if(Validation.isVarchar(value) == true) {
							validationType.put(column.getCode(), "true");
							if(Validation.isValidLengthVarchar(value, column.getLengthC()) == true) {
								validationLength.put(column.getCode(), "true");
								labels.get(i).setToolTipText(null);
								labels.get(i).setIcon(new ImageIcon(("icons/checked.png")));
							}
							else {
								validationLength.put(column.getCode(), "false");
								labels.get(i).setIcon(new ImageIcon("icons/notChecked.png"));
								labels.get(i).setToolTipText( "Duzina "+column.getName() + " je maximalno"+column.getLenghtC());
							}
						}
						else {
							validationType.put(column.getCode(), "false");
							labels.get(i).setIcon(new ImageIcon("icons/notChecked.png"));
							JOptionPane.showMessageDialog(MainFrame.getInstance(), "Tip kolone mora biti varchar!");;
						}
					}
					
			}
			/**
			 * Ako je polje obavezno i prazno je, prijavljujemo gresku korisniku.
			 */
			else if(column.getNotNull().equals("true") && value.equals("")) {
				validationMandatory.put(column.getCode(), "false");
				labels.get(i).setIcon(new ImageIcon("icons/notChecked.png"));
			//	JOptionPane.showMessageDialog(MainFrame.getInstance(), "Polje"+ column.getName() +"ne moze biti prazno");
			}
			/**
			 * Ako polje nije obavezno i prazno je, nastavljamo sa prolazenjem kroz kolone.
			 */
			else if(column.getNotNull().equals("false") && value.equals("")) {
				validationType.put(column.getCode(), "true");
				validationMandatory.put(column.getCode(), "true");
				validationLength.put(column.getCode(), "true");
				labels.get(i).setIcon(new ImageIcon("src/icons/notChecked.png"));
				labels.get(i).setToolTipText(null);
			}
		}
	
		int countType = 0;
		int countMand = 0;
		int countLength = 0;
		
		@SuppressWarnings("rawtypes")
		Iterator it = validationType.entrySet().iterator();
		    while (it.hasNext()) {
		        @SuppressWarnings("rawtypes")
				HashMap.Entry pair = (HashMap.Entry)it.next();
		        if(pair.getValue().equals("true"))
		        	countType++;
		    }
		    
		@SuppressWarnings("rawtypes")
		Iterator it1 = validationMandatory.entrySet().iterator();
			while (it1.hasNext()) {
			    @SuppressWarnings("rawtypes")
				HashMap.Entry pair = (HashMap.Entry)it1.next();
			    if(pair.getValue().equals("true"))
			    	countMand++;
			}
		
		@SuppressWarnings("rawtypes")
		Iterator it2 = validationLength.entrySet().iterator();
			while (it2.hasNext()) {
			    @SuppressWarnings("rawtypes")
				HashMap.Entry pair = (HashMap.Entry)it2.next();
			    if(pair.getValue().equals("true"))
			    	countLength++;
			}
		    
			/**
			 * Provera da li su validni svi podaci i slanje podataka u bazu od zavisnosti od ishoda.
			 */
			
		    if(countType == validationType.values().size()) {
		    	String retVal = AddToDatabase.getInstance().insertRow(tableSchema,  editedColumns);
		    	
		    	/**
		    	 * Ako je slog uspesno dodat u bazu.
		    	 */
		    	if(retVal.equals("")) {
		    		TableController tc = new TableController();
//		    		if(isParent){
//		    			
//		    			tc.createParentTableView(tableSchema);
//		    			tc.createChildTableView(tableSchema);
//		    		}else{
//		    			
//		    		}
		    		tc.getSelectedTable(tableSchema.getCode());
		    		tc.createParentTableView(tableSchema);
	    			tc.setChildren(tableSchema);
		    		dialog.dispose();
		    	}
//		    	/**
//		    	 * Ukoliko baza vraca gresku.
//		    	 */
//		    	else
//		    		JOptionPane.showMessageDialog(new JFrame(), MainFrame.getInstance().getResourceBundle().getString(retVal));
//		    }
//		    
//			if(table.getSelectedRow()!=-1){
//				MainFrame.getInstance().getActionManager().getDeleteRow(isParent).setEnabled(true);
//				MainFrame.getInstance().getActionManager().getEditRow(isParent).setEnabled(true);
//			} else {
//				MainFrame.getInstance().getActionManager().getDeleteRow(isParent).setEnabled(false);
//				MainFrame.getInstance().getActionManager().getEditRow(isParent).setEnabled(false);
			}
	}

	/**
	 * Metoda koja se poziva pri kliku na taster Enter u dijalogu za izmenu sloga.
	 */
	public void keyPressed(KeyEvent arg0) {
		if(arg0.getKeyCode() == KeyEvent.VK_ENTER)
			add();
	}

	public void keyReleased(KeyEvent arg0) {}

	public void keyTyped(KeyEvent arg0) {}

	/**
	 * Metoda koja se poziva pri kliku na dugme za izmenu.
	 */
	public void actionPerformed(ActionEvent arg0) {
		add();
	}
}
