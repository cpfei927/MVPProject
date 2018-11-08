package com.cpfei.mvpproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.cpfei.mvpproject.listener.OnLoginResultListener;
import com.cpfei.mvpproject.model.IModel;
import com.cpfei.mvpproject.presenter.IPresenterImpl;
import com.cpfei.mvpproject.view.IView;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener, IView, OnLoginResultListener {
//还想让我加啥啊 你想看啥啊你说 你在搞什么机密的东西：
    protected EditText userName, password;
    protected IPresenterImpl iPresenteri;
    protected TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        initView2();

        initView2();

        initView2();

        iPresenter = new IPresenterImpl(this);
        iPresenter.setLoginResultListener(this);
        //====================== Add by rqhua ======================
        String string = string.toString();
        System.out.println("string " + string);
    }

    protected void initView() {
        userName = ((EditText) findViewById(R.id.userName));
        password = ((EditText) findViewById(R.id.password));

        result = ((TextView) findViewById(R.id.result));

        findViewById(R.id.toast).setOnClickListener(this);
        findViewById(R.id.clear).setOnClickListener(this);
    }


    protected void initView2() {
        userName = ((EditText) findViewById(R.id.userName));
        password = ((EditText) findViewById(R.id.password));

        findViewById(R.id.toast).setOnClickListener(this);
        findViewById(R.id.clear).setOnClickListener(this);

        userName = ((EditText) findViewById(R.id.userName));
        password = ((EditText) findViewById(R.id.password));

        password.setText("我是来捣乱的");

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
