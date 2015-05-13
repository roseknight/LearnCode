package com.junma.jobhunt.careercup.c9;

public class Chapter9SortingNSearching {
	public static int[] merge(int[] a, int[] b, int aLen){
		int iNext = a.length-1;
		int iA = aLen-1;
		int iB = b.length-1;
		while(iA>=0&&iB>=0) {
			if(a[iA]>b[iB]) {
				a[iNext] = a[iA];
				iA--;
			} else {
				a[iNext] = b[iB];
				iB--;
			}
			iNext--;
		}
		while(iB>=0){
			a[iNext]=b[iB];
			iB--;
			iNext--;
		}
		return a;
	}
	
	// Question 9.3
	// Hint 1: One side is the correct order, the other side is not. 
	// Hint 2: use iMid+1 and iMid-1, the correct scope
	// Hint 3: The base case is iStart==iEnd. 
	public static int findInRotation(int[] input, int iStart, int iEnd, int iVal) {
		if (iEnd==iStart){
			if(input[iStart]==iVal){
				return iStart;
			} else {
				return -1;
			}
		}

		int iMid = (iStart+iEnd)/2 ;
		if (input[iMid]==iVal){
			return iMid;
		}
		if (input[iMid]<iVal) {
			if (((input[iMid]<=input[iEnd]))&&(iVal<=input[iEnd])) {
			// right side is Correct Order
				return findInRotation(input, iMid+1, iEnd, iVal);
			} else {
				return findInRotation(input, iStart, iMid-1, iVal);
			}
		} else {
			if (((input[iMid]>=input[iStart]))&&(iVal>=input[iStart])) {
			// left side is Correct Order
				return findInRotation(input, iStart, iMid-1, iVal);
			} else {
			// right side is Correct Order
				return findInRotation(input, iMid+1, iEnd, iVal);
			}			
		}
	}
}
