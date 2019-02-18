package com.fec.yunmall.order.ui.fragment;

import android.view.View;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.fec.yunmall.order.R;
import com.fec.yunmall.order.contract.GoodsContract;
import com.fec.yunmall.order.presenter.GoodsPresenter;
import com.fec.yunmall.projectcore.base.router.RouterPath;
import com.fec.yunmall.projectcore.base.vp.fragment.BaseFragment;

/**
 * @author tome
 * @date 2019/1/25  10:43
 * @describe ${TODO}
 */
@Route(path = RouterPath.MALL_GOODS)
public class GoodsFragment extends BaseFragment<GoodsPresenter> implements GoodsContract.View {

    @Override
    protected GoodsPresenter getPresenter() {
        return new GoodsPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.order_fragment_goods;
    }

    @Override
    protected void initView(View rootView) {

    }

    @Override
    protected void initListenerAddData() {

    }

    @Override
    public void showGoodsList() {

    }

}
