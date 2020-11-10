package com.bq;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class deom01 {

	public static void main(String[] args) throws InterruptedException {
//		test01();
//		test02();
//		test03();
		test04();
	}

	// 抛出异常
	public static void test01() {
		ArrayBlockingQueue<Integer> bq = new ArrayBlockingQueue<>(5);

		System.out.println(bq.add(1));
		System.out.println(bq.add(2));
		System.out.println(bq.add(3));
		System.out.println(bq.add(4));
		System.out.println(bq.add(5));
//		System.out.println(bq.add(1));   java.lang.IllegalStateException: Queue full

		System.out.println("=============");
		System.out.println(bq.remove());
		System.out.println(bq.remove());
		System.out.println(bq.remove());
		System.out.println(bq.remove());
		System.out.println(bq.remove());
//		System.out.println(bq.remove());   java.util.NoSuchElementException
	}

	// 有返回值
	public static void test02() {
		ArrayBlockingQueue<String> bq = new ArrayBlockingQueue<String>(3);
		System.out.println(bq.offer("abc"));
		System.out.println(bq.offer("defabc"));
		System.out.println(bq.offer("abcokm"));
//		System.out.println(bq.offer("abcdsa"));   false

		System.out.println("==================");
		System.out.println(bq.poll());
		System.out.println(bq.poll());
		System.out.println(bq.poll());
//		System.out.println(bq.poll());        null
		
		System.out.println("===================");
		System.out.println(bq.peek());
   	}
	
	//阻塞等待
	public static void test03() throws InterruptedException {
		ArrayBlockingQueue<String> bq=new ArrayBlockingQueue<String>(3);
		
		bq.put("a");
		bq.put("b");
		bq.put("c");
//		bq.put("d");
		System.out.println("=====");
		
		System.out.println(bq.take());
		System.out.println(bq.take());
		System.out.println(bq.take());
		System.out.println(bq.take());
		System.out.println("*/*");
	}
	
	//超时等待
	public static void test04() throws InterruptedException {
		ArrayBlockingQueue<String> bq=new ArrayBlockingQueue<String>(3);
		System.out.println(bq.offer("abv", 2, TimeUnit.SECONDS));
		System.out.println(bq.offer("as", 2, TimeUnit.SECONDS));
		System.out.println(bq.offer("aasfv", 2, TimeUnit.SECONDS));
//		System.out.println(bq.offer("saf", 2, TimeUnit.SECONDS));
		System.out.println("=====");
		
		System.out.println(bq.poll(2, TimeUnit.SECONDS));
		System.out.println(bq.poll(2, TimeUnit.SECONDS));
		System.out.println(bq.poll(2, TimeUnit.SECONDS));
		System.out.println(bq.poll(5, TimeUnit.SECONDS));
		System.out.println("***");
	}
}
