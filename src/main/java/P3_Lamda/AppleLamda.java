package P3_Lamda;

/**
 * @Author Double_apple
 * @Date 2022/2/3 9:48
 * @Version 1.0
 */

/**
 * @author: codeyuaiaio
 * 函数式接口（runnable） lambda表达式
 */
public class AppleLamda {
    //3.静态内部类
    static class like2 implements Ilike{
        @Override
        public void lambda(int a,int b) {
            System.out.println("2我喜欢--->"+a+"--->"+b);
        }
    }
    public static void main(String[] args) {
        Ilike like = new like();
        like.lambda(521,520);

        like = new like2();
        like.lambda(521,520);

        //4.局部内部类
        class like3 implements Ilike {
            @Override
            public void lambda(int a, int b) {
                System.out.println("3我喜欢--->" + a + "--->" + b);
            }
        }
        like = new like3();
        like.lambda(521,520);

        //5.匿名内部类 没有类的名称,必须借助接口或者父类
        like = new Ilike(){
            @Override
            public void lambda(int a, int b) {
                System.out.println("4我喜欢--->" + a + "--->" + b);
            }
        };
        like.lambda(521,520);
//--------------------------------------lambda---------------------------
        //6.lambda表达式  简化
//        like =(int a, int b)->{
//            System.out.println("5我喜欢--->" + a + "--->" + b);
//        };
        like = (int a,int  b)->{
            System.out.println("a+b="+(a+b));
        };

        like.lambda(521,520);

        //6.1简化lambda表达式--->参数类型
        like =(a,b)->{
            System.out.println("5.1我喜欢--->" + a + "--->" + b);
        };
        like.lambda(521,520);

        //6.2简化lambda表达式--->简化括号 (只有参数为一个的时候可以去掉小括号)
//        like =a->{
//            System.out.println("5.1我喜欢--->" + a + "--->");
//        };

        //6.3简化lambda表达式--->去掉花括号 (不能小括号和花括号同时删除)
        like =(a,b)->System.out.println("5.2我喜欢--->" + a + "--->" + b);
        like.lambda(521,520);


    }

}

