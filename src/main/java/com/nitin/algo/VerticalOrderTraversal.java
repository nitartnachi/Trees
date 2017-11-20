/*
Given a binary tree, return the vertical order traversal of its nodes values.

       
           1
         /   \
       2       3
     /  \     /  \
   4     5   6    7
  / \
 8   9        
              
The output of print this tree vertically will be:

8
4
2 9
1 5 6
3
7
 * ----------------------------------------------------------------------------------------------------------------------------------------------
 * BIG O Details: time O(n) -- space O(1)
 */

package com.nitin.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.nitin.algo.Utils.Node;

public class VerticalOrderTraversal {

	private static List<List<Integer>> verticalOrderTraversal(Node root){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
	    if(root==null)
	        return result;
	 
	    // level and list    
	    HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
	 
	    Queue<Node> queue = new LinkedList<>();
	    Queue<Integer> level = new LinkedList<>();
	 
	    queue.add(root);
	    level.add(0);
	 
	    int minLevel=0;
	    int maxLevel=0;
	 
	    while(!queue.isEmpty()){
	        Node p = queue.remove();
	        int l = level.remove();
	 
	        //track min and max levels
	        minLevel=Math.min(minLevel, l);
	        maxLevel=Math.max(maxLevel, l);
	 
	        if(map.containsKey(l)) {
	            map.get(l).add(p.data);
	        }else {
	            List<Integer> list = new ArrayList<>();
	            list.add(p.data);
	            map.put(l, list);
	        }
	 
	        if(p.left!=null) {
	            queue.add(p.left);
	            level.add(l-1);
	        }
	 
	        if(p.right!=null) {
	            queue.add(p.right);
	            level.add(l+1);
	        }
	    }
	 
	    for(int i=minLevel; i<=maxLevel; i++) {
	        if(map.containsKey(i)) {
	            result.add(map.get(i));
	        }
	    }
	 
	    return result;
	}

	// test harness
	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5,6,7,8,9};
		Node root = Utils.insertLevelOrder(arr, null, 0);
		
		System.out.println("================VerticalOrder=================");
		List<List<Integer>> list = verticalOrderTraversal(root);
		System.out.println(list.toString());
	}

}
