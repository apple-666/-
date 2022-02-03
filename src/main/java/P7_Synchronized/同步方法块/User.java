package P7_Synchronized.同步方法块;

class User
{
	private String code;
	private int cash;
	User(String code,int cash)
	{
		this.code = code;
		this.cash = cash;
		System.out.println("开始有余额:"+cash);
	}
	public String getCode()
	{
		return code;
	}
	public void setCode(String code)
	{
		this.code = code;
	}
	public void oper(int x)
	{
		try{
			  Thread.sleep(10);
			  synchronized (this)//这里的this指的是调用该方法的对象，也就是u
			{//执行同步代码块时要检查该线程是否取得对象u的锁
				this.cash += x;
				System.out.println(Thread.currentThread().getName()+"运行结束，"+x+"，当前账户余额："+cash);
			}
			
		   }
    	 catch(InterruptedException e)
    		{
    			e.printStackTrace();
    		}
	}
	@Override
	public String toString()
	{
		return "User:" + code + ",cash="+cash;
	}
}

