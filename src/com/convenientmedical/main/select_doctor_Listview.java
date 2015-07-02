package com.convenientmedical.main;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class select_doctor_Listview extends Activity {

	private ListView listView;
	private ArrayAdapter<String> adapter;
	private List<String> data = null;// 表示数据源

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.select_doctor);
		data = select_area_datasource.getDataSource();
		listView = (ListView) this.findViewById(R.id.LV_select_doctor);
		adapter = new ArrayAdapter<String>(select_doctor_Listview.this,
				android.R.layout.simple_list_item_1, data);
		listView.setAdapter(adapter);
	}

}
