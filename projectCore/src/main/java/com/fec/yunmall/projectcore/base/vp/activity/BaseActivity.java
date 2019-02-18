package com.fec.yunmall.projectcore.base.vp.activity;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.fec.yunmall.core.base.CoreApplication;
import com.fec.yunmall.core.base.vp.CoreBaseActivity;
import com.fec.yunmall.projectcore.R;
import com.fec.yunmall.projectcore.base.vp.inter.IPresenter;
import com.fec.yunmall.projectcore.base.vp.inter.IView;
import com.fec.yunmall.projectcore.helper.HUDFactory;
import com.fec.yunmall.projectcore.util.ToastUtils;
import com.gyf.barlibrary.ImmersionBar;
import com.kaopiz.kprogresshud.KProgressHUD;
import org.greenrobot.eventbus.EventBus;

/**
 * @author tome
 * @date 2019/1/25  15:17
 * @describe ${mvp的基础 Activity}
 */
public abstract class BaseActivity<P extends IPresenter> extends CoreBaseActivity implements IView {

    protected P mPresenter ;
    protected boolean regEvent;
    /**
     * 仿ios进度条
     */
    public KProgressHUD kProgressHUD;
    public ImmersionBar mImmersionBar;

    protected boolean isDestory = false;

    @Override
    public Context getContext() {
        return this;
    }

    /**
     * 注意如果在这里获取intent的数据在构造中传给Presenter的话,获取代码需要在super调用之前
     */
    @Override
    protected void init(Bundle savedInstanceState) {
       // 设置theme
       // ThemeManager.setTheme(this);
        //设置statuBar
        setBaseStatusBar();
        if (regEvent){
            EventBus.getDefault().register(this);
        }
        mPresenter = getPresenter();
        if (mPresenter != null) {
            mPresenter.attachView(this);
            //注册lifecycle生命周期
            getLifecycle().addObserver(mPresenter);
        }

    }

    /**
     * 沉浸式状态栏
     */
    protected void setBaseStatusBar() {
        mImmersionBar = ImmersionBar.with(this);
        //所有子类都将继承这些相同的属性,请在设置界面之后设置,指定标题栏view
        mImmersionBar.fitsSystemWindows(true).statusBarColor(R.color.color66).init();
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
        }
    }

    @Override
    public void showHUD(String msg) {
        if (isDestory){
            return;
        }
        if (kProgressHUD == null){
            kProgressHUD = HUDFactory.getInstance().creatHUD(this);
        }
        kProgressHUD.setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                    // .setLabel(getString(R.string.loading))
                    .setLabel(TextUtils.isEmpty(msg) ? getString(R.string.loading) : msg)
                    // .setLabel(null)
                    .setCancellable(true)
                    .setAnimationSpeed(2)
                    .setDimAmount(0.3f).show();
    }

    @Override
    public void dismissHUD() {
        if (null != kProgressHUD && kProgressHUD.isShowing()) {
            kProgressHUD.dismiss();
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // 如果你的app可以横竖屏切换，并且适配4.4或者emui3手机请务必在onConfigurationChanged方法里添加这句话
        ImmersionBar.with(this).init();
    }

    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        if (regEvent) {
            EventBus.getDefault().unregister(this);
        }
        isDestory = true;
        dismissHUD();
        // 必须调用该方法，防止内存泄漏
        ImmersionBar.with(this).destroy();

        super.onDestroy();
    }

    /**
     * 返回键
     * @param v
     */
    public void back(View v) {
        finish();
    }

    /**
     * 退出应用
     */
    public void exitApp() {
        CoreApplication.getApplication().getActivityControl().finishiAll();
        //用于杀掉当前进程
        android.os.Process.killProcess(android.os.Process.myPid());
        //参数0和1代表退出的状态，0表示正常退出，1表示异常退出
        System.exit(0);
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
