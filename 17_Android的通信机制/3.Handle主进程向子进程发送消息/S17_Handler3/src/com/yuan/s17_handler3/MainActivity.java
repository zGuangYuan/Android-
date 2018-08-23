package com.yuan.s17_handler3;


import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends Activity {

	private Button button;
	private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       //获取代表控件的对象
        button =(Button)findViewById(R.id.buttonId3);
        //创建线程对象，启动MyThread线程
        Thread ft = new MyThread();
        ft.start();
     
        //生成监听器对象，绑定监听器，使用匿名内部类方法
        button.setOnClickListener(new OnClickListener(){
			@Override  
			public void onClick(View v) {
				System.out.println("onClick---->"+Thread.currentThread().getName());
				//得到一个Message对象
				Message msg = handler.obtainMessage();
				//给msg的what属性赋值
				msg.what=10;
				//这个Message对象就会发送消息队列里
				handler.sendMessage(msg);
			}
        	
        });
    }
   
    //子线程
    class MyThread extends Thread{
		@Override
		public void run() {
			//准备Looper对象
			Looper.prepare();
			//在Work Thread生成一个Handler对象
			//使用匿名内部类实现
			handler = new Handler(){
				@Override
				public void handleMessage(Message msg) {
					System.out.println("handleMessage---->"+Thread.currentThread().getName());
					System.out.println("收到了从MainThread传来的消息："+msg.what);
				}
			};
			//调用Looper的loop（）方法之后，Looper对象不断从消息队列中取出消息对象
			//然后调用handler的handleMessage（）方法处理该消息对象
			//如果消息队列中没有消息，则线程阻塞
			Looper.loop();
		}
    	
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
