package com.example.mihw.mvp;

import com.example.mihw.mvp.modle.User;

public interface OnLoginListener {

   void onSuccess(User user);
   void onFaild();
}
