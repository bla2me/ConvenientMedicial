package com.convenientmedical.main;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.Request.Method;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.convenientmedical.json.ParseLogAndSign;
import com.convenitentmedical.savedata.SharePreferenceUtil;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * @author Mr.Codey
 *注册的activity
 */
public class SignUpActivity extends Activity {
private Button mbtSignUp;
private EditText metUserName,metPwd,metRePwd;
private String mUserName,mPwd;
private SharedPreferences preferences;// 保存登录状态和cookies
private RequestQueue requestqueue;
public String cookieFromResponse;
private String mHeader;
private HashMap<String, String> mHashmap;
private static final int LOG_IN_STATUS = 1;// 登录状态值
private static final String INPUT_TIP="用户名密码不能为空！";
private static final String CHECK_PWD="两次输入密码不一致，请检查！";
private static final String URL="https://120.26.83.51/demo/user/register";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.registered);
		initView();
		preferences=getPreferences(MODE_PRIVATE);
		requestqueue=Volley.newRequestQueue(getApplicationContext());
		mbtSignUp.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				JudgeInput();
				
				mHashmap=new HashMap<String, String>();
				mHashmap.put("username", mUserName);
				mHashmap.put("password",mPwd);
				Log.i("signup", mHashmap.toString());
				StringRequest stringRequest=new StringRequest(Method.POST, URL,new Listener<String>() {

					@Override
					public void onResponse(String response) {
						// TODO Auto-generated method stub
						Log.i("res", response.toString());
						ParseLogAndSign login=new ParseLogAndSign();
						if(login.getContent(response).equals("1"))
						{
							Toast.makeText(getApplicationContext(), "注册成功", Toast.LENGTH_SHORT).show();
							Intent intent = new Intent();
							intent.setClass(getApplicationContext(), MainActivity.class);
							startActivity(intent);
							finish();
							SharePreferenceUtil.getInstanse().putIntData(preferences, "LOG_IN_STATUS", LOG_IN_STATUS);
						}
						else
						{
							Toast.makeText(getApplicationContext(), "用户名已存在！", Toast.LENGTH_SHORT).show();
						}
					}
				}, new ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {
						// TODO Auto-generated method stub
//						Log.i("res", error.getMessage());
					}
				}){

					@Override
					protected Map<String, String> getParams()
							throws AuthFailureError {
						// TODO Auto-generated method stub
						return mHashmap;
					}

					@Override
					protected Response<String> parseNetworkResponse(
							NetworkResponse response) {
						// TODO Auto-generated method stub
						try {
							String jsonString =
							        new String(response.data, HttpHeaderParser.parseCharset(response.headers));
						} catch (UnsupportedEncodingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			            mHeader = response.headers.toString();
			            Log.w("LOG","get headers in parseNetworkResponse "+response.headers.toString());
			            //使用正则表达式从reponse的头中提取cookie内容的子串
			            Pattern pattern=Pattern.compile("Set-Cookie.*?;");
			            Matcher m=pattern.matcher(mHeader);
			            if(m.find()){
			                cookieFromResponse =m.group();
			                Log.w("LOG","cookie from server "+ cookieFromResponse);
			            }
			            //去掉cookie末尾的分号
//			            cookieFromResponse = cookieFromResponse.substring(11,cookieFromResponse.length()-1);
//			            Log.w("LOG","cookie substring "+ cookieFromResponse);
//			            SharePreferenceUtil.getInstanse().putStringData(preferences, "Cookie", cookieFromResponse);
//			            Log.w("cookie", SharePreferenceUtil.getInstanse().getshareString(preferences, "Cookie"));
			            String dataString = null;
						try {
							dataString = new String(response.data,"UTF-8");
						} catch (UnsupportedEncodingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}//返回值
			            
						return Response.success(dataString,
			                    HttpHeaderParser.parseCacheHeaders(response));
					}
				};
				requestqueue.add(stringRequest);
			}
		});
	}
	private void initView()
	{
		mbtSignUp=(Button)findViewById(R.id.BT_register);
		metUserName=(EditText)findViewById(R.id.Et_username);
		metPwd=(EditText)findViewById(R.id.Et_password);
		metRePwd=(EditText)findViewById(R.id.Et_againpassword);
	}
	private boolean JudgeInput()
	{
		mUserName=metUserName.getText().toString().trim();
		mPwd=metPwd.getText().toString().trim();
		String mRePwd=metRePwd.getText().toString().trim();
		if(mUserName.equals("")||mPwd.equals(""))
		{
			Toast.makeText(getApplicationContext(), INPUT_TIP, Toast.LENGTH_SHORT).show();
			return false;
		}
		else if(!mPwd.equals(mRePwd))
		{
			Toast.makeText(getApplicationContext(), CHECK_PWD, Toast.LENGTH_SHORT).show();
			return false;
		}
		return true;
	}
}
