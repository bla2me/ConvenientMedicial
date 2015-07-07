package com.convenientmedical.json;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.convenitentmedical.savedata.SharePreferenceUtil;

public class ParseJson {
	private ParseJson(){};
	private static final ParseJson PARSE_JSON=new ParseJson();
	/**
	 * 单例模式设置
	 * @return
	 */
	public static ParseJson getInstanse()
	{
		return PARSE_JSON;
	}
	private JSONTokener jsonParser;
	private JSONObject jsonObject;
	public JSONObject packJson(int type,String jsonString)
	{
		switch (type) {
		case 1:
			try {
				jsonObject=new JSONObject(jsonString);
				return jsonObject;
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		default:
			break;
		}
		return jsonObject;
		
	}
}
