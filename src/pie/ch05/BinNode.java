package pie.ch05;

public class BinNode<T> {

    private BinNode<T> left;
    private BinNode<T> right;
    private T value;

    public BinNode(T value) {
	this.value = value;
    }

    public T getValue() {
	return value;
    }

    public void setLeft(BinNode<T> left) {
	this.left = left;
    }

    public void setRight(BinNode<T> right) {
	this.right = right;
    }

    public BinNode<T> getLeft() {
	return left;
    }

    public BinNode<T> getRight() {
	return right;
    }
}
