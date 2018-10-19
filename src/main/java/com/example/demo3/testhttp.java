package com.example.demo3;

import java.io.*;
import java.net.*;

public class testhttp {

//    private String str_url="http://localhost:8080/new_web/httpmesg.jsp";
    private String str_url="http://localhost:8080/login";
//    private String str_url="http://www.baidu.com";
    private String str_geturl="http://www.baidu.com/s?wd=e&rsv_bp=0&ch=&tn=baidu&bar=&rsv_spt=3&ie=utf-8&rsv_sug3=1&rsv_sug4=537&rsv_sug1=1&f=3&rsp=0&inputT=1471";
    private String str_baidu="http://www.baidu.com?wd=e&test=1234ada";
    private URL url;
    private HttpURLConnection urlconn;
    private URL get_url;

    public void http(){
        try {
            url = new URL(str_url);
            urlconn= (HttpURLConnection)url.openConnection();
            urlconn.connect();
            urlconn.setDoOutput(true);
            urlconn.setDoInput(true);
            urlconn.setUseCaches(false);
            urlconn.setRequestMethod("POST");
            urlconn.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
            //通过post方法发送的内容
            String content="11req_http";
            //向服务器端发送数据的输出流
            OutputStream os=urlconn.getOutputStream();
            BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(os,"ascii"));
            bw.write(content);
            bw.flush();
            //关闭后将输出流写入到http的content中
            bw.close();

            //发送请求信息，获得服务器返回数据的输入流
            InputStream is=urlconn.getInputStream();
            if(urlconn.getResponseCode()!=200){
                //is = urlconn.getErrorStream();
                System.out.println("error!!!");
            }else{
                is=urlconn.getInputStream();
            }

            byte[] b=new byte[1024];
            while(is!=null && is.read(b)!=-1 ){
                System.out.println(new String(b));
            }

//		BufferedReader br=new BufferedReader(new InputStreamReader(is,"ascii"));
//		String read_content=new String();
//		while((read_content= br.readLine())!=null){
//		}

        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        System.out.println("hello");

        testhttp testHttp = new testhttp();
        testHttp.http();
    }


}
