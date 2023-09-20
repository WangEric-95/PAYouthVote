package com.payouth.hackathon.vote.ui.login;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;

import com.payouth.hackathon.vote.data.DemoRepository;

import me.goldze.mvvmhabit.base.BaseViewModel;

public class LoginActivityViewModel extends BaseViewModel<DemoRepository> {

    public LoginActivityViewModel(@NonNull Application application, DemoRepository model) {
        super(application, model);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
