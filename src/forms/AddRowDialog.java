package forms;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTable;

import app.MainFrame;
import forms.listener.OkAddRowListener;
import model.TableSchema;
/**
 * Klasa koja omogucuje otvaranje forme za dodavanje sloga zajedno sa dugmadima za rukovanje pomenutom akcijom.
 * @author Snezana
 *
 */
@SuppressWarnings("serial")
public class AddRowDialog extends JDialog {
	
	/**
	 * Dugme koje omogucuje dodavanje sloga u tabelu.
	 */
	private JButton okButton = new JButton("OK");
	/**
	 * Dugme koje omogucuje otkazivanje akcije dodavanja sloga u tabelu.
	 */
	private JButton cancelButton = new JButton("Cancel");
	/**
	 * Panel u kome se nalazi forma za dodavanje.
	 */
	private AddRowForm panel;
	/**
	 * Panel u kome se nalaze dugmad za rukovanje akcijom dodavanja sloga.
	 */
	private JPanel buttonPanel;
	/**
	 * Tabela u koju dodajemo slog.
	 */
	private TableSchema table;
	
	/**
	 * Konstruktor.
	 * @param isParent oznacava da li je potrebno otvoriti formu za dodavanje sloga parent ili child tabele.
	 */
	public AddRowDialog(boolean isParent) {
		setModal(true);
		panel = new AddRowForm(isParent,this);
		table = panel.getTable();
		
		setLayout(new BorderLayout());
		setLocation(7*MainFrame.getInstance().getTk().getScreenSize().width/24, 7*MainFrame.getInstance().getTk().getScreenSize().height/24);
		setSize(6*panel.getSize().width, 7*panel.getSize().height/2);
		add(BorderLayout.CENTER, panel);

		buttonPanel = new JPanel(new FlowLayout());
		cancelButton.addActionListener(new CancelListenerRow(this, isParent));
		cancelButton.addKeyListener(new CancelListenerRow(this, isParent));
		okButton.addActionListener(new OkAddRowListener(table,isParent, panel, this));
		okButton.addKeyListener(new OkAddRowListener(table, isParent, panel, this));
		buttonPanel.add(okButton);
		buttonPanel.add(cancelButton);
		add(BorderLayout.SOUTH, buttonPanel);
	}
}
