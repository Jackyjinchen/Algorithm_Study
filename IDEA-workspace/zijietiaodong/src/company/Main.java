package company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        Solution sl=new Solution();
        System.out.println((int)sl.uppertri(n-1)%1000000007);


    }
}

class Solution{


    public long uppertri(long n){
        if(n==0)
            return 3;
        else{
            long count=0;
            count=uppertri(n-1)*3+downtri(n-1);
            return count;
        }
    }

    public long downtri(long n){
        if(n==0)
            return 1;
        else{
            long count=0;
            count=downtri(n-1)*3+uppertri(n-1);
            return count;
        }

    }


}