package P9_生产者消费者.管城法;

public class TestCooperation {
    //协作模型：生产者消费者实现方式一：管城法
    //借助缓冲区
    public static void main(String[] args) {
        Container container = new Container();
        new Producter(container).start();
        new Consumer(container).start();
    }
}
class Producter extends Thread{
    Container container;

    public Producter(Container container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 1; i < 100; i++) {
            System.out.println("仓库未满，生产第"+i+"个商品");
            container.push(new Stor(i));
        }
    }
}
class Consumer extends Thread{
    Container container;

    public Consumer(Container container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 1; i < 100; i++) {
            System.out.println("仓库有货了，消费第"+container.pop().id+"个商品");
        }
    }
}
class Container {
    Stor[] stors = new Stor[5];
    int count=0;
    public synchronized void push(Stor stor) {
        if (count == stors.length) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        stors[count++] = stor;
        this.notifyAll();
    }
    public synchronized Stor pop() {
        if (count == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Stor stor = stors[--count];
        this.notifyAll();
        return stor;
    }
}

class Stor {
    int id;

    public Stor(int id) {
        this.id = id;
    }
}
