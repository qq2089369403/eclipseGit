package com.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class demo02 {

	public static void main(String[] args) {
		System.out.println(Runtime.getRuntime().availableProcessors());
		ExecutorService threadPool=new ThreadPoolExecutor(
				2, //核心线程数
				5, //最大线程数
				3, //
				TimeUnit.SECONDS, //单位
				new LinkedBlockingDeque<>(3), //阻塞队列
				Executors.defaultThreadFactory(), //线程工厂
				new ThreadPoolExecutor.AbortPolicy());//拒绝策略 
		
		try {
			for (int i = 0; i < 12; i++) {
				int temp=i;
				threadPool.execute(()->{
					System.out.println(Thread.currentThread().getName()+"***"+temp);
				});
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			threadPool.shutdown();
		}
	}

}
