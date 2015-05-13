package com.junma.jobhunt.careercup.c9;

import static org.junit.Assert.*;

import org.junit.Test;

public class Chapter9SortingNSearchingTest {

	@Test
	// 9.1
	public void testMerge() {
		int[] a = new int[5];
		a[0]=3;
		a[1]=5;
		a[2]=8;
		int[] b = new int[] {2,6};
		assertArrayEquals(Chapter9SortingNSearching.merge(a, b, 3), new int[] {2,3,5,6,8});
		a = new int[5];
		a[0] = 7;
		a[1] = 8;
		a[2] = 9;
		assertArrayEquals(Chapter9SortingNSearching.merge(a, b, 3), new int[] {2,6,7,8,9});
		a = new int[5];
		a[0] = 7;
		a[1] = 8;
		a[2] = 9;
		b = new int[] {10,11};
		assertArrayEquals(Chapter9SortingNSearching.merge(a, b, 3), new int[] {7,8,9,10,11});
	}
	
	@Test
	// 9.3
	public void testFindInRotation(){
		int[] input = new int[] {15,16,19,20,25,1,3,4,5,7,10,14};
		assertEquals(Chapter9SortingNSearching.findInRotation(input, 0, input.length-1, 5), 8);
		assertEquals(Chapter9SortingNSearching.findInRotation(input, 0, input.length-1, 20), 3);
		assertEquals(Chapter9SortingNSearching.findInRotation(input, 0, input.length-1, 15), 0);
		assertEquals(Chapter9SortingNSearching.findInRotation(input, 0, input.length-1, 14), 11);
		assertEquals(Chapter9SortingNSearching.findInRotation(input, 0, input.length-1, 25), 4);
		assertEquals(Chapter9SortingNSearching.findInRotation(input, 0, input.length-1, 1), 5);		
		assertEquals(Chapter9SortingNSearching.findInRotation(input, 0, input.length-1, 9), -1);		
		
	}

}
