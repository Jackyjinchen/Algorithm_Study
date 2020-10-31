package com.Jacky.linkedlist;

import java.util.Scanner;

public class DoubleLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoubleNode node1 = new DoubleNode(1, "sa", "xf");
		DoubleNode node2 = new DoubleNode(2, "sf", "th");
		DoubleNode node3 = new DoubleNode(3, "xq", "ju");
		DoubleNode node4 = new DoubleNode(4, "xc", "rv");
		DoubleList doubleList = new DoubleList();
		doubleList.add(node1);
		doubleList.add(node2);
		doubleList.add(node3);
		doubleList.add(node4);
		doubleList.ShowList();

		DoubleNode node5 = new DoubleNode(4, "x22", "rv");
		doubleList.update(node5);
		doubleList.ShowList();
//
		doubleList.delete(node2);
		doubleList.ShowList();
	}

}

//创建DoubleList表
class DoubleList {
	private DoubleNode head = new DoubleNode(0, "", "");

	public DoubleNode getHead() {
		return head;
	}

	public void add(DoubleNode node) {
		DoubleNode temp = head;
		while (true) {
			if (temp.next == null) {
				break;
			}
			temp = temp.next;
		}
		temp.next = node;
		node.prev = temp;
	}

	public void update(DoubleNode node) {
		if (head.next == null) {
			System.out.println("链表为空");
			return;
		}
		DoubleNode temp = head.next;
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

	public void delete(DoubleNode node) {
		if (head.next == null) {
			System.out.println("链表为空");
			return;
		}
		DoubleNode temp = head.next;
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
			//这里一定要注意，如果链表尾不需要指定prev结点
			if (temp.next != null) {
				temp.next.prev = temp.prev;
			}
			temp.prev.next = temp.next;
		} else {
			System.out.printf("没找到");
		}
	}

	public void ShowList() {
		if (head.next == null) {
			System.out.println("链表为空");
			return;
		}
		DoubleNode temp = head.next;
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
class DoubleNode {
	public int no;
	public String name;
	public String nickname;
	public DoubleNode next;
	public DoubleNode prev;

	public DoubleNode(int no, String name, String nickname) {
		this.no = no;
		this.name = name;
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "Node [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
	}

}
