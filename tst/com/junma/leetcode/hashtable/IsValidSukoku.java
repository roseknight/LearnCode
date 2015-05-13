package com.junma.leetcode.hashtable;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;

public class IsValidSukoku {

    public boolean isValidSudoku(char[][] board) {
        if ((board==null) || (board.length==0) || (board[0].length==0)) {
            return false;
        }
        
        // verify row
        for(int i=0; i<board.length; i++) {
            if (!isValidData(board[0])) {
                return false;
            }
        }
        
        // verify col
        for(int i=0; i<board[0].length; i++) {
            char[] data = new char[board.length];
            for(int j=0; j<board.length; j++) {
                data[j] = board[j][i];
            }
            if (!isValidData(data)) {
                return false;
            }
        }        
        
        // verify the grid
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                char[] data = getGrid(board, i*3, j*3);
                if (!isValidData(data)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public char[] getGrid(char[][] data, int x, int y) {
        char[] result = new char[9] ;
        int k = 0;
        for(int i=x; i<x+3; i++) {
            for(int j=y; j<y+3; j++) {
                result[k] = data[i][j];
                k++;
            }
        }
        return result;
    }
    
    public boolean isValidData(char[] data) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c:data) {
            if (c!='.'){
                if (map.containsKey(c)) {
                    return false;
                } else {
                    map.put(c, 1);
                }
            }
        }
        return true;
    }
    
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
