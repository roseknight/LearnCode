/**
 * 
 */
package com.junma.alg.sort;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.*;

/**
 * @author junma
 *
 */
public class ArraySortTest {

	/**
	 * @throws java.lang.Exception
	 */
	private int[] input;
	
	@Before
	public void setUp() {
		input = new int[]{4, 2, 6, 9, 1, 0, 5, 2};
	}
	
	private int[] output = new int[]{0, 1, 2, 2, 4, 5, 6, 9};

	private void printArray(int[] input) {
		for(int i:input) {
			System.out.print(i+",");
		}
		System.out.println();
	}
	/**
	 * Test method for {@link com.junma.jobhunt.sort.ArraySort#insertSort(int[])}.
	 */
	@Test
	public void testInsertSort() {
		int[] result = ArraySort.insertSort(input);
		assertArrayEquals(output, result);
	}

	/**
	 * Test method for {@link com.junma.jobhunt.sort.ArraySort#selectSort(int[])}.
	 */
	@Test
	public void testSelectSort() {
		int[] result = ArraySort.selectSort(input);
		assertArrayEquals(output, result);
	}

	/**
	 * Test method for {@link com.junma.jobhunt.sort.ArraySort#bubbleSort(int[])}.
	 */
	@Test
	public void testBubbleSort() {
		int[] result = ArraySort.bubbleSort(input);
		assertArrayEquals(output, result);
	}

	/**
	 * Test method for {@link com.junma.jobhunt.sort.ArraySort#mergeSort(int[])}.
	 */
	@Test
	public void testMergeSort() {
		System.out.println("testMergeSort ---------");
		int[] input2 = new int[]{2,1};
		int[] input3 = new int[]{2,5,7,9,1,6,8,10};		
		ArraySort.merge(input2, 0, 1, input2.length-1);
		printArray(input2);
		ArraySort.merge(input3, 0, 1, input2.length-1);
		printArray(input3);		
		ArraySort.mergeSort(input, 0, input.length-1);
		assertArrayEquals(output, input);		
	}

	/**
	 * Test method for {@link com.junma.jobhunt.sort.ArraySort#quickSort(int[])}.
	 */
	@Test
	public void testQuickSort() {
		System.out.println("testQuickSort ---------");
		int[] input2 = new int[]{2,1};		
		int[] input3 = new int[]{2,5,7,9,1,6,8,4};
		int q = ArraySort.partition(input2, 0, input2.length-1);
		System.out.println(q);
		printArray(input2);
		q = ArraySort.partition(input3, 0, input3.length-1);
		System.out.println(q);
		printArray(input3);		
		
		ArraySort.quickSort(input, 0, input.length-1);
		assertArrayEquals(output, input);
	}
	
	/**
	 * Test method for {@link com.junma.jobhunt.sort.ArraySort#heapSort(int[])}.
	 */
	@Test
	public void testHeapSort() {
		System.out.println("testHeapSort ---------");		
		int[] input3 = new int[]{2,5,7,9,1,6,8,4};
		ArraySort.heapSort(input3);
		printArray(input3);				
	}
	
	@Test
	public void testKSizeHeap() {
		
	}
	
	public void swap(int[] input, int i, int j){
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp ;
	}
	
	public int partition(int[] input, int iLeft, int iRight){		
		int iKey = input[iRight] ;
		int iReplace = iLeft ;
		for(int i=iLeft; i<iRight; i++) {
			if (input[i]<iKey) { 
				swap(input, i, iReplace);
				iReplace++;
			}
		}
		swap(input, iReplace, iRight);
		return iReplace;
	}
	
	public void quicksort2(int[] input, int iLeft, int iRight) {	
		if (iLeft<=iRight) {
			int iMid = partition(input, iLeft, iRight);
			quicksort2(input, iLeft, iMid-1);
			quicksort2(input, iMid+1, iRight);
		}
	}
	
	@Test 
	public void testQuickSort2() {
		System.out.println("testQuickSorts2 ---------");		
		int[] input = new int[]{2,5,7,9,1,6,8,4};
		printArray(input);				
		partition(input, 0, input.length-1);
		printArray(input);
		quicksort2(input, 0, input.length-1);
		printArray(input);
	}	

	public boolean isEven(int a){
		if(a%2==0) { 
			return true;
		} else {
			return false;
		}
	}
	
	public void arrangeOddEven(int[] input) {
		int iLeft = 0;
		int iRight = input.length-1;
		
		while(iLeft<iRight) {
			if (isEven(input[iLeft])) {
				swap(input, iLeft, iRight);
				iRight--;
			} else {
				iLeft++;
			}
		}
	}
	
	@Test
	public void testOddEvenArrange() {
		System.out.println("testOddEvenArrange ---------");		
		int[] input = new int[]{2,5,7,9,1,6,8,4};
		printArray(input);				
		arrangeOddEven(input);
		printArray(input);
	}
	
	public String swapString(String input, int i, int j){
		char[] cTempArray = input.toCharArray();
		char cTemp = cTempArray[i];
		cTempArray[i] = cTempArray[j];
		cTempArray[j] = cTemp;
		return new String(cTempArray);
	}
	
	public List<String> getAllPerms(String input){
		List<String> result = new ArrayList<String>();
		if(input==null) {
			return result;
		}
		if(input.length()==1){
			result.add(input);
			return result;
		}
		char cFirst;
		String sTemp ;
		List<String> subResult;
		for(int i=0; i<input.length(); i++) {
			sTemp = swapString(input, 0, i);
			cFirst = sTemp.charAt(0);
			subResult = getAllPerms(sTemp.substring(1));
			for(String str:subResult){
				result.add(cFirst+str);
			}
		}

		return result ;
	}
	
	@Test
	public void testGetAllPerms() {
		System.out.println("---------- TestGetAllPerms ---------");
		for(String str:getAllPerms("abcd")){
			System.out.println(str);
		}
	}
}
