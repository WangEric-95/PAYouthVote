package com.payouth.hackathon.vote.ui.webview;

import android.app.Application;
import android.webkit.WebSettings;

import androidx.annotation.NonNull;

import com.payouth.hackathon.vote.data.DemoRepository;

import me.goldze.mvvmhabit.base.BaseViewModel;


public class WebViewViewModel extends BaseViewModel<DemoRepository> {

    public WebViewViewModel(@NonNull Application application) {
        super(application);
    }

    public WebViewViewModel(@NonNull Application application, DemoRepository model) {
        super(application, model);
    }

}
