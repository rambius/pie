package pie.ch05;

import java.util.ArrayList;
import java.util.List;

public class TreeNode<T> {

    private T value;
    private List<TreeNode<T>> children;

    public TreeNode(T value) {
	this.value = value;
	children = new ArrayList<TreeNode<T>>();
    }

    public int getChildrenSize() {
	return children.size();
    }

    public TreeNode<T> getChild(int index) {
	return children.get(index);
    }

    public void addChild(TreeNode<T> child) {
	children.add(child);
    }
}
