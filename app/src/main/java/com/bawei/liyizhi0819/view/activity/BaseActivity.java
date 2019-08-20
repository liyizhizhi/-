package com.bawei.liyizhi0819.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * <p>文件描述：<p>
 * <p>作者：志哥<p>
 * <p>创建时间：2019/8/19<p>
 * <p>更改时间：2019/8/19<p>
 * <p>版本号：1<p>
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(onLayout());
        onInitView();
        onInitData();
    }

    abstract int onLayout();

    abstract void onInitView();

    abstract void onInitData();
}
