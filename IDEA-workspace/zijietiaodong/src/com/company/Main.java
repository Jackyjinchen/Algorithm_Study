package com.company;

import javax.swing.plaf.SliderUI;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();



        int[] a = new int[n];
        int[][] map=new int[n][n];
        for (int i = 1; i <= n; i++) {
            a[i-1] = sc.nextInt();
        }

        if(m==0){
            int max=0;
            for (int i = 0; i <n ; i++) {
                max=Math.max(a[i],max);
            }
            System.out.println(max);
            return;
        }

        for (int i = 0; i < m; i++) {
            int tempx=sc.nextInt();
            int tempy=sc.nextInt();
            map[tempx-1][tempy-1]=1;
            map[tempy-1][tempx-1]=1;
        }

        Solution sl=new Solution();
        int max=sl.findmaxnum(map,a);
        System.out.println(max);


    }
}

class Solution{

    private int max=0;

    public int findmaxnum(int[][] map,int[] a){
        int[] find=new int[map.length];
        int count=0;
        for (int i = 0; i <map.length ; i++) {
            if(find[i]==0){
                dfs(map,find,i,a);
//                count++;
            }
        }

        for (int i = 0; i <map.length ; i++) {
            max=Math.max(find[i],max);
        }

        return max;
    }

    public void dfs(int[][] map,int[] find,int i,int[] a){
        for (int j = 0; j < map.length; j++) {
            if(map[i][j]!=0&&find[j]==0){
                find[j]=a[i]+a[j];
                find[i]=a[i]+a[j];
                dfs(map,find,j,a);
            }
        }
    }


}