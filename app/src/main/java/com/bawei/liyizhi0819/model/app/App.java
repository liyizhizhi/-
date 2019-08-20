package com.bawei.liyizhi0819.model.app;

import android.app.Application;
import android.content.Context;

/**
 * <p>文件描述：<p>
 * <p>作者：志哥<p>
 * <p>创建时间：2019/8/19<p>
 * <p>更改时间：2019/8/19<p>
 * <p>版本号：1<p>
 */
public class App extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context=this;
    }
}
