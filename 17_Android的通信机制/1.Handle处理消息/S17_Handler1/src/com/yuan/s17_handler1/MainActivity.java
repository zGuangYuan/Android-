package com.yuan.s17_handler1;

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
        //获取控件的标签用对象表示
        button =(Button)findViewById(R.id.buttonId);
        textView =(TextView)findViewById(R.id.textViewId);
        handler = new FirstHandler(); 
        //生成监听器对象，为button绑定监听器
        OnButtonListener listener =new OnButtonListener();
        button.setOnClickListener(listener);
    }
    //当用户点下按钮后，就会创建一个消息对象，并且给这个消息对象的what属性赋值为2
    //然后调用handler的sendMessage方法，把msg对象发送到消息队列去
    //当消息队列有东西之后，Looper就会从消息队列中将消息对象取出
    //Looper将会找到与消息对象对应的Handler对象
    //Looper将会调用Handler对象的handlerMessage(Message,msg)方法，用于处理消息对象
    class OnButtonListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			//当用户点击按钮时，创建一个消息对象，并使用Handler发送该对象
			//创建消息对象
			Message msg = handler.obtainMessage();//每个消息对象，都有与之对应的Handler对象
			//调用消息对象的属性 what,赋值为2
			msg.what =2;
			//调用Handler方法，把消息对象放入到消息队列当中去
			handler.sendMessage(msg);
		}	
    }
    //也就是调用这个对象的的HandlerMessage方法
    class FirstHandler extends Handler{
		@Override
		public void handleMessage(Message msg) {
			int what = msg.what;
			textView.setText("what:"+what);
		}
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
