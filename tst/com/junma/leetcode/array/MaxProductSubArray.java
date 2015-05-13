package com.junma.leetcode.array;

import static org.junit.Assert.*;

import org.junit.Test;

public class MaxProductSubArray {
	public int getMaxProductSubArray(int[] A) {
		if ((A==null)||(A.length==0)) {
			return 0;
		}
		
		int min = A[0];
		int max = A[0];
		int global = A[0];
		for(int i=1; i<A.length; i++) {
			int iTemp = max;
			max = Math.max(Math.max(A[i], A[i]*max), A[i]*min);
			min = Math.min(Math.min(A[i], A[i]*min), A[i]*iTemp);
			global = Math.max(global, max);
		}
		return global;
	}
	
	@Test
	public void test() {
		int[] input = {-4, -3, -2};
		assertEquals(12, getMaxProductSubArray(input));
	}

}
