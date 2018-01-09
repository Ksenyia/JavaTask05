package test;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

import by.tc.task.datastructure.ArrayList;
import by.tc.task.datastructure.Iterator;


public class ArrayListTest {
	
    @Test
    public void testAddIndex() {
    	ArrayList list = new ArrayList();
		Object object = new String("a");
		list.add("b");
		list.add("c");
		list.add(3);
		list.add(1, object);
        assertEquals(object, list.get(1));
    }
    @Test
    public void testAdd() {
    	ArrayList list = new ArrayList();
		list.add("b");
		list.add("c");
		list.add(3);
		int result = 3;
        assertEquals(result, list.get(2));
    }
    @Test
    public void testRemove() {
    	ArrayList list = new ArrayList();
		list.add("b");
		list.add("c");
		list.add(3);
		int result = 3;
        assertEquals(result, list.remove(2));
    }
    @Test
    public void testRemove2() {
    	ArrayList list = new ArrayList();
		list.add("b");
		list.add("c");
		list.add("a");
		list.add(3);
		list.remove(2);
		int result = 3;
        assertEquals(result, list.get(2));
    }
    @Test
    public void testIteratorRemove() {
    	ArrayList list = new ArrayList();
		list.add("b");
		list.add("c");
		list.add("a");
		list.add(3);
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			iterator.remove();
		}
		int result = 0;
        assertEquals(result, list.size());
    }
    @Test
    public void testIteratorRemoveFirstTwoElements() {
    	ArrayList list = new ArrayList();
		list.add("b");
		list.add("c");
		list.add("a");
		list.add(3);
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
    	ArrayList list = new ArrayList();
		list.add("b");
		list.add("c");
		list.add("a");
		list.add(3);
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
   