package com.fec.yunmall.projectcore.base.vp.presenter;

import android.content.Context;
import com.fec.yunmall.projectcore.base.vp.inter.IDisposablePool;
import com.fec.yunmall.projectcore.base.vp.inter.IPresenter;
import com.fec.yunmall.projectcore.base.vp.inter.IView;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @author tome
 * @date 2019/1/28  15:10
 * @describe ${mvp的基础 Presenter}
 */
public abstract class BasePresenter<V extends IView> implements IPresenter<V>, IDisposablePool {

    protected V mView;

    /**
     * 管理事件流订阅的生命周期CompositeDisposable
     */
    private CompositeDisposable compositeDisposable;

    @Override
    public Context getContext() {
        return mView.getContext();
    }

    @Override
    public void attachView(V view) {
        this.mView = view;
    }

    @Override
    public void addDisposable(Disposable disposable) {
        if (compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
        }
        compositeDisposable.add(disposable);
    }

    @Override
    public void detachView() {
        clearPool();
        mView = null;
    }

    /**
     * 取消订阅关系
     */
    @Override
    public void clearPool() {
        if (compositeDisposable != null) {
            compositeDisposable.clear();
            compositeDisposable = null;
        }
    }


}
