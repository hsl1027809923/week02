package model;

import contract.Icontract;
import util.VolleyUtil;

/*
 *@auther:郝世龙
 *@Date: 2019-11-11
 *@Time:9:15
 *@Description:${model层}
 **/public class MyModel {
    public void modelget(String url, Icontract.CallBack callBack){
        VolleyUtil.getInstance().ToGet(url, callBack);
    }
}
