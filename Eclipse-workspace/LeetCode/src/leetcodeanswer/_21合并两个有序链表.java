package leetcodeanswer;


public class _21合并两个有序链表 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode21 node1=new ListNode21(1);
		ListNode21 node2=new ListNode21(2);
		ListNode21 node3=new ListNode21(4);
		node1.next=node2;
		node2.next=node3;
		
		
		ListNode21 node4=new ListNode21(1);
		ListNode21 node5=new ListNode21(3);
		ListNode21 node6=new ListNode21(4);
		node4.next=node5;
		node5.next=node6;
		
		node1.print();
		node4.print();
		
		Solution21 sl = new Solution21();
		
		sl.mergeTwoLists(node1, node4).print();
		
	}

}



//采用递归方式
class Solution21 {
  public ListNode21 mergeTwoLists(ListNode21 l1, ListNode21 l2) {
  	if(l1==null)
  		return l2;
  	else if(l2==null)
  		return l1;
  	else if (l1.val>l2.val) {
			l2.next=mergeTwoLists(l1, l2.next);
			return l2;
		}else {
			l1.next=mergeTwoLists(l1.next, l2);
			return l1;
		}
      

  }
}




////采用递归方式
//class Solution21 {
//    public ListNode21 mergeTwoLists(ListNode21 l1, ListNode21 l2) {
//    	if(l1==null)
//    		return l2;
//    	else if(l2==null)
//    		return l1;
//    	else if (l1.val>l2.val) {
//			l2.next=mergeTwoLists(l1, l2.next);
//			return l2;
//		}else {
//			l1.next=mergeTwoLists(l1.next, l2);
//			return l1;
//		}
//        
//
//    }
//}



  class ListNode21 {
     int val;
     ListNode21 next;
     ListNode21(int x) { val = x; }
     
     public void print() {
    	 print(this);
     }
     
     public void print(ListNode21 root) {
		while (root!=null) {
			System.out.print(root.val+"->");
			root=root.next;
		}
		System.out.println();
	}
     
     
 }
  

  

  
  
  
//  class Solution21 {
//	    public ListNode21 mergeTwoLists(ListNode21 l1, ListNode21 l2) {
//	    	ListNode21 list = new ListNode21(0);
//	        ListNode21 pointer = list;
////	      ListNode21 temp = null;
//	        while (true) {
//	            if (l1 == null && l2 == null) {
//	                return list.next;
//	            } else if (l2 == null && l1 != null) {
//	                pointer.next=l1;
//	                return list.next;
//	            }else if (l1 == null && l2 != null) {
//	                pointer.next=l2;
//	                return list.next;
//	            }else {
//	                if (l1.val<l2.val) {
//	                    pointer.next=new ListNode21(l1.val);
//	                    pointer=pointer.next;
//	                    l1=l1.next;
//	                }else {
//	                    pointer.next=new ListNode21(l2.val);
//	                    pointer=pointer.next;
//	                    l2=l2.next;
//	                }
//	            }
//	        }
//	    }
//	}