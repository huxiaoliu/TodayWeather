package com.example.huxiaoliu.todayweather.model;

/**
 * Created by huxiaoliu on 2015/9/7.
 *  City表的实体类
 */
public class City {
    private int id;
    private String cityName;
    private String cityCode;
    private int provinceId;

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }
}
