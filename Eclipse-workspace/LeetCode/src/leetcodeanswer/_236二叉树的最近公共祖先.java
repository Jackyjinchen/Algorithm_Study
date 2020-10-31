package leetcodeanswer;



public class _236二叉树的最近公共祖先 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


class Solution236 {
	
	TreeNode263 p;
	TreeNode263 q;
	TreeNode263 ans;
	
    public TreeNode263 lowestCommonAncestor(TreeNode263 root, TreeNode263 p, TreeNode263 q) {
        this.p=p;
        this.q=q;
    	recurseTree(root);
    	
    	return this.ans;
    }
    
    public boolean recurseTree( TreeNode263 crr ) {
		
    	if(crr==null) {
    		return false;
    	}    	
    	int left=recurseTree(crr.left)?1:0;
    	int right=recurseTree(crr.right)?1:0;
    	int mid=0;
    	if (crr==p||crr==q) {
    		mid=1;	
		}
    	if (mid+left+right>=2) {
			this.ans=crr;
		}
    	
    	return(mid+left+right>0);

	}      
}


 


  class TreeNode263 {
     int val;
     TreeNode263 left;
     TreeNode263 right;
     TreeNode263(int x) { val = x; }
//     public void print() {
//       	 print(this);
//        }
        
//        public void print(TreeNode263 root) {
//    		while (root!=null) {
//    			System.out.print(root.val+"->");
//    			root=root.next;
//    		}
//    		System.out.println();
//    	}
     
     
  }
 