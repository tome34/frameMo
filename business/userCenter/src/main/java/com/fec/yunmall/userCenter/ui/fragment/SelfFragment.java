package com.fec.yunmall.userCenter.ui.fragment;

import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.fec.yunmall.projectcore.base.router.RouterPath;
import com.fec.yunmall.projectcore.base.vp.fragment.BaseFragment;
import com.fec.yunmall.userCenter.R;
import com.fec.yunmall.userCenter.R2;
import com.fec.yunmall.userCenter.contract.SelfContract;
import com.fec.yunmall.userCenter.presenter.SelfPresenter;
import com.fec.yunmall.userCenter.widget.MyMaterialItemView;

/**
 * @author tome
 * @date 2019/1/25  10:43
 * @describe ${TODO}
 */
@Route(path = RouterPath.MALL_SELF)
public class SelfFragment extends BaseFragment<SelfPresenter> implements SelfContract.View {

    @BindView(R2.id.view_phone)
    MyMaterialItemView mViewPhone;
    @BindView(R2.id.view_name)
    MyMaterialItemView mViewName;

    @Override
    protected SelfPresenter getPresenter() {
        return new SelfPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.user_fragment_self;
    }

    @Override
    protected void initView(View rootView) {
        TextView phoneTitle = (TextView)mViewPhone.findViewById(R.id.tv_mymaterial_title);
        phoneTitle.setText("手机号码");

        TextView phoneContent = (TextView)mViewName.findViewById(R.id.tv_my_material_content);
        phoneContent.setText("1234587222");
    }

    @Override
    protected void initListenerAddData() {

    }

    @Override
    public void showSelfView() {

    }

}
