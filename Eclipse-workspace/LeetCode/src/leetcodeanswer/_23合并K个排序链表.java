package leetcodeanswer;


public class _23合并K个排序链表{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode23 node1 = new ListNode23(1);
		ListNode23 node2 = new ListNode23(2);
		ListNode23 node3 = new ListNode23(3);
		node1.next = node2;
		node2.next = node3;

		ListNode23 node4 = new ListNode23(4);
		ListNode23 node5 = new ListNode23(5);
		ListNode23 node6 = new ListNode23(6);
		node4.next = node5;
		node5.next = node6;

//		ListNode23 node7 = new ListNode23(7);
//		ListNode23 node8 = new ListNode23(8);
//		ListNode23 node9 = new ListNode23(9);
//		node3.next = node7;
//		node6.next = node7;
//		node7.next = node8;
//		node8.next = node9;

//		node1.print();

		Solution23 sl = new Solution23();
		
		ListNode23[] lists= {node1,node4};
		
		sl.mergeKLists(lists).print();

//		sl.sortList(node1).print();
//		sl.split(node1).print();
//		node1.print();

	}

}


class Solution23 {
	
    public ListNode23 mergeKLists(ListNode23[] lists) {
    	if (lists==null) return null;
    	if (lists.length<2) return lists[0];

    	ListNode23 ans=null;
       
    	for (int i = 0; i < lists.length; i++) {
    		ans=mergeTwoLists(lists[i], ans);
		}
    	
    	
    	return ans;
    }
    
    public ListNode23 mergeTwoLists(ListNode23 l1, ListNode23 l2) {
    	if(l2==null) return l1;
        // maintain an unchanging reference to node ahead of the return node.
        ListNode23 prehead = new ListNode23(-1);

        ListNode23 prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // exactly one of l1 and l2 can be non-null at this point, so connect
        // the non-null list to the end of the merged list.
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }

    
}
	
	
	

class ListNode23 {
	int val;
	ListNode23 next;

	ListNode23(int x) {
		val = x;
	}
	
	

	@Override
	public String toString() {
		return "ListNode23 val=" + val + "";
	}



	public void print() {
		print(this);
	}

	public void print(ListNode23 root) {
		while (root != null) {
			System.out.print(root.val + "->");
			root = root.next;
		}
		System.out.println();
	}
}

