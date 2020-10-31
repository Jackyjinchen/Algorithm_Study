package leetcodeanswer;

public class _160相交链表 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		ListNode160 node1 = new ListNode160(1);
		ListNode160 node2 = new ListNode160(2);
		ListNode160 node3 = new ListNode160(3);
		node1.next = node2;
		node2.next = node3;

		ListNode160 node4 = new ListNode160(4);
		ListNode160 node5 = new ListNode160(5);
		ListNode160 node6 = new ListNode160(6);
		node4.next = node5;
		node5.next = node6;

		ListNode160 node7 = new ListNode160(7);
		ListNode160 node8 = new ListNode160(8);
		ListNode160 node9 = new ListNode160(9);
		node3.next = node7;
		node6.next = node7;
		node7.next = node8;
		node8.next = node9;

//		node1.print();

		Solution160 sl = new Solution160();

		System.out.println(sl.getIntersectionNode(node1, node4).val);

//		sl.sortList(node1).print();
//		sl.split(node1).print();
//		node1.print();

	}

}

//Floyd算法，证明总可以经过n次循环最终到达相同地点
class Solution160 {
	public ListNode160 getIntersectionNode(ListNode160 headA, ListNode160 headB) {
		if (headA == null || headB == null)
			return null;
		ListNode160 pA = headA;
		ListNode160 pB = headB;

		while (pA != pB) {
			if (pA.next == null && pB.next == null && pA != pB)
				return null;

			if (pA.next == null) {
				pA = headB;
			} else {
				pA = pA.next;
			}
			if (pB.next == null) {
				pB = headA;
			} else {
				pB = pB.next;
			}
		}

		return pA;
	}
}

class ListNode160 {
	int val;
	ListNode160 next;

	ListNode160(int x) {
		val = x;
	}

	public void print() {
		print(this);
	}

	public void print(ListNode160 root) {
		while (root != null) {
			System.out.print(root.val + "->");
			root = root.next;
		}
		System.out.println();
	}

}