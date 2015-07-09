package com.convenientmedical.frag;

import com.convenientmedical.main.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author Mr.Codey
 * 资讯fragment
 */
public class Diagnoses extends Fragment {
private View diagView;
//private ExpandableListView mexpandList;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		diagView =inflater.inflate(R.layout.diagnoses, container,false);
		return diagView;
	}

}
