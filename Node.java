package org.ie.practice11;

public class Node {
    private Integer data;
    private Node left;
    private Node rigt;

    Node(int data){
        this.data= data;
        left=null;
        rigt=null;
    }
    Node(){}
    public Integer getData() {
        return data;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRigt() {
        return rigt;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRigt(Node rigt) {
        this.rigt = rigt;
    }

}
