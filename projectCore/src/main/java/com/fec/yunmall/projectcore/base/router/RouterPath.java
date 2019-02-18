package com.fec.yunmall.projectcore.base.router;

/**
 * @author tome
 * @date 2019/1/24  17:14
 * @describe ${基本的RouterPath}
 * 注意:path路径模式”/app/xxxx/”,Aouter 要求path必须有至少两级的路径,
 * 不同module的一级路径必须不同，否则会导致一个moudle中的一级路径失效！
 */
public interface RouterPath {

    String MALL_HOME = "/mall/home";
    String MALL_GOODS = "/order/goods";
    String MALL_SHOP_CART = "/shop/shopcart";
    String MALL_SELF = "/self/page";

}
