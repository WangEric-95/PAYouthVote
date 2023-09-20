package com.payouth.hackathon.vote.app;

import android.annotation.SuppressLint;
import android.app.Application;

import com.payouth.hackathon.vote.data.DemoRepository;
import com.payouth.hackathon.vote.ui.login.LoginActivityViewModel;
import com.payouth.hackathon.vote.ui.login.LoginViewModel;
import com.payouth.hackathon.vote.ui.network.NetWorkViewModel;
import com.payouth.hackathon.vote.ui.register.RegisterFragment;
import com.payouth.hackathon.vote.ui.register.RegisterFragmentViewModel;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

/**
 * Created by goldze on 2019/3/26.
 */
public class AppViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    @SuppressLint("StaticFieldLeak")
    private static volatile AppViewModelFactory INSTANCE;
    private final Application mApplication;
    private final DemoRepository mRepository;

    public static AppViewModelFactory getInstance(Application application) {
        if (INSTANCE == null) {
            synchronized (AppViewModelFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new AppViewModelFactory(application, Injection.provideDemoRepository());
                }
            }
        }
        return INSTANCE;
    }

    @VisibleForTesting
    public static void destroyInstance() {
        INSTANCE = null;
    }

    private AppViewModelFactory(Application application, DemoRepository repository) {
        this.mApplication = application;
        this.mRepository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(NetWorkViewModel.class)) {
            return (T) new NetWorkViewModel(mApplication, mRepository);
        } else if (modelClass.isAssignableFrom(LoginViewModel.class)) {
            return (T) new LoginViewModel(mApplication, mRepository);
        } else if (modelClass.isAssignableFrom(LoginActivityViewModel.class)) {
            return (T) new LoginActivityViewModel(mApplication, mRepository);
        } else if (modelClass.isAssignableFrom(RegisterFragmentViewModel.class)){
            return (T) new RegisterFragmentViewModel(mApplication);
        }
        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
