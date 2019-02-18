package com.fec.yunmall.mall.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import butterknife.BindView;
import com.fec.yunmall.mall.R;
import com.fec.yunmall.mall.R2;
import com.fec.yunmall.mall.contract.MainContract;
import com.fec.yunmall.mall.presenter.MainPresenter;
import com.fec.yunmall.projectcore.base.router.RouterCenter;
import com.fec.yunmall.projectcore.base.vp.activity.BaseActivity;
import com.fec.yunmall.projectcore.util.ToastUtils;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View, RadioGroup.OnCheckedChangeListener {

    @BindView(R2.id.fl_content)
    FrameLayout mFlContent;
    @BindView(R2.id.rb_home)
    RadioButton mRbHome;
    @BindView(R2.id.rb_order)
    RadioButton mRbOrder;
    @BindView(R2.id.rb_cart)
    RadioButton mRbCart;
    @BindView(R2.id.rb_self)
    RadioButton mRbSelf;

    @BindView(R2.id.rg_tab_container1)
    RadioGroup mRgTab;
    @BindView(R2.id.layout_home_frag)
    LinearLayout mLayoutHomeFrag;

    private List<Fragment> mFragments;
    public Fragment mHomeFragment;
    public Fragment mGoodsFragment;
    public Fragment mShopCartFrament;
    public Fragment mSelfFrament;

    private long exitTime = 0;

    @Override
    protected int getLayoutId() {
        return R.layout.mall_activity_main;
    }

    @Override
    protected MainPresenter getPresenter() {
        return new MainPresenter();
    }

    @Override
    protected void initView() {
        mFragments = new ArrayList<>();
        //radiobutton监听
         mRgTab.setOnCheckedChangeListener(this);
        //选择主页tab
         mRgTab.check(R.id.rb_home);
    }

    @Override
    protected void initListenerAddData() {

    }

    @Override
    public void onCheckedChanged(RadioGroup group,int checkedId) {
        FragmentTransaction transaction = this.getSupportFragmentManager().beginTransaction();
        hideFragments(transaction);
        if (checkedId == R.id.rb_home) {
            //首页
            if (mHomeFragment == null) {
                mHomeFragment = RouterCenter.toMallHome();
                transaction.add(R.id.fl_content,mHomeFragment);
                mFragments.add(mHomeFragment);
            } else {
                transaction.show(mHomeFragment);
            }
        } else if (checkedId == R.id.rb_order) {
            //商品页
            if (mGoodsFragment == null) {
                mGoodsFragment = RouterCenter.toMallGoods();
                transaction.add(R.id.fl_content,mGoodsFragment);
                mFragments.add(mGoodsFragment);
            } else {
                transaction.show(mGoodsFragment);
            }
        } else if (checkedId == R.id.rb_cart) {
            //购物车页
            if (mShopCartFrament == null) {
                mShopCartFrament = RouterCenter.toShopCart();
                transaction.add(R.id.fl_content,mShopCartFrament);
                mFragments.add(mShopCartFrament);
            } else {
                transaction.show(mShopCartFrament);
            }
        } else if (checkedId == R.id.rb_self) {
            //个人中心页
            if (mSelfFrament == null) {
                mSelfFrament = RouterCenter.toMallSelf();
                transaction.add(R.id.fl_content,mSelfFrament);
                mFragments.add(mSelfFrament);
            } else {
                transaction.show(mSelfFrament);
            }
        }

        transaction.commitAllowingStateLoss();
    }

    /**
     * 隐藏掉所有的Fragment
     */
    private void hideFragments(FragmentTransaction transaction) {
        for (Fragment fragment : mFragments) {
            if (fragment != null && !fragment.isHidden()) {
                transaction.hide(fragment);
            }
        }
    }

    @Override
    public void onBackPressed() {
        //退出提示
        if (System.currentTimeMillis() - exitTime > 2000) {
            ToastUtils.showShort(this, getString(R.string.mall_exit));
            exitTime = System.currentTimeMillis();
        } else {
            exitApp();
            super.onBackPressed();
        }
    }
}
