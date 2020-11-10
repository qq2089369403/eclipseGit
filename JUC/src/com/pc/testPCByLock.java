package com.pc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class testPCByLock {

	public static void main(String[] args) {
		DATALcok dataLock=new DATALcok();
		
		new Thread(()->{
			for (int i = 0; i < 10; i++) {
				try {
					dataLock.increament();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		},"A").start();
		
		new Thread(()->{
			for (int i = 0; i < 10; i++) {
				try {
					dataLock.decreament();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		},"B").start();
		
		new Thread(()->{
			for (int i = 0; i < 10; i++) {
				try {
					dataLock.increament();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		},"C").start();
		
		new Thread(()->{
			for (int i = 0; i < 10; i++) {
				try {
					dataLock.decreament();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		},"D").start();
	}

}

class DATALcok {
	private int count = 0;

	private int number = 0;

	Lock lock = new ReentrantLock();
	Condition condition=lock.newCondition();

	public void increament() throws InterruptedException {// +1
		lock.lock();
		try {
			while (number != 0) {
				// 等待
				condition.await();
//			this.wait();
			}
			// 业务方法
			System.out.println(Thread.currentThread().getName() + "==>" + number + "，count==>" + (++count));
			number++;
			// 唤醒
			condition.signal();
		}
		finally {
			lock.unlock();
		}

	}

	public void decreament() throws InterruptedException {// -1
		lock.lock();
		try {
			while (number == 0) {
				condition.await();
			}
			System.out.println(Thread.currentThread().getName() + "==>" + number + "，count==>" + (++count));
			number--;
			condition.signal();
		}
		finally {
			lock.unlock();
		}
		
		
		
	}
}
