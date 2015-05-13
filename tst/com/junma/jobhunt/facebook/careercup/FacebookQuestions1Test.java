package com.junma.jobhunt.facebook.careercup;

import static org.junit.Assert.*;

import org.junit.Test;

public class FacebookQuestions1Test {

	@Test
	public void testFindTheClosetInSortedArray() {
		assertEquals(FacebookQuestions1.findTheClosetInSortedArray(new int[]{1,3,5,8,9}, 6), 5);
	}

	@Test
	public void testConvertNumToStrings() {
		for(String str:FacebookQuestions1.convertNumToStrings("1123")) {
			System.out.println(str);
		}
	}
}
