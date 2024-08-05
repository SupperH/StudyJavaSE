package MyTomcat;


import java.util.HashMap;

public class MyMapping {
    public static HashMap<String,String> mapping = new HashMap<>();

    static{
        mapping.put("/mytomcat","MyTomct.Myservlet");

    }

    public HashMap<String,String> getMapping(){
        return mapping;
    }
}
