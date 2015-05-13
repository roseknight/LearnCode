package com.junma.alg.sort;

import static org.junit.Assert.*;

import org.junit.Test;

public class KSizeMinHeapTest {

	private void printArray(int[] input) {
		for(int i:input) {
			System.out.print(i+",");
		}
		System.out.println();
	}
	
	@Test
	public void test() {
		int[] input3 = new int[]{2,5,7,9,1,6,8,4,11,3,15,1,6,20,3};
		KSizeMinHeap heap = new KSizeMinHeap(new int[]{2,5,7,9,1});
		printArray(heap.getHeap());
		for(int i=5; i<input3.length; i++) {
			if (input3[i]>heap.getMin()) {
				heap.insert(input3[i]);
			}
		}
		printArray(heap.getHeap());
	}

}
