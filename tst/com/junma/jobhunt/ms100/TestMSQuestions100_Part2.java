package com.junma.jobhunt.ms100;
import static org.junit.Assert.*;
import org.junit.*;

public class TestMSQuestions100_Part2 {
	@Test
	public void testMergeList() {
		Node head1 = MSQuestions100_Part2.createList("1->2->3");
		Node head2 = MSQuestions100_Part2.createList("2->3->5");
		assertEquals(MSQuestions100_Part2.mergeList(head1, head2), "1->2->3->5");
	}

	@Test
	public void testCreateBracketsComb() {
		String[] result = MSQuestions100_Part2.createBracketsComb(4);
		System.out.println("Total Num: " + result.length);
		for(String str : result) {
			System.out.println(str);
		}
	}
	
	@Test
	public void testSearchRotatedArray() {
		int[] input = new int[] {4,3,2,1,6,5};
		assertEquals(MSQuestions100_Part2.searchRotatedArray(input, 0, 5, 1), 3);
		System.out.println("--------------");
		assertEquals(MSQuestions100_Part2.searchRotatedArray(input, 0, 5, 6), 4);
		System.out.println("--------------");		
		assertEquals(MSQuestions100_Part2.searchRotatedArray(input, 0, 5, 8), -1);		
	}
}
