package Nowcoder;

public class _合并两个有序链表 {
	public static void main(String[] args) {
//		ListNode1 node1= new ListNode1(2);
//		ListNode1 node2= new ListNode1(3);
//		ListNode1 node3= new ListNode1(4);
//		ListNode1 node4= new ListNode1(5);
//		node1.next=node2;
//		node2.next=node3;
//		node3.next=node4;
//		Solution单链表 solution = new Solution单链表();
//		ListNode1 answerListNode1=solution.ReverseList(node1);
//		while(answerListNode1!=null) {
//			System.out.println(answerListNode1.val);
//			answerListNode1=answerListNode1.next;
//		}

	}

}

class ListNode1 {
	int val;
	ListNode1 next = null;

	ListNode1(int val) {
		this.val = val;
	}
}

class Solution有序链表合并 {
	public ListNode1 Merge(ListNode1 list1, ListNode1 list2) {
		ListNode1 list = new ListNode1(0);
		ListNode1 pointer = list;
//		ListNode1 temp = null;
		while (true) {
			if (list1 == null && list2 == null) {
				return list.next;
			} else if (list2 == null && list1 != null) {
				pointer.next=list1;
				return list.next;
			}else if (list1 == null && list2 != null) {
				pointer.next=list2;
				return list.next;
			}else {
				if (list1.val<list2.val) {
					pointer.next=new ListNode1(list1.val);
					pointer=pointer.next;
					list1=list1.next;
				}else {
					pointer.next=new ListNode1(list2.val);
					pointer=pointer.next;
					list2=list2.next;
				}
			}
		}

	}
}