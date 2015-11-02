package homework2;

public class BST {
	private BSTNode root;

	public BSTNode getRoot() {
		return root;
	}

	private void setRoot(BSTNode root) {
		this.root = root;
	}

	public void insert(BST tree, int insert) {
		BSTNode y = null; // this will be the parent of new node
		BSTNode x = tree.getRoot();
		while (x != null) {
			y = x;
			// traverse the tree
			if (insert < x.getKey()) {
				x = x.getLeft();
			} else {
				x = x.getRight();
			}
		}
		if (y == null) { // if insert is root
			tree.setRoot(new BSTNode(insert));
		} else if (insert < y.getKey()) {
			y.setLeft(new BSTNode(insert));
		} else {
			y.setRight(new BSTNode(insert));
		}
	}

	// deletes node from tree
	public void delete(BST tree, int delete) { // driver
		if (tree.getRoot().getKey() == delete) { // we need to change the root
			tree.setRoot(delete(tree.getRoot(), delete));
		} else {
			delete(tree.getRoot(), delete);
		}
	}

	// node = the node we are checking to delete
	// parent = parent of above node
	// delete = the value we are deleting
	private BSTNode delete(BSTNode node, int delete) {
		BSTNode temp = null;
		if (node.getKey() == delete) { // found node to delete
			temp = getMaxSuccessor(node); // will take node's place
			if (node.getLeft() != null) {
				if (node.getLeft() != null) {
					node.getLeft().setRight(temp.getLeft());
				}
				if (temp.getKey() != node.getLeft().getKey()) {
					temp.setLeft(node.getLeft());
				}
				temp.setRight(node.getRight());
			}
		} else if (node.getKey() < delete) {
			node.setRight(delete(node.getRight(), delete));
			temp = node;
		} else {
			node.setLeft(delete(node.getLeft(), delete));
			temp = node;
		}
		return temp;
	}

	// prints the values in the bst in ascending order
	public void treeWalk(BST tree) { // driver
		treeWalk(tree.getRoot());
	}

	private void treeWalk(BSTNode node) {
		if (node != null) {
			treeWalk(node.getLeft());
			System.out.println(node.getKey());
			treeWalk(node.getRight());
		}
	}

	// finds the maximum node
	// returns null if none found
	public BSTNode getMaxSuccessor(BSTNode node) { // driver & trival case check
		if (node.getLeft() != null) {
			node = node.getLeft();
			return getMax(node);
		} else if (node.getRight() != null) {
			return node.getRight();
		} else {
			return null;
		}
	}

	// returns max of a [sub]tree
	public BSTNode getMax(BSTNode node) {
		while (node.getRight() != null) {
			node = node.getRight();
		}
		return node;
	}

	public int getHeight(BST tree) {
		return getHeight(tree.getRoot())-1;
	}

	private int getHeight(BSTNode node) {
		int height;
		if (node == null) {
			height = 0;
		} else {
			int left = getHeight(node.getLeft()) + 1;
			int right = getHeight(node.getRight()) + 1;
			if (left > right) {
				height = left;
			} else {
				height = right;
			}
		}
		return height;
	}
	
	public void clearTree() {
		this.setRoot(null);
	}
}
