package com.Jacky.huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 13, 7, 8, 3, 29, 6, 1 };
		Node node = creatHuffmanTree(arr);

		// 前序遍历
		node.preOder();

	}

	// 编写一个前序遍历的方法
	public static void preorder(Node root) {
		if (root != null) {
			root.preOder();
		} else {
			System.out.println("是空树，不能追历~");
		}
	}

	public static Node creatHuffmanTree(int[] arr) {
		// 遍历排序arr，构建成Node，放入ArrayList
		List<Node> nodes = new ArrayList<Node>();
		for (int value : arr) {
			nodes.add(new Node(value));
		}

		while (nodes.size() > 1) {
			Collections.sort(nodes);

			// 取出权值最小的二叉树节点
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

//为了让Node 支持集合排序，需要将Node实现一个Comparable接口
class Node implements Comparable<Node> {
	int value;
	char c;
	Node left;
	Node right;

	// 构造器
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
		// 表示从小到大排序
		return this.value - o.value;
	}

	// 前序遍历
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
