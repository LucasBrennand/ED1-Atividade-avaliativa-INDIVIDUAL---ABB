package br.unicap.edi.trees;

import br.unicap.edi.Queue;
import br.unicap.edi.trees.BinaryTree;

public class Node <T extends Comparable<T>> {
    private Node<T> left;
    private T info;
    private Node<T> right;
    public Node (T value) {
        this.info = value;
    }
    public T getInfo() {
        return this.info;
    }
    public void setInfo(T value) {
        this.info = value;
    }
    public Node<T> getLeft () {
        return this.left;
    }
    public void setLeft (Node<T> newLeft) {
        this.left = newLeft;
    }
    public Node<T> getRight () {
        return this.right;
    }
    public void setRight (Node<T> newRight) {
        this.right = newRight;
    }
    void insertNode (T value){
        if (value.compareTo(this.getInfo()) == 0) {
            System.out.println("Valor repetido.");
        }
        else if (value.compareTo(this.getInfo()) < 0) {
            if (this.left == null){
                this.left = new Node (value);
            }
            else {
                this.left.insertNode (value);
            }
        }
        else {
            if (this.right == null){
                this.right = new Node (value);
            }
            else {
                this.right.insertNode (value);
            }
        }
    }
    T findNode (T value) {
        if (value.compareTo(this.getInfo()) == 0) {
            return this.getInfo();
        }
        else if (value.compareTo(this. getInfo()) < 0) {
            if (this.getLeft() == null){
                return null;
            }
            else {
                return this.getLeft().findNode (value);
            }
        }
        else {
            if (this.getRight() == null){
                return null;
            }
            else {
                return this.getRight().findNode (value);
            }
        }
    }
}