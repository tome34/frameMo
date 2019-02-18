package com.fec.yunmall.mall.ui.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.fec.yunmall.core.base.BaseHost;
import com.fec.yunmall.core.util.SPUtil;
import com.fec.yunmall.mall.R;
import com.fec.yunmall.mall.R2;
import com.fec.yunmall.mall.contract.HomeContract;
import com.fec.yunmall.mall.presenter.HomePresenter;
import com.fec.yunmall.mall.ui.activity.TestKotlinAct;
import com.fec.yunmall.projectcore.base.router.RouterPath;
import com.fec.yunmall.projectcore.base.vp.fragment.BaseFragment;
import com.fec.yunmall.projectcore.bean.home.TestRankingBean;
import com.fec.yunmall.projectcore.util.L;
import com.fec.yunmall.projectcore.util.ToastUtils;

/**
 * @author tome
 * @date 2019/1/25  10:43
 * @describe ${TODO}
 */
@Route(path = RouterPath.MALL_HOME)
public class HomeFragment extends BaseFragment<HomePresenter> implements HomeContract.View {

    @BindView(R2.id.bt_test1)
    Button mBtTest1;
    @BindView(R2.id.bt_test2)
    Button mBtTest2;
    @BindView(R2.id.bt_test3)
    Button mBtTest3;
    @BindView(R2.id.rl_title_bar)
    RelativeLayout layoutTitleBar;
    @BindView(R2.id.tv_center_title)
    TextView tvTitle;

    public boolean selectFlag;

    @Override
    protected HomePresenter getPresenter() {
        return new HomePresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.mall_fragment_home;
    }

    @Override
    protected void initView(View rootView) {
        layoutTitleBar.setBackgroundColor(mContext.getResources().getColor(R.color.color33));
        tvTitle.setText("首页");
    }

    @Override
    protected void initListenerAddData() {

    }

    @Override
    public void showHomeTestData(TestRankingBean.ObjBean data) {
        L.d("请求数据成功" );
    }

    @OnClick({ R2.id.bt_test1,R2.id.bt_test2,R2.id.bt_test3 })
    public void onViewClicked(View view) {
        if (view.getId() == R.id.bt_test1) {
            //ToastUtils.showShort(getContext(),"点击");
            mPresenter.getTestData();
        } else if (view.getId() == R.id.bt_test2) {
            if (selectFlag){
                selectFlag = false;
                SPUtil.put(getContext(),BaseHost.SELECT_SERVER,2);
                ToastUtils.showShort(getContext(),"选择测试服务器");
            }else {
                selectFlag = true;
                SPUtil.put(getContext(),BaseHost.SELECT_SERVER,1);
                ToastUtils.showShort(getContext(),"选择正式服务器");
            }

        } else if (view.getId() == R.id.bt_test3) {
            ToastUtils.showShort(getContext(),"kotlin");
            startActivity(new Intent(mContext,TestKotlinAct.class));
        }
    }

}
