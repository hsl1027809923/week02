package presenter;

import com.bawei.haoshilong.MainActivity;
import com.google.gson.Gson;

import base.BasePresenter;
import bean.Shop;
import contract.Icontract;
import model.MyModel;

/*
 *@auther:郝世龙
 *@Date: 2019-11-11
 *@Time:9:14
 *@Description:${presenter层}
 **/public class MyPresenter extends BasePresenter implements Icontract.Presenter {
    MyModel model;

    public MyPresenter() {
        model=new MyModel();
    }


    @Override
    public void success(String url) {
        model.modelget(url, new Icontract.CallBack() {
            @Override
            public void Success(String json) {
                //解析
                Gson gson=new Gson();
                Shop shop = gson.fromJson(json, Shop.class);
                MainActivity activity= (MainActivity) v;
                activity.success(shop);
            }

            @Override
            public void error(String er) {

            }
        });
    }
}
