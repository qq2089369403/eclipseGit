package com.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 异步调用：CompletableFuture 异步执行 成功回调 失败回调
 */
public class demo01 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		// 发送请求
//		CompletableFuture<Void> future=new CompletableFuture<Void>();
//		future.runAsync(()->{
//			try {
//				TimeUnit.SECONDS.sleep(2);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			System.out.println(Thread.currentThread().getName()+"runAsync");
//		});
//		System.out.println(future.get());//获得阻塞执行结果

		CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
			System.out.println(Thread.currentThread().getName() + "supplyAsync");
			int i=10/0;
			return 1024;
		});

		System.out.println("123hhhh");

		System.out.println(future.whenComplete((t, u) -> {
			System.out.println("t=" + t);//正常的返回结果
			System.out.println("u=" + u);//错误的返回结果
		}).exceptionally((e) -> {
			System.out.println(e.getMessage());
			return 256;//失败时的返回结果
		}).get());

	}

}
