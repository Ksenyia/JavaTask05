package by.tc.task.datastructure;

public class BinaryTree {

	public BinaryTree() {
	}
	Node root;

	public void addNode(int key, String name) {
		Node newNode = new Node(key, name);
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
	public void inOrderBypass(Node focusNode) {

		if (focusNode != null) {
			inOrderBypass(focusNode.left);
			inOrderBypass(focusNode.right);
		}

	}
    void preOrderBypass(Node focusNode){
        ArrayList list = new ArrayList (); 
        while (focusNode!=null || list.size()!=0){
            if (list.size()!=0){
            	int last = list.size()-1;
            	focusNode =(Node) list.remove(last);
            }
            while (focusNode!=null){
                if (focusNode.right!=null) list.add(focusNode.right);
                focusNode=focusNode.left;
            }
        }
   }

    static void contLevelOrder(Node top){
    	LinkedList list=new LinkedList();
        do{
            if (top.left!=null){
            	list.addLast(top.left);
            }
            if (top.right!=null){
            	list.addLast(top.right);
            }
            if (list.size()!=0){
            	top=(Node) list.removeFirst();
            }
        }while (list.size()!=0);
    }
    
	public Node findNode(int key) {
		
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
		return focusNode;
	}

}

class Node {

	int key;
	String name;

	Node left;
	Node right;

	Node(int key, String name) {

		this.key = key;
		this.name = name;

	}

	public String toString() {
		return name + " has the key " + key;
	}

}
