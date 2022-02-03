package P4_线程状态;

/**
 * @author: codeyuaiaio
 * 线程礼让
 *  礼让不一定成功,看CPU心情
 */
public class ThreadYield {

    public static void main(String[] args) {
        TestYield testYield = new TestYield();

        new Thread(testYield,"a").start();
        new Thread(testYield,"b").start();

    }
}
class TestYield implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"线程开始");
        Thread.yield();//线程礼让
        System.out.println(Thread.currentThread().getName()+"线程结束");
    }
}


