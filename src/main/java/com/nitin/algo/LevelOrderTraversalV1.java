/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,23,14,15,7},

 * 			3
 * 		   / \
 * 		9/     \20
 *    23/\14 15/ \7
return its level order traversal as [[3], [9,20], [23,14,15,7]]

 * ----------------------------------------------------------------------------------------------------------------------------------------------
 * BIG O Details: time O(n) -- space O(1)
 */

package com.nitin.algo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.nitin.algo.Utils.Node;

public class LevelOrderTraversalV1 {

	public static List<List<Integer>> levelOrderTraversal(Node root){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		if(root == null)
			return result;
		Queue<Node> que = new LinkedList<>();
		que.add(root);

		Node node = null;

		while(!que.isEmpty()) {
			//create a list to add nodes at the same level
			List<Integer> list  = new ArrayList<>();
			int size = que.size();
			//loop number of times equal to entries in queue for that level
			for (int i = 0; i < size; ++i) {
				node = que.remove();
				list.add(node.data);
				
				//add children to queue
				if(node.left != null)
					que.add(node.left);
				if(node.right != null)
					que.add(node.right);
			}
			result.add(list);
		}
		return result;
	}

	// test harness
	public static void main(String[] args) {
		int arr[] = {3,9,20,23,14,15,7};
		Node root = Utils.insertLevelOrder(arr, null, 0);
		System.out.println("================LevelOrder=================");
		List<List<Integer>> list = levelOrderTraversal(root);
		System.out.println(list.toString());
	}

}
