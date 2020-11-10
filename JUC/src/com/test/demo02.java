package com.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class demo02 {

	public static void main(String[] args) {
		Ticket02 ticket=new Ticket02();
		
		new Thread(()->{for (int i = 0; i < 40; i++) {
			ticket.sellTicket();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}},"A").start();
		new Thread(()->{for (int i = 0; i < 40; i++) {
			ticket.sellTicket();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}},"B").start();
		new Thread(()->{for (int i = 0; i < 40; i++) {
			ticket.sellTicket();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}},"C").start();
	}

}
class Ticket02{
	int number=30;
	Lock lock=new ReentrantLock(true);
	
	public void sellTicket() {
		
		lock.lock();
		try {
			if (number>0) {
				System.out.println(Thread.currentThread().getName()+"卖出第"+number--+"张票,还剩"+number+"票");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
		
		
	}
}