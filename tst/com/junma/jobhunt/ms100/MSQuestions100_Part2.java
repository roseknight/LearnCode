package com.junma.jobhunt.ms100;
import java.util.*;

public class MSQuestions100_Part2 {

	// Create a list from string "a->b->c"
	public static Node createList(String strList) {
		String[] strArray = strList.split("->");
		Node head=null, previous=null, current=null;
		for(String strCurrent:strArray) {
			current = new Node(Integer.parseInt(strCurrent));
			if (head==null) {
				head = current;
				previous = current;
			} else {
				previous.next = current;
				previous = current;
			}
		}
		return head;
	}	
	
	/* Question 31
	 * find shortest path
	 */
	
	/* Question 32
	 * Given two integer arrays A and B, size n, no order. Swap between the 
	 * elements to make the difference between the sum of A and the sum of B min
	 * Hint: ??
	 */
	
	/* Question 33
	 * Implement a pattern matching system
	 */
	
	/* Question 34
	 * A producer and consumer problem
	 */
	
	/* Question 35
	 * Find the max sum subarray in an array
	 */
	
	/* Question 36
	 *  Skip
	 */
	
	/* Question 37
	 * there are n strings (size m+1). the last m chars of a string could overlap with the
	 * first m chars of a string. What is the longest string
	 */
	
	/* Question 38
	 * Baidu questions: a lot of URL strings, remove the duplicated ones
	 */
	
	/* Question 39
	 * Find the biggest distance between nodes of a binary tree
	 * Hint: it should be either the distance between the root and a farest leaf;
	 * Or it is the distance between two farest leafs
	 */
	
	/* Question 40
	 * Implment a min stack
	 * Hint: each node should maintain the previous min value
	 */
	
	/* Question 41
	 * Skip
	 */
	
	/* Question 42
	* merge two sorted list and remove duplicated ones. 
	* Hint: Just like merge to array. use two indexes to track
	*/
	public static String mergeList(Node head1, Node head2){
		Node index1 = head1;
		Node index2 = head2;
		StringBuffer sb = new StringBuffer();
		while ((index1!=null)&&(index2!=null)) {
			if (index1.val==index2.val) {
				sb.append(index1.val);
				sb.append("->");
				index1 = index1.next;
				index2 = index2.next;
			} else if (index1.val<index2.val) {
				sb.append(index1.val);
				sb.append("->");
				index1 = index1.next;				
			} else {
				sb.append(index2.val);
				sb.append("->");
				index1 = index2.next;					
			}
		}
		while(index1!=null) {
			sb.append(index1.val);
			if (index1.next!=null) {
				sb.append("->");
			}
			index1 = index1.next;			
		}
		while(index2!=null) {
			sb.append(index2.val);
			if (index2.next!=null) {
				sb.append("->");
			}
			index2 = index2.next;			
		}		
		return sb.toString();
	}
	
	/* Question 43
	 * Implement the transversal of a binary tree preorder with both recusrive 
	 * and iterative ways
	 * Hint: Recursive is easy
	 * Hint: iterative: use a queue
	 */
	
	/* Question 44
	 * A million messages, find the top 10 with the most repetive times
	 * Hint: use hashtable to count, then sort. Can use the external sort idea
	 */
	
	/* Question 45
	 * Yahoo question, skip
	 */
	
	/* Question 46
	 * Print all combinations of k brackets
	 * Hint: use a recursive way to add () to existing set. However, there will be 
	 * duplicated ones. So, use a hashmap to remove duplicated ones. 
	 */
	public static String[] createBracketsComb(int k) {
		Map<String, Integer> result = new Hashtable<String, Integer>();
		if (k==0) {
			return null;
		}
		if (k==1) {
			result.put("()", 0);
			return result.keySet().toArray(new String[0]);
		}
		String[] temp;
		temp = createBracketsComb(k-1);
		String strTemp;
		for(String str : temp) {
			for(int i=0; i<=str.length(); i++) {
				if (i==0) {
					strTemp = "()" + str;
				} else if (i==str.length()) {
					strTemp = str + "()";
				} else {
					strTemp = str.substring(0,i) + "()" + str.substring(i);
				}
				if (!result.containsKey(strTemp)) {
					result.put(strTemp, 0);
				}
			}
			strTemp = "(" + str + ")";
			if (!result.containsKey(strTemp)) {
				result.put(strTemp, 0);
			}			
		}
		return result.keySet().toArray(new String[0]);		
	}
	/* Question 47
	 * Find the longest descending sub sequence (diff by 1) in an array
	 * {9,4,3,2,5,4,3,2} => {5,4,3,2}
	 */
	
	/* Question 48
	 * Search an element in a rotated integer array. 
	 * the hint: for a given element, there is always one side having the normal order. 
	 */
	public static int searchRotatedArray(int[] input, int iLeft, int iRight, int iNum){

		int iIndex;
		
		if(iLeft<=iRight) {
			System.out.println(iLeft + ":" + iRight);
			iIndex = (iLeft + iRight)/2;
			if (input[iIndex]==iNum) {
				return iIndex;
			}
			if (input[iLeft]>=input[iIndex]) {
				// Left side is the correct order ;
				if ((input[iLeft]>=iNum)&&(input[iIndex]<iNum)) {
					return searchRotatedArray(input, iLeft, iIndex-1, iNum);
				} else {
					return searchRotatedArray(input, iIndex+1, iRight, iNum);
				}
			} else {
				// Right side is the correct order ;
				if ((input[iRight]<=iNum)&&(input[iIndex]>iNum)) {
					return searchRotatedArray(input, iIndex+1, iRight, iNum);
				} else {
					return searchRotatedArray(input, iLeft, iIndex-1, iNum);
				}				
			}
		} else {
			return -1;
		}
	}
	
	/* Question 49
	 * Sort n numbers with O(N) time and O(1) space
	 * Hint: Use bitmap
	 */
	
	/* 
	 * Question 50
	 * Same as Question 39, skip
	 */
	
	/* Question 51
	 * Given a number n, output all sequences with the sum as n
	 * Hint: ???
	 */
	
	/* Question 52
	 * Find the depth of a binary tree
	 * Hint: Use recursive way
	 */
	
	/* Question 53
	 * For a given string, output all possible permutations. 
	 * abc => abc, acb, bac, bca, cab, cba
	 */
	
	/* Question 54
	 * For an integer array, make all odd numbers on the left, all even numbers on the right
	 * Hint: move from the head and the tail. 
	 */
	
	/* Question 55
	 * Overload a CString class (Skip)
	 */
	
	/* Question 56
	 * Find the longest common string between two strings
	 * Hint: Important, LCS in dynamic programming
	 */
	
	/* Question 57
	 * Use two stacks to implement a queue
	 * Hint: swap the stacks when push and pop
	 */
	
	/* Quesiton 58
	 * Output a linked list from tend to the head
	 */
	
	/* Question 59
	 * Design a class that can not be inherited. 
	 * In Java, it is a final keyword
	 */
	
	/* Question 60
	 * Delete a linked node with O(1) time
	 * Hint: copy the next node to the current one, and remove the next node. 
	 */
}

class Node {
	int val ;
	Node next;
	
	public Node(int i) {
		val = i;
		next = null;
	}
}