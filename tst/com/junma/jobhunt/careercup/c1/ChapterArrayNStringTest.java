/**
 * 
 */
package com.junma.jobhunt.careercup.c1;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author junma
 *
 */
public class ChapterArrayNStringTest {

	/**
	 * Test method for {@link com.junma.jobhunt.careercup.c1.Chapter1ArrayNString#checkStringHasAllUniqueChars1(java.lang.String)}.
	 */
	@Test
	public void testCheckStringHasAllUniqueChars1() {
		assertTrue(Chapter1ArrayNString.checkStringHasAllUniqueChars1("abc"));
		assertFalse(Chapter1ArrayNString.checkStringHasAllUniqueChars1("aba"));		
		assertTrue(Chapter1ArrayNString.checkStringHasAllUniqueChars1("a"));
		assertTrue(Chapter1ArrayNString.checkStringHasAllUniqueChars1(""));
		assertTrue(Chapter1ArrayNString.checkStringHasAllUniqueChars1(null));		
	}

	/**
	 * Test method for {@link com.junma.jobhunt.careercup.c1.Chapter1ArrayNString#checkStringHasAllUniqueChars1(java.lang.String)}.
	 */
	@Test
	public void testCheckStringHasAllUniqueChars2() {
		assertTrue(Chapter1ArrayNString.checkStringHasAllUniqueChars2("abc"));
		assertFalse(Chapter1ArrayNString.checkStringHasAllUniqueChars2("aba"));		
		assertTrue(Chapter1ArrayNString.checkStringHasAllUniqueChars2("a"));
		assertTrue(Chapter1ArrayNString.checkStringHasAllUniqueChars2(""));
		assertTrue(Chapter1ArrayNString.checkStringHasAllUniqueChars2(null));		
	}	
	
	/**
	 * Test method for {@link com.junma.jobhunt.careercup.c1.Chapter1ArrayNString#reverseString(java.lang.String)}.
	 */
	@Test
	public void testReverseString() {
		assertEquals(Chapter1ArrayNString.reverseString("abcde"), "edcba") ;
		assertEquals(Chapter1ArrayNString.reverseString(""), "") ;
		assertEquals(Chapter1ArrayNString.reverseString("b"), "b") ;	
		assertEquals(Chapter1ArrayNString.reverseString(null), null) ;		
	}

	/**
	 * Test method for {@link com.junma.jobhunt.careercup.c1.Chapter1ArrayNString#reverseString(java.lang.String)}.
	 */
	@Test
	public void testReverseString2() {
		assertEquals(Chapter1ArrayNString.reverseString2("abcde"), "edcba") ;
		assertEquals(Chapter1ArrayNString.reverseString2(""), "") ;
		assertEquals(Chapter1ArrayNString.reverseString2("b"), "b") ;	
		assertEquals(Chapter1ArrayNString.reverseString2("ab"), "ba") ;			
		assertEquals(Chapter1ArrayNString.reverseString2(null), null) ;		
	}

	/**
	 * Test method for {@link com.junma.jobhunt.careercup.c1.Chapter1ArrayNString#removeDuplicateCharFromString(java.lang.String)}.
	 */
	@Test
	public void testRemoveDuplicateCharFromString() {
		assertEquals(Chapter1ArrayNString.removeDuplicateCharFromString("abcdbce"),"abcde");
		assertEquals(Chapter1ArrayNString.removeDuplicateCharFromString("aabcdbce"),"abcde");
		assertEquals(Chapter1ArrayNString.removeDuplicateCharFromString("abcdbcee"),"abcde");
		assertEquals(Chapter1ArrayNString.removeDuplicateCharFromString("aaaaa"),"a");
		assertEquals(Chapter1ArrayNString.removeDuplicateCharFromString("a"),"a");
		assertEquals(Chapter1ArrayNString.removeDuplicateCharFromString(""),"");
		assertEquals(Chapter1ArrayNString.removeDuplicateCharFromString(null),null);		
	}

	/**
	 * Test method for {@link com.junma.jobhunt.careercup.c1.Chapter1ArrayNString#checkStringAnagrams(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testCheckStringAnagrams() {
		assertTrue(Chapter1ArrayNString.checkStringAnagrams("bcd", "dcb"));
		assertTrue(Chapter1ArrayNString.checkStringAnagrams("bacdcb", "bbaccd"));
		assertTrue(Chapter1ArrayNString.checkStringAnagrams("b", "b"));	
		assertTrue(Chapter1ArrayNString.checkStringAnagrams("", ""));
		assertTrue(Chapter1ArrayNString.checkStringAnagrams("b", "b"));	
		assertTrue(Chapter1ArrayNString.checkStringAnagrams(null, null));			
	}

	/**
	 * Test method for {@link com.junma.jobhunt.careercup.c1.Chapter1ArrayNString#replaceSpaceFor20(java.lang.String)}.
	 */
	@Test
	public void testReplaceSpaceFor20() {
		assertEquals(Chapter1ArrayNString.replaceSpaceFor20("a bb ccc "), "a%20bb%20ccc%20");		
		assertEquals(Chapter1ArrayNString.replaceSpaceFor20("bb "), "bb%20");		
		assertEquals(Chapter1ArrayNString.replaceSpaceFor20(" aa"), "%20aa");
		assertEquals(Chapter1ArrayNString.replaceSpaceFor20(" "), "%20");		
		assertEquals(Chapter1ArrayNString.replaceSpaceFor20(""), "");
		assertEquals(Chapter1ArrayNString.replaceSpaceFor20(null), null);		
	}

	/**
	 * Test method for {@link com.junma.jobhunt.careercup.c1.Chapter1ArrayNString#rotateImage(byte[][])}.
	 */
	@Test
	public void testRotateImage() {
		int[][] input = {{1, 2, 3},
						 {4, 5, 6},
						 {7, 8, 9}};

		int[][] output = {{3, 6, 9},
		  		   		  {2, 5, 8},
		  		   		  {1, 4, 7}};

		assertEquals(Chapter1ArrayNString.rotateImage(input), output);
	}

	/**
	 * Test method for {@link com.junma.jobhunt.careercup.c1.Chapter1ArrayNString#clearMatrix(int[][])}.
	 */
	@Test
	public void testClearMatrix() {
		int[][] input = {{0, 1, 1},
						 {1, 1, 1},
						 {1, 1, 0}};
						 
		int[][] output = {{0, 0, 0},
				 		  {0, 1, 0},
				 		  {0, 0, 0}};	

		int[][] input2 = {{0, 1, 1},
				 		  {1, 1, 1},
				 		  {0, 1, 0}};
		

		int[][] input3 = {{0, 1, 1},
		 		  		  {0, 1, 1},
		 		  		  {1, 1, 0}};

		int[][] output2 = {{0, 0, 0},
		 		  		   {0, 0, 0},
		 		  		   {0, 0, 0}};
		
		assertEquals(Chapter1ArrayNString.clearMatrix(input), output);
		assertEquals(Chapter1ArrayNString.clearMatrix(input2), output);		
		assertEquals(Chapter1ArrayNString.clearMatrix(input3), output2);
	}

	/**
	 * Test method for {@link com.junma.jobhunt.careercup.c1.Chapter1ArrayNString#checkStringRotation(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testCheckStringRotation() {
		assertTrue(Chapter1ArrayNString.checkStringRotation("waterbottle", "erbottlewat"));
		assertTrue(Chapter1ArrayNString.checkStringRotation("waterbottle", "waterbottle"));
		assertTrue(Chapter1ArrayNString.checkStringRotation("", ""));		
		assertTrue(Chapter1ArrayNString.checkStringRotation(" ", " "));	
		assertFalse(Chapter1ArrayNString.checkStringRotation("waterbottle", "rebottlewat"));		
	}

	@Test
	public void testRotateString() {
		assertEquals(Chapter1ArrayNString.rotateString("abcdefg", 0), "abcdefg");
		assertEquals(Chapter1ArrayNString.rotateString("abcdefg", 1), "bcdefga");
		assertEquals(Chapter1ArrayNString.rotateString("abcdefg", 3), "defgabc");
		assertEquals(Chapter1ArrayNString.rotateString("abcdefg", 7), "abcdefg");	
		assertEquals(Chapter1ArrayNString.rotateString("abcdefg", 8), "bcdefga");		
		assertEquals(Chapter1ArrayNString.rotateString(null, 1), null);	
		assertEquals(Chapter1ArrayNString.rotateString("a", 1), "a");
		assertEquals(Chapter1ArrayNString.rotateString("a", 2), "a");
		assertEquals(Chapter1ArrayNString.rotateString("ab", 1), "ba");		
		assertEquals(Chapter1ArrayNString.rotateString("ab", 2), "ab");
		assertEquals(Chapter1ArrayNString.rotateString("ab", 3), "ba");			
	}
	
	@Test
	public void testTrimString() {
		assertEquals(Chapter1ArrayNString.trimString("ab cd  ef   g"), "abcdefg");
		assertEquals(Chapter1ArrayNString.trimString("  ab cd  "), "abcd");		
		assertEquals(Chapter1ArrayNString.trimString("abcdefg"), "abcdefg");	
		assertEquals(Chapter1ArrayNString.trimString("    "), "");	
		assertEquals(Chapter1ArrayNString.trimString(""), "");
		assertEquals(Chapter1ArrayNString.trimString(null), null);			
	}
}
