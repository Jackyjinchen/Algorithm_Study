package Nowcoder;


public class _¶þ²æÊ÷µÄ¾µÏñ {
	public static void main(String[] args) {
		TreeNode n8 = new TreeNode(8);
		TreeNode n6 = new TreeNode(6);

		TreeNode n5 = new TreeNode(5);
		TreeNode n7 = new TreeNode(7);
		TreeNode n4 = new TreeNode(4);

		n8.right=n7;
		n7.right=n6;
		n6.right=n5;
		n5.right=n4;

		Solution¶þ²æÊ÷¾µÏñ sl = new Solution¶þ²æÊ÷¾µÏñ();
		sl.Mirror(n8);
		
		return;
	}
}


class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

class Solution¶þ²æÊ÷¾µÏñ {
    public void Mirror(TreeNode root) {
     
    	if (root==null||(root.left==null&&root.right==null)) {
        	return;
		}
        TreeNode temp=null;
        temp=root.right;
        root.right=root.left;
        root.left=temp;  
        
        if (root.left!=null) {
			Mirror(root.left);
		}

        if (root.right!=null) {
			Mirror(root.right);
	        
		}
    	


    	


    }
}