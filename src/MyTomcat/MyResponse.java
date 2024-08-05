package MyTomcat;

import javafx.util.Builder;

import java.io.IOException;
import java.io.OutputStream;

public class MyResponse {

    private OutputStream outputStream;

    public MyResponse(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void write(String str) throws Exception {
        StringBuilder sb = new StringBuilder();
        //标准的http格式
        sb.append("Http/1.1 200OK\n")
                .append("Content-Type:text/html\n")
                .append("\r\n")
                .append("<html>")
                .append("<body>")
                .append("<h1>"+str+"<h1>")
                .append("</body>")
                .append("</html>");

        this.outputStream.write(sb.toString().getBytes());
        this.outputStream.flush();
        this.outputStream.close();
    }



}
