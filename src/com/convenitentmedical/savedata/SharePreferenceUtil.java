package com.convenitentmedical.savedata;

import android.content.SharedPreferences;

public class SharePreferenceUtil {
	//默认构造
	private SharePreferenceUtil(){};
	private static final SharePreferenceUtil PREFERENCE_UTIL=new SharePreferenceUtil();
	/**
	 * 单例模式设置
	 * @return
	 */
	public static SharePreferenceUtil getInstanse()
	{
		return PREFERENCE_UTIL;
	}
	public void putStringData(SharedPreferences preferences,String key,String value)
	{
		SharedPreferences.Editor editor=preferences.edit();
		editor.putString(key, value);
		editor.apply();
	}
}
