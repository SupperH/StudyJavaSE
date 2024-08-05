package NetWork.tcplogin;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

//客户端
public class TcpClient {
    public static void main(String[] args) throws IOException {
        //1.创建套接字,指定服务器ip和端口号
        Socket s = new Socket("localhost",8888);

        //录入用户的账号和密码
        Scanner sc = new Scanner(System.in);
        System.out.println("请录入你的账号密码");
        String name = sc.next();
        String pwd = sc.next();
        //把账号密码封装成user对象
        User user =new User(name,pwd);

        //2.对于程序员来说 向外发送数据， 就是利用输出流
        OutputStream os = s.getOutputStream();
        //因为要传的是对象 所以用object流
        ObjectOutputStream oos = new ObjectOutputStream(os);
        //利用outputstream就可以发送数据了，但是没有直接发送String的方法
        //所以我们在output外套了一个处理流dataoutputStream
        oos.writeObject(user);

        //接受服务器端会话---输入流
        InputStream is =s.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        boolean flg = dis.readBoolean();
        if(flg){
            System.out.println("登录成功");
        }else{
            System.out.println("账号或密码错误");
        }

        //3.关闭流+关闭网络资源
        dis.close();
        is.close();
        oos.close();
        os.close();
        s.close();
    }

}
