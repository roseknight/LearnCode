package com.junma.leetcode.questions;

import static org.junit.Assert.*;

import org.junit.Test;

public class FindSubArrayWithBiggestSum {

	public int findBiggestSum(int[] A) {
		
		int iMax = A[0] ;
		int sum = 0 ;
		
		for(int i=0; i<A.length; i++) {
			sum += A[i] ;
			if (sum>iMax) {
				iMax = sum ;
			}
			if (sum<0) {
				sum = 0 ;
			}
		}
		return iMax ;
	}
	
	public int findBiggestSum2(int[] A) {
		// DP approach
		int[] dp = new int[A.length] ;
		dp[0] = A[0] ;
		
		int iMax = A[0] ;
		
		for(int i=1; i<A.length; i++) {
			dp[i] = Math.max(A[i], dp[i-1]+A[i]) ;
			if (dp[i]>iMax) {
				iMax = dp[i] ;
			}
		}
		
		return iMax ;
	}
	
	
	@Test
	public void test() {
		int[] data = new int[]{1, -2, 3, 10, -4, 7, 2, -5} ;
		System.out.println(this.findBiggestSum(data)) ;
		System.out.println(this.findBiggestSum2(data)) ;		
	}

}
