package com.convenientmedical.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout;

public class splash extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		LinearLayout ll_splash_main;
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		ll_splash_main = (LinearLayout) findViewById(R.id.ll_splash_main);
		AlphaAnimation aa = new AlphaAnimation(0.1f, 1.0f);
		aa.setDuration(10000);
		ll_splash_main.startAnimation(aa); 
		new Handler().postDelayed(new Runnable() {  
		      
		    @Override  
		    public void run() {  
		        Intent  intent=new Intent(splash.this, MainActivity.class);  
		        startActivity(intent);  splash.this.finish();   
		    }  
		}, 5000);  

	}
}
