package com.pc;

public class testPC {

	public static void main(String[] args) {
		DATA data=new DATA();
		
		new Thread(()->{
			for (int i = 0; i < 10; i++) {
				try {
					data.increament();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		},"A").start();
		
		new Thread(()->{
			for (int i = 0; i < 10; i++) {
				try {
					data.decreament();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		},"B").start();
		
		new Thread(()->{
			for (int i = 0; i < 10; i++) {
				try {
					data.increament();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		},"C").start();
		
		new Thread(()->{
			for (int i = 0; i < 10; i++) {
				try {
					data.decreament();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		},"D").start();
	}
	
	
}
class DATA{
	
	private int count=0;
	
	private int number=0;
	
	public synchronized void increament() throws InterruptedException {//+1
		while (number!=0) {
			//等待
			this.wait();
		}
		//业务方法
		System.out.println(Thread.currentThread().getName()+"==>"+number+"，count==>"+(++count));
		number++;
		//唤醒
		this.notifyAll();
	}
	public synchronized void decreament() throws InterruptedException {//-1
		while (number==0) {
			this.wait();
		}
		System.out.println(Thread.currentThread().getName()+"==>"+number+"，count==>"+(++count));
		number--;
		this.notifyAll();
	}
}