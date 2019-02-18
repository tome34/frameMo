package com.fec.yunmall.projectcore.base.vp.fragment;

import android.os.Bundle;
import com.fec.yunmall.core.base.vp.CoreBaseFragment;
import com.fec.yunmall.projectcore.base.application.BaseApplication;
import com.fec.yunmall.projectcore.base.vp.activity.BaseActivity;
import com.fec.yunmall.projectcore.base.vp.inter.IPresenter;
import com.fec.yunmall.projectcore.base.vp.inter.IView;
import com.fec.yunmall.projectcore.util.ToastUtils;
import com.gyf.barlibrary.ImmersionBar;
import com.squareup.leakcanary.RefWatcher;
import org.greenrobot.eventbus.EventBus;

/**
 * @author tome
 * @date 2019/1/25  15:17
 * @describe ${mvp的基础 fragment}
 */
public abstract class BaseFragment<P extends IPresenter> extends CoreBaseFragment implements IView {

    protected P mPresenter ;
    protected boolean regEvent;
    private BaseActivity mBaseActivity;

    protected boolean isDestory = false;
    public ImmersionBar mImmersionBar;
    @Override
    protected void init(Bundle savedInstanceState) {
        //沉浸式状态栏
        setBaseStatusBar();
        if (regEvent){
            EventBus.getDefault().register(this);
        }

        mPresenter = getPresenter();
        if (mPresenter != null) {
            //在这个时候才attach view是因为这个时候view的初始化已经基本完成,在Presenter中调用view的域也不会为空
            mPresenter.attachView(this);
            getLifecycle().addObserver(mPresenter);
        }
    }

    /**
     * 沉浸式状态栏
     */
    protected void setBaseStatusBar() {
        if (mImmersionBar == null){
            mImmersionBar = ImmersionBar.with(this);
            //让子类单独使用
           // mImmersionBar.init();
        }
    }

    /**
     * 获取当前的persenter
     * @return
     */
    protected abstract P getPresenter();


    /**
     * 提示网络请求错误信息
     * @param msg
     * @param code
     */
    @Override
    public void showRequestError(String msg,String code) {
        String mCode ="-1";
        if (mCode.equals(code)){
            ToastUtils.showShort(mActivity, msg);
        }else {
            ToastUtils.showShort(mActivity, msg);
        }
    }

    @Override
    public void showHUD(String msg) {
        if (getActivity() != null ) {
            if (mBaseActivity == null){
                mBaseActivity = (BaseActivity)getActivity();
            }
            mBaseActivity.showHUD(msg);
        }
    }

    @Override
    public void dismissHUD() {
        if (getActivity() != null && mBaseActivity != null) {
            mBaseActivity.dismissHUD();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        if (regEvent) {
            EventBus.getDefault().unregister(this);
        }
        dismissHUD();

        //leakCanary 监控
        RefWatcher refWatcher = BaseApplication.getRefWatcher(mActivity);
        refWatcher.watch(this);
    }

    /*----------------------空页面显示----------------------*/

    @Override
    public void showNormal() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showEmptyView() {

    }

    @Override
    public void showError() {

    }
}
