package com.junma.leetcode.hashtable;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        if ((s == null) || (t == null)) {
            return "";
        }
        if ((s.length() == 0) || (t.length() == 0)) {
            return "";
        }

        // Init the dict
        Map<Character, Integer> dict = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (dict.containsKey(c)) {
                dict.put(c, dict.get(c) + 1);
            } else {
                dict.put(c, 1);
            }
        }

        int count = 0;
        int l = 0;
        int mLen = s.length() + 1;
        int ml = 0;
        char c;

        for (int r = 0; r < s.length(); r++) {
            c = s.charAt(r);
            if (dict.containsKey(c)) {
                dict.put(c, dict.get(c) - 1);
                if (dict.get(c) >= 0) {
                    count++;
                }
                while (count == t.length()) {
                    //find a set. 
                    // process the min
                    int curMinLen = r - l + 1;
                    if (curMinLen < mLen) {
                        mLen = curMinLen;
                        ml = l;
                    }
                    // move l
                    c = s.charAt(l);
                    if (dict.containsKey(c)) {
                        dict.put(c, dict.get(c) + 1);
                        if (dict.get(c) > 0) {
                            count--;
                        }
                    }
                    l++;
                }
            }
        }

        if (mLen > s.length()) {
            return "";
        } else {
            return s.substring(ml, ml + mLen);
        }
    }

    @Test
    public void test() {
        assertEquals("A", minWindow("A", "A"));
        assertEquals("", minWindow("X", "A"));
        assertEquals("AB", minWindow("ABXXXX", "BA"));
        assertEquals("AB", minWindow("XXXXAB", "BA"));
        assertEquals("AXXBXXC", minWindow("XAXXBXXC", "CBA"));
        assertEquals("AXB", minWindow("XXXAXBXXX", "BA"));
        assertEquals("A", minWindow("XXXXAXAAXXX", "A"));
    }

}
