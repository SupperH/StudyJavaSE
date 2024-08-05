package MyTomcat;

public class MyServlet extends MyhttpServlet{
    @Override
    public void doGet(MyRequest request, MyResponse response) throws Exception {
        response.write("mytomcat");
    }

    @Override
    public void doPost(MyRequest request, MyResponse response) throws Exception {
        response.write("mytomcat");

    }
}
