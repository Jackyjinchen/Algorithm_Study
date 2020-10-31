package leetcodeanswer;


public class _02两数之和 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode root1 = new ListNode(2);
		ListNode node2 = new ListNode(4);
		ListNode node3 = new ListNode(3);
		root1.next = node2;
		node2.next = node3;

		ListNode root2 = new ListNode(5);
		ListNode node5 = new ListNode(6);
		ListNode node6 = new ListNode(4);
		root2.next = node5;
		node5.next = node6;

		Solution02 solution = new Solution02();
		solution.addTwoNumbers(root1, root2).show();

	}

}

class Solution02 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int flag = 0;
		ListNode returnNode = new ListNode(0);
		ListNode curr=returnNode;
		while (l1 != null || l2 != null) {
			int x = (l1 != null) ? l1.val : 0;
			int y = (l2 != null) ? l2.val : 0;
			int temp= x+y+flag;
			flag=temp/10;
			curr.next=new ListNode(temp%10);
			curr=curr.next;
			if(l1!=null) l1=l1.next; 
			if(l2!=null) l2=l2.next; 
		}
		if(flag!=0) curr.next=new ListNode(flag);

		return returnNode.next;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}

	public void show() {
		ListNode root = this;
		while (root != null) {
			System.out.println(root.val);
			root = root.next;
		}

	}

}
