package Reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectDemo {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //定义一个字符串，模拟前台支付方式,
        //传入的是对应的包路径
        String str = "Reflect.Wechat";

        //下面代码利用反射：
        Class cls = Class.forName(str);
        Object o = cls.newInstance();
        Method method =cls.getMethod("payOnline");
        method.invoke(o);
    }



}
