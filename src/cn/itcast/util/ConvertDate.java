package cn.itcast.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConvertDate {
	public static Date ConvertStringToDate(String date) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-DD");
		Date d = sdf.parse(date);
		return d;/////
	}
}
