package com.yaun.s17_handler4;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	private Button button;
	private Handler handler =new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button =(Button)findViewById(R.id.buttonId);
        
        
        button.setOnClickListener(new OnClickListener(){
			
			@Override
			public void onClick(View v) {
				TestThread tt =new TestThread();
				tt.start();
			}
		}); 
    }
    //Worker Thread
    class TestThread extends Thread{
		@Override
		public void run() {
			//在网络上取回数据
			Runnable r = new Runnable(){
				@Override
				public void run() {
					
					System.out.println("线程名字--->"+Thread.currentThread().getName());
				}	
			};
			handler.post(r);		
			
		}
    	
    }
   
    
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
