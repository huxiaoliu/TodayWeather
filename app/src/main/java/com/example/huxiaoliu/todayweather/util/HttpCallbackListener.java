package com.example.huxiaoliu.todayweather.util;

/**
 * Created by huxiaoliu on 2015/9/7.
 */
public interface HttpCallbackListener {
    //当服务器成功响应时回调该方法
    void onFinish(String response);
    //当进行网络操作出错时调用该方法
    void onError(Exception e);

}
