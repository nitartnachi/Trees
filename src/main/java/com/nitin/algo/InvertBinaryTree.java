/*
 *   4
   /   \
  2     7
 / \   / \
1   3 6   9

     4
   /   \
  7     2
 / \   / \
9   6 3   1

 */
package com.nitin.algo;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.nitin.algo.Utils.Node;

public class InvertBinaryTree {
	
	private static void invert(Node node) {
		Node temp = node.left;
		node.left = node.right;
		node.right = temp;
		
		if(node.left != null)
			invert(node.left);
		if(node.right != null)
			invert(node.right);
		
	}

	private static Node invertBinaryTreeRecursive(Node root) {
		if(root != null)
			invert(root);
		return root;
		
	}
	
	private static Node invertBinaryTreeIterative(Node root) {
		Queue<Node> queue = new LinkedList<>();
		if(root != null)
			queue.add(root);
		
		while(!queue.isEmpty()) {
			Node node = queue.remove();
			if(node.left != null)
				queue.add(node.left);
			if(node.right != null)
				queue.add(node.right);
			
			Node temp = node.left;
			node.left = node.right;
			node.right = temp;
		}
		
		return root;
		
	}
	
	// test harness
	public static void main(String[] args) {
		int arr[] = {4,2,7,1,3,6,9};
		Node root = Utils.insertLevelOrder(arr, null, 0);
		System.out.println("================LevelOrderTraversal=================");
		List<List<Integer>> list = LevelOrderTraversalV1.levelOrderTraversal(root);
		System.out.println(list.toString());
		
		System.out.println("================LevelOrderTraversalAfterInvertingRecursively=================");
		root = invertBinaryTreeRecursive(root);
		list = LevelOrderTraversalV1.levelOrderTraversal(root);
		System.out.println(list.toString());
		
		System.out.println("================LevelOrderTraversal=================");
		root = invertBinaryTreeRecursive(root);
		list = LevelOrderTraversalV1.levelOrderTraversal(root);
		System.out.println(list.toString());
		
		System.out.println("================LevelOrderTraversalAfterInvertingIteratively=================");
		root = invertBinaryTreeIterative(root);
		list = LevelOrderTraversalV1.levelOrderTraversal(root);
		System.out.println(list.toString());
	}
}
