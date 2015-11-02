package homework2;

public class BSTNode {
	private BSTNode left = null;
	private BSTNode right = null;
	private int key;
	
	public BSTNode(int insert) {
		this.setKey(insert);
	}

	public BSTNode getLeft() {
		return left;
	}
	
	public void setLeft(BSTNode left) {
		this.left = left;
	}
	
	public BSTNode getRight() {
		return right;
	}
	
	public void setRight(BSTNode right) {
		this.right = right;
	}
	
	public int getKey() {
		return key;
	}
	
	public void setKey(int key) {
		this.key = key;
	}
}
