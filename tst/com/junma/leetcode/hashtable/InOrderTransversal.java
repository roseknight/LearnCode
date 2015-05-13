package com.junma.leetcode.hashtable;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.Test;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

public class InOrderTransversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root==null) {
            return null;
        }
        
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
        
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if ((cur.left!=null)&&(!map.containsKey(cur.left))) {
                stack.push(cur);
                stack.push(cur.left);
            } else {
                result.add(cur.val);
                map.put(cur, 1);
                if (cur.right!=null) {
                    stack.push(cur.right);
                }
            }
        }
        
        return result;
    }
    
	@Test
	public void test() {
		fail("Not yet implemented");
	}

    public int singleNumber(int[] A) {
        if ((A==null)||(A.length==0)) {
            return -1;
        }
        
        int cur = A[0];
        for(int i=1; i<A.length; i++) {
            cur = cur ^ A[i];
        }
        
        return cur;
    }
    
}
