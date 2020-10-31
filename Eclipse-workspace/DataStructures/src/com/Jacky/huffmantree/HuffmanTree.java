package com.Jacky.huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 13, 7, 8, 3, 29, 6, 1 };
		Node node = creatHuffmanTree(arr);

		// ǰ�����
		node.preOder();

	}

	// ��дһ��ǰ������ķ���
	public static void preorder(Node root) {
		if (root != null) {
			root.preOder();
		} else {
			System.out.println("�ǿ���������׷��~");
		}
	}

	public static Node creatHuffmanTree(int[] arr) {
		// ��������arr��������Node������ArrayList
		List<Node> nodes = new ArrayList<Node>();
		for (int value : arr) {
			nodes.add(new Node(value));
		}

		while (nodes.size() > 1) {
			Collections.sort(nodes);

			// ȡ��Ȩֵ��С�Ķ������ڵ�
			Node left = nodes.get(0);
			Node right = nodes.get(1);
			Node parent = new Node(left.value + right.value);
			parent.left = left;
			parent.right = right;

			nodes.remove(left);
			nodes.remove(right);
			nodes.add(parent);
			System.out.println("node =" + nodes);

		}

		return nodes.get(0);

	}

}

//Ϊ����Node ֧�ּ���������Ҫ��Nodeʵ��һ��Comparable�ӿ�
class Node implements Comparable<Node> {
	int value;
	char c;
	Node left;
	Node right;

	// ������
	public Node(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}

	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		// ��ʾ��С��������
		return this.value - o.value;
	}

	// ǰ�����
	public void preOder() {
		System.out.println(this);
		if (this.left != null) {
			this.left.preOder();
		}
		if (this.right != null) {
			this.right.preOder();
		}

	}

}
