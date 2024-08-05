package NetWork;

import java.net.InetAddress;
import java.net.InetSocketAddress;

public class Test02 {
    public static void main(String[] args) {
        InetSocketAddress isa = new InetSocketAddress("localhost",8080);
        System.out.println(isa);
        System.out.println(isa.getAddress());
        System.out.println(isa.getHostName());
        System.out.println(isa.getPort());

        InetAddress ia = isa.getAddress();
        System.out.println(ia.getHostAddress());
    }
}
