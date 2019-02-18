package com.fec.yunmall.projectcore.base.router;

import android.support.v4.app.Fragment;
import com.alibaba.android.arouter.launcher.ARouter;

/**
 * @author tome
 * @date 2019/1/28  14:17
 * @describe ${路由中心}
 */
public class RouterCenter {

    /**
     * 获取主页面
     */
    public static Fragment toMallHome() {
        Fragment fragment = (Fragment) ARouter.getInstance().build(RouterPath.MALL_HOME).navigation();
        if (fragment == null) {
            fragment = new Fragment();
        }
        return fragment;
    }
    /**
     * 获取商品页面
     */
    public static Fragment toMallGoods() {
        Fragment fragment = (Fragment) ARouter.getInstance().build(RouterPath.MALL_GOODS).navigation();
        if (fragment == null) {
            fragment = new Fragment();
        }
        return fragment;
    }
    /**
     * 获取购物车页面
     */
    public static Fragment toShopCart() {
        Fragment fragment = (Fragment) ARouter.getInstance().build(RouterPath.MALL_SHOP_CART).navigation();
        if (fragment == null) {
            fragment = new Fragment();
        }
        return fragment;
    }
    /**
     * 获取个人中心页面
     */
    public static Fragment toMallSelf() {
        Fragment fragment = (Fragment) ARouter.getInstance().build(RouterPath.MALL_SELF).navigation();
        if (fragment == null) {
            fragment = new Fragment();
        }
        return fragment;
    }


}
