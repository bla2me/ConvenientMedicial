package com.convenientmedical.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.convenientmedical.main.R;

import android.app.Activity;
import android.os.Bundle;
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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search_result);
		initView();
		mList = new ArrayList<HashMap<String, Object>>();
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
}
