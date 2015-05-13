package com.junma.alg.sort;

public class ArraySort {

	public static int[] insertSort(int[] input) {
		if (input.length <= 1) {
			return input;
		}
		int iBigO = 0;
		int j,  value;
		for(int i=1; i<input.length; i++){
			j = 0;
			while(j<i && input[j]<input[i]) {
				iBigO = iBigO + 1;
				j++;
			}
			if (j<i) {
				value = input[i];
				for(int k=i; k>j; k--) {
					iBigO = iBigO + 1;
					input[k] = input[k-1];
				}
				input[j] = value;
			}
		}
		System.out.println("BigO: " + iBigO);
		return input;
	}

	public static int[] selectSort(int[] input) {
		if (input.length <= 1) {
			return input;
		}
		int iBigO = 0;
		int index, temp;
		for(int i=0; i<input.length; i++){
			index = i;
			for(int j=i; j<input.length; j++) {
				iBigO = iBigO + 1;
				// find the min one
				if (input[index] > input[j]) {
					index = j;
				}
			}
			// swap
			if (index != i) {
				temp = input[i];
				input[i] = input[index] ;
				input[index] = temp;
			}
		}
		System.out.println("BigO: " + iBigO);
		return input;
	}

	public static int[] bubbleSort(int[] input) {
		if (input.length <= 1) {
			return input;
		}
		int iBigO = 0;
		int temp;
		for(int i=0; i<input.length; i++){
			for(int j=i+1; j<input.length; j++) {
				iBigO = iBigO + 1;
				if (input[i] > input[j]) {
					temp = input[i];
					input[i] = input[j] ;
					input[j] = temp;
				}
			}
		}
		System.out.println("BigO: " + iBigO);
		return input;
	}

	public static void swap(int[] input, int i, int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}
	
	public static int partition(int[] input, int i, int j) {
		int temp = input[j];
		int maxindex = i;
		for(int p=i; p<j; p++) {
			if (input[p] < temp) {
				swap(input, maxindex, p) ;
				maxindex++;
			}
		}
		swap(input, maxindex, j);	
		return maxindex;
	}
	
	public static int[] quickSort(int[] input, int i, int j) {
		if (i<j) {
			int q = partition(input, i, j);
			quickSort(input, i, q-1);
			quickSort(input, q+1, j);
		}
		return input;
	}

	public static void merge(int[] input, int p, int q, int r) {
		int i = p;
		int j = q;
		int len = r-p+1;
		int[] temp = new int[len];
		int index = 0;
		
		while(i<=q-1 && j<=r) {
			if (input[i] < input[j]) {
				temp[index] = input[i];
				i++;
			} else {
				temp[index] = input[j];
				j++;
			}
			index++;
		}
		
		while(i<=q-1) {
			temp[index] = input[i] ;
			index++;
			i++;
		}
		
		while(j<=r) {
			temp[index] = input[j];
			index++;
			j++;
		}
		
		index = p;
		i = 0;
		while(index<=r) {
			input[index] = temp[i] ;
			index++;
			i++;
		}
	}
	
	public static void mergeSort(int[] input, int p, int r) {
		if (r>p) {
			int q;
			q = Math.round((p+r)/2);
			mergeSort(input, p, q);
			mergeSort(input, q+1, r);
			merge(input, p, q+1, r);
		} 	
	}

	public static void max_heapify(int[] input, int iNode, int iLast) {
		int iLeft = iNode * 2 + 1;
		int iRight = iNode * 2 + 2;
		int iLargest = -1;
		if ((iLeft <= iLast) && (input[iLeft] > input[iNode])) {
			iLargest = iLeft;
		} else {
			iLargest = iNode;
		}
		if ((iRight <= iLast) && (input[iRight] > input[iLargest])) {
			iLargest = iRight;
		}
		if (iLargest > iNode) {
			int iTemp = input[iNode] ;
			input[iNode] = input[iLargest] ;
			input[iLargest] = iTemp;
			max_heapify(input, iLargest, iLast);
		}	
	}
	
	public static void heapSort(int[] input) {
		int iLast = input.length-1;
		for(int i=(iLast-1)/2; i>=0; i--) {
			max_heapify(input, i, iLast);
		}	
		int iTemp = -1;
		for(int i=iLast; i>0; i--) {
			iTemp = input[i];
			input[i] = input[0];
			input[0] = iTemp;
			max_heapify(input, 0, i-1);
		}
	}
	
}
