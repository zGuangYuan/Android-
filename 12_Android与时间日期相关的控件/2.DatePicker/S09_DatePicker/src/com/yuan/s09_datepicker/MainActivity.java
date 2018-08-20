package com.yuan.s09_datepicker;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class MainActivity extends Activity {
    //声明变量
	private DatePicker datePicker;
	private Button button;
	private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取控件的标签用对象表示
        datePicker = (DatePicker)findViewById(R.id.datePickerId);
        textView = (TextView)findViewById(R.id.TextViewId);
        button = (Button)findViewById(R.id.buttonId);
        //设置默认时间
        datePicker.updateDate(2018, 8, 20);
        //为Button绑定监听器
        ButtonListener listener =new ButtonListener();
        button.setOnClickListener(listener);
    }

    //实现OnClickListener接口
    class ButtonListener implements OnClickListener{
		@Override
		//复写onClick方法
		public void onClick(View v) {
			// TODO Auto-generated method stub
			int y = datePicker.getYear();
			int m = datePicker.getMonth()+1;
			int d =datePicker.getDayOfMonth();
			//显示时间，因为Java月份从0开始算起，所以m需要加一
			textView.setText("当前时间  ："+y+"年"+m+"月"+d+"日");	
		}
    	
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
