package com.cvte.msgclient;

import net.sf.json.JSONArray;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PostRequest {


    public static void register() {
        // 创建默认的httpClient实例.
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost("http://localhost:8080/msgpush/register");

        // 创建参数队列
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        formparams.add(new BasicNameValuePair("userName", "abcd"));
        formparams.add(new BasicNameValuePair("passwd", "123"));
        UrlEncodedFormEntity uefEntity;

        try

        {
            uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
            httppost.setEntity(uefEntity);
            System.out.println("executing request " + httppost.getURI());
            CloseableHttpResponse response = httpclient.execute(httppost);
            try {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    System.out.println("--------------------------------------");
                    System.out.println("Response content: " + EntityUtils.toString(entity, "UTF-8"));
                    System.out.println("--------------------------------------");
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            } finally {
                response.close();
            }
        } catch (ClientProtocolException e)
        {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e1)
        {
            e1.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        } finally
        {
            // 关闭连接,释放资源
            try {
                if(httpclient!=null) httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void post() {
        // 创建默认的httpClient实例.
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 创建httppost
        HttpPost httppost = new HttpPost("http://localhost:8080/msgpush/phone");

        ArrayList<String> list = new ArrayList();
        list.add("ljh");
        list.add("2017-3-27");
        list.add("3");

        JSONArray jsonArray = JSONArray.fromObject(list);
        // 创建参数队列
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        formparams.add(new BasicNameValuePair("appid", "10524782571"));
        formparams.add(new BasicNameValuePair("push", "18827588559,18822777045"));
        formparams.add(new BasicNameValuePair("sign", "shirui"));
        formparams.add(new BasicNameValuePair("template_id", "1"));
        formparams.add(new BasicNameValuePair("params", jsonArray.toString()));
        formparams.add(new BasicNameValuePair("content", "hello{1},zai{2},{3}day."));
        formparams.add(new BasicNameValuePair("needreply", "1"));
        formparams.add(new BasicNameValuePair("isTongbu", "0"));
        UrlEncodedFormEntity uefEntity;

        try

        {
            uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
            httppost.setEntity(uefEntity);
            System.out.println("executing request " + httppost.getURI());
            CloseableHttpResponse response = httpclient.execute(httppost);
            try {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    System.out.println("--------------------------------------");
                    System.out.println("提交后返回本次请求id(id>0): " + EntityUtils.toString(entity, "UTF-8"));
                    System.out.println("--------------------------------------");
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            } finally {
                response.close();
            }
        } catch (ClientProtocolException e)
        {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e1)
        {
            e1.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        } finally
        {
            try {
                if(httpclient!=null) httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void mailPost() {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost("http://localhost:8080/msgpush/mail");

        ArrayList<String> list = new ArrayList();
        list.add("subject");//第一个参数=subject
        list.add("ljh");
        list.add("2017-3-27");
        list.add("3");

        JSONArray jsonArray = JSONArray.fromObject(list);

        List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        formparams.add(new BasicNameValuePair("appid", "10191291000"));
        formparams.add(new BasicNameValuePair("push", "1888@mail.com,1388@mail.com"));
        formparams.add(new BasicNameValuePair("sendMailer", "554@mail.com"));
        formparams.add(new BasicNameValuePair("template_id", "1"));
        formparams.add(new BasicNameValuePair("params", jsonArray.toString()));
        formparams.add(new BasicNameValuePair("content", "hello{1},zai{2},{3}day."));
        formparams.add(new BasicNameValuePair("needreply", "1"));
        formparams.add(new BasicNameValuePair("isTongbu", "0"));
        UrlEncodedFormEntity uefEntity;
        try
        {
            uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
            httppost.setEntity(uefEntity);
            System.out.println("executing request " + httppost.getURI());
            CloseableHttpResponse response = httpclient.execute(httppost);
            try {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    System.out.println("--------------------------------------");
                    System.out.println("提交后返回本次请求id(id>0): " + EntityUtils.toString(entity, "UTF-8"));
                    System.out.println("--------------------------------------");
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            } finally {
                response.close();
            }
        } catch (ClientProtocolException e)
        {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e1)
        {
            e1.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        } finally
        {
            try {
                if(httpclient!=null) httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void addTemplate() {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost("http://localhost:8080/msgpush/template");


        // 创建参数队列
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        formparams.add(new BasicNameValuePair("appid", "10524782571"));
        formparams.add(new BasicNameValuePair("text", "hi，please join interview at {1},this message value days."));
        formparams.add(new BasicNameValuePair("paramsNum","1"));
        UrlEncodedFormEntity uefEntity;

        try

        {
            uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
            httppost.setEntity(uefEntity);
            System.out.println("executing request " + httppost.getURI());
            CloseableHttpResponse response = httpclient.execute(httppost);
            try {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    System.out.println("--------------------------------------");
                    System.out.println("提交模板，返回模板id(id>0): " + EntityUtils.toString(entity, "UTF-8"));
                    System.out.println("--------------------------------------");
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            } finally {
                response.close();
            }
        } catch (ClientProtocolException e)
        {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e1)
        {
            e1.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        } finally
        {
            try {
                if(httpclient!=null) httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void getResult() {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost("http://localhost:8080/msgpush/callback");

        List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        formparams.add(new BasicNameValuePair("appid", "10191291000"));
        formparams.add(new BasicNameValuePair("requestCode","6"));
        formparams.add(new BasicNameValuePair("push",""));
//        formparams.add(new BasicNameValuePair("push","18627588559,15084849034"));
        UrlEncodedFormEntity uefEntity;

        try
        {
            uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
            httppost.setEntity(uefEntity);
            System.out.println("executing request " + httppost.getURI());
            CloseableHttpResponse response = httpclient.execute(httppost);
            try {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    System.out.println("--------------------------------------");
                    System.out.println("提交查询，返回json: " + EntityUtils.toString(entity, "UTF-8"));
                    System.out.println("--------------------------------------");
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            } finally {
                response.close();
            }
        } catch (ClientProtocolException e)
        {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e1)
        {
            e1.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        } finally
        {
            // 关闭连接,释放资源
            try {
                if(httpclient!=null) httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void reply2User() {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost("http://localhost:8080/pubsub/reply2User");

        List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        formparams.add(new BasicNameValuePair("appid", "10191291000"));
        formparams.add(new BasicNameValuePair("requestCode","6"));
        formparams.add(new BasicNameValuePair("pushAddress","18627588559"));
        formparams.add(new BasicNameValuePair("replyText","zai ma."));
        UrlEncodedFormEntity uefEntity;

        try
        {
            uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
            httppost.setEntity(uefEntity);
            System.out.println("executing request " + httppost.getURI());
            CloseableHttpResponse response = httpclient.execute(httppost);
            try {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    System.out.println("--------------------------------------");
                    System.out.println("提交查询，返回json: " + EntityUtils.toString(entity, "UTF-8"));
                    System.out.println("--------------------------------------");
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            } finally {
                response.close();
            }
        } catch (ClientProtocolException e)
        {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e1)
        {
            e1.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        } finally
        {
            try {
                if(httpclient!=null) httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }








    public static void  main(String args[]){

//        post();
//        while(true){
//
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } finally {
//                post();
//            }
//        }


//        register();
        post();
//        mailPost();

//        addTemplate();


//        getResult();

//        reply2User();



    }


}
