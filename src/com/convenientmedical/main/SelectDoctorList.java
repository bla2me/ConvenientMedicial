package com.convenientmedical.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.Request.Method;
import com.android.volley.toolbox.JsonObjectRequest;
import com.convenientmedical.json.ParseJson;
import com.convenientmedical.net.AppController;
import com.convenitentmedical.savedata.SharePreferenceUtil;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class SelectDoctorList extends Activity {

	private ListView listView;
	private ImageButton mibBack;
	private List<HashMap<String, Object>> mdataList;
	private HashMap<String, Object> mdataHash;

	private HashMap<String, String> mHash;
	private SharedPreferences preferences;
	private static final String URL = "https://120.26.83.51/demo/order/ 120.26.83.51/demo/order/findDoctor";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.select_doctor);
		preferences=getSharedPreferences("myshare", MODE_PRIVATE);
		listView = (ListView) this.findViewById(R.id.LV_select_doctor);
		mibBack=(ImageButton)findViewById(R.id.Ib_left);
		mibBack.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		mdataList=new ArrayList<HashMap<String,Object>>();
		getDocJson();
		setData();
		setListAdapter();
	}
	private void setData()
	{
		//从网络获取
		/*String s="[{"+"\"name\""+":\"named\"}]";
		Log.e("string", s);
		mdataHash=new HashMap<String, Object>();
		mdataHash=ParseJson.getInstanse().parseJson(s);
		mdataList.add(mdatahash);
		*/
		//本地测试用
		mdataHash=new HashMap<String, Object>();
		mdataHash.put("area", "地区");
		mdataHash.put("hospital", "医院名");
		mdataHash.put("doctor", "医生姓名");
		mdataList.add(mdataHash);
	}
	private void setListAdapter()
	{
		SimpleAdapter adapter=new SimpleAdapter(getApplicationContext(), mdataList, R.layout.search_result_list,
				new String[]{"doctor_name","server_time","clinic_type"}, new int[]{R.id.tv_area,R.id.tv_hos_name,R.id.tv_doc_name});
		listView.setAdapter(adapter);
	}
	/**
	 * 通过医院获取科室	 */
	private void getDocJson() {
		mHash = new HashMap<String, String>();
		mHash.put("hospital", "浙江省中医院");
		Log.e("res",mHash.toString());
		JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
				Method.POST, URL, new Response.Listener<JSONObject>() {

					@Override
					public void onResponse(JSONObject jsonObject) {
						// TODO Auto-generated method stub
						Log.e("res", jsonObject.toString());
					}
				}, new Response.ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {
						// TODO Auto-generated method stub
						/*if (error != null) {
							Log.e("res", error.getMessage());
						}*/
					}
				}) {

			@Override
			protected Map<String, String> getParams() throws AuthFailureError {
				// TODO Auto-generated method stub
				return mHash;
			}

			@Override
			public Map<String, String> getHeaders() throws AuthFailureError {
				// TODO Auto-generated method stub
				HashMap<String, String> mHashheader = new HashMap<String, String>();
				mHashheader.put("Cookie", SharePreferenceUtil.getInstanse()
						.getshareString(preferences, "Cookie"));
				Log.e("header", mHashheader.toString());
				return mHashheader;
			}

		};
		AppController.getInstance().addToRequestQueue(jsonObjectRequest);
	}

}
