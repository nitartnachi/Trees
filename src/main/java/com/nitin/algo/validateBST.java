/*
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 * 	The left subtree of a node contains only nodes with keys less than the node's key.
 * 	The right subtree of a node contains only nodes with keys greater than the node's key.
 * 	Both the left and right subtrees must also be binary search trees.
 */

package com.nitin.algo;

import com.nitin.algo.Utils.Node;

public class validateBST {
	
	private static boolean isBST(Node node, int minValue, int maxValue) {
		if(node == null)
			return true;
		if(node.data <= minValue || node.data >=maxValue)
			return false;
		return isBST(node.left, minValue, node.data) && isBST(node.right, node.data, maxValue);
	}
	
	private static String isBST(Node root) {
		boolean result = isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
		return (result) ? "true" : "false";
	}

	// test harness
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9};
		Node root = Utils.sortedArrayToBST(arr, 0, arr.length - 1);

		System.out.println("The given binary is a BST: " + isBST(root));
		
		int[] array = {3,9,20,23,14,15,7};
		root = Utils.insertLevelOrder(array, null, 0);

		System.out.println("The given binary is a BST: " + isBST(root));
	}

}
