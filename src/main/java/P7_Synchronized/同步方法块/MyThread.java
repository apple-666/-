package P7_Synchronized.同步方法块;


class MyThread extends Thread
{
   private User u;
   private int y = 0;
   MyThread(String name,User u,int y)
   {
	   super(name);
	   this.u = u;
	   this.y = y;
   }
   @Override
   public void run()
   {
	   u.oper(y);
   }
}
 

