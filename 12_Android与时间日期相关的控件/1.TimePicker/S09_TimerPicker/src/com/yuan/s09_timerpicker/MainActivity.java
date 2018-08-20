package com.yuan.s09_timerpicker;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;



public class MainActivity extends Activity {

	private TimePicker firstTimerPicker;
	private TextView textView1;
	private TextView textView2;
	private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        firstTimerPicker =(TimePicker)findViewById(R.id.timerPickerId);
        button = (Button)findViewById(R.id.buttonId);
        textView1 =(TextView)findViewById(R.id.textViewId1);
        textView2 =(TextView)findViewById(R.id.textViewId2);
        
        //生成Button的监听器对象，并为其绑定监听器
        ButtonListener buttonListener = new ButtonListener();
        button.setOnClickListener(buttonListener);
        //该方法用于设置是否使用24小时制的时钟
        firstTimerPicker.setIs24HourView(true);
        TimePickeListener listener = new TimePickeListener();
        firstTimerPicker.setOnTimeChangedListener(listener);
    }
    class ButtonListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			int hour = firstTimerPicker.getCurrentHour();
			int minute =firstTimerPicker.getCurrentMinute();
			//System.out.println("h:"+hour+",min:"+ minute);
			textView1.setText("确定时间：hour"+hour+",mintue"+minute);
		}
    	
    }

    class TimePickeListener implements OnTimeChangedListener{

    	//View代表是哪个TimePicker
    	//houOfDay用户选择哪个小时
    	//minute用户选择的分钟数
		@Override
		public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
			// TODO Auto-generated method stub
			if(view ==firstTimerPicker ){
				textView2.setText("变化时间：hour"+hourOfDay+",mintue"+minute);
				//System.out.println("hour" + hourOfDay +"    ,mimute" + minute);
			}
			
		}
    	
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
