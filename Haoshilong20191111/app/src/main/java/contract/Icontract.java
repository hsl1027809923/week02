package contract;

import bean.Shop;

/*
 *@auther:郝世龙
 *@Date: 2019-11-11
 *@Time:9:27
 *@Description:${契约类}
 **/public interface Icontract {
    //②　使用契约统一管理MVP接口。
    //V
    public interface IView{
        void  success(Shop shop);
    }
    //P
    public interface Presenter{
        void success(String url);
    }


    //CallBack
    public interface CallBack{
        void Success(String json);
        void error(String er);
    }
}
