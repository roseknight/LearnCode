package com.junma.leetcode.array;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Stack;

public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        if ((matrix==null)||(matrix.length==0)||(matrix[0]==null)) {
            return 0;
        }
        
        int max = 0;
        int height[] = new int[matrix[0].length];
        for(int i=0; i<matrix.length; i++) {
            for (int j=0; j<height.length; j++) {
                height[j] = (matrix[i][j]=='0' ? 0 : height[j]+1);
            }
            max = Math.max(max, largestRectangleArea(height));
        }
        return max;
    }
    
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
		
		char[][] input = {
							{'0', '0', '0', '1', '0', '0'}, 
							{'0', '0', '1', '1', '0', '0'},  
							{'0', '0', '1', '1', '0', '0'}, 
							{'0', '0', '1', '1', '0', '1'}, 
							{'1', '0', '1', '1', '1', '1'}, 
							{'1', '1', '1', '1', '1', '1'},
							{'0', '0', '1', '0', '0', '0'} 
						};
		assertEquals(10, this.maximalRectangle(input));
	}

}
