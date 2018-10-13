package action;

import action.DemoteAction;
import action.PromoteAction;
/**
 * 	Klasa unutar koje se vrsi inicijalizacija svih akcija koje se dodaju na dugme
 * 	@author Snezana Stevanovic
 */
public class ActionManager {

	/**
	 * Atribut koji predstavlja Promote akciju
	 */
	private PromoteAction promote;
	/**
	 * Atrinut koji predstavlja Demote akciju
	 */
	private DemoteAction demote;
	/**
	 * Atribut koji predstavlja AddRow akciju za Parent tabelu
	 */
	private AddRowAction addRowTrue;
	/**
	 * Atribut koji predstavlja AddRow akciju za Child tabelu
	 */
	private AddRowAction addRowFalse;
	
	/**
	 * Atribut koji predstavlja EditRow akciju
	 */
	private EditRowAction editRow;
	/**
	 * Atribut koji predstavlja DeleteRow akciju za Parent tabelu
	 */
	private DeleteRowAction deleteRowTrue;
	
	/**
	 * Atribut koji predstavlja DeleteRow akciju za Child tabelu
	 */
	private DeleteRowAction deleteRowFalse;
	/**
	 * Atribut koji predstavlja Search akciju
	 */
	private SearchAction search;
	
	public ActionManager(){
		super();
		promote = new PromoteAction();
		demote = new DemoteAction();
		addRowTrue = new AddRowAction(true);
		addRowFalse = new AddRowAction(false);
		editRow = new EditRowAction();
		deleteRowTrue = new DeleteRowAction(true);
		deleteRowFalse = new DeleteRowAction(false);
		search = new SearchAction();
	}


	public PromoteAction getPromote() {
		return promote;
	}

	public void setPromote(PromoteAction promote) {
		this.promote = promote;
	}

	public DemoteAction getDemote() {
		return demote;
	}

	public void setDemote(DemoteAction demote) {
		this.demote = demote;
	}

	public AddRowAction getAddRowTrue() {
		return addRowTrue;
	}


	public void setAddRowTrue(AddRowAction addRowTrue) {
		this.addRowTrue = addRowTrue;
	}


	public AddRowAction getAddRowFalse() {
		return addRowFalse;
	}


	public void setAddRowFalse(AddRowAction addRowFalse) {
		this.addRowFalse = addRowFalse;
	}


	public EditRowAction getEditRow() {
		return editRow;
	}


	public void setEditRow(EditRowAction editRow) {
		this.editRow = editRow;
	}

	public DeleteRowAction getDeleteRowTrue() {
		return deleteRowTrue;
	}


	public void setDeleteRowTrue(DeleteRowAction deleteRowTrue) {
		this.deleteRowTrue = deleteRowTrue;
	}


	public DeleteRowAction getDeleteRowFalse() {
		return deleteRowFalse;
	}


	public void setDeleteRowFalse(DeleteRowAction deleteRowFalse) {
		this.deleteRowFalse = deleteRowFalse;
	}


	public SearchAction getSearch() {
		return search;
	}


	public void setSearch(SearchAction search) {
		this.search = search;
	}
	
	
}
