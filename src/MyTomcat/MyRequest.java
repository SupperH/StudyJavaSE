package MyTomcat;

import java.io.IOException;
import java.io.InputStream;

public class MyRequest {
    //请求方法get/post
    private String requestMethod;
    //请求地址www.baidu.com
    private String requestUrl;


    public MyRequest(InputStream inputStream) throws IOException {
        //缓冲区域
        byte[] buffer = new byte[1024];
        //读取数据长度
        int len = 0;
        //定义请求变量
        String str = null;

        if((len=inputStream.read(buffer))>0){
            //读取数据有效长度
            str = new String(buffer,0,len);
            //格式化数据
            //http协议包括：请求行 请求头 空格 请求体
            //只要请求行就行了 所以只要第一个参数
            //get/http/1.1
            String data= str.split("\n")[0];
            String[] param = data.split("");
            this.requestMethod = param[0];
            this.requestUrl =param[1];
        }
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }
}
