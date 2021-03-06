package leetcodeanswer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _30串联所有单词的子串 {

	public static void main(String[] args) {
		String s = "barfoothefoobarman";
		String[] words = { "foo", "bar" };
		Solution30 sl = new Solution30();
		List<Integer> list = sl.findSubstring(s, words);
		System.out.println(list.toString());

	}

}

class Solution30 {
	
	public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        if (words.length == 0 || s.length() < words.length * words[0].length()) {
            return list;
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }
        int listLen = words.length;
        int wordLen = words[0].length();

        for (int i = 0; i < wordLen; i++) {
            for (int j = i; j <= s.length() - wordLen * listLen; j += wordLen) {
                Map<String, Integer> map2 = new HashMap<>();
                for (int k = listLen - 1; k >= 0; k--) {
                    String temp = s.substring(j + k * wordLen, j + (k + 1) * wordLen);
                    int val = map2.getOrDefault(temp, 0) + 1;
                    if (val > map.getOrDefault(temp, 0)) {
                        j += k * wordLen;
                        break;
                    }
                    if (k == 0) {
                        list.add(j);
                    } else {
                        map2.put(temp, val);
                    }
                }
            }
        }
        return list;
    }
	
	
//	public List<Integer> findSubstring(String s, String[] words) {
//	    List<Integer> res = new ArrayList<Integer>();
//	    int wordNum = words.length;
//	    if (wordNum == 0) {
//	        return res;
//	    }
//	    int wordLen = words[0].length();
//	    HashMap<String, Integer> allWords = new HashMap<String, Integer>();
//	    for (String w : words) {
//	        int value = allWords.getOrDefault(w, 0);
//	        allWords.put(w, value + 1);
//	    }
//	    //将所有移动分成 wordLen 类情况
//	    for (int j = 0; j < wordLen; j++) {
//	        HashMap<String, Integer> hasWords = new HashMap<String, Integer>();
//	        int num = 0; //记录当前 HashMap2（这里的 hasWords 变量）中有多少个单词
//			//每次移动一个单词长度
//	        for (int i = j; i < s.length() - wordNum * wordLen + 1; i = i + wordLen) {
//	            boolean hasRemoved = false; //防止情况三移除后，情况一继续移除
//	            while (num < wordNum) {
//	                String word = s.substring(i + num * wordLen, i + (num + 1) * wordLen);
//	                if (allWords.containsKey(word)) {
//	                    int value = hasWords.getOrDefault(word, 0);
//	                    hasWords.put(word, value + 1);
//	                    //出现情况三，遇到了符合的单词，但是次数超了
//	                    if (hasWords.get(word) > allWords.get(word)) {
//	                        // hasWords.put(word, value);
//	                        hasRemoved = true;
//	                        int removeNum = 0;
//	                        //一直移除单词，直到次数符合了
//	                        while (hasWords.get(word) > allWords.get(word)) {
//	                            String firstWord = s.substring(i + removeNum * wordLen, i + (removeNum + 1) * wordLen);
//	                            int v = hasWords.get(firstWord);
//	                            hasWords.put(firstWord, v - 1);
//	                            removeNum++;
//	                        }
//	                        num = num - removeNum + 1; //加 1 是因为我们把当前单词加入到了 HashMap 2 中
//	                        i = i + (removeNum - 1) * wordLen; //这里依旧是考虑到了最外层的 for 循环，看情况二的解释
//	                        break;
//	                    }
//	                //出现情况二，遇到了不匹配的单词，直接将 i 移动到该单词的后边（但其实这里
//	                //只是移动到了出现问题单词的地方，因为最外层有 for 循环， i 还会移动一个单词
//	                //然后刚好就移动到了单词后边）
//	                } else {
//	                    hasWords.clear();
//	                    i = i + num * wordLen;
//	                    num = 0;
//	                    break;
//	                }
//	                num++;
//	            }
//	            if (num == wordNum) {
//	                res.add(i);
//
//	            }
//	            //出现情况一，子串完全匹配，我们将上一个子串的第一个单词从 HashMap2 中移除
//	            if (num > 0 && !hasRemoved) {
//	                String firstWord = s.substring(i, i + wordLen);
//	                int v = hasWords.get(firstWord);
//	                hasWords.put(firstWord, v - 1);
//	                num = num - 1;
//	            }
//
//	        }
//
//	    }
//	    return res;
//	}

	
	
//	public List<Integer> findSubstring(String s, String[] words) {
//		List<Integer> list = new ArrayList<Integer>();
//		if (words.length == 0)
//			return list;
//		Map<String, Integer> map = new HashMap<String, Integer>();
//		for (int i = 0; i < words.length; i++) {
//			if (map.containsKey(words[i]))
//				map.replace(words[i], map.get(words[i]) + 1);
//			else {
//				map.put(words[i], 1);
//			}
//		}
//		int wordlens = words[0].length();
//		for (int i = 0; i < s.length() - wordlens * words.length + 1; i++) {
//			Map<String, Integer> temp = new HashMap<>();
//			int num = 0;
//			while (num < words.length) {
//				String tempword = s.substring(i + num * wordlens, i + (num + 1) * wordlens);
//				if (map.containsKey(tempword)) {
//					int value = temp.getOrDefault(tempword, 0);
//					temp.put(tempword, value + 1);
//					if (temp.get(tempword) > map.get(tempword)) {
//						break;
//					}
//				} else {
//					break;
//				}
//				num++;
//			}
//			if (num == words.length) {
//				list.add(i);
//			}
//
//		}
//
//		return list;
//	}
}