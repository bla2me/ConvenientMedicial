package com.convenientmedical.main;

import java.util.ArrayList;
import java.util.List;

public class select_area_datasource {

	public select_area_datasource() {
	}

	public static List<String> getDataSource() {
		List<String> list = new ArrayList<String>();

		list.add("北京");
		list.add("上海");
		list.add("杭州");
		list.add("深圳");
		list.add("广州");
		list.add("苏州");
		list.add("重庆");
		return list;
	}

}
