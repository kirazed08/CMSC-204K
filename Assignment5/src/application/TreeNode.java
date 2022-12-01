package application;

public class TreeNode<S> {
	S data;
	TreeNode<S> RightChild,LeftChild;
public TreeNode(S dataNode) {
	this.data = dataNode;
	RightChild = null;
	LeftChild = null;
}
public TreeNode(TreeNode<S> node) {
	new TreeNode<S>(node);
}
public S getData() {
	return data;
	
}
}
