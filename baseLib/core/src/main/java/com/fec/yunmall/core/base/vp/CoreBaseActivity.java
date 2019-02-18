package com.fec.yunmall.core.base.vp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.fec.yunmall.core.base.CoreApplication;
import com.orhanobut.logger.Logger;

/**
 * @author tome
 * @date 2019/1/25  11:37
 * @describe ${activity公共基类}
 */
public abstract class CoreBaseActivity extends AppCompatActivity {
    /**
     * 是否启用换肤的功能，为true时baseActivity会去注册SkinManager,不考虑换肤功能请设置成false
     */
    public static final boolean IS_SKIN = false;
    protected Activity mActivity;
    public Context mContext;
    private Unbinder unBinder;
    public static final int REQUEST_REFRESH_KEY = 55555;

    /**
     * view填充之前 过去Intent数据  绑定Presenter等
     * 注意:获取intent的数据需要在super之前,否则如果创建Presenter使用到这些数据的话,这些数据在使用时还未被赋值
     * @param savedInstanceState
     */
    protected abstract void init(Bundle savedInstanceState);
    protected abstract int getLayoutId();
    protected abstract void initView();
    protected abstract void initListenerAddData();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        mContext = this;
        if (IS_SKIN) {
            //这里初始化换肤功能
        }
        //加入activity管理
        CoreApplication.getApplication().getActivityControl().addActivity(this);

        baseInit();
        init(savedInstanceState);
        initView();
        initListenerAddData();

    }

    @Override
    protected void onResume() {
        super.onResume();
        Logger.d("当前的activity:"+getClass().getSimpleName());
    }

    /**
     * 基础初始化 绑定黄油刀,  使用binding的复写 不绑
     */
    protected void baseInit() {
        setContentView(getLayoutId());
        try {
            unBinder = ButterKnife.bind(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode,@Nullable Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode == REQUEST_REFRESH_KEY && resultCode==Activity.RESULT_OK) {
            onRefresh();
        }
    }

    /**
     * 请求回来刷新时调用
     */
    public void onRefresh() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unBinder != null) {
            unBinder.unbind();
        }
        //移除类
        CoreApplication.getApplication().getActivityControl().removeActivity(this);
    }
}
