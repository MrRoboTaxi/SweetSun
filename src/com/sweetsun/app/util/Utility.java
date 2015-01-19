package com.sweetsun.app.util;

import android.text.TextUtils;

import com.sweetsun.app.SweetSunDB;
import com.sweetsun.app.model.Province;
public class Utility {

	public synchronized static boolean handleProvincesResponse(SweetSunDB sweetsunDB,String response){
		if(!TextUtils.isEmpty(response)){
			String[] allProvinces=response.split(",");
			if(allProvinces!=null && allProvinces.length>0){
				for(String p:allProvinces){
					String[] array=p.split("\\|");
					Province province=new Province();
					province.setProvinceCode(array[0]);
					province.setProvinceName(array[1]);
					sweetsunDB.saveProvince(province);
					
				}
				return true;
			}
		}
		return false;
	}
}
