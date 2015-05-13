package com.junma.leetcode.questions;

import static org.junit.Assert.*;

import org.junit.Test;

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (divisor==0) {
            return -1 ;
        }
        
        boolean bNeg = true ;
        if ((dividend>0) && (divisor>0)) {
            bNeg = false ;
        }
        if ((dividend<0) && (divisor<0)) {
            bNeg = false ;
        }        
        
        int remain = Math.abs(dividend) ;
        int divisor2 = Math.abs(divisor) ;
        
        if (divisor2<0) {
        	divisor2 = Integer.MAX_VALUE ;
        }
        
        if (remain<divisor2) {
        	return 0 ;
        }
        
        int divisor3 = divisor2 ;
        
        int times = 1 ;
        boolean bOut = false ;
        while(remain>=divisor2) {
        	System.out.println(divisor2) ;
            divisor2 = divisor2 << 1 ;
            times = times << 1 ;
            if (divisor2>(Integer.MAX_VALUE>>1)) {
            	bOut = true ;
            	break ;
            }
        }
        
        if (bOut) {
        	remain = remain - divisor2 ;
        } else {
            remain = remain - (divisor2 >> 1) ;
            times = times >> 1;        	
        }

        times = times + divide(remain, divisor3) ;
        
        if (bNeg) {
            return (-1)*times ;
        } else {
            return times ;
        }
    }
    
	@Test
	public void test() {
		assertEquals(20, divide(101, 5));
		
		long t1 = System.currentTimeMillis() ; 
		assertEquals(0, divide(-999511578, -2147483648));
		System.out.println(System.currentTimeMillis()-t1) ;
		
	}

}
