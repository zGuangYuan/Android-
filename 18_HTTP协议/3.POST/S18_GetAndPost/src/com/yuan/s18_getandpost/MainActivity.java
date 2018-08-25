package com.yuan.s18_getandpost;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	private Button button;
	private EditText nameText;
	private EditText pwdText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button =(Button)findViewById(R.id.buttonId);
        nameText =(EditText)findViewById(R.id.nameText);
        pwdText =(EditText)findViewById(R.id.pswText);
        
        button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//获取输入的用户名密码
				String name =nameText.getText().toString();
				String pwd = pwdText.getText().toString();
				//使用Get方法向服务器发送请求
				//GetThread tt = new GetThread(name,pwd);
				//tt.start();
				
				
				//使用POST方法向服务器发送请求
				PostThread td = new PostThread(name,pwd);
				td.start();
			}
		});
    }
    //用线程使用GET方法向服务发送请求
    class GetThread extends Thread{
    	//把主线程获取的用户名密码获取出来
    	String name;
    	String pwd;
    	//创建一个构造函数
    	public GetThread(String name,String pwd){
    		this.name=name;
    		this.pwd =pwd;
    	}
		@Override
		public void run() {
			//创建HttpClient
			HttpClient httpClient = new DefaultHttpClient();
			String url = "http://192.168.1.113:8080/s18http.jsp?name="+name+"&passward="+pwd;
			
			//创建代表请求的对象，参数是访问的服务器的地址
			HttpGet httpGet = new HttpGet(url);
			try {
				HttpResponse resp = httpClient.execute(httpGet);
				//检查响应的状态是否正常,等于200正常
				if( resp.getStatusLine().getStatusCode()== 200){
					//从响应对象取出数据
					HttpEntity entity = resp.getEntity();
					InputStream in = entity.getContent();
					BufferedReader reader = new BufferedReader(new InputStreamReader(in));
					String line = reader.readLine();
					Log.d("HTTPGET","从服务器取出的数据为"+line);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
    	
    }
  //用线程使用POST向服务器发送请求
    class PostThread extends Thread{
    	//把主线程获取的用户名密码获取出来
    	String name;
    	String pwd;
    	//创建一个构造函数
    	public PostThread(String name,String pwd){
    		this.name=name;
    		this.pwd =pwd;
    	}
		@Override
		public void run() {
			//创建HttpClient
			HttpClient httpClient = new DefaultHttpClient();
			//跟刚才Url不一样
			//Post和Get最大的区别是，POST有请求体，而GET没有请求体
			String url ="http://192.168.1.113:8080/s18http.jsp?";
			//生成POST的请求对象
			HttpPost httpPost = new HttpPost(url);
			
			//创建键值对对象 ,NameValuePair对象代表了一个需要发往服务器的键值对
			NameValuePair pair1 = new BasicNameValuePair("name", name);
			NameValuePair pair2 = new BasicNameValuePair("passward", pwd);
			//将准备好的键值对对象放置在一个List当中
			ArrayList<NameValuePair> pairs = new ArrayList<NameValuePair>();
			//把两个键值对，放入键值对List
			pairs.add(pair1);
			pairs.add(pair2);
			//创建代表请求体的对象
			try {
				//所以这个请求体包含了键值对对象的List
				HttpEntity requesEntity = new UrlEncodedFormEntity(pairs);
				//将请求体放置在请求对象当中
				httpPost.setEntity(requesEntity);
				//执行请求对象
				try {
					HttpResponse resp = httpClient.execute(httpPost);
					//检查响应的状态是否正常,等于200正常
					if( resp.getStatusLine().getStatusCode()== 200){
						//从响应对象取出数据
						HttpEntity entity = resp.getEntity();
						InputStream in = entity.getContent();
						BufferedReader reader = new BufferedReader(new InputStreamReader(in));
						String line = reader.readLine();
						Log.d("HTTPPOST","服务器的数据为"+line);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
    	
    }
    //使用POST方法向服务器发送请求
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
