package com.Jacky.AVLTree;

public class AVLTreeDemo {

	public static void main(String[] args) {

//		int[] arr = { 4, 3, 6, 5, 7, 8 };
//		int[] arr = { 10,12,8,9,7,6 };
		int[] arr = { 10,11,7,6,8,9 };


		AVLTree avlTree = new AVLTree();

		for (int i = 0; i < arr.length; i++) {
			avlTree.add(new Node(arr[i]));
		}
		
		System.out.println("infixOrder");
		avlTree.infixOrder();
		
		System.out.println("ûƽ�⴦��");
		System.out.println(avlTree.getRoot().height());
		System.out.println(avlTree.getRoot().leftHeight());
		System.out.println(avlTree.getRoot().rightHeight());
		
//		System.out.println("ƽ�⴦��");
//		avlTree.getRoot().leftRotate();
//		System.out.println(avlTree.getRoot().height());
//		System.out.println(avlTree.getRoot().leftHeight());
//		System.out.println(avlTree.getRoot().rightHeight());
//		System.out.println("infixOrder");
//		avlTree.infixOrder();


	}

}

class AVLTree {
	private Node root;

	public Node getRoot() {
		return root;
	}
	
	public void add(Node nodes) {
		if (root == null) {
			root = nodes;
		} else {
			root.add(nodes);
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
					if (parent != null) {// ���ﵱֻ��2���ڵ�ʱ��Ҫɾ��root�ڵ�ʱ��parentΪnull����Ҫ��������
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
					} else {
						root = targetNode.right;
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

	// ���ص�ǰ�ڵ�߶ȣ�ָ���Ǹýڵ�Ϊ���ڵ�����ĸ߶�
	public int height() {
		return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
	}

	public int leftHeight() {
		if (left == null) {
			return 0;
		}
		return left.height();
	}

	public int rightHeight() {
		if (right == null) {
			return 0;
		}
		return right.height();
	}

	//����ת�����������ĸ߶Ƚ���
	public void leftRotate() {
		Node newnode =new Node(value);
		newnode.left=left;
		newnode.right=right.left;
		value=right.value;
		right=right.right;
		left=newnode;	
	}
	
	public void rightRotate() {
		Node newnode =new Node(value);
		newnode.right=right;
		newnode.left=left.right;
		value=left.value;
		left=left.left;
		right=newnode;	
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
		
		//�������������߶ȴ���������2����rotate
		if((rightHeight()-leftHeight())>1){
			if (right!=null&&right.rightHeight()<right.leftHeight()) {
				leftRotate();
			}else {
				right.rightRotate();
				leftRotate();
			}
			
//			leftRotate();
		}
		
		//����ת��
		if((leftHeight()-rightHeight())>1){
			if (left!=null&&left.rightHeight()<left.leftHeight()) {
				rightRotate();
			}else {
				left.leftRotate();
				rightRotate();
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