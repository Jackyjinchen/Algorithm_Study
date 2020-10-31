package leetcodeanswer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _17电话号码的字母组合 {

	public static void main(String[] args) {
		Solution17 sl = new Solution17();
		List<String> list=sl.letterCombinations("27");
		System.out.println(list.toString());
		
	}

}

class Solution17 {
	Map<String, String> phone = new HashMap<String, String>() {{
	    put("2", "abc");
	    put("3", "def");
	    put("4", "ghi");
	    put("5", "jkl");
	    put("6", "mno");
	    put("7", "pqrs");
	    put("8", "tuv");
	    put("9", "wxyz");
	  }};
	
	List<String> ans=new ArrayList<String>();
	
    public List<String> letterCombinations(String digits) {
    	if(digits.length()!=0)
    		backtrack("", digits);
    	return ans;
    }
    
    public void backtrack(String commbination,String nextdigits) {
		if(nextdigits.length()==0)
			ans.add(commbination);
		else {
			String digit=nextdigits.substring(0,1);
			String letters=phone.get(digit);
			for (int i = 0; i < letters.length(); i++) {
				String letter=phone.get(digit).substring(i,i+1);
				backtrack(commbination+letter, nextdigits.substring(1));
			}
		}
    	
	}
    
}