package com.payouth.hackathon.vote.ui.login;

import android.app.Application;

import androidx.annotation.NonNull;

import com.payouth.hackathon.vote.data.DemoRepository;

import me.goldze.mvvmhabit.base.BaseViewModel;

public class LoginActivityViewModel extends BaseViewModel<DemoRepository> {

    public LoginActivityViewModel(@NonNull Application application, DemoRepository model) {
        super(application, model);
    }

    public void showSplashScreen() {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
