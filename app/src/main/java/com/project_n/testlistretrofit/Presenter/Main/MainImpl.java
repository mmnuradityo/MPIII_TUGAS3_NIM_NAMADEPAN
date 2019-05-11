package com.project_n.testlistretrofit.Presenter.Main;

import android.app.Activity;

import com.project_n.testlistretrofit.utils.PreferencesHelper;

public class MainImpl implements MainPresenter {

    private PreferencesHelper preferencesHelper;

    @Override
    public void MainComponent(Activity context) {
        preferencesHelper = PreferencesHelper.getInstance(context.getApplicationContext());
    }

    @Override
    public String getName() {
        return preferencesHelper.getName();
    }
}
