package com.payouth.hackathon.vote.ui.register;

import android.app.Application;
import android.text.TextUtils;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;

import com.payouth.hackathon.vote.data.DemoRepository;
import com.payouth.hackathon.vote.ui.base.viewmodel.ToolbarViewModel;
import com.payouth.hackathon.vote.ui.tab_bar.activity.TabBarActivity;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.goldze.mvvmhabit.bus.event.SingleLiveEvent;
import me.goldze.mvvmhabit.utils.RxUtils;
import me.goldze.mvvmhabit.utils.ToastUtils;

public class RegisterFragmentViewModel extends ToolbarViewModel<DemoRepository> {


    public ObservableField<String> userName = new ObservableField<>("");

    public ObservableField<String> password = new ObservableField<>("");
    public ObservableField<String> passwordConfirm = new ObservableField<>("");
    public ObservableField<String> idno = new ObservableField<>("");
    public ObservableField<String> mail = new ObservableField<>("");


    public UIChangeObservable uc = new UIChangeObservable();

    public RegisterFragmentViewModel(@NonNull Application application, DemoRepository model) {
        super(application, model);
    }
    public RegisterFragmentViewModel(@NonNull Application application) {
        super(application);
    }

    public class UIChangeObservable {
        public SingleLiveEvent<Boolean> pRegisterClickEvent = new SingleLiveEvent<>();

        public SingleLiveEvent<Boolean> pBackButtonClickEvent = new SingleLiveEvent<>();

    }

    public BindingCommand registerOnClickCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            register();
        }
    });

    public void initToolbar() {
        setRightTextVisible(View.GONE);
    }

    private void register() {
        if (TextUtils.isEmpty(idno.get())) {
            ToastUtils.showShort("Please input a ID card number！");
            return;
        }
        if (TextUtils.isEmpty(userName.get())) {
            ToastUtils.showShort("Please input you userName！");
            return;
        }
        if (TextUtils.isEmpty(mail.get())) {
            ToastUtils.showShort("Please input mail address for vote purpose！");
            return;
        }
        if (TextUtils.isEmpty(password.get())) {
            ToastUtils.showShort("Please input password！");
            return;
        }
        if (TextUtils.isEmpty(passwordConfirm.get())) {
            ToastUtils.showShort("Please confirm your password！");
            return;
        }
        if (!passwordConfirm.get().equals(password.get())) {
            ToastUtils.showShort("the second time password what input not matched");
            return;
        }

        addSubscribe(model.register()
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
                        ToastUtils.showLong("Congratulations！ you can login and voting now");
                        model.saveUserName(userName.get());
                        backOnClick.execute();
                    }
                }));
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
