package by.tc.task.main;

import by.tc.task.datastructure.ArrayList;
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
		list2.addFirst("b");
		list2.addFirst("a");
		list2.addFirst("0");
		list2.addLast("c");
		list2.addLast("d");
		System.out.println(list2.removeFirst());
		for (int i = 0;i<4;i++){
		System.out.println(list2.getLast());
		}
		for (int i = 0;i<4;i++){
		System.out.println(list2.getFirst());
		}
		for (int i = 0;i<list.size();i++){
		//System.out.println(list.get(i));
		}
		//System.out.println(list2.get(0));

	}

}
