package com.junma.jobhunt.careercup.c8;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;

public class Chapter8RecursionTest {
	public int getFibo(int n) {
		if (n<=2) {
			return n;
		}
		return getFibo(n-1) + getFibo(n-2) ;
	}
	
	// Question 8.3
	public List<List<Character>> getAllSubSets(List<Character> input, int index) {
		List<List<Character>> result = new ArrayList<List<Character>>();
		if (index==input.size()) {
			return result;
		}
		Character firstChar = input.get(index);
		List<List<Character>> temp = getAllSubSets(input, index+1);
		List<Character> subset = null;
		subset = new ArrayList<Character>();
		subset.add(firstChar);
		result.add(subset);
		result.addAll(temp);
		for(List<Character> subset2:temp) {
			subset = new ArrayList<Character>();
			subset.add(firstChar);
			subset.addAll(subset2);
			result.add(subset);
		}
		return result;
	}
	
	public List<String> getAllSubSets2(String input) {
		List<String> result = new ArrayList<String>();
		if(input.length()==0) {
			return result;
		}
		if(input.length()==1) {
			result.add(input);
			return result;
		}
		
		List<String> temp = getAllSubSets2(input.substring(1));
		result.addAll(temp);
		result.add(input.substring(0,1));		
		for(String str:temp) {
			result.add(input.substring(0,1)+str);
		}
		return result;
	}
	
	
	// Question 8.4
	public List<String> getPerms(String input) {
		List<String> result = new ArrayList<String>();
		if(input.length()==0) {
			return result;
		}
		if(input.length()==1) {
			result.add(input);
			return result;
		}

		List<String> temp ;
		temp = getPerms(input.substring(1));
		for(String sindex:temp) {
			result.add(input.charAt(0) + sindex);
			for(int i=1; i<sindex.length(); i++) {
				result.add(sindex.substring(0,i) + input.charAt(0) + sindex.substring(i));
			}
			result.add(sindex + input.charAt(0));			
		}			

		return result;
	}
	
	// Question 8.5
	public List<String> getParentheses(int npair) {
		List<String> result = new ArrayList<String>();
		if(npair==1) {
			result.add("()");
			return result;
		}
		if(npair==2){
			result.add("()()");
			result.add("(())");
			return result;
		}
		List<String> temp = getParentheses(npair-1);
		result.add("()"+temp.get(0));
		String str=null;
		for(int i=1; i<temp.size(); i++) {
			str=temp.get(i);
			result.add("()"+str);
			result.add(str+"()");
			result.add("("+str+")");
		}
		return result;
	}
	
	public int getWaysForCents(int nCent, int denom) {
		int next_denom = 0;
		if(denom==25) next_denom=10;
		if(denom==10) next_denom=5;
		if(denom==5) next_denom=1;	
		if(denom==1) return 1;			
		int iWays = 0;
		for(int i=0; i*denom<=nCent; i++) {
			iWays = iWays + getWaysForCents(nCent-i*denom, next_denom);
		}
		return iWays;
	}
	
	public int iSum = 0;
	int[] colInRows = new int[8];
	
	boolean check(int iRow) {
		for(int i=0; i<iRow; i++) {
			int diff = Math.abs(colInRows[i] - colInRows[iRow]);
			if(diff==0||diff==iRow-1) return false;
		}
		return true;
	}
	
	void placeQueen(int iRow) {
		if (iRow==8) {
			iSum++;
			return ;
		}
		for(int i=0; i<8; i++) {
			colInRows[iRow] = i;
			if(check(iRow))
			{
				placeQueen(iRow+1);
			}
		}
	}
	
	
	public int getNthUglyNum(int n){
		LinkedList<Integer> l2 = new LinkedList<Integer>();
		LinkedList<Integer> l3 = new LinkedList<Integer>();
		LinkedList<Integer> l5 = new LinkedList<Integer>();	
		if (n==0) {return 0;}
		l2.add(2);
		l3.add(3);
		l5.add(5);
		int iIndex = 1;
		int iCurrent = -1;
		while(iIndex<=n){
			if ((l2.getFirst()<l3.getFirst())&&(l2.getFirst()<l5.getFirst())){
				iCurrent = l2.removeFirst();
			} else if ((l3.getFirst()<l2.getFirst())&&(l3.getFirst()<l5.getFirst())){
				iCurrent = l3.removeFirst();
			} else {
				iCurrent = l5.removeFirst();
			}

			l2.add(iCurrent*2);
			l3.add(iCurrent*3);
			l5.add(iCurrent*5);	
			iIndex++;
		}
		return iCurrent ;
	}
	
	@Test
	// 8.1
	public void testGetFibo() {
		assertEquals(getFibo(1), 1);
		assertEquals(getFibo(2), 2);
		assertEquals(getFibo(3), 3);
		assertEquals(getFibo(5), 8);		
	}

	@Test
	// 8.3
	public void testGetAllSubsets() {
		List<Character> input = new ArrayList<Character>();
		input.add('a');
		input.add('b');
		input.add('c');
		List<List<Character>> result = getAllSubSets(input, 0);
		Iterator<List<Character>> it = result.iterator();
		List<Character> test = null;
		while(it.hasNext()) {
			test = it.next();
			System.out.println(test);
		}
		System.out.println("-------------");
	}

	@Test
	//8.3
	public void testGetAllSubsets2() {
		System.out.println("----- All Subsets2 for abc --------");			
		String str = "abc";
		List<String> result = getAllSubSets2(str);
		for(String s:result) {
			System.out.println(s);
		}
		System.out.println("-------------");		
	}
	
	@Test
	//8.4
	public void testGetAllPerms() {
		System.out.println("----- All Perms for abc --------");			
		String str = "abc";
		List<String> result = getPerms(str);
		for(String s:result) {
			System.out.println(s);
		}
		System.out.println("-------------");		
	}
	
	@Test
	//8.5
	public void testGetAllParentheses() {
		List<String> result = getParentheses(5);
		for(String s:result) {
			System.out.println(s);
		}
		System.out.println("-------------");		
	}	
	
	@Test
	//8.6
	public void testGetWaysForCents() {
		assertEquals(getWaysForCents(5, 5),2);	
		assertEquals(getWaysForCents(25, 25),13);		
	}	
	
	@Test
	//8.7
	public void testGet8Queens() {
		placeQueen(0);
		assertEquals(iSum, 352);
	}
	
	@Test
	public void testNthUglyNumber() {
		assertEquals(getNthUglyNum(1),2);
		assertEquals(getNthUglyNum(2),3);
		assertEquals(getNthUglyNum(3),4);
		assertEquals(getNthUglyNum(4),5);
		assertEquals(getNthUglyNum(5),6);
		assertEquals(getNthUglyNum(6),8);		
		assertEquals(getNthUglyNum(7),10);
		assertEquals(getNthUglyNum(1000),51200000);		
	}
}
