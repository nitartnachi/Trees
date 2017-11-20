/*
 * Create tree
 * Preorder traversal
 * Postorder traversal
 * Inorder traversal
 * ----------------------------------------------------------------------------------------------------------------------------------------------
 * BIG O Details: time O(n) -- space O(1)
 * 	In-order, Pre-order, and Post-order traversals are Depth-First traversals.

	For a Graph, the complexity of a Depth First Traversal is O(n + m), where n is the number of nodes, and m is the number of edges.

	Since a Binary Tree is also a Graph, the same applies here. The complexity of each of these Depth-first traversals is O(n+m).

	Since the number of edges that can originate from a node is limited to 2 in the case of a Binary Tree, the maximum number of total edges in a Binary Tree is n-1, where n is the total number of nodes.

	The complexity then becomes O(n + n-1), which is O(n).
 */

package com.nitin.algo;

import com.nitin.algo.Utils.Node;

public class BinaryTreeTraversal {
	
	private static void preOrderTraversal(Node node) {
		if(node == null)
			return;
		System.out.print(node.data + " ");
		preOrderTraversal(node.left);
		preOrderTraversal(node.right);
		
	}
	
	private static void inOrderTraversal(Node node) {
		if(node == null)
			return;
		inOrderTraversal(node.left);
		System.out.print(node.data + " ");
		inOrderTraversal(node.right);
		
	}
	
	private static void postOrderTraversal(Node node) {
		if(node == null)
			return;
		postOrderTraversal(node.left);
		postOrderTraversal(node.right);
		System.out.print(node.data + " ");
		
	}
	
	// test harness
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9};
		Node root = Utils.sortedArrayToBST(arr, 0, arr.length - 1);
		System.out.println("=====PreOrder=====");
		preOrderTraversal(root);
		
		System.out.println("\n=====InOrder=====");
		inOrderTraversal(root);
		
		System.out.println("\n=====PostOrder=====");
		postOrderTraversal(root);
	}

}
