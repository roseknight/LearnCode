package com.junma.leetcode.array;

import static org.junit.Assert.*;

import org.junit.Test;

public class MedianInTwoSortedArrays {

    public double findMedianSortedArrays(int A[], int B[]) {
        int len = A.length + B.length;
        if (len%2==1) {
            return findKth(A, 0, A.length-1, B, 0, B.length-1, len/2);
        } else {
            return (findKth(A, 0, A.length-1, B, 0, B.length-1, len/2) + findKth(A, 0, A.length-1, B, 0, B.length-1, len/2+1))/2.0;
        }
    }
    
    public int findKth(int A[], int Astart, int Aend, int B[], int Bstart, int Bend, int k){
        int ALen = Aend-Astart+1;
        int BLen = Bend-Bstart+1;
        
        if (k==0) {
            return Math.min(A[Astart], B[Bstart]);
        }
        
        if (ALen==0) {
            return B[Bstart+k];
        }
 
        if (BLen==0) {
            return A[Astart+k];
        }       
        
        int Amid = ALen * k / (ALen + BLen);
        int Bmid = k - 1 - Amid ;
        Amid = Amid + Astart;
        Bmid = Bmid + Bstart;
        
        if (A[Amid]>B[Bmid]) {
            k = k - (Bmid - Bstart + 1);
            Aend = Amid;
            Bstart = Bmid + 1;
        } else {
            k = k - (Amid - Astart + 1);
            Bend = Bmid;
            Astart = Amid + 1;
        }

        return findKth(A, Astart, Aend, B, Bstart, Bend, k);
        
    }
    
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
