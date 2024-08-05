package Reflect;

public class Test {
    public static void main(String[] args) {
        //定义一个字符串，模拟前台支付方式
        String str = "支付宝";
        if("微信".equals(str)){
            //微信支付
            pay(new Wechat());
        }
        if("支付宝".equals(str)){
            //支付宝
            pay(new Alipay());
        }
    }

    public static void pay(Wechat wc){
        wc.payOnline();
    }
    public static void pay(Alipay ap){
        ap.payOnline();
    }
}
