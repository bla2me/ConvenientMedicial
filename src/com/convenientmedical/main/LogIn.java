package com.convenientmedical.main;

import android.app.Activity;
import android.app.DownloadManager.Request;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

/**
 * 登录
 * 
 * @author Mr.Codey
 *
 */
public class LogIn extends Activity implements OnClickListener {
	private static final int LOG_IN_STATUS = 1;// 登录状态值
	private SharedPreferences preferences;// 保存登录状态和cookies
	private Button mbtLogIn, mbtSignup, mbtNoLogIn;
	private EditText mUserName, mPwd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.log_in);
		initView();
	}

	/**
	 * 实例化控件
	 */
	private void initView() {
		mbtSignup = (Button) findViewById(R.id.Bt_register);
		mbtNoLogIn = (Button) findViewById(R.id.Bt_nolanding);
		mbtLogIn = (Button) findViewById(R.id.BT_landing);
		mUserName = (EditText) findViewById(R.id.Et_username);
		mPwd = (EditText) findViewById(R.id.Et_password);
		mbtSignup.setOnClickListener(this);
		mbtNoLogIn.setOnClickListener(this);
		mbtLogIn.setOnClickListener(this);
	}

	/**
	 * 点击事件处理
	 */
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent = new Intent();
		switch (v.getId()) {
		case R.id.Bt_register:
			intent.setClass(getApplicationContext(), SignUpActivity.class);
			startActivity(intent);
			break;
		case R.id.Bt_nolanding:
			intent.setClass(getApplicationContext(), MainActivity.class);
			startActivity(intent);
			break;
		case R.id.BT_landing:
		default:
			intent.setClass(getApplicationContext(), MainActivity.class);
			startActivity(intent);
			break;
		}
	}

}
