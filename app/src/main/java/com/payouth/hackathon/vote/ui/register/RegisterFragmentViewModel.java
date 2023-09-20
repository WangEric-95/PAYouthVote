package com.payouth.hackathon.vote.ui.register;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.goldze.mvvmhabit.R;
import com.payouth.hackathon.vote.data.DemoRepository;
import com.payouth.hackathon.vote.ui.login.LoginFragment;
import com.payouth.hackathon.vote.ui.login.LoginViewModel;

import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.goldze.mvvmhabit.bus.event.SingleLiveEvent;
import me.goldze.mvvmhabit.utils.ToastUtils;

public class RegisterFragmentViewModel extends BaseViewModel<DemoRepository> {


    public ObservableField<String> userName = new ObservableField<>("");

    public ObservableField<String> password = new ObservableField<>("");
    public ObservableField<String> idno = new ObservableField<>("");

    public UIChangeObservable1 uc = new UIChangeObservable1();

//    public RegisterFragmentViewModel(@NonNull Application application, DemoRepository model) {
//        super(application, model);
//    }
    public RegisterFragmentViewModel(@NonNull Application application) {
        super(application);
    }

    public class UIChangeObservable1 {
        public SingleLiveEvent<Boolean> pRegisterClickEvent = new SingleLiveEvent<>();
    }

    public BindingCommand registerOnClickCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            uc.pRegisterClickEvent.setValue(true);
        }
    });

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
