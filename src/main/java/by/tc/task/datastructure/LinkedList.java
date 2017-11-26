package by.tc.task.datastructure;

public class LinkedList {

	private LinkedList note; 
	private Object element;
	private int size;
	private int indexReverse;
	private int  index;
	private void increaseSize(){
		size++;
		index = size-indexReverse;
		if(note==null){
		}
		else{
			note.increaseSize();
		}
	}
	private void decreaseSize(){
		size--;
		index = size-indexReverse;
		
		if(note==null){
		}
		else{
			note.decreaseSize();
		}
	}
	private void changeIndex(int index){
		this.index = index;
		indexReverse = size-index;
		if(note==null){
			
		}
		else{
			note.changeIndex(++index);
		}
	}
	public LinkedList() {
		size = 0;
		note = null;
		indexReverse = 0;
	}
	public void addLast(Object element) {
		size++;
		indexReverse++;
		index = size-indexReverse;
		if(note==null){
			this.element = element;
			note = new LinkedList();
			note.size=size;
			note.index = size-note.indexReverse;
		}
		else{
			note.addLast(element);
		}
	}
	public int size() {
		return size;
	}
	public void addFirst(Object element) {
		increaseSize();
		if(note==null){
			this.element = element;
			note = new LinkedList();
		}
		else{
			LinkedList newNote = new LinkedList();
			note.size=size;
			newNote.size = size;
			newNote.element = this.element;
			newNote.note = this.note;
			newNote.indexReverse= this.indexReverse;
			this.element = element;
			this.note = newNote;
		}
		indexReverse++;
	}
	public Object getFirst() {
		return element;
	}
	public Object getLast() {
		if(note.note==null){
			return element;
		}
		else{
			return note.getLast();
		}
	}
	public Object get(int index) {
		
		if(index==this.index){
			return element;
		}
		else{
			if(this.size>index){
				return note.get(index);
			}
			else{
				return null;
			}
		}
	}
	public Object removeFirst(){
		if(note.note==null){
			size = 0;
			Object removedObject = this.element;
			element = null; 
			return removedObject;
		}
		decreaseSize();
		Object removedObject = this.element;
		LinkedList newNote = new LinkedList();
		newNote = this.note;
		newNote.size = size;
		this.element = newNote.element;
		this.note = newNote.note;
		this.index = 0;
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
	public Object remove(int index) {
		size--;
		if(this.index==index){
			if(note.note==null){
				size = 0;
				Object removedObject = this.element;
				element = null; 
				return removedObject;
			}
			note.decreaseSize();
			Object removedObject = this.element;
			LinkedList newNote = new LinkedList();
			newNote = this.note;
			this.element = newNote.element;
			this.note = newNote.note;
			this.changeIndex(index);
			return removedObject;
		}
		else{
			if(note!=null){
				return note.remove(index);
			}
		}
		return null;
	}
    private class MyIterator implements Iterator {
   	 
        private int index;
 
        public MyIterator() {
        }
 
        public boolean hasNext() {
     
        	return size>index;
        }
 
        public Object next() {
            return get(index++);
        }

		public void remove() {
			size--;
			if(index!=0){
				note.remove(index);
			}
			else{
				if(note.note==null){
					size = 0;
					element = null; 
				}
				decreaseSize();
				LinkedList newNote = new LinkedList();
				newNote = note;
				newNote.size = size;
				element = newNote.element;
				note = newNote.note;
				index = 0;
			}
		}
	}
    public Iterator iterator() {
        return new MyIterator();
    }
}
