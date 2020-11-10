package com.unsafe;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArraySet;

public class SetList {
	public static void main(String[] args) {
		Set<String> set=new HashSet<String>();  //不安全
//		Set<String> set=Collections.synchronizedSet(new HashSet<String>());
//		Set<String> set=new CopyOnWriteArraySet<String>();
		for (int i = 0; i < 20; i++) {
			new Thread(()->{
					set.add(UUID.randomUUID().toString().substring(1, 4));
					System.out.println(set);
					}).start();
		}
	}

}
