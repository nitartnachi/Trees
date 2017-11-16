
/*
 * Create Binary tree
 * 			5
 * 		   / \
 * 		 3/   \7
 *      2/\4 6/\8
 *     1/       \9
 *       
 */
package com.nitin.algo;

public class BinaryTree
{
	private static Node root;

	private BinaryTree(int data)
	{
		root = new Node(data);
	}

	private void add(Node parent, Node child, String orientation)
	{
		if (orientation.equals("left"))
		{
			parent.setLeft(child);
		}
		else
		{
			parent.setRight(child);
		}
	}

	public static Node getBinaryTree()
	{
		Node n1 = new Node(3);
		Node n2 = new Node(2);
		Node n3 = new Node(1);
		Node n4 = new Node(4);
		Node n5 = new Node(7);
		Node n6 = new Node(6);
		Node n7 = new Node(8);
		Node n8 = new Node(9);

		BinaryTree tree = new BinaryTree(5); 
		tree.add(root, n1, "left"); 
		tree.add(n1, n2, "left"); 
		tree.add(n2, n3, "left"); 
		tree.add(n1, n4, "right");
		tree.add(root, n5, "right");
		tree.add(n5, n6, "left");
		tree.add(n5, n7, "right");
		tree.add(n7, n8, "right");
		
		return root;
	}
}

class Node {
	private int key;
	private Node left;
	private Node right;

	Node (int key) {
		this.key = key;
		right = null;
		left = null;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public int getKey() {
		return key;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getLeft() {
		return left;
	}

	public void setRight(Node right ) {
		this.right = right;
	}

	public Node getRight() {
		return right;
	}

}
