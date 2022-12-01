package application;

import static org.junit.Assert.assertEquals;


import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

public class MorseCodeTree_StudentTest {
	protected MorseCodeTree tr  = new MorseCodeTree();
	@Before
	public void setUp() throws Exception {
		tr = new MorseCodeTree();
	}

	@After
	public void tearDown() throws Exception {
		tr = null;
	}

	@Test
	public void addNode() {
		
		TreeNode<String> treeNode = tr.getRoot();
		tr.addNode(treeNode, "-.-", "k");
		String node = tr.fetchNode(treeNode, "-.-");
		assertEquals(node,  "k");
	}
	@Test
	public void insert() {
		tr.insert("-.-", "k");
		String code = tr.fetch("-.-");
	assertEquals(code,  "k");
		
		
	}
	@Test
	public void fetch() {
	String fetch = tr.fetch("-.--" );
	assertEquals( fetch, "y");
	}
	@Test
	public void fetchNode() {
		TreeNode<String> treeNode = tr.getRoot();
		String fetchN = tr.fetchNode(treeNode, ".--");
		
		assertEquals( fetchN, "w");
	}

	@Test
	public void testToArrayList() {
	
		String result = "";
		ArrayList<String> list = tr.toArrayList();
		
		
		for (String letter : list) {
			result += letter + " ";
		}
		
		result = result.trim();
	
		assertEquals("h s v i f u e l r a p w j  b d x n c k y t z g q m o", result);
	}

}
