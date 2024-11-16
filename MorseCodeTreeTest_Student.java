package assignment2222;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * test for morse code tree class
 */
public class MorseCodeTreeTest_Student {
	protected MorseCodeTree tree;
	
	
	@Before
	public void setUp() throws Exception {
		tree = new MorseCodeTree();
	}

	@After
	public void tearDown() throws Exception {
		tree = null;
	}

	@Test
	public void testGetRoot() {
		assertEquals(tree.getRoot().getData(), "");
	}

	@Test
	public void testSetRoot() {
		TreeNode<String> newRoot = new TreeNode<String>("b");
		tree.setRoot(newRoot);
		assertEquals(tree.getRoot(), newRoot);
	}

	@Test
	public void testInsert() {
		tree.insert("-...","b");
		tree.insert("---", "o");
		assertEquals(tree.fetch("-..."),"b");
		assertEquals(tree.fetch("---"), "o");
	}


	@Test
	public void testFetch() {
		tree.insert("--..","z");
		assertEquals(tree.fetch("--.."), "z");
		tree.insert("..-.", "f");
		assertEquals(tree.fetch("..-."), "f");
	}

	@Test
	public void testToArrayList() {
		String result = "";
		ArrayList<String> list = tree.toArrayList();
		
		for (String letter : list) {
			result += letter + " ";
		}
		
		result = result.trim();
		
		assertEquals("h s v i f u e l r a p w j  b d x n c k y t z g q m o", result);
	}

}
