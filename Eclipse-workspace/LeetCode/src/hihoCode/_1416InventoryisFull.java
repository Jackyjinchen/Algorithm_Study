package hihoCode;
import java.util.*;

public class _1416InventoryisFull{
   static class Node{
       int value;
       int num;
       public Node(int value,int num){
           this.value=value;
           this.num=num;
       }
   }

   public static void main(String[] args) {
       Scanner in=new Scanner(System.in);
       int n=in.nextInt();
       int m=in.nextInt();
       int arr[][]=new int[3][m];
       for (int i = 0; i <3 ; i++) {
           for (int j = 0; j <m ; j++) {
               arr[i][j]=in.nextInt();
           }
       }
       int amount[]=arr[0];
       int value[]=arr[1];
       int maxStack[]=arr[2];

       PriorityQueue<Node> priorityQueue=new PriorityQueue<>(new Comparator<Node>() {
           @Override
           public int compare(Node o1, Node o2) {
               return o2.value-o1.value;
           }
       });
       for (int i = 0; i < m; i++) {
           int count1=amount[i]/maxStack[i];
           int v1=maxStack[i]*value[i];
           int v2=(amount[i]%maxStack[i])*value[i];
           priorityQueue.add(new Node(v1,count1));
           if(v2!=0)
               priorityQueue.add(new Node(v2,1));
       }

       long max=0;
       while (priorityQueue.size()>0 && n>0){
           Node node=priorityQueue.poll();
           int c=Integer.min(node.num,n);
           max+=(node.value*(long)c);
           n-=c;
       }
       System.out.println(max);

   }
}
