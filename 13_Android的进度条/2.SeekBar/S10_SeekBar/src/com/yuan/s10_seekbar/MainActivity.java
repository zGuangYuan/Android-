package com.yuan.s10_seekbar;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity {
	//声明引用
	private SeekBar seekBar;
	private TextView textView1,textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取控件的标签用对象的方法表示
        seekBar =(SeekBar)findViewById(R.id.seekBarId);
        textView1=(TextView)findViewById(R.id.textViewId1);
        textView2=(TextView)findViewById(R.id.textViewId2);
        //设置初始值
        seekBar.setProgress(20);
        seekBar.setSecondaryProgress(30);
        //设置监听器
        SeekBarListener listener = new SeekBarListener();
        seekBar.setOnSeekBarChangeListener(listener);
    }

    class SeekBarListener implements OnSeekBarChangeListener{

    	//seekBar代表了触发了监听器SeekBar对象
    	//progress当前SeekBar的进度
    	//fromUser参数是用户操作还是系统自动发生进度，如果是是用户，则此值为true
		public void onProgressChanged(SeekBar seekBar, int progress,
				boolean fromUser) {
				textView1.setText("progress:"+progress+",fromUser:"+fromUser);
		}

		public void onStartTrackingTouch(SeekBar seekBar) {
				textView2.setText("开始拖动");
		}
		public void onStopTrackingTouch(SeekBar seekBar) {
				textView2.setText("停止拖动");
			
		}
    	
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
