package com.cpfei.mvpproject.presenter;

import com.cpfei.mvpproject.listener.OnLoginResultListener;

/**
 * Created by cpfei on 2017/10/16.
 */

public interface IPresenter {

    void login(String userName, String password);


    void clearTextAll();

    void setLoginResultListener(OnLoginResultListener listener);
}
