package com.forkJoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class forkJoinDemo extends RecursiveTask<Long>{
	
	private long start;
	private long end;
	
	
	private long temp=1_0000L;//临界值
	
	public forkJoinDemo() {
	}

	public forkJoinDemo(long start, long end) {
		this.start = start;
		this.end = end;
	}


	@Override
	protected Long compute() {
		long sum=0L;
		
		if (end-start<temp) {
			for (start = 0; start < end; start++) {
				sum+=start;
			}
			return sum;
		}else {
			long middle=(end+start)/2;
			forkJoinDemo task1=new forkJoinDemo(start,middle);
			task1.join();
			forkJoinDemo task2=new forkJoinDemo(middle+1,end);
			task2.join();
			return task1.join()+task2.join();
		}
	}
	

}
