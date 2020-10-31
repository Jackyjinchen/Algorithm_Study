package Nowcoder;


public class _单链表翻转 {
	public static void main(String[] args) {
		ListNode node1= new ListNode(2);
		ListNode node2= new ListNode(3);
		ListNode node3= new ListNode(4);
		ListNode node4= new ListNode(5);
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		Solution单链表 solution = new Solution单链表();
		ListNode answerListNode=solution.ReverseList(node1);
		while(answerListNode!=null) {
			System.out.println(answerListNode.val);
			answerListNode=answerListNode.next;
		}
		
		
	}
	
	

}

class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
}

class Solution单链表 {
	public ListNode ReverseList(ListNode head) {
		
		if(head==null||head.next==null) {
			return head;
		}
    	ListNode temp =null;
    	ListNode pointer = head.next;
    	head.next=null;
    	
    	while(pointer!=null) {
    		temp=pointer;
    		pointer=pointer.next;
    		temp.next=head;
    		head=temp;

    	}

    	return head;
    		
    }
}