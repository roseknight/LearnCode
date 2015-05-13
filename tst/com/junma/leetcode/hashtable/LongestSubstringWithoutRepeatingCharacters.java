package com.junma.leetcode.hashtable;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;

import org.junit.Test;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if ((s==null)||(s.length()==0)) {
            return 0;
        }
        
        int[] map = new int[256];
        Arrays.fill(map, -1);
        int iMax = 0;
        int iStart = 0;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (map[c]>=iStart) {
                iMax = Math.max(iMax, i-iStart);
                iStart = map[c] + 1;
            }
            map[c] = i;
        }
        return Math.max(iMax, s.length()-iStart);
    }
    
	@Test
	public void test() {
		assertEquals(3, this.lengthOfLongestSubstring("abcabcbb"));
		assertEquals(1, this.lengthOfLongestSubstring("aaaaa"));	
		assertEquals(3, this.lengthOfLongestSubstring("abc"));
		assertEquals(1, this.lengthOfLongestSubstring("a"));		
		assertEquals(4, this.lengthOfLongestSubstring("abcaadaabcd"));		
		
	}

}
