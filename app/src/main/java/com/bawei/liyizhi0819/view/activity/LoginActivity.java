package com.bawei.liyizhi0819.view.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.liyizhi0819.R;
import com.bawei.liyizhi0819.model.bean.LoginBean;
import com.bawei.liyizhi0819.presenter.LoginPresenter;
import com.bawei.liyizhi0819.view.interfaces.IMainView;

public class LoginActivity extends BaseActivity implements IMainView.LoginCallo {

    private EditText name;
    private EditText pass;
    private Button deng;
    private Button zhuce;
    private LoginPresenter presenter;

    @Override
    int onLayout() {
        return R.layout.activity_login;
    }

    @Override
    void onInitView() {
        name = findViewById(R.id.name);
        pass = findViewById(R.id.pass);
        deng = findViewById(R.id.deng);
        zhuce = findViewById(R.id.zhuce);
        deng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name1 = LoginActivity.this.name.getText().toString().trim();
                String pass1 = LoginActivity.this.pass.getText().toString().trim();
                presenter.LoginPresenter(name1, pass1);
            }
        });
        zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));

            }
        });
    }

    @Override
    void onInitData() {
        presenter = new LoginPresenter();
        presenter.ActachView(this);
        presenter.getView();
    }

    @Override
    public void success(LoginBean loginBean) {
        if (loginBean.getStatus().equals("0000")) {
            Toast.makeText(this, loginBean.getMessage(), Toast.LENGTH_SHORT).show();
            startActivity(new Intent(LoginActivity.this, HomeActivity.class));
        } else {
            Toast.makeText(this, loginBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.DatachView();
    }
}
