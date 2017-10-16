package com.cpfei.mvpproject.presenter;

import android.os.Handler;

import com.cpfei.mvpproject.listener.OnLoginResultListener;
import com.cpfei.mvpproject.model.IModel;
import com.cpfei.mvpproject.view.IView;

/**
 * Created by cpfei on 2017/10/16.
 */

public class IPresenterImpl implements IPresenter {

    private final IView iView;
    private OnLoginResultListener listener;
    private IModel iModel;

    public IPresenterImpl(IView iView) {
        this.iView = iView;
        iModel = new IModel();
    }

    @Override
    public void login(String userName, String password) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 回调结果
                iModel.userName = iView.getUserName();
                iModel.password = iView.getPassword();
                listener.loginResult(iModel);
            }
        }, 100);
    }

    @Override
    public void clearTextAll() {
        iView.clearTextAll();
        // 回调结果
        iModel.userName = iView.getUserName();
        iModel.password = iView.getPassword();
        listener.loginResult(iModel);
    }

    @Override
    public void setLoginResultListener(OnLoginResultListener listener) {
        this.listener = listener;
    }
}
