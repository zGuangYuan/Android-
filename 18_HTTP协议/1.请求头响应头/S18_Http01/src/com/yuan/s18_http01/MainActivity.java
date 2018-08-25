package com.yuan.s18_http01;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button =(Button)findViewById(R.id.buttonId);
        
        button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//原则：在主线程当中不能访问网络
				//主线程用来接受用户的触摸和接受数据的
				NetWorkThread ttNetWorkThread =new NetWorkThread();
				ttNetWorkThread.start();
			}
		});
    }

    class NetWorkThread extends Thread{
		@Override
		public void run() {
			//创建HttpClient
			HttpClient httpClient = new DefaultHttpClient();
			//创建代表请求的对象，参数是访问的服务器的地址
			//
			HttpGet httpGet = new HttpGet("https://blog.csdn.net/qq_36243942");
			//获取请求头所有的信息
			Header reqHeader[]=httpGet.getAllHeaders();
			//打印请求头的内容
			for (int i = 0; i < reqHeader.length; i++) {
				String name = reqHeader[i].getName();
				String value = reqHeader[i].getValue();
				Log.d("Http","reqHeader name:"+name+",value:"+value);
			}
			//执行请求，获取服务器发还的响应对象
			try {
				HttpResponse resp = httpClient.execute(httpGet);
				//检查响应的状态是否正常,等于200正常
				int code = resp.getStatusLine().getStatusCode();
				//得到响应头的内容
				Header resHeader[]=httpGet.getAllHeaders();
				//打印请求头的内容
				for (int i = 0; i < resHeader.length; i++) {
					String name = resHeader[i].getName();
					String value = resHeader[i].getValue();
					Log.d("Http","resqHeader name:"+name+",value:"+value);
				}
				if(code == 200){
					//从响应对象取出数据
					HttpEntity entity = resp.getEntity();
					InputStream in = entity.getContent();
					BufferedReader reader = new BufferedReader(new InputStreamReader(in));
					String line = reader.readLine();
					Log.d("HTTP","从服务器取出的数据为"+line);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
    	
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
