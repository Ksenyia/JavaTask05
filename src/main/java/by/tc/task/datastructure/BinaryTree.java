package by.tc.task.datastructure;

public class BinaryTree {

	public BinaryTree() {
	}
	private Node root;
	private static void inOrderBypass(Node focusNode) {

		if (focusNode != null) {
			System.out.println(focusNode.key);
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
            	System.out.println(focusNode.key);
                if (focusNode.right!=null) {
                	list.add(focusNode.right);
                }
                focusNode=focusNode.left;
            }
        }
	}
	private static void contLevelOrder(Node focusNode){
		if (focusNode != null) {
			System.out.println(focusNode.key);
			inOrderBypass(focusNode.right);
			inOrderBypass(focusNode.left);
		}
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
			if (focusNode == null)
				return null;
		}
		return focusNode.element;
	}

}

class Node {

	int key;
	Object element;

	Node left;
	Node right;

	Node(int key, Object element) {

		this.key = key;
		this.element = element;

	}

	public String toString() {
		return element + " has the key " + key;
	}

}
