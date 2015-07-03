package com.convenientmedical.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

/**
 * @author Mr.Codey
 *注册的activity
 */
public class SignUpActivity extends Activity {
private Button mbtSignUp;
private EditText metUserName,metPwd,metRePwd;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.registered);
		mbtSignUp.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.setClass(getApplicationContext(), MainActivity.class);
			}
		});
	}
	private void initView()
	{
		mbtSignUp=(Button)findViewById(R.id.BT_register);
		metUserName=(EditText)findViewById(R.id.Et_username);
		metPwd=(EditText)findViewById(R.id.Et_password);
		metRePwd=(EditText)findViewById(R.id.Et_againpassword);
	}

}
