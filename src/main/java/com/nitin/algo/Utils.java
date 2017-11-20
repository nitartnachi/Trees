
/*
 * Create Binary tree
 * 			5
 * 		   / \
 * 		 2/   \7
 *      1/\3 6/\8
 *         \4   \9
 *       
 */
package com.nitin.algo;

public class Utils {
 
    // Tree Node
    static class Node {
        int data;
        Node left, right;
        Node(int elem) {
            data = elem;
            left = right = null;
        }
    }
    
    // Function to create BST from sorted array
    public static Node sortedArrayToBST(int arr[], int start, int end) {
    	 
        /* Base Case */
        if (start > end) {
            return null;
        }
 
        // Get the middle element and make it root
        int mid = (start + end) / 2;
        Node node = new Node(arr[mid]);
 
        //Recursively construct the left subtree and make it left child of root
        node.left = sortedArrayToBST(arr, start, mid - 1);
 
        // Recursively construct the right subtree and make it right child of root
        node.right = sortedArrayToBST(arr, mid + 1, end);
         
        return node;
    }
 
    // Function to insert nodes in level order
    public static Node insertLevelOrder(int[] arr, Node root, int i) {
        // Base case for recursion
        if (i < arr.length) {
            Node temp = new Node(arr[i]);
            root = temp;
 
            // insert left child
            root.left = insertLevelOrder(arr, root.left, 2 * i + 1);
 
            // insert right child
            root.right = insertLevelOrder(arr, root.right, 2 * i + 2);
        }
        return root;
    }
}
