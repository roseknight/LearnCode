package com.junma.alg.sort;

public class KSizeMinHeap {
	int[] iHeap = null;
	
	public KSizeMinHeap(int[] iInit) {
		iHeap = iInit;
		// Build the heap
		for(int i=(iInit.length-2)/2; i>=0; i--) {
			min_heapify(i);
		}
	}
	
	public void insert(int v) {
		iHeap[0] = v;
		min_heapify(0);
	}
	
	public int[] getHeap() {
		return iHeap;
	}
	
	public int getMin() {
		return iHeap[0];
	}
	
	private void min_heapify(int iNode) {
		int iLeft = iNode * 2 + 1;
		int iRight = iNode * 2 + 2;
		int iSmallest = -1 ;
		if ((iLeft<iHeap.length)&&(iHeap[iLeft]<iHeap[iNode])) {
			iSmallest = iLeft;
		} else {
			iSmallest = iNode;
		}
		if ((iRight<iHeap.length)&&(iHeap[iRight]<iHeap[iSmallest])) {
			iSmallest = iRight;
		}
		if (iSmallest != iNode) {
			int iTemp = iHeap[iNode] ;
			iHeap[iNode] = iHeap[iSmallest] ;
			iHeap[iSmallest] = iTemp;
			min_heapify(iSmallest);
		}
	}	
}
