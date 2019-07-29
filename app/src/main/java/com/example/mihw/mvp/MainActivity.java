package com.example.mihw.mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.mihw.mvp.modle.User;
import com.example.mihw.mvp.pecenter.UserLoginPecenter;
import com.example.mihw.mvp.view.IUserLoginView;

public class MainActivity extends AppCompatActivity implements IUserLoginView{
    private EditText username,password;
    private Button login,clear;
    private ProgressBar loding;
    private UserLoginPecenter userLoginPecenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userLoginPecenter=new UserLoginPecenter(this);
        initView();
    }

    private void initView() {
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        login=findViewById(R.id.login);
        clear=findViewById(R.id.clear);
        loding=findViewById(R.id.loding);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLoginPecenter.login();
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLoginPecenter.clear();
            }
        });
    }

    @Override
    public String getUserName() {
        return username.getText().toString();
    }

    @Override
    public String getPassword() {
        return password.getText().toString();
    }

    @Override
    public void clearUserName() {
       username.setText("");
    }

    @Override
    public void clearPassword() {
        password.setText("");
    }

    @Override
    public void showLoading() {
        loding.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        loding.setVisibility(View.GONE);
    }

    @Override
    public void toMainActivity(User user) {
        Toast.makeText(this,"登录成功",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFaileTips() {
        Toast.makeText(this,"登录失败",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //为了防止内存泄漏，解绑Presenter层对View层的引用
        userLoginPecenter.detachView();
    }
}
