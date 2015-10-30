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
	if (value.compareTo(node.getValue()) == 0) {
	    return;
	}
	if (value.compareTo(node.getValue()) == -1) {
	    BinNode<T> left = node.getLeft();
	    if (left == null) {
		left = new BinNode<T>(value);
		node.setLeft(left);
	    } else {
		addRec(value, left);
	    }
	} else{ 
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
}
