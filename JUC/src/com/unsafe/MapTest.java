package com.unsafe;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class MapTest {

	public static void main(String[] args) {
//       默认等价new HashMap<K,V>(16,0.75)
		Map<String,String> map=new HashMap<String, String>();
//		Map<String,String> map=Collections.synchronizedMap(new HashMap<String,String>());
//		Map<String,String> map=new ConcurrentHashMap<String, String>();
		for (int i = 0; i < 15; i++) {
			new Thread(()->{
				map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 4));
				System.out.println(map);
			},String.valueOf(i)).start();
		}
	}

}
