/*
 * Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \  / \
     3  4  6  7
The flattened tree should look like:

   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
              \
               7
 */
package com.nitin.algo;

import java.util.List;

import com.nitin.algo.Utils.Node;

public class FlattenTreeToList {

	// test harness
	public static void main(String[] args) {
		int[] arr = {1,2,5,3,4,6,7};
		Node root = Utils.insertLevelOrder(arr, null, 0);
		List<List<Integer>> list = LevelOrderTraversalV1.levelOrderTraversal(root);
		System.out.println(list.toString());
		
		root = flattenTreeToList(root);
		list = LevelOrderTraversalV1.levelOrderTraversal(root);
		System.out.println(list.toString());
		
	}

}
