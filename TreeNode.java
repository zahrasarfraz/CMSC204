package assignment2222;

//make a tree genric class 
//add getter and setters for the right and left child
/**
 * The external Tree Node for Linked Trees
 * @author ZahraSarfraz
 * @param <T> data type of TreeNode
 */
public class TreeNode<T> {

	T data;
	TreeNode<T> right;
	TreeNode<T> left;
	
	/**
	 * Create a new TreeNode with left and right child set to null and data set to the dataNode
	 * @param dataNode data to be stored in the treenode
	 */
	public TreeNode(T dataNode) {
		data =dataNode;
		left=null;
		right=null;
	}
	
	/**
	 * Is used for making deep copies
	 * @param node node to make copy of 
	 */
	public TreeNode(TreeNode<T> node) {
		data=node.data;
		right=node.right;
		left=node.left;
	}
	
	/**
	 * Return the data within this TreeNode
	 * @return data within the tree node
	 */
	public T getData() {
		return data;	
	}
	
	/**
	 * To access the right child of the node 
	 * @return right child of the node
	 */
	public TreeNode<T> getRight(){
		return right;	
	}
	
	/**
	 * To set the value of the right child of the node
	 * @param right the value of right
	 */
	public void setRight(TreeNode<T> right){
		this.right=right;
	}
	
	/**
	 * To acess the left child of the node
	 * @return left child of the node
	 */
	public TreeNode<T> getLeft(){
		return left;
	}
	
	/**
	 * to set the vaue of the left child of the node
	 * @param left the value of the left
	 */
	public void setLeft(TreeNode<T> left) {
		this.left=left;
	}
	
}


