package NetWork;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test01 {
    public static void main(String[] args) throws UnknownHostException {
        //封装IP：传入ip地址，这里传的是本机的
        //不能直接InetAddress ia = new InetAddress() 因为InetAddress被default修饰了
        InetAddress ia = InetAddress.getByName("192.168.10.104");
        System.out.println(ia);
        InetAddress ia2 = InetAddress.getByName("localhost");//指代本机ip
        System.out.println(ia2);
        InetAddress ia3 = InetAddress.getByName("www.baidu.com");//封装域名
        System.out.println(ia3);
        System.out.println(ia3.getHostAddress());
        System.out.println(ia3.getHostName());
    }

}
