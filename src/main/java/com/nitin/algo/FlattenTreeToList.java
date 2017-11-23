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
import java.util.Stack;

import com.nitin.algo.TreeUtils.Node;

public class FlattenTreeToList {
	
	public static void main(String[] args) {
		int[] arr = {1,2,5,3,4,6,7};
		Node root = TreeUtils.insertLevelOrder(arr, null, 0);
		System.out.println("========LevelOrderTraversalForTree=========");
		List<List<Integer>> list = LevelOrderTraversal.levelOrderTraversal(root);
		System.out.println(list.toString());
		
		flattenTreeToList(root);
		System.out.println("========LevelOrderTraversalForTreeAfterFlattening=========");
		list = LevelOrderTraversal.levelOrderTraversal(root);
		System.out.println(list.toString());
	}

	private static void flattenTreeToList(Node root) {
		if(root == null)
			return;
		Node node = root;
		Stack<Node> stk = new Stack<>();
		
		while(!stk.isEmpty() || node != null) {
			
			if(node.right != null){
                stk.push(node.right);
            }
			if(node.left != null) {
				node.right = node.left;
				node.left = null;
			}
			else if(!stk.empty()){
                Node temp = stk.pop();
                node.right=temp;
            }
 
            node = node.right;
		}
		
		
	}

}
