/*
 * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
Example 1:
Input:
    3
   / \
  9  20
    /  \
   15   7
Output: [3, 14.5, 11]
 */

package com.nitin.algo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.nitin.algo.TreeUtils.Node;

public class LevelOrderAverages {
	
	public static void main(String[] args) {
		int[] arr = {3,9,20,15,7};
		
		System.out.println("========LevelOrderTraversalForInsertLevelOrder=========");
		Node root = TreeUtils.insertLevelOrder(arr, null, 0);
		List<Double> list = levelOrderAverages(root);
		System.out.println(list.toString());
	}

	public static List<Double> levelOrderAverages(Node root) {
		List<Double> result = new ArrayList<Double>();
		
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
			double sum = 0;
			for(int i = 0; i < list.size(); i++) {
				sum = sum + list.get(i);
			}
			result.add(sum/(list.size()));
			
		}
			
		return result;
	}

}