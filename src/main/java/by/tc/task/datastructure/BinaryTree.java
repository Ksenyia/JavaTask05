package by.tc.task.datastructure;

import org.apache.log4j.Logger;


public class BinaryTree {

	private Node root;
	
	public static final Logger log = Logger.getLogger(BinaryTree.class);
	
	private static void inOrderBypass(Node focusNode) {
		if (focusNode != null) {
			log.info(focusNode.key);
			inOrderBypass(focusNode.left);
			inOrderBypass(focusNode.right);
		}

	}
	
	private static void preOrderBypass(Node focusNode){
        ArrayList list = new ArrayList (); 
        while (focusNode!=null || list.size()!=0){
            if (list.size()!=0){
            	int first = 0;
            	focusNode =(Node) list.remove(first);
            }
            while (focusNode!=null){
            	log.info(focusNode.key);
                if (focusNode.right!=null) {
                	list.add(focusNode.right);
                }
                focusNode=focusNode.left;
            }
        }
	}
	
	private static void contLevelOrder(Node focusNode){
		if (focusNode != null) {
			inOrderBypass(focusNode.right);
			log.info(focusNode.key);
			inOrderBypass(focusNode.left);
		}
	}
	
	public BinaryTree() {
		
	}
	
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((root == null) ? 0 : root.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BinaryTree other = (BinaryTree) obj;
		if (root == null) {
			if (other.root != null)
				return false;
		} else if (!root.equals(other.root))
			return false;
		return true;
	}

	public void contLevelOrder(){
    	Node top = this.root;
    	contLevelOrder(top);
    }
    public void preOrderBypass(){
    	Node top = this.root;
    	preOrderBypass(top);
    }
    public void inOrderBypass(){
    	Node top = this.root;
    	inOrderBypass(top);
    }
	public void addNode(int key, Object element) {
		Node newNode = new Node(key, element);
		if (root == null) {
			root = newNode;
		} else {
			Node focusNode = root;
			Node parent;

			while (true) {
				parent = focusNode;
				if (key < focusNode.key) {
					focusNode = focusNode.left;

					if (focusNode == null) {
						parent.left = newNode;
						return; 
					}

				} else { 
					focusNode = focusNode.right;
					if (focusNode == null) {
						parent.right = newNode;
						return; 

					}

				}

			}
		}

	}
    
	public Object findNode(int key) {
		
		Node focusNode = root;
		
		while (focusNode.key != key) {
			if (key < focusNode.key) {
				focusNode = focusNode.left;
			} else {
				focusNode = focusNode.right;
			}
			if (focusNode == null){
				return null;
			}
		}
		return focusNode.element;
	}
	
	public boolean delete(int key) {

        if (root == null){
              return false;
        }
        else {
              if (root.key == key) {
                    Node newNote = new Node();
                    newNote.left = root;
                    boolean result = root.delete(key, newNote);
                    root = newNote.left;
                    return result;
              } else {
                    return root.delete(key, null);
              }
        }
  }

}

class Node {

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((element == null) ? 0 : element.hashCode());
		result = prime * result + key;
		result = prime * result + ((left == null) ? 0 : left.hashCode());
		result = prime * result + ((right == null) ? 0 : right.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (element == null) {
			if (other.element != null)
				return false;
		} else if (!element.equals(other.element))
			return false;
		if (key != other.key)
			return false;
		if (left == null) {
			if (other.left != null)
				return false;
		} else if (!left.equals(other.left))
			return false;
		if (right == null) {
			if (other.right != null)
				return false;
		} else if (!right.equals(other.right))
			return false;
		return true;
	}
	int key;
	Object element;

	Node left;
	Node right;

	Node(int key, Object element) {
		this.key = key;
		this.element = element;
	}

	public Node() {
	}

	public boolean delete(int key,Node parent) {
		if (key < this.key) {
			if (left != null){
	               return left.delete(key, this);
	         }
	         else{
	               return false;
	         }
		} 
		else {
			if (key > this.key) {
				if (right != null){
					return right.delete(key, this);
				}
		        else{
		        	return false;
		        }
			}
			else {
				if (left != null && right != null) {
					int minKey = right.minKey();
					Object value =right.findNode(minKey);
					this.key = minKey;
					this.element = value;
					right.delete(this.key,this);
				} else {
					if (parent.left == this) {
						if(left != null){
							parent.left =  left ;
						}
						else{
							parent.left =  right ;
						}
					} 
					else {
						if (parent.right == this) {
							if(left != null){
								parent.left =  left ;
			      		   	}
			      		   	else{
			      				parent.left =  right ;
			      		   	}
						}
					}
				}
	         return true;
			}
		}
	}
    public int minKey() {
        if (left == null){
              return key;
        }
        else{
              return left.minKey();
        }
    }
    
	public Object findNode(int key) {
		
		Node focusNode = this;
		
		while (focusNode.key != key) {
			if (key < focusNode.key) {
				focusNode = focusNode.left;
			} else {
				focusNode = focusNode.right;
			}
			if (focusNode == null){
				return null;
			}
		}
		return focusNode.element;
	}
	public String toString() {
		return element + " has the key " + key;
	}
	
}
