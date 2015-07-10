package com.convenientmedical.frag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.convenientmedical.adapter.IllDetailsListAdapter;
import com.convenientmedical.main.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;

/**
 * @author Mr.Codey 资讯fragment
 */
public class Diagnoses extends Fragment implements OnClickListener {
	private View diagView;
	// private LinearLayout mLinClick1,mLinClick2,mLinClick3;
	private ListView  mCheckListView,mMedicalListView;
	private List<HashMap<String, Object>> mCheckList,mMedicalList;
	private HashMap<String, Object> mCheckHash,mMedicalHash;
	private LinearLayout mlIllDetails, mlCheckDetails, mlMedicalDetails;
	private RelativeLayout mrlIllDetails, mrlCheckDetails, mrlMedicalDetails;

	// private ExpandableListView mexpandList;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		diagView = inflater.inflate(R.layout.diagnoses, container, false);
		mCheckList=new ArrayList<HashMap<String,Object>>();
		mMedicalList=new ArrayList<HashMap<String,Object>>();
		
		return diagView;
	}

	private void initView() {
		/*
		 * mLinClick1=(LinearLayout)diagView.findViewById(R.id.lin_click1);
		 * mLinClick2=(LinearLayout)diagView.findViewById(R.id.lin_click2);
		 * mLinClick3=(LinearLayout)diagView.findViewById(R.id.lin_click3);
		 * mLinClick1.setOnClickListener(this);
		 * mLinClick2.setOnClickListener(this);
		 * mLinClick3.setOnClickListener(this);
		 */
		mCheckListView=(ListView)diagView.findViewById(R.id.check_list);
		mMedicalListView=(ListView)diagView.findViewById(R.id.medical_list);
		mlIllDetails = (LinearLayout) diagView.findViewById(R.id.ill_details);
		mlCheckDetails = (LinearLayout) diagView
				.findViewById(R.id.check_details);
		mlMedicalDetails = (LinearLayout) diagView
				.findViewById(R.id.medical_details);
/*		mlIllDetails.setOnClickListener(this);
		mlCheckDetails.setOnClickListener(this);
		mlMedicalDetails.setOnClickListener(this);*/
		mrlIllDetails = (RelativeLayout) diagView.findViewById((R.id.rl_t1));
		mrlCheckDetails = (RelativeLayout) diagView.findViewById((R.id.rl_t2));
		mrlMedicalDetails = (RelativeLayout) diagView
				.findViewById((R.id.rl_t3));
		mrlIllDetails.setOnClickListener(this);
		mrlCheckDetails.setOnClickListener(this);
		mrlMedicalDetails.setOnClickListener(this);

	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		initView();
		setCheckData();
		setMedicalData();
		setCheckListAdapter();
		setMedicalListAdapter();

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.rl_t1:
			if (mlIllDetails.getVisibility() == View.VISIBLE) {
				mlIllDetails.setVisibility(View.GONE);
			} else if (mlIllDetails.getVisibility() == View.GONE) {
				mlIllDetails.setVisibility(View.VISIBLE);
			}

			break;
		case R.id.rl_t2:
			if (mlCheckDetails.getVisibility() == View.VISIBLE) {
				mlCheckDetails.setVisibility(View.GONE);
			} else if (mlCheckDetails.getVisibility() == View.GONE) {
				mlCheckDetails.setVisibility(View.VISIBLE);
			}
			break;
		case R.id.rl_t3:
			if (mlMedicalDetails.getVisibility() == View.VISIBLE) {
				mlMedicalDetails.setVisibility(View.GONE);
			} else if (mlMedicalDetails.getVisibility() == View.GONE) {
				mlMedicalDetails.setVisibility(View.VISIBLE);
			}
			break;

		default:
			break;
		}
	}
	/**
	 * 设置检查单的数据源
	 */
	private void setCheckData()
	{
		mCheckHash=new HashMap<String, Object>();
		mCheckHash.put("project", "CT");
		mCheckHash.put("time", "7/2 14:00");
		mCheckHash.put("queue", "8");
		mCheckList.add(mCheckHash);
	}
	/**
	 * 设置药品的数据源
	 */
	private void setMedicalData()
	{
		mMedicalHash=new HashMap<String, Object>();
		mMedicalHash.put("name", "CT");
		mMedicalHash.put("quantity", "7/2 14:00");
		mMedicalHash.put("price", "8");
		mMedicalList.add(mMedicalHash);
	}
	private void setCheckListAdapter()
	{
		IllDetailsListAdapter adapter=new IllDetailsListAdapter(getActivity(), mCheckList);
		mCheckListView.setAdapter(adapter);
		/*SimpleAdapter adapter= new SimpleAdapter(getActivity(), mCheckList, R.layout.ill_details_list, 
				new String[]{"project","time","queue"}, new int[]{R.id.tv_project,R.id.tv_time,R.id.tv_queue});
		mCheckListView.setAdapter(adapter);*/
	}
	private void setMedicalListAdapter()
	{
		SimpleAdapter adapter=new SimpleAdapter(getActivity(), mMedicalList, R.layout.medical_details_list, 
				new String[]{"name","quantity","price"}, new int[]{R.id.tv_name,R.id.tv_quantity,R.id.tv_price});
		mMedicalListView.setAdapter(adapter);
	}

}
