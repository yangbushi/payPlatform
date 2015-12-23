package com.defray.util;

public class CardToPwd {
	
	public static String toPwd(String card){
		
		card = card.toUpperCase();
		String pwd = null;
		if(card.length() == 15){
			pwd =  card.substring(7);
		}else{
			pwd = card.substring(10);
		}
		return pwd;
	}
}
