package com.lock8;

public class Test1 {

	public static void main(String[] args) {
		Phone phone1=new Phone();
		Phone phone2=new Phone();
		new Thread(()->{
			try {
				phone1.sendMessage();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
		new Thread(()->{
			phone2.call();
		}).start();
	}

}
class Phone{
	//synchronized锁的是方法的使用者
	//两个方法是同一个锁，谁先拿到谁先执行
	public synchronized void sendMessage() throws InterruptedException {
		Thread.sleep(4000);
		System.out.println("发信息");
	}
	
	public synchronized void call() {
		System.out.println("打电话");
	}
}