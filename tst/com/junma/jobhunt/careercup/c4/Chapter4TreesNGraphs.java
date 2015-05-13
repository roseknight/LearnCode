package com.junma.jobhunt.careercup.c4;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class Chapter4TreesNGraphs {
	
	static int iCurrentDepth = 0, iMaxDepth = 0, iMinDepth = 0;
	
	public static void preorderT(TreeNode node) {
		if (node==null) {
			return ;
		}
		
		// Leaf Node. Mark the Depth
		if ((node.left==null)&&(node.right==null)) {
			if (iCurrentDepth>iMaxDepth) {
				iMaxDepth = iCurrentDepth;
			}
			if (iCurrentDepth<iMinDepth) {
				iMinDepth = iCurrentDepth;
			}
		}
		
		if (node.left!=null) {
			iCurrentDepth++;
			preorderT(node.left);
			iCurrentDepth--;
		}
		
		if (node.right!=null) {
			iCurrentDepth++;
			preorderT(node.right);
			iCurrentDepth--;
		}		
	}
	
	public static int checkTreeBalanced(BinarySearchTree t) {
		TreeNode index = t.root;
		iCurrentDepth = 0;
		iMaxDepth = 0;
		iMinDepth = 100;		
		preorderT(index);
		return iMaxDepth-iMinDepth;
	}
	
	public static int getMaxDepth(TreeNode root){
		if (root==null) {
			return 0;
		} 
		return Math.max(getMaxDepth(root.left), getMaxDepth(root.right)) + 1;
	}
	
	public static int getMinDepth(TreeNode root){
		if (root==null) {
			return 0;
		} 
		return Math.min(getMinDepth(root.left), getMinDepth(root.right)) + 1;		
	}
	
	public static int checkTreeBalanced2(BinarySearchTree t){
		return getMaxDepth(t.root)-getMinDepth(t.root);
	}
	
	// insert an array into a binary tree. always insert from the middle point and then recurisve
	// insert the left side and the right side
	public static void insertArrayToBST(BinarySearchTree t, int[] a, int iStart, int iEnd) {
		if (iEnd-iStart<=1) {
			t.insert(a[iStart]);
			if (iEnd>iStart) {
				t.insert(a[iEnd]);
			}
			return ;
		}
		
		int iMid = (int)((iStart+iEnd)/2);
		t.insert(a[iMid]);
		insertArrayToBST(t, a, iStart, iMid-1);
		insertArrayToBST(t, a, iMid+1, iEnd);		
	}
	
	// Binary Search variation. Omma's question
	// Always maintain the known left side and the right side
	public static int findClosetValue(BinarySearchTree t, int input) {
		TreeNode index = t.root;
		//Do not need to set these two values actually
		int iRight=1000, iLeft=-1 ;
		
		while(index!=null) {
			if (index.val==input) {
				return input;
			} 
			if (index.val<input) {
				iLeft = index.val ;
				index = index.right;		
			} else {
				iRight = index.val;
				index = index.left;
			}
		}
		if ((input-iLeft)>(iRight-input)) {
			return iRight;
		} else {
			return iLeft;
		}
	}
	
	public static TreeNode getEdgeNode(TreeNode node, boolean bLeft) {
		if (bLeft) {
			if (node.left==null) {
				return node;
			} else {
				return getEdgeNode(node.left, bLeft);
			}
		} else {
			if (node.right==null) {
				return node;
			} else {
				return getEdgeNode(node.right, bLeft);
			}			
		}
	}
	
	//check whether a binary tree is a binary search tree
	// Facebook phone interview
	// Use inorder transversal. Good enough
	public static boolean isBST(TreeNode root) {
		if (root==null) {
			return true;
		}
		if ((root.left==null)&&(root.right==null)) {
			return true;
		}
		TreeNode tmp;
		if (root.left!=null) {
			tmp = getEdgeNode(root.left, false);
			if (tmp.val>=root.val) {
				return false;
			}
		}
		if (root.right!=null) {
			tmp = getEdgeNode(root.right, true);
			if (tmp.val<=root.val) {
				return false;
			}
		}	
		return isBST(root.left) && isBST(root.right);
	}
	
	public static int iPre = -1;
	public static boolean inOrderCheck(TreeNode node){
		if (node==null) {
			return true;
		}
		if (!inOrderCheck(node.left)) {
			return false ;
		}
		if (iPre>=node.val) {
			return false ;
		}
		iPre = node.val;
		if (!inOrderCheck(node.right)) {
			return false ;
		}
		return true ;
	}
	public static boolean isBST2(TreeNode node) {
		iPre = -1;
		return inOrderCheck(node);
	}

	public static boolean inOrderCheck2(TreeNode node, int[] iPre2){
		if (node==null) {
			return true;
		}
		if (!inOrderCheck2(node.left, iPre2)) {
			return false ;
		}
		if (iPre2[0]>=node.val) {
			return false ;
		}
		iPre2[0] = node.val;
		if (!inOrderCheck2(node.right, iPre2)) {
			return false ;
		}
		return true ;
	}	
	public static boolean isBST3(TreeNode node) {
		int[] iPre2 = new int[1];
		return inOrderCheck2(node, iPre2);
	}
	
	// Quesiton 4.6, Find the lowest common ancester
	// There are quite a few branches. Pay attention to the case where a->c->b. 
	// In this case, the ancester is a. 
	public static boolean findValue(TreeNode root, int a) {
		if(root==null) {
			return false;
		} else if(root.val==a) {
			return true;
		} else {
			return findValue(root.left, a)||findValue(root.right, a);
		}
	}
	
	// Solution for Binary Search Tree. O(LogN)
	public static int findLowestCommonAncester(TreeNode root, int a, int b) {
		if (root==null) {
			return -1;
		} else {
			if ((a<root.val)&&(b<root.val)) {
				return findLowestCommonAncester(root.left, a, b);
			} else if ((a>root.val)&&(b>root.val)) {
				return findLowestCommonAncester(root.right, a, b);
			} else {
				if (root.val==a){
					if (root.val==b) {
						return root.val;
					} else {
						if (findValue(root.left, b)||findValue(root.right,b)){
							return a;
						} else {
							return -1;
						}
					}
				}
				
				if (root.val==b) {
					if (findValue(root.left, a)||findValue(root.right,a)){
						return b;
					} else {
						return -1;
					}				
				}				
				if (findValue(root.left, a)&&findValue(root.right,b)) {
					return root.val;
				} else {
					return -1;
				}
			}
		}
	}
	
	// Solution for Bineary Tree. O(N*N)
	public static int findLowestCommonAncester2(TreeNode root, int a, int b) {
		if (root==null) {
			return -1;
		} else {
			if (root.val==a){
				if (root.val==b) {
					return root.val;
				} else {
					if (findValue(root.left, b)||findValue(root.right,b)){
						return a;
					} else {
						return -1;
					}
				}
			}
			
			if (root.val==b) {
				if (findValue(root.left, a)||findValue(root.right,a)){
					return b;
				} else {
					return -1;
				}				
			}
			
			if (findValue(root.left, a)&&findValue(root.right,b)) {
				return root.val;
			} else {
				return Math.max(findLowestCommonAncester2(root.left, a, b)
						, findLowestCommonAncester2(root.right, a, b));
			}
		}	
	}	
	
	// Question 4.8
	public static void preOrderNode(TreeNode node, List<Integer> lValues, int m) {
		if (node==null) {
			return ;
		}
		lValues.add(node.val);
		int intIndex = lValues.size()-1;
		int iResult = m;
		while ((iResult>0)&&(intIndex>=0)) {
			iResult = iResult - lValues.get(intIndex) ;
			intIndex--;
		}
		if(iResult==0) {
			intIndex++;
			while(intIndex<lValues.size()){
				System.out.print(lValues.get(intIndex));
				intIndex++;
			}
			System.out.println();
		}
		preOrderNode(node.left, lValues, m);
		preOrderNode(node.right, lValues, m);	
		lValues.remove(lValues.size()-1);
	}
	
	public static void printPathes4M(TreeNode root, int m) {
		List<Integer> lValues = new ArrayList<Integer>();
		System.out.println("-------------");
		preOrderNode(root, lValues, m);
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(int value) {
		val = value;
		left = null;
		right = null;
	}
}

class BinarySearchTree {
	TreeNode root=null;
	
	public BinarySearchTree(int[] values) {
		for(int i:values) {
			insert(i);
		}
	}
	
	public void insert(int i) {
		TreeNode node = new TreeNode(i) ;
		if (root==null) {
			root = node;
		} else {
			TreeNode index = root;
			boolean bContinue = true;
			while (bContinue) {		
				if (i<=index.val) {
					if (index.left==null) {
						index.left = node;
						bContinue = false;
					} else {
						index = index.left;
					}
				} else {
					if (index.right==null) {
						index.right = node;						
						bContinue = false;
					} else {
						index = index.right;
					}
				}
			}			
		}		
	}
	
	public TreeNode search(int i) {
		if(root==null) {
			return null;
		}
		TreeNode index = root;
		while ((index!=null)&&(index.val!=i)) {
			if (i<index.val) {
				index = index.left;
			} else {
				index = index.right;
			}
		}
		return index;
 	}
	
	public String printTree() {
		StringBuffer strB = new StringBuffer();
		TreeNode delimiter = new TreeNode(-1);
		TreeNode index = null;
		Queue<TreeNode> q = new ArrayBlockingQueue<TreeNode>(100);
		q.offer(root);
		q.offer(delimiter);
		while(!q.isEmpty()) {
			index = q.poll();
			if (index==delimiter) {
				strB.append("\n") ;
				if (!q.isEmpty()) {
					q.offer(delimiter) ;
				}
 			} else {
 				strB.append(index.val) ;
 				strB.append(",");
 				if (index.left!=null) {
 					q.offer(index.left);
 				}
 				if (index.right!=null) {
 					q.offer(index.right);
 				}
 			}
		}
		return strB.toString();
	}
}

class BinaryTree{
	public TreeNode root;
	
	private TreeNode buildTree(int[] input, int current) {
		if (current>=input.length) {
			return null;
		}
		TreeNode node = new TreeNode(input[current]);
		node.left = buildTree(input, current*2 + 1);
		node.right = buildTree(input, current*2 + 2);
		return node;
	}
	
	
	public BinaryTree(int[] input) {
		root = buildTree(input, 0);
	}
	
	public String printTree() {
		StringBuffer strB = new StringBuffer();
		TreeNode delimiter = new TreeNode(-1);
		TreeNode index = null;
		Queue<TreeNode> q = new ArrayBlockingQueue<TreeNode>(100);
		q.offer(root);
		q.offer(delimiter);
		while(!q.isEmpty()) {
			index = q.poll();
			if (index==delimiter) {
				strB.append("\n") ;
				if (!q.isEmpty()) {
					q.offer(delimiter) ;
				}
 			} else {
 				strB.append(index.val) ;
 				strB.append(",");
 				if (index.left!=null) {
 					q.offer(index.left);
 				}
 				if (index.right!=null) {
 					q.offer(index.right);
 				}
 			}
		}
		return strB.toString();
	}
}