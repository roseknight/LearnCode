package com.junma.jobhunt.careercup.c4;

import static org.junit.Assert.*;

import org.junit.Test;

public class Chapter4TreesNGraphsTest {

	@Test
	public void testBinarySearchTree() {
		BinarySearchTree t = new BinarySearchTree(new int[]{5,3,7});
		assertEquals(t.printTree(), "5,\n3,7,\n");
		assertEquals(Chapter4TreesNGraphs.checkTreeBalanced(t),0);	
		t = new BinarySearchTree(new int[]{5,3,7,2});
		assertEquals(t.printTree(), "5,\n3,7,\n2,\n");
		assertEquals(Chapter4TreesNGraphs.checkTreeBalanced(t),1);		
		t = new BinarySearchTree(new int[]{5,3,7,2,1});
		assertEquals(t.printTree(), "5,\n3,7,\n2,\n1,\n");
		assertEquals(Chapter4TreesNGraphs.checkTreeBalanced(t),2);	
	}
	
	//4.1
	@Test
	public void testcheckTreeBalanced() {
		BinarySearchTree t = new BinarySearchTree(new int[]{5,3,7,8});		
		assertTrue(Chapter4TreesNGraphs.checkTreeBalanced(t)<=1);
		t = new BinarySearchTree(new int[]{5,3,7,8,9});	
		assertTrue(Chapter4TreesNGraphs.checkTreeBalanced(t)>1);	
		t = new BinarySearchTree(new int[]{5});	
		assertTrue(Chapter4TreesNGraphs.checkTreeBalanced(t)<=1);	
		t = new BinarySearchTree(new int[]{});	
		assertTrue(Chapter4TreesNGraphs.checkTreeBalanced(t)<=1);			
	}
	
	@Test
	public void testcheckTreeBalanced2() {
		BinarySearchTree t = new BinarySearchTree(new int[]{5,3,7,8});		
		assertEquals(Chapter4TreesNGraphs.getMaxDepth(t.root),3);
		assertEquals(Chapter4TreesNGraphs.getMinDepth(t.root),2);
		assertTrue(Chapter4TreesNGraphs.checkTreeBalanced2(t)<=1);
		t = new BinarySearchTree(new int[]{5,7,8,9});		
		assertEquals(Chapter4TreesNGraphs.getMaxDepth(t.root),4);
		assertEquals(Chapter4TreesNGraphs.getMinDepth(t.root),1);		
		assertTrue(Chapter4TreesNGraphs.checkTreeBalanced2(t)>1);	
		t = new BinarySearchTree(new int[]{5});	
		assertTrue(Chapter4TreesNGraphs.checkTreeBalanced2(t)<=1);	
		t = new BinarySearchTree(new int[]{});	
		assertTrue(Chapter4TreesNGraphs.checkTreeBalanced2(t)<=1);		
	}	
	
	@Test
	// 4.3
	public void testInsertArrayIntoBST() {
		BinarySearchTree t = new BinarySearchTree(new int[]{});
		Chapter4TreesNGraphs.insertArrayToBST(t, new int[]{1,2,3,5,7,8,9}, 0, 6);
		assertEquals(t.printTree(), "5,\n2,8,\n1,3,7,9,\n");
		assertEquals(Chapter4TreesNGraphs.checkTreeBalanced(t), 0);	

		t = new BinarySearchTree(new int[]{});
		Chapter4TreesNGraphs.insertArrayToBST(t, new int[]{1,2,3,4}, 0, 3);
		assertEquals(t.printTree(), "2,\n1,3,\n4,\n");
		assertEquals(Chapter4TreesNGraphs.checkTreeBalanced(t), 1);			
		
	}
	
	@Test
	public void testFindCloestValue() {
		BinarySearchTree t = new BinarySearchTree(new int[]{10,5,15,1});
		assertEquals(Chapter4TreesNGraphs.findClosetValue(t, 6), 5) ;
		assertEquals(Chapter4TreesNGraphs.findClosetValue(t, 9), 10) ;
		assertEquals(Chapter4TreesNGraphs.findClosetValue(t, 16), 15) ;	
		assertEquals(Chapter4TreesNGraphs.findClosetValue(t, 14), 15) ;		
		assertEquals(Chapter4TreesNGraphs.findClosetValue(t, 11), 10) ;	
		assertEquals(Chapter4TreesNGraphs.findClosetValue(t, 2), 1) ;			
	}
	
	@Test 
	public void testIsBST() {
		BinaryTree t1 = new BinaryTree(new int[]{5,3,8,1,4,7,9});	
		System.out.println(t1.printTree());
		BinaryTree t2 = new BinaryTree(new int[]{5,3,8,1,6,7,9});	
		System.out.println(t2.printTree());
		assertEquals(Chapter4TreesNGraphs.isBST(t1.root), true);
		assertEquals(Chapter4TreesNGraphs.isBST(t2.root), false);	
		assertEquals(Chapter4TreesNGraphs.isBST2(t1.root), true);
		assertEquals(Chapter4TreesNGraphs.isBST2(t2.root), false);	
		assertEquals(Chapter4TreesNGraphs.isBST3(t1.root), true);
		assertEquals(Chapter4TreesNGraphs.isBST3(t2.root), false);			
	}
	
	@Test
	public void testfindLowestCommonAncester() {
		BinaryTree t1 = new BinaryTree(new int[]{5,3,8,1,4,7,9});	
		assertEquals(Chapter4TreesNGraphs.findLowestCommonAncester(t1.root, 1, 4),3);
		assertEquals(Chapter4TreesNGraphs.findLowestCommonAncester(t1.root, 7, 9),8);
		assertEquals(Chapter4TreesNGraphs.findLowestCommonAncester(t1.root, 4, 9),5);
		assertEquals(Chapter4TreesNGraphs.findLowestCommonAncester(t1.root, 8, 7),8);		
		assertEquals(Chapter4TreesNGraphs.findLowestCommonAncester(t1.root, 2, 6),-1);
		assertEquals(Chapter4TreesNGraphs.findLowestCommonAncester2(t1.root, 1, 4),3);
		assertEquals(Chapter4TreesNGraphs.findLowestCommonAncester2(t1.root, 7, 9),8);
		assertEquals(Chapter4TreesNGraphs.findLowestCommonAncester2(t1.root, 4, 9),5);
		assertEquals(Chapter4TreesNGraphs.findLowestCommonAncester2(t1.root, 5, 1),5);		
		assertEquals(Chapter4TreesNGraphs.findLowestCommonAncester2(t1.root, 2, 6),-1);		
	}

	@Test
	public void testprintPathes4M() {
		BinaryTree t1 = new BinaryTree(new int[]{5,6,3,4,2,1,9});
		System.out.println(t1.printTree());
		Chapter4TreesNGraphs.printPathes4M(t1.root, 9);
	}
}
