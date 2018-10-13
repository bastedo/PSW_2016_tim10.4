package model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JTree;
import javax.swing.tree.TreeNode;
/**
 * Klasa koja predstavlja listu cvorova 
 * {@link JTree} stabla aplikacije
 * 
 * @author Snezana Stevanovic
 *
 */
public class Nodes implements Serializable {

	private static final long serialVersionUID = 1L;
	private ArrayList<Node> nodes; //children
	
	public Nodes(){
		nodes = new ArrayList<Node>();
	}
	
	public Nodes(ArrayList<Node> n){
		this.nodes = n;
	}

	public ArrayList<Node> getNodes() {
		return nodes;
	}

	public void setNodes(ArrayList<Node> nodes) {
		this.nodes = nodes;
	}

	//NASE METODE
	public void addNode(Node child) {
		if(child!=null)
			nodes.add(child);
		
	}

	public TreeNode getChildren(int index) {
		return nodes.get(index);
	}

	
	public int getChildCount() {
		return nodes.size();
	}
	
}
