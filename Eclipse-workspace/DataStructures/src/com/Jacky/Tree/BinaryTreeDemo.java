package com.Jacky.Tree;


public class BinaryTreeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree binaryTree = new BinaryTree();
		HeroNode root = new HeroNode(1, "a");
		HeroNode node2 = new HeroNode(2, "b");
		HeroNode node3 = new HeroNode(3, "c");
		HeroNode node4 = new HeroNode(4, "d");
		HeroNode node5 = new HeroNode(5, "e");

		root.setLeft(node2);
		root.setRight(node3);
		node3.setRight(node4);
		node3.setLeft(node5);
		binaryTree.setRoot(root);
		System.out.println("pre");
		binaryTree.preOrder();
		System.out.println("inf");
		binaryTree.infixOrder();
		System.out.println("pos");
		binaryTree.postOrder();

		System.out.println(binaryTree.preOrdersearch(2));
		System.out.println(binaryTree.infixOrdersearch(3));
		System.out.println(binaryTree.postOrdersearch(6));
		
		binaryTree.delNode(3);
		binaryTree.infixOrder();


	}

}

//二叉树
class BinaryTree {
	private HeroNode root;

	public void setRoot(HeroNode root) {
		this.root = root;
	}

	// 前序遍历
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
		if(root!=null) {
			//先判断根节点是不是要删除的
			if(root.getNo()==no) {
				root=null;
			}
			root.delNode(no);
		}else {
			System.out.println("Null Tree");
		}
	}
	

}

//节点
class HeroNode {
	private int no;
	private String name;
	private HeroNode left;
	private HeroNode right;

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

	// 前序遍历方法
	public void preOrder() {
		System.out.println(this);// 输出父节点
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
		System.out.println(this);// 输出父节点
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

		System.out.println(this);// 输出父节点
	}

	public HeroNode preOrderSearch(int no) {
		System.out.println("进入前序遍历");
		// 比较当前结点是不是
		if (this.no == no) {
			return this;
		}
		// 1.则判断当前结点的左子节点是否为空，如果不为空，则递归前序查找
		// 2.如果左递归前序查找，找到结点，则返回
		HeroNode resNode = null;
		if (this.left != null) {
			resNode = this.left.preOrderSearch(no);
		}
		if (resNode != null) {// 说明我们左子树找到
			return resNode;
		}
		// 1.左递归前序查找，找到结点，则返回，否继续判断，
		// 2.当前的结点的右子节点是否为空，如果不空，则继续向右递归前序查找
		if (this.right != null) {
			resNode = this.right.preOrderSearch(no);
		}
		return resNode;
	}

	// 中序遍历查找
	public HeroNode infixOrderSearch(int no) {
		// 判断当前结点的左子节点是否为空，如果不为空，则递归中序查找
		HeroNode resNode = null;
		if (this.left != null) {
			resNode = this.left.infixOrderSearch(no);
		}
		if (resNode != null) {
			return resNode;
		}
		System.out.println("进入中序查找");
		// 如果找到，则返回，如果没有找到，就和当前结点比较，如果是则返回当前结点
		if (this.no == no) {
			return this;
		}
		// 否则继续进行右递归的中序查找
		if (this.right != null) {
			resNode = this.right.infixOrderSearch(no);
		}
		return resNode;

	}

	// 后序遍历查找
	public HeroNode postOrderSearch(int no) {

		// 判断当前结点的左子节点是否为空，如果不为空，则递归后序查找
		HeroNode resNode = null;
		if (this.left != null) {
			resNode = this.left.postOrderSearch(no);
		}
		if (resNode != null) {// 说明在左子树找到
			return resNode;
		}

		// 如果左子树没有找到，则向右子树递归进行后序遍历查找
		if (this.right != null) {
			resNode = this.right.postOrderSearch(no);
		}
		if (resNode != null) {
			return resNode;
		}
		System.out.println("进入后序查找");
		// 如果左右子树都没有找到，就比较当前结点是不是
		if (this.no == no) {
			return this;
		}
		return resNode;
	}
	
	public void delNode(int no) {
		if(this.left!=null&&this.left.no==no) {
			this.left=null;
			return;
		}
		if(this.right!=null&&this.right.no==no) {
			this.right=null;
			return;
		}
		if(this.left!=null) {
			this.left.delNode(no);
		}
		if(this.right!=null) {
			this.right.delNode(no);
		}
		
	}
	

}