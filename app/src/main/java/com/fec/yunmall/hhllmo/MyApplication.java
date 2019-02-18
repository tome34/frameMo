package com.fec.yunmall.hhllmo;

import com.fec.yunmall.projectcore.base.application.BaseApplication;

/**
 * @Created by TOME .
 * @时间 2018/5/14 17:40
 * @描述 ${应用的application}
 */

public class MyApplication extends BaseApplication {

    private static MyApplication myApplication;
    //初始化
    public static MyApplication getAppInstance() {
        return myApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this ;
    }
}
