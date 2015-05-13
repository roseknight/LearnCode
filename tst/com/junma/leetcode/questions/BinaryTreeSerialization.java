package com.leetcode.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class BinaryTreeSerialization {

	TreeNode head ;
	
	public String serialize(TreeNode h) {
		if (h==null) {
			return "" ;
		}
		
		StringBuffer sb = new StringBuffer() ;
		ArrayList<TreeNode> curLevel = new ArrayList<TreeNode>() ;
		ArrayList<TreeNode> nextLevel = null ;
		curLevel.add(h) ;
		TreeNode nullNode = new TreeNode(-1) ;
		
		while(!curLevel.isEmpty()) {
			nextLevel = new ArrayList<TreeNode>() ;
			for(TreeNode cNode: curLevel) {
				if (cNode!=nullNode) {
					sb.append(',') ;
					sb.append(cNode.val) ;
					
					if (cNode.left!=null) {
						nextLevel.add(cNode.left) ;
					} else {
						nextLevel.add(nullNode) ;
					}
					if (cNode.right!=null) {
						nextLevel.add(cNode.right) ;
					} else {
						nextLevel.add(nullNode) ;
					}
				} else {
					sb.append(",#") ;
				}
			}
			curLevel = nextLevel ;
		}
		String result = sb.substring(1) ;
		while (result.endsWith(",#")) {
			result = result.substring(0, result.length()-2) ;
		} 
		
		return result ;
	}
	
	public TreeNode deserialize(String s) {
		if ((s==null)||(s.length()==0)) {
			return null ;
		}
		
		String[] tokens = s.split(",") ;
		TreeNode head = new TreeNode(Integer.parseInt(tokens[0])) ;
		int index = 1 ;
		
		ArrayList<TreeNode> curLevel = new ArrayList<TreeNode>() ;
		curLevel.add(head) ;
		ArrayList<TreeNode> nextLevel = null ;		
		
		while(!curLevel.isEmpty()) {
			nextLevel = new ArrayList<TreeNode>() ;
			for(TreeNode cNode:curLevel) {
				if (index>=tokens.length) {
					break ;
				}
				
				// Process the left child
				if (tokens[index].equals("#")) {
					cNode.left = null ;
				} else {
					cNode.left = new TreeNode(Integer.parseInt(tokens[index])) ;
					nextLevel.add(cNode.left) ;
				}
				
				index++ ;
				if (index>=tokens.length) {
					break ;
				}				
				// Process the right child
				if (tokens[index].equals("#")) {
					cNode.right = null ;
				} else {
					cNode.right= new TreeNode(Integer.parseInt(tokens[index])) ;
					nextLevel.add(cNode.right) ;
				}
				index++ ;				
			}
			curLevel = nextLevel ;
		}
		return head ;
	}
	
	@Test
	public void test() {
		TreeNode test = this.deserialize("1,#,2,3") ;
		assertEquals("1,#,2,3", this.serialize(test)) ;

		assertEquals("1,2,3,#,#,4,#,#,5", this.serialize(this.deserialize("1,2,3,#,#,4,#,#,5"))) ;
	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}