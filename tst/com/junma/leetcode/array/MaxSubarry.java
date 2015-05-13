package com.junma.leetcode.array;

import static org.junit.Assert.*;

import org.junit.Test;

public class MaxSubarry {
	public int getMaxSubArray(int[] A) {
		if ((A==null)||(A.length==0)) {
			return 0;
		}
		
		int local = A[0];
		int global =A[0];
		for(int i=1; i<A.length; i++) {
			local = Math.max(A[i], A[i]+local);
			global = Math.max(global, local);
		}
		return global;
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
