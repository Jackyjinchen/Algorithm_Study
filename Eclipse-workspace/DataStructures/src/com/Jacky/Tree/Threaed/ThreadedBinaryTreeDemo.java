package com.Jacky.Tree.Threaed;


public class ThreadedBinaryTreeDemo {

	public static void main(String[] args) {
		ThreadedBinaryTree threadedbinaryTree = new ThreadedBinaryTree();
		HeroNode root = new HeroNode(1, "a");
		HeroNode node2 = new HeroNode(3, "b");
		HeroNode node3 = new HeroNode(6, "c");
		HeroNode node4 = new HeroNode(8, "d");
		HeroNode node5 = new HeroNode(10, "e");
		HeroNode node6 = new HeroNode(14, "f");
		
		//�ֶ�����
		threadedbinaryTree.setRoot(root);
		root.setLeft(node2);
		root.setRight(node3);
		node2.setLeft(node4);
		node2.setRight(node5);
		node3.setLeft(node6); 
		
		//������
//		System.out.println("������");
//		HeroNode leftNode=node5.getLeft();
		threadedbinaryTree.infixOrder();
//		System.out.println(leftNode);
		threadedbinaryTree.threadedNodes(root);
//		leftNode=node5.getLeft();
//		HeroNode rightNode=node5.getRight();
//		System.out.println(rightNode);
		
		System.out.println("��������ʽ����");
		threadedbinaryTree.threadedList();
		
		
	}

}

//������
class ThreadedBinaryTree {
	private HeroNode root;
	// Ϊ��ʵ��������
	// ��Ҫ����һ��ָ��ǰ���ڵ��ָ��
	private HeroNode pre = null;

	public void setRoot(HeroNode root) {
		this.root = root;
	}

	
	//�����������
	public void threadedList() {
		HeroNode node=root;
		while(node!=null) {
			//ѭ���ҵ�leftType=1�Ľڵ�
			while (node.getLeftType()==0) {
				node=node.getLeft();
			}
			System.out.println(node);
			//�����ָ��ָ���̽ڵ��һֱ���
			while(node.getRightType()==1) {
				node=node.getRight();
				System.out.println(node);
			}
			node=node.getRight();
		}
	}
	
	
	/**
	 * �������������
	 * 
	 * @param node Ҫ�������Ľڵ�
	 */
	public void threadedNodes(HeroNode node) {
		if (node == null) {
			return;
//			System.out.println("Empty,cannot threaded");
		}

		// ������������
		threadedNodes(node.getLeft());
		// ��������ǰ�ڵ�

		if (node.getLeft() == null) {
			node.setLeft(pre);
			node.setLeftType(1);
		}

		// ������̽ڵ�
		///////////////////////////////
		if (pre != null && pre.getRight() == null) {
			pre.setRight(node);
			pre.setRightType(1);
		}

		pre = node;

		// ������������
		threadedNodes(node.getRight());

	}

	// ǰ�����
	public void preOrder() {
		if (this.root != null) {
			this.root.preOrder();
		} else {
			System.out.println("Empty,Finish");
		}
	}

	public HeroNode preOrdersearch(int no) {
		HeroNode temp = null;
		if (this.root != null) {
			temp = this.root.preOrderSearch(no);
		} else {
			System.out.println("Not find");
		}
		return temp;
	}

	public void infixOrder() {
		if (this.root != null) {
			this.root.infixOrder();
		} else {
			System.out.println("Empty,Finish");
		}
	}

	public HeroNode infixOrdersearch(int no) {
		HeroNode temp = null;
		if (this.root != null) {
			temp = this.root.infixOrderSearch(no);
		} else {
			System.out.println("Not find");
		}
		return temp;
	}

	public void postOrder() {
		if (this.root != null) {
			this.root.postOrder();
		} else {
			System.out.println("Empty,Finish");
		}
	}

	public HeroNode postOrdersearch(int no) {
		HeroNode temp = null;
		if (this.root != null) {
			temp = this.root.postOrderSearch(no);
		} else {
			System.out.println("Not find");
		}
		return temp;
	}

	public void delNode(int no) {
		if (root != null) {
			// ���жϸ��ڵ��ǲ���Ҫɾ����
			if (root.getNo() == no) {
				root = null;
			}
			root.delNode(no);
		} else {
			System.out.println("Null Tree");
		}
	}

}

class HeroNode {
	private int no;
	private String name;
	private HeroNode left;
	private HeroNode right;

	// =0������ 1��ǰ������ϵ�G��
	///////////////////////////////////
	private int leftType;

	public int getLeftType() {
		return leftType;
	}

	public void setLeftType(int leftType) {
		this.leftType = leftType;
	}

	public int getRightType() {
		return rightType;
	}

	public void setRightType(int rightType) {
		this.rightType = rightType;
	}

	private int rightType;

	public HeroNode(int no, String name) {
		this.no = no;
		this.name = name;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HeroNode getLeft() {
		return left;
	}

	public void setLeft(HeroNode left) {
		this.left = left;
	}

	public HeroNode getRight() {
		return right;
	}

	public void setRight(HeroNode right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + "]";
	}

	// ǰ���������
	public void preOrder() {
		System.out.println(this);// ������ڵ�
		if (this.left != null) {
			this.left.preOrder();
		}
		if (this.right != null) {
			this.right.preOrder();
		}
	}

	public void infixOrder() {
		if (this.left != null) {
			this.left.infixOrder();
		}
		System.out.println(this);// ������ڵ�
		if (this.right != null) {
			this.right.infixOrder();
		}
	}

	public void postOrder() {
		if (this.left != null) {
			this.left.postOrder();
		}
		if (this.right != null) {
			this.right.postOrder();
		}

		System.out.println(this);// ������ڵ�
	}

	public HeroNode preOrderSearch(int no) {
		System.out.println("����ǰ�����");
		// �Ƚϵ�ǰ����ǲ���
		if (this.no == no) {
			return this;
		}
		// 1.���жϵ�ǰ�������ӽڵ��Ƿ�Ϊ�գ������Ϊ�գ���ݹ�ǰ�����
		// 2.�����ݹ�ǰ����ң��ҵ���㣬�򷵻�
		HeroNode resNode = null;
		if (this.left != null) {
			resNode = this.left.preOrderSearch(no);
		}
		if (resNode != null) {// ˵�������������ҵ�
			return resNode;
		}
		// 1.��ݹ�ǰ����ң��ҵ���㣬�򷵻أ�������жϣ�
		// 2.��ǰ�Ľ������ӽڵ��Ƿ�Ϊ�գ�������գ���������ҵݹ�ǰ�����
		if (this.right != null) {
			resNode = this.right.preOrderSearch(no);
		}
		return resNode;
	}

	// �����������
	public HeroNode infixOrderSearch(int no) {
		// �жϵ�ǰ�������ӽڵ��Ƿ�Ϊ�գ������Ϊ�գ���ݹ��������
		HeroNode resNode = null;
		if (this.left != null) {
			resNode = this.left.infixOrderSearch(no);
		}
		if (resNode != null) {
			return resNode;
		}
		System.out.println("�����������");
		// ����ҵ����򷵻أ����û���ҵ����ͺ͵�ǰ���Ƚϣ�������򷵻ص�ǰ���
		if (this.no == no) {
			return this;
		}
		// ������������ҵݹ���������
		if (this.right != null) {
			resNode = this.right.infixOrderSearch(no);
		}
		return resNode;

	}
	

	// �����������
	public HeroNode postOrderSearch(int no) {

		// �жϵ�ǰ�������ӽڵ��Ƿ�Ϊ�գ������Ϊ�գ���ݹ�������
		HeroNode resNode = null;
		if (this.left != null) {
			resNode = this.left.postOrderSearch(no);
		}
		if (resNode != null) {// ˵�����������ҵ�
			return resNode;
		}

		// ���������û���ҵ��������������ݹ���к����������
		if (this.right != null) {
			resNode = this.right.postOrderSearch(no);
		}
		if (resNode != null) {
			return resNode;
		}
		System.out.println("����������");
		// �������������û���ҵ����ͱȽϵ�ǰ����ǲ���
		if (this.no == no) {
			return this;
		}
		return resNode;
	}

	public void delNode(int no) {
		if (this.left != null && this.left.no == no) {
			this.left = null;
			return;
		}
		if (this.right != null && this.right.no == no) {
			this.right = null;
			return;
		}
		if (this.left != null) {
			this.left.delNode(no);
		}
		if (this.right != null) {
			this.right.delNode(no);
		}

	}
}