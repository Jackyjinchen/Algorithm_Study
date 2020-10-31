package leetcodeanswer;

import java.util.HashSet;

public class _142环形链表II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode142 node1 = new ListNode142(4);
		ListNode142 node2 = new ListNode142(2);
		ListNode142 node3 = new ListNode142(1);
		node1.next = node2;
		node2.next = node3;

		ListNode142 node4 = new ListNode142(3);
		ListNode142 node5 = new ListNode142(3);
		ListNode142 node6 = new ListNode142(4);
		node3.next = node4;
		node4.next = node2;


//		node1.print();

		Solution142 sl = new Solution142();

		System.out.println(sl.detectCycle(node1).val);
		
//		sl.sortList(node1).print();
//		sl.split(node1).print();
//		node1.print();

	}

}



//Floyd算法，证明总可以经过n次循环最终到达相同地点
class Solution142 {
    private ListNode142 getIntersect(ListNode142 head) {
        ListNode142 tortoise = head;
        ListNode142 hare = head;

        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
            if (tortoise == hare) {
                return tortoise;
            }
        }

        return null;
}

    public ListNode142 detectCycle(ListNode142 head) {
        if (head == null) {
            return null;
        }

        ListNode142 intersect = getIntersect(head);
        if (intersect == null) {
            return null;
        }

        ListNode142 ptr1 = head;
        ListNode142 ptr2 = intersect;
        while (ptr1 != ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        return ptr1;
    }
}



////采用哈希表存储每一个节点，如果出现重复说明循环了
//class Solution142 {
//	public ListNode142 detectCycle(ListNode142 head) {
//		HashSet<ListNode142> set = new HashSet<ListNode142>();
//		
//		while(head!=null) {
//			if (set.contains(head)) {
//				return head;
//			}
//			set.add(head);
//			head=head.next;
//
//		}
//		
//		return null;
//	}
//
//
//
//}

class ListNode142 {
	int val;
	ListNode142 next;

	ListNode142(int x) {
		val = x;
	}

	public void print() {
		print(this);
	}

	public void print(ListNode142 root) {
		while (root != null) {
			System.out.print(root.val + "->");
			root = root.next;
		}
		System.out.println();
	}

}