package com.fec.yunmall.cart.ui.fragment;

import android.view.View;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.fec.yunmall.cart.R;
import com.fec.yunmall.cart.contract.ShopCartContract;
import com.fec.yunmall.cart.presenter.ShopCartPresenter;
import com.fec.yunmall.projectcore.base.router.RouterPath;
import com.fec.yunmall.projectcore.base.vp.fragment.BaseFragment;

/**
 * @author tome
 * @date 2019/1/25  10:50
 * @describe ${TODO}
 */
@Route(path = RouterPath.MALL_SHOP_CART)
public class CartFragment extends BaseFragment<ShopCartContract.Presenter> implements ShopCartContract.View {
    @Override
    protected ShopCartContract.Presenter getPresenter() {
        return new ShopCartPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.cart_fragment_shop_cart;
    }

    @Override
    protected void initView(View rootView) {

    }

    @Override
    protected void initListenerAddData() {

    }

    @Override
    public void showShopCart() {

    }
}
