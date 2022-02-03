package P9_生产者消费者.信号灯法;

public class Testcooperation2 {
    public static void main(String[] args) {
        //协作模型：生产者消费者实现方式二：信号灯表示法
        //借助标志位
        Tv tv =new Tv();
        new Player(tv).start();
        new Watcher(tv).start();
    }
}
//生产者  演员
class Player extends Thread {
    Tv tv;

    public Player(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (i %2 == 0) {
                this.tv.play("apple 上台表演了");
            }else {
                this.tv.play("apple 下台了");
            }
        }
    }
}
//消费者 观众
class Watcher extends Thread {
    Tv tv;

    public Watcher(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            tv.watch();
        }
    }
}
//同一个资源 电视
class Tv {
    String voice;
    //信号灯
    //T 表示演员表演 观众等待
    //F 表示观众观看 演员等待
    boolean flag = true;

    //表演
    public synchronized void play(String voice) {
        //演员等待
        if (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //表演
        System.out.println("表演了："+voice);
        this.voice = voice;
        //唤醒
        this.notifyAll();
        this.flag = false;
    }
    //观看
    public synchronized void watch() {
        //观众等待
        if (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //观看
        if(voice.equals("apple 上台表演了"))     {
            System.out.println("观众听到了"+voice+"喊道：apple 加油！");
        }
        else {
            System.out.println("观众听到了"+voice+"喊道：apple 辛苦了！");
        }
        //唤醒
        this.notifyAll();
        //切换标志
        this.flag = true;
    }
}
