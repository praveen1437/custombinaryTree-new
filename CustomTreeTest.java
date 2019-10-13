package org.ie.practice11;

public class CustomTreeTest {
    public static void main(String[] args) {
        CustomBinaryTree cb = new CustomBinaryTree();
       for(int i=0;i<150;i++) {
    	   cb.add(i);
       }
        cb.traverseInOrder(cb.getRoot());
        cb.remove(140);
        cb.traverseInOrder(cb.getRoot());
        
        //System.out.println(cb.lookUp(21).getData());
        //System.out.println(cb.getRoot().getData());
        }
}
