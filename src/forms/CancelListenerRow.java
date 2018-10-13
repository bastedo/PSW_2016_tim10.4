<<<<<<< HEAD
package forms;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/**
 * Klasa koja mredstavlja listener za dugme odustajanja
 * @author Snezana
 *
 */
public class CancelListenerRow implements KeyListener, ActionListener{
	/**
	 * Atribut koji predstavlja informaciju o tome da li se akcija izvrsava nad 
	 * parent {@code TRUE} ili child tabelom {@code FALSE}
	 */
	public boolean isParent;
	/**
	 * Atibut koji predstavlja objekata nad koji treba da se izvrsi otkazivanje akcije
	 * { {@code EditRowDialog}, {@code DeleteRowDialog} ili {@code AddRowDialog}}
	 */
	public Object object; 
	/**
	 * Konstruktor unutar kog se vrsi inicijalizacija atributa na osnovu prosledjenih vrednosti
	 * @param object nad kojim se vrsi otkazivanje operacije
	 * @param isParent da li se vrsi nad parent {@code TRUE} ili child tabelom {@code FALSE}
	 */
	public CancelListenerRow(Object object, boolean isParent ){
		this.object = object;
		this.isParent = isParent;
		
	}
	/**
	 * Metoda unutar koje se vrsi dispose odgovarajuceg objekta 
	 * i disable-ovanje odgovarajucih akcija u zavisnosti da li je u piranju child ili parent tabela
	 */
	public void cancel(){
		 if (object instanceof DeleteRowDialog){
			DeleteRowDialog dialog = (DeleteRowDialog) object;
			dialog.dispose();
		} else if (object instanceof AddRowDialog){
			AddRowDialog dialog = (AddRowDialog) object;
			dialog.dispose();
		}
		
	}
	/* METODE KOJE SU AUTOGENERISANE OD STRANE IMPLEMENTIRANIH KLASA */
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		cancel();
	}

	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		cancel();
	}

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
=======
package forms;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/**
 * Klasa koja mredstavlja listener za dugme odustajanja
 * @author Snezana
 *
 */
public class CancelListenerRow implements KeyListener, ActionListener{
	/**
	 * Atribut koji predstavlja informaciju o tome da li se akcija izvrsava nad 
	 * parent {@code TRUE} ili child tabelom {@code FALSE}
	 */
	public boolean isParent;
	/**
	 * Atibut koji predstavlja objekata nad koji treba da se izvrsi otkazivanje akcije
	 * { {@code EditRowDialog}, {@code DeleteRowDialog} ili {@code AddRowDialog}}
	 */
	public Object object; 
	/**
	 * Konstruktor unutar kog se vrsi inicijalizacija atributa na osnovu prosledjenih vrednosti
	 * @param object nad kojim se vrsi otkazivanje operacije
	 * @param isParent da li se vrsi nad parent {@code TRUE} ili child tabelom {@code FALSE}
	 */
	public CancelListenerRow(Object object, boolean isParent ){
		this.object = object;
		this.isParent = isParent;
		
	}
	/**
	 * Metoda unutar koje se vrsi dispose odgovarajuceg objekta 
	 * i disable-ovanje odgovarajucih akcija u zavisnosti da li je u piranju child ili parent tabela
	 */
	public void cancel(){
		 if (object instanceof DeleteRowDialog){
			DeleteRowDialog dialog = (DeleteRowDialog) object;
			dialog.dispose();
		} else if (object instanceof AddRowDialog){
			AddRowDialog dialog = (AddRowDialog) object;
			dialog.dispose();
		}
		
	}
	/* METODE KOJE SU AUTOGENERISANE OD STRANE IMPLEMENTIRANIH KLASA */
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		cancel();
	}

	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		cancel();
	}

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
>>>>>>> origin/master
