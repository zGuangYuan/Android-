package com.yuan.s04_checkbox;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;


public class MainActivity extends Activity {

	private CheckBox eatBox;
	private CheckBox sleepBox;
	private CheckBox readBox;
	private CheckBox allSelectBox;
	private TextView textView1;
	private TextView textView2;
	private TextView textView3;
	private TextView allSelect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        eatBox = (CheckBox)findViewById(R.id.eatId);
        sleepBox=(CheckBox)findViewById(R.id.sleepId);
        readBox =(CheckBox)findViewById(R.id.readId);;
        allSelectBox =(CheckBox)findViewById(R.id.allSelectId);
        textView1 =(TextView)findViewById(R.id.textview1);
        textView2 =(TextView)findViewById(R.id.textview2);
        textView3 =(TextView)findViewById(R.id.textview3);
        allSelect =(TextView)findViewById(R.id.allselect);
        //生成监听器类的对象
        CheckBoxLitener listener = new CheckBoxLitener();
        //为三个多选框绑定同一个监听器对象
        //这三个控件，无论哪个被点击，都会执行listener的onCheckedChanged方法
        eatBox.setOnCheckedChangeListener(listener);
        sleepBox.setOnCheckedChangeListener(listener);
        readBox.setOnCheckedChangeListener(listener);
        allSelectBox.setOnCheckedChangeListener(listener);
    }
    class CheckBoxLitener implements OnCheckedChangeListener{

		@Override
		public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
			if(isChecked){
				if(buttonView.getId()==R.id.eatId){
					textView1.setText("吃饭被选中");
				}
				else if(buttonView.getId()==R.id.sleepId){
					textView2.setText("睡觉被选中");
				}else if(buttonView.getId()==R.id.readId){
					textView3.setText("看书被选中");
				}else{
					allSelect.setText("全选选中");
					eatBox.setChecked(isChecked);
					sleepBox.setChecked(isChecked);
					readBox.setChecked(isChecked);
				}
			}else{
				if(buttonView.getId()==R.id.eatId){
					textView1.setText("吃饭未选中");
				}
				else if(buttonView.getId()==R.id.sleepId){
					textView2.setText("睡觉未选中");
				}else if(buttonView.getId()==R.id.readId){
					textView3.setText("看书未选中");
				}else{
					allSelect.setText("全选未选");
					eatBox.setChecked(false);
					sleepBox.setChecked(false);
					readBox.setChecked(false);
				}
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
