package com.junma.leetcode.array;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;

public class LargestRectangleinHistogram {

    public int largestRectangleArea(int[] height) {
        if ((height==null)||(height.length==0)) {
            return 0;
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for(int i=0; i<height.length; i++) {
            while ((!stack.empty())&&(height[i]<height[stack.peek()])) {
                // find the lower point, start the process
                int leftIndex = stack.pop();
                int curSize = (stack.empty() ? i*height[leftIndex] : (i-stack.peek()-1)*height[leftIndex]);
                if (curSize>max) {
                    max = curSize;
                }
            }
            stack.push(i);
        }
        
        while(!stack.empty()) {
            int leftIndex = stack.pop();
            int curSize = (stack.empty() ? height.length*height[leftIndex] : (height.length-stack.peek()-1)*height[leftIndex]);
            if (curSize>max) {
                max = curSize;
            }           
        }
        
        return max;
    }
    
	@Test
	public void test() {
		int[] input={2,1,5,6,2,3};
		assertEquals(10, largestRectangleArea(input));
		int[] input2={4,2,0,3,2,5};
		assertEquals(6, largestRectangleArea(input2));
	}

}
