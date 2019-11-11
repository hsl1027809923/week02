package base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/*
 *@auther:郝世龙
 *@Date: 2019-11-11
 *@Time:9:07
 *@Description:${基类}
 **/public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {
    public P p;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //加载布局
        setContentView(Layout());
        p=Presente();
        //绑定方法
        if (p!=null){
            p.attach(this);
        }
        //初始化控件
        initView();
        //
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int Layout();
    protected abstract P Presente();
    //解绑方法
    //③　解决MVP内存泄漏。
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (p!=null){
            p.Uattch();
            p=null;
        }
    }
}
