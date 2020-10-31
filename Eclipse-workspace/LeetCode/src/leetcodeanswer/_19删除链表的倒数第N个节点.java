package leetcodeanswer;

public class _19删除链表的倒数第N个节点 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}

class ListNode19 {
	int val;
	ListNode19 next;

	ListNode19(int x) {
		val = x;
	}
}

//双指针实现
class Solution19{
	public ListNode removeNthFromEnd(ListNode head, int n) {
	    ListNode dummy = new ListNode(0);
	    dummy.next = head;
	    ListNode first = dummy;
	    ListNode second = dummy;
	    for (int i = 1; i <= n + 1; i++) {
	        first = first.next;
	    }
	    while (first != null) {
	        first = first.next;
	        second = second.next;
	    }
	    second.next = second.next.next;
	    return dummy.next;
	}
}


//class Solution19 {
//    public ListNode19 removeNthFromEnd(ListNode19 head, int n) {
//    	ListNode19 pre=new ListNode19(0);
//    	pre.next=head;
//    	reverse(n, pre);
//    	return pre.next;
//    	
//    }
//    
//    public int reverse(int n,ListNode19 temp) {
//		if(temp.next==null) return 1;
//    	int count=reverse(n, temp.next);
//    	if(count==n) temp.next=temp.next.next;
//    	return ++count;
//	}
//    
//    
//}