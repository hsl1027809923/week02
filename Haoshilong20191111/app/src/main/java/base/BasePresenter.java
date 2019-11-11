package base;

/*
 *@auther:郝世龙
 *@Date: 2019-11-11
 *@Time:9:08
 *@Description:${p层基类}
 **/public class BasePresenter<V extends BaseActivity>  {
    public V v;
    //绑定方法
    public void attach(V v){
        this.v=v;
    }
    //③　解决MVP内存泄漏。
    //解绑方法
    public void Uattch(){
        if (v!=null){
            v=null;
        }
    }

}
