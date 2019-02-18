package com.fec.yunmall.userCenter.contract;

import com.fec.yunmall.projectcore.base.vp.inter.IPresenter;
import com.fec.yunmall.projectcore.base.vp.inter.IView;

/**
 * @Created by TOME .
 * @时间 2018/5/4 11:15
 * @描述 ${TODO}
 */

public interface SelfContract {

    interface View extends IView{
        void showSelfView();
    }

    interface Presenter extends IPresenter<View>{
        void getSelfData();
    }
}
