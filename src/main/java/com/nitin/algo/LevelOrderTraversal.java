/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
For example:
Given binary tree {1,2,3,4,5,6,7,8,9},
           1
       2       3
    4    5   6    7
  8   9
return its reverse level order traversal as [[1], [2,3], [4,5,6,7], [8,9]]
 * ----------------------------------------------------------------------------------------------------------------------------------------------
 * BIG O Details: time O(n) -- space O(n)
 */

package com.nitin.algo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.nitin.algo.TreeUtils.Node;

public class LevelOrderTraversal {
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9};
		Node root = TreeUtils.sortedArrayToBST(arr, 0, arr.length - 1);
		System.out.println("========LevelOrderTraversalForBST=========");
		List<List<Integer>> list = levelOrderTraversal(root);
		System.out.println(list.toString());
		
		System.out.println("========LevelOrderTraversalForInsertLevelOrder=========");
		root = TreeUtils.insertLevelOrder(arr, null, 0);
		list = levelOrderTraversal(root);
		System.out.println(list.toString());
	}

	static List<List<Integer>> levelOrderTraversal(Node root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		Queue<Node> queue = new LinkedList<>();
		Node temp = null;
		int size = 0;
		if(root != null)
			queue.add(root);
		
		while(!queue.isEmpty()) {
			List<Integer> list = new ArrayList<>();
			size = queue.size();
			while (size-- > 0) {
				temp = queue.remove();
				list.add(temp.data);
				if(temp.left != null)
					queue.add(temp.left);
				if(temp.right != null)
					queue.add(temp.right);
			}
			result.add(list);
			
		}
			
		return result;
	}

}
