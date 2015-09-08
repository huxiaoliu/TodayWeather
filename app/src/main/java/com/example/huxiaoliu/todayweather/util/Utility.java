package com.example.huxiaoliu.todayweather.util;

import android.text.TextUtils;

import com.example.huxiaoliu.todayweather.db.TodayWeatherDB;
import com.example.huxiaoliu.todayweather.model.City;
import com.example.huxiaoliu.todayweather.model.County;
import com.example.huxiaoliu.todayweather.model.Province;

/**
 * Created by huxiaoliu on 2015/9/8.
 * 解析和处理从服务器返回数据的工具类
 */
public class Utility {

    /**
     *  解析和处理返回的省级数据
     * */
    public synchronized static boolean handleProvinceResponse(TodayWeatherDB todayWeatherDB,String response){
        if (!TextUtils.isEmpty(response)){
            String[] allProvinces = response.split(",");
            if (allProvinces != null && allProvinces.length > 0){
                for (String p : allProvinces){
                    String[] array = p.split("\\|");
                    Province province = new Province();
                    province.setProvinceCode(array[0]);
                    province.setProvinceName(array[1]);
                    //将解析出来的数据存到Province表
                    todayWeatherDB.saveProvince(province);
                }
                return  true;
            }
        }
        return false;
    }

    /**
     * 解析和处理服务器返回的市级数据
     * */
    public static boolean handleCitiesResponse(TodayWeatherDB todayWeatherDB,String response,int provinceId){
        if (!TextUtils.isEmpty(response)){
            String[] allCities = response.split(",");
            if (allCities != null && allCities.length>0){
                for (String c :allCities){
                    String[] array = c.split("\\|");
                    City city = new City();
                    city.setCityCode(array[0]);
                    city.setCityName(array[1]);
                    city.setProvinceId(provinceId);
                    todayWeatherDB.savCity(city);
                }
                return true;
            }
        }

        return false;
    }

    /**
     * 解析和处理返回的县级数据
     * */

    public static boolean handleCountiesResponse(TodayWeatherDB todayWeatherDB,String response,int cityId){
        if (!TextUtils.isEmpty(response)){
            String[] allCounties = response.split(",");
            if (allCounties!=null && allCounties.length >0){
                for (String c:allCounties){
                    String[] array = c.split("\\|");
                    County county = new County();
                    county.setCountyCode(array[0]);
                    county.setCountyName(array[1]);
                    county.setCityId(cityId);
                    todayWeatherDB.saveCounty(county);
                }
                return true;
            }
        }
        return false;
    }
}
