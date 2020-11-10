package add;

import java.util.concurrent.CountDownLatch;

//计数器
public class CountDownLatchDemo {

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch cdl=new CountDownLatch(6);
		for (int i = 5; i >-2; i--) {
			new Thread(()->{
				System.out.println(Thread.currentThread().getName()+"===");
				cdl.countDown();
			},String.valueOf(i)).start();
		}
		
		cdl.await();//等待计数器归零，在向下执行
		System.out.println("close");
	}

}
