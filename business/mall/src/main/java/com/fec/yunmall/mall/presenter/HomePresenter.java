package com.fec.yunmall.mall.presenter;

import com.fec.yunmall.core.net.common_callback.INetCallback;
import com.fec.yunmall.mall.contract.HomeContract;
import com.fec.yunmall.projectcore.api.ApiService;
import com.fec.yunmall.projectcore.base.vp.observer.ModelService;
import com.fec.yunmall.projectcore.base.bean.BaseObj;
import com.fec.yunmall.projectcore.base.vp.presenter.BasePresenter;
import com.fec.yunmall.projectcore.bean.home.TestRankingBean;
import com.fec.yunmall.projectcore.params.RequestMapParams;
import com.fec.yunmall.projectcore.util.L;
import io.reactivex.Observable;
import java.util.Map;

/**
 * @author tome
 * @date 2019/1/28  15:05
 * @describe ${主页presenter}
 */
public class HomePresenter extends BasePresenter<HomeContract.View> implements HomeContract.Presenter{

    @Override
    public void getHomeListData() {

    }

    @Override
    public void getTestData() {
        RequestMapParams params = new RequestMapParams();
        Map<String,String> map = params.build();

        addDisposable(ModelService.getRemoteData(true,mView,new ModelService.SelectListener<TestRankingBean>() {
            @Override
            public Observable<BaseObj<TestRankingBean>> selectApi(ApiService service) {
                return service.getRanking(map);
            }
        },new INetCallback<TestRankingBean>() {
            @Override
            public void onSuccess(TestRankingBean result) {
                if (BaseObj.STATE.equals(result.getState())){
                    L.d("okhttp:"+mView);
                    //mView.showNormal();
                    mView.showHomeTestData(result.getObj());
                }

            }
        }));
    }
}
