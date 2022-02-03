package P7_Synchronized.同步方法块;


public class ThreadDemo03
{
   public static void main(String[] args)
   {
	  User u = new User("张三",100);
	  MyThread t1 = new MyThread("线程A",u,20);
	  MyThread t2 = new MyThread("线程B",u,-60);
	  MyThread t3 = new MyThread("线程C",u,-80);
	  MyThread t4 = new MyThread("线程D",u,-30);
	  MyThread t5 = new MyThread("线程E",u,32);
	  MyThread t6 = new MyThread("线程F",u,21);
	  
	  t1.start();
	  t2.start();
	  t3.start();
	  t4.start();
	  t5.start();
	  t6.start();
   }
}
 
