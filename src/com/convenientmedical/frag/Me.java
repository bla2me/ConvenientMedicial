package com.convenientmedical.frag;

import com.convenientmedical.main.R;
import com.convenientmedical.me.SocialCard;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * @author Mr.Codey 个人信息fragment
 */
public class Me extends Fragment {
	private View meView;
	private TextView mSocialCard;
	private ImageButton mSocialImg;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		meView = inflater.inflate(R.layout.personal_information, container,
				false);
		initView();
		mSocialCard.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(getActivity(),SocialCard.class);
				startActivity(intent);
			}
		});
		return meView;
	}

	private void initView() {
		mSocialCard=(TextView)meView.findViewById(R.id.Tv_My_social_security_card);
		mSocialImg=(ImageButton)meView.findViewById(R.id.Ib_Right2);
	}

/*	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent;
		switch (v.getId()) {
		case R.id.Tv_My_social_security_card:
			intent=new Intent(getActivity(),SocialCard.class);
			startActivity(intent);
			break;
		case R.id.Ib_Right2:
			intent=new Intent(getActivity(),SocialCard.class);
			startActivity(intent);
			break;

		default:
			intent=new Intent(getActivity(),SocialCard.class);
			startActivity(intent);
			break;
		}
	}*/
}
