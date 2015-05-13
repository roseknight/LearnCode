package com.junma.jobhunt.ms100;
import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

public class TestMSQuestions100_Part1 {
	@Test
	public void testConvertTree2LinkedList() {
		BinarySearchTree t = new BinarySearchTree(new int[]{5,3,7,2,1});
		assertEquals(t.printTree(), "5,\n3,7,\n2,\n1,\n");
		TreeNode index = MSQuestions100_Part1.convertTree2LinkedList(t.root, true) ;
		while(index!=null) {
			System.out.print(index.val + "->");
			index = index.right;
		}
		System.out.println("");
	}
	
	@Test
	public void testMinStack() {
		MinStack s = new MinStack();
		s.push(4);
		s.push(9);
		s.push(1);
		s.push(3);
		assertEquals(s.min(),1);
		s.pop();
		assertEquals(s.min(),1);
		s.pop();
		assertEquals(s.min(),4);
		s.pop();
		assertEquals(s.min(),4);
	}
	
	@Test
	public void testGetMaxSuminSubArray() {
		int sum = MSQuestions100_Part1.getMaxSuminSubArray(new int[]{1,-2,3,10,-4,7,2,-5});
		assertEquals(sum, 18);
	}
	
	
	@Test 
	public void testFindPathsSumX() {
		System.out.println("-------------- testFindPathsSumX");
		BinarySearchTree t = new BinarySearchTree(new int[]{10,5,12,4,7});
		assertEquals(t.printTree(), "10,\n5,12,\n4,7,\n");	
		MSQuestions100_Part1.findPathsSumX(t.root, 22, new LinkedList<Integer>());
	}
	
	@Test
	public void testFindKMinInt() {
		assertEquals(MSQuestions100_Part1.findKMinInt(new int[]{10,5,12,4,7,2}, 3), "5,2,4,");
	}
	
	@Test
	public void testGetTreeDepth() {
		BinarySearchTree t = new BinarySearchTree(new int[]{5,3,7,8,2,1});
		assertEquals(MSQuestions100_Part1.getTreeDepth(t.root),4);		
	}
	
	@Test
	public void testCheckJointLinkedList() {
		LinkNode a = MSQuestions100_Part1.convertStringToList("1->2->3->4");
		LinkNode b = MSQuestions100_Part1.convertStringToList("7->8");
		LinkNode c = MSQuestions100_Part1.convertStringToList("5->6");	
		assertFalse(MSQuestions100_Part1.checkJointLinkedList(a, b));
		MSQuestions100_Part1.getLastNode(a).next = c;
		MSQuestions100_Part1.getLastNode(b).next = c;	
		assertTrue(MSQuestions100_Part1.checkJointLinkedList(a, b));		
	}
	
	@Test
	public void testReverseLinkedList() {
		LinkNode a = MSQuestions100_Part1.convertStringToList("1->2->3->4");
		a = MSQuestions100_Part1.reverseLinkedList1(a);
		assertEquals("4->3->2->1", MSQuestions100_Part1.printLinkedList(a));
		a = MSQuestions100_Part1.convertStringToList("1->2->3->4");
		a = MSQuestions100_Part1.reverseLinkedList2(a);
		assertEquals("4->3->2->1", MSQuestions100_Part1.printLinkedList(a));		
	}
	
	@Test
	public void testReverseString() {
		assertEquals("12345", MSQuestions100_Part1.reverseString("54321"));
	}
	
	@Test
	public void testReverseSentence() {
		assertEquals("I am a student.", MSQuestions100_Part1.reverseSentence("student. a am I"));
	}	

	@Test
	public void testMirrorBST() {
		BinarySearchTree t = new BinarySearchTree(new int[]{5,3,6,1,4});
		TreeNode temp = MSQuestions100_Part1.mirrorBST(t.root);
		String strOutput = MSQuestions100_Part1.printBSTByLevel(temp);
		assertEquals("5,;6,3,;4,1,", strOutput);
	}	
	
	@Test
	public void testPrintByLevel() {
		BinarySearchTree t = new BinarySearchTree(new int[]{5,3,6,1,4});			
		String strOutput = MSQuestions100_Part1.printBSTByLevel(t.root);
		assertEquals("5,;3,6,;1,4,", strOutput);
	}
	
	@Test
	public void testGetUniqueChar() {
		assertEquals('d', MSQuestions100_Part1.getUniqueChar("abbcdcaaa"));
		assertEquals('@', MSQuestions100_Part1.getUniqueChar("abbcddcaaa"));		
	}
	
	@Test
	public void testParseInt() {
		assertEquals(345, MSQuestions100_Part1.parseInt("345"));
		assertEquals(100, MSQuestions100_Part1.parseInt("100"));
		assertEquals(10, MSQuestions100_Part1.parseInt("010"));	
		assertEquals(0, MSQuestions100_Part1.parseInt("0"));		
	}
	
	@Test
	public void testGetMaxDistanceInTree() {
		BinarySearchTree t = new BinarySearchTree(new int[]{10,5,11,12,4,3,2,1,6,7,8,9});			
		assertEquals(MSQuestions100_Part1.getMaxDistanceInTree(t.root),8);			
	}
	
	@Test
	public void testfindPair4() {
		int[] input = new int[]{1,2,4,7,11,15} ;
		assertEquals(MSQuestions100_Part1.findPair4M(input, 15),"4+11");
		assertEquals(MSQuestions100_Part1.findPair4M(input, 10),null);		
	}
	
	@Test
	public void testGetMaxNumString() {
		assertEquals(MSQuestions100_Part1.getMaxNumString("abcd123ed1234fg12345"), "12345");
		assertEquals(MSQuestions100_Part1.getMaxNumString("abcd123ed1234fg12345hi"), "12345");	
		assertEquals(MSQuestions100_Part1.getMaxNumString("abcd"), null);
		assertEquals(MSQuestions100_Part1.getMaxNumString("12345"), "12345");
		assertEquals(MSQuestions100_Part1.getMaxNumString("123ed1234fg12345"), "12345");
		assertEquals(MSQuestions100_Part1.getMaxNumString("12345ed1234fg1234"), "12345");		

		
		assertEquals(MSQuestions100_Part1.getMaxNumString2("abcd123ed1234fg12345"), "12345");
		assertEquals(MSQuestions100_Part1.getMaxNumString2("abcd123ed1234fg12345hi"), "12345");	
		assertEquals(MSQuestions100_Part1.getMaxNumString2("abcd"), null);
		assertEquals(MSQuestions100_Part1.getMaxNumString2("12345"), "12345");
		assertEquals(MSQuestions100_Part1.getMaxNumString2("123ed1234fg12345"), "12345");
		assertEquals(MSQuestions100_Part1.getMaxNumString2("12345ed1234fg1234"), "12345");		
	
	}
	
	@Test
	public void testgetFibonacciNumber() {
		assertEquals(MSQuestions100_Part1.getFibonacciNumber(11),89);
	}
	
	@Test
	public void testCountBit() {
		assertEquals(MSQuestions100_Part1.countBit(0), 0);
		assertEquals(MSQuestions100_Part1.countBit(1), 1);	
		assertEquals(MSQuestions100_Part1.countBit(2), 1);	
		assertEquals(MSQuestions100_Part1.countBit(3), 2);		
	}
	
	@Test
	public void testCheckStackPushPop() {
		assertTrue(MSQuestions100_Part1.checkStackPushPop(new int[]{1,2,3,4,5},new int[]{4,5,3,2,1}));
		assertFalse(MSQuestions100_Part1.checkStackPushPop(new int[]{1,2,3,4,5},new int[]{4,3,1,5,2}));
	}
	
	@Test
	public void testFindSubString() {
		System.out.println(java.util.Arrays.toString(MSQuestions100_Part1.preKMP("abaab")));
		System.out.println(java.util.Arrays.toString(MSQuestions100_Part1.preKMP("cbd")));
		
		assertEquals(5, MSQuestions100_Part1.findSubString("abccbbcbdefg", "bcb"));
		assertEquals(3, MSQuestions100_Part1.findSubString("aefcbdk", "cbd"));		
		assertEquals(2, MSQuestions100_Part1.findSubString("cbcbddg", "cbd"));
	}

}
