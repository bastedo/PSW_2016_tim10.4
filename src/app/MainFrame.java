package app;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.Dialog.ModalityType;
import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTree;

import action.ActionManager;
import connection.ReadUsers;
import controller.JsonParser;
import forms.LoginDialog;
import forms.listener.OkLoginListener;
import model.Node;
import model.TableSchema;
import tree.TreeMouseListener;
import view.ChildToolbar;
import view.MainMenu;
import view.ParentToolbar;
import view.StatusBar;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	
	public static MainFrame instance = null;
	public Toolkit tk;
	
	private LoginDialog loginDialog;
	public HashMap<String, TableSchema> tabele;
	
	public HashMap<String, TableSchema> tabele1 = new HashMap<String, TableSchema>();
	public HashMap<String, String> tabeleNames = new HashMap<String, String>();

	public ActionManager action;
	private JPanel mainPanel;
	private ParentToolbar parentToolbar;
	private ChildToolbar childToolbar;
	private JScrollPane scroll;
	private MainMenu menu;
	private JTree tree;
	private JsonParser parser;
	private JPanel panel;
	private StatusBar statusBar;
	
	private JPanel panelGornji;
	private JPanel panelDonji;
	
	private JSplitPane split;
	private JSplitPane split2;
	
	private JTabbedPane mainTabsChild;
	private JTabbedPane mainTabsParent;
	
	private ResourceBundle resourceBundle;
	
	private MainFrame() {
		
		Locale.setDefault(new Locale("en","US"));
		resourceBundle =ResourceBundle.getBundle( "MessageResources.MessageResources", Locale.getDefault());
	}
	
	/**
	 * 
	 */
	public void initialise(){ 
		
	new ReadUsers();	
	// Podešavanje okruženja	
	tk = Toolkit.getDefaultToolkit();
	Dimension screenSize = tk.getScreenSize();
	
	
	int screenHeight = screenSize.height;
	int screenWidth = screenSize.width;
	setSize(4*screenWidth/5, 4*screenHeight/5);
	setMinimumSize(new Dimension (600,300));
	
	setVisible(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
	
	setTitle(MainFrame.getInstance().getResourceBundle().getString("title"));
	
	
	mainPanel = new JPanel(new BorderLayout());
	action = new ActionManager();
	parentToolbar = new ParentToolbar();
	childToolbar = new ChildToolbar();
	
	tabele = new HashMap<String, TableSchema>();
	
	menu = new MainMenu();
	setJMenuBar(menu);
	
	
	getContentPane().add(mainPanel, BorderLayout.NORTH);
	
	if(OkLoginListener.loggedUser == null){
		//showLogin();
	}
	
	statusBar = new StatusBar();
	getContentPane().add(statusBar, BorderLayout.SOUTH);
	
	//Stablo aplikacije
	parser = new JsonParser();
	tree = parser.generateTree();
	tree.addMouseListener(new TreeMouseListener());
	parser.generateTables();
    scroll = new JScrollPane(tree);
	scroll.setMinimumSize(new Dimension(200, 150));
	
	//TabbedPane za prikaz Child tabela, donji prozor aplikacije
	panelDonji = new JPanel(new BorderLayout());
	mainTabsChild = new JTabbedPane();
	mainTabsChild.setVisible(false);
	mainTabsChild.setSize(new Dimension(panelDonji.getWidth(), panelDonji.getHeight()));

	panelDonji.add(BorderLayout.CENTER, mainTabsChild);
	panelDonji.add(childToolbar, BorderLayout.NORTH);
	
	
	//TabbedPane za prikaz parent tabela, gornji prozor aplikacije
	panelGornji=new JPanel(new BorderLayout());
	mainTabsParent = new JTabbedPane();
	mainTabsParent.setVisible(false);
	mainTabsParent.setSize(new Dimension(panelGornji.getWidth(), panelGornji.getHeight()));
	
	panelGornji.add(BorderLayout.CENTER, mainTabsParent);
	panelGornji.add(parentToolbar, BorderLayout.NORTH);
	
	panel = new JPanel(new GridLayout());
	
	split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scroll, panel);
	add(split, BorderLayout.CENTER);
	split.setDividerLocation(250);
	
	split2=new JSplitPane(JSplitPane.VERTICAL_SPLIT,panelGornji,panelDonji);
	panel.add(split2);
	split2.setDividerLocation(250);
	System.out.println(Locale.getDefault().toString());
	
	
	
	}
	
	
	
	public HashMap<String, TableSchema> getTabele() {
		return tabele;
	}

	public void setTabele(HashMap<String, TableSchema> tabele) {
		this.tabele = tabele;
	}

	public JPanel getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(JPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

	public ParentToolbar getMainToolbar() {
		return parentToolbar;
	}

	public void setMainToolbar(ParentToolbar mainToolbar) {
		this.parentToolbar = mainToolbar;
	}

	public MainMenu getMenu() {
		return menu;
	}

	public void setMenu(MainMenu menu) {
		this.menu = menu;
	}

	public JTree getTree() {
		return tree;
	}

	public void setTree(JTree tree) {
		this.tree = tree;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public  JTabbedPane getMainTabsChild() {
		return mainTabsChild;
	}

	public void setMainTabsChild(JTabbedPane mainTabsChild) {
		this.mainTabsChild = mainTabsChild;
	}

	public JTabbedPane getMainTabsParent() {
		return mainTabsParent;
	}

	public void setMainTabsParent(JTabbedPane mainTabsParent) {
		this.mainTabsParent = mainTabsParent;
	}

	public  JPanel getPanelGornji(){
		return panelGornji;
	}
	
	public JPanel getPanelDonji() {
		return panelDonji;
	}

	public void setPanelDonji(JPanel panelDonji) {
		this.panelDonji = panelDonji;
	}

	public Toolkit getTk() {
		return tk;
	}

	public void setTk(Toolkit tk) {
		this.tk = tk;
	}

	public ResourceBundle getResourceBundle() {
		
		return resourceBundle;
	}
	
	public static MainFrame getInstance(){
		
		if (instance == null){
			instance = new MainFrame();
			instance.initialise();
			
		}
		
		return instance;  
	}


	public ActionManager getAction() {
		return action;
	}

	public void setAction(ActionManager action) {
		this.action = action;
	}

	/**
	 * @return the parser
	 */
	public JsonParser getParser() {
		return parser;
	}

	/**
	 * @param parser the parser to set
	 */
	public void setParser(JsonParser parser) {
		this.parser = parser;
	}
	public void readAllTables (){
		for (String key: this.getTabele().keySet()) {
		    System.out.println("key : " + key);
		    System.out.println("value : " + this.getTabele().get(key).getReferences().size());
		}
	}
	/**
	 * Metoda koja podesava instancu {@code MainFrame} na {@code NULL}
	 */
	public static void setInstanceToNull(){
		instance.dispose();
		instance = null;
	}
	
	public void changeLanguage(Locale locale){
	
		resourceBundle = ResourceBundle.getBundle( "MessageResources.MessageResources", locale );
		Node rootNode = (Node) tree.getModel().getRoot();		
		rootNode.localizeNodeAndChildrenNodes(resourceBundle);
		tree.updateUI();
		Set<String> b = tabele.keySet() ;
		for (String key : b) {
			String name1=null;
			if(resourceBundle.containsKey(tabele.get(key).getLocalName()))
				name1 = resourceBundle.getString(tabele.get(key).getLocalName());
			TableSchema a = tabele.get(key);
			a.localizeTableSchema(resourceBundle);
			if (name1 != null) {
				tabele1.put(name1, a);
			}
			
			//.localizeTableSchema(resourceBundle);
		}
		statusBar.localizeStatusBar(resourceBundle);
		menu.localizeMainManu(resourceBundle);				
		
		
		//da
		//MainMenu.init();
		this.setTitle(MainFrame.getInstance().getResourceBundle().getString("title"));
		//action = new ActionManager();
		parentToolbar.changeLanguage();
		childToolbar.changeLanguage();
		this.validate();
		this.repaint();
		
	}

	/**
	 * @return the split2
	 */
	public JSplitPane getSplit2() {
		return split2;
	}

	/**
	 * @param split2 the split2 to set
	 */
	public void setSplit2(JSplitPane split2) {
		this.split2 = split2;
	}
	
	/**
	 * Metoda koja vrsi prikaz Login dijaloga prilikom pokretanja aplikacije
	 */
	public void showLogin() {
		loginDialog = LoginDialog.getInstance();
		loginDialog.setModalityType(ModalityType.APPLICATION_MODAL);
		loginDialog.setVisible(true);
	}

	/**
	 * @return the treeNames
	 */
	public HashMap<String, TableSchema> getTabele1() {
		return tabele1;
	}

	/**
	 * @param treeNames the treeNames to set
	 */
	public void setTabele1(HashMap<String, TableSchema> treeNames) {
		this.tabele1 = treeNames;
	}

	/**
	 * @return the tabeleNames
	 */
	public HashMap<String, String> getTabeleNames() {
		return tabeleNames;
	}

	/**
	 * @param tabeleNames the tabeleNames to set
	 */
	public void setTabeleNames(HashMap<String, String> tabeleNames) {
		this.tabeleNames = tabeleNames;
	}

	public TableSchema getTabelebyName(String tableName) {
		TableSchema ts = null ;
		for (String key: getTabele().keySet()) {
			if (getTabele().get(key).getName().equals(tableName)) {
				ts = getTabele().get(key) ;
			}
		    System.out.println("key : " + key);
		    System.out.println("value : " + MainFrame.getInstance().getTabele().get(key).getName());
		}
		// TODO Auto-generated method stub
		return ts;
	}
	

}
