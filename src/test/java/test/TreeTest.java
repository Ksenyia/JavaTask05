package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import by.tc.task.datastructure.BinaryTree;

public class TreeTest {
	
    @Test
    public void testFind() {
		BinaryTree tree = new BinaryTree();
		tree.addNode(1, "x");
		tree.addNode(4, "r");
		tree.addNode(2, "u");
		tree.addNode(3, "z");
		tree.addNode(6, "m");
		tree.addNode(5, "l");
		tree.addNode(0, "q");
		String result = "r";
        assertEquals(result, tree.findNode(4));
    }
    @Test
    public void testDelete() {
		BinaryTree tree = new BinaryTree();
		tree.addNode(1, "x");
		tree.addNode(4, "r");
		tree.addNode(2, "u");
		tree.addNode(3, "z");
		tree.addNode(6, "m");
		tree.addNode(5, "l");
		tree.addNode(0, "q");
        assertEquals(true, tree.delete(4));
    }
    @Test
    public void testDelete1() {
		BinaryTree tree = new BinaryTree();
		tree.addNode(1, "x");
		tree.addNode(4, "r");
		tree.addNode(2, "u");
		tree.addNode(3, "z");
		tree.addNode(6, "m");
		tree.addNode(5, "l");
		tree.addNode(0, "q");
        assertEquals(false, tree.delete(10));
    }
    @Test
    public void testDelete2() {
		BinaryTree tree = new BinaryTree();
		BinaryTree resultTree = new BinaryTree();
		tree.addNode(1, "x");
		tree.addNode(4, "r");
		tree.addNode(2, "u");
		tree.addNode(3, "z");
		tree.addNode(6, "m");
		tree.addNode(5, "l");
		tree.addNode(0, "q");
		
		resultTree.addNode(1, "x");
		resultTree.addNode(5, "l");
		resultTree.addNode(2, "u");
		resultTree.addNode(3, "z");
		resultTree.addNode(6, "m");
		resultTree.addNode(0, "q");
		
		tree.delete(4);
        assertEquals(resultTree, tree);
    }

}
