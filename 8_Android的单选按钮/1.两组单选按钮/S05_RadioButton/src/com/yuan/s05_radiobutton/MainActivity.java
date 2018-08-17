package com.yuan.s05_radiobutton;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity {
	private RadioGroup radioGroup,radioGroup1;
	private RadioButton mealButton,femalButton,goodboyButton,badboyButton;
	private TextView textView1,textView2;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        radioGroup =(RadioGroup)findViewById(R.id.radioGroupId);
        mealButton =(RadioButton)findViewById(R.id.maleButtonId);
        femalButton=(RadioButton)findViewById(R.id.femalButtonId);
        
        radioGroup1=(RadioGroup)findViewById(R.id.radioGroupId2);
        goodboyButton =(RadioButton)findViewById(R.id.goodboyButtonId);
        badboyButton =(RadioButton)findViewById(R.id.badboyButtonId);
        
        textView1 =(TextView)findViewById(R.id.textView1Id);
        textView2 =(TextView)findViewById(R.id.textView2Id);
        
        RadioGroupListener listener =new RadioGroupListener();
        radioGroup.setOnCheckedChangeListener(listener);
        radioGroup1.setOnCheckedChangeListener(listener);
    }
    class RadioGroupListener implements OnCheckedChangeListener{

		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {
			if(group == radioGroup){
				if(checkedId == R.id.maleButtonId){
					textView1.setText("选男");
				}else if(checkedId == femalButton.getId()){
					textView1.setText("选女");
				}
			}else if(group == radioGroup1){
				if(checkedId == R.id.goodboyButtonId){
					textView2.setText("选好人");
				}else{
					textView2.setText("选坏人");
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
