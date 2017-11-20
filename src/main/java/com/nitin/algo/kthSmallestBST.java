/*
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it. (1 ≤ k ≤ BST's total elements)
 */
package com.nitin.algo;

import java.util.List;
import java.util.Stack;

import com.nitin.algo.Utils.Node;

public class kthSmallestBST {
	
	private static int kthSmallestInBST(Node node, int k) {
		Stack<Node> stack = new Stack<Node>();
		 
	    Node p = node;
	    int result = 0;
	 
	    while(!stack.isEmpty() || p!=null){
	        if(p!=null){
	            stack.push(p);
	            p = p.left;
	        }else{
	            Node t = stack.pop();
	            k--;
	            if(k==0)
	                result = t.data;
	            p = t.right;
	        }
	    }
	 
	    return result;
	}

	// test harness
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9};
		Node root = Utils.sortedArrayToBST(arr, 0, arr.length - 1);
		
		System.out.println("=====LevelOrder=====");
		List<List<Integer>> list = LevelOrderTraversalV1.levelOrderTraversal(root);
		System.out.println(list.toString());
		
		int k = 1;
		System.out.println("The kth largest element in BST is: " + kthSmallestInBST(root, k));
	}

}
