package com.boke.util;

public class StringUtil {
  //为空判断
	public  static boolean isNull(String...strs){
		if(strs ==null||strs.length==0){
			return true;
		}
	 for(String str :strs){
		 if(str ==null||"".equals(str)){
			 return true;
		 }
	 }
	return false;
	}

	public static boolean isNull(int ano, String province, String city, String area, String name, String tel) {
		// TODO Auto-generated method stub
		return false;
	}

	public static boolean isNull(String ono, int ano) {
		// TODO Auto-generated method stub
		return false;
	}

	public static boolean isNull(int userid, String pics) {
		// TODO Auto-generated method stub
		return false;
	}

	public static boolean isNull(int userid) {
		return false;
	}
}
