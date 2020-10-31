package leetcodeanswer;

public class _148≈≈–Ú¡¥±Ì {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode148 node1 = new ListNode148(4);
		ListNode148 node2 = new ListNode148(2);
		ListNode148 node3 = new ListNode148(1);
		node1.next = node2;
		node2.next = node3;

		ListNode148 node4 = new ListNode148(3);
		ListNode148 node5 = new ListNode148(3);
		ListNode148 node6 = new ListNode148(4);
		node3.next = node4;
//		node4.next = node5;
//		node5.next = node6;

		node1.print();

		Solution148 sl = new Solution148();

		sl.sortList(node1).print();
//		sl.split(node1).print();
//		node1.print();

	}

}

class Solution148 {
	public ListNode148 sortList(ListNode148 head) {
		if (head == null || head.next == null)
			return head;
		ListNode148 half = split(head);

		head=sortList(head);
		half=sortList(half);

		return merge(head, half);
	}

	public ListNode148 merge(ListNode148 l1, ListNode148 l2) {
		if(l1==null) return l2;
		if(l2==null) return l1;
		
		ListNode148 root = new ListNode148(0);
		ListNode148 prev = root;
		
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				prev.next = l1;
				l1 = l1.next;
			} else {
				prev.next = l2;
				l2 = l2.next;
			}
			prev = prev.next;
		}

		if (l1 == null) {
			prev.next = l2;
		}
		if (l2 == null) {
			prev.next = l1;
		}

		return root.next;

	}

	// ¡¥±Ì≤∑÷
	public ListNode148 split(ListNode148 head) {

		if (head == null || head.next == null)
			return null;
		ListNode148 fast = head;
		ListNode148 slow = head;
		ListNode148 temp = null;

		while (fast != null) {
			fast = fast.next;
			if (fast != null) {
				fast = fast.next;
			}
			if (fast == null) {
				break;
			}
			slow = slow.next;
		}

		temp = slow;
		slow = slow.next;
		temp.next = null;
		
//		System.out.println("left");
//		head.print();
//		System.out.println("right");
//		slow.print();
		return slow;

	}

}

class ListNode148 {
	int val;
	ListNode148 next;

	ListNode148(int x) {
		val = x;
	}

	public void print() {
		print(this);
	}

	public void print(ListNode148 root) {
		while (root != null) {
			System.out.print(root.val + "->");
			root = root.next;
		}
		System.out.println();
	}

}