package com.convenientmedical.main;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

public class DocOrHosExpandList extends Activity {

	private ExpandableListView listView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		listView = (ExpandableListView) findViewById(R.id.expandableListView_doc_or_hos);
		listView.setAdapter(new MyExpandablelistViewAdapter());
		listView.setGroupIndicator(null);
	}

	// 自定义适配器ExpandablelistView

	class MyExpandablelistViewAdapter extends BaseExpandableListAdapter {

		private String[] groups = { "搜索选择" };
		private String[][] childs = { { "医生", "医院" } };

		// 分组的数量
		@Override
		public int getGroupCount() {
			return groups.length;
		}

		// 每个分组中二级列表的数量
		@Override
		public int getChildrenCount(int groupPosition) {
			return childs[groupPosition].length;
		}

		// 返回每组对象
		@Override
		public Object getGroup(int groupPosition) {
			return groups[groupPosition];
		}

		// 返回每组中的每个子列表项对象
		@Override
		public Object getChild(int groupPosition, int childPosition) {
			return childs[groupPosition][childPosition];
		}

		@Override
		public long getGroupId(int groupPosition) {
			return groupPosition;
		}

		@Override
		public long getChildId(int groupPosition, int childPosition) {
			return childPosition;
		}

		@Override
		public boolean hasStableIds() {
			return true;
		}

		@Override
		public View getGroupView(int groupPosition, boolean isExpanded,
				View convertView, ViewGroup parent) {

			if (convertView == null) {
				convertView = getLayoutInflater().inflate(
						R.layout.doc_or_hos_group, null);
			}
			ImageView iv = (ImageView) convertView
					.findViewById(R.id.IV_doc_or_hos__group);
			TextView tv = (TextView) convertView
					.findViewById(R.id.TV_doc_or_hos_group);

			tv.setText(groups[groupPosition]);
			// iv.setImageResource(R.drawable.downarrow_small_green);
			return convertView;
		}

		@Override
		public View getChildView(int groupPosition, int childPosition,
				boolean isLastChild, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = getLayoutInflater().inflate(
						R.layout.doc_or_hos_child, null);
			}
			// ImageView iv = (ImageView)
			// convertView.findViewById(R.id.imageView1_child);
			TextView tv = (TextView) convertView
					.findViewById(R.id.TV_doc_or_hos_child);
			// iv.setImageResource(resId);
			tv.setText(childs[groupPosition][childPosition]);
			return convertView;

		}

		@Override
		public boolean isChildSelectable(int groupPosition, int childPosition) {
			return true;
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
