package com.convenientmedical.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.android.volley.toolbox.JsonObjectRequest;
import com.convenientmedical.frag.Registration;
import com.convenientmedical.frag.Registration.CallBack;
import com.convenientmedical.main.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;

/**
 * @author Mr.Codey 按医生名字搜索结果
 */
public class DoctorSearchResult extends Activity {
	private ImageButton mibBack;
	private ListView mResultList;
	private HashMap<String, Object> mHash;
	private List<HashMap<String, Object>> mList;
	private Registration registrationFrag;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search_result);
		initView();
		Intent intent=getIntent();
		String[] s=intent.getStringArrayExtra("search");
//		Bundle mbundle=new Bundle();
		Log.i("bundle", s[0]+"   "+s[1]);
//		registrationFrag=new Registration();
		mList = new ArrayList<HashMap<String, Object>>();
//		getContentFromFrag();
		addData();
		SimpleAdapter adapter=new SimpleAdapter(getApplicationContext(), mList, R.layout.search_result_list, 
				new String[]{"area","hospital","doctor"},new int[]{R.id.tv_area,R.id.tv_hos_name,R.id.tv_doc_name});
		mResultList.setAdapter(adapter);
	}

	private void initView() {
		mibBack = (ImageButton) findViewById(R.id.Ib_back_to_main);
		mResultList = (ListView) findViewById(R.id.search_result_list);
	}

	private void addData() {
		mHash=new HashMap<String, Object>();
		mHash.put("area", "地区");
		mHash.put("hospital", "医院名");
		mHash.put("doctor", "医生姓名");
		mList.add(mHash);
	}
/*	public void getContentFromFrag()
	{
		registrationFrag.getSearchContent(new CallBack() {
			
			@Override
			public void getResult(HashMap<String, String> mHash) {
				// TODO Auto-generated method stub
				Log.i("hash", mHash.toString());
			}
		});
	}*/
}
