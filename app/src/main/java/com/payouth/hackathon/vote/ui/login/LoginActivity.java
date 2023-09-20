package com.payouth.hackathon.vote.ui.login;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.KeyEvent;

import com.goldze.mvvmhabit.BR;
import com.goldze.mvvmhabit.R;
import com.payouth.hackathon.vote.app.AppViewModelFactory;
import com.goldze.mvvmhabit.databinding.ActivityLoginBinding;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import me.goldze.mvvmhabit.base.BaseActivity;

/**
 * vote登陆界面
 */
public class LoginActivity extends BaseActivity<ActivityLoginBinding, LoginActivityViewModel> {

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_login;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public LoginActivityViewModel initViewModel() {
        AppViewModelFactory factory = AppViewModelFactory.getInstance(getApplication());
        return ViewModelProviders.of(this, factory).get(LoginActivityViewModel.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (isFirstTimeLaunch()) {
            showSplashScreen();
        } else {
            showLoginFragment();
        }

    }

    private void showSplashScreen() {
        binding.containerFl.setBackgroundResource(R.mipmap.splash);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                showLoginFragment();
            }
        }, 3000);
    }

    private void showLoginFragment() {
        FragmentManager manager = getSupportFragmentManager();
        Fragment topfragement = manager.findFragmentById(R.id.container_fl);
        if (!(topfragement instanceof LoginFragment)) {
            FragmentTransaction fragmentTransaction = manager.beginTransaction();
            fragmentTransaction.setCustomAnimations(R.anim.page_enter_in,R.anim.page_enter_out,R.anim.page_exit_in,R.anim.page_exit_out);
            fragmentTransaction.add(R.id.container_fl, LoginFragment.newInstance(),LoginFragment.class.getCanonicalName());
            fragmentTransaction.addToBackStack(LoginFragment.class.getCanonicalName());
            fragmentTransaction.commit();
        }
    }

    private boolean isFirstTimeLaunch() {
        SharedPreferences sp = getPreferences(Context.MODE_PRIVATE);
        return !sp.contains("splash_committed");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
