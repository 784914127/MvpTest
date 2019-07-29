package com.example.mihw.mvp.pecenter;

import android.os.Handler;

import com.example.mihw.mvp.OnLoginListener;
import com.example.mihw.mvp.modle.User;
import com.example.mihw.mvp.modle.UserBiz;
import com.example.mihw.mvp.view.IUserLoginView;

public class UserLoginPecenter {
   private IUserLoginView iUserLoginView;
   private UserBiz userBiz;
    //对应视图页面销毁的标志位,当视图销毁后回调就不需要处理了
    private boolean destroyFlag;
    private Handler mHandler = new Handler();

    public UserLoginPecenter(IUserLoginView iUserLoginView) {
        this.iUserLoginView = iUserLoginView;
        this.userBiz=new UserBiz();
    }
    public void login(){
        iUserLoginView.showLoading();
        userBiz.login(iUserLoginView.getUserName(), iUserLoginView.getPassword(), new OnLoginListener() {
            @Override
            public void onSuccess(final User user) {
                if(!destroyFlag){
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            iUserLoginView.toMainActivity(user);
                            iUserLoginView.hideLoading();
                        }
                    });
                }
            }

            @Override
            public void onFaild() {
                if(!destroyFlag){
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            iUserLoginView.showFaileTips();
                            iUserLoginView.hideLoading();
                        }
                    });
                }
            }
        });
    }
    public void  clear(){
        iUserLoginView.clearUserName();
        iUserLoginView.clearPassword();
    }
    //解绑视图
    public void detachView(){
        destroyFlag=true;
        iUserLoginView=null;
    }
}
