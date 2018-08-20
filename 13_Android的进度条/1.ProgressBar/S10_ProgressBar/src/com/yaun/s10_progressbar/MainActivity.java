package com.yaun.s10_progressbar;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
//导入一些包
public class MainActivity extends Activity {
	//声明引用
	private ProgressBar progressBar;
	private Button firstButton,secondButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取控件的标签用对象的方法表示
        progressBar = (ProgressBar)findViewById(R.id.ProgressBarId);
        firstButton =(Button)findViewById(R.id.firstButtonId);
        secondButton= (Button)findViewById(R.id.secondButtonId);
        //设最大值
        progressBar.setMax(100);
        //设置第一进度条的值
        progressBar.setProgress(20);
        //设第二进度条的值
        progressBar.setSecondaryProgress(50);
        //生成监听器对象，并未两个按钮绑定监听器
        OnButtonListener1 listener1 =new OnButtonListener1();
        OnbuttonListener2 listener2 =new OnbuttonListener2();
        firstButton.setOnClickListener(listener1);
        secondButton.setOnClickListener(listener2);
        
    }
    //实现按钮监听器的类
    class OnButtonListener1 implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			progressBar.incrementProgressBy(10);	
		}  	
    }
    //实现按钮监听器的类
    class OnbuttonListener2 implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			progressBar.incrementSecondaryProgressBy(20);
		}
    	
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
