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
		
		System.out.println("没平衡处理");
		System.out.println(avlTree.getRoot().height());
		System.out.println(avlTree.getRoot().leftHeight());
		System.out.println(avlTree.getRoot().rightHeight());
		
//		System.out.println("平衡处理");
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

	// 删除节点
	public void deleteNode(int value) {
		if (root == null) {
			return;
		} else {
			Node targetNode = search(value);
			if (targetNode == null) {
				return;
			}
			// 如果删除的是root，而且只有他一个
			if (root.left == null && root.right == null) {
				root = null;
				return;
			}
			// 找到targetNode父节点
			Node parent = searchParent(value);
			if (targetNode.left == null && targetNode.right == null) {
				if (parent.left != null && parent.left.value == value) {
					parent.left = null;
					return;
				} else if (parent.right != null && parent.right.value == value) {
					parent.right = null;
					return;
				}
			} else if (targetNode.left != null && targetNode.right != null) {// 有两个子树的情况
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
				// 如果要删除的节点有左子节点，
				if (targetNode.left != null) {
					if (parent != null) {// 这里当只有2个节点时候，要删除root节点时，parent为null，需要单独处理
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

	// 返回当前节点高度，指的是该节点为根节点的树的高度
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

	//左旋转，将右子树的高度降低
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
		
		//添加完后右子树高度大于左子树2，则rotate
		if((rightHeight()-leftHeight())>1){
			if (right!=null&&right.rightHeight()<right.leftHeight()) {
				leftRotate();
			}else {
				right.rightRotate();
				leftRotate();
			}
			
//			leftRotate();
		}
		
		//右旋转，
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
	 * 找到要删除节点的父节点，没有返回null
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
	 * @param value 找到希望删除的值
	 * @return 返回找到的节点，否则null
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