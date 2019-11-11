package app;

import android.app.Application;
import android.content.Context;

/*
 *@auther:郝世龙
 *@Date: 2019-11-11
 *@Time:9:21
 *@Description:${上下文}
 **/public class MyApp extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context=this;
    }
}
