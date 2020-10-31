package leetcodeanswer;

public class _25K个一组翻转链表 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode25 head = new ListNode25(1);
		ListNode25 l1 = new ListNode25(2);
		ListNode25 l2 = new ListNode25(3);
		ListNode25 l3 = new ListNode25(4);
		ListNode25 l4 = new ListNode25(5);
		head.next = l1;
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		Solution25 sl = new Solution25();

		sl.toStrings(sl.reverseKGroup(head, 3));
		;

	}

}

class ListNode25 {
	int val;
	ListNode25 next;

	ListNode25(int x) {
		val = x;
	}

}

class Solution25 {

	public ListNode25 reverseKGroup(ListNode25 head, int k) {
		ListNode25 ans = new ListNode25(0);
		ans.next = head;

		ListNode25 pre = ans;
		ListNode25 end = ans;

		while (end.next != null) {
			for (int i = 0; i < k && end != null; i++)end = end.next;
			if (end == null)break;
			ListNode25 start=pre.next;
			ListNode25 next=end.next;
			end.next=null;
			pre.next=reverseList(start);
			start.next=next;
			pre=start;
			end=pre;
			
		}
		return ans.next;
	}
	
	public ListNode25 reverseList(ListNode25 head) {
		
		ListNode25 temp = null;
		ListNode25 pointer = head.next;
		head.next = null;

		while (pointer != null) {
			temp = pointer;
			pointer = pointer.next;
			temp.next = head;
			head = temp;

		}
		return head;
	}

	public void toStrings(ListNode25 head) {
		ListNode25 temp = head;
		while (temp != null) {
			System.out.print(temp.val + "->");
			temp = temp.next;
		}
	}

}
