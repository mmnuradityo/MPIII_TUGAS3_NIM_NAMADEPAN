package com.project_n.testlistretrofit.Presenter.Login;

import android.app.Activity;

public interface PresenterLogin {

    void loginComponenet(Activity context);
    void setLogin(String name, boolean isLogin);
    Boolean getLogin();

}
