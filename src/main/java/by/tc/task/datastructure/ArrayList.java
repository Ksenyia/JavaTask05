package by.tc.task.datastructure;

public class ArrayList {

	private  Object array[];
	private int size;
	private int capasity;
	
	public ArrayList() {
		size = 0;
	}
	public ArrayList(int capasity) {
		this.capasity=capasity;
		array = new Object[capasity];
	}
	
	public Object get(int index){
		return array[index];
	}
	public void set(int index, Object element) {
		array[index] = element;
	}
	public int size() {
		return size;
	}
	public void add(Object element){
		if (size==capasity){
			capasity++;
		}
		if(size!=0){
			size++;
			Object newArray[] = new Object[capasity];
			System.arraycopy(array, 0, newArray, 0, size-1);
			newArray[size-1]=element;
			array = new Object[capasity]; 
			System.arraycopy(newArray, 0, array, 0, size);
		}
		if(size==0){
			size = 1;
			array = new Object[capasity];
			array[0] = element;
		}
	}
	public void add(int index, Object element){
		if (size==capasity){
			capasity++;
		}
		size++;
		Object newArray[] = new Object[capasity];
		System.arraycopy(array, 0, newArray, 0, size-1);
		for(int i = size - 1; i > index; i--){
			newArray[i] = newArray[i - 1];
		}
		newArray[index]=element;
		array = new Object[capasity]; 
		System.arraycopy(newArray, 0, array, 0, size);
	}
	public Object remove(int index){
		Object removedObject = array[index];
		size--;
		for(int i = index; i < size; i++){
			array[i]=array[i+1];
		}
		return removedObject;
	}
	public int indexOfObject(Object element){
		for(int i = 0; i< size; i++){
			if(array[i]==element){
				return i;
			}
		}
		return -1;
	}
	public int lastIndexOfObject(Object element){
		for(int i = size-1; i<= 0; i--){
			if(array[i]==element){
				return i;
			}
		}
		return -1;
	}
	public ArrayList subList(int from,int to){
		int newSize = to - from +1;
		ArrayList arrayList = new ArrayList(newSize);
		for(int i = to; i< from + 1; i++){
			arrayList.add(array[i]);
		}
		return arrayList;
	} 
	    private class MyIterator implements Iterator {
	 
	        private int index;
	 
	        public MyIterator() {
	        }
	 
	        public boolean hasNext() {
	            return index < array.length;
	        }
	 
	        public Object next() {
	            return array[index++];
	        }

			public void remove() {
				size--;
				for(int i = index; i < size; i++){
					array[i]=array[i+1];
				}
			}
	 
	    }
	    public Iterator iterator() {
	        return new MyIterator();
	    }
}
