package Greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class greedyAlgorithm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ������̨����
		HashMap<String, HashSet<String>> broadcast = new HashMap<String, HashSet<String>>();


		HashSet<String> hashSet1 =new HashSet<String>();
		hashSet1.add("����");
		hashSet1.add("�Ϻ�");
		hashSet1.add("���");
		HashSet<String> hashSet2 =new HashSet<String>();
		hashSet2.add("����");
		hashSet2.add("����");
		hashSet2.add("����");
		HashSet<String> hashSet3 = new HashSet<String>();
		hashSet3.add("�ɶ�");
		hashSet3.add("�Ϻ�");
		hashSet3.add("����");
		HashSet<String> hashSet4 =new HashSet<String>();
		hashSet4.add("�Ϻ�");
		hashSet4.add("���");
		HashSet<String> hashSet5 =new HashSet<String>();
		hashSet5.add("����");
		hashSet5.add("����");

		broadcast.put("K1", hashSet1);
		broadcast.put("K2", hashSet2);
		broadcast.put("K3", hashSet3);
		broadcast.put("K4", hashSet4);
		broadcast.put("K5", hashSet5);

		// ������е���
		HashSet<String> allAreas = new HashSet<String>();
		allAreas.add("����");
		allAreas.add("���");
		allAreas.add("�Ϻ�");
		allAreas.add("����");
		allAreas.add("����");
		allAreas.add("����");
		allAreas.add("�ɶ�");
		allAreas.add("����");

		// ���ѡ��ĵ�̨�ڵ㣬���������Ҫ�Ľ��
		ArrayList<String> selects = new ArrayList<String>();

		// ������ʱ���ϣ���ŵ�̨���ǵĵ�����û�и��ǵ����Ľ���
		HashSet<String> tempSet = new HashSet<String>();

		// maxKey,�����ܸ������δ���ǵ����ĵ�̨�����������Ҫ�Ľ����
		String maxKey = null;
		while (allAreas.size() != 0) {// ��ʾ��û���и���

			maxKey = null;

			for (String key : broadcast.keySet()) {

				tempSet.clear();

				HashSet<String> areas = broadcast.get(key);
				tempSet.addAll(areas);
				// ���tempSet��allAreas���ϵĽ���
				tempSet.retainAll(allAreas);
				// ���δ���ǵ�����������maxKeyָ��ļ��ϵ������࣬����maxKey
				if (tempSet.size() > 0 && (maxKey == null || tempSet.size() > broadcast.get(maxKey).size())) {
					maxKey = key;
				}

			}
			if (maxKey != null) {
				selects.add(maxKey);
				// maxKeyָ��ĵ�����allAreas���
				allAreas.removeAll(broadcast.get(maxKey));

			}

		}

		System.out.println("Result"+ selects);
		
	}

}
