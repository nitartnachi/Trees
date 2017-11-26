/*
 * Implement an iterator over a binary search tree (BST). 
 * Your iterator will be initialized with the root node of a BST. 
 * Calling next() will return the next smallest number in the BST. Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, 
 * where h is the height of the tree.
 */

package com.nitin.algo;

import java.util.Stack;

import com.nitin.algo.TreeUtils.Node;

public class BSTIterator {
	private Stack<Node> stk;
	
	public BSTIterator(Node root) {
		stk = new Stack<>();
		while(root != null) {
			stk.push(root);
			root = root.left;
		}
	}
	
	public Node next() {
		Node result = stk.pop();
		Node node = result;
		if(node.right != null) {
			node = node.right;
			while(node != null) {
				stk.push(node);
				node = node.left;
			}
		}
		return result;
	}
	
	public boolean hasNext() {
		return (stk.isEmpty()) ? false : true;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,3,4,6,7,8,10,13,14};
		Node root = TreeUtils.sortedArrayToBST(arr, 0, arr.length - 1);
		
		BSTIterator itr = new BSTIterator(root);
		while(itr.hasNext())
			System.out.println(itr.next().data);
	}

}
