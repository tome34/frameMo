package com.fec.yunmall.mall.contract;

import com.fec.yunmall.projectcore.base.vp.inter.IPresenter;
import com.fec.yunmall.projectcore.base.vp.inter.IView;
import com.fec.yunmall.projectcore.bean.home.TestRankingBean;

/**
 * @Created by TOME .
 * @时间 2018/5/4 11:15
 * @描述 ${TODO}
 */

public interface HomeContract {

    interface View extends IView{
        void showHomeTestData(TestRankingBean.ObjBean data);
    }

    interface Presenter extends IPresenter<View>{
        void getHomeListData();
        void getTestData();
    }
}
