package com.convenientmedical.pay;

import com.convenientmedical.main.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class PayMethod extends Activity {
private Button mbtPay;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.payment_method);
		mbtPay=(Button)findViewById(R.id.BT_sure);
		mbtPay.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "缴费成功", Toast.LENGTH_SHORT).show();
			}
		});
	}

}
