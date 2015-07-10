package com.convenientmedical.main;

import com.convenientmedical.pay.PayDetails;
import com.convenitentmedical.savedata.SharePreferenceUtil;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class RegistratInfo extends Activity implements OnClickListener{
	private Button mbtCancel, mbtPay;
	private ImageButton mibBack;
	private  int status;
	private SharedPreferences preferences;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.registered_information);
		preferences=getSharedPreferences("myshare", MODE_PRIVATE);
		initView();
	}
	

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		setButtonFromStatus();
	}


	private void setButtonFromStatus() {
		if(getIntent()!=null)
		{
		Intent intent=getIntent();
		status=intent.getIntExtra("status", 0);
		if(status==1)
		{
			mbtPay.setVisibility(View.GONE);
			mbtCancel.setText("取消问诊");
		}
		}
		
	}

	private void initView() {
		mibBack=(ImageButton)findViewById(R.id.Ib_back);
		mbtCancel = (Button) findViewById(R.id.BT_Cancel_registration);
		mbtPay = (Button) findViewById(R.id.BT_To_pay_for);
		mbtCancel.setOnClickListener(this);
		mbtPay.setOnClickListener(this);
		mibBack.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.Ib_back:
			finish();
		case R.id.BT_Cancel_registration:
			if(mbtCancel.getText().equals("取消问诊"))
			{
				Intent intent=new Intent(getApplicationContext(),MainActivity.class);
				startActivity(intent);
			}
			finish();
			break;
		case R.id.BT_To_pay_for:
			SharePreferenceUtil.getInstanse().putIntData(preferences, "pay_from", 0);
			Intent intent1=new Intent(getApplicationContext(), PayDetails.class);
			startActivity(intent1);
		default:
			break;
		}
	}
}
