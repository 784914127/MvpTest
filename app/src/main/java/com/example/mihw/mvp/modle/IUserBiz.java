package com.example.mihw.mvp.modle;

import com.example.mihw.mvp.OnLoginListener;

public interface IUserBiz {

   void login(String userName, String passWord, OnLoginListener onLoginListener);
}
