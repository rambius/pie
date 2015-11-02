package pie.ch05;

import java.util.Comparator;

public class BST<T extends Comparable<T>> {

    private BinNode<T> root;

    public BST() {
	root = null;
    }

    public void addRec(T value) {
	if (root == null) {
	    root = new BinNode<T>(value);
	    return;
	}
	addRec(value, root);	
    }

    private void addRec(T value, BinNode<T> node) {
	int c = value.compareTo(node.getValue());
	if (c == 0) {
	    return;
	} else if (c == -1) {
	    BinNode<T> left = node.getLeft();
	    if (left == null) {
		left = new BinNode<T>(value);
		node.setLeft(left);
	    } else {
		addRec(value, left);
	    }
	} else { 
	    BinNode<T> right = node.getRight();
	    if (right == null) {
		right = new BinNode<T>(value);
		node.setRight(right);
	    } else {
		addRec(value, right);
	    }
	}
    }

    public int sizeRec() {
	return sizeRec(root);
    }

    private int sizeRec(BinNode<T> node) {
	if (node == null) {
	    return 0;
	}
	return 1 + sizeRec(node.getLeft()) + sizeRec(node.getRight());
    }

    public boolean isEmpty() {
	return root == null;
    }

    public T min() {
	if (isEmpty()) {
	    return null;
	}
	BinNode<T> node = root;
	while (node.getLeft() != null) {
	    node = node.getLeft();
	}
	return node.getValue();
    }

    public T max() {
	if (isEmpty()) {
	    return null;
	}
	BinNode<T> node = root;
	while (node.getRight() != null) {
	    node = node.getRight();
	}
	return node.getValue();
    }

    public BinNode<T> findRec(T value) {
	if (root == null) {
	    return null;
	}
    	return findRec(value, root);
    }

    public BinNode<T> findRec(T value, BinNode<T> node) {
	int c = value.compareTo(node.getValue());
	if (c == 0) {
	    return node;
	} else if (c < 0) {
	    return findRec(value, node.getLeft());
	} else {
	    return findRec(value, node.getRight());
	}
    }
}
