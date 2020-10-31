package av64213436;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;


public class ArraylistUnsafe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		List<String> list =new ArrayList<>();
		
		
		//Vector中加了synchronized锁
//		List<String> list =new Vector<String>();
		
		//Collections中有同步方法 实现安全性
//		List<String> list =Collections.synchronizedList(new ArrayList<>());
		
		//CopyOnWrite
		List<String> list =new CopyOnWriteArrayList<String>();

		
		list.add("a");
		System.out.println(list);

		for (int i = 0; i < 100; i++) {

			new Thread(() -> {
				list.add(UUID.randomUUID().toString().substring(0,8));
				System.out.println(list);
			},String.valueOf(i)).start();

		}

	}

}
