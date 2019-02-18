package com.fec.yunmall.cart.contract;

import com.fec.yunmall.projectcore.base.vp.inter.IPresenter;
import com.fec.yunmall.projectcore.base.vp.inter.IView;

/**
 * @Created by TOME .
 * @时间 2018/5/4 11:15
 * @描述 ${TODO}
 */

public interface ShopCartContract {

    interface View extends IView{
        void showShopCart();
    }

    interface Presenter extends IPresenter<View>{
        void getShopCartData();
    }
}
