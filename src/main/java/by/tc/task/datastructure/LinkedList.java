package by.tc.task.datastructure;

public class LinkedList {

	private LinkedList note; 
	private Object element;
	private int size;
	public LinkedList() {
		size = 0;
		note = null;
	}
	public void addLast(Object element) {
		size++;
		if(note==null){
			this.element = element;
			note = null;
		}
		else{
			note.addLast(element);
		}
	}
	public int size() {
		return size;
	}
	public void addFirst(Object element) {
		size++;
		if(note==null){
			this.element = element;
			note = new LinkedList();
		}
		else{
			LinkedList newNote = new LinkedList();
			newNote.element = this.element;
			newNote.note = this.note;
			this.element = element;
			this.note = newNote;
		}
	}
	public Object getFirst() {
		return element;
	}
	public Object getLast() {
		if(note==null){
			return element;
		}
		else{
			return note.getLast();
		}
	}
	public Object removeFirst(){
		if(note==null){
			size = 0;
			Object removedObject = this.element;
			element = null;
			return removedObject;
		}
		size--;
		Object removedObject = this.element;
		LinkedList newNote = new LinkedList();
		newNote = this.note;
		this.element = newNote.element;
		this.note = newNote.note;
		return removedObject;
	}
	public Object removeLast() {
		size--;
		if(note.note==null){
			Object removedObject = this.element;
			this.element = null;
			this.note = null;
			return removedObject;
		}
		else{
			return note.removeLast();
		}
	}
    private class MyIterator implements Iterator {
   	 
        private int index;
 
        public MyIterator() {
        }
 
        public boolean hasNext() {
            return index < size;
        }
 
        public Object next() {
            return note.note;
        }

		public void remove() {
			size--;
			LinkedList newNote = new LinkedList();
			newNote = note;
			element = newNote.element;
			note = newNote.note;
			}
		}
    public Iterator iterator() {
        return new MyIterator();
    }
}
