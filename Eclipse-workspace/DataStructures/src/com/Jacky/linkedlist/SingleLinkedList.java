package com.Jacky.linkedlist;

import java.util.Stack;

public class SingleLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node node1 = new Node(1, "sa", "xf");
		Node node2 = new Node(2, "sf", "th");
		Node node3 = new Node(3, "xq", "ju");
		Node node4 = new Node(4, "xc", "rv");
		SingleList singleList = new SingleList();
		singleList.add(node1);
		singleList.add(node2);
		singleList.add(node3);
		singleList.add(node4);
//		singleList.ShowList();

		Node node5 = new Node(4, "x22", "rv");
		singleList.update(node5);
//		singleList.ShowList();

//		singleList.delete(node2);
//		singleList.ShowList();

		System.out.println("链表的长度" + getLenth(singleList.getHead()));
		singleList.ShowList();

//		reversetList2(singleList.getHead());
//		System.out.println("链表的长度" + getLenth(singleList.getHead()));
//		singleList.ShowList();

		//单链表逆序打印未改变链表结构
		Node tempNodexNode = null;
		tempNodexNode = reversetOutput(singleList.getHead());
		reversetOutput2(singleList.getHead());
		singleList.ShowList();
	}

	// 获取单链表节点个数
	public static int getLenth(Node head) {
		if (head.next == null) {
			System.out.println("链表为空");
			return 0;
		}
		int length = 0;
		Node cur = head.next;
		while (cur != null) {
			length++;
			cur = cur.next;
		}
		return length;
	}

	// 链表反转输出
	public static void reversetList(Node head) {
		if (head.next == null || head.next.next == null) {
			return;
		}
		Node cur = head.next;
		Node next = null;
		Node reversetHead = new Node(0, "", "");

		while (cur != null) {
			next = cur.next;
			cur.next = reversetHead.next;
			reversetHead.next = cur;
			cur = next;
		}
		head.next = reversetHead.next;
	}

	// 链表反转输出 ，网络方法
	public static void reversetList2(Node head) {
		if (head.next == null || head.next.next == null) {
			return;
		}
		Node cur = head.next;
		Node prev = null;
		Node next = null;
		while (cur != null) {
			// 在头节点改变之前，先获取下一个节点的指针
			next = cur.next;
			// 头节点的下一个节点要改成它的上一个节点，是一个逆转的过程
			cur.next = prev;
			// 上一个节点前移指向头节点
			prev = cur;
			// 头节点前移指向下一个节点
			cur = next;
		}
		head.next = prev;
	}

	// 链表通过嵌套循环倒序输出
	public static Node reversetOutput(Node head) {
		Node temp = null;
		if (head.next != null) {
			temp = reversetOutput(head.next);
		}
		System.out.println(temp);
		return head;
	}

	// 链表通过栈FILO进行逆序打印
	public static void reversetOutput2(Node head) {
		// TODO Auto-generated method stub
		if (head.next == null) {
			return;
		}

		Stack<Node> stack = new Stack<Node>();
		Node cur =head.next;
		// Stack先进后出 单链表先压栈再出栈
		while (cur!=null) {
		stack.push(cur);
		cur=cur.next;
		}
		while(stack.size()>0) {
		System.out.println(stack.pop());
		}
	}

}
/*
 * class Solution { public: vector<int> printListFromTailToHead(ListNode* head)
 * { vector<int> v; if(nullptr == head) return v; v =
 * printListFromTailToHead(head->next); v.push_back(head->val); return v; } };
 * 
 * 
 * }
 */

//创建SingleList表
class SingleList {
	private Node head = new Node(0, "", "");

	public Node getHead() {
		return head;
	}

	public void add(Node node) {
		Node temp = head;
		while (true) {
			if (temp.next == null) {
				break;
			}
			temp = temp.next;
		}
		temp.next = node;
	}

	public void update(Node node) {
		if (head.next == null) {
			System.out.println("链表为空");
			return;
		}
		Node temp = head.next;
		boolean flag = false;
		while (true) {
			if (temp == null) {
				break;
			}
			if (temp.no == node.no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if (flag) {
			temp.name = node.name;
			temp.nickname = node.nickname;
		} else {
			System.out.printf("没找到");
		}
	}

	public void delete(Node node) {
		if (head.next == null) {
			System.out.println("链表为空");
			return;
		}
		Node temp = head;
		boolean flag = false;
		while (true) {
			if (temp == null) {
				break;
			}
			if (temp.next.no == node.no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if (flag) {
			temp.next = temp.next.next;
		} else {
			System.out.printf("没找到");
		}
	}

	public void ShowList() {
		if (head.next == null) {
			System.out.println("链表为空");
			return;
		}
		Node temp = head.next;
		while (true) {
			if (temp == null) {
				break;
			}
			System.out.println(temp);
			temp = temp.next;
		}

	}

}

//节点
class Node {
	public int no;
	public String name;
	public String nickname;
	public Node next;

	public Node(int no, String name, String nickname) {
		this.no = no;
		this.name = name;
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "Node [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
	}

}
