package NetWork;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

//服务器
public class TcpServer {
    public static void main(String[] args) throws IOException {
        //1.创建套接字,指定服务器的端口号
        ServerSocket ss = new ServerSocket(8888);
       //等待客户端发来的信息
        Socket s = ss.accept(); //阻塞方法，等待接受客户端数据，什么时候收到，什么时候程序继续执行
        //accept返回值为socket，这个socket就是客户端的socket
        //接收到socket后，客户端和服务器才真正产生了链接，才可以进行通信
        //操作流
        InputStream is = s.getInputStream();
        DataInputStream dis = new DataInputStream(is);

        //读取客户端发来的数据
        String str = dis.readUTF();
        System.out.println(str);

        //向客户端输出内容---操作流---输出流
        OutputStream os = s.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        dos.writeUTF("收到请求");

        //关闭资源
        dos.close();
        os.close();
        dis.close();
        is.close();
        s.close();
        ss.close();
    }

}
