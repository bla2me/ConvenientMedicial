package com.convenientmedical.frag;

import com.convenientmedical.main.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author Mr.Codey
 *  支付fragment
 */
public class Pay extends Fragment {
private View payView;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		payView=inflater.inflate(R.layout.pay, container,false);
		return payView;
	}

}
 