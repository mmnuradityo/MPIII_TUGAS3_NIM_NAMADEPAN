package com.project_n.testlistretrofit.Presenter.Login;

import android.app.Activity;

import com.project_n.testlistretrofit.utils.PreferencesHelper;

public class LoginImpl implements PresenterLogin{

    private PreferencesHelper preferencesHelper;

    @Override
    public void loginComponenet(Activity context) {
        preferencesHelper = PreferencesHelper.getInstance(context.getApplicationContext());
    }

    @Override
    public void setLogin(String name, boolean isLogin) {
        preferencesHelper.setName(name);
        preferencesHelper.setLogin(isLogin);
    }

    @Override
    public Boolean getLogin() {
        return preferencesHelper.isLogin();
    }
}
