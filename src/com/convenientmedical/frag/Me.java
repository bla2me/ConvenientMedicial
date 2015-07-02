package com.convenientmedical.frag;

import com.convenientmedical.main.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author Mr.Codey
 * 个人信息fragment
 */
public class Me extends Fragment {
private View meView;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		meView=inflater.inflate(R.layout.me, container,false);
		return meView;
	}

}
