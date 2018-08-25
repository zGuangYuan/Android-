package com.yuan.s18_getandpost;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
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
				
				GetThread tt = new GetThread(name,pwd);
				tt.start();
			}
		});
    }
    //用线程把数据发给服务器
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
