package leetcodeanswer;

public class _383赎金信 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution383 sl = new Solution383();
		System.out.println(sl.canConstruct("aaaa", "abaa"));
		
		
	}

}


//可以自行遍历，不用系统函数多次寻找增加时间
//class Solution383 {
//    public boolean canConstruct(String ransomNote, String magazine) {
//        int[] buckets = new int[26];
//        for(int i = 0; i < magazine.length(); i++) {
//            buckets[magazine.charAt(i) - 'a']++;
//        }
//        for(int i = 0; i < ransomNote.length(); i++) {
//            if(--buckets[ransomNote.charAt(i) - 'a'] < 0) {
//                return false;
//            }
//        }
//        return true;
//    }
//}




//找字符
class Solution383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        
    	for (int i = 0; i < ransomNote.length(); i++) {
    		char ch=ransomNote.charAt(i);
			if(magazine.indexOf(ch)!=-1) {
				magazine=magazine.replaceFirst(ch+"", "");
			}else {
				return false;
			}
		}
    	return true;
    }
}