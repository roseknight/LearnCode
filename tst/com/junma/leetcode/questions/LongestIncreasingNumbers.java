package com.junma.leetcode.questions;

import static org.junit.Assert.*;

import org.junit.Test;

public class LongestIncreasingNumbers {
	
	public int findLISContinue(int[] nums) {
		if ((nums==null)||(nums.length==0)) {
			return 0 ;
		}
		
		int max = 0 ;
		int[][] dp = new int[nums.length][nums.length] ;
		
		for(int i=0; i<nums.length; i++) {
			dp[i][i] = 1 ;
		}
		
		for(int i=0; i<nums.length; i++) {
			for(int j=i+1; j<nums.length; j++) {
				if (nums[j]>=nums[j-1]) {
					dp[i][j] = dp[i][j-1] + 1 ;
					if (dp[i][j]>max) {
						max = dp[i][j] ;
					}
				}
			}
		}
		
		return max ;
	}
	
	public int findLISNoContinue(int[] nums) {
		if ((nums==null)||(nums.length==0)) {
			return 0 ;
		}
		
		int max = 0 ;
		int[][] dp = new int[nums.length][nums.length] ;
		int[][] val = new int[nums.length][nums.length] ;		
		
		for(int i=0; i<nums.length; i++) {
			dp[i][i] = 1 ;
			val[i][i] = nums[i] ;
		}
		
		for(int i=0; i<nums.length; i++) {
			for(int j=i+1; j<nums.length; j++) {
				if (nums[j]>=val[i][j-1]) {
					dp[i][j] = dp[i][j-1] + 1 ;
					val[i][j] = nums[j] ;
					
					if (dp[i][j]>max) {
						max = dp[i][j] ;
					}
				} else {
					dp[i][j] = dp[i][j-1] ;
					val[i][j] = val[i][j-1] ;
				}
			}
		}
		
		return max ;
	}

	@Test
	public void test() {
		assertEquals(3, findLISContinue(new int[]{1,2,3})) ;
		assertEquals(3, findLISContinue(new int[]{100,99,98,97,98,96,95,1,2,3,2,1,2,0})) ;		
		
		assertEquals(3, findLISNoContinue(new int[]{1,2,1,3})) ;
		assertEquals(3, findLISNoContinue(new int[]{100,99,98,97,98,96,95,1,2,3,2,1,2,0})) ;		
		assertEquals(3, findLISNoContinue(new int[]{100,99,98,97,98,96,95,1,2,1,3,2,1,2,0})) ;		
		
	}

}
