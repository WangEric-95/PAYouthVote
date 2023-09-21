package com.payouth.hackathon.vote.ui.login;

import android.app.Application;
import android.text.TextUtils;
import android.view.View;

import com.payouth.hackathon.vote.data.DemoRepository;
import com.payouth.hackathon.vote.ui.main.DemoActivity;
import com.payouth.hackathon.vote.ui.tab_bar.activity.TabBarActivity;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.goldze.mvvmhabit.binding.command.BindingConsumer;
import me.goldze.mvvmhabit.bus.event.SingleLiveEvent;
import me.goldze.mvvmhabit.utils.RxUtils;
import me.goldze.mvvmhabit.utils.ToastUtils;

/**
 * Created by goldze on 2017/7/17.
 */

public class LoginViewModel extends BaseViewModel<DemoRepository> {

    public ObservableField<String> userName = new ObservableField<>("");

    public ObservableField<String> password = new ObservableField<>("");


    public ObservableInt clearBtnVisibility = new ObservableInt();

    public UIChangeObservable uc = new UIChangeObservable();

    public class UIChangeObservable {
        public SingleLiveEvent<Boolean> pSwitchEvent = new SingleLiveEvent<>();
        public SingleLiveEvent<Boolean> pRegisterClickEvent = new SingleLiveEvent<>();

    }

    public LoginViewModel(@NonNull Application application, DemoRepository repository) {
        super(application, repository);
        userName.set(model.getUserName());
    }

    public BindingCommand clearUserNameOnClickCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            userName.set("");
        }
    });
    public BindingCommand passwordShowSwitchOnClickCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            uc.pSwitchEvent.setValue(uc.pSwitchEvent.getValue() == null || !uc.pSwitchEvent.getValue());
        }
    });

    public BindingCommand<Boolean> onFocusChangeCommand = new BindingCommand<>(new BindingConsumer<Boolean>() {
        @Override
        public void call(Boolean hasFocus) {
            if (hasFocus) {
                clearBtnVisibility.set(View.VISIBLE);
            } else {
                clearBtnVisibility.set(View.INVISIBLE);
            }
        }
    });

    public BindingCommand loginOnClickCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            login();
        }
    });

    public BindingCommand forgetPasswordOnClickCommand;

    public BindingCommand registerOnClickCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            uc.pRegisterClickEvent.setValue(true);
        }
    });

    private void register() {
        ToastUtils.showShort("register");
    }

    private void forgetPassword() {
        ToastUtils.showShort("forgetPassword");
    }

    private void login() {
        if (TextUtils.isEmpty(userName.get())) {
            ToastUtils.showShort("Please input a ID card number！");
            return;
        }
        if (TextUtils.isEmpty(password.get())) {
            ToastUtils.showShort("Please input password！");
            return;
        }
        addSubscribe(model.login()
                .compose(RxUtils.schedulersTransformer())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        showDialog();
                    }
                })
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {
                        dismissDialog();
                        model.saveUserName(userName.get());
                        model.savePassword(password.get());
                        startActivity(TabBarActivity.class);
                        finish();
                    }
                }));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
