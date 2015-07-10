package com.convenientmedical.diagnoses;

import com.convenientmedical.main.R;
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
import android.widget.TextView;

public class IllDetailsActivity extends Activity {
	private ImageButton mibBack;
	private Button mButton;
	private TextView mtvPay, mtvCheck;
	private String payString, checkString;
	private SharedPreferences preferences;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.blood_test);
		initView();
		setButtonText();
		preferences=getSharedPreferences("myshare", MODE_PRIVATE);
		mibBack.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		mButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (payString.equals("未缴费")) {
					// mButton.setText("缴费");
					SharePreferenceUtil.getInstanse().putIntData(preferences, "pay_from", 1);
					Intent intent = new Intent(getApplicationContext(),
							PayDetails.class);
					startActivity(intent);
				} else if (checkString.equals("未签到")) {
					// mButton.setText("签到");
					finish();
				} else {
					// mButton.setText("查看检查报告");
					Intent intent = new Intent(getApplicationContext(),
							IllDetailsResportActivity.class);
					startActivity(intent);
				}
			}
		});
	}

	private void initView() {
		mibBack = (ImageButton) findViewById(R.id.Ib_left);
		mButton = (Button) findViewById(R.id.BT_Inspection_report);
		mtvPay = (TextView) findViewById(R.id.Tv_Payment_status_result);
		mtvCheck = (TextView) findViewById(R.id.Tv_Sign_in_state_result);
	}

	/**
	 * 设置字体
	 */
	private void setButtonText() {
		payString = mtvPay.getText().toString().trim();
		checkString = mtvCheck.getText().toString().trim();
		if (payString.equals("未缴费")) {
			mButton.setText("缴费");
		} else if (checkString.equals("未签到")) {
			mButton.setText("签到");
		} else {
			mButton.setText("查看检查报告");
		}
	}
}
