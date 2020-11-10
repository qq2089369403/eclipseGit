package sort;

public class lock {
	 private static String A="A"; 
     private static String B="B"; 
     public static void main(String[] args){ 
         new lock().deadLock(); 
     } 
     private void deadLock(){ 
         Thread t1=new Thread(new Runnable() { 
             @Override 
             public void run() { 
                 synchronized(A){ 
                     try { 
                         Thread.currentThread().sleep(2000); 
                     } catch (InterruptedException e) { 
                         e.printStackTrace(); 
                     } 
                     synchronized (B){ 
                         System.out.print("1"); 
                     } 
                 } 
             }
         }); 
         Thread t2=new Thread(new Runnable() { 
             @Override 
             public void run() { 
                 synchronized (B){ 
                     synchronized (A){ 
                         System.out.println("2"); 
                     } 
                 } 
             } 
         }); 
         //开启线程 
         t1.start(); 
         // 开启线程2 
         t2.start(); 
     } 
}
