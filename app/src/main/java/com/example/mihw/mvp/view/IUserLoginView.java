package com.example.mihw.mvp.view;

import com.example.mihw.mvp.modle.User;

public interface IUserLoginView {
    String getUserName();
    String getPassword();
    void clearUserName();
    void clearPassword();
    void showLoading();
    void hideLoading();
    void toMainActivity(User user);
    void showFaileTips();
}
