package com.junma.jobhunt.facebook.careercup;

import java.util.*;

public class FacebookQuestions1 {

	/* Question 1
	 * Given - a number (n) and a sorted array 
	 * Find a number in the array having least difference with the given number (n).
	 * Hint: Use the normal binary search, when there are only two elements, try to find 
	 * which is the closest one. 
	 */	
	public static int findTheClosetInSortedArray(int[] input, int n) {
		int iLeft = 0;
		int iRight = input.length-1;
		int iIndex = 0;
		while(iLeft<iRight-1) {
			iIndex = (iLeft+iRight)/2 ;
			if(input[iIndex]==n) {
				return n;
			} else if (input[iIndex]<n) {
				iLeft = iIndex ;
			} else {
				iRight = iIndex ;
			}
		}
		if ((input[iRight]-n)>(n-input[iLeft])) {
			return input[iLeft];
		} else {
			return input[iRight];
		}
	}
	
	/* Question 2
	 * Pattern Matching 
---------------- 
Characters: a to z 
Operators: * + 
* -> matches zero or more (of the character that occurs previous to this operator) 
+ -> matches one or more (of the character that occurs previous to this operator) 

Output if a given pattern matches a string. 
Example: 
pattern:a*b 
string:aaab b, ab, aab, aaab, ab 
output:1
 	* 
 	*
	*/
	
	/* Question 3
	 * If a=1, b=2, c=3,....z=26. Given a string, find all possible codes that string can generate. Give a count as well as print the strings. 

For example: 
Input: "1123". You need to general all valid alphabet codes from this string. 

Output List 
aabc //a = 1, a = 1, b = 2, c = 3 
kbc // since k is 11, b = 2, c= 3 
alc // a = 1, l = 12, c = 3 
aaw // a= 1, a =1, w= 23 
kw // k = 11, w = 23
	* Hint, Use the recursive way, divide the string by prefix 1 char or 2 chars
	* Be very careful about the 3 edge/base cases (0 char, 1 char, 2 chars)
	*/
	public static String mapStrInt2String(String strInt) {
		int iChar = Integer.parseInt(strInt) ;
		if ((iChar<1)||(iChar>26)) {
			return null;
		} else {
			char cTemp = (char) ('a' + iChar - 1);
			String strTemp = new String();
			return strTemp+cTemp;
		}
	}
	
	public static List<String> convertNumToStrings(String strInput) {
		List<String> result = new ArrayList<String>();
		List<String> subResult ;
		String prefix = null;
		
		if (strInput.length()==0) {
			return result; 
		} else if (strInput.length()==1) {
			result.add(mapStrInt2String(strInput));
			return result;
		} else if (strInput.length()==2) {
			result.add(mapStrInt2String(strInput.substring(0,1)) + mapStrInt2String(strInput.substring(1)));
			prefix = mapStrInt2String(strInput);
			if(prefix!=null){
				result.add(prefix);
			}
			return result;
		}
		
		prefix = mapStrInt2String(strInput.substring(0,1));
		subResult = convertNumToStrings(strInput.substring(1));
		for(String str:subResult) {
			result.add(prefix + str);
		}
		
		prefix = mapStrInt2String(strInput.substring(0,2));
		if (prefix!=null) {
			subResult = convertNumToStrings(strInput.substring(2));
			for(String str:subResult) {
				result.add(prefix + str);
			}			
		}
		return result;
	}
	
	/* Question 4
	 * You are given an array of 1's 2's and 3's. Sort this list so the 1's are first, the 2's come second, and the 3's come third. 

Ex: Input [1, 3, 3, 2, 1] 
Output [1, 1, 2, 3, 3] 
	 * Hint: find the first non 1 on the left, then find the first 1 from there, swap 
	 */
	public static int[] sort123(int[] input){
		return null;
	}
}


