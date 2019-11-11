package com.bawei.haoshilong;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import adapter.MyAdapterA;
import adapter.MyAdapterB;
import adapter.MyAdapterc;
import appis.API;
import base.BaseActivity;
import base.BasePresenter;
import bean.Shop;
import contract.Icontract;
import presenter.MyPresenter;
import util.VolleyUtil;

/*
 *@auther:郝世龙
 *@Date: 2019-11-11
 *@Time:9:07
 *@Description:${主页面}
 **/
public class MainActivity extends BaseActivity implements Icontract.IView {
    RecyclerView recyclerViewa,recyclerViewb,recyclerViewc;
    //设置数据
    @Override
    protected void initData() {
        boolean net = VolleyUtil.getInstance().getNet(this);
        if (net){
            //设置接口数据
            API api=new API();
            MyPresenter presenter= (MyPresenter) p;
            presenter.success(api.toUrl());
            Toast.makeText(this, "有网", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "检查网络", Toast.LENGTH_SHORT).show();
        }


    }
    //初始化控件
    @Override
    protected void initView() {
        //----recycle  A
        recyclerViewa=findViewById(R.id.RecyclerView_a);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        //设置横向
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerViewa.setLayoutManager(manager);
        //----recycle  B
        recyclerViewb=findViewById(R.id.RecyclerView_b);
        recyclerViewb.setLayoutManager(new LinearLayoutManager(this));
        //----recycle  C
        recyclerViewc=findViewById(R.id.RecyclerView_c);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
        recyclerViewc.setLayoutManager(gridLayoutManager);


    }
    //加载布局
    @Override
    protected int Layout() {
        return R.layout.activity_main;
    }
    //实例化presenter
    @Override
    protected BasePresenter Presente() {
        return new MyPresenter();
    }

    @Override
    public void success(final Shop shop) {
        //----------A
      MyAdapterA adapterA=new MyAdapterA(shop.getData().getHorizontalListData(),this);
      recyclerViewa.setAdapter(adapterA);
      //(5)	刷新
      adapterA.notifyDataSetChanged();
        //----------B
        MyAdapterB adapterB =new MyAdapterB(shop.getData().getVerticalListData(),this);
        recyclerViewb.setAdapter(adapterB);

       //-------
        MyAdapterc adapterc=new MyAdapterc(shop.getData().getGridData(),this);
        recyclerViewc.setAdapter(adapterc);
        //点击事件
        adapterB.setOnclickb(new MyAdapterB.onClickb() {
            @Override
            public void itemClic(int postion) {
                Toast.makeText(MainActivity.this, ""+shop.getData().getVerticalListData().get(postion).getPrice(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
