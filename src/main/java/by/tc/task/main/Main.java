package by.tc.task.main;

import by.tc.task.datastructure.ArrayList;
import by.tc.task.datastructure.BinaryTree;
import by.tc.task.datastructure.Iterator;
import by.tc.task.datastructure.LinkedList;

public class Main {

	public Main() {
	}

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
		list2.remove(2);
		System.out.println(list2.removeLast());
		System.out.println(list2.getLast());
		for (int i = 0;i<list2.size();i++){
			System.out.print(list2.get(i)+ " ");
		}
		System.out.println();
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			System.out.print(iterator.next()+" ");
		}
		iterator = list.iterator();
		System.out.println();
		while(iterator.hasNext()){
			Object obj = iterator.next();
			if(obj.equals("a")){
				iterator.remove();
			}
		}
		list.remove(1);
		for (int i = 0;i<list.size();i++){
			System.out.print(list.get(i)+ " ");
		}
		System.out.println();
		Iterator iterator2 = list2.iterator();
		while(iterator2.hasNext()){
			System.out.print(iterator2.next()+" ");
		}
		System.out.println();
		BinaryTree tree = new BinaryTree();
		tree.addNode(1, "x");
		tree.addNode(4, "r");
		tree.addNode(2, "u");
		tree.addNode(3, "r");
		tree.addNode(6, "u");
		tree.addNode(5, "r");
		tree.addNode(0, "u");
		System.out.println(tree.findNode(4));
		tree.inOrderBypass();
		System.out.println();
		tree.contLevelOrder();
		System.out.println();
		tree.preOrderBypass();
	}

}
