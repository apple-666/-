package P1_创建线程.demo1;

/**
 * @Author Double_apple
 * @Date 2022/1/12 19:29
 * @Version 1.0
 */

/*
* 多线程方法一：继承Thread
* 重写run 方法
* 执行对象的start方法
* */

public class TestThread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("其他线程执行NO."+i);
        }
    }

    public static void main(String[] args) {
         TestThread1 t1 = new TestThread1();
         t1.start();//主线程和其他线程会同时交替执行
        for (int i = 0; i < 20; i++) {
            System.out.println("主线程执行NO."+i);
        }
    }
}
