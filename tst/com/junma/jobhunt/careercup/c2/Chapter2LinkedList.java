package com.junma.jobhunt.careercup.c2;

import java.util.*;

public class Chapter2LinkedList {

	// Create a list from string "a->b->c"
	public static Node createList(String strList) {
		String[] strArray = strList.split("->");
		Node head=null, previous=null, current=null;
		for(String strCurrent:strArray) {
			current = new Node(Integer.parseInt(strCurrent));
			if (head==null) {
				head = current;
				previous = current;
			} else {
				previous.next = current;
				previous = current;
			}
		}
		return head;
	}
	
	// Print a list split by "->"
	public static String printList(Node head) {
		StringBuffer strB = new StringBuffer();
		Node index = head;
		while(index!=null) {
		  if (strB.length()>0) {
			  strB.append("->");
		  }
		  strB.append(index.val) ;
		  index = index.next;
		}
		return strB.toString();
	}
	
	// remove the duplicated node in a list
	public static Node removeDuplicateNodes(Node head) {
		
		if ((head==null)||(head.next==null)) {
			return head;
		}
		
		Node index = head;
		Node newhead=null, previous=null, current=null;
		Map<Integer, Boolean> map = new Hashtable<Integer, Boolean>();
		while(index!=null) {
			if (!map.containsKey(index.val)) {
				map.put(index.val, true);
				current = index ;
				index = index.next ;
				current.next = null;
				if (newhead==null) {
					newhead = current;
					previous = current;
				} else {
					previous.next = current;
					previous = current;
				}
			} else {
				index = index.next;
			}
		}
		return newhead;
	}
	
	public static Node removeDuplicateNodes2(Node head) {

		if ((head==null)||(head.next==null)) {
			return head;
		}
		
		Node current = head, index=null;
		while(current!=null) {
			index = current;
			while(index.next!=null) {
				if(index.next.val==current.val) {
					index.next = index.next.next;
				} else {
					index = index.next;
				}
			}
			current = current.next;
		}
		return head;
	}
	
	// find the nth node in the list
	public static Node findNthLastNode(Node head, int n) {
		if (head==null) {
			return null;
		}
		
		Node nToLast=head, nIndex=head;
		// Set the patrol;
		for(int i=0;i<n;i++) {
			if(nIndex.next==null) {
				return null;
			} else {
				nIndex = nIndex.next;
			}
		}
		
		while(nIndex.next!=null) {
			nIndex = nIndex.next;
			nToLast = nToLast.next ;
		}
		
		return nToLast;
	}
	
	// delete a node in the middle of the list. Just copy the content of the next node and release the next node
	public static void deleteNodeInTheMiddle(Node nToDelete) {
		if ((nToDelete==null) || (nToDelete.next==null)) {
			return;
		}
		
		nToDelete.val = nToDelete.next.val;
		nToDelete.next = nToDelete.next.next;
	}
	
	// Add two list together
	public static Node addTwoLists(Node list1, Node list2) {
		Node rhead=null, rindex=null;
		Node i1 = list1, i2 = list2;
		
		int iAddOne = 0 ;
		Node nTemp = null;
		int iTemp = 0;
		while((i1!=null) && (i2!=null)) {
			iTemp = i1.val + i2.val + iAddOne ;
			if(iTemp>=10) {
				iTemp = iTemp - 10;
				iAddOne = 1;
			} else {
				iAddOne = 0;
			}
			nTemp = new Node(iTemp);
			if (rhead==null) {
				rhead = nTemp;
				rindex = nTemp;
			} else {
				rindex.next = nTemp;
				rindex = nTemp;
			}
			i1=i1.next;
			i2=i2.next;
		}
		
		if(i1!=null) {
			while(i1!=null) {
				iTemp = i1.val + iAddOne ;
				if(iTemp>=10) {
					iTemp = iTemp - 10;
					iAddOne = 1;
				} else {
					iAddOne = 0;
				}	
				nTemp = new Node(iTemp);
				rindex.next = nTemp;
				rindex = nTemp;		
				i1=i1.next;
			}
		} else if(i2!=null) {
			while(i2!=null) {
				iTemp = i2.val + iAddOne ;
				if(iTemp>=10) {
					iTemp = iTemp - 10;
					iAddOne = 1;
				} else {
					iAddOne = 0;
				}	
				nTemp = new Node(iTemp);
				rindex.next = nTemp;
				rindex = nTemp;	
				i2=i2.next;
			}			
			
		} 
		
		if(iAddOne>0) {
			rindex.next = new Node(1);
		}
		
	    return rhead;
	}
	
	// find a loop start point. find the loop point. set one in the head and move the index along with the head
	public static Node findLoopStart(Node head) {
		if (head==null) {
			return null;
		}
				
		Node index1=head, index2=head;
		while ((index2!=null)&&(index2.next!=null)) {
			index1 = index1.next;
			index2 = index2.next.next;
			if(index1==index2) {
				break;
			}
		}
		
		if ((index2==null)||(index2.next==null)) {
			return null;
		}
		
		index1=head;
		while(index1!=index2) {
			index1 = index1.next;
			index2 = index2.next;
		}
		return index2;
	}

	public static Node reverseLinkedList1(Node head) {
		if (head==null) {
			return null;
		}
		if (head.next==null) {
			return head;
		}
		Node newhead = reverseLinkedList1(head.next);
		Node index = newhead;
		while(index.next!=null) {
			index = index.next;
		}
		head.next = null;
		index.next = head;
		return newhead;
	}

	public static Node reverseLinkedList2(Node head) {
		Node newhead = null;
		Node nodeTemp = null;
		Node nodeToR = head;
		while(nodeToR!=null) {
			nodeTemp = nodeToR.next ;
			nodeToR.next = newhead ;
			newhead = nodeToR ;
			nodeToR = nodeTemp;
		}
		return newhead;
	}
}



class Node {
	int val ;
	Node next;
	
	public Node(int i) {
		val = i;
		next = null;
	}
}
