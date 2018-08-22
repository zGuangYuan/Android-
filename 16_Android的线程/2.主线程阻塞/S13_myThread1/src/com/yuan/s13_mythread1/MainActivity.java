package com.yuan.s13_mythread1;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView textView;
	private Button button;
	private ProgressBar progressBar;
	//Main Thread
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取控件的对象
        textView =(TextView)findViewById(R.id.textViewId);
        button =(Button)findViewById(R.id.buttonId);
        progressBar=(ProgressBar)findViewById(R.id.progressBarId);
        //绑定监听器
        OnButtonListener listener = new OnButtonListener();
        button.setOnClickListener(listener);
    }
    class OnButtonListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			try {
				Thread.sleep(10*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			Thread ft = new MyThread();
//    		ft.start();
		}
    		
    }
//    //Work Thread
//    class MyThread extends Thread{
//
//		@Override
//		public void run() {
//			for(int i =0;i<100;i++){
//				try {
//					Thread.sleep(100); //休眠0.1s.
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//				progressBar.setProgress(progressBar.getProgress()+1);	
//			}
//		}
//    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
