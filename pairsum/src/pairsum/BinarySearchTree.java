package pairsum;

public class BinarySearchTree {
	Node root;

	BinarySearchTree() {
		root = null;
	}

	void insert(int key) {
		root = insertRec(root, key);
	}

	Node insertRec(Node root, int data) {

		if (root == null) {
			root = new Node(data);
			return root;
		}

		if (data < root.getData())
			root.setLeft(insertRec(root.getLeft(), data));
		else if (data > root.getData())
			root.setRight(insertRec(root.getRight(), data));

		return root;
	}

	boolean isPairPresent(Node root, Node temp, int target) {
		if (temp == null)
			return false;

		return search(root, temp, target - temp.getData()) || isPairPresent(root, temp.getLeft(), target)
				|| isPairPresent(root, temp.getRight(), target);
	}

	boolean search(Node root, Node temp, int k) {

		if (root == null)
			return false;

		Node c = root;
		boolean flag = false;
		while (c != null && flag != true) {
			if (c.getData() == k && temp != c) {
				flag = true;
				System.out.println("Pair Found: " + c.getData() + " and  " + temp.getData());
				System.out.println("With Sum: " + (c.getData() + temp.getData()));

				return true;
			} else if (k < c.getData())
				c = c.getLeft();
			else
				c = c.getRight();
		}

		return false;
	}
}
