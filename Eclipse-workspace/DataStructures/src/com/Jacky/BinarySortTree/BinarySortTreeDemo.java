package com.Jacky.BinarySortTree;

public class BinarySortTreeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 7, 3, 10, 1, 5, 9, 12 };
//		int[] arr = { 8,4,12,2,6,10,14,1,3,5,7,9,11,13,15};

		BinarySortTree tree = new BinarySortTree();
		for (int i = 0; i < arr.length; i++) {
			tree.add(new Node(arr[i]));
		}
		tree.infixOrder();
		System.out.println();

//		tree.add(new Node(2));
//		tree.infixOrder();

//		System.out.println();
//		tree.deleteNode(1);
//		tree.infixOrder();

//		System.out.println();
//		tree.add(new Node(3));
//		tree.infixOrder();

//		System.out.println();
//
		tree.deleteNode(2);
		tree.deleteNode(5);
		tree.deleteNode(9);
		tree.deleteNode(12);
		tree.deleteNode(7);
		tree.deleteNode(3);
	
		tree.deleteNode(10);
	tree.deleteNode(1);
		tree.infixOrder();

	}

}

class BinarySortTree {
	private Node root;

	public void add(Node node) {
		if (root == null) {
			root = node;
		} else {
			root.add(node);
		}
	}

	public void infixOrder() {
		if (root != null) {
			root.infixOrder();
		} else {
			System.out.println("Empty");
		}
	}

	public Node search(int value) {
		if (root == null) {
			return null;
		} else {
			return root.search(value);
		}
	}

	public Node searchParent(int value) {
		if (root == null) {
			return null;
		} else {
			return root.searchParent(value);
		}
	}

	// ɾ���ڵ�
	public void deleteNode(int value) {
		if (root == null) {
			return;
		} else {
			Node targetNode = search(value);
			if (targetNode == null) {
				return;
			}
			// ���ɾ������root������ֻ����һ��
			if (root.left == null && root.right == null) {
				root = null;
				return;
			}
			// �ҵ�targetNode���ڵ�
			Node parent = searchParent(value);
			if (targetNode.left == null && targetNode.right == null) {
				if (parent.left != null && parent.left.value == value) {
					parent.left = null;
					return;
				} else if (parent.right != null && parent.right.value == value) {
					parent.right = null;
					return;
				}
			} else if (targetNode.left != null && targetNode.right != null) {// ���������������
				Node tempNode = targetNode.left;
				int temp = 0;
				while (tempNode.right != null) {
					tempNode = tempNode.right;
				}
				temp = tempNode.value;
				deleteNode(tempNode.value);
				targetNode.value = temp;
				return;

			} else {
				// ���Ҫɾ���Ľڵ������ӽڵ㣬
				if (targetNode.left != null) {
					if (parent != null) {//���ﵱֻ��2���ڵ�ʱ��Ҫɾ��root�ڵ�ʱ��parentΪnull����Ҫ��������
						if (parent.left != null && parent.left.value == value) {
							parent.left = targetNode.left;
							return;
						} else {
							parent.right = targetNode.left;
							return;
						}
					} else {
						root = targetNode.left;
					}
				} else {
					if (parent != null) {
						if (parent.left != null && parent.left.value == value) {
							parent.left = targetNode.right;
							return;
						} else {
							parent.right = targetNode.right;
							return;
						}
					}else {
						root=targetNode.right;
					}
				}

			}

		}
	}

}

class Node {
	int value;
	Node left;
	Node right;

	public Node(int value) {
		this.value = value;
	}

	public void infixOrder() {
		if (this.left != null) {
			this.left.infixOrder();
		}
		System.out.println(this.value);
		if (this.right != null) {
			this.right.infixOrder();
		}

	}

	public void add(Node node) {
		if (node == null) {
			return;
		}
		if (node.value < this.value) {
			if (this.left == null) {
				this.left = node;
			} else {
				this.left.add(node);
			}
		} else {
			if (this.right == null) {
				this.right = node;
			} else {
				this.right.add(node);
			}
		}
	}

	/**
	 * �ҵ�Ҫɾ���ڵ�ĸ��ڵ㣬û�з���null
	 * 
	 * @param value
	 * @return
	 */
	public Node searchParent(int value) {
		if ((this.left != null && this.left.value == value) || this.right != null && this.right.value == value) {
			return this;
		} else {
			if (value < this.value && this.left != null) {
				return this.left.searchParent(value);
			} else if (value >= this.value && this.right != null) {
				return this.right.searchParent(value);
			} else {
				return null;
			}
		}
	}

	/**
	 * 
	 * @param value �ҵ�ϣ��ɾ����ֵ
	 * @return �����ҵ��Ľڵ㣬����null
	 */
	public Node search(int value) {
		if (value == this.value) {
			return this;
		} else if (value < this.value) {
			if (this.left == null) {
				return null;
			}
			return this.left.search(value);
		} else {
			if (this.right == null) {
				return null;
			}
			return this.right.search(value);
		}
	}

	public void delete(Node node) {

	}

}