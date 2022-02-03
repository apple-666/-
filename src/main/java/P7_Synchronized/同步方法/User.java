package P7_Synchronized.同步方法;

class User
{
	private String code;
	private int cash;
	User(String code,int cash)
	{
		this.code = code;
		this.cash = cash;
		System.out.println("初始余额为："+cash);
	}
	public String getCode()
	{
		return code;
	}
	public void setCode(String code)
	{
		this.code = code;
	}
	public synchronized void oper(int x)
	{
		try{
			  Thread.sleep(10);
			   	
				this.cash += x;
				System.out.println(Thread.currentThread().getName()+"运行结束，增加"+x+"，当前账户余额："+cash);
			
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

