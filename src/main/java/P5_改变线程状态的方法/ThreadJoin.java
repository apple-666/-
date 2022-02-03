package P5_改变线程状态的方法;

/**
 * @author: codeyuaiaio
 * join方法
 */
public class ThreadJoin implements Runnable{


    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("run---我是vip---都让开"+i);
        }
    }


    public static void main(String[] args) {
        // 启动线程
        ThreadJoin threadJoin = new ThreadJoin();
        Thread thread = new Thread(threadJoin);


        //主线程
        for (int i = 0; i < 500; i++) {
            System.out.println("main线程-----"+i);
            if ( i == 400) {
                try {
                    thread.start();
                    thread.join();// 不适用join进行插队，main线程可能先跑完
                                    //join会抛出 InterruptedException异常
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
