package com.convenientmedical.frag;

import com.convenientmedical.adapter.MyExpandablelistViewAdapter;
import com.convenientmedical.main.R;
import com.convenientmedical.main.RegistratInfo;
import com.convenientmedical.main.SelectAreaList;
import com.convenientmedical.main.SelectDepartmentActivity;
import com.convenientmedical.main.SelectDoctorList;
import com.convenientmedical.main.SelectHosActivity;
import com.convenientmedical.search.DoctorSearchResult;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.webkit.WebView.FindListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

/**
 * @author Mr.Codey 挂号fragment
 */
public class Registration extends Fragment {

	private View registrationView;
	private ExpandableListView mListView;
	private EditText metSearch;
	private RelativeLayout mrlChooseArea, mSelectHos, mSelectDept, mSelectDoc;
	private Button mbtReservation;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		registrationView = inflater.inflate(R.layout.registration, container,
				false);
		initView();
		mListView.setAdapter(new MyExpandablelistViewAdapter(getActivity()));
		mListView.setGroupIndicator(null);
		// 搜索事件
		metSearch.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				metSearch.setFocusable(true);
			}
		});
		/*metSearch.setOnEditorActionListener(new OnEditorActionListener() {

			@Override
			public boolean onEditorAction(TextView v, int actionId,
					KeyEvent event) {
				// TODO Auto-generated method stub
				if (actionId == EditorInfo.IME_ACTION_SEARCH) {
					Intent intent = new Intent(getActivity(),
							DoctorSearchResult.class);
					startActivity(intent);
				}
				return false;
			}
		});*/
		// 选择地区的点击事件
		mrlChooseArea.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getActivity(), SelectAreaList.class);
				startActivity(intent);
			}
		});
		// 选择医院的点击事件
		mSelectHos.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getActivity(),
						SelectHosActivity.class);
				startActivity(intent);
			}
		});
		// 选择科室的点击事件
		mSelectDept.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getActivity(),
						SelectDepartmentActivity.class);
				startActivity(intent);
			}
		});
		// 选择医生的点击事件
		mSelectDoc.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getActivity(),
						SelectDoctorList.class);
				startActivity(intent);
			}
		});
		//预约挂号的点击事件
		mbtReservation.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getActivity(), RegistratInfo.class);
				startActivity(intent);
			}
		});
		return registrationView;
	}

	private void initView() {
		mListView = (ExpandableListView) registrationView
				.findViewById(R.id.expandableListView_doc_or_hos);
		mrlChooseArea = (RelativeLayout) registrationView
				.findViewById(R.id.rl_1);
		mSelectHos = (RelativeLayout) registrationView.findViewById(R.id.rl_2);
		mSelectDept = (RelativeLayout) registrationView.findViewById(R.id.rl_3);
		mSelectDoc = (RelativeLayout) registrationView.findViewById(R.id.rl_4);
		metSearch = (EditText) registrationView
				.findViewById(R.id.Et_Search_doc_Tips);
		mbtReservation = (Button) registrationView
				.findViewById(R.id.bt_reservation);
	}
}
