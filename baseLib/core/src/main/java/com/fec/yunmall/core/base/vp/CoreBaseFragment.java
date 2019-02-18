package com.fec.yunmall.core.base.vp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.orhanobut.logger.Logger;
import java.lang.ref.WeakReference;

/**
 * @author tome
 * @date 2019/1/25  16:02
 * @describe ${Fragment公共基类}
 */
public abstract class CoreBaseFragment extends Fragment{
    public Activity mActivity;
    public Context mContext;
    private Unbinder unBinder;
    public static final int REQUEST_REFRESH_KEY = 44444;

    protected WeakReference<View> mRootView;
    private boolean inited = false;
    @Override
    public void onActivityResult(int requestCode,int resultCode,Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode == REQUEST_REFRESH_KEY && resultCode == Activity.RESULT_OK) {
            onRefresh();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = getActivity();
        mContext = getContext();
        init(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,@Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {

        View mFragmentView = null;
        if (mRootView == null || mRootView.get() == null) {
            inited = false;
            mFragmentView = inflater.inflate(getLayoutId(),container,false);
            //弱引用对象
            mRootView = new WeakReference<>(mFragmentView);
        } else {
            ViewGroup parent = (ViewGroup)mRootView.get().getParent();
            if (parent != null) {
                parent.removeView(mRootView.get());
            }
            mFragmentView = mRootView.get();
        }
        unBinder = ButterKnife.bind(this,mFragmentView);
        return mRootView.get();
    }

    @Override
    public void onViewCreated(@NonNull View view,@Nullable Bundle savedInstanceState) {
        super.onViewCreated(view,savedInstanceState);
        if (!inited) {
            initView(mRootView.get());
            initListenerAddData();
            inited = true;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        Logger.d("当前的fragment:"+getClass().getSimpleName());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (unBinder != null) {
            unBinder.unbind();
            unBinder = null;
        }
    }

    /**
     * view 创建之前 获取intent数据等
     */
    protected abstract void init(Bundle savedInstanceState);

    protected abstract int getLayoutId();

    /**
     * mFragmentView创建完成后,初始化具体的view 只会调用一次
     */
    protected abstract void initView(View rootView);

    protected abstract void initListenerAddData();

    /**
     * 请求回来刷新时调用
     */
    public void onRefresh() {

    }
}
