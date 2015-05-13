package com.junma.leetcode.hashtable;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;

class RandomListNode {
	     int label;
	     RandomListNode next, random;
	     RandomListNode(int x) { this.label = x; }
	  };
	 
public class CopyListwithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head==null) {
            return null;
        }
        
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode index1 = head;
        RandomListNode index2 = new RandomListNode(index1.label);
        map.put(index1, index2);
        RandomListNode result = index2;
        
        while(index1.next!=null) {
            index2.next = new RandomListNode(index1.next.label);
            map.put(index1.next, index2.next);
            index1 = index1.next;
            index2 = index2.next;
        }
        
        index1 = head;
        index2 = result;
        while(index1!=null) {
            index2.random = (index1.random==null?null:map.get(index1.random));
            index1 = index1.next;
            index2 = index2.next;
        }
        
        return result;
    }
    
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
