package com.junma.alg.search;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.*;


public class BinarySearchTest {

	@Test
	public void testBinarySearch() {
		int[] input = new int[]{1,3,5,6,8,10};
		assertEquals(3, BinarySearch.binarySearch(input, 6));
		assertEquals(0, BinarySearch.binarySearch(input, 1));	
		assertEquals(5, BinarySearch.binarySearch(input, 10));		
		assertEquals(-1, BinarySearch.binarySearch(input, 0));	
		assertEquals(-1, BinarySearch.binarySearch(input, 11));			
		assertEquals(-1, BinarySearch.binarySearch(input, 4));			
	}
	
	private void printLink(Node head) {
		Node index = head;
		while(index!=null) {
			System.out.print(index.value) ;
			index = index.next;
		}
		System.out.println();
	}
	
	private Node reverseLink1(Node head) {
		Stack<Node> s = new Stack<Node>();
		Node index = head;
		while(index!=null) {
			s.push(index);
			index = index.next;
		}
		Node newhead = s.pop();
		newhead.next = null;
		index = newhead;
		while(!s.empty()) {
			index.next = s.pop();
			index.next.next = null;
			index = index.next;
		}
		return newhead;
	}
	
	private Node reverseLink2(Node head) {
		if(head.next==null) {
			return head;
		}
		Node newhead = reverseLink2(head.next) ;
		Node index = newhead ;
		while(index.next!=null) {
			index = index.next;
		}
		index.next = head;
		head.next = null;
		return newhead;
	}
	
	@Test
	public void testReversedLink() {
		Node head = new Node();
		head.value = 0;
		head.next = null;
		Node temp = head;
		for(int i=1; i<5; i++) {
			temp.next = new Node();
			temp.next.value = i;
			temp.next.next = null;
			temp = temp.next;
		}
		printLink(head);
		head = reverseLink1(head);
		printLink(head);
		head = reverseLink2(head);
		printLink(head);	
	}

}

class Node {
	int value;
	Node next;
}
