package com.convenientmedical.frag;

import java.util.HashMap;
import java.util.List;

import com.convenientmedical.main.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.ListView;

/**
 * @author Mr.Codey
 *  支付fragment
 */
public class Pay extends Fragment {
private View payView;
private ListView mListView;
private HashMap<String, Object> mHash;
private List<HashMap<String, Object>> mList;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		payView=inflater.inflate(R.layout.pay, container,false);
		mListView=(ListView)payView.findViewById(R.id.pay_list);
		return payView;
	}

}
 