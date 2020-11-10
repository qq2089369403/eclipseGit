package com.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class demo01 {

	public static void main(String[] args) {
//		ExecutorService threadPool=Executors.newSingleThreadExecutor();//单个线程
//		ExecutorService threadPool=Executors.newFixedThreadPool(4);//创建一个固定大小的线程池
		ExecutorService threadPool=Executors.newCachedThreadPool();//可伸缩的
		
		try {
			for (int i = 0; i < 10; i++) {
				threadPool.execute(()->{
					System.out.println(Thread.currentThread().getName()+"***");
				});
				}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			threadPool.shutdown();
		}
	}

}
