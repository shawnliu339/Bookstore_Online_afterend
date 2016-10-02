package com.ncut.bookshop.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Format {

	public Format() {
		super();
		// TODO Auto-generated constructor stub
	}

	static public Double moneyFormat(Double money) {
		DecimalFormat moneyFormat = new DecimalFormat("#.00");
		money = Double.parseDouble(moneyFormat.format(money));
		return money;
	}
	
	public static String dateFormat(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}
}
