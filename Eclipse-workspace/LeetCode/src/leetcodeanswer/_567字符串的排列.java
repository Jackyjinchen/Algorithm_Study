package leetcodeanswer;

import java.util.Arrays;


public class _567×Ö·û´®µÄÅÅÁĞ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1="adc";
		String s2="dcda";
		Solution567 sl = new Solution567();
		
		
		System.out.println(sl.checkInclusion(s1, s2));
	}

}

class Solution567 {
    public boolean checkInclusion(String s1, String s2) {
    	if(s1.length()>s2.length()) return false;
        int[] s1map=new int[26];
        int[] s2map=new int[26];   
        int lens=s1.length();
        
        for (int i = 0; i < s1.length(); i++) {
			s1map[s1.charAt(i)-'a']++;
			s2map[s2.charAt(i)-'a']++;
		}
        

        for (int i = 0; i < s2.length()-s1.length(); i++) {
			if(Arrays.equals(s1map, s2map)) {
				return true;
			}else {
				s2map[s2.charAt(i)-'a']--;
				s2map[s2.charAt(i+lens)-'a']++;
			}
		}
        
	
    	return false;
    }



}