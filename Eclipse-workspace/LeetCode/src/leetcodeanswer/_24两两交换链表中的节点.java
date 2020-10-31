package leetcodeanswer;

public class _24两两交换链表中的节点 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode24 head = new ListNode24(1);
		ListNode24 l1 = new ListNode24(2);
		ListNode24 l2 = new ListNode24(3);
		ListNode24 l3 = new ListNode24(4);
		head.next=l1;
		l1.next=l2;
		l2.next=l3;
		Solution24 sl = new Solution24();
		
		sl.toStrings(sl.swapPairs(head));

	}

}

class ListNode24 {
	int val;
	ListNode24 next;

	ListNode24(int x) {
		val = x;
	}

}

class Solution24 {
	public ListNode24 swapPairs(ListNode24 head) {
		ListNode24 pre=new ListNode24(0);
		pre.next=head;
		ListNode24 temp=pre;
		while(temp.next!=null&&temp.next.next!=null) {
			ListNode24 l1=temp.next;
			ListNode24 l2=temp.next.next;
			l1.next=l2.next;
			temp.next=l2;
			l2.next=l1;
			temp=l1;
		}
		return pre.next;		
	}
	
	public void toStrings(ListNode24 head) {
		ListNode24 temp=head;
		while(temp!=null) {
			System.out.print(temp.val+"->");
			temp=temp.next;
		}
	}
	
}