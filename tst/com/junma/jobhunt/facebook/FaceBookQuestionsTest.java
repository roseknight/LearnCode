package com.junma.jobhunt.facebook;

import static org.junit.Assert.*;

import org.junit.Test;

public class FaceBookQuestionsTest {

	@Test
	public void testSqrt() {
		assertTrue(FaceBookQuestions.sqrt(2.0)-1.4142<0.0001);
		assertTrue(FaceBookQuestions.sqrt(0.6)-0.7745<0.0001);		
	}

}
