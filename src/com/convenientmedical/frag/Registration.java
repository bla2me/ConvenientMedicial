package com.convenientmedical.frag;

import com.convenientmedical.adapter.MyExpandablelistViewAdapter;
import com.convenientmedical.main.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.EditText;
import android.widget.ExpandableListView;

/**
 * @author Mr.Codey 挂号fragment
 */
public class Registration extends Fragment {

	private View registrationView;
	private ExpandableListView mListView;
	private EditText metSearch;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		registrationView = inflater.inflate(R.layout.registration, container,
				false);
		initView();
		mListView.setAdapter(new MyExpandablelistViewAdapter(getActivity()));
		mListView.setGroupIndicator(null);
		return registrationView;
	}

	private void initView() {
		mListView=(ExpandableListView)registrationView.findViewById(R.id.expandableListView_doc_or_hos);
		metSearch=(EditText)registrationView.findViewById(R.id.Et_Search_doc_Tips);
	}
}
