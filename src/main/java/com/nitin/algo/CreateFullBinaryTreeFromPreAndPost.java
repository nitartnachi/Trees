/*
 * Construct Full Binary Tree from given preorder and postorder traversals
4.2
Given two arrays that represent preorder and postorder traversals of a full binary tree, construct the binary tree.

A Full Binary Tree is a binary tree where every node has either 0 or 2 children

Following are examples of Full Trees.

        1
      /   \
    2       3
  /  \     /  \
 4    5   6    7


       1
     /   \
   2      3
        /   \  
       4     5
           /   \  
          6    7


          1
        /   \
      2       3
    /  \     /  \
   4    5   6    7
 /  \  
8    9 

It is not possible to construct a general Binary Tree from preorder and postorder traversals (See this). 
But if know that the Binary Tree is Full, we can construct the tree without ambiguity. Let us understand this with the help of following example.

Let us consider the two given arrays as pre[] = {1, 2, 4, 8, 9, 5, 3, 6, 7} and post[] = {8, 9, 4, 5, 2, 6, 7, 3, 1};
In pre[], the leftmost element is root of tree. Since the tree is full and array size is more than 1. 
The value next to 1 in pre[], must be left child of root. So we know 1 is root and 2 is left child. How to find the all nodes in left subtree? 
We know 2 is root of all nodes in left subtree. All nodes before 2 in post[] must be in left subtree. 
Now we know 1 is root, elements {8, 9, 4, 5, 2} are in left subtree, and the elements {6, 7, 3} are in right subtree.


                  1
                /   \
               /      \
     {8, 9, 4, 5, 2}     {6, 7, 3}
We recursively follow the above approach and get the following tree.

          1
        /   \
      2       3
    /  \     /  \
   4    5   6    7
  / \  
 8   9 
 */
package com.nitin.algo;

import com.nitin.algo.TreeUtils.Node;

public class CreateFullBinaryTreeFromPreAndPost {
	
	private static int preindex;

	private static Node constructTreeUtil(int pre[], int post[], int l, 
			int h, int size) {

		// Base case
		if (preindex >= size || l > h)
			return null;

		// The first node in preorder traversal is 
		// root. So take the node at preIndex from 
		// preorder and make it root, and increment 
		// preIndex
		Node root = new Node(pre[preindex]);
		preindex++;

		// If the current subarry has only one 
		// element, no need to recur or 
		// preIndex > size after incrementing
		if (l == h || preindex >= size)
			return root;
		int i;

		// Search the next element of pre[] in post[]
		for (i = l; i <= h; i++) 
		{
			if (post[i] == pre[preindex])
				break;
		}
		// Use the index of element found in 
		// postorder to divide postorder array 
		// in two parts. Left subtree and right subtree
		if (i <= h) 
		{
			root.left = constructTreeUtil(pre, post, l, i, size);
			root.right = constructTreeUtil(pre, post, i + 1, h, size);
		}
		return root;
	}

	private static Node constructTree(int pre[], int post[], int size) {
		preindex = 0;
		return constructTreeUtil(pre, post, 0, size - 1, size);
	}

	public static void main(String[] args) {

		int pre[] = { 1, 2, 4, 8, 9, 5, 3, 6, 7 };
		int post[] = { 8, 9, 4, 5, 2, 6, 7, 3, 1 };

		int size = pre.length;
		Node root = constructTree(pre, post, size);

		System.out.println("Inorder traversal of the constructed tree:");
		PreOrderInOrderPostOrderTraversal.inOrderTraversal(root);
	}

}
