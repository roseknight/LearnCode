package com.junma.jobhunt.careercup.c3;
import java.util.*;

public class Chapter3StackNQueue {

	// Hanoi Tower
	public static void moveDisks(int n, Stack<Integer> from, Stack<Integer> to, Stack<Integer> buffer) {
		if (n==1) {
			to.push(from.pop());
		} else {
			moveDisks(n-1, from, buffer, to);
			to.push(from.pop());
			moveDisks(n-1, buffer, to, from);
		}		
	}
	
	// Sort numbers with a stack
	public static Stack<Integer> sortStack(Stack<Integer> input) {
		Stack<Integer> result = new Stack<Integer>();
		int iTemp = -1;
		while(!input.isEmpty()) {
			iTemp = input.pop();
			while ((!result.isEmpty())&&(result.peek()>iTemp)) {
				input.push(result.pop());
			}
			result.push(iTemp);
		}
		return result;
	}
}



class StackOnArray {
	
	int[] data ;
	int s1upperb;
	int s3upperb;	
	int s2lowerb, s2upperb;	

	private void copyArray(int from, int to, int length) {
		if (from > to) {
			for(int i=0; i<length; i++) {
				data[to+i] = data[from+i] ;
			}
		} else {
			for(int i=1; i<=length; i++) {
				data[to+length-i] = data[from+length-i] ;
			}			
		}
	}
	
	public StackOnArray(int i) {
		data = new int[i];
		s3upperb=data.length;	
		s1upperb = -1;
		s2lowerb=s1upperb;
		s2upperb=s2lowerb;		
	}
	
	public synchronized int pop1() {
		int val = data[s1upperb] ;
		data[s1upperb] = 0;
		s1upperb--;
		// Move Stack 2 to the left to shrink the space
		copyArray(s2lowerb, s2lowerb-1, s2upperb-s2lowerb+1);
		s2lowerb--;
		s2upperb--;
		
		return val;
	}
	
	public synchronized void push1(int i) {
		if(s2upperb+1<s3upperb) {
			// Move Stack 2 to the right to make space for Stack 1
			if(s2lowerb<s2upperb) {
				copyArray(s2lowerb, s2lowerb+1, s2upperb-s2lowerb+1);
			}
			s2lowerb++;
			s2upperb++;
			// Push the i to Stack 1;
			data[s1upperb+1] = i;
			s1upperb++;
		} else {
			System.out.println("Stack Overflow");
		}
	}
	
	public synchronized int pop2() {
		int val = data[s2upperb] ;
		data[s2upperb] = 0;
		s2upperb--;
		return val;
	}
	
	public synchronized void push2(int i) {
		if(s2upperb+1<s3upperb) {
			//there is still some space
			data[s2upperb+1] = i;
			s2upperb++;
		} else {
			System.out.println("Stack Overflow");
		}
	}
	
	public synchronized int pop3() {
		int val = data[s3upperb] ;
		data[s3upperb] = 0;
		s3upperb++;
		return val;
	}
	
	public synchronized void push3(int i) {
		if(s3upperb-1>s2upperb) {
			// There is still some space
			data[s3upperb-1] = i;
			s3upperb--;
		} else {
			System.out.println("Stack Overflow");
		}
	}	
	
	public synchronized int[] outputStacks() {
		return data;
	}
}

// wrong implemenation. If the min value is poped, the min is not well maintied. 
// for each push value, maintain its previous min value
class MinStack {
	private int min = 9999999;
	private Stack<Integer> data = new Stack<Integer>();
	
	public int pop() {
		return data.pop().intValue();
	}
	
	public void push(int i) {
		data.push(i);
		if (i<min) {
			min = i;
		}
	}
	
	public int min() {
		return min;
	}
}

// Use stacks to implement a queue. 
class QueueOnStack {
	Stack<Integer> s1 = new Stack<Integer>();
	Stack<Integer> s2 = new Stack<Integer>();
	
	public int dequeue() {
		return s1.pop();
	}
	
	public void enqueue(int i) {
		while(!s1.isEmpty()) {
			s2.push(s1.pop());
		}
		s1.push(i);
		while(!s2.isEmpty()) {
			s1.push(s2.pop());
		}
	}
}