package NetWork;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UdpReceive {
    public static void main(String[] args) throws IOException {
        System.out.println("老师上线了");
        //创建套接字，指定接收方端口
        DatagramSocket ds = new DatagramSocket(9999);

        while(true){
            //有一个空的数据包，打算用来接受对方传来的数据包
            byte[] b= new byte[1024];
            DatagramPacket dp = new DatagramPacket(b,b.length);

            //接受对方数据包，然后放入我们的dp数据包中填充
            ds.receive(dp);//接受完后，dp就填充好内容了

            //取出数据
            byte[] data = dp.getData();
            //dp.getLength():数据包中的有效长度
            String s = new String(data,0,dp.getLength());
            System.out.println("学生对我说： "+s);
            //如果学生说了byebye，结束聊天关闭资源
            if(s.equals("byebye")){
                ds.close();
                break;
            }

            //老师进行回复
            //准备数据包
            Scanner sc = new Scanner(System.in);
            System.out.print("老师： ");
            String str = sc.next();
            byte[] bytes = str.getBytes();


            //封装数据，并指定学生的端口号
            DatagramPacket dp2 = new DatagramPacket(bytes,bytes.length, InetAddress.getByName("localhost"),8888);
            ds.send(dp2);
        }
    }
}
