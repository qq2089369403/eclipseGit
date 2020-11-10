package com.unsafe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListTest {

	public static void main(String[] args) {
//		List<String> list=new ArrayList<String>();
//		List<String> list=new Vector<String>();
//		List<String> list=Collections.synchronizedList(new ArrayList<String>());
		List<String> list=new CopyOnWriteArrayList<String>();
		/**
		 * 1、解决方案    List<String> list=new Vector<String>();
		 * 2、List<String> list=Collections.synchronizedList(new ArrayList<String>());
		 * 3、List<String> list=new CopyOnWriteArrayList<String>();
		 * */
		
		//CopyOnWrite 写入时复制   COM计算机程序一种优化策略
		//多个线程，list，读取时，固定的；写入时（覆盖），造成数据问题
		
		for (int i = 0; i < 5; i++) {
			new Thread(()->{
				list.add(UUID.randomUUID().toString().substring(0,4));
				System.out.println(list);
			}).start();
		}
	}

}
