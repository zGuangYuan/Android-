package com.yuan.s11_activitylifecycle;

import android.app.Activity;
import android.os.Bundle;

public class SecondActivity extends Activity {
	 protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.second_activity);
	        System.out.println("SecondActivity:onCreate");
	    }
		protected void onDestroy() {
			super.onDestroy();
			System.out.println("SecondActivity:onDestroy");
		}
		protected void onPause() {
			super.onPause();
			System.out.println("SecondActivity:onPause");
		}
		protected void onRestart() {
			super.onRestart();
			System.out.println("SecondActivity:onRestart");
		}
		protected void onResume() {
			super.onResume();
			System.out.println("SecondActivity:onResume");
		}
		protected void onStart() {
			super.onStart();
			System.out.println("SecondActivity:onStart");
		}
		protected void onStop() {
			super.onStop();
			System.out.println("SecondActivity:onStop");
		}

}
