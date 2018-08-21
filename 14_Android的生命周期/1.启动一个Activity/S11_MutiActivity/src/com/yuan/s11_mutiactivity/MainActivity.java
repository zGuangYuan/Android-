package com.yuan.s11_mutiactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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
        //获取标签控件用对象表示
        button = (Button)findViewById(R.id.buttonId);
        //生成button类监听器实现类对象，并为button点击绑定监听器
        OnButtonListener buttonLitener = new OnButtonListener();
        button.setOnClickListener(buttonLitener);
    }
    class OnButtonListener implements OnClickListener{

		public void onClick(View v) {
			//生成意图对象
			Intent intent = new Intent();
			//调用意图的方法，setClass方法
			//setClass函数的第一个参数是Context对象
			//Context是一个类，Activity是Context的一个子类
			//所以所有的Activity对象，都可以向上转型为Context对象
			//----->|传入Activity对象，使用：MainActivity.this |<------
			//直接填this,表示是调用这个函数的对象，就是button了
			//setClass函数的第二个参数是一个Class对象
			//在当前场景，应填入需要被启动的Activity的Class对象
			intent.setClass(MainActivity.this, secondActivity.class);
			//调用startActivity,启动这个intent，这个意图就是打开另一个Activity
			startActivity(intent);
		}
    	
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
