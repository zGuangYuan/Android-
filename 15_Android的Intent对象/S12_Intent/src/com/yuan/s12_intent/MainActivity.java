package com.yuan.s12_intent;


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
        
        button =(Button)findViewById(R.id.buttonId);
        OnButtonListener listener =new OnButtonListener();
        button.setOnClickListener(listener);
    }

    class OnButtonListener implements OnClickListener{

		public void onClick(View v) {
			//生成意图对象
			Intent intent = new Intent();
			intent.setClass(MainActivity.this, SecondActivity.class);
			intent.putExtra("com.yuan.s12_intent.Age", 30);
			intent.putExtra("com.yuan.s12_intent.name", "张三");
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
