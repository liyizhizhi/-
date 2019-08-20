package com.bawei.liyizhi0819.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.liyizhi0819.R;
import com.bawei.liyizhi0819.model.bean.LoginBean;
import com.bawei.liyizhi0819.presenter.RegisterPresenter;
import com.bawei.liyizhi0819.view.interfaces.IMainView;

public class RegisterActivity extends BaseActivity implements IMainView.LoginCallo {

    private EditText name2;
    private EditText pass2;
    private Button zhuce2;
    private RegisterPresenter presenter;

    @Override
    int onLayout() {
        return R.layout.activity_register;
    }

    @Override
    void onInitView() {
        name2 = findViewById(R.id.name2);
        pass2 = findViewById(R.id.pass2);
        zhuce2 = findViewById(R.id.zhuce2);
        zhuce2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name1 = RegisterActivity.this.name2.getText().toString().trim();
                String pass1 = RegisterActivity.this.pass2.getText().toString().trim();
                presenter.RegisterPresenter(name1, pass1);
            }
        });
    }

    @Override
    void onInitData() {
        presenter = new RegisterPresenter();
        presenter.ActachView(this);
        presenter.getView();
    }

    @Override
    public void success(LoginBean loginBean) {
        if (loginBean.getStatus().equals("0000")) {
            Toast.makeText(this, loginBean.getMessage(), Toast.LENGTH_SHORT).show();
            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
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
