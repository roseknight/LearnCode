package com.junma.leetcode.array;

import static org.junit.Assert.*;

import org.junit.Test;

public class RotateArray {

    public void rotate(int[] nums, int k) {
        if ((nums==null)||(nums.length==0)||(nums.length==1)) {
            return;
        }
        
        k = k % nums.length ;
        if (k==0) {
            return ;
        } else {
            swapItoJ(nums, 0, nums.length-k-1);
            swapItoJ(nums, nums.length-k, nums.length-1);
            swapItoJ(nums, 0, nums.length-1);
        }
        return;
    }
    
    /* swap elements from ith to jth inclusive */
    public void swapItoJ(int[] nums, int i, int j) {
        int temp ;
        while(i<j) {
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
        return;
    }
    
    public void swap(int[] nums, int i, int j){
    	int temp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = temp;
    	return;
    }
    
    public void rotate2(int[] nums, int k) {
        if ((nums==null)||(nums.length==0)||(nums.length==1)) {
            return;
        }
        
        k = k % nums.length ;
        if (k==0) return;
        
        int istart = 0;
        int index = 0;
        for(int i=0; i<nums.length; i++) {
        	index = (index+k)%nums.length ;
        	if (index==istart) {
        		index = index + 1;
        		istart = index;
        		continue;
        	}
        	swap(nums, istart, index);
        }
        
        return;
    }   
    
    public String outputArray(int[] nums) {
    	StringBuilder strB = new StringBuilder();
		for(int i=0; i<nums.length; i++) {
			strB.append(nums[i]+",");
		}
		return strB.toString();
    }
    
	@Test
	public void test() {
		int[] input1 = {1,2,3,4,5,6,7};
		rotate(input1, 3);
		assertEquals("5,6,7,1,2,3,4,", outputArray(input1));
		
		int[] input2 = {1,2,3};
		rotate(input2, 0);
		assertEquals("1,2,3,", outputArray(input2));		
		
		int[] input3 = {1,2,3};
		rotate(input3, 2);
		assertEquals("2,3,1,", outputArray(input3));			
	}

	@Test
	public void test2() {
		int[] input1 = {1,2,3,4,5,6,7};
		rotate2(input1, 3);
		assertEquals("5,6,7,1,2,3,4,", outputArray(input1));
		
		int[] input4 = {1,2,3,4,5,6};
		rotate2(input4, 2);
		assertEquals("5,6,1,2,3,4,", outputArray(input4));
		
		int[] input2 = {1,2,3};
		rotate2(input2, 0);
		assertEquals("1,2,3,", outputArray(input2));		
		
		int[] input3 = {1,2,3};
		rotate2(input3, 2);
		assertEquals("2,3,1,", outputArray(input3));			
	}
}
