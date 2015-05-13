package com.junma.jobhunt.careercup.c1;

import java.util.*;

import javax.naming.spi.DirStateFactory.Result;

public class Chapter1ArrayNString {

	// Check the unique chars with Map O(N) but space O(26)
	public static boolean checkStringHasAllUniqueChars1(String input) {
		if ((input==null) || input.equals("")) {
			return true;
		}
		Map<Character,Integer> map1 = new Hashtable<Character, Integer>();
		char cCurrent ;
		for(int i=0; i<input.length(); i++) {
			cCurrent = input.charAt(i);
			if(map1.containsKey(cCurrent)) {
				return false;
			} else {
				map1.put(cCurrent, 1);
			}
		}
		return true;
	}
	
	// Check the unique char with two loops O(N*N)
	public static boolean checkStringHasAllUniqueChars2(String input) {
		if ((input==null) || input.equals("")) {
			return true;
		}
		
		char cCurrent;
		for(int i=0; i<input.length(); i++) {
			cCurrent = input.charAt(i) ;
			for(int j=i+1; j<input.length(); j++) {
				if (cCurrent==input.charAt(j)) {
					return false;
				}
			}
		}	
		return true;
	}	
	
	// Reverse String with recursive method
	public static String reverseString(String input) {
		if (input==null) {
			return null;
		}
		if (input.length()<=1) {
			return input;
		} else if (input.length()==2) {
			char[] cTemp = input.toCharArray();
			char c1 = cTemp[0] ;
			cTemp[0] = cTemp[1];
			cTemp[1] = c1;
			return new String(cTemp);
		} else {
			return reverseString(input.substring(1)) + input.charAt(0) ;
		}
	}

	// reverse the string with iterative method
	public static String reverseString2(String input) {
		if (input==null) {
			return null;
		}
		if (input.length()<=1) {
			return input;
		} else {
			char[] cTemp = input.toCharArray();
			int i=0, j=input.length()-1;
			char c1;
			while(i<j) {
				c1 = cTemp[i] ;
				cTemp[i] = cTemp[j];
				cTemp[j] = c1;
				i++;
				j--;
			}
			return new String(cTemp);
		} 
	}
	
	// remove duplicated chars with double loops O(N*N)
	public static String removeDuplicateCharFromString(String input) {
		if (input==null) {
			return null;
		}
		if (input.length()<=1) {
			return input;
		}
		char[] cTemp = input.toCharArray();
		char c1;
		StringBuffer strB = new StringBuffer();
		for(int i=0; i<cTemp.length; i++) {
			c1 = cTemp[i] ;
			if (c1 != '^') {
				strB.append(c1) ;
				for(int j=i+1; j<cTemp.length; j++) {
					if (cTemp[j]==c1) {
						cTemp[j] = '^';
					}
				}
			}
		}
		return strB.toString();
	}

	// Check whether two strings are anagram. encode them first, then compare
	// big space O for this way
	public static String codeStringAnagram(String str1) {
		if (str1==null) {
			return "null";
		}
		if (str1.length()==0) {
			return "";
		}
		int[] map = new int[26];
		char c1;
		for(int i=0; i<str1.length(); i++) {
			c1 = str1.charAt(i) ;
			map[c1-'a']++;
		}
		StringBuffer strB = new StringBuffer();
		for(int i:map) {
			strB.append(i);
			strB.append('-');
		}
		return strB.toString();
	}
	
	public static boolean checkStringAnagrams(String str1, String str2) {
		return codeStringAnagram(str1).equals(codeStringAnagram(str2));
	}
	
	public static String replaceSpaceFor20(String input) {
		if (input==null) {
			return null;
		}
		
		StringBuffer strB = new StringBuffer();
		char cTemp[] = input.toCharArray();
		for(char c1:cTemp) {
			if (c1==' ') {
				strB.append("%20");
			} else {
				strB.append(c1);
			}
		}
		return strB.toString();
	}
	
	// rotate a matrix. up->down; left->right
	public static int[][] rotateImage(int[][] image) {
		int iRow = image.length;
		int iCol = image[0].length;
		int iTemp ;
		for(int i=0; i<iRow; i++) {
			for(int j=i+1; j<iCol; j++) {
				iTemp = image[i][j] ;
				image[i][j] = image[j][i];
				image[j][i] = iTemp;
			}
		}

		for(int j=0; j<iCol; j++) {
			for(int i=0; i<=iRow/2; i++) {
				iTemp = image[i][j] ;
				image[i][j] = image[iRow-i-1][j];
				image[iRow-i-1][j] = iTemp;
			}
		}		
		
		return image;
	}
	
	public static int[][] clearMatrix(int[][] input) {
		int iRow = input.length;
		int iCol = input[0].length;
		
		int[] aRow = new int[iRow];
		int[] aCol = new int[iCol];
		
		for(int i=0; i<iRow; i++) {
			for(int j=0; j<iCol; j++) {
				if (input[i][j]==0) {
					aRow[i] = 1;
					aCol[j] = 1;
				}
			}
		}
		
		for(int i=0; i<iRow; i++) {
			if(aRow[i]==1) {
				for(int j=0; j<iCol; j++) {
					input[i][j] = 0;
				}
			}
		}

		for(int j=0; j<iCol; j++) {
			if(aCol[j]==1) {
				for(int i=0; i<iRow; i++) {
					input[i][j] = 0;
				}
			}
		}
		
		return input;
	}
	
	// check whether string a is a rotation of string b. a+a.contains(b) and b+b.contains(a)
	public static boolean checkStringRotation(String str1, String str2) {
		return ((str1+str1).indexOf(str2)>=0) && ((str2+str2).indexOf(str1)>=0) ;
	}
	
	public static char[] reverseCharArray(char[] input, int iStart, int iEnd) {
		if (input==null) {
			return null;
		}
		if ((iEnd-iStart)<1) {
			return input ;
		} else {
			char[] cTemp = input;
			char c1;
			while(iStart<iEnd) {
				c1 = cTemp[iStart] ;
				cTemp[iStart] = cTemp[iEnd];
				cTemp[iEnd] = c1;
				iStart++;
				iEnd--;
			}
			return cTemp;
		} 
	}
	
	public static String rotateString(String str1, int k) {
		if (str1==null) {
			return null;
		}
		if (k<0) {
			k = (str1.length() - k) % str1.length();
		} else if (k>0) {
			k = k % str1.length();
		}
		if (k==0) {
			return str1;
		} 
		int iEnd = str1.length()-1;
		char[] result = reverseCharArray(str1.toCharArray(), 0, iEnd);
		result = reverseCharArray(result, 0, iEnd-k);
		result = reverseCharArray(result, iEnd-k+1, iEnd);
		return new String(result);
	}
	
	public static String trimString(String input) {
		if (input==null) {
			return null;
		}
		if (input.length()==0) {
			return input;
		}
		StringBuffer strB = new StringBuffer();
		char cTemp ;
		for(int i=0; i<input.length(); i++) {
			cTemp = input.charAt(i);
			if (cTemp!=' ') {
				strB.append(cTemp);
			}
		}
		return strB.toString();
	}
}
