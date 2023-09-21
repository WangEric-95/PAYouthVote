package com.payouth.hackathon.vote.ui.register;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.goldze.mvvmhabit.BR;
import com.goldze.mvvmhabit.R;
import com.goldze.mvvmhabit.databinding.FragmentRegisterBinding;
import com.payouth.hackathon.vote.app.AppViewModelFactory;
import com.payouth.hackathon.vote.ui.login.LoginViewModel;

import me.goldze.mvvmhabit.base.BaseFragment;
import me.goldze.mvvmhabit.utils.ToastUtils;

public class RegisterFragment extends BaseFragment<FragmentRegisterBinding, RegisterFragmentViewModel> {

    public static RegisterFragment newInstance() {
        Bundle args = new Bundle();
        RegisterFragment fragment = new RegisterFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_register;
    }

    @Override
    public RegisterFragmentViewModel initViewModel() {
        AppViewModelFactory factory = AppViewModelFactory.getInstance(getActivity().getApplication());
        return ViewModelProviders.of(this, factory).get(RegisterFragmentViewModel.class);
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public void initViewObservable() {
        super.initViewObservable();

        viewModel.uc.pRegisterClickEvent.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                ToastUtils.showShort("register done , you can login now");
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });

        viewModel.uc.pBackButtonClickEvent.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });
    }
    @Override
    public void initData() {
        super.initData();
        viewModel.initToolbar();
    }
}
