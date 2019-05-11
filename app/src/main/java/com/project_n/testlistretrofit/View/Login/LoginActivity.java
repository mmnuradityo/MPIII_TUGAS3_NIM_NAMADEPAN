package com.project_n.testlistretrofit.View.Login;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.project_n.testlistretrofit.R;
import com.project_n.testlistretrofit.View.Base.BaseActivity;
import com.project_n.testlistretrofit.View.Main.MainActivity;
import com.project_n.testlistretrofit.utils.PreferencesHelper;

public class LoginActivity extends BaseActivity {

    private PreferencesHelper preferencesHelper;
    private EditText email, pass;
    private String user_email, user_pass;

    @Override
    public int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void initComponents() {
        preferencesHelper = PreferencesHelper.getInstance(getApplicationContext());
    }

    @Override
    public void findView() {
        email = findViewById(R.id.et_email);
        pass = findViewById(R.id.et_pass);
    }

    @Override
    public void initView() {
        if (preferencesHelper.isLogin()) {
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
        }
    }

    public void btn_login(View view) {
        user_email = email.getText().toString();
        user_pass = pass.getText().toString();
        preferencesHelper.setLogin(true);
        preferencesHelper.setName(email.getText().toString());
        Toast.makeText(this, "login sukses", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
    }


}
