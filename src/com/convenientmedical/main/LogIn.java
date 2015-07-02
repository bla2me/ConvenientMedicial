package com.convenientmedical.main;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;

/**
 * 登录
 * 
 * @author Mr.Codey
 *
 */
public class LogIn extends Activity {
	private static final int STATUS=1 ;//登录状态值
	private SharedPreferences preferences;//保存登录状态和cookies

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.log_in);
	}

}
