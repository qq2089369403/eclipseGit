package com.pc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class testPCByLockOrder {

	public static void main(String[] args) {
		DATA02 data=new DATA02();
		new Thread(()-> {
			for (int i = 0; i < 8; i++) {
				data.printA();
			}
		},"A").start();
		
		new Thread(()-> {
			for (int i = 0; i < 8; i++) {
				data.printB();
			}
		},"B").start();
		
		new Thread(()-> {
			for (int i = 0; i < 8; i++) {
				data.printC();
			}
		},"C").start();
	}

}
class DATA02{
	private int number=1;
	
	private Lock lock=new ReentrantLock();
	private Condition condition1=lock.newCondition();
	private Condition condition2=lock.newCondition();
	private Condition condition3=lock.newCondition();
	
	public void printA() {
		lock.lock();
		try {
			while(number!=1) {
				condition1.await();
			}
			System.out.println(Thread.currentThread().getName()+"=>B，number="+number);
			number=2;
			condition2.signal();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
	
	public void printB() {
		lock.lock();
		try {
			while(number!=2) {
				condition2.await();
			}
			System.out.println(Thread.currentThread().getName()+"=>C，number="+number);
			number=3;
			condition3.signal();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
	
	public void printC() {
		lock.lock();
		try {
			while(number!=3) {
				condition3.await();
			}
			System.out.println(Thread.currentThread().getName()+"=>A，number="+number);
			number=1;
			condition1.signal();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
}