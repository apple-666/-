package P6_监控线程状态;

/**
 * @author: codeyuaiaio
 * 观察测试线程的状态
 */
@SuppressWarnings("all")
public class ThreadState {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("///");
        });

        //观察状态
        Thread.State state = thread.getState();
        //NEW
        System.out.println(state);

        //观察启动后
        //启动线程
        thread.start();
        state = thread.getState();
        System.out.println(state);

        //只要线程不终止,就一直输出状态
        while (state != Thread.State.TERMINATED) {
            try {
                Thread.sleep(800);
                //更新线程状态
                state = thread.getState();
                System.out.println(state);//最后会是Terminated
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
