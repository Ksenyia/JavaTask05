package by.tc.task.main;

import org.apache.log4j.Logger;

import by.tc.task.datastructure.ArrayList;
import by.tc.task.datastructure.BinaryTree;
import by.tc.task.datastructure.Iterator;
import by.tc.task.datastructure.LinkedList;

public class Main {

	public Main() {
	}
	public static final Logger log = Logger.getLogger(Main.class);
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		LinkedList list2 = new LinkedList();
		Object object = new String("a");
		list.add("b");
		list.add("c");
		list.add(3);
		list.add(1, object);
		list2.addFirst("3");
		list2.addFirst("2");
		list2.addFirst("b");
		list2.addFirst("a");
		list2.addLast("0");
		list2.addLast(2);
		list2.addLast("c");
		list2.addLast("d");
		Iterator iterator = list.iterator();
		String message = "ArrayList iterator test";
		log.info(message);
		String test = null;
		while(iterator.hasNext()){
			test+=iterator.next() + " ";
		}
		log.info(test);
		message = "ArrayList iterator test end";
		log.info(message);
		Iterator iterator2 = list2.iterator();
		message = "LinkedList iterator test";
		log.info(message);
		test = null;
		while(iterator2.hasNext()){
			test+=iterator2.next() + " ";
		}
		log.info(test);
		BinaryTree tree = new BinaryTree();
		tree.addNode(1, "x");
		tree.addNode(4, "r");
		tree.addNode(2, "u");
		tree.addNode(3, "r");
		tree.addNode(6, "u");
		tree.addNode(5, "r");
		tree.addNode(0, "u");
		
		tree.inOrderBypass();
		
		tree.inOrderBypass();
		
		tree.contLevelOrder();
		tree.preOrderBypass();
	}
}   
