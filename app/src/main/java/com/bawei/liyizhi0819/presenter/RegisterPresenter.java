package com.bawei.liyizhi0819.presenter;

import com.bawei.liyizhi0819.model.bean.LoginBean;
import com.bawei.liyizhi0819.model.http.CaoJie;
import com.bawei.liyizhi0819.model.http.LoginHttpUtils;
import com.bawei.liyizhi0819.view.interfaces.IMainView;

/**
 * <p>文件描述：<p>
 * <p>作者：志哥<p>
 * <p>创建时间：2019/8/19<p>
 * <p>更改时间：2019/8/19<p>
 * <p>版本号：1<p>
 */
public class RegisterPresenter<V extends IMainView.LoginCallo> extends BasePresenter<V> {
    public void RegisterPresenter(String name, String pass) {
        LoginHttpUtils.getInstance().getdata(CaoJie.BASE_REGISTER, name, pass, new LoginHttpUtils.CallBackooo() {
            @Override
            public void ok(LoginBean loginBean) {
                getView().success(loginBean);
            }
        });
    }
}
