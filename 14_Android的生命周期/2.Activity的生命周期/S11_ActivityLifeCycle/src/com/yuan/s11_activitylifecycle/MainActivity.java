package com.yuan.s11_activitylifecycle;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	//生命引用
	private Button button;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("MainActivity:onCreate");
        //获取控件的标签用对象表示
        button =(Button)findViewById(R.id.buttonId);
        //生成监听器实现类的对象，并为button绑定监听器
        OnButonListener listener = new OnButonListener();
        button.setOnClickListener(listener);
    }
	protected void onDestroy() {
		super.onDestroy();
		System.out.println("MainActivity:onDestroy");
	}
	protected void onPause() {
		super.onPause();
		System.out.println("MainActivity:onPause");
	}
	protected void onRestart() {
		super.onRestart();
		System.out.println("MainActivity:onRestart");
	}
	protected void onResume() {
		super.onResume();
		System.out.println("MainActivity:onResume");
	}
	protected void onStart() {
		super.onStart();
		System.out.println("MainActivity:onStart");
	}
	protected void onStop() {
		super.onStop();
		System.out.println("MainActivity:onStop");
	}
	class OnButonListener implements OnClickListener{

		public void onClick(View v) {
			//生成意图对象
			Intent intent = new Intent();
			intent.setClass(MainActivity.this,SecondActivity.class );
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
