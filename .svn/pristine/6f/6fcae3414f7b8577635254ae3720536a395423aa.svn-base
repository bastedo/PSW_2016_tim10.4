package ra244;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import model.Node;
import model.Nodes;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class NodesTest {
	
	private Nodes nodes;
	
	private String name;
	private String code;
	private int index;
	private Node node;
	private ArrayList<Node> childrenNode;
	
	@Parameters
	public static Collection<Object[]> data() {
		
		Node n1 = new Node();
		n1.setName("Node1");
		n1.setCode("node1");

		
		Nodes children = new Nodes();
		Node n11 = new Node();
		n11.setName("NodeChild11");
		n11.setCode("nodechild11");

		
		Node n12 = new Node();
		n12.setName("NodeChild12");
		n12.setCode("nodechild12");

		
		Node n13 = new Node();
		n13.setName("NodeChild13");
		n13.setCode("nodechild13");

		
		children.addNode(n11);
		children.addNode(n12);
		children.addNode(n13);
		
		n1.setChildren(children);
		
		Node n2 = new Node();
		n2.setName("Node2");
		n2.setCode("node2");

		
		Nodes children2 = new Nodes();
		Node n21 = new Node();
		n21.setName("NodeChild21");
		n21.setCode("nodechild21");

		
		Node n22 = new Node();
		n22.setName("NodeChild22");
		n22.setCode("nodechild22");

		
		Node n23 = new Node();
		n23.setName("NodeChild23");
		n23.setCode("nodechild23");

		
		children2.addNode(n21);
		children2.addNode(n22);
		children2.addNode(n23);
		
		n2.setChildren(children2);
		
		Node n3 = new Node();
		n3.setName("Node3");
		n3.setCode("node3");

		
		Nodes children3 = new Nodes();
		Node n31 = new Node();
		n31.setName("NodeChild31");
		n31.setCode("nodechild31");

		
		Node n32 = new Node();
		n32.setName("NodeChild32");
		n32.setCode("nodechild32");

		
		Node n33 = new Node();
		n33.setName("NodeChild33");
		n33.setCode("nodechild33");

		
		children2.addNode(n31);
		children2.addNode(n32);
		children2.addNode(n33);
		
		n2.setChildren(children3);
		
		ArrayList<Node> childrenNodes1 = new ArrayList<Node>();
		childrenNodes1.add(n11);
		childrenNodes1.add(n12);
		childrenNodes1.add(n13);
		
		ArrayList<Node> childrenNodes2 = new ArrayList<Node>();
		childrenNodes2.add(n21);
		childrenNodes2.add(n22);
		childrenNodes2.add(n23);
		
		ArrayList<Node> childrenNodes3 = new ArrayList<Node>();
		childrenNodes3.add(n31);
		childrenNodes3.add(n32);
		childrenNodes3.add(n33);
		
		
		return Arrays.asList(
				new Object[]{"Node1","node1",0,n1,childrenNodes1},
				new Object[]{"Node2","node2",1,n2,childrenNodes2},
				new Object[]{"Node3","node3",2,n3,childrenNodes3});
}
	
	public NodesTest(String name, String code, int index ,Node node, ArrayList<Node> children) {
		this.name = name;
		this.code = code;
		this.index = index;
		this.node = node;
		this.childrenNode = children;
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		nodes = new Nodes();
		nodes.setNodes(childrenNode);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testGetChildrens() {
		ArrayList<Node> nodesTest = nodes.getNodes();
		assertEquals(childrenNode, nodesTest);
	}

	@Test
	public void testGetChildren() {
		ArrayList<Node> childTest = nodes.getNodes();
		assertEquals(childrenNode.get(index), childTest.get(index));
	}

	@Test
	public void testSetChildren() {
		Nodes nodes = new Nodes();
		nodes.setNodes(childrenNode);
		assertEquals(childrenNode, nodes.getNodes());
	}

	@Test
	public void testAddNode() {
		ArrayList<Node> childTest = nodes.getNodes();
		Node node = new Node();
		node.setName("New node");
		node.setCode("newNode");
		childrenNode.add(node);
		assertEquals(childrenNode.size(), childTest.size());
		assertEquals(childrenNode.get(index).getName(), childTest.get(index).getName());
		assertEquals(childrenNode.get(index).getCode(), childTest.get(index).getCode());
		
	}

	@Test
	public void testSize() {
		ArrayList<Node> list = nodes.getNodes();
		assertEquals(childrenNode.size(), list.size());
	}

}
