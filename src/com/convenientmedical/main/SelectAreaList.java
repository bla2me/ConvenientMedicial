package com.convenientmedical.main;

import java.util.List;

import com.convenientmedicial.DataList.SelectAreaData;

import android.R.integer;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * 选择地区
 * @author Mr.Codey
 *
 */
public class SelectAreaList extends Activity {

	private ListView listView;
	private ArrayAdapter<String> adapter;
	private List<String> data = null;// 表示数据源

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.select_area);
		data=SelectAreaData.getDataSource();
		listView = (ListView) this.findViewById(R.id.LV_select_area);
		adapter = new ArrayAdapter<String>(SelectAreaList.this,
				android.R.layout.simple_list_item_1, data);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(getApplicationContext(), MainActivity.class);
				startActivity(intent);
			}
		});
	}
}
