package com.example.mihw.mvp.modle;

import com.example.mihw.mvp.OnLoginListener;
import com.example.mihw.mvp.modle.IUserBiz;

public class UserBiz implements IUserBiz {
    @Override
    public void login(final String userName, final String passWord, final OnLoginListener onLoginListener) {

        //模拟网络请求
        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if("mi".equals(userName)&&"888".equals(passWord)){
                     User user=new User();
                     user.setUserName(userName);
                     user.setPassWord(passWord);
                     if(onLoginListener!=null){
                         onLoginListener.onSuccess(user);
                     }
                }else{
                    if(onLoginListener!=null){
                        onLoginListener.onFaild();
                    }
                }

            }
        }.start();
    }
}
