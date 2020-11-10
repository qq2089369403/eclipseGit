package com.forkJoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class Test {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
//		test1();1872ms
//		test2();
//		test3();191ms
	}
	
	public static void test1() {
		Long sum=0L;
		
		long start=System.currentTimeMillis();
		long end;
		for (int i = 1; i <= 10_0000_0000; i++) {
			sum+=i;
		}
		end=System.currentTimeMillis();
		System.out.println("sum="+sum+",运行了多少"+(end-start));
	}
	
	public static void test2() throws InterruptedException, ExecutionException {
		Long sum=0L;
		
		long start=System.currentTimeMillis();
		long end;
		
		ForkJoinPool forkJoinPool=new ForkJoinPool();
		ForkJoinTask<Long> task=new forkJoinDemo(0,10);		
		ForkJoinTask<Long> submit=forkJoinPool.submit(task);	
		
		sum=submit.get();
		
		end=System.currentTimeMillis();
		System.out.println("sum="+sum+",运行了多少"+(end-start));
	}
	
	public static void test3() {
		Long sum=0L;
		
		long start=System.currentTimeMillis();
		long end;
		//stream并行流
		LongStream.rangeClosed(0, 10_0000_0000).parallel().reduce(0, Long::sum);
		
		end=System.currentTimeMillis();
		System.out.println("sum="+sum+",运行了多少"+(end-start));
	}
}
