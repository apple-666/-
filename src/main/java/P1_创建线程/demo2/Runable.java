package P1_创建线程.demo2;

/**
 * @Author Double_apple
 * @Date 2022/1/12 19:40
 * @Version 1.0
 */
public class Runable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 15; i++) {
            System.out.println("其他线程执行NO."+i);
        }
    }

    public static void main(String[] args) {
        Runable runable = new Runable();
//        Thread thread = new Thread(runable);
//        thread.start();

        new Thread(runable).start();

        for (int i = 0; i < 50; i++) {
            System.out.println("主线程执行NO."+i);
        }
    }
}
