package com.convenientmedical.main;

import java.util.List;

import com.convenientmedicial.DataList.SelectDoctorData;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SelectDoctorList extends Activity {

	private ListView listView;
	private ArrayAdapter<String> adapter;
	private List<String> data = null;// 表示数据源

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.select_doctor);
		data = SelectDoctorData.getDataSource();
		listView = (ListView) this.findViewById(R.id.LV_select_doctor);
		adapter = new ArrayAdapter<String>(SelectDoctorList.this,
				android.R.layout.simple_list_item_1, data);
		listView.setAdapter(adapter);
	}

}
