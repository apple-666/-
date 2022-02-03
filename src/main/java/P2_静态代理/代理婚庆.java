package P2_静态代理;

/**
 * @Author Double_apple
 * @Date 2022/2/3 9:35
 * @Version 1.0
 */
/**
 * @author: codeyuaiaio
 *  静态代理模式总结：
 *      真实对象和代理对象都要实现同一个接口
 *      代理对象要代理真实角色
 *  好处：
 *      代理对象可以做很多真实对象做不了的事情
 *      真实对象专注做自己的事情
 */
public class 代理婚庆 {
    public static void main(String[] args) {
        WeddingCompany weddingCompany = new WeddingCompany(new You());
        weddingCompany.happyMarry();
    }

}


