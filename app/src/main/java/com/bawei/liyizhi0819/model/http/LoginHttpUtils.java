package com.bawei.liyizhi0819.model.http;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bawei.liyizhi0819.model.app.App;
import com.bawei.liyizhi0819.model.bean.LoginBean;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>文件描述：<p>
 * <p>作者：志哥<p>
 * <p>创建时间：2019/8/19<p>
 * <p>更改时间：2019/8/19<p>
 * <p>版本号：1<p>
 */
public class LoginHttpUtils {
    private static final LoginHttpUtils ourInstance = new LoginHttpUtils();

    public static LoginHttpUtils getInstance() {
        return ourInstance;
    }

    private LoginHttpUtils() {
    }

    public void getdata(String path, final String name, final String pass, final CallBackooo callBackooo) {
        RequestQueue requestQueue = Volley.newRequestQueue(App.context);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, path, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                LoginBean loginBean = gson.fromJson(response, LoginBean.class);
                callBackooo.ok(loginBean);
            }
        }, null) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> map = new HashMap<>();
                map.put("phone", name);
                map.put("pwd", pass);
                return map;
            }
        };
        requestQueue.add(stringRequest);
    }

    public interface CallBackooo {
        void ok(LoginBean loginBean);
    }

}
