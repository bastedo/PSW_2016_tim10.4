<<<<<<< HEAD
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import action.LanguageToEnglish;
import action.LanguageToSerbianC;
import action.LanguageToSerbianL;
import app.MainFrame;

public class MainMenu extends JMenuBar{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JMenu fileMenu,editMenu,viewMenu,jezik;
	private static JMenuItem engleski,srpskil,srpskic;
	
	public MainMenu(){
		fileMenu = new JMenu("File");
		editMenu = new JMenu("Edit");
		viewMenu = new JMenu("View");
		
		jezik=new JMenu(MainFrame.getInstance().getResourceBundle().getString("Language"));
		engleski=new JMenuItem(MainFrame.getInstance().getResourceBundle().getString("English"));
		srpskil=new JMenuItem(MainFrame.getInstance().getResourceBundle().getString("SerbianLatin"));
		srpskic=new JMenuItem(MainFrame.getInstance().getResourceBundle().getString("SerbianCyrillic"));
		
		viewMenu.add(jezik);
		jezik.add(engleski);
		jezik.add(srpskil);
		jezik.add(srpskic);
		
		add(fileMenu);
		add(editMenu);
		add(viewMenu);
	
		
		engleski.addActionListener(new LanguageToEnglish());
		
		srpskil.addActionListener(new LanguageToSerbianL());
		
		srpskic.addActionListener(new LanguageToSerbianC());
		
	}

	
	public static void init(){
		
		jezik.setText(MainFrame.getInstance().getResourceBundle().getString("Language"));
		engleski.setText(MainFrame.getInstance().getResourceBundle().getString("English"));
		srpskil.setText(MainFrame.getInstance().getResourceBundle().getString("SerbianLatin"));
	    srpskic.setText(MainFrame.getInstance().getResourceBundle().getString("SerbianCyrillic"));
	    fileMenu.setText(MainFrame.getInstance().getResourceBundle().getString("File"));
	    editMenu.setText(MainFrame.getInstance().getResourceBundle().getString("Edit"));
	    viewMenu.setText(MainFrame.getInstance().getResourceBundle().getString("View"));
	    
	}
	
	public void localizeMainManu(ResourceBundle resourceBundle) {
		jezik.setText(MainFrame.getInstance().getResourceBundle().getString("Language"));
		engleski.setText(MainFrame.getInstance().getResourceBundle().getString("English"));
		srpskil.setText(MainFrame.getInstance().getResourceBundle().getString("SerbianLatin"));
	    srpskic.setText(MainFrame.getInstance().getResourceBundle().getString("SerbianCyrillic"));
	    fileMenu.setText(MainFrame.getInstance().getResourceBundle().getString("File"));
	    editMenu.setText(MainFrame.getInstance().getResourceBundle().getString("Edit"));
	    viewMenu.setText(MainFrame.getInstance().getResourceBundle().getString("View"));
		
	}
}
=======
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import action.LanguageToEnglish;
import action.LanguageToSerbianC;
import action.LanguageToSerbianL;
import app.MainFrame;

public class MainMenu extends JMenuBar{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JMenu fileMenu,editMenu,viewMenu,jezik;
	private static JMenuItem engleski,srpskil,srpskic;
	
	public MainMenu(){
		fileMenu = new JMenu("File");
		editMenu = new JMenu("Edit");
		viewMenu = new JMenu("View");
		
		jezik=new JMenu(MainFrame.getInstance().getResourceBundle().getString("Language"));
		engleski=new JMenuItem(MainFrame.getInstance().getResourceBundle().getString("English"));
		srpskil=new JMenuItem(MainFrame.getInstance().getResourceBundle().getString("SerbianLatin"));
		srpskic=new JMenuItem(MainFrame.getInstance().getResourceBundle().getString("SerbianCyrillic"));
		
		viewMenu.add(jezik);
		jezik.add(engleski);
		jezik.add(srpskil);
		jezik.add(srpskic);
		
		add(fileMenu);
		add(editMenu);
		add(viewMenu);
	
		
		engleski.addActionListener(new LanguageToEnglish());
		
		srpskil.addActionListener(new LanguageToSerbianL());
		
		srpskic.addActionListener(new LanguageToSerbianC());
		
	}

	
	public static void init(){
		
		jezik.setText(MainFrame.getInstance().getResourceBundle().getString("Language"));
		engleski.setText(MainFrame.getInstance().getResourceBundle().getString("English"));
		srpskil.setText(MainFrame.getInstance().getResourceBundle().getString("SerbianLatin"));
	    srpskic.setText(MainFrame.getInstance().getResourceBundle().getString("SerbianCyrillic"));
	    fileMenu.setText(MainFrame.getInstance().getResourceBundle().getString("File"));
	    editMenu.setText(MainFrame.getInstance().getResourceBundle().getString("Edit"));
	    viewMenu.setText(MainFrame.getInstance().getResourceBundle().getString("View"));
	    
	}
	
	public void localizeMainManu(ResourceBundle resourceBundle) {
		jezik.setText(MainFrame.getInstance().getResourceBundle().getString("Language"));
		engleski.setText(MainFrame.getInstance().getResourceBundle().getString("English"));
		srpskil.setText(MainFrame.getInstance().getResourceBundle().getString("SerbianLatin"));
	    srpskic.setText(MainFrame.getInstance().getResourceBundle().getString("SerbianCyrillic"));
	    fileMenu.setText(MainFrame.getInstance().getResourceBundle().getString("File"));
	    editMenu.setText(MainFrame.getInstance().getResourceBundle().getString("Edit"));
	    viewMenu.setText(MainFrame.getInstance().getResourceBundle().getString("View"));
		
	}
}
>>>>>>> origin/master
