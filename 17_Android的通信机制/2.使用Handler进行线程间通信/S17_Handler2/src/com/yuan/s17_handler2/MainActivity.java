package com.yuan.s17_handler2;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {
	//声明引用
	private TextView textView;
	private Button button;
	private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取代表控件的对象
        textView =(TextView)findViewById(R.id.textViewId2);
        button =(Button)findViewById(R.id.buttonId2);
        //生成一个handler对象
        handler = new MyHandler();
        //生成监听器对象，绑定监听器
        button.setOnClickListener(new OnbuttonListener());
    }
    class MyHandler extends Handler{
		@Override
		public void handleMessage(Message msg) {
			//打印当前线程的名字
	    	System.out.println("handlerMessage-->"+ Thread.currentThread().getName());
	    	//在主线程的MyHandler接受 msg
	    	String s=(String)msg.obj;
	    	//主线程修改TextView的属性
	    	textView.setText(s);
		}
    	
    }
    class OnbuttonListener implements OnClickListener{
		@Override
		public void onClick(View v) {
			Thread ft =new NetWorkThread();
			ft.start();
		}
    }
    //模拟一个网络线程
    class NetWorkThread extends Thread{
		@Override
		public void run() {
			//打印当前线程的名字
	    	System.out.println("netWork-->"+ Thread.currentThread().getName());
			//模拟访问网络，线程运行时，休眠2s
			try {
				Thread.sleep(2*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//变量s的值，模拟从网络当中获取的数据
			//应为这里不是UI线程，所以不能去修改UI的属性，除非特殊控件
			String s = "从网络获取的数据";
			//生成Message对象
			Message msg = handler.obtainMessage();
			//把s的值赋值给，msg的obj属性
			msg.obj =s;
			//把消息发送到消息队列里面，Looper就会自动把消息取出来
			//然后用相对应的Handler对象的handleMessage去处理Message对象。
			handler.sendMessage(msg);
		}
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
