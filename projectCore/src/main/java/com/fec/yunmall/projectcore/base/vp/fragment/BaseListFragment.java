package com.fec.yunmall.projectcore.base.vp.fragment;

import android.view.View;
import android.view.ViewGroup;
import com.fec.yunmall.projectcore.R;
import com.fec.yunmall.projectcore.base.vp.inter.IPresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

/**
 * @author tome
 * @date 2019/2/18  15:53
 * @describe ${抽取list公共部分}
 */
public abstract class BaseListFragment<P extends IPresenter> extends BaseEmptyFragment<P> implements OnRefreshListener, OnLoadMoreListener {

    protected int page = 0;
    protected int pageSize = 20;
    protected boolean isRefresh = true;
    protected SmartRefreshLayout rlRefreshLayout;

    @Override
    protected void initView(View view) {
        super.initView(view);
        if (rlRefreshLayout != null) {
            rlRefreshLayout.setOnRefreshListener(this);
            rlRefreshLayout.setOnLoadMoreListener(this);
            //自动刷新
            rlRefreshLayout.autoRefresh();
        }
    }

    /**
     *  空布局
     * @param view
     * @return
     */
    @Override
    public ViewGroup getViewGroup(View view) {
        return (ViewGroup) view.findViewById(R.id.refresh_layout);
    }

    /**
     * 刷新
     * @param refreshLayout
     */
    @Override
    public void onRefresh(RefreshLayout refreshLayout) {
        this.page = 0;
        isRefresh = true ;
        loadListData(rlRefreshLayout ,page, pageSize);
    }

    /**
     * 加载更多
     * @param refreshLayout
     */
    @Override
    public void onLoadMore(RefreshLayout refreshLayout) {
        page++;
        isRefresh = false ;
        loadListData(rlRefreshLayout ,page, pageSize);
    }

    /**
     * 让子类去加载数据
     * @param rlRefreshLayout
     * @param page
     * @param pageSize
     */
    public abstract void loadListData(SmartRefreshLayout rlRefreshLayout , int page, int pageSize);
}
