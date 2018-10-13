<<<<<<< HEAD
package app;

import app.MainFrame;
import connection.DBConnection;

public class App {

	public static void main(String[] args) {
		
		MainFrame main = MainFrame.getInstance();
		main.setVisible(true);
		DBConnection.getInstance().getConnection();
	
	}
	
}
=======
package app;

import app.MainFrame;
import connection.DBConnection;

public class App {

	public static void main(String[] args) {
		
		MainFrame main = MainFrame.getInstance();
		main.setVisible(true);
		DBConnection.getInstance().getConnection();
	
	}
	
}
>>>>>>> origin/master
