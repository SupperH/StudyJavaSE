package Reflect;

//获取字节码信息
public class ReflectDemo1 {
    public static void main(String[] args) throws ClassNotFoundException {
        //以person的字节码信息为案例
        //1.通过getclass
        Person p = new Person();
        Class c1 =p.getClass();
        System.out.println(c1);

        //2.通过内置class属性
        Class c2 =Person.class;
        System.out.println(c2);

        //方式一和方式二不常用

        //3.用的最多，调用class类提供的静态方法forName，传入包名
        Class c3 = Class.forName("Reflect.Person");
        System.out.println(c3);

        //4：利用类的加载器(了解技能点)
        ClassLoader loader = Test.class.getClassLoader();
        Class c4 = loader.loadClass("Reflect.Person");
        System.out.println(c4);
    }

}
