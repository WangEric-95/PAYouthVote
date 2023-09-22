package com.payouth.hackathon.vote.ui.tab_bar.fragment;

import android.app.Application;

import androidx.annotation.NonNull;

import com.payouth.hackathon.vote.data.DemoRepository;
import com.payouth.hackathon.vote.ui.base.viewmodel.ToolbarViewModel;

import me.goldze.mvvmhabit.base.BaseViewModel;

public class TabBar2ViewModel extends ToolbarViewModel<DemoRepository> {

    public TabBar2ViewModel(@NonNull Application application) {
        super(application);
    }

    public TabBar2ViewModel(@NonNull Application application, DemoRepository model) {
        super(application, model);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
