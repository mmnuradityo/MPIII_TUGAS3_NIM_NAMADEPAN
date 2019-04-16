package com.project_n.testlistretrofit.View.Base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        initComponents();
        findView();
        initView();
    }

    public abstract int getLayout();
    public abstract void initComponents();
    public abstract void findView();
    public abstract void initView();

}
