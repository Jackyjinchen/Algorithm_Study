package Greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class greedyAlgorithm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 创建电台集合
		HashMap<String, HashSet<String>> broadcast = new HashMap<String, HashSet<String>>();


		HashSet<String> hashSet1 =new HashSet<String>();
		hashSet1.add("北京");
		hashSet1.add("上海");
		hashSet1.add("天津");
		HashSet<String> hashSet2 =new HashSet<String>();
		hashSet2.add("广州");
		hashSet2.add("北京");
		hashSet2.add("深圳");
		HashSet<String> hashSet3 = new HashSet<String>();
		hashSet3.add("成都");
		hashSet3.add("上海");
		hashSet3.add("杭州");
		HashSet<String> hashSet4 =new HashSet<String>();
		hashSet4.add("上海");
		hashSet4.add("天津");
		HashSet<String> hashSet5 =new HashSet<String>();
		hashSet5.add("杭州");
		hashSet5.add("大连");

		broadcast.put("K1", hashSet1);
		broadcast.put("K2", hashSet2);
		broadcast.put("K3", hashSet3);
		broadcast.put("K4", hashSet4);
		broadcast.put("K5", hashSet5);

		// 存放所有地区
		HashSet<String> allAreas = new HashSet<String>();
		allAreas.add("北京");
		allAreas.add("天津");
		allAreas.add("上海");
		allAreas.add("深圳");
		allAreas.add("杭州");
		allAreas.add("大连");
		allAreas.add("成都");
		allAreas.add("广州");

		// 存放选择的电台节点，就是最后需要的结果
		ArrayList<String> selects = new ArrayList<String>();

		// 定义临时集合，存放电台覆盖的地区和没有覆盖地区的交集
		HashSet<String> tempSet = new HashSet<String>();

		// maxKey,保存能覆盖最大未覆盖地区的电台。将其放入需要的结果中
		String maxKey = null;
		while (allAreas.size() != 0) {// 表示还没法有覆盖

			maxKey = null;

			for (String key : broadcast.keySet()) {

				tempSet.clear();

				HashSet<String> areas = broadcast.get(key);
				tempSet.addAll(areas);
				// 求出tempSet和allAreas集合的交集
				tempSet.retainAll(allAreas);
				// 如果未覆盖地区的数量比maxKey指向的集合地区还多，重置maxKey
				if (tempSet.size() > 0 && (maxKey == null || tempSet.size() > broadcast.get(maxKey).size())) {
					maxKey = key;
				}

			}
			if (maxKey != null) {
				selects.add(maxKey);
				// maxKey指向的地区从allAreas清楚
				allAreas.removeAll(broadcast.get(maxKey));

			}

		}

		System.out.println("Result"+ selects);
		
	}

}
