package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import by.tc.task.datastructure.Iterator;
import by.tc.task.datastructure.LinkedList;

public class LinkedListTest {
	
    @Test
    public void testAddFirst() {
    	LinkedList list = new LinkedList();
		Object object = new String("a");
		list.addFirst(object);
		list.addFirst("b");
		list.addFirst("c");
        assertEquals(object, list.getLast());
    }
    @Test
    public void testAddLast() {
    	LinkedList list = new LinkedList();
    	list.addLast(3);
		list.addLast("b");
		list.addLast("c");
		int result = 3;
        assertEquals(result, list.getFirst());
    }
    @Test
    public void testRemove() {
    	LinkedList list = new LinkedList();
		list.addLast("b");
		list.addLast("c");
    	list.addLast(3);
		int result = 3;
        assertEquals(result, list.remove(2));
    }
    @Test
    public void testRemoveFirst() {
    	LinkedList list = new LinkedList();
    	list.addLast(3);
		list.addLast("b");
		list.addLast("c");
		int result = 3;
        assertEquals(result, list.removeFirst());
    }
    @Test
    public void testRemoveLast() {
    	LinkedList list = new LinkedList();
		Object object = new String("a");
		list.addFirst(object);
		list.addFirst("b");
		list.addFirst("c");
        assertEquals(object, list.removeLast());
    }
    @Test
    public void testRemove2() {
    	LinkedList list = new LinkedList();
		list.addLast("b");
		list.addLast("c");
		list.addLast("a");
		list.addLast(3);
		list.remove(2);
		int result = 3;
        assertEquals(result, list.get(2));
    }
    @Test
    public void testRemoveFirst2() {
    	LinkedList list = new LinkedList();
		list.addLast("b");
		list.addLast("c");
		list.addLast("a");
		list.addLast(3);
		list.removeFirst();
		String result = "c";
        assertEquals(result, list.getFirst());
    }
    @Test
    public void testRemoveLast2() {
    	LinkedList list = new LinkedList();
		list.addLast("b");
		list.addLast("a");
		list.addLast("c");
		list.addLast(3);
		list.removeLast();
		String result = "c";
        assertEquals(result, list.getLast());
    }
    @Test
    public void testIteratorRemove() {
    	LinkedList list = new LinkedList();
		list.addLast("b");
		list.addLast("c");
		list.addLast("a");
		list.addLast(3);
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			iterator.remove();
		}
		int result = 0;
        assertEquals(result, list.size());
    }
    @Test
    public void testIteratorRemoveFirstTwoElements() {
    	LinkedList list = new LinkedList();
		list.addLast("b");
		list.addLast("c");
		list.addLast("a");
		list.addLast(3);
		Iterator iterator = list.iterator();
		int i =0;
		int DeleteElementCount = 2;
		while(i<DeleteElementCount){
			iterator.remove();
			i++;
		}
		int result = 2;
        assertEquals(result, list.size());
    }
    @Test
    public void testIteratorRemoveFirstTwoElements2() {
    	LinkedList list = new LinkedList();
		list.addLast("b");
		list.addLast("c");
		list.addLast("a");
		list.addLast(3);
		Iterator iterator = list.iterator();
		int i =0;
		int DeleteElementCount = 2;
		while(i<DeleteElementCount){
			iterator.remove();
			i++;
		}
		String result = "a";
        assertEquals(result, list.get(0));
    }

}
