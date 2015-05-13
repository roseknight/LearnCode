package com.junma.leetcode.questions;

import static org.junit.Assert.*;

import org.junit.Test;

public class FindMIssingPositive {
    public int firstMissingPositive(int[] A) {
        if ((A==null)||(A.length==0)) {
            return 1 ;
        }
        
        int temp = 0 ;
        
        for(int i=0; i<A.length; i++) {
            while (A[i]!=(i+1)) {
                if ((A[i]<=0)||(A[i]>=A.length)||(A[i]==A[A[i]-1])) {
                    break ;
                }
                
                temp = A[A[i]-1] ;
                A[A[i]-1] = A[i] ;
                A[i] = temp ;
            }
        }
        
        for(int i=0; i<A.length; i++) {
            if (A[i]!=(i+1)) {
                return i+1 ;
            }
        }
        
        return A.length + 1 ;
    }
    
    
	@Test
	public void test() {
		assertEquals(3, this.firstMissingPositive(new int[]{1,2,0})) ;
		assertEquals(2, this.firstMissingPositive(new int[]{3,4,-1,1})) ;	
		assertEquals(1, this.firstMissingPositive(new int[]{2})) ;		
		assertEquals(2, this.firstMissingPositive(new int[]{1})) ;		
	}

}
