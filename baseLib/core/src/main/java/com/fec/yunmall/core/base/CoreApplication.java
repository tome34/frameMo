package com.fec.yunmall.core.base;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.support.multidex.MultiDex;
import com.fec.yunmall.core.BuildConfig;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * @author tome
 * @date 2019/1/24  16:33
 * @describe ${TODO}
 */
public class CoreApplication extends Application {
    public static CoreApplication mApplication;
    public static boolean IS_DEBUG = BuildConfig.DEBUG ;
    //内存泄露
    private RefWatcher refWatcher;
    //Activity管理
    public ActivityControl mActivityControl;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        mApplication = this;
        //MultiDex分包方法 必须最先初始化
        MultiDex.install(this);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //activity统一管理器
        mActivityControl = new ActivityControl();
        //初始化leakCanary
        initLeakCanary();

        // 初始化Logger工具
        Logger.addLogAdapter(new AndroidLogAdapter(){
            @Override
            public boolean isLoggable(int priority, String tag) {
                return BuildConfig.DEBUG;
            }
        });
        Logger.i("当前是否为debug模式："+IS_DEBUG );
    }

    private void initLeakCanary() {
        //leakcanary初始化
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // 如果是在HeapAnalyzer进程里，则返回，因为该进程是专门用来堆内存分析的。
            return;
        }
        //调用LeakCanary.install()的方法来进行必要的初始化工作，来监听内存泄漏。
        refWatcher = LeakCanary.install(this);
    }
    /**
     * 监控Fragment等其他有生命周期函数的方法的类是否有内存泄漏
     * @param context
     * @return
     */
    public static RefWatcher getRefWatcher(Context context) {
        CoreApplication leakApplication = (CoreApplication) context.getApplicationContext();
        return leakApplication.refWatcher;
    }

    public static CoreApplication getApplication(){
        return mApplication;
    }

    public ActivityControl getActivityControl() {
        return mActivityControl;
    }



    /**
     * 程序终止的时候执行
     */
    @Override
    public void onTerminate() {
        super.onTerminate();
        exitApp();
    }
    /**
     * 退出应用
     */
    public void exitApp() {
        mActivityControl.finishiAll();
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }


    /**
     * 低内存的时候执行
     */
    @Override
    public void onLowMemory() {
        super.onLowMemory();

    }

    // 程序在内存清理的时候执行
    /**
     * 程序在内存清理的时候执行
     */
    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
    }
}
