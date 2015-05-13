package com.junma.jobhunt.ms100;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class MSQuestions100_Part1 {

	/* Question 1
	 * Convert a binary tree into a double linked list. 
	 * Use recursive to convert the left side and right side respectively, then join
	 */
	public static TreeNode convertTree2LinkedList(TreeNode node, boolean bHead) {
		if (node==null) {
			return null;
		}
		
		TreeNode temp = convertTree2LinkedList(node.left, false);
		if (temp!=null) {
			temp.right = node ;
		}
		node.left = temp;
		
		temp = convertTree2LinkedList(node.right, true);
		if (temp!=null) {
			temp.left = node;
		}
		node.right = temp;
		
		temp = node ;
		if(bHead) {
			while(temp.left!=null) {
				temp = temp.left;
			}
		} else {
			while(temp.right!=null) {
				temp = temp.right;
			}			
		}
		return temp;
	}
	
	/* Question 3
	 * Find the max sum in a subarray
	 * Programming Pearls. If iCurrentMax < 0, it will not contribute to the value of iMax. So, reset to 0;
	 */
	/*
	 * Question 3
	 * Get the max sum of a subarray
	 * Hint: Use the idea in the Programming Pearls 
	 * Check the current sum. When the current sum is less than 0, reset it to 0
	 */	
	public static int getMaxSuminSubArray(int[] input) {
		int iMax = 0;
		int iCurrentMax = 0;
		for(int i=0; i<input.length; i++) {
			iCurrentMax = iCurrentMax + input[i] ;
			if (iCurrentMax>iMax) {
				iMax = iCurrentMax ;
			}
			if (iCurrentMax<0) {
				iCurrentMax = 0;
			}
		}
		return iMax;
	}
	
	/* KMP Alg
	 * 
	 */
	public static int[] preKMP(String strSub){
		int[] result = new int[strSub.length()] ;
		int iIndex = 0;
		result[0] = 0;
		for(int i=1; i<strSub.length(); i++) {
			while ((iIndex>0)&&(strSub.charAt(i)!=strSub.charAt(iIndex))) {
				iIndex = result[iIndex] ;
			}
			if (strSub.charAt(i)==strSub.charAt(iIndex)) {
				iIndex++;
			}
			result[i] = iIndex ;
		}
		return result;
	}
	
	public static int findSubString(String strInput, String strSub) {
		int[] preSub = preKMP(strSub) ;
		int iSub = 0;
		int iIndex = 0;
		int iSubLen = strSub.length();
		
		while(iIndex<strInput.length()) {
			
			if (strInput.charAt(iIndex)==strSub.charAt(iSub)) {
				iSub++;
				iIndex++;
			} else if (iSub==0) {
				iIndex++;
			} else {
				iSub = preSub[iSub-1];
			}
			
			if (iSub==iSubLen) {
				return iIndex-iSubLen;
			}			
		}
		return -1;
	}
	
	/*
	 * Question 4
	 * Find all paths that can sum up to a value X
	 * Hint: Maintain a path list for each node
	 * This is the solution for all pathes starting from the root node
	 */
	public static void findPathsSumX(TreeNode node, int X, LinkedList<Integer> L) {
		if (node==null) {
			return ;
		}
		if (node.val>X) {
			return ;
		} else if (node.val==X) {
			for(Integer i:L) {
				System.out.print(i + "->");
			}
			System.out.println(node.val);
		} else {
			int diff = X - node.val;
			L.addLast(node.val);
			findPathsSumX(node.left, diff, L);
			findPathsSumX(node.right, diff, L);
			L.removeLast();
		}
	}
	
	
	/* Question 5
	 * Find the k minimal integers in an array with O(N)
	 * Hint: maintain a max heap with K elements. 
	 */
	public static String findKMinInt(int[] input, int k) {
		int[] iHeap = new int[k];
		for(int i=0; i<k; i++) {
			iHeap[i] = input[i];
		}
		MaxHeap heap = new MaxHeap(iHeap);
		for(int i=k; i<input.length; i++) {
			if (input[i]<heap.top()) {
				heap.replacetop(input[i]);
			}
		}
		return heap.printHeap();
	}
	
	/*
	 * Question 6
	 * QQ interview
	 */
	
	/*
	 * Question 7
	 * Given two linked lists, detect whether they are intersected
	 * Hint: If the two lists intersect, the last node is the same one
	 */
	public static LinkNode convertStringToList(String input) {
		LinkNode head = null;
		LinkNode index = head;
		LinkNode next = null;
		for(String str:input.split("->")) {
			next = new LinkNode();
			next.val = Integer.parseInt(str);
			next.next = null;
			if (index==null) {
				index = next ;
				head = index ;
			} else {
				index.next = next ;
				index = next ;
			}
		}
		return head;
	}
	
	public static LinkNode getLastNode(LinkNode head) {
		LinkNode index = head;
		while(index.next!=null) {
			index = index.next ;
		}
		return index;
	}
	
	public static boolean checkJointLinkedList(LinkNode a, LinkNode b) {
		if (getLastNode(a)==getLastNode(b)) {
			return true;
		} else {
			return false;
		}
	}
	
	/*
	 * Question 8
	 * Reverse a linked list
	 * Reverse a string
	 */
	
	public static String printLinkedList(LinkNode a){
		StringBuffer strB = new StringBuffer();
		LinkNode index = a;
		while(index.next!=null) {
			strB.append(index.val);
			strB.append("->");
			index = index.next;
		}
		strB.append(index.val);
		return strB.toString();
	}
	
	// Recursive way
	public static LinkNode reverseLinkedList1(LinkNode a){
		if (a.next==null) {
			return a;
		} else {
			LinkNode b = reverseLinkedList1(a.next);
			a.next.next = a;
			a.next = null ;
			return b;
		}
	}
	// Maintain 3 pointers: prev, index, next; move together
	public static LinkNode reverseLinkedList2(LinkNode a){
		LinkNode index = a ;
		LinkNode temp = null;
		LinkNode next = index.next ;
		LinkNode prev = null;
		while(next!=null) {
			temp = next.next ;
			index.next = prev; 
			next.next = index;
			prev = index ;
			index = next ;
			next = temp ;
		}
		return index;
	}
	
	public static String reverseString(String strInput){
		char[] cInput = strInput.toCharArray() ;
		return new String(reverseCharArray(cInput, 0, cInput.length-1));
	}
	
	public static char[] reverseCharArray(char[] cInput, int iStart, int iEnd){
		int iLeft = iStart;
		int iRight = iEnd;
		char cTemp ;
		while(iLeft<iRight) {
			cTemp = cInput[iLeft];
			cInput[iLeft] = cInput[iRight];
			cInput[iRight] = cTemp;
			iLeft++;
			iRight--;
		}
		return cInput;
	}
	
	
	/* 
	 * Question 9
	 * Find whether an array is the output of a post order transverse of a BST
	 * Hint: the last node is the root. left tree is less than the root node. 
	 * the right subtree is larger than the root node
	 */ 
	public static boolean isBSTPostOrder(int[] input){
		return false;
	}
	
	/* 
	 * Question 10
	 * Reverse a sentence. "I am a student." to "student. a am I"
	 * Hint: Programming Pearls. Reverse the whole string first, then reverse each word
	 */
	public static String reverseSentence(String strInput){
		char[] cInput = strInput.toCharArray() ;
		cInput = reverseCharArray(cInput, 0, cInput.length-1) ;
		int iLeft = 0;
		int iRight = iLeft;
		while(iRight<=cInput.length-1) {
			if (cInput[iRight]!=' ') {
				iRight++;
			} else {
				cInput = reverseCharArray(cInput, iLeft, iRight-1) ;
				iLeft = iRight + 1;
				iRight = iLeft ;
			}
		}
		cInput = reverseCharArray(cInput, iLeft, iRight-1) ;
		return new String(cInput);
	}
	
	/* 
	 * Question 11
	 * Find the max distance between nodes in a Binary Tree
	 * Hint: it depends on the depth of left tree and right tree. 
	 * Meanwhile, do the recursive search.
	 */
	public static int getMaxDistanceInTree(TreeNode node) {
		if (node==null) {
			return 0;
		}

		int iDistance = getTreeDepth(node.left) + getTreeDepth(node.right);	
		int iLeft = getMaxDistanceInTree(node.left);
		int iRight = getMaxDistanceInTree(node.right);		
		return Math.max(iDistance, Math.max(iLeft, iRight));
	}	
	
	/* 
	 * Question 12
	 * find the sum of 1+2+...+N. do not use *,/,for,while,if...
	 * Hint: The sum is (N*(N-1))/2 = (N*N - N)/2  
	 */
	
	/* 
	 * Question 13
	 * Given a linked list, find the kth node to the last node
	 * Hint: Have two pointer a and b. move b to the kth node. then move a and b togther
	 * when b reaches the end, a points to the kth node to the last
	 */
	
	/* 
	 * Question 14
	 * Find the pair of numbers whose sum is M
	 * Hint: sorted the array, then from the head and the tail, try to scan. O(N)
	 */
	public static String findPair4M(int[] input, int m) {
		int iStart = 0;
		int iEnd = input.length-1;
		int iTemp = -1;
		while(iStart<iEnd) {
			if(input[iEnd]>=m) {
				iEnd--;
			} else {
				iTemp = input[iStart] + input[iEnd];
				if(iTemp==m) {
					return input[iStart] + "+" + input[iEnd];
				} else if (iTemp<m) {
					iStart++;
				} else {
					iEnd--;
					iStart = 0;
				}
			}
		}
		return null;
	}
	
	/*
	 * Question 15
	 * Given a binary search tree, convert it to its mirror
	 * Hint: Post-order transverse + recursive 
	 */
	public static TreeNode mirrorBST(TreeNode node) {
		if (node==null) {
			return null;
		}
		TreeNode left = mirrorBST(node.left) ;
		TreeNode right = mirrorBST(node.right) ;
		node.right = left ;
		node.left = right ;
		
		return node;
	}
	
	/* 
	 * Question 16
	 * Print a binary tree by levels
	 * Hint: Use BFS and use a delimiter at the end of each level
	 */
	public static String printBSTByLevel(TreeNode node) {
		StringBuffer sb = new StringBuffer();
		TreeNode delimiter = new TreeNode(-1);
		LinkedList<TreeNode> l = new LinkedList<TreeNode>();
		l.addLast(node);
		l.addLast(delimiter);
		TreeNode temp = null;
		while(l.size()>1) {
			temp = l.removeFirst();
			if (temp==delimiter) {
				sb.append(";") ;
				l.addLast(temp);
			} else {
				sb.append(temp.val);
				sb.append(",");
				if (temp.left!=null) {
					l.addLast(temp.left) ;
				}
				if (temp.right!=null) {
					l.addLast(temp.right) ;
				}				
			}
		}
		return sb.toString();
	}
	
	/*
	 * Question 17
	 * Find the first unique (occur once) char in a string
	 * Hint: use hashmap
	 * Hint: Check lower case/upper case ; Check the case if no unique char; check invalid input
	 */
	public static char getUniqueChar(String strInput){
		char[] cTemp = strInput.toCharArray() ;
		int[] iCount = new int[26] ;
		for(int i=0; i<26; i++) {
			iCount[i] = 0;
		}
		int iTemp = 0;
		for(int i=0; i<cTemp.length; i++) {
			iTemp = cTemp[i] - 'a' ;
			iCount[iTemp]++;
		}
		for(int i=0; i<cTemp.length; i++) {
			iTemp = cTemp[i] - 'a' ;
			if (iCount[iTemp]==1) {
				return (char)('a'+iTemp) ;
			}
		}		
		return '@';
	}
	
	/* 
	 * Question 18
	 * use n numbers (0,1,..n-1) to form a loop. Delete the mth number. 
	 * Then delete the mth number again till the last number. 
	 * What is the last number
	 * 
	 */
	
	/*
	 * Question 19
	 * Calculate the Fibonacci number with best performance
	 * Hint: Calculate from 0 to N, Iteratively
	 * Hint: Or use the gold ratio
	 */	
	public static int getFibonacciNumber(int n) {
		if(n==0) {
			return 0;
		}
		if(n==1) {
			return 1;
		}
		int index = 2;
		int iNM1 = 1;
		int iNM2 = 0;
		int iCurrent = -1;
		while(index<=n){
			iCurrent = iNM1 + iNM2 ;
			iNM2 = iNM1 ;
			iNM1 = iCurrent ;
			index++;
		}
		return iCurrent;
	}
	
	/* Question 20
	 * Input a string representing an integer, convert it to an integer
	 * "345" => 345
	 * Hint: from left to right, convert 1 char, then multiply by 10, convert the next one
	 * Need to consider other cases like "-345, +345, 3,000, 3E10"
	 */
	public static int parseInt(String strInput) {
		char[] cInput = strInput.toCharArray();
		int iResult = 0;
		for(int i=0; i<cInput.length; i++) {
			iResult = iResult*10 + cInput[i] - '0' ;
		}
		return iResult;
	}
	
	/* Question 21
	 * Given n and m, get a combination of numbers from 1 to n, the sum should be m. 
	 * Hint: Dynamic Programming
	 */
	
	/* Question 23
	 * Use a way to detect whether a circle intersects with a square. 
	 * Hint: find the distance between the center point of the circle and the center 
	 * of the square. find the radius of the circle and the radius of the square. 
	 * Compare this two things. 
	 */
	
	/* Question 24 
	 * Reverse a linked list locally. No additional space
	 * Hint: recursive; Done. Check ReverseLinkedList2;
	 */
	
	public static int getTreeDepth(TreeNode node) {
		if (node==null) {
			return 0;
		}
		int iLeft = getTreeDepth(node.left);
		int iRight = getTreeDepth(node.right);
		return Math.max(iLeft, iRight)+1;
	}
	
	// Question 25
	// Find the longest numeric string in a given string
	// Find a numberic string, same the location, find the next one, and identify the longest. 
	public static String getMaxNumString(String strInput) {
		if (strInput==null) {
			return null;
		}
		
		char[] input = strInput.toCharArray();
		int iCurrentMaxNumStart = -1;
		int iCurrentMaxNumLen = 0;
		int iMaxNumStart = -1;
		int iMaxNumLen = 0;
		boolean bFoundNum = false;
		for(int index=0; index<input.length; index++) {
			if (((input[index]-'0')>=0) && ((input[index]-'0')<=9)) {
				iMaxNumLen++;
				if (bFoundNum==false) {
					iMaxNumStart = index;
					bFoundNum = true;
				}
			} else {
				if (bFoundNum==true) {
					bFoundNum = false;
					if (iMaxNumLen>iCurrentMaxNumLen) {
						iCurrentMaxNumStart = iMaxNumStart;
						iCurrentMaxNumLen = iMaxNumLen ;
					}
					iMaxNumStart = -1;
					iMaxNumLen = 0;					
				}
			}
		}
		
		if(bFoundNum==true){
			if (iMaxNumLen>iCurrentMaxNumLen) {
				iCurrentMaxNumStart = iMaxNumStart;
				iCurrentMaxNumLen = iMaxNumLen ;
			}			
		}
		
		if (iCurrentMaxNumLen>0) {
			return strInput.substring(iCurrentMaxNumStart, iCurrentMaxNumStart + iCurrentMaxNumLen);
		} else {
			return null;
		}
	}
	
	public static String getMaxNumString2(String strInput) {
		int iMax = 0;
		int iResult = -1;
		int iLen = 0;
		char[] input = strInput.toCharArray();
		
		for(int index=0; index<strInput.length(); index++) {
			if ((input[index]>='0') && (input[index]<='9')) {
				iLen++;
			} else {
				if(iLen>iMax) {
					iMax = iLen;
					iResult = index - iLen ;
				}
				iLen = 0;
			}
		}
		if(iLen>iMax) {
			iMax = iLen;
			iResult = strInput.length() - iLen  ;
		}	
		if (iMax==0) {
			return null;
		}
		return strInput.substring(iResult, iResult+iMax);
	}
	
	/* Question 26
	 * Left rotate a string. abcdef -> cdefab
	 * Hint: Programming Pearls. Reverse the whole string, reverse the left side of the 
	 * splitter, reverse the right side of the splitter
	 */
	
	/* Question 27
	 * There are n stairs, you can jump by 1 or 2 steps. How many ways in total
	 * Hint: Fabonacci. 
	 */
	
	/* Question 28
	 * Count the 1 bit of an integer
	 */
	public static int countBit(int iInput){
		int iTemplate = 0x0001;
		int iResult = 0x0000;
		while(iTemplate>0) {
			if ((iTemplate & iInput)>0) {
				iResult++;
			}
			iTemplate = iTemplate << 1;
		}
		return iResult;
	}
	
	/* Question 29
	 * Input two integer array, one is the push sequence, check whether the 
	 * other array is the pop sequence
	 * Hint: simulate the pop sequence, try to match push side. 
	 */
	public static boolean checkStackPushPop(int[] push, int[]pop) {
		Stack<Integer> stack = new Stack<Integer>();
		int iLen = push.length;
		stack.push(push[0]);
		int iPush = 1;
		int iPop = 0;
		while (iPop<iLen) {
			if (stack.peek()!=pop[iPop]) {
				if (iPush==iLen) {
					return false;
				}
				stack.push(push[iPush]);
				iPush++;
			} else {
				stack.pop();
				iPop++;
			}
		}
		return true;
	}
	
	/* Question 30
	 * Input n, find the total number of 1s shown in the integer between 1 and n
	 * Hint: N=ABCDE; 
	 * If E<1, return # of ABCD, otherwise, # of ABCD + 1
	 * If D<1, return # of ABC * 10; If D==1, # of ABC * 10 + # of E + 1; Otherwise, (# of ABC + 1)*10
	 */
	
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

// Question 2: Create a MinStack
class StackNode {
	public int val;
	public int pre_min;
	
	public StackNode(int v, int m) {
		val = v;
		pre_min = m;
	}
}

class MinStack {
	private Stack<StackNode> s = new Stack<StackNode>();
	private int pre_min = 9999999;
	
	public int min() {
		return pre_min;
	}
	
	public int pop() {
		StackNode n = s.pop();
		pre_min = n.pre_min;
		return n.val;
	}
	
	public void push(int i) {
		int temp = pre_min;
		if (i<pre_min) {
			pre_min = i;
		}
		s.push(new StackNode(i,temp));
	}
}

class MaxHeap {
	public int[] heap ;
	public int size;
	
	public MaxHeap(int[] h) {
		heap = h;
		size = h.length;
		for(int i=(size/2-1); i>=0; i--) {
			heapfy(i);
		}
	}
	
	private void heapfy(int iCurrent) {
		int iLeft = iCurrent*2 + 1;
		int iRight = iCurrent*2 + 2;
		if (iLeft<size) {
			if (heap[iLeft]>heap[iCurrent]) {
				swap(iLeft, iCurrent);
			}
		}
		if (iRight<size) {
			if (heap[iRight]>heap[iCurrent]) {
				swap(iRight, iCurrent);
			}
		}		
	}
	
	public int top() {
		return heap[0];
	}
	
	public void replacetop(int i) {
		heap[0] = i ;
		heapfy(0);
	}
	
	private void swap(int i, int j) {
		int temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}
	
	public String printHeap() {
		StringBuffer sb = new StringBuffer();
		for(int i:heap) {
			sb.append(i).append(",");
		}
		return sb.toString();
	}
	
}

class LinkNode {
	public int val;
	public LinkNode next;
}