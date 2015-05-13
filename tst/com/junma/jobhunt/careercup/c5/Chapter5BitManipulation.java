package com.junma.jobhunt.careercup.c5;

import static org.junit.Assert.*;

import org.junit.Test;

public class Chapter5BitManipulation {

	public static int setBit(int N, int M, int i, int j) {
		int iModel = ((1<<i)-1) | ((32*1024-1)<<j) ;
		int iResult = N & iModel ;
		iResult = iResult | (M<<i) ;
		return iResult;
	}
	
	public static int getNumBitToConvert(int N, int M) {
		int X = N ^ M;
		int iResult = 0, iIndex=1;
		for(int i=1; i<=32; i++) {
			if ((iIndex & X) > 0 ){
				iResult ++;
			}
			iIndex = iIndex*2;
		}
		return iResult;
	}
	
	public static String getDecimalBinary(String strNum) {
		double num = Double.parseDouble(strNum) ;
		num = num - (int)num;
		StringBuffer strB = new StringBuffer();
		double dIndex = 0.5, dCurrent = num;
		while(dCurrent>(1/64.0)) {
			if (dCurrent>=dIndex) {
				strB.append("1");
				dCurrent = dCurrent - dIndex ;
			} else {
				strB.append("0");
			}
			dIndex = dIndex/2;
		}
		if (dCurrent>0.0) {
			return "ERROR";
		} else {
			return strB.toString();
		}
	}
	
	public static byte swapOddEvenBits(byte input){
		byte OddBit = 10, EvenBit = 5;
		byte b1 = (byte) ((input & OddBit ) >> 1);
		byte b2 = (byte) ((input & EvenBit) << 1);
		return (byte) (b1 | b2);

	}
	
	public static int findMissingInt2N(int[] test) {
		int iResult = -1;
		for(int i:test) {
			if(iResult<0) {
				iResult = i;
			} else {
				iResult = iResult ^ i;
			}
		}
		return iResult;
	}
	
	public static int setIntBit(int n, int index, boolean set) {
		if (set) {
			return n | (1<<index);
		} else {
			return n & (~(1<<index));
		}
	}
	
	public static boolean getIntBit(int n, int index) {
		return (n&(1<<index))>0 ;
	}
	
	public static int getNextNum(int n) {
		int iResult = n;
		int iOnes = 0;
		int iOneIndex = 0;
		
		if(n<=0) {
			return 0;
		}
		
		while((!getIntBit(n, iOneIndex))||getIntBit(n, iOneIndex+1)) {
			if(getIntBit(n,iOneIndex)) {
				iOnes++;
			}
			iOneIndex++;
		}
		iResult = setIntBit(n, iOneIndex, false);
		iResult = setIntBit(iResult, iOneIndex+1, true);
		for(int i=0; i<iOnes; i++) {
			iResult = setIntBit(iResult, i, true);
		}
		for(int i=iOnes; i<iOneIndex; i++) {
			iResult = setIntBit(iResult, i, false);
		}
		return iResult;
	}
	
	public static int findMissingInt2N2(int[] test, int bitlen) {
		int iResult = 0;
		int iOnes = 0;
		int iZeros = 0;
		
		for(int i=0; i<bitlen; i++) {
			iOnes = 0;
			iZeros = 0;
			for(int j:test) {
				if (getIntBit(j,i)) {
					iOnes++;
				} else {
					iZeros++;
				}
			}
			if(iOnes<iZeros){
				iResult = setIntBit(iResult, i, true);
			}
		}
		return iResult;
	}
	
	@Test
	// 5.1
	public void testSetBit() {
		assertEquals(setBit(259, 21, 2, 6), 259+84) ;
		assertEquals(setBit(256, 21, 2, 6), 256+84) ;		
		assertEquals(setBit(256+4, 21, 2, 6), 256+84) ;		
	}

	@Test
	// 5.2
	public void testgetDecimalBinary() {
		assertEquals(getDecimalBinary("0.625"), "101");
		assertEquals(getDecimalBinary("0.626"), "ERROR");		
		assertEquals(getDecimalBinary("0.62500000001"), "ERROR");			
	}
	
	@Test
	//5.3
	public void testGetNextNum() {
		assertEquals(getNextNum(1), 2);
		assertEquals(getNextNum(3), 5);		
		assertEquals(getNextNum(12), 17);			
	}
	
	@Test
	//5.5
	public void testGetNumBitToConvert() {
		assertEquals(getNumBitToConvert(31,14), 2);
	}
	
	@Test
	//5.6
	public void testSwapOddEvenBits() {
		byte b1 = 5, b2 = 10;
		assertEquals(swapOddEvenBits(b1), b2);
		assertEquals(swapOddEvenBits(b2), b1);	
		b1 = 0;
		assertEquals(swapOddEvenBits(b1), b1);		
		b1 = 15;
		assertEquals(swapOddEvenBits(b1), b1);			
	}
	
	@Test
	public void testFindMissingInt2N() {
		assertEquals(findMissingInt2N(new int[]{0,1,2,4,5,6,7}),3);			
	}
	
	@Test
	public void testFindMissingInt2N2() {
		assertEquals(findMissingInt2N2(new int[]{0,1,2,4,5,6,7}, 3),3);		
		assertEquals(findMissingInt2N2(new int[]{0,1,2,3,4,5,6,7,8,9,10,11,13,14,15,16},4),12);			
	}
	
}
