package leetcodeanswer;

public class _383����� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution383 sl = new Solution383();
		System.out.println(sl.canConstruct("aaaa", "abaa"));
		
		
	}

}


//�������б���������ϵͳ�������Ѱ������ʱ��
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




//���ַ�
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