package com.lock8;


//5.增加两个静态同步方法，只有一个对象，先发短信还是打电话   发短信
//6.增加两个静态同步方法，有两个对象，先发短信还是打电话   发短信
public class Test3 {

	public static void main(String[] args) {
		Phone3 phone1=new Phone3();
		Phone3 phone2=new Phone3();
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
class Phone3{
	//synchronized锁的是方法的使用者	
	//static 静态方法
	//类一加载就有，锁的是class
	public static synchronized void sendMessage() throws InterruptedException {
		Thread.sleep(400);
		System.out.println("发信息");
	}
	
	public static synchronized void call() {
		System.out.println("打电话");
	}
	
	public void hello() {
		System.out.println("hello");
	}
}