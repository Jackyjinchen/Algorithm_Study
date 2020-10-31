package leetcodeanswer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _30�������е��ʵ��Ӵ� {

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
//	    //�������ƶ��ֳ� wordLen �����
//	    for (int j = 0; j < wordLen; j++) {
//	        HashMap<String, Integer> hasWords = new HashMap<String, Integer>();
//	        int num = 0; //��¼��ǰ HashMap2������� hasWords ���������ж��ٸ�����
//			//ÿ���ƶ�һ�����ʳ���
//	        for (int i = j; i < s.length() - wordNum * wordLen + 1; i = i + wordLen) {
//	            boolean hasRemoved = false; //��ֹ������Ƴ������һ�����Ƴ�
//	            while (num < wordNum) {
//	                String word = s.substring(i + num * wordLen, i + (num + 1) * wordLen);
//	                if (allWords.containsKey(word)) {
//	                    int value = hasWords.getOrDefault(word, 0);
//	                    hasWords.put(word, value + 1);
//	                    //����������������˷��ϵĵ��ʣ����Ǵ�������
//	                    if (hasWords.get(word) > allWords.get(word)) {
//	                        // hasWords.put(word, value);
//	                        hasRemoved = true;
//	                        int removeNum = 0;
//	                        //һֱ�Ƴ����ʣ�ֱ������������
//	                        while (hasWords.get(word) > allWords.get(word)) {
//	                            String firstWord = s.substring(i + removeNum * wordLen, i + (removeNum + 1) * wordLen);
//	                            int v = hasWords.get(firstWord);
//	                            hasWords.put(firstWord, v - 1);
//	                            removeNum++;
//	                        }
//	                        num = num - removeNum + 1; //�� 1 ����Ϊ���ǰѵ�ǰ���ʼ��뵽�� HashMap 2 ��
//	                        i = i + (removeNum - 1) * wordLen; //���������ǿ��ǵ��������� for ѭ������������Ľ���
//	                        break;
//	                    }
//	                //����������������˲�ƥ��ĵ��ʣ�ֱ�ӽ� i �ƶ����õ��ʵĺ�ߣ�����ʵ����
//	                //ֻ���ƶ����˳������ⵥ�ʵĵط�����Ϊ������� for ѭ���� i �����ƶ�һ������
//	                //Ȼ��պþ��ƶ����˵��ʺ�ߣ�
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
//	            //�������һ���Ӵ���ȫƥ�䣬���ǽ���һ���Ӵ��ĵ�һ�����ʴ� HashMap2 ���Ƴ�
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