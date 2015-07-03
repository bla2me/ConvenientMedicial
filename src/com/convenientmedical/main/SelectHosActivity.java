package com.convenientmedical.main;

import java.util.List;

import com.convenientmedicial.DataList.SelectAreaData;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

/**
 * 选择医院
 * @author Mr.Codey
 *
 */
public class SelectHosActivity extends Activity {
	private ListView listView;
	private ArrayAdapter<String> adapter;
	private List<String> data = null;// 表示数据源
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.select_hospital);
		data=SelectAreaData.getDataSource();
		listView = (ListView) this.findViewById(R.id.select_hospital_list);
		adapter = new ArrayAdapter<String>(getApplicationContext(),
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
