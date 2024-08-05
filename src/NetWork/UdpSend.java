package NetWork;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UdpSend {
    public static void main(String[] args) throws IOException {
        System.out.println("学生上线");
        //准备套接字 指定发送方的端口号
        DatagramSocket ds =new DatagramSocket(8888);
        while(true){
            //准备数据包
            Scanner sc = new Scanner(System.in);
            System.out.print("学生： ");
            String str = sc.next();
            byte[] bytes = str.getBytes();
            //需要四个参数：
            //1：传送数据转为字节数组
            //2.字节数组的长度
            //3封装接收方的ip
            //4指定接收方的端口
            DatagramPacket dp = new DatagramPacket(bytes,bytes.length, InetAddress.getByName("localhost"),9999);
            ds.send(dp);
            //如果学生说了byebye，结束聊天关闭资源
            if(str.equals("byebye")){
                ds.close();
                break;
            }


            //接收老师传回的信息
            //同理创建一个空的数据包，接受对方传来的内容
            byte[] b = new byte[1024];
            DatagramPacket dp2 = new DatagramPacket(b,b.length);
            //填充内容
            ds.receive(dp2);

            //取出数据
            byte[] data = dp2.getData();
            String s = new String(data,0,dp2.getLength());
            System.out.println("老师对我说:"+s);

        }
        }
}
