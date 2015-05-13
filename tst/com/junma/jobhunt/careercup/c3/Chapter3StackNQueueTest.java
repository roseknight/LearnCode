package com.junma.jobhunt.careercup.c3;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;

public class Chapter3StackNQueueTest {

	@Test
	public void testStackOnArray() {
		StackOnArray s=new StackOnArray(10);
		s.push1(1);
		s.push2(1);
		s.push3(1);
		assertArrayEquals(s.outputStacks(), new int[]{1,1,0,0,0,0,0,0,0,1});
		s.push1(2);
		s.push2(2);
		s.push3(2);
		assertArrayEquals(s.outputStacks(), new int[]{1,2,1,2,0,0,0,0,2,1});
		s.push1(3);
		s.push2(3);
		s.push3(3);
		assertArrayEquals(s.outputStacks(), new int[]{1,2,3,1,2,3,0,3,2,1});
		s.push2(4);		
		assertArrayEquals(s.outputStacks(), new int[]{1,2,3,1,2,3,4,3,2,1});	
		s.pop2();
		assertArrayEquals(s.outputStacks(), new int[]{1,2,3,1,2,3,0,3,2,1});
		s.push3(4);
		assertArrayEquals(s.outputStacks(), new int[]{1,2,3,1,2,3,4,3,2,1});
		s.pop3();
		assertArrayEquals(s.outputStacks(), new int[]{1,2,3,1,2,3,0,3,2,1});
		s.push1(4);
		assertArrayEquals(s.outputStacks(), new int[]{1,2,3,4,1,2,3,3,2,1});	
		s.push1(5);
		s.push2(5);
		s.push3(5);		
	}

	@Test
	public void testMinStack() {
		MinStack s = new MinStack();
		s.push(5);
		s.push(2);
		s.push(4);
		assertEquals(s.min(),2);
	}
	
	@Test
	public void testHanoiTower() {
		Stack<Integer> from = new Stack<Integer>();
		Stack<Integer> to = new Stack<Integer>();	
		Stack<Integer> buffer = new Stack<Integer>();	
		from.push(4);
		from.push(3);
		from.push(2);
		from.push(1);
		System.out.println(from.toString());		
		Chapter3StackNQueue.moveDisks(4, from, to, buffer);
		System.out.println(from.toString());
		System.out.println(buffer.toString());		
		System.out.println(to.toString());
	}
	
	@Test
	public void testQueueOnStack() {
		QueueOnStack q = new QueueOnStack();
		q.enqueue(1);
		assertEquals(q.dequeue(), 1);
		
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		assertEquals(q.dequeue(), 1);
		assertEquals(q.dequeue(), 2);	
		assertEquals(q.dequeue(), 3);
		
		q.enqueue(1);
		q.enqueue(2);
		assertEquals(q.dequeue(), 1);	
		q.enqueue(3);
		assertEquals(q.dequeue(), 2);	
		assertEquals(q.dequeue(), 3);		
	}
	
	@Test
	public void testSortStack() {
		Stack<Integer> input = new Stack<Integer>();
		input.push(5);
		input.push(1);
		input.push(3);
		input.push(4);
		Stack<Integer> output = Chapter3StackNQueue.sortStack(input);
		System.out.println(output.toString());
	}
}
