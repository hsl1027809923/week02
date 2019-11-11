package util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Map;

import app.MyApp;
import contract.Icontract;

/*
 *@auther:郝世龙
 *@Date: 2019-11-11
 *@Time:9:15
 *@Description:${Volley层}
 **/public class VolleyUtil {
    //创建队列
    RequestQueue queue= Volley.newRequestQueue(MyApp.context);
    //单例模式
    public static VolleyUtil util=new VolleyUtil();
    //私有化构造
    private VolleyUtil() {
    }
    public static  VolleyUtil getInstance(){
       return util;
    }

    //请求网络⑥　封装网络状态判断方法，可以判断有网无网。
    public boolean getNet(Context context){
        ConnectivityManager manager= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        if (info!=null){
            return info.isConnected();
        }
        return false;

    }
//-----------------⑤　封装Volley的get和post。
    //get请求
    public void ToGet(String url,final Icontract.CallBack callBack){
        StringRequest request=new StringRequest(0, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callBack.Success(response);
                Log.i("a","ccs"+response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.error(error.getMessage());
            }
        });
        queue.add(request);
    }

    //post请求
    public void ToPost(String url, final Map<String,String>map, final Icontract.CallBack callBack){
        StringRequest request=new StringRequest(1, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callBack.Success(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.error(error.getMessage());
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return map;
            }
        };
        queue.add(request);
    }
}
