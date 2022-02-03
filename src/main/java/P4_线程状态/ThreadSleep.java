package P4_线程状态;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: codeyuaiaio
 * 模拟倒计时
 */
public class ThreadSleep {

    public static void main(String[] args) {
        //方法一
//        try {
//            tenDowm();
//        } catch (InterruptedException e) {
//        }


        //方法二
        Date date = new Date(System.currentTimeMillis());

        while(true){
            try {
                Thread.sleep(1000);
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(date));
                //更新当前时间
                date = new Date(System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
	//模拟倒计时
    public static void tenDowm() throws InterruptedException {
        int i = 10;
        while(true){
            Thread.sleep(1000);
            System.out.println(i--);
            if (i<0) {
                break;
            }
        }

    }
}
