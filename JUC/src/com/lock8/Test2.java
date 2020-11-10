package com.lock8;


//3.增加一个普通方法后，先执行发短信还是hello？ 普通方法    
//4.两个对象，两个同步方法，发短信还是打电话？  打电话
public class Test2 {

	public static void main(String[] args) {
		Phone2 phone1=new Phone2();
		Phone2 phone2=new Phone2();
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
class Phone2{
	//synchronized锁的是方法的使用者
	//两个方法是同一个锁，谁先拿到谁先执行
	public synchronized void sendMessage() throws InterruptedException {
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