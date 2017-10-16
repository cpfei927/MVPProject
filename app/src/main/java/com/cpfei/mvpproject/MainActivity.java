package com.cpfei.mvpproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.cpfei.mvpproject.listener.loginResultListener;
import com.cpfei.mvpproject.model.IModel;
import com.cpfei.mvpproject.presenter.IPresenterImpl;
import com.cpfei.mvpproject.view.IView;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener, IView, loginResultListener {

    protected EditText userName, password;
    protected IPresenterImpl iPresenter;
    protected TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        iPresenter = new IPresenterImpl(this);
        iPresenter.setLoginResultListener(this);
    }

    protected void initView() {
        userName = ((EditText) findViewById(R.id.userName));
        password = ((EditText) findViewById(R.id.password));

        result = ((TextView) findViewById(R.id.result));

        findViewById(R.id.toast).setOnClickListener(this);
        findViewById(R.id.clear).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.toast:
                iPresenter.login(getUserName(), getPassword());
                break;
            case R.id.clear:
                iPresenter.clearTextAll();
                break;
        }
    }

    @Override
    public String getUserName() {
        return userName.getText().toString();
    }

    @Override
    public String getPassword() {
        return password.getText().toString();
    }

    @Override
    public void clearTextAll() {
        userName.setText("");
        password.setText("");
    }

    @Override
    public void loginResult(IModel iModel) {
        result.setText(iModel.toString());
    }
}
