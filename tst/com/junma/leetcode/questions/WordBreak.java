package com.junma.leetcode.questions;
import java.util.Set;
import java.util.HashSet;

public class WordBreak {

    public boolean wordBreak(String s, Set<String> dict) {
        if ((s==null)||(s.length()==0)) {
            return false ;
        }
        
        boolean[] bResult = new boolean[s.length()] ;
        if (dict.contains(s.substring(0,1))) {
        	bResult[0] = true ;
        }
        
        for(int i=1; i<s.length(); i++) {
        	for(int j=i; j<s.length(); j++) {
        		String str = s.substring(i, j+1) ;
        		if(bResult[i-1] && dict.contains(str)) {
        			bResult[j] = true ;
        		}
        	}
        }
        return bResult[bResult.length-1] ;
    }
    
	
    public static void main(String[] args) {
    	WordBreak w = new WordBreak() ;
    	String str = "ab" ;
    	Set<String> set = new HashSet<String>() ;
    	set.add("a") ;
    	set.add("b") ;
    	if (w.wordBreak(str, set)) { 
    		System.out.println("True") ;
    	} else {
    		System.out.println("false") ;
    	}
    }
}

