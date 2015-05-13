package com.junma.alg.search;

public class BinarySearch {
	public static int binarySearch(int[] input, int value) {
		int lBound = 0;
		int rBound = input.length-1;
		int index ;
		
		while(lBound<rBound) {
			index = Math.round((lBound+rBound)/2);
			if (input[index]<value) {
				lBound = index;
			} else if (input[index]>value) {
				rBound = index;
			} else {
				return index;
			}
			
			if(lBound==rBound-1) {
				if(input[rBound]==value) {
					return rBound;
				} else if (input[lBound]==value)
				{
					return lBound;
				} else {
					return -1;
				}
			}
		}
		return -1;
	}
}
