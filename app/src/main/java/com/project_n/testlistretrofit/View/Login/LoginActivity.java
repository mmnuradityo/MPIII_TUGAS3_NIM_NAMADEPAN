package com.project_n.testlistretrofit.View.Login;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.project_n.testlistretrofit.Presenter.Login.LoginImpl;
import com.project_n.testlistretrofit.R;
import com.project_n.testlistretrofit.View.Base.BaseActivity;
import com.project_n.testlistretrofit.View.Main.MainActivity;

public class LoginActivity extends BaseActivity {

    private EditText email, pass;
    private String user_email, user_pass;
    private LoginImpl login;

    @Override
    public int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void initComponents() {
        login = new LoginImpl();
        login.loginComponenet(this);
    }

    @Override
    public void findView() {
        email = findViewById(R.id.et_email);
        pass = findViewById(R.id.et_pass);
    }

    @Override
    public void initView() {
        if (login.getLogin()) {
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
        }
    }

    public void btn_login(View view) {
        user_email = email.getText().toString();
        user_pass = pass.getText().toString();

        if (user_email == "" & user_pass == "") {
            Toast.makeText(this, "harap masukan Email dan Password", Toast.LENGTH_SHORT).show();
        } else {
            login.setLogin(user_email, true);
            Toast.makeText(this, "login sukses", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
        }

    }


}
