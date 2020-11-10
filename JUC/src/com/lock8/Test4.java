package com.lock8;


//7.一个静态同步方法，一个普通同步方法，一个对象，发短信？打电话？  打电话
//8.一个静态同步方法，一个普通同步方法，两个个对象，发短信？打电话？  打电话
public class Test4 {

	public static void main(String[] args) {
		Phone4 phone1=new Phone4();
		Phone4 phone2=new Phone4();
		new Thread(()->{
			try {
				phone1.sendMessage();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
		/*new Thread(()->{
			phone1.hello();
		}).start();*/
		new Thread(()->{
			phone2.call();
		}).start();
	}

}
class Phone4{
	//synchronized锁的是方法的使用者
	//两个方法是同一个锁，谁先拿到谁先执行
	public static synchronized void sendMessage() throws InterruptedException {
		Thread.sleep(400);
		System.out.println("发信息");
	}
	
	public synchronized void call() {
		System.out.println("打电话");
	}
	
	public void hello() {
		System.out.println("hello");
	}
}