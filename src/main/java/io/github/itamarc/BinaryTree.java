package io.github.itamarc;

public class BinaryTree<T> {
    public T value;
    public BinaryTree<T> left;
    public BinaryTree<T> right;

    public BinaryTree(T value) {
        this.value = value;
    }

    public void insertLeft(T value) {
        BinaryTree<T> newNode = new BinaryTree<T>(value);
        this.left = newNode;
    }

    public void insertRight(T value) {
        BinaryTree<T> newNode = new BinaryTree<T>(value);
        this.right = newNode;
    }
}
