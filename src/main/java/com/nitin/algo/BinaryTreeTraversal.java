/*
 * Create tree
 * Preorder traversal
 * Postorder traversal
 * Inorder traversal
 */

package com.nitin.algo;

public class BinaryTreeTraversal {
	
	private static void preOrderTraversal(Node node) {
		if(node == null)
			return;
		System.out.println(node.getKey());
		preOrderTraversal(node.getLeft());
		preOrderTraversal(node.getRight());
		
	}
	
	private static void inOrderTraversal(Node node) {
		if(node == null)
			return;
		inOrderTraversal(node.getLeft());
		System.out.println(node.getKey());
		inOrderTraversal(node.getRight());
		
	}
	
	private static void postOrderTraversal(Node node) {
		if(node == null)
			return;
		postOrderTraversal(node.getLeft());
		postOrderTraversal(node.getRight());
		System.out.println(node.getKey());
		
	}
	
	public static void main(String[] args) {
		Node root = BinaryTree.getBinaryTree();
		System.out.println("=====PreOrder=====");
		preOrderTraversal(root);
		
		System.out.println("=====InOrder=====");
		inOrderTraversal(root);
		
		System.out.println("=====PostOrder=====");
		postOrderTraversal(root);
	}

}
