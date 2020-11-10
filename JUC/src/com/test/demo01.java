package com.test;

public class demo01 {

	public static void main(String[] args) {
		//获取CPU的核数
//		System.out.println(Runtime.getRuntime().availableProcessors());
		Ticket ticker=new Ticket();
		//lamada表达式
		new Thread(()->{
			for (int i = 1; i < 40; i++) {
				ticker.sellTicket();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		},"A").start();
		new Thread(()->{
			for (int i = 1; i < 40; i++) {
				ticker.sellTicket();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		},"B").start();
		new Thread(()->{
			for (int i = 1; i < 40; i++) {
				ticker.sellTicket();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		},"C").start();
	}

}

class Ticket{
	int number=30;
	
	public synchronized void sellTicket() {
		if (number>0) {
			System.out.println(Thread.currentThread().getName()+"卖出第"+number--+"张票,还剩"+(30-number)+"票");
		}
		
	}
}