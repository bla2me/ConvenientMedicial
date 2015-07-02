package com.convenientmedical.frag;

import com.convenientmedical.main.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author Mr.Codey
 *  挂号fragment
 */
public class Registration extends Fragment {
	
private View registrationView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		registrationView=inflater.inflate(R.layout.registration, container,false);
		return registrationView;
	}

}
