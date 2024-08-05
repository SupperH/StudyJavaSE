package NetWork;

import java.io.*;
import java.net.Socket;

//客户端
public class TcpClient {
    public static void main(String[] args) throws IOException {
        //1.创建套接字,指定服务器ip和端口号
        Socket s = new Socket("localhost",8888);
        //2.对于程序员来说 向外发送数据， 就是利用输出流
        OutputStream os = s.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        //利用outputstream就可以发送数据了，但是没有直接发送String的方法
        //所以我们在output外套了一个处理流dataoutputStream
        dos.writeUTF("你好");

        //接受服务器端会话---输入流
        InputStream is =s.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        String str = dis.readUTF();
        System.out.println(str);

        //3.关闭流+关闭网络资源
        dis.close();
        is.close();
        dos.close();
        os.close();
        s.close();
    }

}
