package com.yuan.s12_intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends Activity {
	//声明引用
	private TextView textView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//使用setContentView(View)来显示指定控件
		setContentView(R.layout.activity_second);
		//获取代表空间的对象
		textView =(TextView)findViewById(R.id.secondTextViewId2);
		//生成意图对象
		Intent intent = getIntent();
		//获取意图对象的数据
		int age = intent.getIntExtra("com.yuan.s12_intent.Age", 10);
		String name =intent.getStringExtra("com.yuan.s12_intent.name");
		//显示获取到的值
		textView.setText("Age:"+age+",name:"+name);
	}

}
