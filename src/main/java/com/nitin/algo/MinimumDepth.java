/*
 * Given a binary tree, find its minimum depth.

 *  The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *  For this example, the minimum depth will be 3:
              1
             / \
            2   3
           /\  / \
          4  5 7  8
         /
        6 
 */

package com.nitin.algo;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.nitin.algo.TreeUtils.Node;

public class MinimumDepth {

	public static void main(String[] args) {

		int[] arr = {1,2,3,4,5,7,8,6};
		Node root = TreeUtils.insertLevelOrder(arr, null, 0);
		System.out.println("========LevelOrderTraversal=========");
		List<List<Integer>> list = LevelOrderTraversal.levelOrderTraversal(root);
		System.out.println(list.toString());
		
		System.out.println("The minimum depth for the given tree is: " + minDepth(root));
	}

	private static int minDepth(Node root) {
		if(root == null)
			return 0;
		
		Queue<Node> nodeQ = new LinkedList<>();
		Queue<Integer> countQ = new LinkedList<>();
		int count = 0;
		Node curr = null;
		
		nodeQ.add(root);
		countQ.add(1);
		
		while(!nodeQ.isEmpty()) {
			curr = nodeQ.remove();
			count = countQ.remove();
			
			if(curr.left == null && curr.right == null)
				return count;
			if(curr.left != null) {
				nodeQ.add(curr.left);
				countQ.add(count + 1);
			}
			
			if(curr.right != null) {
				nodeQ.add(curr.right);
				countQ.add(count + 1);
			}
				
		}
		return 0;
	}

}
