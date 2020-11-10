package add;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

//计数器
public class CyclicBarrierDemo {

	public static void main(String[] args) {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(7, new Thread(() -> {
			System.out.println("召唤神龙成功");
		}));
		for (int i = 0; i < 8; i++) {
			final int temp = i;
			new Thread(() -> {
				System.out.println(Thread.currentThread().getName() + "收集了第" + temp + "个龙珠");
				try {
					cyclicBarrier.await();
				} catch (InterruptedException | BrokenBarrierException e) {
					e.printStackTrace();
				}
			}, String.valueOf(i)).start();
			/*try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}*/
		}
	}

}
