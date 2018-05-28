
package com.hosoda.internous.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public String getDate(){
		Date date= new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		
		return simpleDateFormat.format(date);
	}

}
