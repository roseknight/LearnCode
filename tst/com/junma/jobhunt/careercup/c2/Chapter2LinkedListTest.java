package com.junma.jobhunt.careercup.c2;

import static org.junit.Assert.*;

import org.junit.Test;

public class Chapter2LinkedListTest {

	@Test
	public void testRemoveDuplicateNodes() {
		Node head = Chapter2LinkedList.createList("5->2->3->2->5->1->7");
		Node result = Chapter2LinkedList.removeDuplicateNodes(head);
		assertEquals(Chapter2LinkedList.printList(result), "5->2->3->1->7");
		
	}

	@Test
	public void testRemoveDuplicateNodes2() {
		Node head = Chapter2LinkedList.createList("5->2->3->2->5->1->7");
		Node result = Chapter2LinkedList.removeDuplicateNodes2(head);
		assertEquals(Chapter2LinkedList.printList(result), "5->2->3->1->7");
		
	}	
	
	@Test
	public void testFindNthLastNode() {
		Node head = Chapter2LinkedList.createList("5->2->3->2->5->1->7");
		assertEquals(Chapter2LinkedList.findNthLastNode(head, 3).val, 2);
		assertEquals(Chapter2LinkedList.findNthLastNode(head, 0).val, 7);	
		assertEquals(Chapter2LinkedList.findNthLastNode(head, 6).val, 5);	
		assertEquals(Chapter2LinkedList.findNthLastNode(head, 1).val, 1);	
		assertEquals(Chapter2LinkedList.findNthLastNode(head, 7), null);			
	}

	@Test
	public void testDeleteNodeInTheMiddle() {
		Node head = Chapter2LinkedList.createList("5->2->3->2->5->1->7");
		Chapter2LinkedList.deleteNodeInTheMiddle(Chapter2LinkedList.findNthLastNode(head, 3));
		assertEquals(Chapter2LinkedList.printList(head), "5->2->3->5->1->7");	
		head = Chapter2LinkedList.createList("5->2->3->2->5->1->7");
		Chapter2LinkedList.deleteNodeInTheMiddle(Chapter2LinkedList.findNthLastNode(head, 0));
		assertEquals(Chapter2LinkedList.printList(head), "5->2->3->2->5->1->7");	
		head = Chapter2LinkedList.createList("5->2->3->2->5->1->7");
		Chapter2LinkedList.deleteNodeInTheMiddle(null);
		assertEquals(Chapter2LinkedList.printList(head), "5->2->3->2->5->1->7");	
		head = Chapter2LinkedList.createList("5->2->3->2->5->1->7");
		Chapter2LinkedList.deleteNodeInTheMiddle(new Node(10));
		assertEquals(Chapter2LinkedList.printList(head), "5->2->3->2->5->1->7");		
	}

	@Test
	public void testAddTwoLists() {
		Node list1 = Chapter2LinkedList.createList("3->1->5");
		Node list2 = Chapter2LinkedList.createList("5->9->2");		
		Node result = Chapter2LinkedList.addTwoLists(list1, list2);
		assertEquals(Chapter2LinkedList.printList(result), "8->0->8");	

		list1 = Chapter2LinkedList.createList("3->1->8");
		list2 = Chapter2LinkedList.createList("5->9->2");		
		result = Chapter2LinkedList.addTwoLists(list1, list2);
		assertEquals(Chapter2LinkedList.printList(result), "8->0->1->1");		
		
		list1 = Chapter2LinkedList.createList("3->1");
		list2 = Chapter2LinkedList.createList("5->9->2");		
		result = Chapter2LinkedList.addTwoLists(list1, list2);
		assertEquals(Chapter2LinkedList.printList(result), "8->0->3");		
		
		list1 = Chapter2LinkedList.createList("1");
		list2 = Chapter2LinkedList.createList("9->9->9");		
		result = Chapter2LinkedList.addTwoLists(list1, list2);
		assertEquals(Chapter2LinkedList.printList(result), "0->0->0->1");			
	}

	@Test
	public void testFindLoopStart() {
		Node head = Chapter2LinkedList.createList("5->2->3->2->5->1->7");
		Node tail = Chapter2LinkedList.findNthLastNode(head, 0);
		Node middle = Chapter2LinkedList.findNthLastNode(head, 3);
		Node middle2 = Chapter2LinkedList.findNthLastNode(head, 5);	
		Node middle3 = Chapter2LinkedList.findNthLastNode(head, 1);			
		
		assertEquals(Chapter2LinkedList.findLoopStart(head), null);		
		
		tail.next = middle;
		assertEquals(Chapter2LinkedList.findLoopStart(head), middle);

		tail.next = tail;
		assertEquals(Chapter2LinkedList.findLoopStart(head), tail);
		
		tail.next = middle3;
		assertEquals(Chapter2LinkedList.findLoopStart(head), middle3);
		
		tail.next = middle2;
		assertEquals(Chapter2LinkedList.findLoopStart(head).val, middle2.val);
		
		head = new Node(5);
		head.next = head;
		assertEquals(Chapter2LinkedList.findLoopStart(head), head);	
		
		assertEquals(Chapter2LinkedList.findLoopStart(null), null);	
		assertEquals(Chapter2LinkedList.findLoopStart(new Node(1)), null);	
		
		head = Chapter2LinkedList.createList("5->2->3->2->5->1->7->3");		
		assertEquals(Chapter2LinkedList.findLoopStart(head), null);			
		
	}
	
	@Test
	public void testReverseLinkedList1() {
		assertEquals(Chapter2LinkedList.reverseLinkedList1(null), null);
		Node head = new Node(5);
		assertEquals(Chapter2LinkedList.reverseLinkedList1(head), head);		
		head = Chapter2LinkedList.createList("5->4->3->2->1");
		assertEquals(Chapter2LinkedList.printList(Chapter2LinkedList.reverseLinkedList1(head)), "1->2->3->4->5");
		head = Chapter2LinkedList.createList("5->4");
		assertEquals(Chapter2LinkedList.printList(Chapter2LinkedList.reverseLinkedList1(head)), "4->5");
	}

	@Test
	public void testReverseLinkedList2() {
		assertEquals(Chapter2LinkedList.reverseLinkedList2(null), null);
		Node head = new Node(5);
		assertEquals(Chapter2LinkedList.reverseLinkedList2(head), head);		
		head = Chapter2LinkedList.createList("5->4->3->2->1");
		assertEquals(Chapter2LinkedList.printList(Chapter2LinkedList.reverseLinkedList2(head)), "1->2->3->4->5");
		head = Chapter2LinkedList.createList("5->4");
		assertEquals(Chapter2LinkedList.printList(Chapter2LinkedList.reverseLinkedList2(head)), "4->5");
	}
}
