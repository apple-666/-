package P8_Lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: DoubleApple
 */
public class TestLock {
    public static void main(String[] args) {
        TestLock2 testLock2 = new TestLock2();

        new Thread(testLock2,"apple1").start();
        new Thread(testLock2,"apple2").start();
        new Thread(testLock2,"apple3").start();
    }
}

class TestLock2 implements Runnable{
    private int ticketsNum = 10;

    //定义lock锁
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            //lock.lock();放在try外部:如果在获取锁时出现了错误,而finally中的释放锁却还能释放 就有问题.
            // 不用lock，三个线程都会进入操作,会导致数据错误（数据可能会重复，小于1）
            // 用了lock，只有拿到了锁的才会执行,就可以保证数据，数据不会重复，按顺序大于0
//            lock.lock();
//            try {
                if (ticketsNum>0) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+":"+ticketsNum--);
                }else{
                    break;
                }
//            } finally {
//                lock.unlock();
//            }
        }
    }



}
