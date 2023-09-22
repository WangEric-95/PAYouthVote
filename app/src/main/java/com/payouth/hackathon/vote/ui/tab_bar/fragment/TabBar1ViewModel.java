package com.payouth.hackathon.vote.ui.tab_bar.fragment;

import android.app.Application;

import androidx.annotation.NonNull;

import com.payouth.hackathon.vote.data.DemoRepository;

import me.goldze.mvvmhabit.base.BaseViewModel;

public class TabBar1ViewModel extends BaseViewModel<DemoRepository> {

    public TabBar1ViewModel(@NonNull Application application) {
        super(application);
    }

    public TabBar1ViewModel(@NonNull Application application, DemoRepository model) {
        super(application, model);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
