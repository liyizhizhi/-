package com.bawei.liyizhi0819.view.interfaces;

import com.bawei.liyizhi0819.model.bean.LoginBean;

/**
 * <p>文件描述：<p>
 * <p>作者：志哥<p>
 * <p>创建时间：2019/8/19<p>
 * <p>更改时间：2019/8/19<p>
 * <p>版本号：1<p>
 */
public interface IMainView {
    interface LoginCallo extends IBaseView{
        void success(LoginBean loginBean);
    }
}
