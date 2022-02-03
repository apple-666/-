package P1_创建线程.demo3;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Author Double_apple
 * @Date 2022/1/12 20:07
 * @Version 1.0
 */
public class SellTickets {
    public static void main(String[] args) {
        Ticket ticket = new Ticket(6);
        TicketWindow ticketWindow = new TicketWindow(ticket);
        for (int i = 1; i < 2; i++) {
            FutureTask<Void> futureTask = new FutureTask<Void>(ticketWindow);
            Thread t = new Thread(futureTask,"TW"+i);
            t.start();
        }
    }
}


class TicketWindow implements Callable<Void> {

    private Ticket tickets;

    public TicketWindow(Ticket ticket){
        this.tickets=ticket;
    }

    @Override
    public Void call() {
        while (true) {
            synchronized (tickets) {
                int sum = tickets.getNum();
                if (sum > 0) {
                    System.out.println(Thread.currentThread().getName() + "可以出票，剩余票数：" + sum);
                    sum--;
                    tickets.setNum(sum);
                    System.out.println(Thread.currentThread().getName() + "卖出一张，剩余票数：" + sum);
                } else {
                    System.out.println("余票不足！");
                    break;
                }
            }
        }
        return null;
    }
}

class Ticket{
    private int num;
    public Ticket(int n){
        this.num = n;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}