package ra244;



import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import model.Column;
import model.Columns;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ColumnsTest {

	private Columns listColumn;
	private Column[] columns;
	
	private String name;
	private String code;
	private int index;
	private Column column;
	
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(
				new Object[]{"Jedan","KodJedan",0,new Column("Test kolona1","KodTest1","KodTest1","false","false","int")},
				new Object[]{"Dva", "KodDva", 1, new Column("Test kolona2","KodTest2","KodTest2","false","false","int")},
				new Object[]{"Tri", "KodTri", 2, new Column("Test kolona3","KodTest3","KodTest3","false","false","int")},
				new Object[]{"Cetiri", "KodCetiri", 3,new Column("Test kolona4","KodTest4","KodTest4","false","false","int")});
	}
	
	public ColumnsTest(String name, String code, int index, Column column) {
		this.name = name;
		this.code = code;
		this.index = index;
		this.column = column;
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		columns = new Column[5];
		columns[0] = new Column("Jedan","KodJedan","KodJedan","false","false","int");
		columns[1] = new Column("Dva","KodDva","KodDva","false","false","varchar");
		columns[2] = new Column("Tri","KodTri","KodTri","true","false","int");
		columns[3] = new Column("Cetiri","KodCetiri","KodCetiri","false","false","char");
		columns[4] = new Column("Pet","KodPet","KodPet","false","true","int");
	
		listColumn = new Columns();
		listColumn.addColumn(columns[0]);
		listColumn.addColumn(columns[1]);
		listColumn.addColumn(columns[2]);
		listColumn.addColumn(columns[3]);
		listColumn.addColumn(columns[4]);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetColumns() {
		assertEquals(Arrays.asList(columns), listColumn.getColumns());
	}



	@Test
	public void testGetColumnByCode() {
		assertEquals(columns[index], listColumn.getColumnByCode(code));
	}

	@Test
	public void testGetColumn() {
		assertEquals(columns[index],listColumn.getColumn(index));
	}



	@Test
	public void testSize() {
		assertEquals(columns.length, listColumn.size());
	}

}
