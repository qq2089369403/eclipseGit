package com.rw;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockDemo {

	public static void main(String[] args) {
		MyCacheLock cache=new MyCacheLock();
		for (int i = 0; i < 5; i++) {
			int temp=i;
			new Thread(() ->{
				cache.put(String.valueOf(temp), temp);
			},String.valueOf(i)).start();
		}
		
		for (int i = 0; i < 5; i++) {
			int temp=i;
			new Thread(() ->{
				cache.get(String.valueOf(temp));
			},String.valueOf(i)).start();
		}
	}

}
class MyCacheLock{
	private volatile Map<String,Object> map=new HashMap<>();
	
	private ReadWriteLock rw=new ReentrantReadWriteLock();
	
	public void put(String key,Object value) {
		rw.writeLock().lock();
		System.out.println(Thread.currentThread().getName()+"写入"+key);
		map.put(key,value);
		System.out.println(Thread.currentThread().getName()+"写入成功");
		rw.writeLock().unlock();
	}
	
	public Object get(String key) {
		rw.readLock().lock();
		System.out.println(Thread.currentThread().getName()+"读取"+key);
		Object o=map.get(key);
		System.out.println(Thread.currentThread().getName()+"读取成功"+o);
		rw.readLock().unlock();
		return o;
	}
}
