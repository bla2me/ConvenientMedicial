package com.convenientmedical.pay;

import com.convenientmedical.main.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class PayDetails extends Activity implements OnClickListener{
private Button mbtPay;
private Button mbtGiveUp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.payment_details);
	}
	private void initView()
	{
		mbtPay=(Button)findViewById(R.id.BT_Pay);
		mbtGiveUp=(Button)findViewById(R.id.BT_To_give_up);
		mbtPay.setOnClickListener(this);
		mbtGiveUp.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.BT_Pay:
			Intent intent=new Intent(getApplicationContext(), PayMethod.class);
			startActivity(intent);
			break;
		case R.id.BT_To_give_up:
		default:
			break;
		}
	}

}
