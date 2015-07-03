package com.convenientmedical.main;

import com.convenientmedical.pay.PayDetails;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class RegistratInfo extends Activity implements OnClickListener{
	private Button mbtCancel, mbtPay;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.registered_information);
		initView();
	}

	private void initView() {
		mbtCancel = (Button) findViewById(R.id.BT_Cancel_registration);
		mbtPay = (Button) findViewById(R.id.BT_To_pay_for);
		mbtCancel.setOnClickListener(this);
		mbtPay.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.BT_Cancel_registration:
			Intent intent=new Intent(getApplicationContext(), MainActivity.class);
			startActivity(intent);
			break;
		case R.id.BT_To_pay_for:
			Intent intent1=new Intent(getApplicationContext(), PayDetails.class);
			startActivity(intent1);
		default:
			break;
		}
	}
}
