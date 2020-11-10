package com.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		MyThread th=new MyThread();
		FutureTask<Integer> f=new FutureTask(th);
		new Thread(f,"A").start();
		new Thread(f,"B").start();//缓存，指挥输出一次
		Integer i=f.get();
		System.out.println(i);
	}

}
class MyThread implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		System.out.println("call");
		return 1024;
	}
	
}
