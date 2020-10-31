package leetcodeanswer;

public class _206·´×ªÁ´±í {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

//Given
class ListNode206 {
	int val;
	ListNode206 next;

	ListNode206(int x) {
		val = x;
	}
}

//Answer
class Solution206 {
	public ListNode206 reverseList(ListNode206 head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode206 temp = null;
		ListNode206 pointer = head.next;
		head.next = null;

		while (pointer != null) {
			temp = pointer;
			pointer = pointer.next;
			temp.next = head;
			head = temp;

		}
		return head;
	}
}