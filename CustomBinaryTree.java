package org.ie.practice11;

public class CustomBinaryTree {
    private Node root;




    public void traverseInOrder(Node node){
        if (node==null)
            return;

        traverseInOrder(node.getLeft());
        System.out.print(node.getData()+"\t");
        traverseInOrder(node.getRigt());
    }





    public void setRoot(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public void add(int value) {
        Node node = new Node(value);

        //first node insertion
        if (root == null) {
            root = node;
            root.setLeft(null);
            root.setRigt(null);
        }
        //if a node is already is present in the tree

        else{
            Node currentNode = this.root;
            while (true) {

                if (node.getData() > currentNode.getData()) {
                    if (currentNode.getRigt() == null) {
                        currentNode.setRigt(node);
                        break;
                    } else {
                        currentNode = currentNode.getRigt();
                    }
                } else if (node.getData() < currentNode.getData()) {
                    if (currentNode.getLeft() == null) {
                       // System.out.println(node.getData());
                        currentNode.setLeft(node);
                        break;
                    } else {
                       // System.out.println(node.getData());
                        currentNode = currentNode.getLeft();
                    }
                } else {
                    break;
                }

            }
         }
        }
     public Node lookUp(int value){
        if(root==null){
            return null;
        }
        else {
            Node currentNode= this.root;
            while (currentNode!=null) {
            	//System.out.println(currentNode.getData());
                if(currentNode.getData()>value) currentNode=currentNode.getLeft();
                		
                else if(currentNode.getData()<value) currentNode=currentNode.getRigt();
                else if(currentNode.getData()==value) return currentNode;
                    }
                }
        return null;
        }


public String printTheELements(){
        if(root==null){
            return "Empty";
        }
        return null;
    }
   /** This method removes the node from the binary tree which matches the given value
    * @param value int value
    * @return if value is found returns the node object which contains that value
    * otherwise returns null
    */
    public Node remove(int value){
        if(root==null){
            return  null;
        }
        Node currentNode = this.root;
        Node  parentNode=null;
        while(currentNode!=null) {
            if (currentNode.getData() < value) {
                parentNode = currentNode;
                currentNode = currentNode.getRigt();
            } else if (currentNode.getData() > value) {
                parentNode = currentNode;
                currentNode = currentNode.getLeft();
            } 
            // When given value matches with node value           
            else if (currentNode.getData() == value) {
                 /**  when current node does not have any child nodes 
                  *   right child and left child are pointing to null        	
                  */
            	//System.out.println(currentNode.getData());
                if (currentNode.getLeft() == null&& currentNode.getRigt()==null) {
                	//System.out.println(currentNode.getData());
                        if(parentNode.getLeft()==currentNode) { parentNode.setLeft(null); return currentNode;}
                        if(parentNode.getRigt()==currentNode) { parentNode.setRigt(null);return currentNode;}
                   
                }
                /**
                 * current Node having only right child
                 */
                if(currentNode.getRigt()!=null&& currentNode.getLeft()==null) {
                	//System.out.println(currentNode.getData());
                	if(parentNode.getLeft()==currentNode) { parentNode.setLeft(currentNode.getRigt()); return currentNode;}
                    if(parentNode.getRigt()==currentNode) { parentNode.setRigt(currentNode.getRigt());return currentNode;}
                }
                /**
                 * current Node having only left child
                 */
                if(currentNode.getRigt()==null&& currentNode.getLeft()!=null) {
                	//System.out.println(currentNode.getData());
                	if(parentNode.getLeft()==currentNode) { parentNode.setLeft(currentNode.getLeft()); return currentNode;}
                    if(parentNode.getRigt()==currentNode) { parentNode.setRigt(currentNode.getLeft());return currentNode;}
                }
                /**
                 * current Node having two children
                 */
                if(currentNode.getRigt()!=null&&currentNode.getLeft()!=null) {
                	//System.out.println(currentNode.getData());
                	Node parentNode1= currentNode;
                	Node parentOfMin=currentNode;
                	currentNode=currentNode.getRigt();
                	//System.out.println(currentNode.getData());
                	/**
                	 * find out the min value in the right side sub tree
                	 */
                	while(currentNode.getLeft()!=null) {
                		//System.out.println(currentNode.getData());
                		
                		currentNode=currentNode.getLeft();
                		parentOfMin=currentNode;
                		
                	}
					/*
					 * System.out.println(parentNode.getData());
					 * System.out.println(currentNode.getData());
					 * System.out.println(parentOfMin.getData());
					 * 
					 */
                	
                	/**
                	 *  remove minimum node reference from Its current position
                	 *  replace the Node to be removed with minimum value Node
                	 *  such that 
                	 *  minimum value Node.right pointing towards removed node.right
                	 *  minimum value Node.left pointing towards removed node.left
                	 *  replace the removed node reference with minimum value node reference in the parent node
                	 *  
                	 */
                	currentNode.setLeft(parentNode1.getLeft());
                	if(parentNode.getLeft()==parentNode1) parentNode.setLeft(currentNode);
                    if(parentNode.getRigt()==parentNode1) parentNode.setRigt(currentNode); 
                	parentOfMin.setLeft(null);
                	
                	return parentNode1;
                	
                }
            }
        }
        return null;
    }
}
