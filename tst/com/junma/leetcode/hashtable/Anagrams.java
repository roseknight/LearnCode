package com.junma.leetcode.hashtable;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.*;

public class Anagrams {
    public List<String> anagrams(String[] strs) {
    	if ((strs==null)||(strs.length==0)) {
    		return null;
    	}
    	
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for(int i=0; i<strs.length; i++) {
            String str = strs[i];
            String key = getKey(str);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> cur = new ArrayList<String>();
                cur.add(str);
                map.put(key, cur);
            }
        }
        
        Collection<List<String>> l = map.values();
        List<String> result = new ArrayList<String>();
        for(List<String> l1: l) {
            if (l1.size()>1) {
                result.addAll(l1);
            }
        }
        
        return result;
    }
    
    public String getKey(String str) {
        if ((str==null)||(str.length()==0)) {
            return "";
        }
        
        int[] map = new int[256];
        Arrays.fill(map, 0);
        
        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            map[c]++;
        }
        
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<256; i++) {
            if (map[i]>0) {
                sb.append((char)i);
                sb.append('-');
                sb.append(map[i]);
            }
        }
        return sb.toString();
    }
    
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
