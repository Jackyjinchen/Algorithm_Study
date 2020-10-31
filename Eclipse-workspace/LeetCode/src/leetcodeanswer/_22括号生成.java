package leetcodeanswer;

import java.util.ArrayList;
import java.util.List;

public class _22À¨ºÅÉú³É {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=5;
		Solution22 sl = new Solution22();
		System.out.println(sl.generateParenthesis(n));
		
	}

}

class Solution22 {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, String cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }

        if (open < max)
            backtrack(ans, cur+"(", open+1, close, max);
        if (close < open)
            backtrack(ans, cur+")", open, close+1, max);
    }
}

