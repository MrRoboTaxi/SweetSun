package com.sweetsun.app.util;

import android.text.TextUtils;

import com.sweetsun.app.SweetSunDB;
import com.sweetsun.app.model.City;
import com.sweetsun.app.model.County;
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
	
	
	
	public static boolean handleCitesResponse(SweetSunDB sweetsunDB,String response, int provinceId){
		if(!TextUtils.isEmpty(response)){
			String[] allCites=response.split(",");
			if(allCites!=null && allCites.length>0){
				for(String p:allCites){
					String[] array=p.split("\\|");
					City city=new City();
					city.setCityCode(array[0]);
					city.setCityName(array[1]);
					city.setProvinceId(provinceId);
					sweetsunDB.saveCity(city);
					
				}
				return true;
			}
		}
		return false;
	}
	
	public  static boolean handleCountiesResponse(SweetSunDB sweetsunDB,String response,int cityId){
		if(!TextUtils.isEmpty(response)){
			String[] allCounties=response.split(",");
			if(allCounties!=null && allCounties.length>0){
				for(String p:allCounties){
					String[] array=p.split("\\|");
					County county=new County();
					county.setCountyCode(array[0]);
					county.setCountyName(array[1]);
					county.setCityId(cityId);
					sweetsunDB.saveCounty(county);
					
				}
				return true;
			}
		}
		return false;
	}
}
