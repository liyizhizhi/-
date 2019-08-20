package com.bawei.liyizhi0819.presenter;

import com.bawei.liyizhi0819.view.interfaces.IBaseView;

/**
 * <p>文件描述：<p>
 * <p>作者：志哥<p>
 * <p>创建时间：2019/8/19<p>
 * <p>更改时间：2019/8/19<p>
 * <p>版本号：1<p>
 */
public class BasePresenter <T extends IBaseView> {
    private T view;

    public void ActachView(T baseview) {
        this.view = baseview;
    }
    public void DatachView() {
        this.view = null;
    }

    public T getView() {
        return view;
    }
}
