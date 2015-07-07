package com.convenientmedical.net;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;

public class JsonObjectPostRequest extends Request<JSONObject> {

	private Map<String, String> mMap;
	private Response.Listener<JSONObject> mListener;
	public String cookieFromResponse;
	private String mHeader;
	private Map<String, String> sendHeader = new HashMap<String, String>(1);

	public JsonObjectPostRequest(int method, String url,
			Response.Listener<JSONObject> listener,
			Response.ErrorListener errorListener, Map map) {
		super(method, url, errorListener);
		mListener = listener;
		mMap = map;
	}

	// 当http请求是post时，则需要该使用该函数设置往里面添加的键值对
	@Override
	protected Map<String, String> getParams() throws AuthFailureError {
		return mMap;
	}

	@Override
	protected void deliverResponse(JSONObject response) {
		mListener.onResponse(response);
	}

	@Override
	public Map<String, String> getHeaders() throws AuthFailureError {
		return sendHeader;
	}

	public void setSendCookie(String cookie) {
		sendHeader.put("Cookie", cookie);
	}

	@Override
	protected Response<JSONObject> parseNetworkResponse(NetworkResponse arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
