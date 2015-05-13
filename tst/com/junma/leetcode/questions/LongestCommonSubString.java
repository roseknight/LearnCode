package com.junma.leetcode.questions;

import static org.junit.Assert.*;

import org.junit.Test;

public class LongestCommonSubString {

	   public String findLCString(String s1, String s2) {
	        if ((s1==null)||(s1.length()==0)) {
	            return null ;
	        }
	        if ((s2==null)||(s2.length()==0)) {
	            return null ;
	        } 
	        
	        int iLast = -1 ;
	        int iLen = -1 ;
	        int[][] matrix = new int[s1.length()+1][s2.length()+1] ;
	        for(int i=0; i<s1.length(); i++) {
	            for(int j=0; j<s2.length(); j++) {
	                if (s1.charAt(i)==s2.charAt(j)) {
	                    matrix[i+1][j+1] = matrix[i][j] + 1;
	                    if (matrix[i+1][j+1]>iLen) {
	                        iLen = matrix[i+1][j+1] ;
	                        iLast = i ;
	                    }
	                }
	            }
	        }

	        System.out.println(iLast) ;	        
	        System.out.println(iLen) ;
	        return s1.substring(iLast+1-iLen, iLast+1) ;
	    }

	    public String longestPalindrome(String s) {
	        if ((s==null)||(s.length()==0)) {
	            return "" ;
	        }
	        
	        StringBuffer sb = new StringBuffer(s) ;
	        sb = sb.reverse() ;
	        
	        return findLCString(s, sb.toString()) ;
	    }
	    
	    public String findLCSequence(String s1, String s2) {
	        if ((s1==null)||(s1.length()==0)) {
	            return null ;
	        }
	        if ((s2==null)||(s2.length()==0)) {
	            return null ;
	        } 	    	
	        
	        int[][] dp = new int[s1.length()+1][s2.length()+1] ;
	        
	        for(int i=0; i<s1.length(); i++) {
	        	for(int j=0; j<s2.length(); j++) {
	        		if (s1.charAt(i)==s2.charAt(j)) {
	        			dp[i+1][j+1] = dp[i][j] + 1 ;
	        		} else {
	        			dp[i+1][j+1] = Math.max(dp[i+1][j], dp[i][j+1]) ;
	        		}
	        	}
	        }
	        
	        StringBuffer sb = new StringBuffer() ;
	        int x = 0;
	        int y = 0;
	        while ((x<s1.length()) && (y<s2.length())) {
	        	if (s1.charAt(x)==s2.charAt(y)) {
	        		sb.append(s1.charAt(x)) ;
	        		x++ ;
	        		y++ ;
	        	} else {
	        		if (x==(s1.length()-1) && (y<s2.length())) {
	        			y++ ;
	        		} else if (y==(s2.length()-1) && (x<s1.length())) {
	        			x++ ;
	        		} else {
		        		if (dp[x+2][y+1]>dp[x+1][y+2]) {
		        			x++ ;
		        		} else {
		        			y++ ;
		        		}
	        		}
	        	}
	        }
	        
	    	return sb.toString() ;
	    }
	    
	@Test
	public void test() {
		System.out.println(findLCString("abcdcfgg","ggfcdcba")) ;
		System.out.println(longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth")) ;
		System.out.println(findLCSequence("abcbdab", "bfcaba")) ;
	}
	
	

}
